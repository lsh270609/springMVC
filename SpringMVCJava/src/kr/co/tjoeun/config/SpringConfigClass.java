package kr.co.tjoeun.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// SpringConfigClass == web.xml

public class SpringConfigClass implements WebApplicationInitializer{
	
	// project 실행 시 자동으로 호출됨
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// Spring MVC Project 에 관련된 설정을 하는 클래스(ServletAppContext)의 객체  생성하기
		AnnotationConfigWebApplicationContext servletAppContext = new AnnotationConfigWebApplicationContext();
		servletAppContext.register(ServletAppContext.class);
		
		// 요청 발생 시 요청을 처리하는 Controller 를 선택하는 Servlet 을
		// org.springframework.web.servlet.DispatcherServlet 으로 지정함
		DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppContext);
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcherServlet", dispatcherServlet);

		// <load-on-startup>1</load-on-startup>
		servlet.setLoadOnStartup(1);
		
		/*
		  <servlet-mapping>
		  	<servlet-name>appServlet</servlet-name>
		  	<url-pattern>/</url-pattern>
		  </servlet-mapping>
		 */
		servlet.addMapping("/");
		
		// Bean을 정의하는 클래스 지정하기 : RootAppContext
		AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
		rootAppContext.register(RootAppContext.class);
		
		// listener 설정하기
		ContextLoaderListener listener = new ContextLoaderListener(rootAppContext);
		servletContext.addListener(listener);
		
		// Parameter Encoding Filter 설정하기 : 한글처리 
		FilterRegistration.Dynamic filter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
		filter.setInitParameter("encoding", "UTF-8");
		filter.addMappingForServletNames(null, false, "dispatcherServlet");
	}	
}
