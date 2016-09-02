package com.example.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("empdao")
@Transactional(
		isolation=Isolation.DEFAULT,		//격리: 트랜잭션 상호간 격리가 기본설정
		propagation=Propagation.REQUIRED,	//전파 : 트랜잭션 효력 범위를 다른 메소드까지 확장
		readOnly=false,						//읽기전용 : 기본값은 false
		timeout=10,							//시간제한 : 10초
		rollbackFor=RuntimeException.class	//(옵션):지정 클래스의 예외가 발생하면 roll-back 
		)
public class EmpDaoImpl implements EmpDao{

	private JdbcTemplate jdbc;
	private SimpleJdbcInsert jdbcInsert;
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		jdbc = new JdbcTemplate(dataSource);
		jdbcInsert = new SimpleJdbcInsert(dataSource)
						.withTableName("emp")
						.usingGeneratedKeyColumns("empno");
	}
	
	/*
	 * @PostConstruct
	 * public void init()
	 * {
	 *  	jdbcInsert = new SimpleJdbcInsert(dataSource)
						.withTableName("emp")
						.usingGeneratedKeyColumns("empno");
		}
	 */
	
	@Override
	public int insert(EmpVo emp) {
		String sql = "insert into emp(ename,sal) values(?,?)";
		int ret = jdbc.update(sql,new Object[]{emp.getEname(),emp.getSal()});
		return ret;
	}

	@Override
	public int update(EmpVo emp) {
		String sql = "update emp set ename=?, sal=? where empno =?";
		int ret =jdbc.update(sql,new Object[]{emp.getEname(),emp.getSal(),emp.getEmpno()});
		return ret;
	}

	@Override
	public int delete(int key) {
		String sql = "delete from emp where empno =?";
		int ret = jdbc.update(sql,new Object[]{key});
		return ret;
	}

	@Override
	public int count() {
		System.out.println("count");
		String sql="select count(1) from emp";
		return jdbc.queryForObject(sql,Integer.class);
	}

	@Override
	public EmpVo selectByKey(int key) {
		String sql = "select * from emp where empno=?";
		jdbc.queryForObject(sql,Integer.class);
		return null;
	}

	private RowMapper<EmpVo> rowMapper = new RowMapper<EmpVo>(){
		
		@Override
		public EmpVo mapRow(ResultSet rs,int idx) throws SQLException
		{
			EmpVo emp = new EmpVo();
			emp.setEmpno(rs.getInt("empno"));
			emp.setEname(rs.getString("ename"));
			emp.setSal(rs.getInt("sal"));
			return emp;
		}
	};
	
	@Override
	public List<EmpVo> selectByLimit(int skip, int size) {
		String sql = "select * from emp limit ?,?";
		return jdbc.query(sql, new Object[]{skip,size},rowMapper);
		// TODO Auto-generated method stub
		
	}

	@Override //upsert
	public EmpVo save(EmpVo emp) {
		// 칼럼명, 필드명이 같은것으로 자동으로 매핑 
		SqlParameterSource param = new BeanPropertySqlParameterSource(emp);
		if(emp.getEmpno() == 0)
		{
			//insert 작업을 SimpleJdbcInsert 가 대신 진행하고 디비가 자동 증가로 사용하는 키값을 리턴 
			Number key = jdbcInsert.executeAndReturnKey(param);
			emp.setEmpno(key.intValue());
		}
		else
		{
			this.update(emp);
		}
		return emp;
	}

	@Override
	public boolean insertMulti(List<EmpVo> emps) {
		for(EmpVo emp:emps)
		{
			if(insert(emp) != 1)
			{
				return false;
			}
		}
		throw new RuntimeException();
		
//		return true;
	}
	

}
