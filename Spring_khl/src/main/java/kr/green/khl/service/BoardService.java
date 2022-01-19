package kr.green.khl.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.green.khl.vo.BoardVO;
import kr.green.khl.vo.FileVO;
import kr.green.khl.vo.MemberVO;

public interface BoardService {
	
	// board 정보를 넘겨받아 insert board 쿼리 호출
	void registerBoard(BoardVO board);
	// type (공지, 일반) 정보를 넘겨받아 select * board 호출 -> board 정보들을 가져옴
	List<BoardVO> getBoardList(String type);
	
	BoardVO getBoard(Integer bd_num);
	
	BoardVO getBoard(Integer bd_num, String me_id);

	void deleteBoard(Integer bd_num, MemberVO user);

	void updateBoard(BoardVO board);

	List<FileVO> getFile(Integer bd_num);

	void uploadFile(List<MultipartFile> file, int bd_num) throws Exception;
	
	void deleteFile(int bd_num, Integer[] fileNums);

	

}
