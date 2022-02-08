package kr.green.khl.service;

import java.util.List;

import kr.green.khl.vo.MainCategoryVO;
import kr.green.khl.vo.MemberVO;
import kr.green.khl.vo.MiddleCategoryVO;

public interface MemberService {

	MemberVO login(MemberVO member);

	boolean signup(MemberVO member);

	String checkId(String id);

	MemberVO updateMember(MemberVO input, MemberVO user);

	String findMemberId(MemberVO member);

	String findMemberPw(MemberVO member);

	void updateAutologin(MemberVO user);

	MemberVO selectMemberBySessionId(String value);

	List<MainCategoryVO> selectMainCategory();

	List<MiddleCategoryVO> selectMiddleCategory(Integer ma_num);

	List<MiddleCategoryVO> selecSubCategory(Integer mi_num);

}
