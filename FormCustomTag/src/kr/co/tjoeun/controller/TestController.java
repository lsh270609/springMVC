package kr.co.tjoeun.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import kr.co.tjoeun.beans.UserInfoBean;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String test1(@ModelAttribute("userInfo") UserInfoBean bean, Model model) {
		ArrayList<String> strList = new ArrayList<String>();
		model.addAttribute("strList", strList);
		
		bean.setUserName("sname");
		bean.setUserId("sid");
		bean.setUserPw("spw");
		bean.setUserAddr1("sUserAddr");
		bean.setUserAddr2("sUserAddr");
		bean.setUserPostCode("sPostCode");
		return "test1";
	}
	
	@GetMapping("/test2")
	public String test2(@ModelAttribute("userInfo") UserInfoBean bean) {
		bean.setUserName("sname");
		bean.setUserId("sid");
		bean.setUserPw("spw");
		bean.setUserAddr1("sUserAddr");
		bean.setUserAddr2("sUserAddr");
		bean.setUserPostCode("sPostCode");
		return "test2";	
	}
	
	@GetMapping("/test3")
	public String test3(@ModelAttribute("userInfo") UserInfoBean bean) {
		return "test3";	
	}
	
	@GetMapping("/test4")
	public String test4(@ModelAttribute("userInfo") UserInfoBean bean) {
		return "test4";	
	}
}
