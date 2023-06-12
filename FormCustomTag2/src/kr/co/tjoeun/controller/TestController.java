package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import kr.co.tjoeun.beans.BeanData;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String getTest1(@ModelAttribute BeanData bean) {
		bean.setData1("spring framework");
		
		return "test1";
	}
	
	@GetMapping("/test2")
	public String getTest2(@ModelAttribute BeanData bean) {
		bean.setData1("spring framework");
		bean.setData2("web application");
		return "test2";
	}
	
	@GetMapping("/test3")
	public String getTest3(@ModelAttribute BeanData bean) {
		bean.setData1("spring framework");
		bean.setData2("web application");
		bean.setData3("password");
		return "test3";
	}
	
	@GetMapping("/test4")
	public String getTest4(@ModelAttribute BeanData bean) {
		bean.setData1("spring framework");
		bean.setData2("web application");
		bean.setData3("password");
		bean.setData4("테스트 문장 1 입니다. 테스트 문장 1 입니다. 테스트 문장 1 입니다. 테스트 문장 1 입니다. ");
		return "test4";
	}
}
