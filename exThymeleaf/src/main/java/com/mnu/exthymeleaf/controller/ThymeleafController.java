package com.mnu.exthymeleaf.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mnu.exthymeleaf.domain.DeptDTO;
import com.mnu.exthymeleaf.domain.UserDTO;

@Controller
public class ThymeleafController {
	//로그 출력용
	private static final Logger log =
			LoggerFactory.getLogger(ThymeleafController.class);
	
	@GetMapping("/")
	public String mainIndex() {
		return "index";
	}
	
	@GetMapping("Board/board_list")
	public String boardList() {
		return "Board/board_list";
	}
	
	//실습 1 (표현식 ${})
	@GetMapping("exam01")
	public String exam01(Model model) {
		log.info("Call : exam01");
		model.addAttribute("name","홍길동" );
		model.addAttribute("score",99);
		
		return "exam01";
	}
	
	//실습2 DTO 출력
	@GetMapping("exam02")
	public String exam02(Model model) {
		log.info("Call : exam02");
		DeptDTO deptDTO = new DeptDTO();
		deptDTO.setDno(10);
		deptDTO.setDname("인사과");
		deptDTO.setLoc("목포");
		
		model.addAttribute("deptDTO", deptDTO);
		return "exam02";
	}
	
	//실습3 DTO 출력(table)
	@GetMapping("exam03")
	public String exam03(Model model) {
		log.info("Call : exam03");
		DeptDTO deptDTO = new DeptDTO();
		deptDTO.setDno(10);
		deptDTO.setDname("인사과");
		deptDTO.setLoc("목포");
		
		model.addAttribute("deptDTO", deptDTO);
		return "exam03";
	}
	//실습4(ExamDTO) 출력
	@RequestMapping("exam04")
	public String exam04(Model model) {
		log.info("Call : exam04");
		//ExamDTO dto = new ExamDTO();
		model.addAttribute("id", "user01");
		model.addAttribute("name", "김학생");
		model.addAttribute("score", 95);
		model.addAttribute("gender", false);
		
		return "exam04";
		
	}
	//실습5(List>
	@RequestMapping("exam05")
	public String exam05(Model model) {
		log.info("Call : exam05");
		List<DeptDTO> list = new ArrayList();
		DeptDTO dto = new DeptDTO();
		dto.setDno(10);
		dto.setDname("영업부");
		dto.setLoc("목포");
		list.add(dto);
		
		dto = new DeptDTO();
		dto.setDno(20);
		dto.setDname("경영부");
		dto.setLoc("대전");
		list.add(dto);
		
		dto = new DeptDTO();
		dto.setDno(30);
		dto.setDname("회계부");
		dto.setLoc("서울");
		list.add(dto);
		
		model.addAttribute("list", list);
		return "exam05";
	}

	//실습6(List>
	@RequestMapping("exam06")
	public String exam06(Model model) {
		log.info("Call : exam06");
		List<DeptDTO> list = new ArrayList();
		DeptDTO dto = new DeptDTO();
		dto.setDno(10);
		dto.setDname("영업부");
		dto.setLoc("목포");
		list.add(dto);
		
		dto = new DeptDTO();
		dto.setDno(20);
		dto.setDname("경영부");
		dto.setLoc("대전");
		list.add(dto);
		
		dto = new DeptDTO();
		dto.setDno(30);
		dto.setDname("회계부");
		dto.setLoc("서울");
		list.add(dto);
		
		model.addAttribute("list", list);
		return "exam06";
	}

	//실습7(Map)
	@RequestMapping("exam07")
	public String exam07(Model model) {
		log.info("Call : exam0");
		List<UserDTO> listA = new ArrayList();
		listA.add(new UserDTO("김학생", 90));
		listA.add(new UserDTO("이학생", 80));
		
		List<UserDTO> listB = new ArrayList();
		listB.add(new UserDTO("김학생", 88));
		listB.add(new UserDTO("이학생", 77));
		
		Map<String,List<UserDTO>> map = new HashMap<>();
		map.put("A001", listA);
		map.put("B001", listB);
		
		model.addAttribute("map", map);
		
		return "exam07";
	}
}
