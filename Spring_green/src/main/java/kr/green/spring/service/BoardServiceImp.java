package kr.green.spring.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.green.spring.dao.BoardDAO;
import kr.green.spring.pagination.Criteria;
import kr.green.spring.utils.UploadFileUtils;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.FileVO;

@Service
public class BoardServiceImp implements BoardService{

	@Autowired
	BoardDAO boardDao;
	//집
//	String uploadPath = "C:\\Users\\caosi\\Desktop\\upload";
	//학원
	String uploadPath = "C:\\Users\\green\\Desktop\\upload";
	@Override
	public List<BoardVO> listGet(Criteria cri) {
		 
		return boardDao.listGet(cri);
	}

	@Override
	public BoardVO detailGet(Integer bd_num) {
		
		return boardDao.detailGet(bd_num);
	}

	@Override
	public void registerPost(BoardVO board, List<MultipartFile> files) {
		 
		//기타 예외처리
		// 게시글 등록
		boardDao.registerPost(board);
		//파일 업로드
		uploadFile(files,board.getBd_num());
	}
	
	@Override
	public void modifyPost(BoardVO board, String userID, List<MultipartFile> files, Integer[] fileNums) {
		
		if(!userID.equals(board.getBd_me_id())) return;
		
		// 기타예외처리필요
		
		boardDao.modifyPost(board);
		
		//해당 게시글 번호와 일치하는 첨부파일 전체를 가져옴.
		List<FileVO> fileList = boardDao.getFileList(board.getBd_num());
		//가져온 첨부파일 전체에서 fileNums에 없는 번호들의 첨부파일들을 서버에서 삭제
		if(fileList != null && fileList.size() !=0 && fileNums != null && fileNums.length !=0) {
			List<FileVO> delList = new ArrayList<FileVO>();
			for(FileVO tmpFilevo : fileList) {
				for(Integer tmp : fileNums) {
					if(tmpFilevo.getFi_num() == tmp) {
						delList.add(tmpFilevo);
					}
				}
			}
			fileList.removeAll(delList);
		}	
		deleteFile(fileList);
		// 새로추가된 첨부파일이 있으면 서버에 업로드
		// 새로추가된 첨부파일을 db에 추가	
		uploadFile(files,board.getBd_num());
		

	}
	
	@Override
	public void deleteGet(Integer bd_num, String userID) {
		String board_id = boardDao.detailGet(bd_num).getBd_me_id();		
		if(!board_id.equals(userID)) return;
		
		//기타 예외처리
				
		//첨부파일이 있으면 첨부파일삭제
		List<FileVO> fileList = boardDao.getFileList(bd_num);	
		deleteFile(fileList);
		
		boardDao.deleteGet(bd_num);
	}

	@Override
	public List<FileVO> getFileList(Integer bd_num) {
		
		if(bd_num <= 0 || bd_num == null) return null;
		return boardDao.getFileList(bd_num);
	}
	
	public void uploadFile(List<MultipartFile> files, Integer bd_num) {
		if(files ==null ||files.size() == 0) return;
		for(MultipartFile temp : files) {
			if(temp != null && temp.getOriginalFilename().length() != 0) {
				try 
				{
					String path = UploadFileUtils.uploadFile(uploadPath, temp.getOriginalFilename(), temp.getBytes());
					FileVO file = new FileVO(temp.getOriginalFilename(), path, bd_num);
					boardDao.insertFile(file);
				}catch (Exception e) { e.printStackTrace(); }
			}
		}
	}
	
	public void deleteFile(List<FileVO>fileList) {
		if(fileList != null && fileList.size() !=0) {
			for(FileVO tmpFileVo : fileList) {
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
	public int getTotalCount(Criteria cri) {
		
		return boardDao.getTotalCount(cri);
	}

	@Override
	public void updateViews(Integer bd_num) {
		boardDao.updateViews(bd_num);	
	}



}
