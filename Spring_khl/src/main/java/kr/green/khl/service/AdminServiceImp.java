package kr.green.khl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.khl.dao.MemberDAO;
import kr.green.khl.vo.MemberVO;

@Service
public class AdminServiceImp implements AdminService{

	@Autowired
	MemberDAO memberDao;
	
	@Override
	public List<MemberVO> getList() {
		
		return memberDao.getList();
		
	}
}
