package kr.co.tjoeun.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.tjoeun.beans.TestBean1;

@Controller
public class TestController {
	@GetMapping("/inputData")
	public String getInputData(TestBean1 bean1) {
		return "inputData";
	}
	
	@PostMapping("/inputProcedure")
	public String postInputProcedure(@Valid TestBean1 bean1, BindingResult result) {
		if(result.hasErrors()) {
			return "inputData";
		} else {
			return "inputSuccess";
		}
	}
}
