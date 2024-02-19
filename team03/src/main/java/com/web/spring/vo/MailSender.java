package com.web.spring.vo;

public class MailSender {
	private String email;
	private String sender;
	private String title;
	private String content;
	private String empno;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public MailSender(String email, String sender, String title, String content, String empno) {
		super();
		this.email = email;
		this.sender = sender;
		this.title = title;
		this.content = content;
		this.empno = empno;
	}
	
	


}
