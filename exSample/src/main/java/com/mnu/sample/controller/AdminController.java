package com.mnu.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Admin")
public class AdminController {
	//로그 출력용
	private static final Logger log =
			LoggerFactory.getLogger(AdminController.class);

	//공지사항 리스트
	@GetMapping("admin_login")
	public String adminLogin() {
		log.info("Admin Call : admin_login");
		
		return "Admin/admin_login";
	}

}
