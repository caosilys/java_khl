package kr.green.khl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.khl.dao.*;
import kr.green.khl.vo.BoardVO;

@Service
public class BoardServiceImp implements BoardService{
	
	@Autowired
	BoardDAO boardDao;

	@Override
	public void registerBoard(BoardVO board) {
		if(	board == null ||
			board.getBd_title() == null ||
			board.getBd_content() == null ||
			board.getBd_me_id() == null)
		{
			System.out.println("boardServiceImp 작업실패 "); return;
		}
			
			System.out.println(board);
			boardDao.insertBoard(board);
			
	}

	@Override
	public List<BoardVO> getBoardList() {
		return boardDao.getBoardList();
	}
	
	//테스트중인 코드
	@Override
	public BoardVO getContent(String contentNum) {
		
		return boardDao.getContent(contentNum);
	}
}
