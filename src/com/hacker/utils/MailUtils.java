package com.hacker.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailUtils {

	private static final String sendMailUserName = "13219630317@163.com";// 发送邮件的用户名(地址)
	private static final String sendMailPassword = "wxl123456";// 密码
//	private static final String sendMailSmtpHostName = "wxl123456"; // SMTP主机地址

	/**
	 * 发送激活邮件
	 * 
	 * @param to
	 *            ：给谁发邮件
	 * @param code：激活码
	 * @param subject：邮件主题
	 * @throws Exception
	 */
	public static void sendMail(String to, String code, String subject) throws Exception {
		// 1.创建连接对象,连接到邮件服务器

		Properties arg0 = new Properties();
		// arg0.setProperty(key, value);//主机名 服务器地址
		// 初始化props
		// 通过邮箱地址解析出smtp服务器，对大多数邮箱都管用
		final String smtpHostName = "smtp." + sendMailUserName.split("@")[1];

		arg0.put("mail.smtp.auth", "true");
		arg0.put("mail.smtp.host", smtpHostName);

		Session session = Session.getInstance(arg0, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				// userName, password 发送邮箱的账号和密码
				return new PasswordAuthentication(sendMailUserName, sendMailPassword);
			}

		});

		// 2.创建邮件对象
		Message message = new MimeMessage(session);
		// 2.1设置发件人
		message.setFrom(new InternetAddress(sendMailUserName));
		// 2.2设置收件人
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		// 2.3设置主题
		message.setSubject(subject);
		// 2.4设置邮件的正文
		message.setContent(
				"<h1>来自XXX网站的激活邮件，激活请点击以下链接，</h1><h3><a href='http://localhost:8080/mail_regist_web/ActiveServlet?code="
						+ code + "'> href='http://localhost:8080/mail_regist_web/ActiveServlet?code=" + code
						+ "</a></h3>",
				"text/html;charset=UTF-8");
		;
		// 3.发送邮件
		Transport.send(message);

	}
}
