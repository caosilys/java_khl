package kr.green.khl.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.green.khl.vo.BoardVO;
import kr.green.khl.vo.FileVO;
import kr.green.khl.vo.MemberVO;

public interface BoardService {

	void registerBoard(BoardVO board, MultipartFile file) throws Exception;

	List<BoardVO> getBoardList(String string);

	BoardVO getBoard(Integer bd_num);
	
	BoardVO getBoard(Integer bd_num, String me_id);

	void deleteBoard(Integer bd_num, MemberVO user);

	void updateBoard(BoardVO board);

	FileVO getFile(Integer bd_num);

	

}
