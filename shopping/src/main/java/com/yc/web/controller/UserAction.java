package com.yc.web.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yc.bean.User;
import com.yc.biz.UserBiz;
import com.yc.biz.impl.BizException;
import com.yc.utils.GetMessageUtils;



@Controller
public class UserAction {

	@Resource
	private UserBiz ubiz;
	
	//	public String login(String uname,String upass,@Param(value = "userinput")String userinput,HttpSession session,Model model)
	@RequestMapping("login.do")
	public String login(String uname,String upass,String userinput,String pcode,HttpSession session,Model model){
		System.out.println(userinput+"========"+upass);
		
		if(ubiz.login( userinput,upass,pcode,session)){
			
			session.setAttribute("username", uname);
			session.setAttribute("password", upass);
			return "home3";
		}else{
			String msg = "用户名或密码错误";
			model.addAttribute("msg", msg);
			model.addAttribute(msg);
			return "redirect:home/login.jsp";
		}
	}
	

	
	@RequestMapping("registerByEmail.do")
	public ModelAndView registerByEmail(String email,String uname,String upass,String reupass,String ecode,HttpSession session){
		session.setAttribute("reguname", uname);
		session.setAttribute("regemail", email);
		ModelAndView mav;
		User user = new User();
		user.setUname(uname);
		user.setUpass(upass);
		user.setPhone(email);
		try {
			ubiz.regByEmail(email, uname, upass, reupass, ecode, session);
			mav = new ModelAndView("redirect:home/login.jsp");
		} catch (BizException e) {
			e.printStackTrace();
			//获取报错信息
			String msg = e.getMessage();
			//跳转注册页面
			mav = new ModelAndView("redirect:home/register.jsp");
			mav.addObject("msg", msg);
			System.out.println(mav);
		}
		return mav;
	}
	
	/**
	 * 1、读会话中的随机码
	 * 2、比对用户输入的随机码
	 * @param phone
	 * @param uname
	 * @param upass
	 * @param pcode
	 * @param session
	 * @return
	 */
	@RequestMapping("registerByPhone.do")
	public ModelAndView registerByPhone(String phone,String uname,String upass,String reupass,String pcode, HttpSession session){
		ModelAndView mav;
		User user = new User();
		user.setUname(uname);
		user.setUpass(upass);
		user.setPhone(phone);
		try {
			ubiz.regByPhone(phone, uname, upass, reupass, pcode, session);
			mav = new ModelAndView("redirect:home/login.jsp");
		} catch (BizException e) {
			e.printStackTrace();
			//获取报错信息
			String msg = e.getMessage();
			//跳转注册页面
			mav = new ModelAndView("redirect:home/register.jsp");
			mav.addObject("msg", msg);
			System.out.println(mav);
		}	
		return mav;
	}
	
	/**
	 * 发送方法
	 * 1、生成随机码
	 * 2、将随机码存入会话
	 * 3、通知用验证码发送成功
	 */
	@RequestMapping("getpcode.do")
	public void sendcode (HttpSession session,String phone){
		String pcode = GetMessageUtils.getResult(phone);
		System.out.println(pcode);
		session.setAttribute("pcode", pcode);
	}
	
}	





