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
	
	public ArrayList<ContentBean> selectContent(int board_info_idx) {
		ArrayList<ContentBean> getContentBeanList = boardMapper.selectContent(board_info_idx);
		return getContentBeanList;
	}
}
