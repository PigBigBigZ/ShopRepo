package com.yc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yc.bean.Goods;
@Repository
public interface GoodsDao extends JpaRepository<Goods, Integer>{
	//@Query(nativeQuery=true,value="insert into goods values (null,#{#g.Gname},#{#g.Gprice},#{#g.gtype.typeid},#{#g.Gcount},#{#g.image.imgid},#{#g.Gsail})")
    //void insertGoods(@Param("g")Goods goods);
	
	@Query(nativeQuery=true,value="select c.Gname,c.Gprice,b.path,c.imgid,b.imgname from goods c LEFT JOIN image b on b.imgid=c.imgid")
	List<Object[]> findAllGoods();
	
	@Query(nativeQuery=true,value="select Gname,b.typename,a.Gprice,c.imgname from goods a LEFT JOIN gtype b on a.gtypeid=b.typeid LEFT JOIN (SELECT imgname,imgid from image) c on a.imgid=c.imgid where a.gtypeid=?" )
	List<Object[]> findChildGoods(Integer gtypeid);
	
	@Query(nativeQuery=true,value="select Gname,b.typename,a.Gprice,c.imgname from goods a LEFT JOIN gtype b on a.gtypeid=b.typeid LEFT JOIN (SELECT imgname,imgid from image) c on a.imgid=c.imgid where a.gtypeid=?" )
	List<Object[]> findGoodsAndImg(Integer gtypeid);
	
	@Query(nativeQuery=true,value="select gtypeid from goods a LEFT JOIN gtype b on a.gtypeid=b.typeid GROUP BY gtypeid" )
	List<Integer> GroupByTypeid();
}
