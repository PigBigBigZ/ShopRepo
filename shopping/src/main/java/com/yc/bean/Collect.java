package com.yc.bean;

public class Collect {
	private Integer collectid;
	private User user;
	private Goods goods;

	public Integer getCollectid() {
		return collectid;
	}

	public void setCollectid(Integer collectid) {
		this.collectid = collectid;
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

	@Override
	public String toString() {
		return "Collect [collectid=" + collectid + ", user=" + user
				+ ", goods=" + goods + "]";
	}

}
