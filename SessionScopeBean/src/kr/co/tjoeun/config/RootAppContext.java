package kr.co.tjoeun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import kr.co.tjoeun.beans.TestBeanByName;
import kr.co.tjoeun.beans.TestBeanByType;

// RootAppContext == root-context.xml
@Configuration
// 상속 없음 : project 작업 시 사용할 bean 을 정의하는 클래스 
public class RootAppContext {
	
	//컨트롤러에서 bean을 type으로 주입받음
	@Bean
	@SessionScope
	public TestBeanByType testBeanByType() {
		return new TestBeanByType();
	}

	//컨트롤러에서 bean을 name으로 주입받음
	@Bean(name="testBeanByName")
	@SessionScope
	public TestBeanByName testBeanByName() {
		return new TestBeanByName();
	}
}
