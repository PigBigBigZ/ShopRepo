package com.yc.web.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.yc.bean.Goods;
import com.yc.bean.Gtype;
import com.yc.bean.Image;
import com.yc.biz.GoodsBiz;
import com.yc.dao.ImageDao;

@Controller
public class GoodsAction {
	@Resource
	private GoodsBiz gBiz;
	@Resource 
	ImageDao dao;
	
	@RequestMapping("addGoods.do")
	public String addGoods(String gname,Double gprice,Integer typeid,
		   Integer gcount,HttpServletRequest request,MultipartFile file){
		
		Goods goods=new Goods();
		goods.setGname(gname);
		goods.setGprice(gprice);
		Gtype gtype=new Gtype();
		gtype.setTypeid(typeid);
		goods.setGtype(gtype);
		goods.setGcount(gcount);
		Image image=new Image();
		image.setImgid(1);
		goods.setImage(image);
	    String fileName = file.getOriginalFilename();
	    
	    String filePath = request.getSession().getServletContext().getRealPath("/")+ "../images/";
	    try {
			FileUtil.uploadFile(file.getBytes(), filePath, fileName);
			Image image2=new Image();
			image2.setImgname(fileName);
			image2.setImgtype(1);
			image2.setPath(filePath);
			dao.save(image2);
			System.out.println(image2.getImgid());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		gBiz.addGoods(goods);
		
		
		//String contentType = file.getContentType();
	    
	    
	   
		return null;
	}
}
