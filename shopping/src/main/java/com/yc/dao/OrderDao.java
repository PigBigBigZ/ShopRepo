package com.yc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yc.bean.Orderform;

public interface OrderDao extends JpaRepository<Orderform, Integer>{
   
}
