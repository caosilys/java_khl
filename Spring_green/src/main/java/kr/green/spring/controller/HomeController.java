package kr.green.spring.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.*;
import kr.green.spring.vo.MemberVO;


@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;

	
	@RequestMapping(value = "/")
	public ModelAndView homeGet(ModelAndView mv) {		
		mv.setViewName("/main/home");
		return mv;
	}
	
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv) {	
		mv.setViewName("/member/signup");
		return mv;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv, MemberVO member) {
		
		memberService.signUpMember(member);
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginGet(ModelAndView mv) {		
		mv.setViewName("/member/login");
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv, MemberVO member) {
		
		MemberVO user = memberService.login(member);
		
		if(user == null) {
			mv.setViewName("redirect:/login");
		}
		else {
			mv.addObject("user", user);
			mv.setViewName("redirect:/");
		}
		return mv;
	}
	
	@RequestMapping(value = "/logout")
	public ModelAndView logOutPost(ModelAndView mv, HttpServletRequest request){
		
			request.getSession().setAttribute("user", null);
			mv.setViewName("redirect:/");
			return mv;
	}
	
	@RequestMapping(value = "/mypage")
	public ModelAndView getMypage(ModelAndView mv, MemberVO member, HttpServletRequest request){
			
			mv.setViewName("/member/mypage");
			return mv;
	}
	
	@RequestMapping(value = "/member/modify")
	public ModelAndView postMemberModify (ModelAndView mv, MemberVO member, HttpServletRequest request){
			
			MemberVO user = (MemberVO)request.getSession().getAttribute("user");
			MemberVO newUser = memberService.modifyMember(user, member);
			
			request.getSession().setAttribute("user", newUser);	
			mv.setViewName("redirect:/mypage");
			return mv;
	}
	
	@RequestMapping(value = "/find")
	public ModelAndView getFind(ModelAndView mv){
			
			mv.setViewName("/member/find");
			return mv;
	}
	
	
	@ResponseBody //view를 거치지않고 직접 전달
	@RequestMapping(value ="/idcheck") 
	public String ajaxIdcheck(String id) {
		if(memberService.idDuplicated(id)) return "false"; //중복이다 => 사용불가
		return "true"; // 중복이 아니다 => 사용가능
	}
	
	@ResponseBody
	@RequestMapping(value ="/find/findId") 
	public String findId(@RequestBody MemberVO member) {
		
		String getFindId = memberService.findId(member);
		System.out.println(getFindId);
		return getFindId;
	}
	
	@ResponseBody
	@RequestMapping(value ="/find/findPw") 
	public String findPw(@RequestBody MemberVO member) {
		
		String getFindPw = memberService.findPw(member);
		
		
		return "true";
	}
	
	
	
	
}
