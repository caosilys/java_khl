package kr.green.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.BoardDAO;
import kr.green.spring.vo.BoardVO;

@Service
public class BoardServiceImp implements BoardService{

	@Autowired
	BoardDAO boardDao;
	
	@Override
	public List<BoardVO> listGet(String bd_type) {
		 
		return boardDao.listGet(bd_type);
	}

	@Override
	public BoardVO detailGet(Integer bd_num) {
		
		return boardDao.detailGet(bd_num);
	}

}
