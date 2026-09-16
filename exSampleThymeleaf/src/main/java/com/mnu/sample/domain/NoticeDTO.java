package com.mnu.sample.domain;

import lombok.Data;

@Data
//@NoArgsConstructor  // 기본 생성자 강제 추가 (Spring, MyBatis, JPA 등이 객체 생성할 때 필수)
//@AllArgsConstructor // 모든 필드를 인자로 받는 생성자 추가
public class NoticeDTO {
	private int idx;
	private String adid;
	private String subject;
	private String contents;
	private String regdate;
	private int readcnt;
	
	
}
