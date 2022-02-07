package kr.green.khl.service;

import java.util.List;

import kr.green.khl.vo.MemberVO;

public interface MemberService {

	MemberVO login(MemberVO member);

	boolean signup(MemberVO member);

	String checkId(String id);

	MemberVO updateMember(MemberVO input, MemberVO user);

	String findMemberId(MemberVO member);

	String findMemberPw(MemberVO member);

	void updateAutologin(MemberVO user);

	MemberVO selectMemberBySessionId(String value);

}
