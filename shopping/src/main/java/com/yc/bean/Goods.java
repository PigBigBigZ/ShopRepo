package com.yc.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="goods")
public class Goods {
	@Id  //主键注解
	@GeneratedValue(strategy=GenerationType.AUTO)  //配置主键值生成机制
	private Integer gid;
	private String Gname;
	private double Gprice;
	
	@OneToOne
	@JoinColumn(name="gtypeid")
	private Gtype gtype;
	
	
	private Integer Gcount;
	
	@OneToOne
	@JoinColumn(name="imgid")
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

	

	public Gtype getGtype() {
		return gtype;
		
	}

	public void setGtype(Gtype gtype) {
		this.gtype = gtype;
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
				+ ", Gtype=" + gtype + ", Gcount=" + Gcount + ", image="
				+ image + ", Gsail=" + Gsail + "]";
	}

}
