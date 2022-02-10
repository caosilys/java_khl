package kr.green.spring.service;

import java.util.List;

import kr.green.spring.pagination.PageMaker;
import kr.green.spring.vo.MemberVO;

public interface MemberService {

	MemberVO getMember(String bd_id);

	void signUpMember(MemberVO member);

	MemberVO login(MemberVO member);

	boolean idDuplicated(String id);

	MemberVO modifyMember(MemberVO user, MemberVO member);

	String findId(MemberVO member);

	String findPw(MemberVO member);

	List<MemberVO> getMemberList(PageMaker pm);

	Integer getMemberCount();

	String changeAutority(MemberVO member, MemberVO user);

	void updateAutologin(MemberVO user);

	MemberVO selectMemberBySessionId(String cookie_id);

}
