package com.mnu.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("Notice")
public class NoticeController {
	//로그 출력용
	private static final Logger log =
			LoggerFactory.getLogger(NoticeController.class);

	//로그인 폼
	@GetMapping("notice_list")
	public String noticeList() {
		log.info("Notice Call : notice_list");

	
		return "Notice/notice_list";
	}
	
	
}
