package kr.green.khl.service;

import java.util.List;

import kr.green.khl.vo.MemberVO;

public interface MemberService {

	MemberVO login(MemberVO member);

	boolean signup(MemberVO member);
	
	//테스트코드
	List<MemberVO> getList();

}
