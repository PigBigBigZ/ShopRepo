package com.yc.test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.yc.HelloApplication;
import com.yc.bean.Address;
import com.yc.bean.Collect;
import com.yc.bean.Goods;
import com.yc.bean.Gtype;
import com.yc.bean.Image;
import com.yc.bean.Orderform;
import com.yc.bean.User;
import com.yc.biz.AddressBiz;
import com.yc.biz.OrderBiz;
import com.yc.biz.impl.CollectBizImpl;
import com.yc.biz.impl.GoodsBizImpl;
import com.yc.biz.impl.GtypeBizImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(HelloApplication.class)
public class Test {
	@Resource
	GoodsBizImpl biz;
	@Resource
	GtypeBizImpl gtbiz;


	@Resource
    CollectBizImpl cbiz;
	
	@Resource 
	OrderBiz obiz;
	
	@Resource
	AddressBiz abiz;

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
	public void testCountGoods() {
		System.out.println(biz.countGoods());
	}

	/*
	 * @org.junit.Test public Page<Goods> testFindGoodsByPage(Integer page,
	 * Integer size){ page=1; size=5; return biz.findGoodsByPage(page, size); }
	 */

	@org.junit.Test
	public void testFindChildGoods() {
		Integer gtypeid = 2;
		List<Object[]> list = biz.findChildGoods(gtypeid);
		System.out.println(list.get(0)[0]);
		System.out.println("==================");
		for (Object[] a : list) {
			System.out.println(a[0]);
			System.out.println(a[1]);
		}
	}

	@org.junit.Test
	public void testFindAll() {
		List<Gtype> list = gtbiz.findAll();
		String typenameString = list.get(0).getTypename();
		System.out.println(typenameString);
	}
		

	public void testAddCollect(){
		Collect collect=new Collect();
		Goods goods=new Goods();
		User user=new User();
		goods.setGid(1);
		user.setUid(2);
		collect.setGoods(goods);
		collect.setUser(user);
		cbiz.addCol(collect);
	}
	
	@org.junit.Test
	public void testFindCol(){
		Integer uid=2;
		Integer gid=2;
		System.out.println(cbiz.findCol(uid, gid));
	}
	
	@org.junit.Test
	public void testDelCollect(){
		Integer collectid=2;
		cbiz.delCol(collectid);

	}

	
	@org.junit.Test
	public void testTypeid() {
		List<Integer> list1 = biz.GroupByTypeid();
		List<List<Object[]>> list = new ArrayList<>();

		for (Integer gtypeid : list1) {
			List<Object[]> list2 = biz.findGoodsAndImg(gtypeid);
			if (list2 != null && list2.size() > 0) {
				list.add(list2);
			}
		}
	
			for(Object[] b:list.get(0)){
				System.out.println(b[0]);
		}
	}
	
	@org.junit.Test
	public void testAddOrder(){
		Orderform orderform=new Orderform();
		Address address=new Address();
		address.setAddrid(1);
		orderform.setAddress(address);
		orderform.setAllprice(15.0);
		orderform.setOstatus(2);
		orderform.setSpdate(new Timestamp(System.currentTimeMillis()));
		User user=new User();
		user.setUid(2);
		orderform.setUser(user);
		obiz.insertOrder(orderform);
	}
	
	@org.junit.Test
	public void testFindAddressByUid(){
		Integer uid=2;
		List<Address> list=abiz.findByUid(uid);
		for(Address a:list){
			System.out.println(a.getProvince());
			//System.out.println(a);
		}
	}

}
