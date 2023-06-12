package kr.co.tjoeun.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.tjoeun.beans.TestBeanByName;
import kr.co.tjoeun.beans.TestBeanByType;

@Controller
public class TestController {

	@Autowired
	TestBeanByType testBeanByType;
	
	@Resource(name="testBeanByName")
	TestBeanByName testBeanByName;
	
	@GetMapping("/test1")
	public String getTest1() {
		testBeanByType.setData1("JAVA");
		testBeanByType.setData2("PYTHON");
		testBeanByName.setData3("C++");
		testBeanByName.setData4("JAVASCRIPT");
		return "test1";
	}
	
	@GetMapping("/result1")
	public String getResult1(Model model) {
		System.out.println(testBeanByType.getData1());
		System.out.println(testBeanByType.getData2());
		System.out.println(testBeanByName.getData3());
		System.out.println(testBeanByName.getData4());
		model.addAttribute("testBeanByType", testBeanByType);
		
		return "result1";
	}
}
