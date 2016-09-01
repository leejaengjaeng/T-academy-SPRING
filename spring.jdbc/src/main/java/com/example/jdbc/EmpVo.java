package com.example.jdbc;

public class EmpVo {

	private int empno;
	private String ename;
	private int sal;

	public EmpVo() {
		// TODO Auto-generated constructor stub
	}

	public EmpVo(int empno, String ename, int sal) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
	}

	@Override
	public String toString()
	{
		return "{"+empno+","+ename+","+sal+"}";
	}
	
	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}
}
