package com.example.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.jdbc.*;

@Service("empService")
public class EmpServiceImpl implements EmpService{

	@Autowired
	@Qualifier("empdao")
	private EmpDaoImpl empDao;
	
	@Override
	public int insert(EmpVo emp) {
		return empDao.insert(emp);
		
	}

	@Override
	public int update(EmpVo emp) {
		return empDao.update(emp);
	}

	@Override
	public int delete(int key) {
		return empDao.delete(key);
	}

	@Override
	public EmpVo save(EmpVo emp) {
		return empDao.save(emp);
	}

	@Override
	public boolean insertMulti(List<EmpVo> emps) {
		return empDao.insertMulti(emps);
	}

	@Override
	public int count() {
		System.out.println("Emp count");
		
		return empDao.count();
	}

	@Override
	public EmpVo selectByKey(int key) {
		return empDao.selectByKey(key);
	}

	@Override
	public List<EmpVo> selectByLimit(int skip, int size) {
		return empDao.selectByLimit(skip, size);
	}
	
	
}
