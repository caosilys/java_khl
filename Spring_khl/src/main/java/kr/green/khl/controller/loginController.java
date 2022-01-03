package kr.green.khl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.khl.vo.*;

@Controller
public class loginController {
	
	@RequestMapping(value = "/login2", method = RequestMethod.GET)	
	public ModelAndView loginTest(ModelAndView mv){	
		mv.setViewName("login2");
		return mv;		
	}
	
	@RequestMapping(value = "/login2", method = RequestMethod.POST)	
	public ModelAndView loginTest(ModelAndView mv, MemberVO2 member){
		mv.setViewName("login2");
		
		System.out.println("로그인 정보 : "+ member);
		return mv;
	}
}
