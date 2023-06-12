package kr.co.tjoeun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;

import kr.co.tjoeun.beans.TestBean1;
import kr.co.tjoeun.beans.TestBean2;

// RootAppContext == root-context.xml
@Configuration
// 상속 없음 : project 작업 시 사용할 bean 을 정의하는 클래스 
public class RootAppContext {
	//ByType
	@Bean
	@ApplicationScope
	public TestBean1 applicationBean1() {
		return new TestBean1();
	}
	
	//ByName
	@Bean("applicationBean2")
	@ApplicationScope
	public TestBean2 applicationBean2() {
		return new TestBean2();
	}
}
