package kr.green.spring.service;

import java.util.List;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.vo.CommantVO;

public interface CommantService {

	List<CommantVO> getList(Integer bd_num, Criteria cri);

	int getTotalCount(Integer bd_num);

	String setCommant(CommantVO commant);

}
