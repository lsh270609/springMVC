package kr.co.tjoeun.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.co.tjoeun.bean.UserBean;

public interface UserMapper {
	@Select(value = { "select user_name from user_table where user_id = #{user_id}" })
	String checkUserIdExist(String user_id);
	
	@Insert(value = { "insert into user_table values(user_seq.nextval, #{user_name}, #{user_id}, #{user_pw})" })
	void insertUser(UserBean joinUserBean);
	
	@Select(value = { "select user_idx, user_name from user_table where user_id = #{user_id} and user_pw = #{user_pw}" })
	UserBean getLoginUserInfo(UserBean tmpLoginUserBean);
}
