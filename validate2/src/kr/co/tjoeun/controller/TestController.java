package kr.co.tjoeun.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.tjoeun.testBean.TestBean1;

@Controller
public class TestController {
	
	
	@GetMapping("/inputData")
	public String getInputData(@ModelAttribute TestBean1 bean1) {
		return "inputData";
	}
	
	@PostMapping("/inputResult")
	public String postInputResult(@Valid @ModelAttribute TestBean1 bean1,
								  BindingResult result) {
		System.out.printf("data1 : %s\n", bean1.getData1());
		System.out.printf("data2 : %s\n", bean1.getData2());
		
		System.out.printf("BindingResult : %s\n", result);
		
		if(result.hasErrors()) {
			//유효성 위반 결과 모두 가져옴
			for(ObjectError error : result.getAllErrors()) {
				System.out.printf("에러메세지 : %s\n", error.getDefaultMessage());
				System.out.printf("에러 코드 : %s\n", error.getCode());
				System.out.printf("object name : %s\n", error.getObjectName());
				System.out.println("---------------------------------------------");
				
				String[] errorCodes = error.getCodes();
				for (String code : errorCodes) {
					System.out.println(code);
				}
				if (errorCodes[0].equals("Size.testBean1.data1")) {
					System.out.println("data1 은 2 ~ 10 글자만 입력할 수 있습니다.");
				} else if (errorCodes[0].equals("Max.testBean1.data2")) {
					System.out.println("data2 는 100 이하의 값만 입력할 수 있습니다.");
				}
				System.out.println("*************************************");
			}
			return "inputData";
		} else {
			return "inputSuccess";	
		}
	}
}
