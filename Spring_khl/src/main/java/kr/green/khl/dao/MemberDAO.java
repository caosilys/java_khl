package kr.green.khl.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.khl.vo.MemberVO;

public interface MemberDAO {

	MemberVO getMember(@Param("me_id")String me_id);

	void signup(MemberVO member);

}
