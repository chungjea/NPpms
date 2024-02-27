package com.web.spring.vo;

public class TaskRink_f {
	private long id;
	private long source;
	private long target;
	private int type;
	private int pcode;
	public TaskRink_f() {
		// TODO Auto-generated constructor stub
	}
	public TaskRink_f(long id, long source, long target, int type) {
		this.id = id;
		this.source = source;
		this.target = target;
		this.type = type;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getSource() {
		return source;
	}
	public void setSource(long source) {
		this.source = source;
	}
	public long getTarget() {
		return target;
	}
	public void setTarget(long target) {
		this.target = target;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getPcode() {
		return pcode;
	}
	public void setPcode(int pcode) {
		this.pcode = pcode;
	}
	
	
	
}
