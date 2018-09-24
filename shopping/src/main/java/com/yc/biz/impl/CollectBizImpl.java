package com.yc.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.biz.CollectBiz;
import com.yc.dao.CollectDao;
@Service
public class CollectBizImpl implements CollectBiz {
	@Resource
	CollectDao dao;
	
	@Override
	public void addCol() {
		
	}

	@Override
	public void delCol() {
		
	}

}
