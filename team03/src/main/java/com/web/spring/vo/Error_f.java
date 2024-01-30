package com.web.spring.vo;

public class Error_f {
	private int rownum;
	private int eno;
	private String content;
	private String status;
	private int wno;
	private int empno;
	private String pname;
	private String wname;
	public Error_f() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Error_f(int eno, String content, String status, int wno) {
		this.eno = eno;
		this.content = content;
		this.status = status;
		this.wno = wno;
	}


	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	
	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getWno() {
		return wno;
	}
	public void setWno(int wno) {
		this.wno = wno;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	
}
