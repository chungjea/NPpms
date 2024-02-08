package com.web.spring.vo;

import java.util.Date;

public class File_f {
	private int no;
	private String page;
	private int bno;
	private String fname;
	private String path;
	private Date regdte;
	private String fno;
	private int auth;
	private int empno;
	private int deptno;
	
	public File_f() {
	}

	public File_f(int no, String page, int bno, String fname, String path, Date regdte, String fno, int auth) {
		this.no = no;
		this.page = page;
		this.bno = bno;
		this.fname = fname;
		this.path = path;
		this.regdte = regdte;
		this.fno = fno;
		this.auth = auth;
	}

	public File_f(int no, String page, int bno, String fname, String path, Date regdte, String fno, int auth, int empno,
			int deptno) {
		this.no = no;
		this.page = page;
		this.bno = bno;
		this.fname = fname;
		this.path = path;
		this.regdte = regdte;
		this.fno = fno;
		this.auth = auth;
		this.empno = empno;
		this.deptno = deptno;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getRegdte() {
		return regdte;
	}

	public void setRegdte(Date regdte) {
		this.regdte = regdte;
	}

	public String getFno() {
		return fno;
	}

	public void setFno(String fno) {
		this.fno = fno;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
}
