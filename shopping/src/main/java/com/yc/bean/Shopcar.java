package com.yc.bean;

import java.sql.Timestamp;

public class Shopcar {

	private Integer carId;
	private User user;
	private Goods goods;
	private Timestamp addtime;
	private Integer addcount;
	private double gprice;

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Timestamp getAddtime() {
		return addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Integer getAddcount() {
		return addcount;
	}

	public void setAddcount(Integer addcount) {
		this.addcount = addcount;
	}

	public double getGprice() {
		return gprice;
	}

	public void setGprice(double gprice) {
		this.gprice = gprice;
	}

	@Override
	public String toString() {
		return "Shopcar [carId=" + carId + ", user=" + user + ", goods="
				+ goods + ", addtime=" + addtime + ", addcount=" + addcount
				+ ", gprice=" + gprice + "]";
	}

}
