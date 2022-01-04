package kr.green.khl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.khl.service.MemberService;
import kr.green.khl.vo.*;

@Controller
public class testController {
	
	@Autowired
	MemberService memberService;
	
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)	
	public ModelAndView joinGet(ModelAndView mv){		
		mv.setViewName("/member/join");
		return mv;
	}
	
	//테스트중인코드
	@RequestMapping(value = "/join", method = RequestMethod.POST)	
	public ModelAndView joinTest(ModelAndView mv, MemberVO member){
		System.out.println("가입정보 : "+ member);
		memberService.join(member);
		mv.setViewName("/main/home");
		return mv;
	}
}
