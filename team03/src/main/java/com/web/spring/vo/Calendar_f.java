package com.web.spring.vo;

public class Calendar_f {
	private int id;
	private String title;
	private String start;
	private String end;
	private String writer;
	private String content;
	private String backgroundColor;
	private String textColor;
	private String allDay;
	private String urlLink;
	private String dName;
	private int empno;
	private String auth;
	private int pcode;

	public Calendar_f() {

	}

	public Calendar_f(int id, String title, String start, String end, String writer, String content,
			String backgroundColor, String textColor, String allDay, String urlLink, String dName, int empno,
			String auth, int pcode) {
		this.id = id;
		this.title = title;
		this.start = start;
		this.end = end;
		this.writer = writer;
		this.content = content;
		this.backgroundColor = backgroundColor;
		this.textColor = textColor;
		this.allDay = allDay;
		this.urlLink = urlLink;
		this.dName = dName;
		this.empno = empno;
		this.auth = auth;
		this.pcode = pcode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public String getTextColor() {
		return textColor;
	}

	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}

	public String getAllDay() {
		return allDay;
	}

	public void setAllDay(String allDay) {
		this.allDay = allDay;
	}

	public String getUrlLink() {
		return urlLink;
	}

	public void setUrlLink(String urlLink) {
		this.urlLink = urlLink;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public int getPcode() {
		return pcode;
	}

	public void setPcode(int pcode) {
		this.pcode = pcode;
	}

}// Calendar_f