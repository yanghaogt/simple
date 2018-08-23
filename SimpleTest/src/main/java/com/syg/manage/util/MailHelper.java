package com.syg.manage.util;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.syg.manage.cfg.GlobalConfig;

public class MailHelper {

	public static void sendMail(String targetEmail,String htmlText,String subject) throws MessagingException{
		 JavaMailSenderImpl senderImpl = new JavaMailSenderImpl(); 
		    
		    //设定mail server 
		    senderImpl.setHost(GlobalConfig.getDef().getValue("email_host")); 
		    
		    //建立邮件消息,发送简单邮件和html邮件的区别 
		    
		    MimeMessage mailMessage = senderImpl.createMimeMessage(); 
		    MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage ,true,"utf-8"); 
		             
		    //设置收件人，寄件人 
		    messageHelper.setTo(targetEmail);
		    messageHelper.setFrom(GlobalConfig.getDef().getValue("email_from")); 
		    messageHelper.setSubject(subject);
		    //true 表示启动HTML格式的邮件
		    messageHelper.setText(htmlText,true);
		    
		    senderImpl.setUsername(GlobalConfig.getDef().getValue("email_username")) ; // 根据自己的情况,设置username
		    senderImpl.setPassword(GlobalConfig.getDef().getValue("email_password")) ; // 根据自己的情况, 设置password
		    Properties prop = new Properties() ;
		    prop.put("mail.smtp.auth", "true") ; // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
		    prop.put("mail.smtp.timeout", "25000") ;
		    senderImpl.setJavaMailProperties(prop);
		    //发送邮件 
		    senderImpl.send(mailMessage); 
	}
}
