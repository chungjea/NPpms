package com.web.spring.vo;

public class MailSender {
	private String email;
	private String sender;
	private String title;
	private String passwd;
	private String empno;
	public MailSender() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MailSender(String email, String sender, String title, String passwd, String empno) {
		super();
		this.email = email;
		this.sender = sender;
		this.title = title;
		this.passwd = passwd;
		this.empno = empno;
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
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	
	
	


}
