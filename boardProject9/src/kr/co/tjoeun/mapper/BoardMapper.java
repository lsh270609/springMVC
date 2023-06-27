package kr.co.tjoeun.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import kr.co.tjoeun.bean.ContentBean;

public interface BoardMapper {
	
	@SelectKey(statement="select content_seq.nextval from dual", 
			   keyProperty="content_idx", before=true, resultType=int.class)
	 @Insert(value={"insert into content_table values"
	 		+ "(#{content_idx}, #{content_subject}, #{content_text}, #{content_file, jdbcType=VARCHAR}, #{content_writer_idx}, #{content_board_idx}, sysdate)"})
	 void insertContent(ContentBean writeContentBean);

	 // 게시판 index 로 헤당 게시판 이름 가져오기
	 @Select(value= { "select board_info_name from board_info_table WHERE board_info_idx = #{board_info_idx} " })
	 String getBoardInfoName(int board_info_idx);
	 
	 // 게시판 index 로 헤당 게시판 글 목록 불러오기
	 @Select(value= {"select a.content_idx, a.content_subject, b.user_name as content_writer_name, TO_CHAR(a.content_date, 'YYYY-MM-DD HH24:MI:SS') as content_date "
	 			    + "from content_table a, user_table b "
	 			    + "where content_board_idx = #{content_board_idx} "
	 			    + "and a.content_writer_idx = b.user_idx "
	 			    + "order by content_idx desc"})
	 ArrayList<ContentBean> getContentList(int board_info_idx);
	 
	 // 게시글 상세보기
	 @Select("select b.user_name as content_writer_name, TO_CHAR(a.content_date, 'YYYY-MM-DD HH24:MI:SS') as content_date, a.content_subject, a.content_text, a.content_file " + 
	 		 "from content_table a, user_table b " + 
	 		 "where a.content_idx = #{content_idx} " + 
	 		 "and a.content_writer_idx = b.user_idx")
	 ContentBean getContentDetail(int content_idx);
}

