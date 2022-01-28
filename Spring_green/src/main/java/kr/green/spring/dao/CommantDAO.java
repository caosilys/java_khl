package kr.green.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.pagination.Criteria;

import kr.green.spring.vo.CommantVO;

public interface CommantDAO {

	List<CommantVO> getList(@Param("bd_num" )Integer bd_num, @Param("cri")Criteria cri);

	int getCommantCount(@Param("bd_num" )Integer bd_num, @Param("cri")Criteria cri);

	int getTotalCount(@Param("bd_num")Integer bd_num);

}
