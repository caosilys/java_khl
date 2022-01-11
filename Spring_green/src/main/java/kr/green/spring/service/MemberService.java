package kr.green.spring.service;

import kr.green.spring.vo.MemberVO;

public interface MemberService {

	MemberVO getMember(String bd_id);

	void signUpMember(MemberVO member);

	MemberVO login(MemberVO member);

}
