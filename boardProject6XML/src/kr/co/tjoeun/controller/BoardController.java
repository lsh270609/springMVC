package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@GetMapping("/main")
	public String boardMain() {
		return "board/main";
	}
	
	@GetMapping("/read")
	public String boardRead() {
		return "board/read";
	}
	
	@GetMapping("/write")
	public String boardWrite() {
		return "board/write";
	}
	
	@GetMapping("/modify")
	public String boardModify() {
		return "board/modify";
	}
	
	@GetMapping("/delete")
	public String boardDelete() {
		return "board/delete";
	}
}
