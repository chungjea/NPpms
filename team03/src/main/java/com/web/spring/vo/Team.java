package com.web.spring.vo;

public class Team {
	private int pcode;
	private int member;
	private int empno;
	private String ename;
	private String dname;
	private String name;
	
	public Team() {
	}

	public Team(int pcode, int member, String name) {
		this.pcode = pcode;
		this.member = member;
		this.name = name;
	}

	public int getPcode() {
		return pcode;
	}

	public void setPcode(int pcode) {
		this.pcode = pcode;
	}

	public int getMember() {
		return member;
	}

	public void setMember(int member) {
		this.member = member;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}
	
}
