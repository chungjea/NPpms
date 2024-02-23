package com.web.spring.vo;

public class MailSender {
	private String email; //receiver
	private String sender;
	private String title; //제목
	private int empno; //사번(불러온사번)
	private String password; //비번(제작된비번)
	public MailSender() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public MailSender(String email, String sender, String title, int empno, String password) {
		super();
		this.email = email;
		this.sender = sender;
		this.title = title;
		this.empno = empno;
		this.password = password;
	}
	
	
	


}
