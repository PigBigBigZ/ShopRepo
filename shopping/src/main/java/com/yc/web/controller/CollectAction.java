package com.yc.web.controller;

import javax.annotation.Resource;


import org.springframework.stereotype.Controller;



import org.springframework.data.domain.Page;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.Collect;
import com.yc.bean.Goods;
import com.yc.bean.User;

import com.yc.biz.CollectBiz;

@Controller
public class CollectAction {
	@Resource
	private CollectBiz cBiz;

	@ResponseBody
	@RequestMapping("addCol.do")
	public int addCol(Integer uid,Integer gid,Model model){
		
//		String msg = null;
		int flag=cBiz.findCol(uid, gid);
		System.out.println("flag="+flag);
		if(flag==0){
			Collect collect=new Collect();
			Goods goods=new Goods();
			User user=new User();
			goods.setGid(gid);
			user.setUid(uid);
			collect.setGoods(goods);
			collect.setUser(user);
			cBiz.addCol(collect);
//			msg="收藏成功！";
			return 0;
		}else{
//			 msg="您已收藏过该商品！";
			return 1;
		}
//		 model.addAttribute("msg",msg);
		
//		System.out.println(msg);
		
	}
	
	
	
	
	@RequestMapping("findCollectByPage.do")
	public String findCollectByPage(ModelMap modelMap,@RequestParam(value = "page", defaultValue = "1") Integer page,
	        @RequestParam(value = "size", defaultValue = "10") Integer size,Integer uid){

		Page<Collect> datas=cBiz.findCollectByPage(page, size);
		
		modelMap.addAttribute("datas", datas);
		modelMap.addAttribute("count", cBiz.countCollect(uid));
		System.out.println(datas.getContent());
		System.out.println(cBiz.countCollect(uid));
		return "collection";
		
	}
	
	
	@RequestMapping("delCollect.do")
	public void delCollect(@RequestParam(value="collectid") Integer collectid){
		cBiz.delCol(collectid);
	}

}
