package kr.co.tjoeun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// ServletAppContext == servlet-context.xml
// Spring MVC Project 에 관련된 설정을 하는 클래스
// ServletAppContext 의 객체는  SpringConfigClass 클래스의 onStartup 메소드에서 생성함
@Configuration
@EnableWebMvc // @Controller 어노테이션이 설정된 클래스를 Controller 로 등록하는 Annotation
@ComponentScan("kr.co.tjoeun.controller") // scan 할 bean 들이 모여 있는 package 지정하기
public class ServletAppContext implements WebMvcConfigurer{

	// Controller 의 메소드에서 반환하는 문자열에 대한 접두사와 접미사 경로 정보 설정
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	// 정적 파일 (.jsp, etc)에 대한 경로 설정 
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}
	
	// properties 파일을 Message 로 등록하기
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
		res.setBasename("/WEB-INF/properties/errorMessage");
		return res;
	}
	
}
