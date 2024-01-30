package com.web.spring.vo;

import java.sql.Timestamp;


public class Emp_master_f {
	private int empno;
	private String ename;
	private String egrade;
	private int deptno;
	private String dname;
	private String hiredate;
	private int salary;
	private int incentive;
	private Timestamp lastfix;
	private int panaltytot;
	private String passwd;
	public Emp_master_f() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Emp_master_f(int empno, String ename, String egrade, int deptno, String dname, String hiredate, int salary,
			int incentive, Timestamp lastfix, int panaltytot, String passwd) {
		this.empno = empno;
		this.ename = ename;
		this.egrade = egrade;
		this.deptno = deptno;
		this.dname = dname;
		this.hiredate = hiredate;
		this.salary = salary;
		this.incentive = incentive;
		this.lastfix = lastfix;
		this.panaltytot = panaltytot;
		this.passwd = passwd;
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
	public String getEgrade() {
		return egrade;
	}
	public void setEgrade(String egrade) {
		this.egrade = egrade;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getIncentive() {
		return incentive;
	}
	public void setIncentive(int incentive) {
		this.incentive = incentive;
	}
	public Timestamp getLastfix() {
		return lastfix;
	}
	public void setLastfix(Timestamp lastfix) {
		this.lastfix = lastfix;
	}
	public int getPanaltytot() {
		return panaltytot;
	}
	public void setPanaltytot(int panaltytot) {
		this.panaltytot = panaltytot;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
	
}
