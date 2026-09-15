package com.mnu.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("User")
public class UserController {
	//로그 출력용
	private static final Logger log =
			LoggerFactory.getLogger(UserController.class);

	//로그인 폼
	@GetMapping("user_login")
	public String userLogin(HttpSession session) {
		log.info("User Call : user_login");

	
		return "User/user_login";
	}
	
	//로그 아웃
	@GetMapping("user_logout")
	public String userLogout(HttpSession session) {
		log.info("User Call : user_logout");

	
		return "/";
	}

	//회원가입 폼
	@GetMapping("user_insert")
	public String userInsert() {
		log.info("User Call : userInsert");
		
		return "User/user_insert";
	}

	//마이페이지 
	@GetMapping("user_mypage")
	public String userMyPage() {
		log.info("User Call : userMyPage");
		
		return "User/user_mypage";
	}
	
}
