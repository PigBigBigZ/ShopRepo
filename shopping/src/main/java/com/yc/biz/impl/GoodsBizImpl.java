package com.yc.biz.impl;


import java.util.List;
import java.util.Map;

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
	}

	
	
	public void updataGoods() {
		
	}



	public List<Map<String, Object>> findAllGoods() {
		return dao.findAllGoods();
	}

	
   
}
