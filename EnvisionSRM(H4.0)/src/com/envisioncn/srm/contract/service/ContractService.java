/**
 * 
 */
package com.envisioncn.srm.contract.service;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.model.json.JsonItem;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.basic.util.FileUtil;
import com.envisioncn.srm.contract.bean.AttachmentBean;
import com.envisioncn.srm.contract.bean.ContractBean;
import com.envisioncn.srm.contract.bean.DiviationHeadBean;
import com.envisioncn.srm.contract.bean.EhsBean;
import com.envisioncn.srm.contract.bean.LogisticBean;
import com.envisioncn.srm.contract.bean.PriceBean;
import com.envisioncn.srm.contract.bean.PurchaseInstructionBean;
import com.envisioncn.srm.contract.bean.QuanlityBean;
import com.envisioncn.srm.contract.bean.SecrecyBean;
import com.envisioncn.srm.contract.bean.SupervisionBean;
import com.envisioncn.srm.contract.bean.TechnologyBean;
import com.envisioncn.srm.contract.common.ContractExcutionStatus;
import com.envisioncn.srm.contract.dao.IAttachmentDao;
import com.envisioncn.srm.contract.dao.IContractDao;
import com.envisioncn.srm.contract.dao.IDiviationHeadDao;
import com.envisioncn.srm.contract.dao.IEhsDao;
import com.envisioncn.srm.contract.dao.ILogisticDao;
import com.envisioncn.srm.contract.dao.IPriceDao;
import com.envisioncn.srm.contract.dao.IPurchaseInstructionDao;
import com.envisioncn.srm.contract.dao.IQuanlityDao;
import com.envisioncn.srm.contract.dao.ISecrecyDao;
import com.envisioncn.srm.contract.dao.ISupervisionDao;
import com.envisioncn.srm.contract.dao.ITechnologyDao;
import com.google.gson.JsonObject;

/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-15
 */
