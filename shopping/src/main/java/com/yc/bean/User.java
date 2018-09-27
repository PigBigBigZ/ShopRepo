package com.yc.bean;


import javax.persistence.*;

@Entity //实体类注解
@Table(name="user") //配置表名
public class User {
	@Id  //主键注解
	@GeneratedValue(strategy=GenerationType.AUTO)  //配置主键值生成机制
	private Integer uid;
	private String uname;
	private String upass;
	private String phone;
	private String email;
	private char sex;
	//身份证id
	private String cid;
	private String head;
	private double account;

	@OneToOne
	@JoinColumn(name="rid")
	private Role role;
	private Integer paypass;
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
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
		return "User [uid=" + uid + ", uname=" + uname + ", upass=" + upass + ", phone=" + phone + ", email=" + email
				+ ", Sex=" + sex + ", cid=" + cid + ", head=" + head + ", account=" + account + ", role=" + role
				+ ", paypass=" + paypass + "]";
	}

	
	

}
