package com.yc.dao;


import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.yc.bean.Collect;

@Repository
public interface CollectDao extends JpaRepository<Collect, Integer>{

	@Query(nativeQuery=true,value="select * from collect where uid=?1 and gid=?2")
	List<Object> findCol(Integer uid,Integer gid);
	
	@Query(nativeQuery=true,value="select count(*) from collect where uid=?")
	Long countCol(Integer uid);

}
