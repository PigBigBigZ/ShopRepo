package com.yc.biz.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.Goods;
import com.yc.biz.GoodsBiz;
import com.yc.dao.GoodsDao;
@Service
public class GoodsBizImpl implements GoodsBiz {
	@Resource
	GoodsDao dao;
	
	

	public void addGoods(Goods goods) {
		dao.save(goods);
		/*
		Integer id=goods.getGid();
		Image image=imgdao.findOne(id);
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
	    factory.setSizeThreshold(4096);//缓冲区大小
        factory.setRepository(tempFile);//缓冲区目录
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(4194304);//最大文件尺寸,4MB
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		*/
	}

	
	
	public void updataGoods() {
		// TODO Auto-generated method stub
		
	}

	
   
}
