package com.web.spring.vo;

public class IconRep_f {
	private int ino;
	private String fname;
	private String path;
	private int pcode;
	private String ext;
	public IconRep_f() {
		// TODO Auto-generated constructor stub
	}
	
	

	public IconRep_f(String fname, String path, String ext) {
		this.fname = fname;
		this.path = path;
		this.ext = ext;
	}



	public IconRep_f(int ino, String fname, String path, int pcode, String ext) {
		this.ino = ino;
		this.fname = fname;
		this.path = path;
		this.pcode = pcode;
		this.ext = ext;
	}



	public String getExt() {
		return ext;
	}



	public void setExt(String ext) {
		this.ext = ext;
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
