package kr.co.tjoeun.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.tjoeun.bean.ContentBean;
import kr.co.tjoeun.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/main")
	public String boardMain(@RequestParam("board_info_idx") int board_info_idx,
							Model model) {
		model.addAttribute("board_info_idx", board_info_idx);
		ArrayList<ContentBean> getContentBeanList = boardService.selectContent(board_info_idx);
		model.addAttribute("getContentBeanList", getContentBeanList);
		return "board/main";
	}
	
	@GetMapping("/read")
	public String boardRead() {
		return "board/read";
	}
	
	@GetMapping("/write")
	public String boardWrite(@RequestParam("board_info_idx") int board_info_idx,
							 @ModelAttribute("writeContentBean") ContentBean writeContentBean) {
		writeContentBean.setContent_board_idx(board_info_idx);
		return "board/write";
	}
	
	@PostMapping("/write_procedure")
	public String writeProcedure(@Valid @ModelAttribute("writeContentBean") ContentBean writeContentBean,
								 BindingResult result) {
		if(result.hasErrors()) {
			return "board/write";
		}
		boardService.insertContent(writeContentBean);
		return "board/write_success";
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
