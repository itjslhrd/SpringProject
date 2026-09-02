package com.mnu.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mnu.sample.service.BoardService;

@Controller
@RequestMapping("Board")
public class BoardController {
	//로그 출력용
	private static final Logger log =
			LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService boardService;
	
	//게시판 전체 리스트(검색 X, 페이징처리 X)
	@GetMapping("board_list")
	public String boardList(Model model) {
		log.info("Board Call : board_list");
		model.addAttribute("totcount", boardService.boardCount());
		model.addAttribute("bList", boardService.boardList());
		
		return "Board/board_list";
	}
	
	//게시판 전체 리스트(검색 O, 페이징처리 X)
	@PostMapping("board_list")
	public String boardList(String search, String key, Model model) {
		log.info("Board Call : board_list");
		model.addAttribute("totcount", boardService.boardCountSearch(search, key));
		model.addAttribute("bList", boardService.boardListSearch(search, key));
		model.addAttribute("search", search);
		model.addAttribute("key", key);
		return "Board/board_list";
	}
/*	
	@RequestMapping(value="board_list", method= {RequestMethod.GET, RequestMethod.POST})
	public String boardList(String search, String key) {

		return "";
	}
*/	
}
