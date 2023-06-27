package kr.co.tjoeun.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.tjoeun.bean.BoardInfoBean;
import kr.co.tjoeun.mapper.TopMenuMapper;

@Repository
public class TopMenuDAO {
	
	@Autowired
	private TopMenuMapper topMenuMapper;
	
	public ArrayList<BoardInfoBean> getTopMenuList(){
		ArrayList<BoardInfoBean> topMenuList = topMenuMapper.getTopMenuList();
		return topMenuList;
	}
}
