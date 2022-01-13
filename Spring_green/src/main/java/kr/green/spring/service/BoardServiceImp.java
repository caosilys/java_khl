package kr.green.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.BoardDAO;
import kr.green.spring.vo.BoardVO;

@Service
public class BoardServiceImp implements BoardService{

	@Autowired
	BoardDAO boardDao;
	
	@Override
	public List<BoardVO> listGet(String bd_type) {
		 
		return boardDao.listGet(bd_type);
	}

	@Override
	public BoardVO detailGet(Integer bd_num) {
		
		return boardDao.detailGet(bd_num);
	}

	@Override
	public void registerPost(BoardVO board) {
		
		//기타 예외처리
		boardDao.registerPost(board);
	}
	
	@Override
	public void modifyPost(BoardVO board, String userID) {
		
		if(!userID.equals(board.getBd_me_id())) return;
		
		// 기타예외처리
		boardDao.modifyPost(board);		
	}
	
	@Override
	public void deleteGet(Integer bd_num, String userID) {
		String board_id = boardDao.detailGet(bd_num).getBd_me_id();		
		if(!board_id.equals(userID)) return;
		
		//기타 예외처리
		
		boardDao.deleteGet(bd_num);
	}



}
