package com.web.spring.vo;

import java.util.Date;

/*
 id NUMBER PRIMARY KEY,
	text varchar2(255) NOT null,
	start_date DATE NOT NULL,
	duration NUMBER NOT NULL,
	progress NUMBER NOT NULL,
	parent NUMBER NOT NULL
 * */
public class Data {
	private int id;
	private String start_date;
	private int duration;
	private double progress;
	private int parent;
	public Data() {
		// TODO Auto-generated constructor stub
	}
	public Data(int id, String start_date, int duration, double progress, int parent) {
		this.id = id;
		this.start_date = start_date;
		this.duration = duration;
		this.progress = progress;
		this.parent = parent;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public double getProgress() {
		return progress;
	}
	public void setProgress(double progress) {
		this.progress = progress;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	
	
}
