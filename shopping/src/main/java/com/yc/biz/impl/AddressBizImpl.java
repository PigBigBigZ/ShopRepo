package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.Address;
import com.yc.biz.AddressBiz;
import com.yc.dao.AddressDao;
@Service
public class AddressBizImpl implements AddressBiz {
    @Resource
    private AddressDao dao;
	
	public void saveAddress(Address address) {
		dao.save(address);
	}

	public List<Address> findByUid(Integer uid) {
		return dao.findByUid(uid);
	}

	
	public void deleteAddress(Integer addrid) {
		dao.deleteAddress(addrid);
	}
}
