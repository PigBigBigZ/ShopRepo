package com.yc.biz;

import java.util.List;

import org.springframework.data.domain.Page;

import com.yc.bean.Gtype;

public interface GtypeBiz {
	public void addGtype(Gtype gtype);
	
	public void updateGtype(Gtype gtype);
	
	public void delGtype(Integer id);
	
	public Gtype findGtypeById(Integer id);
	
	public long countGtype();
	
	public Page<Gtype> findGtypeByPage(Integer page,Integer size);
	
	public void findAllGtype();
	
	public List<Gtype> findAll();
}
