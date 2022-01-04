package kr.green.khl.service;

import kr.green.khl.vo.MemberVO;

public interface MemberService {

	MemberVO login(MemberVO member);
	void join(MemberVO member);

}
