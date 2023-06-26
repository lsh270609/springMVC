package kr.co.tjoeun.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;

import kr.co.tjoeun.bean.BoardInfoBean;

public interface TopMenuMapper {
	
	@Select(value = { "select * from board_info_table order by board_info_idx" })
	ArrayList<BoardInfoBean> getTopMenuList();
}
