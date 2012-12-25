/**
 * 
 */
package com.envisioncn.srm.contract.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.List;
import javax.annotation.Resource;
import org.apache.struts2.ServletActionContext;
import com.envisioncn.srm.basic.action.ABasicAction;
import com.envisioncn.srm.basic.model.Condition;
import com.envisioncn.srm.basic.model.ConditionSet;
import com.envisioncn.srm.basic.model.constants.AppConstants;
import com.envisioncn.srm.basic.model.json.JsonItem;
import com.envisioncn.srm.basic.model.json.JsonList;
import com.envisioncn.srm.basic.model.type.ConditionType;
import com.envisioncn.srm.basic.model.type.ResponseType;
import com.envisioncn.srm.basic.util.DateUtil;
import com.envisioncn.srm.basic.util.ParamAssert;
import com.envisioncn.srm.contract.bean.AttachmentBean;
import com.envisioncn.srm.contract.bean.ContractBean;
import com.envisioncn.srm.contract.bean.ContractCancelBean;
import com.envisioncn.srm.contract.bean.ContractExcutionBean;
import com.envisioncn.srm.contract.bean.ContractScanCopyBean;
import com.envisioncn.srm.contract.bean.DiviationHeadBean;
import com.envisioncn.srm.contract.bean.EhsBean;
import com.envisioncn.srm.contract.bean.LogisticBean;
import com.envisioncn.srm.contract.bean.PriceBean;
import com.envisioncn.srm.contract.bean.PurchaseInstructionBean;
import com.envisioncn.srm.contract.bean.QuanlityBean;
import com.envisioncn.srm.contract.bean.SecrecyBean;
import com.envisioncn.srm.contract.bean.SupervisionBean;
import com.envisioncn.srm.contract.bean.TechnologyBean;
import com.envisioncn.srm.contract.bean.YearcontractBean;
import com.envisioncn.srm.contract.service.AttachmentService;
import com.envisioncn.srm.contract.service.ContractCancelService;
import com.envisioncn.srm.contract.service.ContractExcutionService;
import com.envisioncn.srm.contract.service.ContractScanCopyService;
import com.envisioncn.srm.contract.service.ContractService;
import com.envisioncn.srm.contract.service.DiviationHeadService;
import com.envisioncn.srm.contract.service.EhsService;
import com.envisioncn.srm.contract.service.LogisticService;
import com.envisioncn.srm.contract.service.PriceService;
import com.envisioncn.srm.contract.service.PurchaseInstructionService;
import com.envisioncn.srm.contract.service.QuanlityService;
import com.envisioncn.srm.contract.service.SecrecyService;
import com.envisioncn.srm.contract.service.SupervisionService;
import com.envisioncn.srm.contract.service.TechnologyService;
import com.envisioncn.srm.contract.service.YearContractService;
import com.envisioncn.srm.supplier_basic.service.SupplierBasicService;
import com.envisioncn.srm.system.bean.UserBean;
import com.envisioncn.srm.system.service.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-23
 */
@SuppressWarnings("serial")
public class ContractAction extends ABasicAction<ContractBean> {
	private static final int BUFFER_SIZE = 16 * 1024;
	private ContractBean contractBean;
	private YearContractService yearcontractService;
	private ContractService contractService;
	private ContractExcutionService contractExcutionService;
	private DiviationHeadService diviationHeadService;
	private SecrecyService secrecyService;
	private PriceService priceService;
	private PurchaseInstructionService purchaseInstructionService;
	private TechnologyService technologyService;
	private SupervisionService supervisionService;
	private LogisticService logisticService;
	private EhsService ehsService;
	private QuanlityService quanlityService;
	private AttachmentService attachmentService;
	private ContractScanCopyService contractScanCopyService;
	private ContractCancelService contractCancelService;
	private UserService userService;
	private SupplierBasicService supplierBasicService;
	
	public String list() throws Exception {
		JsonList jsonList=new JsonList();
		ConditionSet conditions = new ConditionSet();
		conditions.put(new Condition("status",ConditionType.LIEK,"%"+status+"%"));
		for(ContractBean contract:contractService.getList(conditions,start,limit)){
			JsonItem item=jsonList.createItem()
			.add("id", contract.getId())
			.add("contractId", contract.getContractId())
			.add("suppierId", supplierBasicService.getObject(contract.getSupplierId()).getName())
			.add("userId", userService.getObjectById(UserBean.class, contract.getUserid()).getName())
			.add("createTime", DateUtil.formatDate(contract.getCreateTime()));
			item=this.contractService.getStatusItem(contract, item);
			
		}
		return response(jsonList.toPageString(contractService.getCount()));
	}
	
