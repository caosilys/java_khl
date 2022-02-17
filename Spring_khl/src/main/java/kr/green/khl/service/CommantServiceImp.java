package kr.green.khl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.khl.dao.CommantDAO;
import kr.green.khl.utils.PageMaker;
import kr.green.khl.vo.CommantVO;
import kr.green.khl.vo.MemberVO;
import kr.green.khl.vo.TestVO;

@Service
public class CommantServiceImp implements CommantService{

	@Autowired
	CommantDAO commantDao;

	@Override
	public boolean insertCommant(CommantVO commant, MemberVO user) {
		if(user == null || commant == null || commant.getCo_content().equals("")){
			return false;
		}
		commant.setCo_me_id(user.getMe_id());
		commantDao.insertCommant(commant);
		
		return true;
	}

	@Override
	public List<CommantVO> selectCommantList(Integer co_bd_num, PageMaker pm) {
		
		if(co_bd_num == null || co_bd_num <=0)	return null;
		if(pm == null) return null;
		pm.calcData();
		
		return commantDao.selectCommantList(co_bd_num, pm);
	}

	@Override
	public int selectTotalCount(Integer co_bd_num) {
		if(co_bd_num == null || co_bd_num <=0)	return 0;
		return commantDao.selectTotalCount(co_bd_num);  
	}

	@Override
	public String deleteCommant(MemberVO user, Integer co_num) {
		
		CommantVO com = commantDao.selectCommant(co_num);
		
		
		if(co_num == null || co_num <=  0 || user == null || com == null) return "false";
		
		commantDao.deleteCommant(co_num);
		
		return "true";
	}

	@Override
	public String updateCommant(MemberVO user, CommantVO commant) {
		
		if(user == null || commant == null) return "false";
		CommantVO dbCommant = commantDao.selectCommant(commant.getCo_num());
		
		if(dbCommant == null || !dbCommant.getCo_me_id().equals(user.getMe_id())) return "false";
		commantDao.updateCommant(commant);		
		return "true";
	}

	@Override
	public void setTest(TestVO tv) {
		
		commantDao.setTest(tv);
		
	}

	@Override
	public TestVO getTest(Integer num) {
		
		TestVO tv = commantDao.getTest(num);
		
		System.out.println(tv);
		
		return null;
	} 
	
}
