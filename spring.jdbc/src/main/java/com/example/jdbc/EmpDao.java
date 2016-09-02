package com.example.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public interface EmpDao  {
	
	public int insert(EmpVo emp); 
	public int update(EmpVo emp);
	public int delete(int key);
	public EmpVo save(EmpVo emp); //upsert = update + insert
	public boolean insertMulti(List<EmpVo> emps);
	public int count();
	public EmpVo selectByKey(int key);
	public List<EmpVo> selectByLimit(int skip,int size);
	/*
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	List getNames()
	{
		String sql = "select * from emp";
		return jdbcTemplate.queryForList(sql);
	}*/
}
