package com.yc.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

public class SendEmailUtils {
	
	public static String sendEmail(String email) throws MessagingException{
		//String regemail = (String) session.getAttribute("regemail");
		//String message="http://localhost:8080/shopping/check3.jsp?username="+reguname;//生成url地址和传递参数
		String emailcode = RandomMessageUtils.getRandNum();
		String text = "您的验证码为："+emailcode;
		Properties pros=new Properties();
		Transport transport;
		pros.put("mail.smtp.host", "smtp.163.com"); //我是用163邮箱发的邮件，所以smtp主机是smtp.163.com,用其他邮箱需要查一下smtp主机，一般为smtp.***.com
		pros.put("mail.smtp.auth","true");
		Session sendmailsession=Session.getInstance(pros);
		sendmailsession.setDebug(true);
		Message newMessage=new MimeMessage(sendmailsession);
		newMessage.setFrom(new InternetAddress("489269207@163.com"));//这里输入发送的邮箱地址
		newMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email));//这里的to替换成用户输入的收件箱，也就是String to=request.getParameter("email")之类的
		newMessage.setSubject("请获取您的验证码!");//输入主题（subject是一个字符串）
		newMessage.setSentDate(new Date());//输入日期
		//newMessage.setContent(content(session),"text/html;charset=UTF-8");//或者setText("一段字符串")
		//newMessage.setContent(text,"text/plain");
		newMessage.setText(text);
		transport=sendmailsession.getTransport("smtp");//此处不变
		transport.connect("smtp.163.com","489269207@163.com","a123456");//这里比较麻烦，第一个是发送邮件的代理主机，第二个是发送邮箱的地址，第三个是发送邮箱的授权密码（而不是登录密码)
		transport.sendMessage(newMessage, newMessage.getAllRecipients());
		transport.close();
		
		return emailcode;
		
		
	}
	

	
	

	
}

