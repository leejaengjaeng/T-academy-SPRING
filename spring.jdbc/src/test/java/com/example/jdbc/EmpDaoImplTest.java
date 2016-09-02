package com.example.jdbc;

import static org.hamcrest.CoreMatchers.is; // 매처 라이브러리
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;			// 테스트 프레임워크

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class EmpDaoImplTest {

	/*
	 	ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
		EmpDao dao = context.getBean("empdao",EmpDao.class);
		int count = dao.count();
		System.out.println(count);
		
		List<EmpVo> emps = dao.selectByLimit(0, count);
		for(EmpVo emp : emps)
			System.out.println(emp);
	 */

	@Autowired
	private EmpDao dao;
	
	@Before
	public void setUp() throws Exception {
		
		System.out.println("@Before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("@After");
	}

	@Test
	@Transactional // 테스트 실행 후 롤백하여 원래 상태로 돌림
	public void testInsert() {
		EmpVo newEmp = new EmpVo();
		newEmp.setEname("통통");
		newEmp.setSal(0);
		int result = dao.insert(newEmp);
		System.out.println(result);
		assertEquals(result,1);
	}

	@Test
	public void save() {
		EmpVo newEmp = new EmpVo();
		newEmp.setEname("홍홍");
		newEmp.setSal(3939393);
		EmpVo result = dao.save(newEmp);
		System.out.println(result);
		assertThat(result.getEmpno(), is(not(0)));
	}

	
	@Test
	public void testUpdate() {
		EmpVo newEmp = new EmpVo();
		newEmp.setEname("홍홍");
		newEmp.setSal(3939393);
		newEmp.setEmpno(2);
		int result = dao.update(newEmp);
		System.out.println(result);
		assertEquals(result,1);
	}

	@Test
	public void testDelete() {
		dao.delete(3);
	}

	@Test
	public void testCount() {
		int count = dao.count();
		System.out.println(count);
		
		//단정, 매처 매서드를 사용하는 이유
		// 테스트코드 자체를 문장처럼 구성하여 설명서 역할을 하도록 
		//assertThat(count,is(8));
		assertThat(count,is(10));
	}
 
	@Test
	public void testSelectByKey() {
		EmpVo result = dao.selectByKey(4);
		System.out.println(result.toString());
		
	}

	@Test
	public void testSelectByLimit() {
		int count = dao.count();
		System.out.println(count);
		
		List<EmpVo> emps = dao.selectByLimit(0, count);
		for(EmpVo emp : emps)
			System.out.println(emp);
		
		assertEquals(count,emps.size());
	}

}
