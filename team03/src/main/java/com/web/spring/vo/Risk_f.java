package com.web.spring.vo;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Risk_f {
	private int rskno;
	private String title;
	private Date regdte;
	private Date uptdte;
	private int wempno;
	private String writer;
	private String probability;
	private String danger;
	private String content;
	private String sts;
	private String priority;
	private String charge;
	private int cempno;
	private Date finaldte;
	private String finaldteStr;
	private String feedback;
	private int manager;
	private MultipartFile[] reports;
	private List<String> fnames;
	
	public Risk_f() {
	}

	public Risk_f(int rskno, String title, Date regdte, Date uptdte, int wempno, String writer, String probability,
			String danger, String content, String sts, String priority, String charge, int cempno, Date finaldte,
			String finaldteStr, String feedback, int manager) {
		this.rskno = rskno;
		this.title = title;
		this.regdte = regdte;
		this.uptdte = uptdte;
		this.wempno = wempno;
		this.writer = writer;
		this.probability = probability;
		this.danger = danger;
		this.content = content;
		this.sts = sts;
		this.priority = priority;
		this.charge = charge;
		this.cempno = cempno;
		this.finaldte = finaldte;
		this.finaldteStr = finaldteStr;
		this.feedback = feedback;
		this.manager = manager;
	}

	public int getRskno() {
		return rskno;
	}

	public void setRskno(int rskno) {
		this.rskno = rskno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getRegdte() {
		return regdte;
	}

	public void setRegdte(Date regdte) {
		this.regdte = regdte;
	}

	public Date getUptdte() {
		return uptdte;
	}

	public void setUptdte(Date uptdte) {
		this.uptdte = uptdte;
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

	public String getProbability() {
		return probability;
	}

	public void setProbability(String probability) {
		this.probability = probability;
	}

	public String getDanger() {
		return danger;
	}

	public void setDanger(String danger) {
		this.danger = danger;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSts() {
		return sts;
	}

	public void setSts(String sts) {
		this.sts = sts;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

	public int getCempno() {
		return cempno;
	}

	public void setCempno(int cempno) {
		this.cempno = cempno;
	}

	public Date getFinaldte() {
		return finaldte;
	}

	public void setFinaldte(Date finaldte) {
		this.finaldte = finaldte;
	}

	public String getFinaldteStr() {
		return finaldteStr;
	}

	public void setFinaldteStr(String finaldteStr) {
		this.finaldteStr = finaldteStr;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public int getManager() {
		return manager;
	}

	public void setManager(int manager) {
		this.manager = manager;
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
