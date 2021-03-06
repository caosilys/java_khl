package kr.green.spring.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.pagination.PageMaker;
import kr.green.spring.service.CommantService;
import kr.green.spring.vo.*;

@RestController
@RequestMapping(value = "/commant")
public class CommantController {

	@Autowired
	CommantService commantService;
	
	@RequestMapping(value = "/list")
	public Map<String, Object> getList(Integer bd_num, Integer page){
		
		// 현재페이지 1, 페이지당 표시 댓글 5개
		Criteria cri = new Criteria(page, 5);
		
		int count = commantService.getTotalCount(bd_num);		
		
		PageMaker pm = new PageMaker(count, 3, cri);

		List<CommantVO> list = commantService.getList(bd_num, pm.getCriteria());
		if(list == null) return null;
		//db에서 읽어온 Date type의 값을 날짜형식으로 변경
		for(CommantVO temp : list) temp.setDate();
				
		Map <String, Object> map = new HashMap<String, Object>();		
		map.put("list", list);
		map.put("pm", pm);
		
		return map;		
	}
	
	@RequestMapping(value = "/insert")
	public String postInsert(@RequestBody CommantVO commant, HttpServletRequest request) {
		
		System.out.println(commant);
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");
		
		if(user == null) return "false";
		return commantService.setCommant(commant);
	}
	
	@RequestMapping(value = "/update")
	public String postUpdate(@RequestBody CommantVO commant, HttpServletRequest request) {
		
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");	
		if(user == null) return "false";
		
		return commantService.modifyCommant(user, commant);
	}
	
	@RequestMapping(value = "/delete")	
	public String getDelete(Integer co_num, HttpServletRequest request) {
		
		MemberVO user = (MemberVO) request.getSession().getAttribute("user");	
		if(user == null || co_num == null) return "false";
		
		
		return commantService.deleteCommant(user, co_num);
	}
	
	
}
