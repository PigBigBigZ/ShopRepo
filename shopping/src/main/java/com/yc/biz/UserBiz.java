package com.yc.biz;



import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yc.bean.User;
import com.yc.biz.impl.BizException;


@Service
public interface UserBiz{
	public void regByEmail(String email,String uname,String upass, String reupass, String ecode,HttpSession session) throws BizException;
	
	public void regByPhone(String phone,String uname,String upass, String reupass, String pcode,HttpSession session) throws BizException;

	public boolean login(String userinput,String upass,String pcode,HttpSession session);
	
	
	

}

