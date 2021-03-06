package kr.green.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.CommantDAO;
import kr.green.spring.pagination.Criteria;
import kr.green.spring.vo.CommantVO;
import kr.green.spring.vo.MemberVO;

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

	@Override
	public String setCommant(CommantVO commant) {
		if(commant.getCo_content().equals("")) return "false";
		commantDao.setCommant(commant);
		return "true";
	}

	@Override
	public String modifyCommant(MemberVO user, CommantVO commant) {
		if(user == null || commant == null) return "false";
		if(!commantDao.getOriUser(commant.getCo_num()).equals(user.getMe_id())) return "false";
		
		commantDao.modifyCommant(commant);
		 
		 return "true";
	}

	@Override
	public String deleteCommant(MemberVO user, Integer co_num) {
		if(user == null || co_num == null) return "false";
		if(!commantDao.getOriUser(co_num).equals(user.getMe_id())) return "false";
		
		commantDao.deleteCommant(co_num);
		
		return "true";
	}
}
