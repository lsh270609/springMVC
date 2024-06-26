package kr.co.tjoeun.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.tjoeun.beans.TestBean1;
import kr.co.tjoeun.beans.TestBean2;
import kr.co.tjoeun.beans.TestBean3;
import kr.co.tjoeun.beans.TestBean4;

@Controller
public class TestController {
	
	//byType
	@Autowired
	TestBean1 applicationBean1;
	
	//byName
	@Resource(name="applicationBean2")
	TestBean2 applicationBean2;
	
	//byType
	@Autowired
	TestBean3 applicationBean3;
	
	//byName
	@Resource(name="applicationBean4")
	TestBean4 applicationBean4;
	
	@GetMapping("/test1")
	public String getTest1() {
		applicationBean1.setData1("data1");
		applicationBean1.setData2("data2");
		applicationBean2.setData3("data3");
		applicationBean2.setData4("data4");
		applicationBean3.setData5("data5");
		applicationBean3.setData6("data6");
		applicationBean4.setData7("data7");
		applicationBean4.setData8("data8");
		return "test1";
	}
	
	@GetMapping("/result1")
	public String getResult1(Model model) {
		model.addAttribute("applicationBean1", applicationBean1);
		model.addAttribute("applicationBean2", applicationBean2); 
		//model.addAttribute()으로 data 를 메모리에 올리면 request scope 에 저장됨 <- result1.jsp 에서 requestScope로 데이터 불러옴
		System.out.println("applicationBean1.data1 : "+applicationBean1.getData1());
		System.out.println("applicationBean1.data2 : "+applicationBean1.getData2());
		System.out.println("applicationBean2.data3 : "+applicationBean2.getData3());
		System.out.println("applicationBean2.data4 : "+applicationBean2.getData4());
		return "result1";
	}
	
	@GetMapping("/test2")
	public String getTest2() {
		applicationBean3.setData5("data5");
		applicationBean3.setData6("data6");
		applicationBean4.setData7("data7");
		applicationBean4.setData8("data8");
		return "test2";
	}
	
	@GetMapping("/result2")
	public String getResult2(Model model) {
		model.addAttribute("applicationBean3", applicationBean3);
		model.addAttribute("applicationBean4", applicationBean4); 
		//model.addAttribute()으로 data 를 메모리에 올리면 request scope 에 저장됨 <- result1.jsp 에서 requestScope로 데이터 불러옴
		System.out.println("applicationBean3.data5 : "+applicationBean3.getData5());
		System.out.println("applicationBean3.data6 : "+applicationBean3.getData6());
		System.out.println("applicationBean4.data7 : "+applicationBean4.getData7());
		System.out.println("applicationBean4.data8 : "+applicationBean4.getData8());
		return "result2";
	}
}
