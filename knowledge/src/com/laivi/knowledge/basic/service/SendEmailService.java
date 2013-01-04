package com.laivi.knowledge.basic.service;

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

import com.laivi.knowledge.basic.model.constants.ErrorMessageConstants;
import com.laivi.knowledge.basic.model.exception.ErrorException;
import com.laivi.knowledge.basic.util.DataUtil;

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

	/**
	 * 获取文件内容
	 * @param map(邮件内容中参数键值对)
	 * @param templateFileName(内容的FreeMaker文件模板名)
	 * @return
	 * @throws ErrorException
	 */
	public String getMailText(Map<String, String> map, String templateFileName) throws ErrorException {
		String htmlText = null;
		try {
			Template tpl = freeMarkerConfigurer.getConfiguration().getTemplate(templateFileName);
			htmlText = FreeMarkerTemplateUtils.processTemplateIntoString(tpl, map);
		} catch (IOException e) {
			throw new ErrorException(ErrorMessageConstants.EmailService.EMAIL_TEMPLATE_LONGDINGERROR);
		} catch (TemplateException e) {
			throw new ErrorException(ErrorMessageConstants.EmailService.EMAIL_TEMPLATE_NOTFOUNT);
		}
		return htmlText;
	}

	/**
	 * 发送邮件
	 * @param to：发送用户
	 * @param cc：抄送人
	 * @param subject：邮件主题
	 * @param htmlText：邮件内容
	 * @param file：附件
	 * @throws ErrorException
	 */
	public void sendMail(String to, String cc,String subject, String htmlText, File file) throws ErrorException {
		MimeMessage msg = mailSender.createMimeMessage();
		MimeMessageHelper msgHelper;
		try {
			msgHelper = new MimeMessageHelper(msg, true, "utf-8");
			msgHelper.setFrom(systemEmail);
			msgHelper.setTo(to);
			msgHelper.setSubject(subject);
			if(DataUtil.notEmptyString(cc)){
				msgHelper.setCc(cc);
			}
			if(file!=null){
				msgHelper.addAttachment(MimeUtility.encodeWord(file.getName()), file);
			}
			msgHelper.setText(htmlText, true);
			mailSender.send(msg);
		} catch (MessagingException e) {
			throw new ErrorException(ErrorMessageConstants.EmailService.EMAIL_SEND_ERROR);
		} catch (UnsupportedEncodingException e) {
			throw new ErrorException(ErrorMessageConstants.EmailService.EMAIL_TEMPLATE_LONGDINGERROR);
		}
	}
	
	public void sendMail(String to,String cc,String subject,String htmlText)throws ErrorException{
		sendMail(to,cc,subject,htmlText,null);
	}

	public void sendMail(String to, String subject, String htmlText) throws ErrorException {
		sendMail(to,null,subject,htmlText,null);
	}

}
