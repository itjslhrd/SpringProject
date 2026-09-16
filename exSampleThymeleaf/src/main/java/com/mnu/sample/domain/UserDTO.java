package com.mnu.sample.domain;

import lombok.Data;

@Data
//@NoArgsConstructor  // 기본 생성자 강제 추가 (Spring, MyBatis, JPA 등이 객체 생성할 때 필수)
//@AllArgsConstructor // 모든 필드를 인자로 받는 생성자 추가
public class UserDTO {
	private String name;
	private String userid;
	private String passwd;
	private String tel;
	private String email;
	private String email1;
	private String email2;
	private String email3;

	private String first_time;
	private String last_time;
	private String gubun;//핸드폰인증 1, 이메일 인증2

}
