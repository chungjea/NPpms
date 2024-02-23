package com.web.spring.vo;

//com.web.spring.vo.ProjectCnt
public class ProjectCnt {
	private String status;
	private int cnt;
	public ProjectCnt() {
		// TODO Auto-generated constructor stub
	}
	public ProjectCnt(String status, int cnt) {
		this.status = status;
		this.cnt = cnt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
}

