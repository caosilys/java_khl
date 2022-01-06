package kr.green.khl.service;

import java.util.List;

import kr.green.khl.vo.BoardVO;

public interface BoardService {

	void registerBoard(BoardVO board);

	List<BoardVO> getBoardList();

	//테스트중인 코드
	BoardVO getContent(String contentNum);

}
