package com.yc.test;


import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import com.yc.HelloApplication;
import com.yc.bean.Goods;
import com.yc.bean.Gtype;
import com.yc.bean.Image;
import com.yc.biz.impl.GoodsBizImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(HelloApplication.class)
public class Test {
	@Resource
    GoodsBizImpl biz;
	@org.junit.Test
   public void testAddGoods(){
	   Goods goods=new Goods();
		goods.setGname("好吃点");
		goods.setGprice(16.0);
		goods.setGsail(15);
		goods.setGcount(100);
		Gtype gtype=new Gtype();
		gtype.setTypeid(2);
	    goods.setGtype(gtype);
	    Image image=new Image();
	    image.setImgid(1);
	    goods.setImage(image);
	    biz.addGoods(goods);
   }
	
	@org.junit.Test
	public void testCountGoods(){
		System.out.println(biz.countGoods());
	}
	
	@org.junit.Test
	public Page<Goods> testFindGoodsByPage(Integer page, Integer size){
		page=1;
		size=5;
		return biz.findGoodsByPage(page, size);
	}
}
