package com.yc.biz;


import java.util.List;

import org.springframework.data.domain.Page;

import com.yc.bean.Goods;

public interface GoodsBiz {
    public void addGoods(Goods goods);
    
    public void updataGoods(Goods goods);
    
    //分页查看商品详情
    public Page<Goods> findGoodsByPage(Integer page,Integer size);
    
    //统计商品总数
    public long countGoods();
    
    //根据id删除商品
    public void delGoods(Integer id);
    
    public Goods findGoodsById(Integer gid);
    
    public List<Goods> findAllGoods();
}
