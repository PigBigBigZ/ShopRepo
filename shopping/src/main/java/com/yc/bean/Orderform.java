package com.yc.bean;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Orderform {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer oid;
	private Timestamp Spdate;
	
	@OneToOne
	@JoinColumn(name="uid")
	private User user;
	@OneToOne
	@JoinColumn(name="addrid")
	private Address address;
	private Integer ostatus;
	private Double allprice;
	
	

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
	
	

	public Double getAllprice() {
		return allprice;
	}

	public void setAllprice(Double allprice) {
		this.allprice = allprice;
	}

	@Override
	public String toString() {
		return "Orderform [oid=" + oid + ", Spdate=" + Spdate + ", user="
				+ user + ", address=" + address + ", ostatus=" + ostatus
				+ ", allprice=" + allprice + "]";
	}

	

}
