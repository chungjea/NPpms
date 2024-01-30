package com.web.spring.vo;

public class Apvfile_f {
	private int apvno;
	private String fname;
	private String path;
	
	public Apvfile_f() {
	}

	public Apvfile_f(String fname, String path) {
		this.fname = fname;
		this.path = path;
	}

	public Apvfile_f(int apvno, String fname, String path) {
		this.apvno = apvno;
		this.fname = fname;
		this.path = path;
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
	
}
