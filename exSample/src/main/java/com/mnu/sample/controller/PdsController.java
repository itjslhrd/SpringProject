package com.mnu.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Pds")
public class PdsController {
	//로그 출력용
	private static final Logger log =
			LoggerFactory.getLogger(PdsController.class);

	// 자료실 리스트
	@GetMapping("pds_list")
	public String pdsList() {
		log.info("Pds Call : pds_list");
		
		return "Pds/pds_list";
	}

	// 등록 폼
	@GetMapping("pds_write")
	public String pdsWrite() {
		log.info("Pds Call : pds_write");
		
		return "Pds/pds_write";
	}

}
