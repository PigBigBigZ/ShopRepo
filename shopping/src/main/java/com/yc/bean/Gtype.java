package com.yc.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gtype {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer typeid;
	private String typename;
	private Integer pid;

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "Gtype [typeid=" + typeid + ", typename="
				+ typename + ", pid=" + pid + "]";
	}

}
