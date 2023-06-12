package kr.co.tjoeun.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.co.tjoeun.beans.TestBean1;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String getTest1(HttpSession session) {
		// HttpSession 객체 생성하기
		//HttpSession session = request.getSession();
		
		// Session 영역에 data 저장하기
		session.setAttribute("data1", "스프링웹");
		
		return "test1";
	}
	
	@GetMapping("/test2_redirect")
	public String getTest2(HttpSession session) {
		session.setAttribute("data1", "MVC 패턴");
		return "redirect:/result1";
	}
	
	@GetMapping("/test3_forward")
	public String getTest3(HttpSession session) {
		session.setAttribute("data1", "Model2방식");
		return "forward:/result1";
	}
	
	@GetMapping("/result1")
	public String getResult1(HttpSession session) {
		// HttpSession 객체 생성하기
		//HttpSession session = request.getSession();
		
		// session 영역에서 data 가져오기
		String data1 = (String) session.getAttribute("data1");
		System.out.println("data1 : "+data1);
		return "result1";
	}
	
	@GetMapping("/test4")
	public String getTest4(HttpSession session) {
		TestBean1 bean1 = new TestBean1();
		bean1.setData1("자바웹");
		bean1.setData2("HTML/CSS");
		
		// 객체를 session scope 에 올리기
		session.setAttribute("bean1", bean1);
		return "test4";
	}
	
	@GetMapping("/result4")
	public String getResult4(HttpSession session) {
		TestBean1 bean1 = (TestBean1) session.getAttribute("bean1");
		System.out.println("bean1.data1 : "+bean1.getData1());
		System.out.println("bean1.data2 : "+bean1.getData2());
		
		return "result4";
	}
	
	@GetMapping("/test5")
	public String getTest5(HttpSession session) {
		TestBean1 bean1 = new TestBean1();
		bean1.setData1("자바웹프로그래밍");
		bean1.setData2("HTML/CSS/JSON");
		
		// 객체를 session scope 에 올리기
		session.setAttribute("bean1", bean1);
		return "test5";
	}
	
	// @SessionAttribute("bean1") : session 영역에 저장된 data 를 가져옴
	@GetMapping("/result5")
	public String getResult5(@SessionAttribute("bean1") TestBean1 bean) {
		// TestBean1 bean1 = (TestBean1) session.getAttribute("bean1");
		System.out.println("bean.data1 : "+bean.getData1());
		System.out.println("bean.data2 : "+bean.getData2());
		
		return "result5";
	}
	
	@GetMapping("/test6")
	public String getTest6(HttpSession session, TestBean1 bean1) {  //@ModelAttribute 어노테이션 생략
		// TestBean1 bean1 = new TestBean1();  
		bean1.setData1("자바웹프로그래밍");
		bean1.setData2("HTML/CSS/JSON");
		
		// 객체를 session scope 에 올리기
		session.setAttribute("bean1", bean1);
		return "test5";
	}
	
	// @SessionAttribute("bean1") : session 영역에 저장된 data 를 가져옴
	@GetMapping("/result6")
	public String getResult6(@SessionAttribute("bean1") TestBean1 bean) { //@ModelAttribute 어노테이션 생략
		// TestBean1 bean1 = (TestBean1) session.getAttribute("bean1");
		System.out.println("bean.data1 : "+bean.getData1());
		System.out.println("bean.data2 : "+bean.getData2());
		
		return "result5";
	}
}
