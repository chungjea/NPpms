package com.web.spring.vo;

public class Chatroom_f {
	
	private int crno;
	private String crname;
	private int userid;
	private String username;
	private int[] chatter;
	
	public Chatroom_f() {
	}

	public Chatroom_f(String crname, int userid, String username) {
		this.crname = crname;
		this.userid = userid;
		this.username = username;
	}

	public Chatroom_f(int crno, String crname, int userid, String username) {
		this.crno = crno;
		this.crname = crname;
		this.userid = userid;
		this.username = username;
	}

	public Chatroom_f(int crno, String crname, int userid, String username, int[] chatter) {
		this.crno = crno;
		this.crname = crname;
		this.userid = userid;
		this.username = username;
		this.chatter = chatter;
	}

	public int getCrno() {
		return crno;
	}

	public void setCrno(int crno) {
		this.crno = crno;
	}

	public String getCrname() {
		return crname;
	}

	public void setCrname(String crname) {
		this.crname = crname;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int[] getChatter() {
		return chatter;
	}

	public void setChatter(int[] chatter) {
		this.chatter = chatter;
	}
	
}
