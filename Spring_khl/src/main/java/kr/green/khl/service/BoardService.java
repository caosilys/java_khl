package kr.green.khl.service;

import java.util.List;

import kr.green.khl.vo.BoardVO;
import kr.green.khl.vo.MemberVO;

public interface BoardService {

	void registerBoard(BoardVO board);

	List<BoardVO> getBoardList(String string);

	BoardVO getBoard(Integer bd_num);
	
	BoardVO getBoard(Integer bd_num, String me_id);

	void deleteBoard(Integer bd_num, MemberVO user);

	void updateBoard(BoardVO board);

	

}
