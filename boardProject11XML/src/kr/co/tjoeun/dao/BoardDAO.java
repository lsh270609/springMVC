package kr.co.tjoeun.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.tjoeun.bean.ContentBean;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insertContent(ContentBean writeContentBean) {
		sqlSessionTemplate.insert("board.insertContent", writeContentBean);
	}
	
	public String getBoardInfoName(int board_info_idx) {
		return sqlSessionTemplate.selectOne("board.getBoardInfoName", board_info_idx);
	}
	
	public List<ContentBean> getContentList(int board_info_idx, RowBounds rowBounds) {
		return sqlSessionTemplate.selectList("board.getContentList", board_info_idx, rowBounds);
	}
	
	public ContentBean getContentDetail(int content_idx) {
		return sqlSessionTemplate.selectOne("board.getContentDetail", content_idx);
	}
	
	public void updateContent(ContentBean modifyContentBean) {
		sqlSessionTemplate.update("board.updateContent", modifyContentBean);
	}
	
	public void deleteContent(int content_idx) {
		sqlSessionTemplate.delete("board.deleteContent", content_idx);
	}
	
	public int getContentCnt(int content_board_idx) {
		return sqlSessionTemplate.selectOne("board.getContentCnt",content_board_idx);
	}
}
