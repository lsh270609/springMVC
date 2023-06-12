package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.tjoeun.beans.DataBean1;
import kr.co.tjoeun.beans.DataBean2;
import kr.co.tjoeun.beans.DataBean3;

@Controller
public class TestController {
	
	@PostMapping("/test1")
	public String postTest1(@ModelAttribute DataBean1 bean1) {
		System.out.println("number1 : "+bean1.getNumber1());
		System.out.println("number2 : "+bean1.getNumber2());
		return "test1";
	}
	
	@PostMapping("/test2")
	public String postTest2(@ModelAttribute("db2") DataBean2 bean2) {
		System.out.println("number3 : "+bean2.getNumber3());
		System.out.println("number4 : "+bean2.getNumber4());
		return "test2";
	}
	
	@PostMapping("/test3")
	public String postTest3(DataBean3 bean3) {
		System.out.println("number5 : "+bean3.getNumber5());
		System.out.println("number6 : "+bean3.getNumber6());
		return "test3";
	}
}
