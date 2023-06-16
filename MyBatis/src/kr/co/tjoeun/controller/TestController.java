package kr.co.tjoeun.controller;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.tjoeun.beans.TestBean;

@Controller
public class TestController {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@GetMapping("/inputData")
	public String inputData() {
		return "inputData";
	}
	
	@GetMapping("/readData")
	public String readData(Model model) {
		List<TestBean> list = sqlSessionTemplate.selectList("test_db.select_data");
		model.addAttribute("list", list);
		return "readData";
	}
	
	@PostMapping("/inputProcedure")
	public String inputProcedure(TestBean testBean) {
		sqlSessionTemplate.insert("test_db.insert_data", testBean);
		return "inputProcedure";
	}
	
	@GetMapping("/updateData")
	public String updateData(Model model) {
		List<TestBean> list = sqlSessionTemplate.selectList("test_db.select_data");
		model.addAttribute("list", list);
		return "readData";
	}
	
	@PostMapping("/updateProcedure")
	public String updateData(TestBean testBean) {
		sqlSessionTemplate.update("test_db.update_data", testBean);
		return "updateProcedure";
	}
}
