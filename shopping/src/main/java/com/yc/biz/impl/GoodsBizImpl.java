package com.yc.biz.impl;


import java.io.File;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.Goods;
import com.yc.bean.ShopAndImg;
import com.yc.biz.GoodsBiz;
import com.yc.dao.GoodsDao;
@Service
public class GoodsBizImpl implements GoodsBiz {
	@Resource
	GoodsDao dao;
	
	

	public void addGoods(Goods goods) {
		dao.save(goods);
	}

	
	
	public void updataGoods() {
		
	}



	public List<Object[]> findAllGoods() {
		return dao.findAllGoods();
		
	}
	
	public File[] findGoodsImgFile(String imgname, String path) {
		File file=getHomeDir(imgname, path);
		//System.out.println(file.getPath());
		System.out.println(file.listFiles());
	    return	file.listFiles();
	}



	private File getHomeDir(String imgname, String path) {
		File file=new File(imgname+path);
		return file;
	}





	
   
}
