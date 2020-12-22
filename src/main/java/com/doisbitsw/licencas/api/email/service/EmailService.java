package com.doisbitsw.licencas.api.email.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import org.springframework.stereotype.Service;

import com.doisbitsw.licencas.api.email.domain.User;

import javax.mail.MessagingException;


@Service
public class EmailService {



	private final JavaMailSender javaMailSender;

	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendMail(User user) throws MessagingException {
		javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		helper.setSubject("Welcome " + user.getFirstName());

		String html = "<!doctype html>\n" +
				"<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\"\n" +
				"      xmlns:th=\"http://www.thymeleaf.org\">\n" +
				"<head>\n" +
				"    <meta charset=\"UTF-8\">\n" +
				"    <meta name=\"viewport\"\n" +
				"          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
				"    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
				"    <title>Email</title>\n" +
				"</head>\n" +
				"<body>\n" +
				"<div>Welcome meu <b>" + user.getFirstName() + "</b></div>\n" +
				"\n" +
				"<div> Your username is <b>" + user.getLastName() + "</b></div>\n" +
				"</body>\n" +
				"</html>\n";
		helper.setText(html, true);
		helper.setTo(user.getEmailAddress());
		javaMailSender.send(mimeMessage);
	}
}