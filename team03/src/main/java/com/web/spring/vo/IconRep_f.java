package com.web.spring.vo;

public class IconRep_f {
	private int ino;
	private String fname;
	private String path;
	private int pcode;
	public IconRep_f() {
		// TODO Auto-generated constructor stub
	}
	public IconRep_f(int ino, String fname, String path, int pcode) {
		this.ino = ino;
		this.fname = fname;
		this.path = path;
		this.pcode = pcode;
	}
	

	public IconRep_f(String fname, String path) {
		this.fname = fname;
		this.path = path;
	}
	public int getIno() {
		return ino;
	}
	public void setIno(int ino) {
		this.ino = ino;
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
	public int getPcode() {
		return pcode;
	}
	public void setPcode(int pcode) {
		this.pcode = pcode;
	}
	
}
