package com.mnu.sample.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mnu.sample.domain.BoardPhotoDTO;
import com.mnu.sample.domain.PageSearchDTO;
import com.mnu.sample.service.BoardPhotoService;
import com.mnu.sample.util.PageIndex;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("BoardPhoto")
public class BoardPhotoController {
	//로그 출력용
	private static final Logger log =
			LoggerFactory.getLogger(BoardPhotoController.class);
	//서비스 주입
	@Autowired
	private BoardPhotoService boardPhotoService;
	
	//Get, Post 겸용 (검색 O, 페이징 O)
	@RequestMapping(value="board_list", method = {RequestMethod.GET, RequestMethod.POST})
	public String boardList(@ModelAttribute("page") int page, PageSearchDTO pageSearchDTO, Model model) {

		log.info("Board Call : board_list");
		
		int nowpage = page ; //넘어온 페이지 저장
		int maxlist = 10; //페이지당 글수
		int totpage = 1; //총 페이지수

		//총 글수 카운트
		int totcount = boardPhotoService.boardCount(pageSearchDTO.getSearch(), pageSearchDTO.getKey());
		
		// 총 페이지수 계산
		if(totcount % maxlist ==0)
			totpage = totcount / maxlist;
		else
			totpage = totcount / maxlist + 1;
				
		int offset = (nowpage - 1) * maxlist;
		
		//게시글 일련번호 출력용
		int listcount = totcount - ((nowpage-1) * maxlist);
		
		//페이지 시작번호(MySQL 사용시)
		//int startpage = (nowpage-1)*maxlist;
		//int listcount = totcount - startpage;//리스트에 일괄적으로 번호 부여시 사용

		pageSearchDTO.setOffset(offset);
		pageSearchDTO.setMaxlist(maxlist);
		
		List<BoardPhotoDTO> bList = boardPhotoService.boardList(pageSearchDTO);
		
		log.info("list :" + bList.size());
		
		String pageSkip = null;
		if(pageSearchDTO.getKey() != null) {
			pageSkip = PageIndex.pageListHan(nowpage, totpage, "board_list", maxlist, pageSearchDTO.getSearch(), pageSearchDTO.getKey());
		}else {
			pageSkip = PageIndex.pageList(nowpage, totpage, "board_list", maxlist);				
		}
		
		model.addAttribute("totcount", totcount);
		model.addAttribute("totpage", totpage);
		model.addAttribute("listcount", listcount);
		model.addAttribute("bList", bList);
		model.addAttribute("pageSkip", pageSkip);
		
		return "BoardPhoto/board_list";

		
	}

	
	//글 등록 폼
	@GetMapping("board_write")
	public String boardWrite(@ModelAttribute("page") int page) {
		return "BoardPhoto/board_write";
	}
	
	//글 등록처리
	@PostMapping("board_write")
	public String boardWritePro(@ModelAttribute("page") int page, BoardPhotoDTO boardPhotoDTO) {
		int row = boardPhotoService.boardWrite(boardPhotoDTO);
		return "redirect:board_list?page=" + page;
		//return "redirect:/"; //index로 이동시
	}
	
	//상세보기(view)
	@GetMapping("board_view")
	public String boardView(@ModelAttribute("page") int page, 
										@RequestParam("idx") int idx, Model model, HttpServletRequest request, HttpServletResponse response) {
		
		model.addAttribute("board", boardPhotoService.boardView(idx, request, response));
		return "BoardPhoto/board_view";
	}
	
	//수정 폼
	@GetMapping("board_modify")
	public String boardModify(@ModelAttribute("page") int page, @RequestParam("idx") int idx , Model model) {
		
		model.addAttribute("board", boardPhotoService.boardModify(idx));
		return "BoardPhoto/board_modify";
	}

	//수정 처리
	@PostMapping("board_modify")
	public String boardModifyPro(@ModelAttribute("page") int page, BoardPhotoDTO boardPhotoDTO, Model model) {
		
		model.addAttribute("row", boardPhotoService.boardModifyPro(boardPhotoDTO));
		return "BoardPhoto/board_modify_pro";
	}

	//삭제폼
	@GetMapping("board_delete")
	public String boardDelete(@ModelAttribute("page") int page, @ModelAttribute("idx") int idx) {
		return "BoardPhoto/board_delete";
	}

	//삭제처리
	@PostMapping("board_delete")
	public String boardDeletePro(@ModelAttribute("page") int page, BoardPhotoDTO boardPhotoDTO, Model model) {
		
		model.addAttribute("row", boardPhotoService.boardDelete(boardPhotoDTO));
		return "BoardPhoto/board_delete_pro";
	}

}
