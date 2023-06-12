package kr.co.tjoeun.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class TestController {

	@GetMapping("/result")
	public String getTest1(HttpServletRequest request) {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String[] numbers = request.getParameterValues("numbers");
		
		request.setAttribute("num1", num1);
		request.setAttribute("num2", num2);
		request.setAttribute("numbers", numbers);
		int i = 0;
		for (String s : numbers) {
			System.out.println("numbers["+i+"] : "+s);
			i += 1;
		}
		return "result";
	}
	
	@PostMapping("/result")
	public String postTest1(HttpServletRequest request) {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String[] numbers = request.getParameterValues("numbers");
		
		request.setAttribute("num1", num1);
		request.setAttribute("num2", num2);
		int i = 0;
		if(numbers!=null) {
			for (String s : numbers) {
				System.out.println("numbers["+i+"] : "+s);
				i += 1;
			}
		}
		
		return "result";
	}
	
	@GetMapping("/test3")
	public String getTest3(WebRequest request) {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String[] numbers = request.getParameterValues("numbers");
		
		System.out.println(num1);
		System.out.println(num2);

		int i = 0;
		for (String s : numbers) {
			System.out.println("numbers["+i+"] : "+s);
			i += 1;
		}
		return "result";
	}
	
	@GetMapping("/test4/{num1}/{num2}/{num3}")
	public String getTest4(@PathVariable String num1, 
						   @PathVariable String num2,
						   @PathVariable String num3) {
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		
		return "result";
	}
	
	@GetMapping("/test5/{num1}/{num2}/{num3}/{num4}")
	public String getTest5(@PathVariable int num1,
						   @PathVariable int num2,
						   @PathVariable int num3,
						   @PathVariable int num4) {
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		// System.out.println("num3+num4 : "+num3+num4);
		int sum = num3 + num4;
		System.out.println("num3+num4 : "+sum);
		
		return "result";
	}
	
	@GetMapping("/test6")
	public String getTest6(@RequestParam("num1") int number1,
						   @RequestParam("num2") int number2,
						   @RequestParam("numbers") int[] nums,
						   Model model) {
		System.out.println(number1);
		System.out.println(number2);
		int i = 0;
		for (int s : nums) {
			i += s;
		}
		int sum = number1 + number2 + i;
		model.addAttribute("num1", number1);
		model.addAttribute("num2", number2);
		
		System.out.println(sum);
		return "result";
	}
	
	@GetMapping("/test7")
	public String getTest7(@RequestParam int num1,
						   @RequestParam int[] numbers,
						   Model model) {
		System.out.println(num1);
		int i = 0;
		for (int s : numbers) {
			i += s;
		}
		int sum = num1 + i + numbers[0];
		model.addAttribute("num1", num1);
		
		System.out.println(sum);
		return "result";
	}
	
	// 넘어오지 않은 값(@RequestParam int num3)을 받는 경우
	@GetMapping("/test8")
	public String getTest8(@RequestParam int num1,
						   @RequestParam int num2,
						   @RequestParam int num3, // error!
						   @RequestParam int[] numbers,
						   Model model) {
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		int i = 0;
		for (int s : numbers) {
			i += s;
		}
		int sum = num1 + num2 + num3 + i;
		
		System.out.println(sum);

		model.addAttribute("num1", num1);
		model.addAttribute("num2", num2);
		model.addAttribute("num3", num3);
		return "result";
	}
	
	// 넘어오지 않은 값(@RequestParam int num3)을 받는 경우 + required
	@GetMapping("/test9")
	public String getTest9(@RequestParam int num1,
						   @RequestParam(required=false) int num2,
						   // @RequestParam(required=false) int num3,	// error! null 을 숫자로 형변환 시도 -> 오류 발생
						   @RequestParam(required=false) String num4,
						   @RequestParam int[] numbers,
						   Model model) {
		System.out.println(num1);
		System.out.println(num2);
		//System.out.println(num3);
		System.out.println(num4);
		int i = 0;
		for (int s : numbers) {
			i += s;
		}
	/*
	 * int sum = num1 + num2 + num3 + i; System.out.println(sum);
	 */
		
		model.addAttribute("num1", num1);
		model.addAttribute("num2", num2);
		// model.addAttribute("num3", num3);
		return "result";
	}
	
	// 넘어오지 않은 값(@RequestParam int num3)을 받는 경우 + required
	@GetMapping("/test10")
	public String getTest10(@RequestParam int num1,
						   @RequestParam(required=false) int num2,
						   @RequestParam(defaultValue="1") int num3,	
						   @RequestParam(required=false) String num4,
						   @RequestParam int[] numbers,
						   Model model) {
			System.out.println(num1);
			System.out.println(num2);
			System.out.println(num3);
			System.out.println(num4);
			int i = 0;
			for (int s : numbers) {
				i += s;
		}
	
	    int sum = num1 + num2 + num3 + i; System.out.println(sum);
	 
		
		model.addAttribute("num1", num1);
		model.addAttribute("num2", num2);
		model.addAttribute("num3", num3);
		return "result";
	}
}
