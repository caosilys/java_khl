package kr.green.spring.controller;


import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.pagination.PageMaker;
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
		
		System.out.println(member);
		MemberVO user = memberService.login(member);
					
		if(user == null) {
			mv.setViewName("redirect:/login");
		}
		else {
			user.setMe_auto_login(member.getMe_auto_login());
			mv.addObject("user", user);
			mv.setViewName("redirect:/");
		}
		return mv;
	}
	
	@RequestMapping(value = "/logout")
	public ModelAndView logOutPost(ModelAndView mv, HttpServletRequest request, HttpServletResponse response){
		
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
	
	@RequestMapping(value = "/admin/modify")
	public ModelAndView setMemberAut(ModelAndView mv, HttpServletRequest request, Integer page){
			
			MemberVO user = (MemberVO)request.getSession().getAttribute("user");
			
			if(user == null || !user.getMe_authority().equals("슈퍼관리자")) {
				mv.setViewName("redirect:/");
				return mv;
			}
			
			if(page == null) page = 1;
			Criteria cri = new Criteria(page, 4);			
			Integer totalCount = memberService.getMemberCount();
			PageMaker pm = new PageMaker(totalCount, 5, cri);
			
			List<MemberVO> list = memberService.getMemberList(pm);
			
			mv.addObject("pm", pm);
			mv.addObject("list", list);
			mv.setViewName("/member/memberlist");
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
		
		return getFindPw;
	}
	
	@ResponseBody
	@RequestMapping(value ="/admin/authority") 
	public String modMemberAut(@RequestBody MemberVO member, HttpServletRequest request) {
		
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		return memberService.changeAutority(member, user);
	}
	
	
	
	
}
