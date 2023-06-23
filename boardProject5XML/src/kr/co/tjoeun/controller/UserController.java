package kr.co.tjoeun.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.tjoeun.bean.UserBean;
import kr.co.tjoeun.service.UserService;
import kr.co.tjoeun.validator.UserValidator;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Resource(name = "loginUserBean")
	@Lazy
	private UserBean loginUserBean;
	
	@GetMapping("/login")
	public String login(@ModelAttribute("tmpLoginUserBean") UserBean userBean,
						@RequestParam(value="fail", defaultValue="false") boolean fail,
						Model model) {
		model.addAttribute("fail", fail);
		return "user/login";
	}
	
	@PostMapping("/login_procedure")
	public String loginProcedure(@Valid @ModelAttribute("tmpLoginUserBean") UserBean tmpLoginUserBean, BindingResult result) {
		if(result.hasErrors()) {
			return "user/login";
		}
		// 로그인 성공 시 처리
		userService.getLoginUserInfo(tmpLoginUserBean);
		if(loginUserBean.getUser_name() != null) {
			return "user/login_success";
		} else {
			return "user/login_fail";
		}
	}
	
	@GetMapping("/join")
	public String join(@ModelAttribute("joinUserBean") UserBean joinUserBean) {
		return "user/join";
	}
	
	@PostMapping("/join_procedure")
	public String joinProcedure(@Valid @ModelAttribute("joinUserBean") UserBean joinUserBean, BindingResult result) {
		if(result.hasErrors()) {
			return "user/join";
		}
		userService.insertUser(joinUserBean);
		return "user/join_success";
	}
	
	@GetMapping("/modify")
	public String modify() {
		return "user/modify";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "user/logout";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		UserValidator userValidator = new UserValidator();
		binder.addValidators(userValidator);
	}
}
