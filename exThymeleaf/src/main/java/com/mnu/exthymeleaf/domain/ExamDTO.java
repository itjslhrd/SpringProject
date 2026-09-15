package com.mnu.exthymeleaf.domain;

import lombok.Data;

@Data
public class ExamDTO {
	private String name;//이름
	private boolean gender;//성별(true:남/false:여)
	private int age;//나이
}
