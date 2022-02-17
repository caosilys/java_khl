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
	CommantService service;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView testGet(ModelAndView mv, Integer num) {		
		
		if(num != null) {
			System.out.println("num = " + num);
			TestVO tv= service.getTest(num);
		}
		mv.setViewName("/main/test");
		return mv;
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public ModelAndView testPost(ModelAndView mv, TestVO tv) {		
		
		System.out.println(tv);
		service.setTest(tv);
		
		mv.setViewName("/main/home");
		return mv;
	}

	
}
