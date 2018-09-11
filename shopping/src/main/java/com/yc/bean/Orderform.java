package com.yc.bean;

import java.sql.Timestamp;

public class Orderform {

	private Integer oid;
	private Timestamp Spdate;
	private User user;
	private Address address;
	private Integer ostatus;

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Timestamp getSpdate() {
		return Spdate;
	}

	public void setSpdate(Timestamp spdate) {
		Spdate = spdate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getOstatus() {
		return ostatus;
	}

	public void setOstatus(Integer ostatus) {
		this.ostatus = ostatus;
	}

	@Override
	public String toString() {
		return "Orderform [oid=" + oid + ", Spdate=" + Spdate + ", user="
				+ user + ", address=" + address + ", ostatus=" + ostatus + "]";
	}

}
