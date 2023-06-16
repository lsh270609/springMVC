package kr.co.tjoeun.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.tjoeun.beans.TestBean;

@RestController
public class RestAPIController {
	
	@GetMapping("/rest_controller")
	public ResponseEntity<ArrayList<TestBean>> rest_controller() {
		TestBean testBean1 = new TestBean("더조은", 123, 3.14, true);
		TestBean testBean2 = new TestBean("아이티", 456, 4.14, false);
		TestBean testBean3 = new TestBean("아카데미", 789, 5.14, true);
		
		ArrayList<TestBean> beanList = new ArrayList<TestBean>();
		beanList.add(testBean1);
		beanList.add(testBean2);
		beanList.add(testBean3);
		
		ResponseEntity<ArrayList<TestBean>> entity = new ResponseEntity<ArrayList<TestBean>>(beanList, HttpStatus.OK);
				
		return entity;
	}
}
