package com.web.spring.vo;

import java.util.Date;



//empno,birth_date,email,pnumber,passwd,email,dname,ename,deptno,auth
//로그인 및 게시판외 페이지정보 공유용
public class Emp_pinfo_f {

	private int empno;
	private Date birth_date;
	private int pnumber;
	private String passwd;
	private String email;
	private String dname;
	private String ename;
	private int deptno;
	private String auth;
	private int lastone;
	public Emp_pinfo_f() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Emp_pinfo_f(int empno, Date birth_date, int pnumber, String passwd, String email, String dname, String ename,
			int deptno, String auth, int lastone) {
		super();
		this.empno = empno;
		this.birth_date = birth_date;
		this.pnumber = pnumber;
		this.passwd = passwd;
		this.email = email;
		this.dname = dname;
		this.ename = ename;
		this.deptno = deptno;
		this.auth = auth;
		lastone = lastone;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public Date getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	public int getPnumber() {
		return pnumber;
	}
	public void setPnumber(int pnumber) {
		this.pnumber = pnumber;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public int getlastone() {
		return lastone;
	}
	public void setlastone(int lastone) {
		lastone = lastone;
	}
	

}
