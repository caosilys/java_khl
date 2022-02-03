package kr.green.spring.service;

import java.util.List;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.vo.CommantVO;
import kr.green.spring.vo.MemberVO;

public interface CommantService {

	List<CommantVO> getList(Integer bd_num, Criteria cri);

	int getTotalCount(Integer bd_num);

	String setCommant(CommantVO commant);

	String modifyCommant(MemberVO user, CommantVO commant);

	String deleteCommant(MemberVO user, Integer co_num);

}
