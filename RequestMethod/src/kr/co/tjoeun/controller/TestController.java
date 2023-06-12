package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	@RequestMapping(value="/test1", method=RequestMethod.GET)	// == @GetMappping("/test1")
	public String getTest1() {
		return "getTest1";
	}
	
	@RequestMapping(value="/test1", method=RequestMethod.POST)	// == @PostMappping("/test1")
	public String postTest1() {
		return "postTest1";
	}
	
	@GetMapping("/test4")
	public String getTest4() {
		return "test4";
	}
	
	@PostMapping("/test4")
	public String postTest4() {
		return "test4";
	}
	
	@GetMapping("/test5")
	public String getTest5() {
		return "test5";
	}
	
	@PostMapping("/test5")
	public String postTest5() {
		return "test5";
	}
	
	@RequestMapping(value="/test6", method= {RequestMethod.GET, RequestMethod.POST})
	public String test6() {
		return "test6";
	}
}
