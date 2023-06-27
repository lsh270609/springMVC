package kr.co.tjoeun.controller;

import javax.annotation.Resource;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.tjoeun.bean.UserBean;

@Controller
public class HomeController {
	
	@Resource(name="loginUserBean")
	@Lazy
	private UserBean loginUserBean;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		//System.out.println("home");

		System.out.println("loginUserBean : "+loginUserBean);
		return "redirect:/main";
	}
	
	@RequestMapping(value="/tjoeun", method=RequestMethod.GET)
	public String tjoeun() {
		System.out.println("tjoeun");
		return null;
	}
	
}





