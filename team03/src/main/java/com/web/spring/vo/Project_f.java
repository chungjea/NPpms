package com.web.spring.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/*
projectcode  NUMBER PRIMARY KEY,
	projectteam varchar2(100),
	teammanger NUMBER ,
	projectname varchar2(500),
	projecttype varchar2(200),
	progress NUMBER DEFAULT 0,
	projectstatus varchar2(50)
 * */

//team03.vo.Project_f
public class Project_f {
	private int rownum;
	private int pcode;
	private String pname;
	private String startdte;
	private String enddte;
	private int empno;
	private String tname;
	private double progress;
	private String status;
	private String ptype;
	private String ttype;
	private String content;
	private MultipartFile reports;
	private String path;
	private int ino;
	private String ext;
	private String mgname;
	private List<Tmem_f> tmem;

	public Project_f() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	
	public Project_f(int rownum, int pcode, String pname, String startdte, String enddte, int empno, String tname,
			double progress, String status, String ptype, String ttype, String content, MultipartFile reports,
			String path, int ino, String ext) {
		super();
		this.rownum = rownum;
		this.pcode = pcode;
		this.pname = pname;
		this.startdte = startdte;
		this.enddte = enddte;
		this.empno = empno;
		this.tname = tname;
		this.progress = progress;
		this.status = status;
		this.ptype = ptype;
		this.ttype = ttype;
		this.content = content;
		this.reports = reports;
		this.path = path;
		this.ino = ino;
		this.ext = ext;
	}

	public List<Tmem_f> getTmem() {
		return tmem;
	}
	public void setTmem(List<Tmem_f> tmem) {
		this.tmem = tmem;
	}

	public String getMgname() {
		return mgname;
	}
	public void setMgname(String mgname) {
		this.mgname = mgname;
	}

	public int getIno() {
		return ino;
	}

	public void setIno(int ino) {
		this.ino = ino;
	}

	public String getExt() {
		return ext;
	}



	public void setExt(String ext) {
		this.ext = ext;
	}



	public String getPath() {
		return path;
	}



	public void setPath(String path) {
		this.path = path;
	}






	public MultipartFile getReports() {
		return reports;
	}



	public void setReports(MultipartFile reports) {
		this.reports = reports;
	}



	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	public String getTtype() {
		return ttype;
	}

	public void setTtype(String ttype) {
		this.ttype = ttype;
	}
	
	public int getPcode() {
		return pcode;
	}
	public void setPcode(int pcode) {
		this.pcode = pcode;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
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
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	
	public double getProgress() {
		return progress;
	}

	public void setProgress(double progress) {
		this.progress = progress;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	
	
}
