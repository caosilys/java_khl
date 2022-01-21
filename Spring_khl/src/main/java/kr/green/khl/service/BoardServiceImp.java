package kr.green.khl.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.green.khl.dao.*;
import kr.green.khl.utils.*;
import kr.green.khl.vo.*;

@Service
public class BoardServiceImp implements BoardService{
	
	@Autowired
	BoardDAO boardDao;
	
	//업로드할 폴더 경로. 환경에 따라 바꿔줘야함
	//집
//	String uploadPath="C:\\Users\\caosi\\Desktop\\upload";
	//학원
	String uploadPath="C:\\Users\\green\\Desktop\\upload";
		
	@Override
	public void deleteFile(int bd_num, Integer[] fileNums) {		
		
		List<FileVO> fileList = boardDao.getFile(bd_num);
		List<FileVO> deletefiles = new ArrayList<FileVO>();
		// 1. fileNums != null : modify 에서 삭제하지 않은 파일이 남아있는 경우
		// -> file 과 fileNums 를 비교해서 새로운 배열(삭제해야할 fi_num)을 만듬
		// -> 삭제해야할 FileVO 변경됨
		if(fileList != null && fileList.size() !=0 && fileNums != null && fileNums.length !=0) {			
			for(FileVO tmpFilevo : fileList) {
				for(Integer tmp : fileNums) {
					if(tmpFilevo.getFi_num() == tmp) {
						deletefiles.add(tmpFilevo);
					}
				}
			}
			fileList.removeAll(deletefiles);
		}
		else if(fileNums == null){
			deletefiles = fileList;
		}
		// 2. fileNums == null : 	a. board 자체를 삭제할 때 null을 넣어서 호출한 경우							
		//								b. modify 중 기존에 있던 파일을 전부 삭제
		// 								삭제해야 할 FileVO는 그대로		
		if(deletefiles != null && deletefiles.size() !=0) {			
			for(FileVO tmpFileVo : deletefiles) {
				File f = new File(uploadPath+tmpFileVo.getFi_name().replace("/", File.separator));
				if(f.exists()) {
					f.delete();
				}
				// db에서도 삭제
				boardDao.deleteFile(tmpFileVo.getFi_num());
			}
		}
	}
	
	@Override
	public void uploadFile(List<MultipartFile> file, int bd_num) throws Exception {
		if(file == null || bd_num == 0) return;
		
//		UploadFileUtils.uploadFile(업로드경로, 파일명, 파일데이터);		
		for(MultipartFile tmpfile : file) {
			//서버에 업로드				
			if(!tmpfile.getOriginalFilename().equals("") && tmpfile.getBytes() != null)  {
				String path = UploadFileUtils.uploadFile(uploadPath, tmpfile.getOriginalFilename(), tmpfile.getBytes());
				
				//db에 저장
				FileVO  fileVo = 
						new FileVO(tmpfile.getOriginalFilename(), path, bd_num);			
				boardDao.insertFile(fileVo);
			}				
		}
	}
	
	@Override
	public void registerBoard(BoardVO board) {
		if(	board == null ||
			board.getBd_title() == null ||
			board.getBd_title().equals("") ||
			board.getBd_content() == null ||
			board.getBd_me_id() == null ) return;
			boardDao.insertBoard(board);
	}
	
	@Override
	public List<BoardVO> getBoardList(PageMaker pm) {
		
		return boardDao.getBoardList(pm);
	}
	
	@Override
	public BoardVO getBoard(Integer bd_num) {
		//게시글 번호가 없거나 0이하이면 예외처리
		if(bd_num == null || bd_num <= 0) return null;

		return boardDao.getBoard(bd_num);
		
	}
	
	@Override
	public BoardVO getBoard(Integer bd_num, String me_id) {
		if(bd_num == null || bd_num <= 0) return null;
		
		BoardVO board = boardDao.getBoard(bd_num);
		if(board ==null || !board.getBd_me_id().equals(me_id)) return null;
		
		return board;
		
	}

	@Override
	public void deleteBoard(Integer bd_num, MemberVO user) {
		
		// 예외처리 코드
		//유효하지 않은 게시글 번호이면 삭제할 필요없음
		if(bd_num == null || bd_num <= 0) return;
		//유효한 게시물이면 게시글 번호와 일치하는 게시글을 가져옴
		BoardVO board =  boardDao.getBoard(bd_num);
		//가져온 게시글이 null이면 삭제할 필요가 없음
		if(board == null) return;
		//게시글 작성자와 로그인한 회원 아이디가 같은지 확인하여 다르면 삭제할 필요 없음
		if(!board.getBd_me_id().equals(user.getMe_id())) return;
		// 게시글 삭제
		boardDao.deleteBoard(bd_num);
		
		/* 해당방법으로도 가능
		board.setBd_del("Y");
		board.setBd_del_date();
		boardDao.update(board);
		*/		
		return;
		
	}

	@Override
	public void updateBoard(BoardVO board) {
				
		boardDao.updateBoard(board);
	}

	@Override
	public List<FileVO> getFile(Integer bd_num) {
		if(bd_num == null || bd_num <= 0) return null;
		return boardDao.getFile(bd_num);
	}

//	@Override
	private int getBoardCount(PageMaker pm) {
		
		return boardDao.getBoardCount(pm);
	}

	@Override
	public PageMaker setPageMaker(PageMaker pm, Integer page, String search, String type) {
		
		if(page != null) pm.setPage(page);
		if(search != null) pm.setSearch(search);	
		if(type != null) pm.setType(type);
		pm.setCount(getBoardCount(pm));			
		
		return pm;
	}

	@Override
	public List<BoardVO> getMyBoard(String user_id) {
		
		return boardDao.getMyBoard(user_id);
	}

	@Override
	public void updateViews(Integer bd_num) {
		boardDao.updateViews(bd_num);
		
	}








}
