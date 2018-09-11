package com.yc.bean;

public class Image {
	private Integer imgid;
	private String path;
	private Integer imgtype;

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
				+ imgtype + "]";
	}

}
