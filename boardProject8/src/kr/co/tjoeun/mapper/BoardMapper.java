package kr.co.tjoeun.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.co.tjoeun.bean.ContentBean;

public interface BoardMapper {
	
	 @Insert(value={"insert into content_table values"
	 		+ "(content_seq.nextval, #{content_subject}, #{content_text}, #{content_file, jdbcType=VARCHAR}, #{content_writer_idx}, #{content_board_idx}, sysdate)"})
	 void insertContent(ContentBean writeContentBean);
	 
	 @Select(value= {"select a.*, b.user_name as content_writer_name from content_table a, user_table b WHERE CONTENT_BOARD_IDX = #{content_board_idx} and a.content_writer_idx = b.user_idx"})
	 ArrayList<ContentBean> selectContent(int content_board_idx);
}

