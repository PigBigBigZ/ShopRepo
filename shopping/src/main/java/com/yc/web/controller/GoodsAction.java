package com.yc.web.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		Integer gsail=0;
		goods.setGsail(gsail);
		gBiz.addGoods(goods);
		return "redirect:manageGoods.jsp";
	}
	
	@RequestMapping("findGoodsByPage.do")
	public String findGoodsByPage(ModelMap modelMap,@RequestParam(value = "page", defaultValue = "1") Integer page,
	        @RequestParam(value = "size", defaultValue = "10") Integer size){

		Page<Goods> datas=gBiz.findGoodsByPage(page, size);
		
		modelMap.addAttribute("datas", datas);
		modelMap.addAttribute("count", gBiz.countGoods());
		return "manageGoods";
		//spring.mvc.view.prefix=/WEB-INF/page/
	}
	
	//删除某个商品
	@RequestMapping("delGoods.do")
	public void delGoods(@RequestParam(value="gid") Integer gid){
		gBiz.delGoods(gid);
	}
	
	//更新某个商品
	@RequestMapping("updateGoods.do")
	public String updateGoods(Integer gid, String gname,Double gprice,Integer typeid,
			Integer gcount){
		Goods goods1=gBiz.findGoodsById(gid);
		Goods goods=new Goods();
		goods.setGid(gid);
		goods.setGname(gname);
		goods.setGprice(gprice);
		Gtype gtype=new Gtype();
		gtype.setTypeid(typeid);
		goods.setGtype(gtype);
		goods.setGcount(gcount);
		goods.setGsail(goods1.getGsail());
		goods.setImage(goods1.getImage());
		gBiz.updataGoods(goods);
		return "redirect:manageGoods.jsp";
	}
	
	
	//根据id查商品
	@RequestMapping("findGoodsById.do")
	public String findGoodsById(Integer gid,Model model){
		Goods goods=gBiz.findGoodsById(gid);
		model.addAttribute("goods",goods);
		return "updateGoods";
	}
	
	@RequestMapping("findAllGoods.do")
	public void findAllGoods(ModelMap modelMap){
		List<Goods> goods=gBiz.findAllGoods();
		modelMap.addAttribute("good", goods);
	}
}
