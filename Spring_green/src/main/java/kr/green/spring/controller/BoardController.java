package kr.green.spring.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.BoardService;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.FileVO;
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
		// 게시글 번호와 일치하는 첨부파일을 가져옴
		List<FileVO> fileList = boardService.getFileList(bd_num);
		
		if(board == null) {
			System.out.println("잘못된 접근입니다");
			mv.setViewName("redirect:/board/list");
		}
		else {
			mv.addObject("fileList", fileList);
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
	public ModelAndView registerPost(ModelAndView mv, BoardVO board, HttpServletRequest request, List<MultipartFile> files) {		

		MemberVO user = (MemberVO)request.getSession().getAttribute("user");		
		board.setBd_me_id(user.getMe_id());	
		boardService.registerPost(board, files);		
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
			List<FileVO> files = boardService.getFileList(bd_num);
			
			mv.addObject("fileList", files);
			mv.addObject("board", board);	
			mv.setViewName("/board/modify");
		}
		return mv;
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ModelAndView modifyPost(ModelAndView mv, BoardVO board, HttpServletRequest request, List<MultipartFile> files, Integer[] fileNums) {
		// modify 페이지에서 board 넘겨받음
		String userID = ((MemberVO)request.getSession().getAttribute("user")).getMe_id();
		boardService.modifyPost(board, userID, files, fileNums);

		mv.addObject("bd_num", board.getBd_num());
		mv.setViewName("redirect:/board/detail");
//		mv.setViewName("redirect:/board/detail?bd_num="+board.getBd_num());
		return mv;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteGet(ModelAndView mv, Integer bd_num, HttpServletRequest request) {
		
		String userID = ((MemberVO)request.getSession().getAttribute("user")).getMe_id();
		boardService.deleteGet(bd_num, userID);
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/download")
	public ResponseEntity<byte[]> downloadFile(String fileName)throws Exception{
		//집
//		String uploadPath = "C:\\Users\\green\\Desktop\\upload";
		//학원
		String uploadPath = "C:\\Users\\green\\Desktop\\upload";
		InputStream in = null;
	    ResponseEntity<byte[]> entity = null;
	    try{
	        String FormatName = fileName.substring(fileName.lastIndexOf(".")+1);
	        HttpHeaders headers = new HttpHeaders();
	        in = new FileInputStream(uploadPath+fileName);

	        fileName = fileName.substring(fileName.indexOf("_")+1);
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        headers.add("Content-Disposition",  "attachment; filename=\"" 
				+ new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
	        entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
	    }catch(Exception e) {
	        e.printStackTrace();
	        entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
	    }finally {
	        in.close();
	    }
	    return entity;
	}
	
	
}

