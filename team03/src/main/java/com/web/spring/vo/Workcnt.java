package com.web.spring.vo;
//Allcnt,Proceeding,complete
//com.web.spring.vo.Workcnt
public class Workcnt {
	private int allcnt;
	private int proceeding;
	private int complete;
	public Workcnt() {
		// TODO Auto-generated constructor stub
	}
	public Workcnt(int allcnt, int proceeding, int complete) {
		this.allcnt = allcnt;
		this.proceeding = proceeding;
		this.complete = complete;
	}
	public int getAllcnt() {
		return allcnt;
	}
	public void setAllcnt(int allcnt) {
		this.allcnt = allcnt;
	}
	public int getProceeding() {
		return proceeding;
	}
	public void setProceeding(int proceeding) {
		this.proceeding = proceeding;
	}
	public int getComplete() {
		return complete;
	}
	public void setComplete(int complete) {
		this.complete = complete;
	}
	
}
