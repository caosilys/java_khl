package kr.green.khl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.khl.vo.MemberVO;

public interface MemberDAO {

	MemberVO getMember(@Param("me_id")String me_id);

	void isertMember(@Param("member") MemberVO member);
	
	void updateMember(@Param("user")MemberVO input);
	
	//테스트코드
	List<MemberVO> getList();

	

}
