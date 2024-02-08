package com.web.spring.vo;

public class Apvfile_f {
	private int apvno;
	private String fname;
	private String path;
	private String fno;
	private int empno;
	
	public Apvfile_f() {
	}

	public Apvfile_f(String fname, String path) {
		this.fname = fname;
		this.path = path;
	}

	public Apvfile_f(String fname, String path, String fno) {
		this.fname = fname;
		this.path = path;
		this.fno = fno;
	}

	public Apvfile_f(String fname, String path, String fno, int empno) {
		this.fname = fname;
		this.path = path;
		this.fno = fno;
		this.empno = empno;
	}

	public Apvfile_f(int apvno, String fname, String path) {
		this.apvno = apvno;
		this.fname = fname;
		this.path = path;
	}

	public Apvfile_f(int apvno, String fname, String path, String fno) {
		this.apvno = apvno;
		this.fname = fname;
		this.path = path;
		this.fno = fno;
	}

	public int getApvno() {
		return apvno;
	}

	public void setApvno(int apvno) {
		this.apvno = apvno;
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

	public String getFno() {
		return fno;
	}

	public void setFno(String fno) {
		this.fno = fno;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}
	
}
