package com.yc.bean;

public class User {
	private Integer Uid;
	private String Uname;
	private String Upass;
	private String Phone;
	private String Email;
	private char Sex;
	//身份证id
	private String cid;
	private String head;
	private double account;
	private Role role;
	private Integer paypass;
	public Integer getUid() {
		return Uid;
	}
	public void setUid(Integer uid) {
		Uid = uid;
	}
	public String getUname() {
		return Uname;
	}
	public void setUname(String uname) {
		Uname = uname;
	}
	public String getUpass() {
		return Upass;
	}
	public void setUpass(String upass) {
		Upass = upass;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public char getSex() {
		return Sex;
	}
	public void setSex(char sex) {
		Sex = sex;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public double getAccount() {
		return account;
	}
	public void setAccount(double account) {
		this.account = account;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Integer getPaypass() {
		return paypass;
	}
	public void setPaypass(Integer paypass) {
		this.paypass = paypass;
	}
	@Override
	public String toString() {
		return "User [Uid=" + Uid + ", Uname=" + Uname + ", Upass=" + Upass
				+ ", Phone=" + Phone + ", Email=" + Email + ", Sex=" + Sex
				+ ", cid=" + cid + ", head=" + head + ", account=" + account
				+ ", role=" + role + ", paypass=" + paypass + "]";
	}
	
	

}
