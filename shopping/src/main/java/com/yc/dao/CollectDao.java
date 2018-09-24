package com.yc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yc.bean.Collect;

@Repository
public interface CollectDao extends JpaRepository<Collect, Integer>{
	
}
