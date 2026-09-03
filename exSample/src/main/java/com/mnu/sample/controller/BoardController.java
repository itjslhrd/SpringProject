package com.mnu.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mnu.sample.domain.BoardDTO;
import com.mnu.sample.domain.PageSearchDTO;
import com.mnu.sample.service.BoardService;
import com.mnu.sample.util.PageIndex;

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
	
	//게시판 전체 리스트(검색 X, 페이징처리 O)
	@GetMapping("board_list_page")
	public String boardListPage(@ModelAttribute("page") int page, PageSearchDTO pageSearchDTO, Model model) {
		log.info("Board Call : board_list");
		
		int nowpage = page ; //넘어온 페이지 저장
		int maxlist = 10; //페이지당 글수
		int totpage = 1; //총 페이지수
		
		int totcount = boardService.boardCount();//총 글수
		// 총 페이지수 계산
		if(totcount % maxlist ==0)
			totpage = totcount / maxlist;
		else
			totpage = totcount / maxlist + 1;
				
		int offset = (nowpage - 1) * maxlist;
		
		//게시글 일련번호 출력용
		int listcount = totcount - ((nowpage-1) * maxlist);
		
		pageSearchDTO.setOffset(offset);
		pageSearchDTO.setMaxlist(maxlist);
		
		String pageSkip = PageIndex.pageList(nowpage, totpage, "board_list_page", maxlist);
		
		
		model.addAttribute("totcount", totcount);
		model.addAttribute("totpage", totpage);
		model.addAttribute("listcount", listcount);
		model.addAttribute("bList", boardService.boardListPage(pageSearchDTO));
		model.addAttribute("pageSkip", pageSkip);
		
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
	//글 등록 폼
	@GetMapping("board_write")
	public String boardWrite() {
		return "Board/board_write";
	}
	
	//글 등록처리
	@PostMapping("board_write")
	public String boardWritePro(BoardDTO boardDTO) {
		int row = boardService.boardWrite(boardDTO);
		return "redirect:board_list";
		//return "redirect:/"; //index로 이동시
	}
}
