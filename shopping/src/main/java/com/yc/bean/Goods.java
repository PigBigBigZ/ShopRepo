package com.yc.bean;

public class Goods {
	private Integer gid;
	private String Gname;
	private double Gprice;
	private String Gtype;
	private Integer Gcount;
	private Image image;
	// 销量
	private Integer Gsail;

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getGname() {
		return Gname;
	}

	public void setGname(String gname) {
		Gname = gname;
	}

	public double getGprice() {
		return Gprice;
	}

	public void setGprice(double gprice) {
		Gprice = gprice;
	}

	public String getGtype() {
		return Gtype;
	}

	public void setGtype(String gtype) {
		Gtype = gtype;
	}

	public Integer getGcount() {
		return Gcount;
	}

	public void setGcount(Integer gcount) {
		Gcount = gcount;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Integer getGsail() {
		return Gsail;
	}

	public void setGsail(Integer gsail) {
		Gsail = gsail;
	}

	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", Gname=" + Gname + ", Gprice=" + Gprice
				+ ", Gtype=" + Gtype + ", Gcount=" + Gcount + ", image="
				+ image + ", Gsail=" + Gsail + "]";
	}

}
