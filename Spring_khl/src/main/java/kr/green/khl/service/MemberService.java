package kr.green.khl.service;

import java.util.List;

import kr.green.khl.vo.MemberVO;

public interface MemberService {

	MemberVO login(MemberVO member);

	boolean signup(MemberVO member);
	
	List<MemberVO> getList();

	String checkId(String id);

	MemberVO updateMember(MemberVO input, MemberVO user);

	String findMember(MemberVO member);

}
