package com.yc.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yc.bean.Address;
import com.yc.bean.User;
import com.yc.biz.AddressBiz;

@Controller
public class AddressAction {
	@Resource
	AddressBiz biz;

	@RequestMapping("AddAddress.do")
	public void addAddress(HttpSession session,Model model) {
      User user= (User) session.getAttribute("logineduser");
      Integer uid= user.getUid();
      List<Address> list= biz.findByUid(uid);
      model.addAttribute("addresslist", list);
      
	}
	
	

}
