package kr.green.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.*;
import kr.green.spring.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService{

	@Autowired
	MemberDAO memberDao;
	
	@Autowired
	BCryptPasswordEncoder pwEncoder;
	
	@Override
	public MemberVO getMember(String bd_id) {
		
		return memberDao.getMember(bd_id);
	}

	@Override
	public void signUpMember(MemberVO member) {
		if(member == null) return;
		if(member.getMe_id() == null) return;
		if(member.getMe_pw() == null) return;
		
		String encPw = pwEncoder.encode(member.getMe_pw());
		member.setMe_pw(encPw);		
		memberDao.sighUpMember(member);		
	}

	@Override
	public MemberVO login(MemberVO member) {

		MemberVO user = memberDao.getMember(member.getMe_id());
		
		if(user == null)	return null;
		if(pwEncoder.matches(member.getMe_pw(), user.getMe_pw())) return user;
		return null;
	}

}