	public String listCancelReason() throws Exception {
		JsonList jsonList=new JsonList();
		for(ContractCancelBean cancel:contractCancelService.getList(start,limit)){
			jsonList.createItem()
			.add("id", cancel.getId())
			.add("reason", cancel.getReason())
			.add("createTime", DateUtil.formatDate(cancel.getCreateTime()));
		}
		return response(jsonList.toPageString(contractCancelService.getCount()));
	}
	
	public String listReason() throws Exception {
		JsonList jsonList=new JsonList();
		for(ContractCancelBean cancel:contractCancelService.getList(start,limit)){
			jsonList.createItem()
			.add("id", cancel.getId())
			.add("name", cancel.getReason());
		}
		return response(jsonList);
	}
	
	public String cancel() throws Exception{
		try
		{
			ContractBean cb=contractService.getObject(id);
			cb.setStatus("50");
			String contractid1=cb.getContractId();
			ConditionSet conditions = new ConditionSet();
			conditions.put(new Condition("contractid",contractid1));
			ContractExcutionBean ceb=new ContractExcutionBean();
			System.out.println("***********ceb="+ceb);
			if(contractExcutionService.getList(conditions).size()<=0){
				ceb.setContractid(contractid1);
				ceb.setCancelReason(reasonId);
				ceb.setCancelTime(new Date(System.currentTimeMillis()));
				contractExcutionService.add(ceb);
			}else{
				ceb=contractExcutionService.getList(conditions).get(0);
				ceb.setCancelReason(reasonId);
				ceb.setCancelTime(new Date(System.currentTimeMillis()));
				contractExcutionService.modify(ceb);
			}
			contractService.modify(cb);
			return response(true,"操作成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return response(false, "操作失败！");
		}
		
	}
	public String listScanCopy() throws Exception {
		JsonList jsonList=new JsonList();
		ConditionSet conditions = new ConditionSet();
		conditions.put(new Condition("status",ConditionType.LIEK,"%"+status+"%"));
		for(ContractBean contract:contractService.getList(conditions,start,limit)){
			ConditionSet conditions1 = new ConditionSet();
			conditions1.put(new Condition("contractid",ConditionType.LIEK,contract.getContractId()+"%"));
			ContractScanCopyBean cscb = new ContractScanCopyBean();
			JsonItem item=jsonList.createItem()
			.add("id", contract.getId())
			.add("contractId", contract.getContractId())
			.add("suppierId", contract.getSupplierId())
			.add("userId", contract.getUserid())
			.add("createTime", DateUtil.formatDate(contract.getCreateTime()));
			item=this.contractService.getStatusItem(contract, item);
			if(contractScanCopyService.getList(conditions1).size()<=0){
				item.add("yearContract", "");
				item.add("diviation", "");
				item.add("price", "");
			}else{
				cscb=contractScanCopyService.getList(conditions1).get(0);
				item.add("yearContract", cscb.getYearContract()==null?"":cscb.getYearContract());
				item.add("diviation", cscb.getDiviation()==null?"":cscb.getDiviation());
				item.add("price", cscb.getPrice()==null?"":cscb.getPrice());
			}
			conditions1.clear();
		}
		return response(jsonList.toPageString(contractService.getCount()));
	}
	
	public String delete() throws Exception
	{
		try
		{
			ParamAssert.isTrue(id != 0, "对象不存在");
			ContractCancelBean bean = contractCancelService.getObjectById(ContractCancelBean.class, id);
			contractCancelService.removeObject(bean);
			return response(true, "删除成功！");
		}
		catch (Exception e)
		{
			return response(false, "删除失败！");
		}
	}
	
	public String confirm() throws Exception {
		try {
			contractBean=contractService.getObject(id);
			contractBean.setStatus(status);
			contractService.modify(contractBean);
			return response(true, "提交成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return response(false, "操作失败！");
		}
	}
	
	public String addCancelReason() throws Exception {
		try {
			ContractCancelBean ccb = new ContractCancelBean();
			ccb.setReason(reason);
			ccb.setCreateTime(new Date(System.currentTimeMillis()));
			contractCancelService.add(ccb);
			return response(true, "新增成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return response(false, "新增失败！");
		}
	}
	
	public String addScan() throws Exception {
		try {
			ContractScanCopyBean cscb = new ContractScanCopyBean();
			cscb.setContractid(contractid);
			if (null != yearContract) {
				cscb.setYearContract(yearContractFileName);
				File wordFile = new File(ServletActionContext.getServletContext()
						.getRealPath("/upload/contract") + "/" + yearContractFileName);
				copy(yearContract, wordFile);
			}
			if (null != diviation) {
				cscb.setDiviation(diviationFileName);
				File wordFile = new File(ServletActionContext.getServletContext()
						.getRealPath("/upload/contract") + "/" + diviationFileName);
				copy(diviation, wordFile);
			}
			if (null != price) {
				cscb.setPrice(priceFileName);
				File wordFile = new File(ServletActionContext.getServletContext()
						.getRealPath("/upload/contract") + "/" + priceFileName);
				copy(price, wordFile);
			}
			contractScanCopyService.add(cscb);
			return response(true, "上传成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return response(false, "上传失败！");
		}
	}
	
	public String getContract() throws Exception {
		try {
			contractBean=contractService.getObject(id);
			String contractid=contractBean.getContractId();
			JsonObject item = new JsonObject();
			item.addProperty("contractId",contractid);
			item.addProperty("supplierName", contractBean.getSupplierId());
			item.addProperty("purchaseName", contractBean.getUserid());
			item=this.contractService.getStatusItem1(contractBean, item);
			
			Gson gson = new Gson();
			return response(gson.toJson(item));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public String get() throws Exception {
		try {
			contractBean=contractService.getObject(id);
			String contractid=contractBean.getContractId();
			ConditionSet conditions0=new ConditionSet();
			ConditionSet conditions=new ConditionSet();
			conditions.put(new Condition("contractid",contractid));
			YearcontractBean yb=yearcontractService.getList(conditions0.put(new Condition("yearcontractid",contractBean.getYearcontractId()))).get(0);
			JsonObject item = new JsonObject();
			//JsonItem item = new JsonItem()
			item.addProperty("contractId",contractid);
			item.addProperty("supplierName", contractBean.getSupplierId());
			item.addProperty("purchaseName", contractBean.getUserid());
			item=this.contractService.getStatusItem1(contractBean, item);
			item.addProperty("yearContractType", yb.getType());
			item.addProperty("yearContractName", yb.getName());
			
			ConditionSet conditions2=new ConditionSet();
			conditions2.put(new Condition("pactId",priceService.getList(conditions).get(0).getId()))
			.put(new Condition("type","3"));
			item.addProperty("price", attachmentService.getList(conditions2).get(0).getAttachmentName());
			item.addProperty("priceRemark", priceService.getList(conditions).get(0).getRemark());
			
			item.addProperty("diviationRemark", diviationHeadService.getList(conditions).get(0).getRemark());
			item.addProperty("quanlityRemark", quanlityService.getList(conditions).get(0).getRemark());
			item.addProperty("purchaseInstructionRemark", purchaseInstructionService.getList(conditions).get(0).getRemark());
			item.addProperty("technologyRemark", technologyService.getList(conditions).get(0).getRemark());
			item.addProperty("supervisionRemark", supervisionService.getList(conditions).get(0).getRemark());
			item.addProperty("logisticRemark", logisticService.getList(conditions).get(0).getRemark());
			item.addProperty("ehsRemark", ehsService.getList(conditions).get(0).getRemark());
			
			ConditionSet conditions4=new ConditionSet();
			conditions4.put(new Condition("pactId",quanlityService.getList(conditions).get(0).getId()))
			.put(new Condition("type","4"));
			List<AttachmentBean> list4 = attachmentService.getList(conditions4);
			
			ConditionSet conditions5=new ConditionSet();
			conditions5.put(new Condition("pactId",purchaseInstructionService.getList(conditions).get(0).getId()))
			.put(new Condition("type","5"));
			List<AttachmentBean> list5 = attachmentService.getList(conditions5);
			
			ConditionSet conditions6=new ConditionSet();
			conditions6.put(new Condition("pactId",technologyService.getList(conditions).get(0).getId()))
			.put(new Condition("type","6"));
			List<AttachmentBean> list6 = attachmentService.getList(conditions6);
			
			ConditionSet conditions7=new ConditionSet();
			conditions7.put(new Condition("pactId",supervisionService.getList(conditions).get(0).getId()))
			.put(new Condition("type","7"));
			List<AttachmentBean> list7 = attachmentService.getList(conditions7);
			
			ConditionSet conditions8=new ConditionSet();
			conditions8.put(new Condition("pactId",logisticService.getList(conditions).get(0).getId()))
			.put(new Condition("type","8"));
			List<AttachmentBean> list8 = attachmentService.getList(conditions8);
			
			ConditionSet conditions9=new ConditionSet();
			conditions9.put(new Condition("pactId",ehsService.getList(conditions).get(0).getId()))
			.put(new Condition("type","9"));
			List<AttachmentBean> list9 = attachmentService.getList(conditions9);
			
			JsonArray ja = new JsonArray();
			JsonArray ja4 = new JsonArray();
			JsonArray ja5 = new JsonArray();
			JsonArray ja6 = new JsonArray();
			JsonArray ja7 = new JsonArray();
			JsonArray ja8 = new JsonArray();
			JsonArray ja9 = new JsonArray();
			for(int i =0; i< list4.size();i++)
			{
				JsonObject jo = new JsonObject();
				jo.addProperty("quanlity", list4.get(i).getAttachmentName());
				ja4.add(jo);
			}
			for(int i = 0; i<list5.size();i++)
			{
				JsonObject jo = new JsonObject();
				jo.addProperty("purchaseInstruction", list5.get(i).getAttachmentName());
				ja5.add(jo);
			}
			for(int i = 0; i<list6.size();i++)
			{
				JsonObject jo = new JsonObject();
				jo.addProperty("technology", list6.get(i).getAttachmentName());
				ja6.add(jo);
			}
			for(int i = 0; i<list7.size();i++)
			{
				JsonObject jo = new JsonObject();
				jo.addProperty("supervision", list7.get(i).getAttachmentName());
				ja7.add(jo);
			}
			for(int i = 0; i<list8.size();i++)
			{
				JsonObject jo = new JsonObject();
				jo.addProperty("logistic", list8.get(i).getAttachmentName());
				ja8.add(jo);
			}
			for(int i = 0; i<list9.size();i++)
			{
				JsonObject jo = new JsonObject();
				jo.addProperty("ehs", list9.get(i).getAttachmentName());
				ja9.add(jo);
			}
			ja.add(ja4);
			ja.add(ja5);
			ja.add(ja6);
			ja.add(ja7);
			ja.add(ja8);
			ja.add(ja9);
			
			
			item.add("gson", ja);
			Gson gson = new Gson();
			return response(gson.toJson(item));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public String confirmFailed() throws Exception {
		try {
			contractBean=contractService.getObject(id);
			String contractid=contractBean.getContractId();
			contractBean.setStatus("30");
			contractService.modify(contractBean);
			
			ConditionSet conditions=new ConditionSet();
			conditions.put(new Condition("contractid",contractid));
			ContractExcutionBean ceb=new ContractExcutionBean();
			
			if(contractExcutionService.getList(conditions)==null||contractExcutionService.getList(conditions).size()<=0){
				ceb.setContractid(contractid);
				ceb.setConfirmOption(confirmOption);
				ceb.setConfirmTime(new Date(System.currentTimeMillis()));
				contractExcutionService.add(ceb);
			}else{
				ceb=contractExcutionService.getList(conditions).get(0);
				ceb.setConfirmOption(confirmOption);
				ceb.setConfirmTime(new Date(System.currentTimeMillis()));
				contractExcutionService.modify(ceb);
			}
			
			return response(true, "保存成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return response(false, "保存失败！");
		}
	}
	
	public String confirmPass() throws Exception {
		try {
			contractBean=contractService.getObject(id);
			contractBean.setStatus(status);
			contractService.modify(contractBean);
			return response(true, "审批成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return response(false, "审批失败！");
		}
	}
	
	public String add() throws Exception {
		try {
			DiviationHeadBean dhb=new DiviationHeadBean();
			SecrecyBean sb=new SecrecyBean();
			PriceBean pb=new PriceBean();
			QuanlityBean qb=new QuanlityBean();
			PurchaseInstructionBean pib=new PurchaseInstructionBean();
			TechnologyBean tb=new TechnologyBean();
			SupervisionBean svb=new SupervisionBean();
			LogisticBean lb=new LogisticBean();
			EhsBean eb=new EhsBean();
			AttachmentBean ab=new AttachmentBean();
	
			String contractid=contractBean.getYearcontractId()+contractBean.getSupplierId()+"V01";
			UserBean user=(UserBean)ServletActionContext.getRequest().getSession().getAttribute("user");
			contractBean.setContractId(contractid);
			contractBean.setCreateTime(new Date(System.currentTimeMillis()));
			contractBean.setDiviationId(diviationHead);
			contractBean.setStatus("00");
			contractBean.setUserid(user.getId());
			
			dhb=diviationHeadService.getObject(diviationHead);
			dhb.setContractid(contractid);
			dhb.setRemark(diviationRemark);
			sb.setContractid(contractid);
			sb.setRemark(secrecyRemark);
			sb.setType(secrecyType);
			pb.setContractid(contractid);
			pb.setRemark(priceRemark);
			pb.setVersion(1);
			qb.setContractid(contractid);
			qb.setRemark(quanlityRemark);
			pib.setContractid(contractid);
			pib.setRemark(purchaseInstructionRemark);
			tb.setContractid(contractid);
			tb.setRemark(technologyRemark);
			svb.setContractid(contractid);
			svb.setRemark(supervisionRemark);
			lb.setContractid(contractid);
			lb.setRemark(logisticRemark);
			eb.setContractid(contractid);
			eb.setRemark(ehsRemark);
			
			String path=getRealPath(AppConstants.Contract.CONTRACT_DOWNLOAD_PATH);
			
			contractService.addContract(ehs,ehsFileName,logistic,logisticFileName,supervision,supervisionFileName,technology,
					technologyFileName,purchaseInstruction,purchaseInstructionFileName,quanlity,quanlityFileName,
					price,priceFileName,secrecy,secrecyFileName,contractBean,diviationHead,
					dhb,sb,pb,qb,pib,tb,svb,lb,eb,ab,path);
			
			return response(ResponseType.HTML, true, "新建框架合同成功,转到列表页面!");
		} catch (Exception e) {
			e.printStackTrace();
			return response(ResponseType.HTML, false, "新建框架合同失败！");
		}
	}
	
	public String contractModify() throws Exception {
		try {
			DiviationHeadBean dhb=new DiviationHeadBean();
			//SecrecyBean sb=new SecrecyBean();
			PriceBean pb=new PriceBean();
			QuanlityBean qb=new QuanlityBean();
			PurchaseInstructionBean pib=new PurchaseInstructionBean();
			TechnologyBean tb=new TechnologyBean();
			SupervisionBean svb=new SupervisionBean();
			LogisticBean lb=new LogisticBean();
			EhsBean eb=new EhsBean();
			AttachmentBean ab=new AttachmentBean();
			
			ContractBean contractBean=contractService.getObject(id);
			String contractid=contractBean.getContractId();
			String contractid_fore=contractid.substring(contractid.length()-1,contractid.length());
			int version1=Integer.parseInt(contractid_fore)+1;
			String contractNewid=contractBean.getContractId().substring(0,contractid.length()-1)+String.valueOf(version1);
			contractBean.setIsModify("1");
			contractBean.setParentContractId(contractid);
			contractService.modify(contractBean);
			
			ContractBean contractBeanNew=new ContractBean();
			contractBeanNew.setContractId(contractNewid);
			contractBeanNew.setCreateTime(new Date(System.currentTimeMillis()));
			contractBeanNew.setDiviationId(diviationHead);
			contractBeanNew.setStatus("40");
			contractBeanNew.setParentContractId(contractid);
			contractBeanNew.setSupplierId(contractBean.getSupplierId());
			contractBeanNew.setUserid(contractBean.getUserid());
			contractBeanNew.setYearcontractId(contractBean.getYearcontractId());
			contractService.add(contractBeanNew);
			
			dhb=diviationHeadService.getObject(diviationHead);
			dhb.setContractid(contractNewid);
			dhb.setRemark(diviationRemark);
			diviationHeadService.add(dhb);
			
			pb.setContractid(contractNewid);
			pb.setRemark(priceRemark);
			pb.setVersion(2);
			priceService.add(pb);
			
			if (null != price) {
				ab.setPactId(pb.getId());
				ab.setAttachmentName(priceFileName);
				ab.setType("3");
				File wordFile = new File(ServletActionContext.getServletContext()
						.getRealPath("/upload/contract") + "/" + priceFileName);
				copy(price, wordFile);
				attachmentService.add(ab);
			}
			
			ConditionSet conditions=new ConditionSet();
			conditions.put(new Condition("contractid",contractid));
			QuanlityBean qb1=new QuanlityBean();
			qb1=quanlityService.getList(conditions).get(0);
			ConditionSet conditions4=new ConditionSet();
			conditions4.put(new Condition("pactId",qb1.getId()))
			.put(new Condition("type","4"));
			List<AttachmentBean> list4 = attachmentService.getList(conditions4);
			qb.setRemark(qb1.getRemark());
			qb.setContractid(contractNewid);
			quanlityService.add(qb);
			for(AttachmentBean ab1:list4){
				AttachmentBean ab2=new AttachmentBean();
				ab2.setPactId(qb.getId());
				ab2.setAttachmentName(ab1.getAttachmentName());
				ab2.setType(ab1.getType());
				attachmentService.add(ab2);
			}
			
			PurchaseInstructionBean pib1=purchaseInstructionService.getList(conditions).get(0);
			ConditionSet conditions5=new ConditionSet();
			conditions5.put(new Condition("pactId",pib1.getId()))
			.put(new Condition("type","5"));
			List<AttachmentBean> list5 = attachmentService.getList(conditions5);
			pib.setRemark(pib1.getRemark());
			pib.setContractid(contractNewid);
			purchaseInstructionService.add(pib);
			for(AttachmentBean ab1:list5){
				AttachmentBean ab2=new AttachmentBean();
				ab2.setPactId(pib.getId());
				ab2.setAttachmentName(ab1.getAttachmentName());
				ab2.setType(ab1.getType());
				attachmentService.add(ab2);
			}
			
			TechnologyBean tb1=technologyService.getList(conditions).get(0);
			ConditionSet conditions6=new ConditionSet();
			conditions6.put(new Condition("pactId",tb1.getId()))
			.put(new Condition("type","6"));
			List<AttachmentBean> list6 = attachmentService.getList(conditions6);
			tb.setRemark(tb1.getRemark());
			tb.setContractid(contractNewid);
			technologyService.add(tb);
			for(AttachmentBean ab1:list6){
				AttachmentBean ab2=new AttachmentBean();
				ab2.setPactId(tb.getId());
				ab2.setAttachmentName(ab1.getAttachmentName());
				ab2.setType(ab1.getType());
				attachmentService.add(ab2);
			}
			
			SupervisionBean svb1=supervisionService.getList(conditions).get(0);
			ConditionSet conditions7=new ConditionSet();
			conditions7.put(new Condition("pactId",svb1.getId()))
			.put(new Condition("type","7"));
			List<AttachmentBean> list7 = attachmentService.getList(conditions7);
			svb.setRemark(svb1.getRemark());
			svb.setContractid(contractNewid);
			supervisionService.add(svb);
			for(AttachmentBean ab1:list7){
				AttachmentBean ab2=new AttachmentBean();
				ab2.setPactId(svb.getId());
				ab2.setAttachmentName(ab1.getAttachmentName());
				ab2.setType(ab1.getType());
				attachmentService.add(ab2);
			}
			
			LogisticBean lb1=logisticService.getList(conditions).get(0);
			ConditionSet conditions8=new ConditionSet();
			conditions8.put(new Condition("pactId",lb1.getId()))
			.put(new Condition("type","8"));
			List<AttachmentBean> list8 = attachmentService.getList(conditions8);
			lb.setRemark(lb1.getRemark());
			lb.setContractid(contractNewid);
			logisticService.add(lb);
			for(AttachmentBean ab1:list8){
				AttachmentBean ab2=new AttachmentBean();
				ab2.setPactId(lb.getId());
				ab2.setAttachmentName(ab1.getAttachmentName());
				ab2.setType(ab1.getType());
				attachmentService.add(ab2);
			}
			
			EhsBean eb1=ehsService.getList(conditions).get(0);
			ConditionSet conditions9=new ConditionSet();
			conditions9.put(new Condition("pactId",eb1.getId()))
			.put(new Condition("type","9"));
			List<AttachmentBean> list9 = attachmentService.getList(conditions9);
			eb.setRemark(eb1.getRemark());
			eb.setContractid(contractNewid);
			ehsService.add(eb);
			for(AttachmentBean ab1:list9){
				AttachmentBean ab2=new AttachmentBean();
				ab2.setPactId(eb.getId());
				ab2.setAttachmentName(ab1.getAttachmentName());
				ab2.setType(ab1.getType());
				attachmentService.add(ab2);
			}
			
			return response(ResponseType.HTML, true, "合同变更成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return response(ResponseType.HTML, false, "合同变更失败！");
		}
	}
	
	private long diviationHead;
	private String diviationRemark;
	private File secrecy;
	private String secrecyFileName;
	private String secrecyType;
	private String secrecyRemark;
	private File price;
	private String priceFileName;
	private String priceRemark;
	private File[] quanlity;
	private String[] quanlityFileName;
	private String quanlityRemark;
	private File[] purchaseInstruction;
	private String[] purchaseInstructionFileName;
	private String purchaseInstructionRemark;
	private File[] technology;
	private String[] technologyFileName;
	private String technologyRemark;
	private File[] supervision;
	private String[] supervisionFileName;
	private String supervisionRemark;
	private File[] logistic;
	private String[] logisticFileName;
	private String logisticRemark;
	private File[] ehs;
	private String[] ehsFileName;
	private String ehsRemark;
	private String status;
	private String contractid;
	private String confirmOption;
	private File yearContract;
	private String yearContractFileName;
	private File diviation;
	private String diviationFileName;
	private long reasonId;
	private String reason;

	
	public String getReason()
	{
		return reason;
	}

	public void setReason(String reason)
	{
		this.reason = reason;
	}

	public long getReasonId()
	{
		return reasonId;
	}

	public void setReasonId(long reasonId)
	{
		this.reasonId = reasonId;
	}

	public File getYearContract() {
		return yearContract;
	}

	public String getYearContractFileName() {
		return yearContractFileName;
	}

	public File getDiviation() {
		return diviation;
	}

	public String getDiviationFileName() {
		return diviationFileName;
	}

	public void setYearContract(File yearContract) {
		this.yearContract = yearContract;
	}

	public void setYearContractFileName(String yearContractFileName) {
		this.yearContractFileName = yearContractFileName;
	}

	public void setDiviation(File diviation) {
		this.diviation = diviation;
	}

	public void setDiviationFileName(String diviationFileName) {
		this.diviationFileName = diviationFileName;
	}

	public String getConfirmOption() {
		return confirmOption;
	}

	public void setConfirmOption(String confirmOption) {
		this.confirmOption = confirmOption;
	}

	public String getContractid() {
		return contractid;
	}

	public void setContractid(String contractid) {
		this.contractid = contractid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Resource(name = "UserService")
	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}
	@Resource(name = "SupplierBasicService")
	public void setSupplierBasicService(SupplierBasicService supplierBasicService)
	{
		this.supplierBasicService = supplierBasicService;
	}
	@Resource(name = "DiviationHeadService")
	public void setDiviationHeadService(
			DiviationHeadService diviationHeadService) {
		this.diviationHeadService = diviationHeadService;
	}
	@Resource(name = "ContractCancelService")
	public void setContractCancelService(
			ContractCancelService contractCancelService) {
		this.contractCancelService = contractCancelService;
	}
	@Resource(name = "ContractScanCopyService")
	public void setContractScanCopyService(
			ContractScanCopyService contractScanCopyService) {
		this.contractScanCopyService = contractScanCopyService;
	}
	@Resource(name = "YearcontractService")
	public void setYearcontractService(YearContractService yearcontractService) {
		this.yearcontractService = yearcontractService;
	}
	@Resource(name = "ContractExcutionService")
	public void setContractExcutionService(
			ContractExcutionService contractExcutionService) {
		this.contractExcutionService = contractExcutionService;
	}
	@Resource(name = "TechnologyService")
	public void setTechnologyService(TechnologyService technologyService) {
		this.technologyService = technologyService;
	}
	@Resource(name = "SupervisionService")
	public void setSupervisionService(SupervisionService supervisionService) {
		this.supervisionService = supervisionService;
	}
	@Resource(name = "LogisticService")
	public void setLogisticService(LogisticService logisticService) {
		this.logisticService = logisticService;
	}
	@Resource(name = "EhsService")
	public void setEhsService(EhsService ehsService) {
		this.ehsService = ehsService;
	}
	@Resource(name = "QuanlityService")
	public void setQuanlityService(QuanlityService quanlityService) {
		this.quanlityService = quanlityService;
	}
	@Resource(name = "PriceService")
	public void setPriceService(PriceService priceService) {
		this.priceService = priceService;
	}
	@Resource(name = "PurchaseInstructionService")
	public void setPurchaseInstructionService(
			PurchaseInstructionService purchaseInstructionService) {
		this.purchaseInstructionService = purchaseInstructionService;
	}
	@Resource(name = "ContractService")
	public void setService(ContractService contractService) {
		this.contractService = contractService;
	}
	@Resource(name = "SecrecyService")
	public void setService(SecrecyService secrecyService) {
		this.secrecyService = secrecyService;
	}
	@Resource(name = "AttachmentService")
	public void setService(AttachmentService attachmentService) {
		this.attachmentService = attachmentService;
	}
	public ContractBean getContractBean() {
		return contractBean;
	}
	public File getSecrecy() {
		return secrecy;
	}
	public String getSecrecyFileName() {
		return secrecyFileName;
	}
	public String getSecrecyType() {
		return secrecyType;
	}
	public String getSecrecyRemark() {
		return secrecyRemark;
	}
	public File getPrice() {
		return price;
	}
	public String getPriceFileName() {
		return priceFileName;
	}
	public String getPriceRemark() {
		return priceRemark;
	}
	public File[] getQuanlity() {
		return quanlity;
	}
	public String[] getQuanlityFileName() {
		return quanlityFileName;
	}
	public String getQuanlityRemark() {
		return quanlityRemark;
	}
	public void setContractBean(ContractBean contractBean) {
		this.contractBean = contractBean;
	}
	public void setSecrecy(File secrecy) {
		this.secrecy = secrecy;
	}
	public void setSecrecyFileName(String secrecyFileName) {
		this.secrecyFileName = secrecyFileName;
	}
	public void setSecrecyType(String secrecyType) {
		this.secrecyType = secrecyType;
	}
	public void setSecrecyRemark(String secrecyRemark) {
		this.secrecyRemark = secrecyRemark;
	}
	public void setPrice(File price) {
		this.price = price;
	}
	public void setPriceFileName(String priceFileName) {
		this.priceFileName = priceFileName;
	}
	public void setPriceRemark(String priceRemark) {
		this.priceRemark = priceRemark;
	}
	public void setQuanlity(File[] quanlity) {
		this.quanlity = quanlity;
	}
	public void setQuanlityFileName(String[] quanlityFileName) {
		this.quanlityFileName = quanlityFileName;
	}
	public void setQuanlityRemark(String quanlityRemark) {
		this.quanlityRemark = quanlityRemark;
	}
	
	public long getDiviationHead() {
		return diviationHead;
	}
	public String getDiviationRemark() {
		return diviationRemark;
	}
	public File[] getPurchaseInstruction() {
		return purchaseInstruction;
	}
	public String[] getPurchaseInstructionFileName() {
		return purchaseInstructionFileName;
	}
	public String getPurchaseInstructionRemark() {
		return purchaseInstructionRemark;
	}
	public File[] getTechnology() {
		return technology;
	}
	public String[] getTechnologyFileName() {
		return technologyFileName;
	}
	public String getTechnologyRemark() {
		return technologyRemark;
	}
	public File[] getSupervision() {
		return supervision;
	}
	public String[] getSupervisionFileName() {
		return supervisionFileName;
	}
	public String getSupervisionRemark() {
		return supervisionRemark;
	}
	public File[] getLogistic() {
		return logistic;
	}
	public String[] getLogisticFileName() {
		return logisticFileName;
	}
	public String getLogisticRemark() {
		return logisticRemark;
	}
	public File[] getEhs() {
		return ehs;
	}
	public String[] getEhsFileName() {
		return ehsFileName;
	}
	public String getEhsRemark() {
		return ehsRemark;
	}
	public void setDiviationHead(long diviationHead) {
		this.diviationHead = diviationHead;
	}
	public void setDiviationRemark(String diviationRemark) {
		this.diviationRemark = diviationRemark;
	}
	public void setPurchaseInstruction(File[] purchaseInstruction) {
		this.purchaseInstruction = purchaseInstruction;
	}
	public void setPurchaseInstructionFileName(String[] purchaseInstructionFileName) {
		this.purchaseInstructionFileName = purchaseInstructionFileName;
	}
	public void setPurchaseInstructionRemark(String purchaseInstructionRemark) {
		this.purchaseInstructionRemark = purchaseInstructionRemark;
	}
	public void setTechnology(File[] technology) {
		this.technology = technology;
	}
	public void setTechnologyFileName(String[] technologyFileName) {
		this.technologyFileName = technologyFileName;
	}
	public void setTechnologyRemark(String technologyRemark) {
		this.technologyRemark = technologyRemark;
	}
	public void setSupervision(File[] supervision) {
		this.supervision = supervision;
	}
	public void setSupervisionFileName(String[] supervisionFileName) {
		this.supervisionFileName = supervisionFileName;
	}
	public void setSupervisionRemark(String supervisionRemark) {
		this.supervisionRemark = supervisionRemark;
	}
	public void setLogistic(File[] logistic) {
		this.logistic = logistic;
	}
	public void setLogisticFileName(String[] logisticFileName) {
		this.logisticFileName = logisticFileName;
	}
	public void setLogisticRemark(String logisticRemark) {
		this.logisticRemark = logisticRemark;
	}
	public void setEhs(File[] ehs) {
		this.ehs = ehs;
	}
	public void setEhsFileName(String[] ehsFileName) {
		this.ehsFileName = ehsFileName;
	}
	public void setEhsRemark(String ehsRemark) {
		this.ehsRemark = ehsRemark;
	}
	public JsonItem getJsonItem(ContractBean object) throws Exception {
		return null;
	}

	private static void copy(File src, File dst) {
		try {
			InputStream in = null;
			OutputStream out = null;
			try {
				in = new BufferedInputStream(new FileInputStream(src),
						BUFFER_SIZE);
				out = new BufferedOutputStream(new FileOutputStream(dst),
						BUFFER_SIZE);
				byte[] buffer = new byte[BUFFER_SIZE];
				while (in.read(buffer) > 0) {
					out.write(buffer);
				}
			} catch (Exception ex) {
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
