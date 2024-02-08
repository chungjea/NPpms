package com.web.spring.vo;
/*
CREATE TABLE link(
	id NUMBER NOT NULL PRIMARY key,
	SOURCE NUMBER NOT null,
	ratget NUMBER NOT NULL,
	TYPE varchar2(50) NOT NULL
);
 * */
public class Links_f {
	private int id;
	private int source;
	private int target;
	private String type;
	public Links_f() {
		// TODO Auto-generated constructor stub
	}
	public Links_f(int id, int source, int target, String type) {
		this.id = id;
		this.source = source;
		this.target = target;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSource() {
		return source;
	}
	public void setSource(int source) {
		this.source = source;
	}
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
