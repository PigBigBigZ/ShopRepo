package com.yc.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Image {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer imgid;
	private String path;
	private Integer imgtype;
	private String imgname;
	
	

	public String getImgname() {
		return imgname;
	}

	public void setImgname(String imgname) {
		this.imgname = imgname;
	}

	public Integer getImgid() {
		return imgid;
	}

	public void setImgid(Integer imgid) {
		this.imgid = imgid;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getImgtype() {
		return imgtype;
	}

	public void setImgtype(Integer imgtype) {
		this.imgtype = imgtype;
	}

	@Override
	public String toString() {
		return "Image [imgid=" + imgid + ", path=" + path + ", imgtype="
				+ imgtype + ", imgname=" + imgname + "]";
	}

	

}
