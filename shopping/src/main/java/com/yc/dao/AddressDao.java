package com.yc.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.experimental.categories.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.yc.bean.Address;

	public interface AddressDao extends JpaRepository<Address, Integer>{
		
		@Query(nativeQuery=true,value="select * from address where uid=? and status=0")
		public List<Address> findByUid(Integer uid);
		
		@Transactional
		@Modifying
		@Query(nativeQuery=true,value="update address set status=1 where addrid=?")
		public void deleteAddress(Integer addrid);
		
	}
