package com.web.spring.vo;

public class Task_f {
	private long id;
	private String startdte;
	private String enddte;
	private String text;
	private double progress;
	private int assignor;
	private String parent;
	private String pcode;
	public Task_f() {

	}
	public Task_f(long id, String startdte, String enddte, String text, double progress, int assignor, String parent,
			String pcode) {
		super();
		this.id = id;
		this.startdte = startdte;
		this.enddte = enddte;
		this.text = text;
		this.progress = progress;
		this.assignor = assignor;
		this.parent = parent;
		this.pcode = pcode;
	}

	public String getEnddte() {
		return enddte;
	}
	public void setEnddte(String enddte) {
		this.enddte = enddte;
	}
	public String getStartdte() {
		return startdte;
	}
	public void setStartdte(String startdte) {
		this.startdte = startdte;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
