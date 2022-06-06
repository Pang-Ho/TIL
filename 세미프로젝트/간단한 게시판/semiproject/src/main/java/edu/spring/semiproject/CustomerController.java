package edu.spring.semiproject;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
	
	@Autowired
	MarketService service;
	
	//회원가입 페이지
	@RequestMapping("/join")
	public String join() {
		
		return "main/join";
	}
	//회원가입 요청
	@RequestMapping(value = "/joinRequest", method=RequestMethod.POST)
	public ModelAndView join(String id, String pw, String name, String mail) {
		MarketVO vo = new MarketVO(id, pw, name, mail);
		service.user_insert(vo);
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", vo);
		mv.setViewName("/main/info");
		return mv;
	}
	
	//유저 정보
	@RequestMapping("/detail.cu")
	public ModelAndView detail(HttpSession session) {
		if(session.getAttribute("login_info")==null) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/main/notice");
			return mv;
		}
		else {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/main/detail");
			return mv;
		}

	}
	
	//유저 정보 수정 화면 요청
	@RequestMapping("/modify.cu")
	public ModelAndView modirq(String id) {
		MarketVO vo = service.user_detail(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", vo);
		mv.setViewName("/main/modify");
		return mv;
	}
	//유저 정보 수정 화면
	@RequestMapping(value = "/modify.cu", method=RequestMethod.POST)
	public ModelAndView modify(String id, String pw, String name, String mail) {
		
		MarketVO vo = new MarketVO(id, pw, name, mail); 
		service.user_update(vo);
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", vo);
		mv.setViewName("/main/modifyinfo");
		return mv;
	}
	//유저 탈퇴 화면 요청
	@RequestMapping("/delete.cu")
	public String deletrq() {
		return "/main/delete";
	}
	
	//유저 탈퇴 화면
	@RequestMapping(value = "/delete.cu", method=RequestMethod.POST)
	public ModelAndView delete(String id, String pw, HttpSession session) {
		session.removeAttribute("login_info");
		MarketVO vo = new MarketVO(id, pw);
		service.user_delete(vo);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/main/deleteinfo");
		
		return mv;
	}
	
}
