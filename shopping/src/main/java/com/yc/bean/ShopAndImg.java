package com.yc.bean;



public class ShopAndImg {
	private Goods goods;
	private Image image;
	public ShopAndImg(){
		
	}
	public ShopAndImg(Goods goods){
		Image image=new Image();
		this.goods = goods;
		this.image = image;
	}
	
	public ShopAndImg(Image image){
		Goods goods=new Goods();
		this.goods = goods;
		this.image = image;
	}
	
	public ShopAndImg(Goods goods, Image image) {
		this.goods = goods;
		this.image = image;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	
	
}
