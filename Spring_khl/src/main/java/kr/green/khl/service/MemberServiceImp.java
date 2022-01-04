package kr.green.khl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.khl.dao.MemberDAO;
import kr.green.khl.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService{

	@Autowired
	MemberDAO memberDao;
	
	@Override
	public MemberVO login(MemberVO member) {
		
		if(member == null || member.getMe_id() == null) return null;
		MemberVO user = memberDao.getMember(member.getMe_id());
		System.out.println(user);
				
		return null;
	}

	@Override
	public void join(MemberVO member) {
		// 이미있는 아이디 예외처리 필요함
		System.out.println("test"); 
		System.out.println(member);
	}
}
