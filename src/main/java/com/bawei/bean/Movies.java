package com.bawei.bean;

/**
 * @作者 hsj
 * @日期 2019年9月3日
 */
public class Movies {

	private Integer mid;
	private String mname;
	private String introduction;
	private String auther;
	private String startdate;
	
	private String sids;
	private String snames;

	
	public String getSids() {
		return sids;
	}

	public void setSids(String sids) {
		this.sids = sids;
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getAuther() {
		return auther;
	}

	public void setAuther(String auther) {
		this.auther = auther;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getSnames() {
		return snames;
	}

	public void setSnames(String snames) {
		this.snames = snames;
	}

	public Movies(Integer mid, String mname, String introduction, String auther, String startdate, String snames) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.introduction = introduction;
		this.auther = auther;
		this.startdate = startdate;
		this.snames = snames;
	}

	public Movies() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Movies [mid=" + mid + ", mname=" + mname + ", introduction=" + introduction + ", auther=" + auther
				+ ", startdate=" + startdate + ", snames=" + snames + "]";
	}
	
	
}
