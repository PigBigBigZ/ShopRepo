package com.yc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yc.bean.Gtype;

@Repository
public interface GtypeDao extends JpaRepository<Gtype,Integer>{
	
}
