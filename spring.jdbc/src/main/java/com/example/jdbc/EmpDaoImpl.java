package com.example.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("empdao")
public class EmpDaoImpl implements EmpDao{

	private JdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		jdbc = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int insert(EmpVo emp) {
		
		return 0;
	}

	@Override
	public int update(EmpVo emp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(int key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int count() {
		String sql="select count(1) from emp";
		return jdbc.queryForInt(sql);
	}

	@Override
	public EmpVo selectByKey(int key) {
		// TODO Auto-generated method stub
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
	

}
