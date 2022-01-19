package kr.green.spring.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.FileVO;

public interface BoardService {

	List<BoardVO> listGet(Criteria cri);

	BoardVO detailGet(Integer bd_num);

	void registerPost(BoardVO board, List<MultipartFile> files);

	void deleteGet(Integer bd_num, String userID);

	void modifyPost(BoardVO board, String userID, List<MultipartFile> files, Integer[] fileNums);

	List<FileVO> getFileList(Integer bd_num);

	int getTotalCount(Criteria cri);

	void updateViews(Integer bd_num);
}
