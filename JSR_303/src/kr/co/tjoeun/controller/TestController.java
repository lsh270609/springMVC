package kr.co.tjoeun.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.tjoeun.beans.TestBean1;

@Controller
public class TestController {
	@GetMapping("/inputData")
	public String getInputData(@ModelAttribute TestBean1 bean1) {
		return "inputData";
	}
	
	@PostMapping("/inputProcedure")
	public String postInputProcedure(@Valid TestBean1 bean1, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "inputData";
		} else {
			model.addAttribute("bean1", bean1);
			return "inputSuccess";
		}
	}
}
