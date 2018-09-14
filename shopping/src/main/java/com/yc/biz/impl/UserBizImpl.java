package com.yc.biz.impl;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.yc.bean.User;
import com.yc.biz.UserBiz;
import com.yc.dao.UserDao;
import com.yc.utils.GetMessageUtils;
import com.yc.utils.MD5Utils;

@Service
@Transactional
public class UserBizImpl implements UserBiz{
	
	@Resource
	UserDao dao;	
		



	
	public boolean login(String userinput,String upass,String pcode,HttpSession session) {
		
		//邮箱与手机的表达式(用于验证是邮箱还是手机)
		String em =  "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
		String ph = "^[1][3578]\\d{9}$";
		
		User user = new User();
		System.out.println(dao.findUserByUnameAndUpass(userinput,upass));
		if(userinput.equals(em)){
			user=dao.findUserByEmailAndUpass(userinput,MD5Utils.md5(upass));
			
			
		}else if(userinput.equals(ph)){
			user=dao.findUserByPhoneAndUpass(userinput,MD5Utils.md5(upass));
		}else{
			user=dao.findUserByUnameAndUpass(userinput,MD5Utils.md5(upass));
			System.out.println(user+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
		
		if(user!=null){
			return true;
		}else{
			return false;
		}
		
	
		
		
		
	}


	@Override
	public boolean regByEmail(String email, String uname, String upass) {
		// TODO Auto-generated method stub
		System.out.println(email+"=="+uname+"=="+upass);
		
		User user = new User();
		
			
			user.setEmail(email);
			user.setUname(uname);
			user.setUpass(MD5Utils.md5(upass));
			dao.save(user);
			System.out.println(user);
			user = dao.findUserByUname(uname);
			
			if(user!=null){
				return true;
			}else{
				return false;
			}
		
	}


	@Override
	public boolean regByPhone(String phone, String uname, String upass, String pcode, HttpSession session) {
		// TODO Auto-generated method stub
		User user = new User();
		String phonecode = (String) session.getAttribute("pcode");
		//System.out.println(phonecode+"这个是验证码");
		//System.out.println(pcode+"这是用户输入的验证码");
		
		if(pcode.equals(phonecode)){
		user.setPhone(phone);
		user.setUname(uname);
		user.setUpass(MD5Utils.md5(upass));
		dao.save(user);
		}
		user = dao.findUserByUname(uname);
		if(user!=null){
			return true;
		}else{
			return false;
		}
		
	}
	
	
	/**
	 * 查重方法
	 * @param session
	 * @param phone
	 * @param uname
	 * @param email
	 */
	public int checkuserinput (HttpSession session,String phone,String uname,String email){
		ModelAndView mav = new ModelAndView();
		User user1 = new User();
		User user2 = new User();
		User user3 = new User();
		user1 = dao.findUserByUname(uname);
		
		user2 = dao.findUserByEmail(email);
		System.out.println(user2);
		user3 = dao.findUserByPhone(phone);
		if(user1!=null){
			return 1;
		}
		
		else if(user2!=null){
			System.out.println(2);
			return 2;
		}
		
		else if(user3!=null){
			return 3;
		}else{
		
		return 0;
		}
	}


}
