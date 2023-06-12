package kr.co.tjoeun.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String getTest1() {
		return "test1";
	}
	
	@GetMapping("/test2")
	public String getTest2(HttpServletRequest request) {
		request.setAttribute("number1", request.getParameter("number1"));
		request.setAttribute("number2", request.getParameter("number2"));
		
		return "test2";
	}
	
	@GetMapping("/test3")
	public String getTest3(HttpServletRequest request, Model model) {
		model.addAttribute("number1", request.getParameter("number1"));
		model.addAttribute("number2", request.getParameter("number2"));
		
		return "test3";
	}
	
	@GetMapping("/test4")
	public ModelAndView getTest4(@RequestParam("number1") int number1, @RequestParam("number2") int number2, ModelAndView mv) {
		mv.addObject("number1", number1);
		mv.addObject("number2", number2);
		mv.setViewName("test4");
		
		return mv;
	}
}
