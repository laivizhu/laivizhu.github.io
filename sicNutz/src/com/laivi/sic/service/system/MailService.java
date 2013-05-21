package com.laivi.sic.service.system;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

import com.laivi.sic.util.basic.DataUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@IocBean
public class MailService {
	@Inject("refer:multiMail")
	private MultiPartEmail mail;
	
	@Inject
	private EmailAttachment attachMail;
	
	@Inject
	private Configuration freeMaker;

	
	public String getMailText(Map<String, Object> map, String path,String templateFileName){
		StringWriter writer = new StringWriter();
		try {
			freeMaker.setDefaultEncoding("utf-8");
			freeMaker.setDirectoryForTemplateLoading(new File(path));
			Template t=freeMaker.getTemplate(templateFileName);
			t.process(map, writer);
			return writer.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void sendMail(String to,String cc,String subject, String htmlText, File file){
		try {
			mail.addTo(to);
			if(DataUtil.notEmptyString(cc)){
				mail.addCc(cc);
			}
			mail.setSubject(subject);
			mail.setMsg(htmlText);
			if(file!=null){
				attachMail.setPath(file.getPath());
				attachMail.setDisposition(EmailAttachment.ATTACHMENT);
				attachMail.setName(file.getName());
				mail.attach(attachMail);
			}
			mail.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
	
	public void sendMail(String to,String cc,String subject,String htmlText){
		this.sendMail(to, cc, subject, htmlText, null);
	}
	
	public void sendMail(String to, String subject, String htmlText){
		this.sendMail(to, null, subject, htmlText);
	}
}