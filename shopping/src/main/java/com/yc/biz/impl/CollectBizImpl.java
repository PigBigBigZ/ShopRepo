package com.yc.biz.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;




import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import com.yc.bean.Collect;
import com.yc.biz.CollectBiz;
import com.yc.dao.CollectDao;
@Service
public class CollectBizImpl implements CollectBiz {
	@Resource
	CollectDao dao;
	
	

	
		

	public void addCol(Collect collect) {
		dao.save(collect);
	}

	@Override
	public void delCol(Integer collectid) {
		dao.delete(collectid);
	}

	@Override
	public int findCol(Integer uid,Integer gid) {
		List<Object> list=dao.findCol(uid, gid);
		System.out.println("list="+list);
		if(list.isEmpty()){
			return 0;
		}else {
			return 1;
		}
	}

	public List<Collect> findCollectByPage(Integer page, Integer size,Integer uid) {
		Pageable pageable= new PageRequest(page-1, size, Sort.Direction.ASC, "collectid");

		
		return dao.findColPageByUid(uid, pageable);
	}

	@Override
	public long countCollect(Integer uid) {
		return dao.countCol(uid);

	}

}
