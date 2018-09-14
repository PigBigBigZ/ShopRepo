package com.yc.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.yc.HelloApplication;
import com.yc.bean.Goods;
import com.yc.bean.Gtype;
import com.yc.bean.Image;
import com.yc.bean.ShopAndImg;
import com.yc.biz.impl.GoodsBizImpl;
import com.yc.dao.ImageDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(HelloApplication.class)
public class Test {
	@Resource
	GoodsBizImpl biz;
	@Resource
	ImageDao dao;

	@org.junit.Test
	public void testAddGoods() {
		Goods goods = new Goods();
		goods.setGname("好吃点");
		goods.setGprice(16.0);
		goods.setGsail(15);
		goods.setGcount(100);
		Gtype gtype = new Gtype();
		gtype.setTypeid(2);
		goods.setGtype(gtype);
		Image image = new Image();
		image.setImgid(1);
		goods.setImage(image);
		biz.addGoods(goods);
	}

	@org.junit.Test
	public void testAddImage() {
		Image image = new Image();
		image.setImgname("shy");
		image.setImgtype(1);
		image.setPath("d:/shy");
		dao.save(image);

	}
	
	@org.junit.Test
	public void testFindAllGoods2(){
		//List<Object> list=biz.findAllGoods();
	}
	

	@org.junit.Test
	public void testFindAllGoods() {
		List<Object[]> list=biz.findAllGoods();
		if(list!=null && list.size()>0){
		for(Object[] map:list){
			  //map.toString();
			 // System.out.println(map.toString());
			 String path=(String) map[2];
			 System.out.println(path);
		}
		}
	}
	
	
	
	
	
	
}
