package kr.green.khl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.khl.vo.BoardVO;

public interface BoardDAO {

	void insertBoard(@Param("board")BoardVO board);
	
	//테스트
	List<BoardVO> getBoardList();
	BoardVO getContent(@Param("contentNum")String contentNum);
}
