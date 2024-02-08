package com.web.spring.vo;

import java.util.Date;

public class sal_f {
	private int empno;
	private String ename;
	private String egrade;
	private int salary;
	private int incentive;
	private int panalty;
	private Date lastfix;
	private String dname;
	public sal_f() {
		super();
		// TODO Auto-generated constructor stub
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
	public int getPanalty() {
		return panalty;
	}
	public void setPanalty(int panalty) {
		this.panalty = panalty;
	}
	public Date getLastfix() {
		return lastfix;
	}
	public void setLastfix(Date lastfix) {
		this.lastfix = lastfix;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public sal_f(int empno, String ename, String egrade, int salary, int incentive, int panalty, Date lastfix,
			String dname) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.egrade = egrade;
		this.salary = salary;
		this.incentive = incentive;
		this.panalty = panalty;
		this.lastfix = lastfix;
		this.dname = dname;
	}
	
}
