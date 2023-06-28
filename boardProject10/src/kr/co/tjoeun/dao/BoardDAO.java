package kr.co.tjoeun.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.tjoeun.bean.ContentBean;
import kr.co.tjoeun.mapper.BoardMapper;


@Repository
public class BoardDAO {
	
	@Autowired
	private BoardMapper boardMapper;
	
	public void insertContent(ContentBean writeContentBean) {
		boardMapper.insertContent(writeContentBean);
	}
	
	public String getBoardInfoName(int board_info_idx) {
		return boardMapper.getBoardInfoName(board_info_idx);
	}
	
	public ArrayList<ContentBean> getContentList(int board_info_idx) {
		ArrayList<ContentBean> getContentBeanList = boardMapper.getContentList(board_info_idx);
		return getContentBeanList;
	}
	
	public ContentBean getContentDetail(int content_idx) {
		return boardMapper.getContentDetail(content_idx);
	}
	
	public void updateContent(ContentBean modifyContentBean) {
		boardMapper.updateContent(modifyContentBean);
	}
	
	public void deleteContent(int content_idx) {
		boardMapper.deleteContent(content_idx);
	}
}
