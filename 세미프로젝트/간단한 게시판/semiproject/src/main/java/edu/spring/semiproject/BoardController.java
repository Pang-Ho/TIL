package edu.spring.semiproject;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	@Autowired
	BoardService saleservice;
	@Autowired
	CommonService common;
	
	//판매게시판 화면 요청
	@RequestMapping("/board.sale")
	public ModelAndView list() {
		List<BoardVO> list = saleservice.board_list();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("/board/list");
		return mv;
	}
	
	//판매게시판 글 조회
	@RequestMapping(value = "/board.salemain", method = RequestMethod.GET)
	public ModelAndView main(String id) {
		BoardVO vo = saleservice.board_detail(id);
		
		/*int cnt = vo.getReadcnt();
		System.out.print(cnt);
		vo.setReadcnt(cnt + 1);
		saleservice.board_cnt(vo);*/
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", vo);
		mv.setViewName("/board/detail");
		return mv;
	}

	//신규 글 작성 화면 요청
	@RequestMapping("/new.sale")
	public String notice() {
		return "/board/new";
	}
	//신규 글 저장 처리 요청
	@RequestMapping(value ="/insert.sale", method = RequestMethod.POST)
	public String insert(MultipartFile file, BoardVO vo, HttpSession session) {
		if(!file.isEmpty()) {
			vo.setFilepath(common.upload("sale", file, session));
			vo.setFilename(file.getOriginalFilename());
		}
		vo.setWriter(((MarketVO)session.getAttribute("login_info")).getId());
		//화면에서 입력한 정보를 DB에 저장한 후
		saleservice.board_insert(vo);
		//목록 화면으로 연결
		return "redirect:board.sale";
	}
	//파일 다운로드
	@ResponseBody
	@RequestMapping("/download.bo")
	public void download(String id, HttpSession session, HttpServletResponse response) {
		//해당 글의 첨부 파일 정보를 조회해와 다운로드한다.
		BoardVO vo = saleservice.board_detail(id);
		common.download(vo.getFilename(), vo.getFilepath(), session, response);
	} //download()

	//기존 글 수정 화면 요청
	@RequestMapping(value = "/modify.sale", method=RequestMethod.GET)
	public ModelAndView modirq(String id) {
		BoardVO vo = saleservice.board_detail(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", vo);
		mv.setViewName("/board/modify");
		return mv;
	}
	//기존 글 수정 화면
	@RequestMapping(value = "/modify.sale", method=RequestMethod.POST)
	public String modify(String attach, MultipartFile file, HttpSession session, BoardVO vo, String id) {
		//기존 글의 첨부 파일 관련 정보를 조회
		BoardVO notice = saleservice.board_detail(id);
		String uuid = session.getServletContext().getRealPath("resources") + notice.getFilepath();
		
		//파일을 첨부한 경우 - 없었는데 첨부 / 있던 파일을 바꿔서 첨부
		if(!file.isEmpty()) {
			vo.setFilename(file.getOriginalFilename());
			vo.setFilepath(common.upload("sale", file, session));
			
			//원래 있던 첨부 파일은 서버에서 삭제
			if( notice.getFilename() != null ) {
				File f = new File(uuid);
				if ( f.exists() ) { f.delete(); }
			}
			
		} else {
			//원래 있던 첨부 파일을 삭제됐거나 원래부터 첨부 파일이 없었던 경우
			if(attach.isEmpty()) {
				//원래 있던 첨부 파일은 서버에서 삭제
				if( notice.getFilename() != null ) {
					File f = new File(uuid);
					if ( f.exists() ) { f.delete(); }
				}
				
			//원래 있던 첨부 파일을 그대로 사용하는 경우
			} else {
				vo.setFilename(notice.getFilename());
				vo.setFilepath(notice.getFilepath());
			}
			
		}
		
		//화면에서 변경한 정보를 DB에 저장한 후 상세 화면으로 연결
		saleservice.Board_update(vo);
		
		return "redirect:board.salemain?id=" + vo.getId();
	}
	//글 삭제 화면
	@RequestMapping(value = "/delete.sale", method=RequestMethod.GET)
	public String delete(String id) {
		saleservice.Board_delete(id);
		return "redirect:board.sale";
	}
}

