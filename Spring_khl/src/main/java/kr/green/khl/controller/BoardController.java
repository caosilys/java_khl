package kr.green.khl.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.khl.service.*;
import kr.green.khl.utils.*;
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
	public ModelAndView boardList(ModelAndView mv, PageMaker pm, Integer page, String search) {		
		
		// 페이지 메이커를 세팅 (서비스에서 전체 글 수를 가져옴)
		pm = boardService.setPageMaker(pm, page, search);
		List<BoardVO> List = boardService.getBoardList(pm);
			
		mv.addObject("pm", pm);
		mv.addObject("list", List);
		mv.setViewName("/board/list");
		return mv;
	}
	
	//게시글 등록 페이지 이동
	@RequestMapping(value="register", method=RequestMethod.GET)
	public ModelAndView boardRegisterGet(ModelAndView mv, Integer bd_ori_num) {
		mv.addObject("bd_ori_num", bd_ori_num);
		mv.setViewName("/board/register");
		return mv;
	}
	
	//게시글 등록
	@RequestMapping(value="register", method=RequestMethod.POST)
	public ModelAndView boardRegisterPost(ModelAndView mv, BoardVO board, HttpServletRequest request, List<MultipartFile> file) throws Exception {
				
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		board.setBd_me_id(user.getMe_id());
		board.setBd_type("일반");
		boardService.registerBoard(board);
		boardService.uploadFile(file, board.getBd_num());
		
		mv.setViewName("redirect:/board/list");
		return mv;
	}
	
	// 게시글 보기 
	@RequestMapping(value="/detail")
	public ModelAndView boardDetail(ModelAndView mv, Integer bd_num) {
				
		BoardVO board = boardService.getBoard(bd_num);
		List<FileVO> file = boardService.getFile(bd_num);
		
		mv.addObject("file", file);
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
		boardService.deleteFile(bd_num, null);
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
				List<FileVO> file = boardService.getFile(bd_num);
				mv.addObject("file", file);
				mv.addObject("board", board);	
				mv.setViewName("/board/modify");
			}
			return mv;
		}
		
		//게시글 수정 동작
		@RequestMapping(value="modify", method=RequestMethod.POST)
		public ModelAndView boardModifyPost(ModelAndView mv, BoardVO board, Integer[] fileNums, List<MultipartFile> file) throws Exception{
							
			boardService.updateBoard(board);						
			boardService.deleteFile(board.getBd_num(), fileNums);
			boardService.uploadFile(file, board.getBd_num());
			
			mv.addObject("bd_num", board.getBd_num());
			mv.setViewName("redirect:/board/detail");			
			return mv;			
		}
		
		//첨부파일 다운로드
				@RequestMapping(value="download") 
				public ResponseEntity<byte[]> downloadFile(String fileName)throws Exception{
					InputStream in = null;
				    ResponseEntity<byte[]> entity = null;
				    //집
				    String uploadPath = "C:\\Users\\caosi\\Desktop\\upload";

				    //학원
//				    String uploadPath = "C:\\Users\\green\\Desktop\\upload";
				    try{
				    	String FormatName = fileName.substring(fileName.lastIndexOf(".")+1);
					    HttpHeaders headers = new HttpHeaders();
				    	in = new FileInputStream(uploadPath+fileName);

						fileName = fileName.substring(fileName.indexOf("_")+1);
						headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
						headers.add("Content-Disposition",  "attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1")+"\"");
					entity = new ResponseEntity<byte[]>	(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
					}catch(Exception e) {
						e.printStackTrace();
						entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
					}finally {
						in.close();
					}
					return entity;
				}
}
