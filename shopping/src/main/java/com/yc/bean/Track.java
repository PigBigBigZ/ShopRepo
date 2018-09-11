package com.yc.bean;

import java.sql.Timestamp;

public class Track {

	private Integer tid;
	private User user;
	private Goods goods;
	private Timestamp ttime;

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
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

	public Timestamp getTtime() {
		return ttime;
	}

	public void setTtime(Timestamp ttime) {
		this.ttime = ttime;
	}

	@Override
	public String toString() {
		return "Track [tid=" + tid + ", user=" + user + ", goods=" + goods
				+ ", ttime=" + ttime + "]";
	}

}
