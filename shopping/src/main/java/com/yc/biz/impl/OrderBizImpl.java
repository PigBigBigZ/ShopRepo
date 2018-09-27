package com.yc.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.Orderform;
import com.yc.biz.OrderBiz;
import com.yc.dao.OrderDao;
@Service
public class OrderBizImpl implements OrderBiz{
	
    @Resource
    private  OrderDao dao;
	
	public void insertOrder(Orderform orderform) {
		dao.save(orderform );
	}

}
