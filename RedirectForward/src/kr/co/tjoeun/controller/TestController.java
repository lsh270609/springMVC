package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String getTest1() {
		return "redirect:/sub1";
	}
	
	@GetMapping("/sub1")
	public String getsub1() {
		return "sub1";
	}
	
	@GetMapping("/test2")
	public String getTest2() {
		return "forward:/sub2";
	}
	
	@GetMapping("/sub2")
	public String getSub2() {
		return "sub2";
	}
}
