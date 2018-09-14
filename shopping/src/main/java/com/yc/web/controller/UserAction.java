package com.yc.web.controller;

<<<<<<< HEAD
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yc.bean.User;
import com.yc.biz.UserBiz;
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
	public ModelAndView registerByEmail(String email,String uname,String upass,String phone,HttpSession session){
		ModelAndView mav;
		
			int i=ubiz.checkuserinput(session, phone,uname, email);
			System.out.println(i);
			switch(i){
			case 1 :
				System.out.println(1);
				mav = new ModelAndView("redirect:home/register.jsp");
				mav.addObject("msg","用户名已注册!");
				break;
			case 2 :
				System.out.println(2);
				mav = new ModelAndView("redirect:home/register.jsp");
				mav.addObject("msg","邮箱已注册!");
				break;
			case 3 :
				System.out.println(3);
				mav = new ModelAndView("redirect:home/register.jsp");
				mav.addObject("msg","手机号已注册!");
				break;
			default :
				System.out.println("default");
				if(ubiz.regByEmail(email,uname,upass)){
					mav = new ModelAndView("redirect:home/login.jsp");
				}else{
					mav = new ModelAndView("redirect:home/register.jsp");
					mav.addObject("msg","用户注册失败!");
				}
				break;
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
	public ModelAndView registerByPhone(String phone,String uname,String upass,String pcode, HttpSession session){
		ModelAndView mav;
		
		if(ubiz.regByPhone(phone, uname, upass, pcode, session)){
			mav = new ModelAndView("redirect:home/login.jsp");
		}else{
			mav = new ModelAndView("redirect:home/register.jsp");
			mav.addObject("msg","用户注册失败!");
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
	
	

=======
import org.springframework.stereotype.Controller;

@Controller
public class UserAction {

	
>>>>>>> branch 'master' of https://github.com/PigBigBigZ/ShopRepo.git
	
}
