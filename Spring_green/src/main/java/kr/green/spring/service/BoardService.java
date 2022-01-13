package kr.green.spring.service;

import java.util.List;

import kr.green.spring.vo.BoardVO;

public interface BoardService {

	List<BoardVO> listGet(String bd_type);

	BoardVO detailGet(Integer bd_num);

	void registerPost(BoardVO board);

	void deleteGet(Integer bd_num, String userID);

	void modifyPost(BoardVO board, String userID);
}
