package kr.co.tjoeun.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.tjoeun.beans.BeansData;
import kr.co.tjoeun.beans.BeansData2;
import kr.co.tjoeun.beans.BeansData3;

@Controller
public class TestController {
	
	@GetMapping("test1")
	public String getTest1(@RequestParam Map<String, String> map, HttpServletRequest request) {
		String strNum1 = map.get("num1");
		String strNum2 = map.get("num2");
		String strNumber = map.get("number");
		
		System.out.printf("num1 : %s\n", strNum1);
		System.out.printf("num2 : %s\n", strNum2);
		System.out.printf("strNumber : %s\n", strNumber);
		
		return "result";
	}
	
	@GetMapping("test2")
	public String getTest2(@RequestParam Map<String, String> map,
						   @RequestParam List<String> number,
						   HttpServletRequest request) {
		String strNum1 = map.get("num1");
		String strNum2 = map.get("num2");
		String numbersMap = map.get("number");

		System.out.printf("num1 : %s\n", strNum1);
		System.out.printf("num2 : %s\n", strNum2);
		System.out.printf("number : %s\n", numbersMap);
		System.out.println("-----------------------");
		
		System.out.println("--같은 이름으로 전달된 2개의 data--");
		int i = 0;
		for(String s : number) {
			System.out.printf("strNumber[%d] : %s\n", i, s);
			i++;
		}
		
		return "result";
	}
	
	@GetMapping("test3")
	public String getTest3(@RequestParam Map<String, String> map,
						   @RequestParam List<String> number,
						   HttpServletRequest request) {
		int strNum1 = Integer.parseInt(map.get("num1"));
		int strNum2 = Integer.parseInt(map.get("num2"));
		int numbersMap = Integer.parseInt(map.get("number"));

		System.out.printf("num1 : %d\n", strNum1);
		System.out.printf("num2 : %d\n", strNum2);
		System.out.printf("number : %d\n", numbersMap);
		System.out.println("-----------------------");
		
		System.out.println("--같은 이름으로 전달된 2개의 data--");
		int i = 0;
		for(String s : number) {
			System.out.printf("strNumber[%d] : %d\n", i, Integer.parseInt(s));
			i++;
		}
		
		return "result";
	}
	
	@GetMapping("test4")
	public String getTest4(@ModelAttribute BeansData bean1,
						   @ModelAttribute BeansData2 bean2,
						   @ModelAttribute BeansData3 bean3) {
		System.out.println("--BeansData--");
		System.out.printf("bean.num1 : %d\n", bean1.getNum1());
		System.out.printf("bean.num2 : %d\n", bean1.getNum2());
		int i = 0;
		for(int a : bean1.getNumber()) {
			System.out.printf("beanNumber[%d] : %d\n", i, a);
			i++;
		}
		
		System.out.println("--BeansData2--");
		System.out.printf("bean2.num1 : %d\n", bean2.getNum1());
		System.out.printf("bean2.num2 : %d\n", bean2.getNum2());
		int j = 0;
		for(int a : bean1.getNumber()) {
			System.out.printf("bean2Number[%d] : %d\n", j, a);
			j++;
		}
		
		System.out.println("--BeansData2--");
		System.out.printf("bean3.num1 : %d\n", bean3.getNum1());
		System.out.printf("bean3.num2 : %d\n", bean3.getNum2());
		int k = 0;
		for(int a : bean1.getNumber()) {
			System.out.printf("bean3Number[%d] : %d\n", k, a);
			k++;
		}
		
		return "result";
	}
	
	@GetMapping("test5")
	public String getTest5(BeansData bean1, BeansData2 bean2, BeansData3 bean3) {
		System.out.println("--BeansData--");
		System.out.printf("bean.num1 : %d\n", bean1.getNum1());
		System.out.printf("bean.num2 : %d\n", bean1.getNum2());
		int i = 0;
		for(int a : bean1.getNumber()) {
			System.out.printf("beanNumber[%d] : %d\n", i, a);
			i++;
		}
		
		System.out.println("--BeansData2--");
		System.out.printf("bean2.num1 : %d\n", bean2.getNum1());
		System.out.printf("bean2.num2 : %d\n", bean2.getNum2());
		int j = 0;
		for(int a : bean1.getNumber()) {
			System.out.printf("bean2Number[%d] : %d\n", j, a);
			j++;
		}
		
		System.out.println("--BeansData2--");
		System.out.printf("bean3.num1 : %d\n", bean3.getNum1());
		System.out.printf("bean3.num2 : %d\n", bean3.getNum2());
		int k = 0;
		for(int a : bean1.getNumber()) {
			System.out.printf("bean3Number[%d] : %d\n", k, a);
			k++;
		}
		
		return "result";
	}
}
