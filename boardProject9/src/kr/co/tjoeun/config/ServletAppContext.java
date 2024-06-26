package kr.co.tjoeun.config;

import javax.annotation.Resource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.tjoeun.bean.UserBean;
import kr.co.tjoeun.interceptor.CheckLoginInterceptor;
import kr.co.tjoeun.interceptor.TopMenuInterceptor;
import kr.co.tjoeun.mapper.BoardMapper;
import kr.co.tjoeun.mapper.TopMenuMapper;
import kr.co.tjoeun.mapper.UserMapper;
import kr.co.tjoeun.service.TopMenuService;

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
	
	@Autowired
	private TopMenuService topMenuService;
	
	@Resource(name="loginUserBean")
	private UserBean loginUserBean;
	
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
	
	// BoardMapper Mapper 등록
	@Bean
	public MapperFactoryBean<BoardMapper> getBoardMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<BoardMapper> factoryBean = new MapperFactoryBean<BoardMapper>(BoardMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}
	
	// TopMenuMapper Mapper 등록
	@Bean
	public MapperFactoryBean<TopMenuMapper> getTopMenuMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<TopMenuMapper> factoryBean = new MapperFactoryBean<TopMenuMapper>(TopMenuMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}
	
	// UserMapper Mapper 등록
	@Bean
	public MapperFactoryBean<UserMapper> getUserMapper(SqlSessionFactory factory) throws Exception {
		MapperFactoryBean<UserMapper> factoryBean = new MapperFactoryBean<UserMapper>(UserMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
	}
	
		
	@Bean
	public StandardServletMultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}
		

	// Interceptor 등록하기
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		TopMenuInterceptor topMenuInterceptor = new TopMenuInterceptor(topMenuService, loginUserBean);
		InterceptorRegistration reg1 = registry.addInterceptor(topMenuInterceptor);
		reg1.addPathPatterns("/**");
		
		CheckLoginInterceptor checkLoginInterceptor = new CheckLoginInterceptor(loginUserBean);	
		InterceptorRegistration reg2 = registry.addInterceptor(checkLoginInterceptor);
		//로그인하지 않으면 접근할 수 없는 url 등록하기
		reg2.addPathPatterns("/user/modify", "/user/logout", "/board/*");
		reg2.excludePathPatterns("/board/main");
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	// 에러 메세지 properties 파일 등록 : messageSource 등록하기
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
		res.setBasename("/WEB-INF/properties/error");
		return res;
	}
	
	
}