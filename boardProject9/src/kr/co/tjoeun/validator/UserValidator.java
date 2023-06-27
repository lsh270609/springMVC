package kr.co.tjoeun.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.co.tjoeun.bean.UserBean;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return UserBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		String beanName = errors.getObjectName();
		
		UserBean userBean = (UserBean) target;
		
		if(beanName.equals("joinUserBean") || beanName.equals("modifyUserBean")) {
			if(userBean.getUser_pw().equals(userBean.getUser_pw2()) == false) {
				errors.rejectValue("user_pw", "NotEquals");
				errors.rejectValue("user_pw2", "NotEquals");
			}
		}
		// 아이디가 db에 이미 존재하는 경우
		if(beanName.equals("joinUserBean")) {
			if(userBean.isUserIdExist() == false) {
				errors.rejectValue("user_id", "DontCheckUserIdExist");
			}	
		}
		
	}	
}