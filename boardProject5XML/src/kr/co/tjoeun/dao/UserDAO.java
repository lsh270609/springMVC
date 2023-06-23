package kr.co.tjoeun.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.tjoeun.bean.UserBean;

@Repository
public class UserDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public String checkUserIdExist(String user_id) {
		String user_name = sqlSessionTemplate.selectOne("user.checkUserIdExist", user_id); 
		return user_name;
	}
	
	public void insertUser(UserBean joinUserBean) {
		sqlSessionTemplate.insert("user.insertUser", joinUserBean);
	}
	
	public UserBean getLoginUserInfo(UserBean tmpLoginUserBean) {
		UserBean userBean = sqlSessionTemplate.selectOne("user.getLoginUserInfo", tmpLoginUserBean);
		return userBean;
	}
}
