package com.yc.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

public class SendEmailUtils {
	
	public void sendEmail(HttpSession session){

//		Properties pros=new Properties();
//		Transport transport;
//		pros.put("mail.smtp.host", "smtp.163.com"); //我是用163邮箱发的邮件，所以smtp主机是smtp.163.com,用其他邮箱需要查一下smtp主机，一般为smtp.***.com
//		pros.put("mail.smtp.auth","true");
//		Session sendmailsession=Session.getInstance(pros);
//		sendmailsession.setDebug(true);
//		Message newMessage=new MimeMessage(sendmailsession);
//		newMessage.setFrom(new InternetAddress("489269207@163.com"));//这里输入发送的邮箱地址
//		newMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));//这里的to替换成用户输入的收件箱，也就是String to=request.getParameter("email")之类的
//		newMessage.setSubject("您已注册成功!");//输入主题（subject是一个字符串）
//		newMessage.setSentDate(new Date());//输入日期
//		newMessage.setContent(emailContent.toString(),"text/html;charset=UTF-8");//或者setText("一段字符串")
//		transport=sendmailsession.getTransport("smtp");//此处不变
//		transport.connect("smtp.163.com","邮箱地址匿了","授权密码匿了");//这里比较麻烦，第一个是发送邮件的代理主机，第二个是发送邮箱的地址，第三个是发送邮箱的授权密码（而不是登录密码)
//		transport.sendMessage(newMessage, newMessage.getAllRecipients());
//		transport.close();
//	}
//	
//	public class emailContent{
//		private Object emailContent(HttpSession session){
//		String message="http://localhost:8080/changshi3/check3.jsp?username="+request.getParameter("username");//生成url地址和传递参数(这里就直接用本地了)
//		StringBuilder emailContent = new StringBuilder()  
//        .append("您已经注册成功：<span style=\"color: #F3750F;font-weight: bold;font-size: larger;font-family: cursive;\">") 
//        .append("<a href=\"")
//        .append(message)
//        .append("\">") 
//        .append("点击此链接跳转")
//        .append("</a>")
//        .append("</span><br/>")  
//        .append("此链接只能使用一次，验证成功自动失效；<br/>")  
//        .append("<div style=\"font-size: small;color: gray;\">")  
//        .append("(请在10分钟内完成验证，10分钟后验证码失效，您需要重新进行验证。感谢您的支持。)<br/>")  
//        .append("如果您错误的收到了本电子邮件，请您忽略上述内容<br/>").append("</div>"); 
//		return emailContent(session);
//		}
//	}
}
}
