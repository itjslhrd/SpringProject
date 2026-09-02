package com.mnu.mybatis.mappertest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mnu.mybatis.domain.DeptDTO;
import com.mnu.mybatis.domain.EmpDTO;
import com.mnu.mybatis.mapper.EmpMapper;

@SpringBootTest
public class EmpMapperTest {
	//로그 출력용 클래스 생성
	private static final Logger log =
			LoggerFactory.getLogger(EmpMapperTest.class);
	
	//주입
	@Autowired
	private EmpMapper mapper;
/*	
	//1. 테스트(empCount())
	@Test
	public void empCountTest() {
		log.info("사원수 : " + mapper.empCount());
	}
	
	//2. 테스트(empDnoCount())
	@Test
	public void empDnoCountTest() {
		int count = mapper.empDnoCount(10);
		log.info("부서번호 10인 사원수 : " + count);
	}
	
	//3. empList()
	@Test
	public void empListTest() {
		mapper.empList().forEach(emp->log.info(emp.toString()));
	}
	
/*	
	public void empListTest2() {
		List<EmpDTO> list = mapper.empList();
			
	}
	
	//4. empDnoList()
	@Test
	public void empDnoListTest() {
		mapper.empDnoList(10).forEach(emp->log.info(emp.toString()));
	}

	//5. 특정사원 검색
	@Test
	public void empEnoListTest() {
		log.info(mapper.empEnoList(7788).toString());
	}
	
	//6. 등록(deptWrite()
	@Test
	public void deptWriteTest() {
		DeptDTO dto = new DeptDTO();
		dto.setDno(50);
		dto.setDname("자재부");
		dto.setLoc("목포");
		
		int row = mapper.deptWrite(dto);
		log.info("결과 : " + row);
	}

	//7. 수정
	@Test
	public void deptUpdateTest() {
		DeptDTO dto = new DeptDTO();
		dto.setDno(50);
		dto.setDname("인사부");
		dto.setLoc("대전");
		
		int row = mapper.deptUpdate(dto);
		log.info("수정 결과 : " + row);
	}
*/
	//8. 삭제
	@Test
	public void deptDeleteTest() {
		int dno=50;
		log.info("삭제 결과 : " + mapper.deptDelete(dno));
	}
}
