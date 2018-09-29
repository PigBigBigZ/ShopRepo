package com.yc.web.controller;

import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yc.bean.Address;
import com.yc.bean.Orderform;
import com.yc.bean.User;
import com.yc.biz.impl.OrderBizImpl;

@Controller
public class OrderAction {
  @Resource OrderBizImpl oBizImpl;
  
  
  @RequestMapping("addOrderform.do")
  public String AddOrderform(HttpSession session,Double AllCount){
	//String AllCount=request.getParameter("AllCount");
	System.out.println(AllCount);  
	Orderform orderform=new Orderform();
	User user=(User) session.getAttribute("logineduser");
	user.getUid();
	Address address=new Address();
	address.setAddrid(1);
	orderform.setSpdate(new Timestamp(System.currentTimeMillis()));
	orderform.setAddress(address);
	orderform.setAllprice(AllCount);
	orderform.setUser(user);
	orderform.setOstatus(2);
	oBizImpl.insertOrder(orderform);
	return "success";
  }
}
