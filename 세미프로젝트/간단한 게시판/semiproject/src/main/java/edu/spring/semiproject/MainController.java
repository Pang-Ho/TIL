package edu.spring.semiproject;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@Autowired
	MarketService service;
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String login() {
		return "main/main";
	}
	
	//로그인
	@RequestMapping(value = "/login", method= RequestMethod.POST)
	@ResponseBody
	public String login(String id, String pw, HttpSession session) {
		//아이디 비밀번호 일치하는지 db확인
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("id", id);
		map.put("pw", pw);
		MarketVO vo = service.user_login(map);
		
		//일치하는 회원 정보가 있다면 세션에 담기
		session.setAttribute("login_info", vo);
		
		if(vo == null) {
			return "false";
		}
		else {
			return "true";
		}
	}
	//로그아웃
	@RequestMapping("/logout")
	@ResponseBody 
	public void logout(HttpSession session) {
		session.removeAttribute("login_info");
	}

}
