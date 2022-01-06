package kr.green.khl.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.khl.service.MemberService;
import kr.green.khl.vo.*;

//@controller가 있어야 url을 분석하여 처리
@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	// url을 확인하는 곳. 필수
	// value는 localhost:8080/패키지면을 제외한 부분
	// method는 전달 방식, get / post 생략하면 둘다
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView homeget(ModelAndView mv) {		
		/*
		 * 화면 파일명 확장자는 여기서 선택하는게 아님
		 * 확장자는 servlet-context.xml 에서 설정
		 * 단, views 폴더에는 jsp만 가능
		 * html을 화면으로 쓰려면 src/main/resources 폴더에 넣어야함
		 * */	
		mv.setViewName("/main/home");
//		화면으로 데이터를 보낼때 addObject를 사용
//		addObject("화면에서 사용할 이름", 데이터);
//		mv.addObject("serverTime", "데이타");	
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginGet(ModelAndView mv) {
		mv.setViewName("/member/login");
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv, MemberVO member) {
		
		MemberVO user = 	memberService.login(member);
		if(user == null) {
			System.out.println("로그인 실패");
			mv.setViewName("redirect:/login");
		}
		else {
			System.out.println("로그인 성공");
			mv.addObject("user",user);
			mv.setViewName("redirect:/");
		}
		return mv;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logoutGet(ModelAndView mv, HttpServletRequest request) {
		request.getSession().removeAttribute("user") ;
		System.out.println("로그아웃");
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)	
	public ModelAndView signupGet(ModelAndView mv){		
		mv.setViewName("/member/signup");
		return mv;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)	
	public ModelAndView signupPost(ModelAndView mv, MemberVO member){
	
		if(memberService.signup(member)) {
			System.out.println("가입성공");
			mv.setViewName("redirect:/");
		}
		else {
			System.out.println("가입실패");
			mv.setViewName("redirect:/signup");
		}		
		return mv;
	}
	// redirect / forward
}
