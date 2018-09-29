package com.yc.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yc.bean.Address;
import com.yc.bean.User;
import com.yc.biz.AddressBiz;

@Controller
public class AddressAction {
	@Resource
	AddressBiz biz;

	/**
	 * 显示用户地址
	 * @param session
	 * @param model
	 */
	
	@RequestMapping("addAddress.do")
	public String addAddress(HttpSession session,HttpSession model) {
      User user= (User) session.getAttribute("logineduser");
      Integer uid= user.getUid();
      List<Address> list= biz.findByUid(uid);
      model.setAttribute("addresslist", list);
	  return "pay";
	}
	/**
	 * 添加用户地址
	 */
	@RequestMapping("address.do")
	public String Address(String username,String userphone,String sf,String cs,String dq,String userintro,HttpSession session,HttpSession model ){
		Address address=new Address();
		User user= (User) session.getAttribute("logineduser");
	    Integer uid= user.getUid();
	    User user2=new User();
	    user2.setUid(uid);
		address.setUser(user2);
	    address.setAddname(username);
		address.setPhone(userphone);
		address.setProvince(sf);
		address.setCity(cs);
		address.setDist(dq);
		address.setAddress(userintro);
		address.setStreet(null);
		biz.saveAddress(address);
		return "redirect:person/address.jsp";
		
	}
	
	@RequestMapping("deleteAddress.do")
	public String deleteAddress(HttpSession session,Integer addrid ){
		System.out.println(addrid);
		biz.deleteAddress(addrid);
		return "redirect:person/address.jsp";
	}
	
	

}
