package com.yc.biz;

import java.util.List;

import com.yc.bean.Address;

public interface AddressBiz {
    public void saveAddress(Address address);
    
    public List<Address> findByUid(Integer uid);
}
