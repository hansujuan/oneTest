package com.bawei.bean;

/**
 * @作者 hsj
 * @日期 2019年9月3日
 */
public class MoviesStory {

	private Integer id;
	private Integer mid;
	private Integer sid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public MoviesStory(Integer id, Integer mid, Integer sid) {
		super();
		this.id = id;
		this.mid = mid;
		this.sid = sid;
	}
	public MoviesStory() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MoviesStory [id=" + id + ", mid=" + mid + ", sid=" + sid + "]";
	}
	
	
}
