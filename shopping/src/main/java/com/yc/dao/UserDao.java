package com.yc.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.yc.bean.User;

public interface UserDao extends JpaRepository<User, Integer>{


	User findUserByEmailAndUpass(String userinput, String upass);

	User findUserByPhoneAndUpass(String userinput, String upass);
	
	User findUserByUnameAndUpass(String userinput,String upass);
	
	User findUserByUname(String uname);

	User findUserByEmail(String email);

	User findUserByPhone(String phone);

}
