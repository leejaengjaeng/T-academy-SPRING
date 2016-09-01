package com.example.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public interface EmpDao  {
	
	public int insert(EmpVo emp);
	public int update(EmpVo emp);
	public void delete(int key);
	
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
