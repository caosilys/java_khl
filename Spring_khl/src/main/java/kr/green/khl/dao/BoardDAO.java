package kr.green.khl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.khl.vo.BoardVO;

public interface BoardDAO {

	void insertBoard(@Param("board")BoardVO board);
	
	List<BoardVO> getBoardList(@Param("type")String type);
	
	BoardVO getBoard(@Param("bd_num")Integer bd_num);

	void deleteBoard(@Param("bd_num")Integer bd_num);

	void updateBoard(@Param("board")BoardVO board);
}