@Service("ContractService")
public class ContractService extends BasicService<ContractBean> implements
		IContractService {
	private IContractDao contractDao;
	private ISecrecyDao secrecyDao;
	private IDiviationHeadDao diviationHeadDao;
	private IAttachmentDao attachmentDao;
	private IPriceDao priceDao;
	private IQuanlityDao quanlityDao;
	private IPurchaseInstructionDao purchaseInstructionDao;
	private ITechnologyDao technologyDao;
	private ILogisticDao logisticDao;
	private IEhsDao ehsDao;
	private ISupervisionDao supervisionDao;

	public void addContract(File[] ehs,String[] ehsFileName,File[] logistic,String[] logisticFileName,
			File[] supervision,String[] supervisionFileName,File[] technology,String[] technologyFileName,
			File[] purchaseInstruction,String[] purchaseInstructionFileName,File[] quanlity,String[] quanlityFileName,
			File price,String priceFileName,File secrecy,String secrecyFileName,ContractBean contractBean,
			long diviationHead,DiviationHeadBean dhb,SecrecyBean sb,PriceBean pb,QuanlityBean qb,
			PurchaseInstructionBean pib,TechnologyBean tb,SupervisionBean svb,LogisticBean lb,EhsBean eb,AttachmentBean ab,String path) throws Exception{
		
		contractDao.add(contractBean);
		diviationHeadDao.add(dhb);
		secrecyDao.add(sb);
		if (null != secrecy) {
			ab.setPactId(sb.getId());
			ab.setAttachmentName(FileUtil.saveCodingFileNew(secrecy,path,secrecyFileName));
			ab.setType("2");
			attachmentDao.add(ab);
		}
		priceDao.add(pb);
		if (null != price) {
			ab.setPactId(pb.getId());
			ab.setAttachmentName(FileUtil.saveCodingFileNew(price,path,priceFileName));
			ab.setType("3");
			attachmentDao.add(ab);
		}
		quanlityDao.add(qb);
		if (null != quanlity) {
		for(int i=0;i<quanlity.length;i++){
			if(quanlity[i]==null){
				continue;
			}
			AttachmentBean ab1=new AttachmentBean();
			ab1.setPactId(qb.getId());
			ab1.setType("4");
			ab1.setAttachmentName(FileUtil.saveCodingFileNew(quanlity[i],path,quanlityFileName[i]));
			attachmentDao.add(ab1);
		}}
		purchaseInstructionDao.add(pib);
		if (null != purchaseInstruction) {
		for(int i=0;i<purchaseInstruction.length;i++){
			if(purchaseInstruction[i]==null){
				continue;
			}
			AttachmentBean ab1=new AttachmentBean();
			ab1.setPactId(pib.getId());
			ab1.setType("5");
			ab1.setAttachmentName(FileUtil.saveCodingFileNew(purchaseInstruction[i],path,purchaseInstructionFileName[i]));
			attachmentDao.add(ab1);
		}}
		technologyDao.add(tb);
		if (null != technology) {
		for(int i=0;i<technology.length;i++){
			if(technology[i]==null){
				continue;
			}
			AttachmentBean ab1=new AttachmentBean();
			ab1.setPactId(tb.getId());
			ab1.setType("6");
			ab1.setAttachmentName(FileUtil.saveCodingFileNew(technology[i],path,technologyFileName[i]));
			attachmentDao.add(ab1);
		}}
		supervisionDao.add(svb);
		if (null != supervision) {
		for(int i=0;i<supervision.length;i++){
			if(supervision[i]==null){
				continue;
			}
			AttachmentBean ab1=new AttachmentBean();
			ab1.setPactId(svb.getId());
			ab1.setType("7");
			ab1.setAttachmentName(FileUtil.saveCodingFileNew(supervision[i],path,supervisionFileName[i]));
			attachmentDao.add(ab1);
		}}
		logisticDao.add(lb);
		if (null != logistic) {
		for(int i=0;i<logistic.length;i++){
			if(logistic[i]==null){
				continue;
			}
			AttachmentBean ab1=new AttachmentBean();
			ab1.setPactId(lb.getId());
			ab1.setType("8");
			ab1.setAttachmentName(FileUtil.saveCodingFileNew(logistic[i],path,logisticFileName[i]));
			attachmentDao.add(ab1);
		}}
		ehsDao.add(eb);
		if (null != ehs) {
		for(int i=0;i<ehs.length;i++){
			if(ehs[i]==null){
				continue;
			}
			AttachmentBean ab1=new AttachmentBean();
			ab1.setPactId(eb.getId());
			ab1.setType("9");
			ab1.setAttachmentName(FileUtil.saveCodingFileNew(ehs[i],path,ehsFileName[i]));
			attachmentDao.add(ab1);
		}}
	}
	
	public JsonItem getStatusItem(ContractBean contract, JsonItem item) {
		switch(ContractExcutionStatus.fromValue(contract.getStatus())){
		case ContractCreated:
			item.add("status", ContractExcutionStatus.ContractCreated.toText());
			break;
		case ContractPendingApproval:
			item.add("status", ContractExcutionStatus.ContractPendingApproval.toText());
			break;
		case ContractBeenApproval:
			item.add("status", ContractExcutionStatus.ContractBeenApproval.toText());
			break;
		case ContractUnBeenApproval:
			item.add("status", ContractExcutionStatus.ContractUnBeenApproval.toText());
			break;
		case ContractCancel:
			item.add("status", ContractExcutionStatus.ContractCancel.toText());
			break;
		case ContractModify:
			item.add("status", ContractExcutionStatus.ContractModify.toText());
			break;
		case ContractOver:
			item.add("status", ContractExcutionStatus.ContractOver.toText());
			break;
		case ContractModify1:
			item.add("status", ContractExcutionStatus.ContractModify1.toText());
			break;
		}
		return item;
	}
	
	public JsonObject getStatusItem1(ContractBean contract, JsonObject item) {
		switch(ContractExcutionStatus.fromValue(contract.getStatus())){
		case ContractCreated:
			item.addProperty("status", ContractExcutionStatus.ContractCreated.toText());
			break;
		case ContractPendingApproval:
			item.addProperty("status", ContractExcutionStatus.ContractPendingApproval.toText());
			break;
		case ContractBeenApproval:
			item.addProperty("status", ContractExcutionStatus.ContractBeenApproval.toText());
			break;
		case ContractUnBeenApproval:
			item.addProperty("status", ContractExcutionStatus.ContractUnBeenApproval.toText());
			break;
		case ContractCancel:
			item.addProperty("status", ContractExcutionStatus.ContractCancel.toText());
			break;
		case ContractModify:
			item.addProperty("status", ContractExcutionStatus.ContractModify.toText());
			break;
		case ContractOver:
			item.addProperty("status", ContractExcutionStatus.ContractOver.toText());
			break;
		case ContractModify1:
			item.addProperty("status", ContractExcutionStatus.ContractModify1.toText());
			break;
		}
		return item;
	}
	
	@Resource(name="SupervisionDao")
	public void setSupervisionDao(ISupervisionDao supervisionDao)
	{
		this.supervisionDao = supervisionDao;
	}
	@Resource(name="TechnologyDao")
	public void setTechnologyDao(ITechnologyDao technologyDao)
	{
		this.technologyDao = technologyDao;
	}
	@Resource(name="SecrecyDao")
	public void setSecrecyDao(ISecrecyDao secrecyDao)
	{
		this.secrecyDao = secrecyDao;
	}
	@Resource(name="EhsDao")
	public void setEhsDao(IEhsDao ehsDao)
	{
		this.ehsDao = ehsDao;
	}
	@Resource(name="LogisticDao")
	public void setLogisticDao(ILogisticDao logisticDao)
	{
		this.logisticDao = logisticDao;
	}
	@Resource(name="PurchaseInstructionDao")
	public void setPurchaseInstructionDao(IPurchaseInstructionDao purchaseInstructionDao)
	{
		this.purchaseInstructionDao = purchaseInstructionDao;
	}
	@Resource(name="QuanlityDao")
	public void setQuanlityDao(IQuanlityDao quanlityDao)
	{
		this.quanlityDao = quanlityDao;
	}
	@Resource(name="PriceDao")
	public void setPriceDao(IPriceDao priceDao)
	{
		this.priceDao = priceDao;
	}
	@Resource(name="AttachmentDao")
	public void setAttachmentDao(IAttachmentDao attachmentDao)
	{
		this.attachmentDao = attachmentDao;
	}
	@Resource(name="DiviationHeadDao")
	public void setDiviationHeadDao(IDiviationHeadDao diviationHeadDao)
	{
		this.diviationHeadDao = diviationHeadDao;
	}
	@Resource(name="ContractDao")
	public void setContractDao(IContractDao contractDao)
	{
		this.contractDao = contractDao;
	}
	@Resource(name="ContractDao")
	public void setBasicDao(IBasicDao<ContractBean> basicDao){
		this.basicDao=basicDao;
	}
	

	
}
