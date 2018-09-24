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
		if(userinput.matches(em)){
			user=dao.findUserByEmailAndUpass(userinput,MD5Utils.md5(upass));
			
			
		}else if(userinput.matches(ph)){
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

	/**
	 * 通过邮箱注册
	 */
	public void regByEmail(String email, String uname, String upass, String reupass, String ecode, HttpSession session)throws BizException {
		
		User user = new User();
		String emailcode = (String) session.getAttribute("ecode");
		user.setEmail(email);
		user.setUname(uname);
		user.setUpass(MD5Utils.md5(upass));
		
		
		String uemail = user.getEmail();
		String name = user.getUname();
		User user1 = new User();
		User user2 = new User();
		//校验合法性
		if(user.getUname() == null || user.getUname().trim().isEmpty()){
			throw new BizException("请输入用户名!");
		}
		if(user.getUpass() == null || user.getUpass().trim().isEmpty()){
			throw new BizException("请输入密码!");
		}
		if(!user.getUpass().equals(MD5Utils.md5(reupass)) ){
			throw new BizException("确认密码与密码不一致!");
		}
		user1 = dao.findUserByUname(name);
		if(user1!=null){
			throw new BizException("用户名已存在!");
		} 
		user2 = dao.findUserByPhone(uemail);
		if(user2!=null){
			throw new BizException("邮箱已被注册!");
		}
		if(!ecode.equals(emailcode)){
			throw new BizException("验证码错误!");
		}
		dao.save(user);
	}

	/**
	 * 通过手机注册
	 */
	public void regByPhone(String phone, String uname, String upass, String reupass, String pcode, HttpSession session)throws BizException {
		User user = new User();
		String phonecode = (String) session.getAttribute("pcode");
		//System.out.println(phonecode+"这个是验证码");
		//System.out.println(pcode+"这是用户输入的验证码");
		user.setPhone(phone);
		user.setUname(uname);
		user.setUpass(MD5Utils.md5(upass));
		String phonenum = user.getPhone();
		String name = user.getUname();
		User user1 = new User();
		User user2 = new User();
		//校验合法性
		if(user.getUname() == null || user.getUname().trim().isEmpty()){
			throw new BizException("请输入用户名!");
		}
		if(user.getUpass() == null || user.getUpass().trim().isEmpty()){
			throw new BizException("请输入密码!");
		}
		if(!user.getUpass().equals(MD5Utils.md5(reupass)) ){
			throw new BizException("确认密码与密码不一致!");
		}
		user1 = dao.findUserByUname(name);
		if(user1!=null){
			throw new BizException("用户名已存在!");
		} 
		user2 = dao.findUserByPhone(phonenum);
		if(user2!=null){
			throw new BizException("手机号已被注册!");
		}
		if(!pcode.equals(phonecode)){
			throw new BizException("验证码错误!");
		}
		dao.save(user);		
	}
	
	

	
	
	



	


}
