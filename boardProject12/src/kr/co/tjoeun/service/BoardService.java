package kr.co.tjoeun.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.tjoeun.bean.ContentBean;
import kr.co.tjoeun.bean.PageBean;
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
	@Value("${path.upload1}")
	private String pathUpload1;
	
	// 한 페이지에 나오는 게시물 수
	@Value("${page.listCnt}")
	private int pageListCnt;
	
	// 
	@Value("${page.paginationCnt}")
	private int paginationCnt;
	
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
	
	public ArrayList<ContentBean> getContentList(int board_info_idx, int page) {
		int start = (page - 1) * pageListCnt;
		RowBounds rowBounds = new RowBounds(start, pageListCnt);
		return boardDAO.getContentList(board_info_idx, rowBounds);
		
		/*
		 *		page			pagination_number
		 *		1				0(start : page - 1) ~ 9
		 *		2				10                  ~ 19
		 *		3				20 					~ 29
		 *		4				30 					~ 39
		 */
	}
	
	public ArrayList<ContentBean> getContentList5(int board_info_idx){
		return boardDAO.getContentList5(board_info_idx);
	}
	
	public ContentBean getContentDetail(int content_idx) {
		return boardDAO.getContentDetail(content_idx);
	}
	
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
	
	// 게시글 전체 개수 가져오기
	public PageBean getContentCnt(int content_board_idx, int currentPage) {
		int contentCnt = boardDAO.getContentCnt(content_board_idx);
		
		PageBean pageBean = new PageBean(contentCnt, currentPage, pageListCnt, paginationCnt);
		
		return pageBean;
	}
	
	
}
