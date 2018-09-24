package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.yc.bean.Gtype;
import com.yc.biz.GtypeBiz;
import com.yc.dao.GtypeDao;

@Service
public class GtypeBizImpl implements GtypeBiz {
	@Resource
	GtypeDao dao;
	
	@Override
	public void addGtype(Gtype gtype) {
		dao.save(gtype);
	}

	@Override
	public void updateGtype(Gtype gtype) {
		dao.save(gtype);
	}

	@Override
	public void delGtype(Integer id) {
		dao.delete(id);
	}

	@Override
	public Gtype findGtypeById(Integer id) {
		return dao.findOne(id);
	}

	@Override
	public long countGtype() {
		return dao.count();
	}

	@Override
	public Page<Gtype> findGtypeByPage(Integer page, Integer size) {
		Pageable pageable= new PageRequest(page-1, size, Sort.Direction.ASC, "typeid");
		return dao.findAll(pageable);
	}

	@Override
	public void findAllGtype() {
		dao.findAll();
	}
	
	public List<Gtype> findAll(){
		return dao.findAll();
	}

}
