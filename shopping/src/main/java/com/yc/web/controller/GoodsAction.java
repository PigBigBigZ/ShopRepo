package com.yc.web.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.yc.bean.Goods;
import com.yc.bean.Gtype;
import com.yc.bean.Image;
import com.yc.biz.impl.GoodsBizImpl;
import com.yc.dao.ImageDao;

@Controller
public class GoodsAction {
	private String path;
	@Resource
	private GoodsBizImpl gBiz;
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
		
	    String fileName = file.getOriginalFilename();
	    
	    String filePath = request.getSession().getServletContext().getRealPath("/")+ "../images/";
	    try {
			FileUtil.uploadFile(file.getBytes(), filePath, fileName);
			Image image2=new Image();
			image2.setImgname(fileName);
			image2.setImgtype(1);
			image2.setPath(filePath);
			dao.save(image2);
			image.setImgid(image2.getImgid());
			goods.setImage(image);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		gBiz.addGoods(goods);
		
		
		//String contentType = file.getContentType();
	    
	    
	   
		return null;
	}
	
	@RequestMapping("findGoodAndImg.do")
	public  String  findGoodAndImg(HttpSession session,Model model){
		List<Object[]> list=gBiz.findAllGoods();
		 String Gname=(String) list.get(0)[0];
		 Double Gprice= (Double) list.get(0)[1];
		 
		path=(String) list.get(0)[2];
		String imgname=(String) list.get(0)[4];
		
		//File[] files=gBiz.findGoodsImgFile(imgname, path);
		//System.out.println(files);
		//files[0].
	   model.addAttribute("path", path);
	   model.addAttribute("imgname", imgname);
	   model.addAttribute("Gname", Gname);
	  model.addAttribute("Gprice", Gprice);
		return "home3";
	}
}
