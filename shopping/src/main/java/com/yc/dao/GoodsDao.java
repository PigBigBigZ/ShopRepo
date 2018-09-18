package com.yc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yc.bean.Goods;
@Repository
public interface GoodsDao extends JpaRepository<Goods, Integer>{
	//@Query(nativeQuery=true,value="insert into goods values (null,#{#g.Gname},#{#g.Gprice},#{#g.gtype.typeid},#{#g.Gcount},#{#g.image.imgid},#{#g.Gsail})")
    //void insertGoods(@Param("g")Goods goods);
}
