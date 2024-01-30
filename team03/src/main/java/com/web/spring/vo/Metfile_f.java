package com.web.spring.vo;

public class Metfile_f {
	private int metno;
	private String fname;
	private String path;
	
	public Metfile_f() {
	}

	public Metfile_f(String fname, String path) {
		this.fname = fname;
		this.path = path;
	}

	public Metfile_f(int metno, String fname, String path) {
		this.metno = metno;
		this.fname = fname;
		this.path = path;
	}

	public int getMetno() {
		return metno;
	}

	public void setMetno(int metno) {
		this.metno = metno;
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
