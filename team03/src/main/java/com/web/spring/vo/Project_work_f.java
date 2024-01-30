package com.web.spring.vo;

public class Project_work_f {
	private int rownum;
	private int wno;
	private int refno;
	private String content;
	private String startdte;
	private String enddte;
	private int progress;
	private int pcode;
	private int empno;
	private String iname;
	private String pname;

	public Project_work_f() {
		// TODO Auto-generated constructor stub
	}
	public Project_work_f(int wno, int refno, String content, String startdte, String enddte, int progress, int pcode,
			int empno, String iname) {
		this.wno = wno;
		this.refno = refno;
		this.content = content;
		this.startdte = startdte;
		this.enddte = enddte;
		this.progress = progress;
		this.pcode = pcode;
		this.empno = empno;
		this.iname = iname;
	}
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public int getWno() {
		return wno;
	}
	public void setWno(int wno) {
		this.wno = wno;
	}
	public int getRefno() {
		return refno;
	}
	public void setRefno(int refno) {
		this.refno = refno;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getStartdte() {
		return startdte;
	}
	public void setStartdte(String startdte) {
		this.startdte = startdte;
	}
	public String getEnddte() {
		return enddte;
	}
	public void setEnddte(String enddte) {
		this.enddte = enddte;
	}
	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
	public int getPcode() {
		return pcode;
	}
	public void setPcode(int pcode) {
		this.pcode = pcode;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	
}
