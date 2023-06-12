package kr.co.tjoeun.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.tjoeun.beans.BeanData;
import kr.co.tjoeun.beans.BeanKeyValue;

@Controller
public class TestController {
	@GetMapping("/test1")
	public String test1(BeanData bean, Model model) {
		// path="data*"
		bean.setData1("더조은학원");
		bean.setData2("자바웹개발");
		bean.setData3("풀스택");
		bean.setData4("Linux");
		
		String[] checkList = {"Spring과정" ,"데이터분석", "풀스택", "자바웹개발", "C언어"};
		bean.setData5(checkList);
		bean.setData6(checkList);
		bean.setData7(checkList);
		bean.setData8(checkList);
	
		// form:select form:option array
		String[] dataArr1 = {"데이터분석", "풀스택", "자바웹개발"};
		model.addAttribute("dataArr1", dataArr1);
		
		// form:select form:options ArrayList<String>
		ArrayList<String> dataList1 = new ArrayList<String>();
		dataList1.add("데이터분석");
		dataList1.add("풀스택");
		dataList1.add("자바웹개발");
		model.addAttribute("dataList1", dataList1);
		
		// form:select form:options ArrayList<BeankeyValue>
		BeanKeyValue key_bean1 = new BeanKeyValue();
		key_bean1.setKey("자바강의");
		key_bean1.setValue("Java");
		BeanKeyValue key_bean2 = new BeanKeyValue();
		key_bean2.setKey("파이썬강의");
		key_bean2.setValue("Python");
		BeanKeyValue key_bean3= new BeanKeyValue();
		key_bean3.setKey("리눅스강의");
		key_bean3.setValue("Linux");
		
		ArrayList<BeanKeyValue> dataList2 = new ArrayList<BeanKeyValue>();
		dataList2.add(key_bean1);
		dataList2.add(key_bean2);
		dataList2.add(key_bean3);
		model.addAttribute("dataList2", dataList2);
		
		
		// form:checkboxes array
		String[] dataArr2 = {"데이터분석", "풀스택", "자바웹개발", "포토샵"};
		model.addAttribute("dataArr2", dataArr2);
		
		return "test1";
	}
	
	@GetMapping("/test2")
	public String getTest2(BeanData bean, Model model) {
		// path="data7"
		String[] checkList = {"Spring과정" ,"데이터분석", "풀스택", "자바웹개발", "C언어"};
		bean.setData7(checkList);
		
		//form:checkboxes ArrayList<String>
		ArrayList<String> dataList1 = new ArrayList<String>();
		dataList1.add("데이터분석");
		dataList1.add("풀스택");
		dataList1.add("자바웹개발");
		dataList1.add("포토샵");
		model.addAttribute("dataList1", dataList1);
		
		return "test2";
	}
	
	@GetMapping("/test3")
	public String getTest3(BeanData bean, Model model) {
		// path="data8"
		String[] checkList = {"Spring과정" ,"데이터분석", "풀스택", "자바웹개발", "C언어"};
		bean.setData8(checkList);
		
		// form:checkboxes ArrayList<BeanKeyValue>
		BeanKeyValue key_bean1 = new BeanKeyValue();
		key_bean1.setKey("item1");
		key_bean1.setValue("포토샵");
		BeanKeyValue key_bean2 = new BeanKeyValue();
		key_bean2.setKey("item2");
		key_bean2.setValue("Spring과정");
		BeanKeyValue key_bean3= new BeanKeyValue();
		key_bean3.setKey("item3");
		key_bean3.setValue("C언어");
		
		ArrayList<BeanKeyValue> dataList2 = new ArrayList<BeanKeyValue>();
		dataList2.add(key_bean1);
		dataList2.add(key_bean2);
		dataList2.add(key_bean3);
		model.addAttribute("dataList2", dataList2);
		
		return "test3";
	}
	
	@GetMapping("/test4")
	public String getTest4(BeanData bean, Model model) {
		// path="data10"
		bean.setData10("풀스택");
		
		// form:radiobuttons array
		String[] dataArr1 = {"데이터분석", "풀스택", "자바웹개발"};
		model.addAttribute("dataArr1", dataArr1);
		return "test4";
	}
	
	@GetMapping("/test5")
	public String getTest5(BeanData bean, Model model) {
		// path="data11"
		bean.setData11("풀스택");
		
		// form:radiobuttons ArrayList<String>
		ArrayList<String> dataList1 = new ArrayList<String>();
		dataList1.add("데이터분석");
		dataList1.add("풀스택");
		dataList1.add("자바웹개발");
		model.addAttribute("dataList1", dataList1);
		return "test5";
	}
	
	@GetMapping("/test6")
	public String getTest6(BeanData bean, Model model) {
		// path="data12"
		bean.setData12("Python");
		
		// form:radiobuttons ArrayList<BeanKeyValue>
		BeanKeyValue key_bean1 = new BeanKeyValue();
		key_bean1.setKey("item1");
		key_bean1.setValue("Java");
		BeanKeyValue key_bean2 = new BeanKeyValue();
		key_bean2.setKey("item2");
		key_bean2.setValue("Python");
		BeanKeyValue key_bean3= new BeanKeyValue();
		key_bean3.setKey("item3");
		key_bean3.setValue("Linux");
		
		ArrayList<BeanKeyValue> dataList2 = new ArrayList<BeanKeyValue>();
		dataList2.add(key_bean1);
		dataList2.add(key_bean2);
		dataList2.add(key_bean3);
		model.addAttribute("dataList2", dataList2);
		
		return "test6";
	}
}