package com.web.spring.vo;

public class ProjectSch {
	private String status;
	private String pname;
	private int empno;
	
	private int totdata;
	private int curPage;
	private int pageSize;
	private int pageCount;
	private int start;
	private int end;
	
	private int bolckSize;
	private int startBlock;
	private int endBlock;
	public ProjectSch() {
		// TODO Auto-generated constructor stub
	}
	public ProjectSch(String status, String pname, int empno, int totdata, int curPage, int pageSize, int pageCount,
			int start, int end, int bolckSize, int startBlock, int endBlock) {
		this.status = status;
		this.pname = pname;
		this.empno = empno;
		this.totdata = totdata;
		this.curPage = curPage;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.start = start;
		this.end = end;
		this.bolckSize = bolckSize;
		this.startBlock = startBlock;
		this.endBlock = endBlock;
	}

	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getTotdata() {
		return totdata;
	}
	public void setTotdata(int totdata) {
		this.totdata = totdata;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getBolckSize() {
		return bolckSize;
	}
	public void setBolckSize(int bolckSize) {
		this.bolckSize = bolckSize;
	}
	public int getStartBlock() {
		return startBlock;
	}
	public void setStartBlock(int startBlock) {
		this.startBlock = startBlock;
	}
	public int getEndBlock() {
		return endBlock;
	}
	public void setEndBlock(int endBlock) {
		this.endBlock = endBlock;
	}
	
	
}
