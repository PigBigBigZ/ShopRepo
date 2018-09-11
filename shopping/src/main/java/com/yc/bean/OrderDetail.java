package com.yc.bean;

public class OrderDetail {
	private Integer detid;
	private Orderform orderform;
	private Goods goods;
	private Integer spcount;
	private double gprice;
	private double allprice;

	public Integer getDetid() {
		return detid;
	}

	public void setDetid(Integer detid) {
		this.detid = detid;
	}

	public Orderform getOrderform() {
		return orderform;
	}

	public void setOrderform(Orderform orderform) {
		this.orderform = orderform;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Integer getSpcount() {
		return spcount;
	}

	public void setSpcount(Integer spcount) {
		this.spcount = spcount;
	}

	public double getGprice() {
		return gprice;
	}

	public void setGprice(double gprice) {
		this.gprice = gprice;
	}

	public double getAllprice() {
		return allprice;
	}

	public void setAllprice(double allprice) {
		this.allprice = allprice;
	}

	@Override
	public String toString() {
		return "OrderDetail [detid=" + detid + ", orderform=" + orderform
				+ ", goods=" + goods + ", spcount=" + spcount + ", gprice="
				+ gprice + ", allprice=" + allprice + "]";
	}

}
