package kr.co.tjoeun.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.tjoeun.beans.TestBean1;
import kr.co.tjoeun.validator.TestBean1Validator;

@Controller
public class TestController {
	
	// Validator 등록하기
	@InitBinder
	protected void initBinder(WebDataBinder binder){
		TestBean1Validator validator1 = new TestBean1Validator();
		binder.addValidators(validator1);
		// binder.addValidators(validator1, validator2, ... );
	}
	
	@GetMapping("/inputData")
	public String inputData(@ModelAttribute TestBean1 bean1) {
		return "inputData";
	}
	
	@PostMapping("/inputProcedure")
	public String inputProcedure(@Valid TestBean1 bean1, BindingResult result) {
		if(result.hasErrors()) {
			return "inputData";
		} else {
			return "inputSuccess";
		}
	}

	
}
