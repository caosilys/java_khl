package kr.green.khl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.khl.vo.MainCategoryVO;
import kr.green.khl.vo.MemberVO;
import kr.green.khl.vo.MiddleCategoryVO;

public interface MemberDAO {

	MemberVO getMember(@Param("me_id")String me_id);

	void isertMember(@Param("member") MemberVO member);
	
	void updateMember(@Param("user")MemberVO input);
	
	String findMemberId(@Param("user")MemberVO member);
	
	List<MemberVO> getList();

	void updateAutoLogin(@Param("user")MemberVO user);

	MemberVO selectMemberBySessionId(@Param("me_session_id")String me_session_id);

	List<MainCategoryVO> selectMainCategory();

	List<MiddleCategoryVO> selectMiddleCategory(@Param("ma_num")Integer ma_num);

	List<MiddleCategoryVO> selecSubCategory(@Param("mi_num")Integer mi_num);

	

	

}
