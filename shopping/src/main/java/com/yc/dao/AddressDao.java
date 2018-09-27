package com.yc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yc.bean.Address;

	public interface AddressDao extends JpaRepository<Address, Integer>{
		
		@Query(nativeQuery=true,value="select * from address where uid=?")
		public List<Address> findByUid(Integer uid);
	   
	}
