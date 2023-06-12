package kr.co.tjoeun.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.tjoeun.beans.TestBeanByName;
import kr.co.tjoeun.beans.TestBeanByName2;
import kr.co.tjoeun.beans.TestBeanByType;
import kr.co.tjoeun.beans.TestBeanByType2;

@Controller
public class TestController {
	
	// Bean 을 type(클래스이름) 으로 주입받음
	@Autowired
	TestBeanByType testBeanByType;

	// Bean 을 (클래스이름) 으로 주입받음
	@Resource(name="testBeanByName")
	TestBeanByName testBeanByName;
	
	@Autowired
	TestBeanByType2 testBeanByType2;
	
	@Resource(name="testBeanByName2")
	TestBeanByName2 testBeanByName2;
	
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
		System.out.printf("testBeanByType.data1 : %s\n", testBeanByType.getData1());
		System.out.printf("testBeanByType.data2 : %s\n", testBeanByType.getData2());
		System.out.printf("testBeanByName.data3 : %s\n", testBeanByName.getData3());
		System.out.printf("testBeanByName.data4 : %s\n", testBeanByName.getData4());
		model.addAttribute("testBeanByType", testBeanByType);
		model.addAttribute("testBeanByName", testBeanByName);
		return "result1";
	}
	
	@GetMapping("/test2")
	public String getTest2() {
		testBeanByType2.setData5("JAVA");
		testBeanByType2.setData6("PYTHON");
		testBeanByName2.setData7("C++");
		testBeanByName2.setData8("JAVASCRIPT");
		return "test2";
	}
	
	@GetMapping("/result2")
	public String getResult2(Model model) {
		System.out.printf("testBeanByType2.data5 : %s\n", testBeanByType2.getData5());
		System.out.printf("testBeanByType2.data6 : %s\n", testBeanByType2.getData6());
		System.out.printf("testBeanByName2.data7 : %s\n", testBeanByName2.getData7());
		System.out.printf("testBeanByName2.data8 : %s\n", testBeanByName2.getData8());
		model.addAttribute("testBeanByType2", testBeanByType2);
		model.addAttribute("testBeanByName2", testBeanByName2);
		return "result2";
	}
	
	
}	
