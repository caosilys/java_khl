package kr.green.khl.controller;

import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.green.khl.service.CommantService;
import kr.green.khl.utils.PageMaker;
import kr.green.khl.vo.CommantVO;
import kr.green.khl.vo.MemberVO;

//RestController -> Ajax용 컨트롤러
@RestController
public class CommantController {
	
	@Autowired
	CommantService commantService;
	
	@RequestMapping(value="/commant/insert")
	public String commantInsert(@RequestBody CommantVO commant, HttpServletRequest request) {
		MemberVO user =  (MemberVO) request.getSession().getAttribute("user");
		
		System.out.println(commant);
		
		if(commantService.insertCommant(commant, user)) return "true";
		return "false: ";
	}
	
	@RequestMapping(value="/commant/list")
	public Map<String, Object> commantList(Integer co_bd_num, Integer page) {
		
		int totalCount = commantService.selectTotalCount(co_bd_num);

		PageMaker pm = new PageMaker();
		pm.setCount(totalCount);
		pm.setPage(page);
		List<CommantVO> list = commantService.selectCommantList(co_bd_num, pm);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pm", pm);
		map.put("list", list);
		return map;
	}
	
	@RequestMapping(value="/commant/modify")
	public String commantModify(@RequestBody CommantVO commant, HttpServletRequest request) {
		
		MemberVO user =  (MemberVO) request.getSession().getAttribute("user");	
		System.out.println(user);
		System.out.println(commant);
		return commantService.updateCommant(user, commant);
	}
	
	@RequestMapping(value="/commant/delete")
	public String commantDelete(Integer co_num, HttpServletRequest request) {
		MemberVO user =  (MemberVO) request.getSession().getAttribute("user");		
		return commantService.deleteCommant(user, co_num);
	}
	
}
