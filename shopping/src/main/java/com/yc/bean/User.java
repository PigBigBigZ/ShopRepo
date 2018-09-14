package com.yc.bean;

<<<<<<< HEAD
import javax.persistence.*;

@Entity //实体类注解
@Table(name="user") //配置表名
=======
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
>>>>>>> branch 'master' of https://github.com/PigBigBigZ/ShopRepo.git
public class User {
<<<<<<< HEAD
	@Id //主键注解
	@GeneratedValue(strategy=GenerationType.AUTO) //配置主键值的生成机制
=======
	@Id  //主键注解
	@GeneratedValue(strategy=GenerationType.AUTO)  //配置主键值生成机制
>>>>>>> branch 'master' of https://github.com/PigBigBigZ/ShopRepo.git
	private Integer Uid;
	private String uname;
	private String upass;
	private String phone;
	private String email;
	private char Sex;
	//身份证id
	private String cid;
	private String head;
	private double account;
<<<<<<< HEAD
	
=======
>>>>>>> branch 'master' of https://github.com/PigBigBigZ/ShopRepo.git
	@OneToOne
	@JoinColumn(name="rid")
	private Role role;
	private Integer paypass;
	
	public Integer getUid() {
		return Uid;
	}
	public void setUid(Integer uid) {
		Uid = uid;
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
		return "User [Uid=" + Uid + ", uname=" + uname + ", upass=" + upass + ", phone=" + phone + ", email=" + email
				+ ", Sex=" + Sex + ", cid=" + cid + ", head=" + head + ", account=" + account + ", role=" + role
				+ ", paypass=" + paypass + "]";
	}

	
	

}
