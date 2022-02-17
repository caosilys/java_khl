package kr.green.khl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.khl.utils.PageMaker;
import kr.green.khl.vo.*;

public interface CommantDAO {

	void insertCommant(@Param ("commant") CommantVO commant);

	List<CommantVO> selectCommantList(@Param("co_bd_num")Integer co_bd_num, @Param("pm")PageMaker pm);

	int selectTotalCount(@Param("co_bd_num")Integer co_bd_num);

	CommantVO selectCommant(@Param("co_num")Integer co_num);	
	
	void deleteCommant(@Param("co_num")Integer co_num);

	void updateCommant(@Param("commant")CommantVO commant);

	void setTest(@Param("tv") TestVO tv);

	TestVO getTest(@Param("num")Integer num);

		
}
