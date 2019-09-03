package com.bawei.bean;

/**
 * @作者 hsj
 * @日期 2019年9月3日
 */
public class Story {

	private Integer sid;
	private String sname;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Story(Integer sid, String sname) {
		super();
		this.sid = sid;
		this.sname = sname;
	}
	public Story() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Story [sid=" + sid + ", sname=" + sname + "]";
	}
	
	
}
