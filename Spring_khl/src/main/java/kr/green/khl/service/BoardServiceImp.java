package kr.green.khl.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.green.khl.dao.*;
import kr.green.khl.utils.UploadFileUtils;
import kr.green.khl.vo.BoardVO;
import kr.green.khl.vo.FileVO;
import kr.green.khl.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService{
	
	@Autowired
	BoardDAO boardDao;
	
	//업로드할 폴더 경로. 환경에 따라 바꿔줘야함
	String uploadPath="C:\\Users\\caosi\\Desktop\\upload";
//	String uploadPath="C:\\Users\\caosi\\Desktop\\upload";
	@Override
	public void registerBoard(BoardVO board, MultipartFile file) throws Exception {
		if(	board == null ||
			board.getBd_title() == null ||
			board.getBd_content() == null ||
			board.getBd_me_id() == null) return;
			
			
			boardDao.insertBoard(board);
			
//			UploadFileUtils.uploadFile(업로드경로, 파일명, 파일데이터);
			if(file == null) return;
			//서버에 업로드
			String path = UploadFileUtils.uploadFile(uploadPath, file.getName(), file.getBytes());
			
			//db에 저장
			FileVO  fileVo = 
					new FileVO(file.getOriginalFilename(), path, board.getBd_num());			
			System.out.println(fileVo);
			boardDao.insertFile(fileVo);
	}
	
	@Override
	public List<BoardVO> getBoardList(String type) {
		
		return boardDao.getBoardList(type);
	}
	
	@Override
	public BoardVO getBoard(Integer bd_num) {
		//게시글 번호가 없거나 0이하이면 예외처리
		if(bd_num == null || bd_num <= 0) return null;

		return boardDao.getBoard(bd_num);
		
	}
	
	@Override
	public BoardVO getBoard(Integer bd_num, String me_id) {
		if(bd_num == null || bd_num <= 0) return null;
		
		BoardVO board = boardDao.getBoard(bd_num);
		if(board ==null || !board.getBd_me_id().equals(me_id)) return null;
		
		return board;
		
	}

	@Override
	public void deleteBoard(Integer bd_num, MemberVO user) {
		
		// 예외처리 코드
		//유효하지 않은 게시글 번호이면 삭제할 필요없음
		if(bd_num == null || bd_num <= 0) return;
		//유효한 게시물이면 게시글 번호와 일치하는 게시글을 가져옴
		BoardVO board =  boardDao.getBoard(bd_num);
		//가져온 게시글이 null이면 삭제할 필요가 없음
		if(board == null) return;
		//게시글 작성자와 로그인한 회원 아이디가 같은지 확인하여 다르면 삭제할 필요 없음
		if(!board.getBd_me_id().equals(user.getMe_id())) return;
		// 게시글 삭제
		boardDao.deleteBoard(bd_num);
		
		/* 해당방법으로도 가능
		board.setBd_del("Y");
		board.setBd_del_date();
		boardDao.update(board);
		*/		
		return;
		
	}

	@Override
	public void updateBoard(BoardVO board) {
				
		boardDao.updateBoard(board);
	}

	@Override
	public FileVO getFile(Integer bd_num) {
		if(bd_num == null || bd_num <= 0) return null;
		return boardDao.getFile(bd_num);
	}




}
