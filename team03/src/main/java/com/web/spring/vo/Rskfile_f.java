package com.web.spring.vo;

public class Rskfile_f {
	private int rskno;
	private String fname;
	private String path;
	
	public Rskfile_f() {
	}

	public Rskfile_f(String fname, String path) {
		this.fname = fname;
		this.path = path;
	}

	public Rskfile_f(int rskno, String fname, String path) {
		this.rskno = rskno;
		this.fname = fname;
		this.path = path;
	}

	public int getRskno() {
		return rskno;
	}

	public void setRskno(int rskno) {
		this.rskno = rskno;
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
