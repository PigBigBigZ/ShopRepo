package com.yc.bean;

public class Gtype {
	private Integer typeid;
	private Goods goods;
	private String typename;
	private Integer pid;

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "Gtype [typeid=" + typeid + ", goods=" + goods + ", typename="
				+ typename + ", pid=" + pid + "]";
	}

}
