package com.web.spring.vo;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Noticeboard_f {
	private int cnt;
	private int notice_num;
	private String writer;
	private String content;
	private Date regDate;
	private Date updateDate;
	private String title;
	// 클라이언트에서 서버로 업로드되는 파일을 받는 객체
	private MultipartFile[] reports;
	private List<String> fname;
	private int readcnt;

	public Noticeboard_f() {

	}

	public Noticeboard_f(int cnt, int notice_num, String writer, String content, Date regDate, Date updateDate,
			String title, MultipartFile[] reports, List<String> fname, int readcnt) {
		super();
		this.cnt = cnt;
		this.notice_num = notice_num;
		this.writer = writer;
		this.content = content;
		this.regDate = regDate;
		this.updateDate = updateDate;
		this.title = title;
		this.reports = reports;
		this.fname = fname;
		this.readcnt = readcnt;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getNotice_num() {
		return notice_num;
	}

	public void setNotice_num(int notice_num) {
		this.notice_num = notice_num;
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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MultipartFile[] getReports() {
		return reports;
	}

	public void setReports(MultipartFile[] reports) {
		this.reports = reports;
	}

	public List<String> getFname() {
		return fname;
	}

	public void setFname(List<String> fname) {
		this.fname = fname;
	}

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}

}// Noticeboard_f
