package kr.co.tjoeun.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.tjoeun.testBean1.TestBean1;

@Controller
public class TestController {
	
	@Autowired
	ServletContext application;
	
	@GetMapping("/test1")
	public String getTest1(HttpServletRequest request) {
		ServletContext application = request.getServletContext();
		application.setAttribute("name", "더조은학원");
		return "test1";
	}
	
	@GetMapping("/result1")
	public String getResult1(HttpServletRequest request) {
		ServletContext application = request.getServletContext();
		String name= (String) application.getAttribute("name");
		System.out.println("name  : "+name);
		return "result1";
	}
	
	@GetMapping("/test2")
	public String getTest2(HttpServletRequest request) {
		application.setAttribute("name", "더조은학원");
		return "test2";
	}
	
	@GetMapping("/result2")
	public String getResult2(HttpServletRequest request) {
		String name= (String) application.getAttribute("name");
		System.out.println("name  : "+name);
		return "result2";
	}
	
	@GetMapping("/test3")
	public String getTest3() {
		TestBean1 bean1 = new TestBean1();
		bean1.setData1("qwer");
		bean1.setData2("asdf");
		application.setAttribute("bean1", bean1);
		return "test3";
	}
	
	@GetMapping("/result3")
	public String getResult3() {
		
	}
}
