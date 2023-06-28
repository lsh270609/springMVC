package kr.co.tjoeun.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.tjoeun.bean.ContentBean;
import kr.co.tjoeun.bean.UserBean;
import kr.co.tjoeun.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Resource(name="loginUserBean")
	@Lazy
	private UserBean loginUserBean;
	
	@GetMapping("/main")
	public String boardMain(@RequestParam("board_info_idx") int board_info_idx,
							Model model) {
		String board_info_name = boardService.getBoardInfoName(board_info_idx);
		
		model.addAttribute("board_info_idx", board_info_idx);	// 글 작성 시 사용
		model.addAttribute("board_info_name", board_info_name);
		
		List<ContentBean> getContentBeanList = boardService.getContentList(board_info_idx);
		model.addAttribute("getContentBeanList", getContentBeanList);
		
		return "board/main";
	}
	
	@GetMapping("/read")
	public String boardRead(@RequestParam("board_info_idx") int board_info_idx,
							@RequestParam("content_idx") int content_idx,
							Model model) {		
		model.addAttribute("board_info_idx", board_info_idx);
		model.addAttribute("content_idx", content_idx);
		
		ContentBean contentDetail = boardService.getContentDetail(content_idx);
		model.addAttribute("contentDetail", contentDetail);
		
		model.addAttribute("loginUserBean", loginUserBean);
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
	
	@GetMapping("/not_writer")
	 public String notWriter() {
		 return "board/not_writer";
	 }
	
	@GetMapping("/modify")
	public String boardModify(@RequestParam("board_info_idx") int board_info_idx,
							  @RequestParam("content_idx") int content_idx,
							  Model model) {
		ContentBean modifyContentBean = boardService.getContentDetail(content_idx);
		modifyContentBean.setContent_idx(content_idx);
		modifyContentBean.setContent_board_idx(board_info_idx);
		model.addAttribute("modifyContentBean", modifyContentBean);
		
		return "board/modify";
	}
	
	@PostMapping("/modify_procedure")
	public String modifyProcedure(@Valid @ModelAttribute("modifyContentBean") ContentBean modifyContentBean,
			 					  BindingResult result) {
		if(result.hasErrors()) {
			return "board/modify";
		}
		boardService.updateContent(modifyContentBean);
		return "board/modify_success";
	}
	
	@GetMapping("/delete")
	public String boardDelete(@RequestParam("board_info_idx") int board_info_idx,
							  @RequestParam("content_idx") int content_idx,
							  Model model) {
		boardService.deleteContent(content_idx);
		model.addAttribute("board_info_idx", board_info_idx);
		return "board/delete";
	}
}
