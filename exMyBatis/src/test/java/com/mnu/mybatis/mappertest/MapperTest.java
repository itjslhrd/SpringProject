package com.mnu.mybatis.mappertest;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mnu.mybatis.mapper.TestMapper;

@SpringBootTest
public class MapperTest {
	//로그 출력용
	private static final Logger log =
			LoggerFactory.getLogger(MapperTest.class);
	
	@Autowired
	private TestMapper mapper;
/*	
	@Test
	public void testGetTime() {
		log.info("클래스 : " + mapper.getClass().getName());
		log.info("오늘 날자는 : " + mapper.getTime());
	}
*/	
	
	@Test
	public void testGetTime2() {
		log.info("오늘 날자는 2 : " + mapper.getTime2());
	}

	/*
	@Test
	public void testMepCount() {
		log.info("사원수  : " + mapper.empCount());
	}
	*/
}
