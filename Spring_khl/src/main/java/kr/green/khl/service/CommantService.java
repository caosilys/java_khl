package kr.green.khl.service;

import java.util.List;

import kr.green.khl.utils.PageMaker;
import kr.green.khl.vo.CommantVO;
import kr.green.khl.vo.MemberVO;

public interface CommantService {

	boolean insertCommant(CommantVO commant, MemberVO user);

	List<CommantVO> selectCommantList(Integer co_bd_num, PageMaker pm);

	int selectTotalCount(Integer co_bd_num);

	String deleteCommant(MemberVO user, Integer co_num);

	String updateCommant(MemberVO user, CommantVO commant);

}
