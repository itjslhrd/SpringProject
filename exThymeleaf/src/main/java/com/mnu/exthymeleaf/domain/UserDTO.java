package com.mnu.exthymeleaf.domain;

import lombok.Data;

@Data
public class UserDTO {
	private String name;
	private int score;
	
	public UserDTO(String name, int score) {
		this.name=name;
		this.score=score;
	}
}
