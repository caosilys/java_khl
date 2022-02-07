package kr.green.khl.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

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

		mv.setViewName("/main/home");
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
			mv.setViewName("redirect:/login");
		}
		else {
			user.setMe_auto_login(member.getMe_auto_login());
			mv.addObject("user",user);
			mv.setViewName("redirect:/");
		}
		return mv;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logoutGet(ModelAndView mv, HttpServletRequest request, HttpServletResponse response) {
		
		
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		
		if(user != null) {
			
			request.getSession().removeAttribute("user");
			
			Cookie cookie = WebUtils.getCookie(request, "loginCookie");
			if(cookie != null) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				//자동 로그인 해제를 위해 세션 아이디에 none을 저장하고, 만료 시간을 현재시간으로 설정
				user.setMe_session_id("none");
				user.setMe_session_limit(new Date());
				memberService.updateAutologin(user);
			}
		
		}
		
		
		
		
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
	
	@ResponseBody
	@RequestMapping(value = "/checkId")	
	public String checkId(String id){		
				
		return memberService.checkId(id);
	}
	

	@RequestMapping(value = "/mypage")	
	public ModelAndView myPageGet(ModelAndView mv, MemberVO input, HttpServletRequest request){
		
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		
		if(user == null) {
			mv.setViewName("/test/home");
			System.out.println("세션이 만료되어 로그아웃되었습니다.");
			return mv;
		}
		MemberVO new_user = memberService.updateMember(input, user);	
		
		mv.addObject("user", new_user);
		mv.setViewName("/member/mypage");
			
		return mv;
	}
	
	@RequestMapping(value = "/member/find")	
	public ModelAndView memberFind(ModelAndView mv){
		
		mv.setViewName("/member/find");			
		return mv;
	}
	
	@ResponseBody
	@RequestMapping(value = "/member/find/Id")
	public String memberFindId(@RequestBody MemberVO member){
		
		String findMemberId = memberService.findMemberId(member);
		System.out.println(findMemberId);	
		
		return findMemberId;
	}
	
	@ResponseBody
	@RequestMapping(value = "/member/find/pw")
	public String memberFindPw(@RequestBody MemberVO member){
				
		String findMemberPw = memberService.findMemberPw(member);
		
		return findMemberPw;
	}
	
	// 이거 작업 해야됨
	@ResponseBody
	@RequestMapping(value = "/admin/upAut")
	public String updateAuthority(@RequestBody MemberVO member){
				
		System.out.println(member);
		
		return "true";
	}
	
	
}
