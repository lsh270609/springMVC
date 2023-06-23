package kr.co.tjoeun.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import kr.co.tjoeun.bean.UserBean;
import kr.co.tjoeun.dao.UserDAO;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	// loginUserBean : Server 실행될 때 Session Scope 에 생성한 UserBean 객체
	@Resource(name = "loginUserBean")
	@Lazy
	private UserBean loginUserBean;
	
	public boolean checkUserIdExist(String user_id) {
		String user_name = userDAO.checkUserIdExist(user_id);
		if(user_name == null) {
			return true;
		} else {
			return false;			
		}
	}
	
	public void insertUser(UserBean joinUserBean) {
		userDAO.insertUser(joinUserBean);
	}
	
	public void getLoginUserInfo(UserBean tmpLoginUserBean) {
		UserBean userBean = userDAO.getLoginUserInfo(tmpLoginUserBean);
		if (userBean != null) {
			//로그인 성공
			loginUserBean.setUser_idx(userBean.getUser_idx());
			loginUserBean.setUser_name(userBean.getUser_name());
			loginUserBean.setUserLogin(true);
		}
	}
	
	public void getModifyUserInfo(UserBean modifyUserBean) {
		UserBean tmpModifyUserBean = userDAO.getModifyUserInfo(loginUserBean.getUser_idx());
		modifyUserBean.setUser_id(tmpModifyUserBean.getUser_id());
		modifyUserBean.setUser_name(tmpModifyUserBean.getUser_name());
		modifyUserBean.setUser_idx(loginUserBean.getUser_idx());
	}
}
