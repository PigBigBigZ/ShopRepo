package com.yc.test;


import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.yc.HelloApplication;
import com.yc.bean.Address;
import com.yc.bean.Goods;
import com.yc.bean.Gtype;
import com.yc.bean.Image;
import com.yc.bean.User;
import com.yc.biz.impl.AddressBizImpl;
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
	
	@Resource
    AddressBizImpl aBizImplbiz;
	@org.junit.Test
	public void testAddAddress(){
		Address address = new Address();
		address.setAddress("湖南工学院33");
		address.setPhone("15022012345");
		User user = new User();
		user.setUid(1);
		address.setUser(user);
		aBizImplbiz.addAddress(address);
	}
}
