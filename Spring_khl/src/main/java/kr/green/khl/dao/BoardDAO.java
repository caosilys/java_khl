package kr.green.khl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.khl.utils.PageMaker;
import kr.green.khl.vo.*;

public interface BoardDAO {

	void insertBoard(@Param("board")BoardVO board);
	
	List<BoardVO> getBoardList(@Param("pm")PageMaker pm);
	
	BoardVO getBoard(@Param("bd_num")Integer bd_num);

	void deleteBoard(@Param("bd_num")Integer bd_num);

	void updateBoard(@Param("board")BoardVO board);

	void insertFile(@Param("file")FileVO fileVo);

	List<FileVO> getFile(@Param("bd_num")Integer bd_num);

	void deleteFile(@Param("fi_num")int fi_num);

	int getBoardCount(@Param("pm")PageMaker pm);
}
