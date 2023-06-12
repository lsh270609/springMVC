package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.tjoeun.beans.TestBean1;
import kr.co.tjoeun.beans.TestBean2;

@Controller
@SessionAttributes({"sessionBean1", "sessionBean2"}) // 여러개 저장할때는 중괄호
public class TestController2 {
	//  @ModelAttribute 를 활용해서 객체를 생성하고 반환하는 메소드를 작성해야 함
	@ModelAttribute("sessionBean1")
	public TestBean1 sessionBean1() {
		return new TestBean1();
	}  // return new TestBean1() 에서 반환하는 객체의 주소를 
	   // @ModelAttribute("sessionBean1") 에 지정한 "sessionBean1" 이라는 이름으로 session 영역에 저장함
	@ModelAttribute("sessionBean2")
	public TestBean2 sessionBean2() {
		return new TestBean2();
	}
	
	@GetMapping("/test7")
	public String getTest7(@ModelAttribute("sessionBean1") TestBean1 sb1) {
		sb1.setData1("화면구현");
		sb1.setData2("UI테스트");
		
		return "test7";
	}
	
	@GetMapping("/result7")
	public String getResult7(@ModelAttribute("sessionBean1") TestBean1 sb1) {
		System.out.println("sessionBean1.data1 : "+sb1.getData1());
		System.out.println("sessionBean1.data2 : "+sb1.getData2());
		return "result7";
	}
	
	@GetMapping("/test8")
	public String getTest8(@ModelAttribute("sessionBean2") TestBean2 sb2) {
		sb2.setData3("화면구현2");
		sb2.setData4("UI테스트2");
		
		return "test8";
	}
	
	@GetMapping("/result8")
	public String getResult8(@ModelAttribute("sessionBean2") TestBean2 sb2) {
		System.out.println("sessionBean2.data3 : "+sb2.getData3());
		System.out.println("sessionBean2.data4 : "+sb2.getData4());
		return "result8";
	}
	
	@GetMapping("/test9")
	public String getTest9(@ModelAttribute("sessionBean1") TestBean1 sb1,
						   @ModelAttribute("sessionBean2") TestBean2 sb2) {
		sb1.setData1("화면구현");
		sb1.setData2("UI테스트");
		sb2.setData3("화면구현2");
		sb2.setData4("UI테스트2");
		
		return "test9";
	}
	
	@GetMapping("/result9")
	public String getResult9(@ModelAttribute("sessionBean1") TestBean1 sb1,
							 @ModelAttribute("sessionBean2") TestBean2 sb2) {
		System.out.println("sessionBean1.data1 : "+sb1.getData1());
		System.out.println("sessionBean1.data2 : "+sb1.getData2());
		System.out.println("sessionBean2.data3 : "+sb2.getData3());
		System.out.println("sessionBean2.data4 : "+sb2.getData4());
		return "result9";
	}
}
