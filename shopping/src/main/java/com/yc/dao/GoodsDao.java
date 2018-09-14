package com.yc.dao;


import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yc.bean.Goods;
import com.yc.bean.ShopAndImg;
@Repository
public interface GoodsDao extends JpaRepository<Goods, Integer>{
	//@Query(nativeQuery=true,value="insert into goods values (null,#{#g.Gname},#{#g.Gprice},#{#g.gtype.typeid},#{#g.Gcount},#{#g.image.imgid},#{#g.Gsail})")
    //void insertGoods(@Param("g")Goods goods);
	@Query(nativeQuery=true,value="select c.Gname,c.Gprice,b.path,c.imgid,b.imgname from goods c LEFT JOIN image b on b.imgid=c.imgid")
	List<Object[]> findAllGoods();
}
