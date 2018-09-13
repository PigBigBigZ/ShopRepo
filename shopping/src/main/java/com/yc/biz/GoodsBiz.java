package com.yc.biz;

import java.util.List;
import java.util.Map;

import com.yc.bean.Goods;

public interface GoodsBiz {
    public void addGoods(Goods goods);
    
    public void updataGoods();
    
    public List<Map<String, Object>> findAllGoods();
    
}
