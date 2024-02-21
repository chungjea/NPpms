package com.web.spring.vo;

public class MailSender {
	private String email;
	private String sender;
	private String title;
	private String receiver;
	private int empno;
	private String password;
	public MailSender() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MailSender(String email, String sender, String title, String receiver, int empno, String password) {
		super();
		this.email = email;
		this.sender = sender;
		this.title = title;
		this.receiver = receiver;
		this.empno = empno;
		this.password = password;
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
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
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
	
	


}
