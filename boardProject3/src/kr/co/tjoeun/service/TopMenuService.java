package kr.co.tjoeun.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.tjoeun.bean.BoardInfoBean;
import kr.co.tjoeun.dao.TopMenuDAO;

@Service
public class TopMenuService {
	
	@Autowired
	private TopMenuDAO topMenuDAO;
	
	public ArrayList<BoardInfoBean> getTopMenuList(){
		ArrayList<BoardInfoBean> topMenuList = topMenuDAO.getTopMenuList();
		return topMenuList;
	}
}
