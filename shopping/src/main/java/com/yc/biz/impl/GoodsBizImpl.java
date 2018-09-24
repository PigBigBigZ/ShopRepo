package com.yc.biz.impl;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

	public void updataGoods(Goods goods) {
		dao.save(goods);
	}

	@Override
	//分页显示商品
	public Page<Goods> findGoodsByPage(Integer page, Integer size) {
		Pageable pageable= new PageRequest(page-1, size, Sort.Direction.ASC, "gid");
		return dao.findAll(pageable);
	}


	@Override
	//统计商品总数
	public long countGoods() {
		return dao.count();
		
	}

	@Override
	public void delGoods(Integer id) {
		dao.delete(id);
	}

	@Override
	public Goods findGoodsById(Integer gid) {
		return dao.findOne(gid);
	}

	@Override
	public List<Goods> findAllGoods() {
		return dao.findAll();
	}

   
}
