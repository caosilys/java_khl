package kr.green.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.FileVO;

public interface BoardDAO {

	List<BoardVO> listGet(@Param("cri")Criteria cri);

	BoardVO detailGet(@Param("bd_num")Integer bd_num);

	void registerPost(@Param("board")BoardVO board);

	void deleteGet(@Param("bd_num")Integer bd_num);

	void modifyPost(@Param("board")BoardVO board);

	void insertFile(@Param("file")FileVO file);

	List<FileVO> getFileList(@Param("bd_num")Integer bd_num);

	void deleteFile(@Param("fi_num")int fi_num);

	int getTotalCount(@Param("cri")Criteria cri);

	void updateViews(@Param("bd_num")Integer bd_num);

}
