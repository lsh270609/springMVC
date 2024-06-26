package kr.co.tjoeun.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.tjoeun.mapper.BoardMapper;

// ServletAppContext == servlet-context.xml
// Spring MVC Project 에 관련된 설정을 하는 클래스
// ServletAppContext 의 객체는  SpringConfigClass 클래스의 onStartup 메소드에서 생성함
@Configuration
@EnableWebMvc // @Controller 어노테이션이 설정된 클래스를 Controller 로 등록하는 Annotation
@ComponentScan("kr.co.tjoeun.controller") // scan 할 bean 들이 모여 있는 package 지정하기
@ComponentScan("kr.co.tjoeun.service")
@ComponentScan("kr.co.tjoeun.dao")
@PropertySource("/WEB-INF/properties/db.properties")
public class ServletAppContext implements WebMvcConfigurer{

	// Controller 의 메소드에서 반환하는 문자열에 대한 접두사와 접미사 경로 정보 설정
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	// 정적 파일 (img, js css, etc)에 대한 경로 설정 
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}
	
	@Value("${db.classname}")
	private String dbClassname;
	
	@Value("${db.url}")
	private String dbUrl;
	
	@Value("${db.username}")
	private String dbUsername;
	
	@Value("${db.password}")
	private String dbPassword;
	
	// BasicDataSource : 데이터베이스 접속정보를 관리하는 Bean 
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName(dbClassname);
		source.setUrl(dbUrl);
		source.setUsername(dbUsername);
		source.setPassword(dbPassword);
		return source;
	}
	
	// SqlSessionFactory : Query 문과 Database 접속 정보를 관리하는 Bean
	@Bean
	public SqlSessionFactory factory(BasicDataSource source) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(source);
		SqlSessionFactory factory = factoryBean.getObject();
		return factory;
	}
	
	// Query 문 실행을 위한 Bean(Mapper 관리)
	@Bean
	public MapperFactoryBean<BoardMapper> getBoardMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<BoardMapper> factoryBean = new MapperFactoryBean<BoardMapper>(BoardMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}
	
	
}