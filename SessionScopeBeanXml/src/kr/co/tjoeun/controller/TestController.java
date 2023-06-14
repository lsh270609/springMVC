package kr.co.tjoeun.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.tjoeun.beans.TestBeanByName;
import kr.co.tjoeun.beans.TestBeanByType;

@Controller
public class TestController {

	@Autowired
	@Lazy
	TestBeanByType testBeanByType;
	
	@Resource(name="testBeanByName")
	@Lazy
	TestBeanByName testBeanByName;
	
	@Autowired
	TestBeanByType testBeanByType2;
	
	@Resource(name="testBeanByName2")
	TestBeanByName testBeanByName2;
	
	@GetMapping("/test1")
	public String getTest1(Model model) {
		testBeanByType.setData1("JAVA");
		testBeanByType.setData2("PYTHON");
		testBeanByName.setData3("C++");
		testBeanByName.setData4("JAVASCRIPT");
		model.addAttribute("testBeanByType", testBeanByType);
		return "test1";
	}
	
	@GetMapping("/result1")
	public String getResult1() {
		System.out.println(testBeanByType.getData1());
		System.out.println(testBeanByType.getData2());
		System.out.println(testBeanByName.getData3());
		System.out.println(testBeanByName.getData4());
		
		return "result1";
	}
	
	@GetMapping("/test2")
	public String getTest2(Model model) {
		testBeanByType2.setData1("JAVA");
		testBeanByType2.setData2("PYTHON");
		testBeanByName2.setData3("C++");
		testBeanByName2.setData4("JAVASCRIPT");
		model.addAttribute("testBeanByType", testBeanByType);
		return "test2";
	}
	
	@GetMapping("/result2")
	public String getResult2() {
		System.out.println(testBeanByType2.getData1());
		System.out.println(testBeanByType2.getData2());
		System.out.println(testBeanByName2.getData3());
		System.out.println(testBeanByName2.getData4());
		
		return "result2";
	}
}
