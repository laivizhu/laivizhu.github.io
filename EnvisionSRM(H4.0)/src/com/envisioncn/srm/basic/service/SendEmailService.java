package com.envisioncn.srm.basic.service;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.envisioncn.srm.basic.model.SRMException;
import com.envisioncn.srm.basic.model.constants.ErrorMessageConstants;

import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service("SendEmailService")
public class SendEmailService {

	private JavaMailSender mailSender;

	private FreeMarkerConfigurer freeMarkerConfigurer;

	@Value("${email.systemEmail}")
	private String systemEmail;

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	@Resource(name = "mailSender")
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Resource(name = "freeMaker")
	public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer) {
		this.freeMarkerConfigurer = freeMarkerConfigurer;
	}

	public String getSystemEmail() {
		return systemEmail;
	}

	public void setSystemEmail(String systemEmail) {
		this.systemEmail = systemEmail;
	}

	public String getMailText(Map<String, String> map, String templateFileName) throws SRMException {
		String htmlText = null;
		try {
			Template tpl = freeMarkerConfigurer.getConfiguration().getTemplate(templateFileName);
			htmlText = FreeMarkerTemplateUtils.processTemplateIntoString(tpl, map);
		} catch (IOException e) {
			throw new SRMException(ErrorMessageConstants.EmailService.EMAIL_TEMPLATE_LONGDINGERROR);
		} catch (TemplateException e) {
			throw new SRMException(ErrorMessageConstants.EmailService.EMAIL_TEMPLATE_NOTFOUNT);
		}
		return htmlText;
	}

	public void sendMail(String to, String subject, String htmlText) throws SRMException {
		MimeMessage msg = mailSender.createMimeMessage();
		MimeMessageHelper msgHelper;
		try {
			msgHelper = new MimeMessageHelper(msg, true, "utf-8");
			msgHelper.setFrom(systemEmail);
			msgHelper.setTo(to);
			msgHelper.setSubject(subject);
			msgHelper.setText(htmlText, true);
			mailSender.send(msg);
		} catch (MessagingException e) {
			throw new SRMException(ErrorMessageConstants.EmailService.EMAIL_SEND_ERROR);
		}
	}

	public void sendMail(String to, String subject, String htmlText, File file) throws SRMException {
		MimeMessage msg = mailSender.createMimeMessage();
		MimeMessageHelper msgHelper;
		try {
			msgHelper = new MimeMessageHelper(msg, true, "utf-8");
			msgHelper.setFrom(systemEmail);
			msgHelper.setTo(to);
			msgHelper.setSubject(subject);
			msgHelper.addAttachment(MimeUtility.encodeWord(file.getName()), file);
			msgHelper.setText(htmlText, true);
			mailSender.send(msg);
		} catch (MessagingException e) {
			throw new SRMException(ErrorMessageConstants.EmailService.EMAIL_SEND_ERROR);
		} catch (UnsupportedEncodingException e) {
			throw new SRMException(ErrorMessageConstants.EmailService.EMAIL_TEMPLATE_LONGDINGERROR);
		}
	}

}
