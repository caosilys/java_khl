package kr.green.khl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.khl.dao.MemberDAO;
import kr.green.khl.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService{

	@Autowired
	MemberDAO memberDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public MemberVO login(MemberVO member) {
		
		if(member == null || member.getMe_id() == null) return null;
		MemberVO user = memberDao.getMember(member.getMe_id());

		//로그인에 성공하면 회원정보를 실패하면 null을 반환		
	    if(user != null && passwordEncoder.matches(member.getMe_pw(), user.getMe_pw())) {	       
	    	return user;	        
	    }
		return null;
	}

	public boolean signup(MemberVO member) {
		
		if(member == null) return false;
		if(member.getMe_id() == null) return false;
		if(member.getMe_pw() == null) return false;
		
		// 이미있는 아이디 예외처리
		if(memberDao.getMember(member.getMe_id()) != null) {
			System.out.println("아이디 중복");
			return false;		
		}
		//암호화된 비밀번호
		String encPw = passwordEncoder.encode(member.getMe_pw());
		member.setMe_pw(encPw);
		memberDao.isertMember(member);	
		return true; 
		
	}
	
	// 테스트코드
	@Override
	public List<MemberVO> getList() {
		
		return memberDao.getList();
		
	}

	@Override
	public String checkId(String id) {
		MemberVO member = memberDao.getMember(id);
		if(member != null) return "false";
		return "true";
	
	}
}
