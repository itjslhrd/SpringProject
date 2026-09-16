package com.mnu.sample.domain;

import lombok.Data;

@Data
//@NoArgsConstructor  // 기본 생성자 강제 추가 (Spring, MyBatis, JPA 등이 객체 생성할 때 필수)
//@AllArgsConstructor // 모든 필드를 인자로 받는 생성자 추가
public class BoardPhotoDTO {
	private int idx;			//고유번호(키)
	private String name;		//작성자
	private String email;	//이메일
	private String subject;	//글 제목
	private String contents;	//글 내용
	private String pass;		//작성자 비번
	private String regdate;	//등록일자
	private int readcnt;		//조회수
}

