package kr.green.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.BoardService;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.MemberVO;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/list")
	public ModelAndView listGet(ModelAndView mv) {
		
		List<BoardVO> list = boardService.listGet("일반");
		mv.addObject("list", list);
		mv.setViewName("/board/list");
		return mv;
	}
	
	@RequestMapping(value = "/detail")
	public ModelAndView detailGet(ModelAndView mv, Integer bd_num) {
		
		BoardVO board = boardService.detailGet(bd_num);
		if(board == null) {
			System.out.println("잘못된 접근입니다");
			mv.setViewName("redirect:/board/list");
		}
		else {
			mv.addObject("board", board);
			mv.setViewName("/board/detail");
		}		
		return mv;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerGet(ModelAndView mv) {		
		mv.setViewName("/board/register");
		return mv;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerPost(ModelAndView mv, BoardVO board, HttpServletRequest request) {		

		MemberVO user = (MemberVO)request.getSession().getAttribute("user");		
		board.setBd_me_id(user.getMe_id());	
		boardService.registerPost(board);
				
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public ModelAndView modifyGet(ModelAndView mv, Integer bd_num, HttpServletRequest request) {
		
		//detail 페이지에서 bd_num만 넘겨줌
		BoardVO board = boardService.detailGet(bd_num);
		String userID = ((MemberVO)request.getSession().getAttribute("user")).getMe_id();
		
		// 게시글 작성자와 로그인한 user정보 비교해서 페이지 전환
		if(!userID.equals(board.getBd_me_id())) {
			System.out.println("modify 페이지는 작성자만 방문가능합니다");
			mv.setViewName("redirect:/board/list");
		}
		else
		{				
			mv.addObject("board", board);	
			mv.setViewName("/board/modify");
		}
		return mv;
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ModelAndView modifyPost(ModelAndView mv, BoardVO board, HttpServletRequest request) {
		// modify 페이지에서 board 넘겨받음
		String userID = ((MemberVO)request.getSession().getAttribute("user")).getMe_id();
		boardService.modifyPost(board, userID);		
		mv.setViewName("redirect:/board/detail?bd_num="+board.getBd_num());
		return mv;
	}
	
	
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteGet(ModelAndView mv, Integer bd_num, HttpServletRequest request) {
		
		String userID = ((MemberVO)request.getSession().getAttribute("user")).getMe_id();
		boardService.deleteGet(bd_num, userID);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
}

