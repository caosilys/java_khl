package kr.green.khl.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.khl.service.*;
import kr.green.khl.vo.*;

// 게시글 url을 담당하는 컨트롤러 /board/XXX 을 담당
@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	//일반적으로 get 방식을 사용함 
	@RequestMapping(value="list")
	public ModelAndView boardList(ModelAndView mv) {
		
		//테스트코드
		List<BoardVO> boardList = boardService.getBoardList();
		mv.addObject("boardList", boardList);
		//테스트코드
		
		mv.setViewName("/board/list");
		return mv;
	}
			
	@RequestMapping(value="register", method=RequestMethod.GET)
	public ModelAndView BoardRegisterGet(ModelAndView mv) {
		mv.setViewName("/board/register");
		return mv;
	}
	
	@RequestMapping(value="register", method=RequestMethod.POST)
	public ModelAndView BoardRegisterPost(ModelAndView mv, BoardVO board, HttpServletRequest request) {
		
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		board.setBd_me_id(user.getMe_id());
		board.setBd_type("일반");
		boardService.registerBoard(board);		
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
	//테스트코드
	@RequestMapping(value="list/*")
	public ModelAndView viewContent(ModelAndView mv, HttpServletRequest request) {
		
		String uri = request.getRequestURI();
		String contentNum = uri.substring(uri.lastIndexOf("/")+1);	
		BoardVO	content = boardService.getContent(contentNum);
		
		mv.addObject("content", content);
		
		mv.setViewName("/board/content");
		return mv;
	}
		
}
