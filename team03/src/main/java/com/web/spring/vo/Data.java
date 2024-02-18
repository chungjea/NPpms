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
	private long id;
	private String text;
	private String start_date;
	private int duration;
	private double progress;
	private long parent;
	public Data() {
		// TODO Auto-generated constructor stub
	}
	
	




	public Data(long id, String text, String start_date, int duration, double progress, long parent) {
		this.id = id;
		this.text = text;
		this.start_date = start_date;
		this.duration = duration;
		this.progress = progress;
		this.parent = parent;
	}






	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
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


	public long getParent() {
		return parent;
	}




	public void setParent(long parent) {
		this.parent = parent;
	}
	
	
	
}
