package kr.green.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.CommantDAO;
import kr.green.spring.pagination.Criteria;
import kr.green.spring.pagination.PageMaker;
import kr.green.spring.vo.CommantVO;

@Service
public class CommantServieImp implements CommantService{
	
	@Autowired
	CommantDAO commantDao;

	@Override
	public List<CommantVO> getList(Integer bd_num, Criteria cri) {
		if(bd_num <= 0 || bd_num ==null || cri == null || cri.getPerPageNum() <= 0) return null;			
						
		return commantDao.getList(bd_num, cri);
	}

	@Override
	public int getTotalCount(Integer bd_num) {
		if(bd_num <= 0) return 0;
		
		return commantDao.getTotalCount(bd_num);
	}
}
