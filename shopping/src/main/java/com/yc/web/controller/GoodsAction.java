package com.yc.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yc.bean.Goods;
import com.yc.bean.Gtype;
import com.yc.bean.Image;
import com.yc.biz.GoodsBiz;

@Controller
public class GoodsAction {
	@Resource
	private GoodsBiz gBiz;
	
	@RequestMapping("addGoods.do")
	public String addGoods(String gname,Double gprice,Integer typeid,
			Integer gcount,Integer imgid){
		Goods goods=new Goods();
		goods.setGname(gname);
		goods.setGprice(gprice);
		Gtype gtype=new Gtype();
		gtype.setTypeid(typeid);
		goods.setGtype(gtype);
		goods.setGcount(gcount);
		Image image=new Image();
		image.setImgid(imgid);
		goods.setImage(image);
		
		gBiz.addGoods(goods);
		return null;
	}
}
