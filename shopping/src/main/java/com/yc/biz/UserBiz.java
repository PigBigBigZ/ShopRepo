package com.yc.biz;

<<<<<<< HEAD

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;


@Service
public interface UserBiz{
	public boolean regByEmail(String email,String uname,String upass);
	
	public boolean regByPhone(String phone,String uname,String upass, String pcode,HttpSession session);

	public boolean login(String userinput,String upass,String pcode,HttpSession session);
	
	public int checkuserinput (HttpSession session,String phone,String uname,String email);

=======
public interface UserBiz {
	
>>>>>>> branch 'master' of https://github.com/PigBigBigZ/ShopRepo.git
}
