package kr.co.tjoeun.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TestInterceptor3 implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("TestInterceptor3 - preHandle");
		System.out.println("Controller 의 메소드가 호출되기 전에 자동으로 호출되는 메소드\r\n" + 
				"		이 메소드가 false 를 반환하면 code 의 흐름이 중단됨");
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("TestInterceptor3 - postHandle");
		System.out.println("Controller 의 메소드의 수행이 완료되고\r\n" + 
				"		View  처리를 수행하기 전에 자동으로 호출되는 메뉴");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("TestInterceptor3 - afterCompletion");
		System.out.println("View 처리까지 완료하고 응답결과(response)가 Client의 \r\n" + 
				"		브라우저로 전달되기 전에 자동으로 호출되는 메소드");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
