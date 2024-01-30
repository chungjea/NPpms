package com.web.spring.vo;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Approve_f {
	private int apvno;
	private String title;
	private String content;
	private String writer;
	private int wempno;
	private Date regdte;
	private String manager;
	private int mempno;
	private Date ckdte;
	private String sts;
	private String feedback;
	private MultipartFile[] reports;
	private List<String> fnames;
	
	public Approve_f() {
	}

	public Approve_f(int apvno, String title, String content, String writer, int wempno, Date regdte, String manager,
			int mempno, String sts) {
		this.apvno = apvno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.wempno = wempno;
		this.regdte = regdte;
		this.manager = manager;
		this.mempno = mempno;
		this.sts = sts;
	}

	public Approve_f(int apvno, String title, String content, String writer, int wempno, Date regdte, String manager,
			int mempno, Date ckdte, String sts, String feedback) {
		this.apvno = apvno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.wempno = wempno;
		this.regdte = regdte;
		this.manager = manager;
		this.mempno = mempno;
		this.ckdte = ckdte;
		this.sts = sts;
		this.feedback = feedback;
	}

	public int getApvno() {
		return apvno;
	}

	public void setApvno(int apvno) {
		this.apvno = apvno;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getWempno() {
		return wempno;
	}

	public void setWempno(int wempno) {
		this.wempno = wempno;
	}

	public Date getRegdte() {
		return regdte;
	}

	public void setRegdte(Date regdte) {
		this.regdte = regdte;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public int getMempno() {
		return mempno;
	}

	public void setMempno(int mempno) {
		this.mempno = mempno;
	}

	public Date getCkdte() {
		return ckdte;
	}

	public void setCkdte(Date ckdte) {
		this.ckdte = ckdte;
	}

	public String getSts() {
		return sts;
	}

	public void setSts(String sts) {
		this.sts = sts;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public MultipartFile[] getReports() {
		return reports;
	}

	public void setReports(MultipartFile[] reports) {
		this.reports = reports;
	}

	public List<String> getFnames() {
		return fnames;
	}

	public void setFnames(List<String> fnames) {
		this.fnames = fnames;
	}
	
}
