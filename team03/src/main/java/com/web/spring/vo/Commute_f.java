package com.web.spring.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Commute_f {
	private int empno;
	private String ename;
	private int late;
	private int absence;
	private int annual;
	@DateTimeFormat(pattern = "yyyy-MM-dd:HH-MM-SS")
	private Date starttime;
	private Date endtime;
	private Date overtime;
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
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public Date getOvertime() {
		return overtime;
	}
	public void setOvertime(Date overtime) {
		this.overtime = overtime;
	}
	public Commute_f(int empno, String ename, int late, int absence, int annual, Date starttime, Date endtime,
			Date overtime) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.late = late;
		this.absence = absence;
		this.annual = annual;
		this.starttime = starttime;
		this.endtime = endtime;
		this.overtime = overtime;
	}
	public Commute_f() {
		super();
		// TODO Auto-generated constructor stub
	}

}
