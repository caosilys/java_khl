package kr.green.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.pagination.Criteria;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.FileVO;
import kr.green.spring.vo.LikesVO;

public interface BoardDAO {

	List<BoardVO> listGet(@Param("cri")Criteria cri);

	BoardVO detailGet(@Param("bd_num")Integer bd_num);

	void registerPost(@Param("board")BoardVO board);

	void deleteGet(@Param("bd_num")Integer bd_num);

	void modifyPost(@Param("board")BoardVO board);

	void insertFile(@Param("file")FileVO file);

	List<FileVO> getFileList(@Param("bd_num")Integer bd_num);

	void deleteFile(@Param("fi_num")int fi_num);

	int getTotalCount(@Param("cri")Criteria cri);

	void updateViews(@Param("bd_num")Integer bd_num);

	LikesVO getLikes(@Param("likes")LikesVO likes);

	Integer getLikeState(@Param("bd_num")Integer bd_num, @Param("me_id")String me_id);

	void insertLikes(@Param("likes")LikesVO likes);

	void updateLikes(@Param("likes")LikesVO likes);

	void updateBdLikes(@Param("li_bd_num") int li_bd_num);

}
