package kr.co.tjoeun.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.tjoeun.bean.ContentBean;
import kr.co.tjoeun.bean.UserBean;
import kr.co.tjoeun.dao.BoardDAO;

@Service
@PropertySource(value = "/WEB-INF/properties/option.properties")
public class BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Resource(name = "loginUserBean")
	@Lazy
	private UserBean loginUserBean;
	
	// 파일 업로드 경로
	@Value("${path.upload1}")
	private String pathUpload1;
	
	// 파일 저장하는 메소드
	private String saveUploadFile(MultipartFile uploadFile) {
		String fileName = System.currentTimeMillis() + "_" + uploadFile.getOriginalFilename();
		
		try {
			uploadFile.transferTo(new File(pathUpload1 + "/" + fileName));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return fileName;
	}
	
	public void insertContent(ContentBean writeContentBean) {
		/*
		 * System.out.println(writeContentBean.getContent_subject());
		 * System.out.println(writeContentBean.getContent_text());
		 * System.out.println(writeContentBean.getUpload_file());
		 * System.out.println(writeContentBean.getUpload_file().getSize());
		 */
		MultipartFile uploadFile = writeContentBean.getUpload_file();
		if(uploadFile.getSize() > 0) {
			// 파일 이름
			String fileName = saveUploadFile(uploadFile);
			//System.out.println("fileName : "+fileName);
			writeContentBean.setContent_file(fileName);
		}
		writeContentBean.setContent_writer_idx(loginUserBean.getUser_idx());
		boardDAO.insertContent(writeContentBean);
	}
	
	public String getBoardInfoName(int board_info_idx) {
		return boardDAO.getBoardInfoName(board_info_idx);
	}
	
	// 게시글 목록 불러오기
	public List<ContentBean> getContentList(int board_info_idx) {
		return boardDAO.getContentList(board_info_idx);
	}
	
	// 게시글 상세 불러오기
	public ContentBean getContentDetail(int content_idx) {
		return boardDAO.getContentDetail(content_idx);
	}
	
	// 게시글 수정하기
	public void updateContent(ContentBean modifyContentBean) {
		MultipartFile uploadFile = modifyContentBean.getUpload_file();
		if(uploadFile.getSize() > 0) {
			// 파일 이름
			String fileName = saveUploadFile(uploadFile);
			//System.out.println("fileName : "+fileName);
			modifyContentBean.setContent_file(fileName);
		}
		modifyContentBean.setContent_writer_idx(loginUserBean.getUser_idx());
		boardDAO.updateContent(modifyContentBean);
	}
	
	public void deleteContent(int content_idx) {
		boardDAO.deleteContent(content_idx);
	}
}
