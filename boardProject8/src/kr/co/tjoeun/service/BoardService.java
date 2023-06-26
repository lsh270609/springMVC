package kr.co.tjoeun.service;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	private UserBean loginUserBean;
	
	// 파일 업로드 경로
	@Value("${path.upload}")
	private String pathUpload;
	
	// 파일 저장하는 메소드
	private String saveUploadFile(MultipartFile uploadFile) {
		String fileName = System.currentTimeMillis() + "_" + uploadFile.getOriginalFilename();
		
		try {
			uploadFile.transferTo(new File(pathUpload + "/" + fileName));
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
	
	public ContentBean selectContent(int board_info_idx) {
		ContentBean getContentBean = boardDAO.selectContent(board_info_idx);
		return getContentBean;
	}
}
