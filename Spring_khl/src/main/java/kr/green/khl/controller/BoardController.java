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
	// 게시글 목록 보기
	@RequestMapping(value="list")
	public ModelAndView boardList(ModelAndView mv) {
		
		List<BoardVO> List = boardService.getBoardList("일반");
		mv.addObject("list", List);
		mv.setViewName("/board/list");
		return mv;
	}
	
	//게시글 등록 페이지 이동
	@RequestMapping(value="register", method=RequestMethod.GET)
	public ModelAndView boardRegisterGet(ModelAndView mv) {
		mv.setViewName("/board/register");
		return mv;
	}
	
	//게시글 등록
	@RequestMapping(value="register", method=RequestMethod.POST)
	public ModelAndView boardRegisterPost(ModelAndView mv, BoardVO board, HttpServletRequest request) {
		
		
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		board.setBd_me_id(user.getMe_id());
		board.setBd_type("일반");
		boardService.registerBoard(board);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
	// 게시글 보기 
	@RequestMapping(value="/detail")
	public ModelAndView boardDetail(ModelAndView mv, Integer bd_num) {
				
		BoardVO board = boardService.getBoard(bd_num);	
		mv.addObject("board", board);		
		mv.setViewName("/board/detail");
		return mv;
	}
	
	//게시글 삭제
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public ModelAndView boardDelete(ModelAndView mv, Integer bd_num, HttpServletRequest request) {

		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		//서비스에게 게시글정보, 로그인한 유저정보를 주면서 게시글 삭제
		boardService.deleteBoard(bd_num, user);		
		mv.setViewName("redirect:/board/list");
		return mv;
	}	
	
	
	//게시글 수정 페이지로 이동 
		@RequestMapping(value="modify", method=RequestMethod.GET)
		public ModelAndView boardmodifyGet(ModelAndView mv, Integer bd_num, HttpServletRequest request) {
			
			// 수정페이지를 띄워주는 부분
			//수정페이지가 정상적으로 떠도 되는지 확인 하기위해 id정보 넘겨줌
			MemberVO user = (MemberVO)request.getSession().getAttribute("user");	
			BoardVO board = boardService.getBoard(bd_num, user.getMe_id());
			if(board == null) {
				System.out.println("잘못된 접근");
				mv.setViewName("redirect:/board/list");
			}
			else {
				mv.addObject("board", board);	
				mv.setViewName("/board/modify");
			}
			return mv;
		}
		
		//게시글 수정 동작
		@RequestMapping(value="modify", method=RequestMethod.POST)
		public ModelAndView boardModifyPost(ModelAndView mv, BoardVO board) {
							
			boardService.updateBoard(board);
			
			mv.addObject("bd_num", board.getBd_num());
			mv.setViewName("redirect:/board/detail");			
			return mv;			
		}
		

}
