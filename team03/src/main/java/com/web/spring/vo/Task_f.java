package com.web.spring.vo;

public class Task_f {
	private String id;
	private String start_date;
	private String end_date;
	private String text;
	private double progress;
	private int assignor;
	private String parent;
	private String pcode;
	public Task_f() {

	}
	public Task_f(String id, String start_date, String end_date, String text, double progress, int assignor,
			String parent, String pcode) {
		this.id = id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.text = text;
		this.progress = progress;
		this.assignor = assignor;
		this.parent = parent;
		this.pcode = pcode;
	}
	









	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParent() {
		return parent;
	}




	public void setParent(String parent) {
		this.parent = parent;
	}




	public String getPcode() {
		return pcode;
	}




	public void setPcode(String pcode) {
		this.pcode = pcode;
	}




	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public double getProgress() {
		return progress;
	}
	public void setProgress(double progress) {
		this.progress = progress;
	}
	public int getAssignor() {
		return assignor;
	}
	public void setAssignor(int assignor) {
		this.assignor = assignor;
	}

	
	
	
}
