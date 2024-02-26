package com.web.spring.vo;

public class Metfile_f {
	private int metno;
	private String fname;
	private String path;
	private String fno;
	private int pcode;
	
	public Metfile_f() {
	}

	public Metfile_f(String fname, String path, String fno) {
		this.fname = fname;
		this.path = path;
		this.fno = fno;
	}

	public Metfile_f(int metno, String fname, String path) {
		this.metno = metno;
		this.fname = fname;
		this.path = path;
	}

	public Metfile_f(String fname, String path, String fno, int pcode) {
		this.fname = fname;
		this.path = path;
		this.fno = fno;
		this.pcode = pcode;
	}

	public Metfile_f(String fname, String fno) {
		this.fname = fname;
		this.fno = fno;
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

	public String getFno() {
		return fno;
	}

	public void setFno(String fno) {
		this.fno = fno;
	}

	public int getPcode() {
		return pcode;
	}

	public void setPcode(int pcode) {
		this.pcode = pcode;
	}
	
}
