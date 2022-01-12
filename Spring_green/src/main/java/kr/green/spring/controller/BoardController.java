package kr.green.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.BoardService;
import kr.green.spring.vo.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/board/list")
	public ModelAndView listGet(ModelAndView mv) {
		
		List<BoardVO> list = boardService.listGet("일반");
		mv.addObject("list", list);
		mv.setViewName("/board/list");
		return mv;
	}
	
	@RequestMapping(value = "/board/detail")
	public ModelAndView detailGet(ModelAndView mv, Integer bd_num) {
		
		BoardVO board = boardService.detailGet(bd_num);
		mv.addObject("board", board);
		mv.setViewName("/board/detail");
		return mv;
	}
}
