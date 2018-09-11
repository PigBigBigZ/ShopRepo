package com.yc.bean;

public class Address {
	private int addrid;
	private User user;
	private String address;
	private String phone;

	public int getAddrid() {
		return addrid;
	}

	public void setAddrid(int addrid) {
		this.addrid = addrid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Address [addrid=" + addrid + ", user=" + user + ", address="
				+ address + ", phone=" + phone + "]";
	}

}
