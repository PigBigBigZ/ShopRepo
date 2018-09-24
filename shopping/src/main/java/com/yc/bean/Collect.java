package com.yc.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="collect")
public class Collect {
	@Id  //主键注解
	@GeneratedValue(strategy=GenerationType.AUTO)  //配置主键值生成机制
	private Integer collectid;
	@OneToOne
	@JoinColumn(name="uid")
	private User user;
	@OneToOne
	@JoinColumn(name="gid")
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
