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
	
	
}
