package kr.green.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.MemberVO;

public interface MemberDAO {

	MemberVO getMember(@Param("bd_id")String bd_id);

	void sighUpMember(@Param("member")MemberVO member);

}
