package com.web.spring.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Commute_f {
	private int empno;
	private String ename;
	private int late;
	private int absence;
	private int annual;
	@DateTimeFormat(pattern = "yyyy-MM-dd:hh-MM-ss")
	private Date ALLTIME;
	private String status;
	public Commute_f() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getLate() {
		return late;
	}
	public void setLate(int late) {
		this.late = late;
	}
	public int getAbsence() {
		return absence;
	}
	public void setAbsence(int absence) {
		this.absence = absence;
	}
	public int getAnnual() {
		return annual;
	}
	public void setAnnual(int annual) {
		this.annual = annual;
	}
	public Date getALLTIME() {
		return ALLTIME;
	}
	public void setALLTIME(Date aLLTIME) {
		ALLTIME = aLLTIME;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Commute_f(int empno, String ename, int late, int absence, int annual, Date aLLTIME, String status) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.late = late;
		this.absence = absence;
		this.annual = annual;
		ALLTIME = aLLTIME;
		this.status = status;
	}
	
	
}
