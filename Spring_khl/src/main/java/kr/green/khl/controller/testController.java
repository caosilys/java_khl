package kr.green.khl.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.khl.dao.*;
import kr.green.khl.service.*;
import kr.green.khl.vo.*;

@Controller
public class testController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/memberlist", method = RequestMethod.GET)	
	public ModelAndView memberListGet(ModelAndView mv){		
		
		List<MemberVO> userList =	memberService.getList();
		mv.addObject("member", userList);
		mv.setViewName("/test/memberlist");
		return mv;
	}
	
	
//	@RequestMapping(value = "/memberlist", method = RequestMethod.POST)	
//	public ModelAndView memberListPost(ModelAndView mv){		
//		
//		List<MemberVO> userList =	memberService.getList();
//		mv.addObject("member", userList);
//		mv.setViewName("/test/memberlist");
//		return mv;
//	}
	
	
}
