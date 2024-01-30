package com.web.spring.vo;

import java.util.Date;

public class NoticeFile_f {
	private int no;
	private String fname;
	private String path;
	private Date regdte;
	private Date uptdte;
	private String etc;

	public NoticeFile_f() {
		// TODO Auto-generated constructor stub
	}

	public NoticeFile_f(String fname, String path, String etc) {
		this.fname = fname;
		this.path = path;
		this.etc = etc;
	}

	public NoticeFile_f(int no, String fname, String path, Date regdte, Date uptdte, String etc) {
		this.no = no;
		this.fname = fname;
		this.path = path;
		this.regdte = regdte;
		this.uptdte = uptdte;
		this.etc = etc;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public Date getUptdte() {
		return uptdte;
	}

	public void setUptdte(Date uptdte) {
		this.uptdte = uptdte;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

}// NoticeFile_f{}
