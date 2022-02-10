package kr.green.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.pagination.PageMaker;
import kr.green.spring.vo.MemberVO;

public interface MemberDAO {

	MemberVO getMember(@Param("bd_id")String bd_id);

	void sighUpMember(@Param("member")MemberVO member);

	void updateMember(@Param("member")MemberVO member);

	String findId(@Param("member")MemberVO member);

	List<MemberVO> getMemberList(@Param("cri")Criteria cri);

	Integer getMemberCount();

	void updateAutologin(@Param("user")MemberVO user);

	MemberVO getMemberBySessionId(@Param("cookie_id")String cookie_id);

}
