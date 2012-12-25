/**
 * 
 */
package com.envisioncn.srm.contract.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Bookmarks;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.model.SRMException;
import com.envisioncn.srm.basic.model.constants.AppConstants;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.basic.util.DateUtil;
import com.envisioncn.srm.basic.util.FileUtil;
import com.envisioncn.srm.contract.bean.YearcontractBean;
import com.envisioncn.srm.contract.bean.YearcontractContentBean;
import com.envisioncn.srm.contract.dao.IYearcontractContentDao;
import com.envisioncn.srm.contract.dao.YearcontractDao;
import com.envisioncn.srm.system.bean.UserBean;

/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-15
 */
@Service("YearcontractService")
public class YearContractService extends BasicService<YearcontractBean> implements
		IYearContractService {
	private YearcontractDao yearContractDao;
	private IYearcontractContentDao yearContractContentDao;
	
	@Resource(name="YearcontractContentDao")
	public void setYearContractContentDao(IYearcontractContentDao yearContractContentDao)
	{
		this.yearContractContentDao = yearContractContentDao;
	}
	
	@Resource(name="YearcontractDao")
	public void setYearContractDao(YearcontractDao yearContractDao) {
		this.yearContractDao = yearContractDao;
	}
	
	@Resource(name="YearcontractDao")
	public void setBasicDao(IBasicDao<YearcontractBean> basicDao){
		this.basicDao=basicDao;
	}

	public YearcontractBean getObject(int id){
		return yearContractDao.getObject(id);
	}
	
	public List<YearcontractBean> getListObjectsBytype(String type){
		return yearContractDao.getListObjects(type);
	}
	
	public boolean checkIsRepeat(String name){
		return yearContractDao.checkIsRepeat(name);
	}
	
	public boolean checkUnValidate(Date beginDate,Date endDate,String type){
		return yearContractDao.checkValidate(beginDate, endDate, type);
	}
	
	public List<YearcontractBean> getUnConformedList(int start,int limit){
		YearcontractDao yearContractDao = (YearcontractDao)(this.yearContractDao);
		return yearContractDao.getUnConformedList(start, limit);
	}

	public void addYearContract(YearcontractBean yearcontractBean,File word_path,String path) throws IOException, SRMException{
		java.util.Date date = new java.util.Date();
		// contractID为年度合同的主键ID，唯一
		@SuppressWarnings("deprecation")
		long contractID = date.getHours() * 60 * 60 + date.getMinutes() * 60
				+ date.getSeconds();
		
		String temp = DateUtil.formatDate(new Date(),DateUtil.DATEUPLOADFORMAT);
		// 上传之后的文件名称
		String fileName = yearcontractBean.getName() + "-" + temp + AppConstants.FileCategory.DOC;
		String uploadName=temp + AppConstants.FileCategory.DOC;
		yearcontractBean.setYearcontractid(contractID);
		yearcontractBean.setPath(fileName);
		UserBean user=(UserBean)ServletActionContext.getRequest().getSession().getAttribute("user");
		yearcontractBean.setPerson(user.getId());
		yearcontractBean.setFilenumber(uploadName);
		yearContractDao.add(yearcontractBean);
		
		FileUtil.saveFile(word_path,path,uploadName);
		/* 解析年度合同模板的内容储存至数据库 */
		FileInputStream in = new FileInputStream(new File(word_path.toString()));
		HWPFDocument hdt = new HWPFDocument(in);
		Range range = hdt.getRange();
		Bookmarks bookmarks = hdt.getBookmarks();
		for (int i = 0; i < bookmarks.getBookmarksCount(); i = i + 2) {
			YearcontractContentBean ycb = new YearcontractContentBean();
			int id_start = bookmarks.getBookmark(i).getStart();
			int id_end = bookmarks.getBookmark(i).getEnd();
			int content_start = bookmarks.getBookmark(i + 1).getStart();
			int content_end = bookmarks.getBookmark(i + 1).getEnd();
			ycb.setYearcontractid(contractID);
			ycb.setProjectnumber(range.text().substring(id_start, id_end)
					.trim());
			ycb.setWordcontent(range.text()
					.substring(content_start, content_end).trim());
			yearContractContentDao.add(ycb);
		}
	}

	
	
}
