package com.web.spring.vo;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Meeting_f {
	private int metno;
	private String title;
	private Date metdte;
	private String metdteStr;
	private Date starttm;
	private String starttmStr;
	private Date fintm;
	private String fintmStr;
	private String participant;
	private int wempno;
	private String writer;
	private String content;
	private String conclusion;
	private Date regdte;
	private MultipartFile[] reports;
	private List<String> fnames;
	private int cnt;
	private int fno;
	
	public Meeting_f() {
	}

	public Meeting_f(int metno, String title, String metdteStr, String starttmStr, String fintmStr, String participant,
			int wempno, String writer, String content, String conclusion) {
		this.metno = metno;
		this.title = title;
		this.metdteStr = metdteStr;
		this.starttmStr = starttmStr;
		this.fintmStr = fintmStr;
		this.participant = participant;
		this.wempno = wempno;
		this.writer = writer;
		this.content = content;
		this.conclusion = conclusion;
	}

	public Meeting_f(int metno, String title, Date metdte, String metdteStr, Date starttm, String starttmStr,
			Date fintm, String fintmStr, String participant, int wempno, String writer, String content,
			String conclusion, Date regdte) {
		this.metno = metno;
		this.title = title;
		this.metdte = metdte;
		this.metdteStr = metdteStr;
		this.starttm = starttm;
		this.starttmStr = starttmStr;
		this.fintm = fintm;
		this.fintmStr = fintmStr;
		this.participant = participant;
		this.wempno = wempno;
		this.writer = writer;
		this.content = content;
		this.conclusion = conclusion;
		this.regdte = regdte;
	}

	public int getMetno() {
		return metno;
	}

	public void setMetno(int metno) {
		this.metno = metno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getMetdte() {
		return metdte;
	}

	public void setMetdte(Date metdte) {
		this.metdte = metdte;
	}

	public String getMetdteStr() {
		return metdteStr;
	}

	public void setMetdteStr(String metdteStr) {
		this.metdteStr = metdteStr;
	}

	public Date getStarttm() {
		return starttm;
	}

	public void setStarttm(Date starttm) {
		this.starttm = starttm;
	}

	public String getStarttmStr() {
		return starttmStr;
	}

	public void setStarttmStr(String starttmStr) {
		this.starttmStr = starttmStr;
	}

	public Date getFintm() {
		return fintm;
	}

	public void setFintm(Date fintm) {
		this.fintm = fintm;
	}

	public String getFintmStr() {
		return fintmStr;
	}

	public void setFintmStr(String fintmStr) {
		this.fintmStr = fintmStr;
	}

	public String getParticipant() {
		return participant;
	}

	public void setParticipant(String participant) {
		this.participant = participant;
	}

	public int getWempno() {
		return wempno;
	}

	public void setWempno(int wempno) {
		this.wempno = wempno;
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

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public Date getRegdte() {
		return regdte;
	}

	public void setRegdte(Date regdte) {
		this.regdte = regdte;
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

	public int getFno() {
		return fno;
	}

	public void setFno(int fno) {
		this.fno = fno;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
}
