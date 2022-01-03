package kr.green.khl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.khl.vo.MemberVO;

@Controller
public class TestController {
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView testGet(ModelAndView mv, Integer num, String name) {
		
		mv.setViewName("test");
//		mv.addObject("serverTime", "데이타");
		System.out.println("/test ; num = " + num + ", name = " + name);
		return mv;
	}
	
	@RequestMapping(value = "/test2", method = RequestMethod.GET)	
	public ModelAndView test2Get(ModelAndView mv){
		
		mv.setViewName("test2");
		return mv;		
	}
	
	@RequestMapping(value = "/test2", method = RequestMethod.POST)	
	public ModelAndView test2PostSum(ModelAndView mv, Integer num1, Integer num2){
		mv.setViewName("test2");
		
		if(num1 == null && num2 == null) {
			mv.addObject("sum", "숫자를 입력해주세요");
		}
		else if(num2 == null) {
			mv.addObject("sum", num1);
		}
		else if(num1 == null) {
			mv.addObject("sum", num2);
		}
		else {
			mv.addObject("sum", num1+num2);
		}
		mv.addObject("num1", num1);
		mv.addObject("num2", num2);
		return mv;
	}
	
	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public ModelAndView test3Post(ModelAndView mv, MemberVO member ){
		
		System.out.println("/test3 : "+ member);
		
		mv.setViewName("test3");		
		return mv;
	}
}
