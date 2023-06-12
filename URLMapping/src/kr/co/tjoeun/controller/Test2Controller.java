package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Test2Controller {
	
	@RequestMapping(value="/test2", method=RequestMethod.GET)
	public String test2() {
		return "test2";
	}
}
