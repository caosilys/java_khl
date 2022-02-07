package kr.green.khl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.khl.service.AdminService;
import kr.green.khl.vo.MemberVO;

@Controller
public class AdminController {
		
	@Autowired
	AdminService adminService;
	
	@RequestMapping(value = "/memberlist", method = RequestMethod.GET)	
	public ModelAndView memberListGet(ModelAndView mv, HttpServletRequest request){		
		
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		
		if(user == null || !user.getMe_authority().equals("슈퍼관리자")) {
			mv.setViewName("redirect:/");
			return mv;
		}
		
		List<MemberVO> userList =	adminService.getList();
		mv.addObject("member", userList);
		mv.setViewName("/admin/memberlist");
		return mv;
	}
}
