package kr.co.tjoeun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import kr.co.tjoeun.bean.UserBean;

// RootAppContext == root-context.xml
@Configuration
// 상속 없음 : project 작업 시 사용할 bean 을 정의하는 클래스 
public class RootAppContext {
	// 로그인하면 UserBean 객체를 loginUserBean 이라는 이름으로 Session Scope 에 저장함
	@Bean("loginUserBean")
	@SessionScope
	public UserBean loginUserBean() {
		return new UserBean();
	}
}
