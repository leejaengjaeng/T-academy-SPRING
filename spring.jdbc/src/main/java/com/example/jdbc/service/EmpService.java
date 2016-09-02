package com.example.jdbc.service;

import java.util.List;

import com.example.jdbc.EmpVo;

public interface EmpService {

	public int insert(EmpVo emp); 
	public int update(EmpVo emp);
	public int delete(int key);
	public EmpVo save(EmpVo emp); //upsert = update + insert
	public boolean insertMulti(List<EmpVo> emps);
	public int count();
	public EmpVo selectByKey(int key);
	public List<EmpVo> selectByLimit(int skip,int size);
}
