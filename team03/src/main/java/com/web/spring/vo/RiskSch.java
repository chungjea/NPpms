package com.web.spring.vo;

public class RiskSch {
	private String title;
	private int wempno;
	private int cempno;
	private int manager;
	private int pcode;
	private int count;
	private int pageSize;
	private int pageCount;
	private int curPage;
	private int start;
	private int end;
	private int blockSize;
	private int startBlock;
	private int endBlock;
	
	public RiskSch() {
	}

	public RiskSch(String title, int wempno, int cempno, int manager, int pcode, int count, int pageSize, int pageCount, int curPage,
			int start, int end, int blockSize, int startBlock, int endBlock) {
		this.title = title;
		this.wempno = wempno;
		this.cempno = cempno;
		this.manager = manager;
		this.pcode = pcode;
		this.count = count;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.curPage = curPage;
		this.start = start;
		this.end = end;
		this.blockSize = blockSize;
		this.startBlock = startBlock;
		this.endBlock = endBlock;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getWempno() {
		return wempno;
	}

	public void setWempno(int wempno) {
		this.wempno = wempno;
	}

	public int getCempno() {
		return cempno;
	}

	public void setCempno(int cempno) {
		this.cempno = cempno;
	}

	public int getManager() {
		return manager;
	}

	public void setManager(int manager) {
		this.manager = manager;
	}

	public int getPcode() {
		return pcode;
	}

	public void setPcode(int pcode) {
		this.pcode = pcode;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
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

	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
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
