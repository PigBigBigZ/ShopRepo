package com.yc.biz;


import java.util.List;


import com.yc.bean.Collect;

public interface CollectBiz {
	public void addCol(Collect collect);
	
	public void delCol(Integer collectid);
	
	//判断是否已经收藏过某个商品
	public int findCol(Integer uid,Integer gid);
	
    //分页查看收藏详情
    public List<Collect> findCollectByPage(Integer page,Integer size,Integer uid);
    
    //统计某用户收藏商品总数
    public long countCollect(Integer uid);

}
