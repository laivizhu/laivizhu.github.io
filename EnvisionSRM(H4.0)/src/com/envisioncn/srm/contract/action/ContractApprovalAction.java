/**
 * 
 */
package com.envisioncn.srm.contract.action;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.envisioncn.srm.basic.action.ABasicAction;
import com.envisioncn.srm.basic.model.Condition;
import com.envisioncn.srm.basic.model.ConditionSet;
import com.envisioncn.srm.basic.model.constants.AppConstants;
import com.envisioncn.srm.basic.model.json.JsonItem;
import com.envisioncn.srm.contract.bean.AttachmentBean;
import com.envisioncn.srm.contract.bean.ContractBean;
import com.envisioncn.srm.contract.bean.ContractExcutionBean;
import com.envisioncn.srm.contract.bean.DiviationBean;
import com.envisioncn.srm.contract.bean.YearcontractBean;
import com.envisioncn.srm.contract.common.ContractExcutionStatus;
import com.envisioncn.srm.contract.common.YearContractType;
import com.envisioncn.srm.contract.service.AttachmentService;
import com.envisioncn.srm.contract.service.ContractCancelService;
import com.envisioncn.srm.contract.service.ContractExcutionService;
import com.envisioncn.srm.contract.service.ContractService;
import com.envisioncn.srm.contract.service.DiviationHeadService;
import com.envisioncn.srm.contract.service.DiviationService;
import com.envisioncn.srm.contract.service.EhsService;
import com.envisioncn.srm.contract.service.LogisticService;
import com.envisioncn.srm.contract.service.PriceService;
import com.envisioncn.srm.contract.service.PurchaseInstructionService;
import com.envisioncn.srm.contract.service.QuanlityService;
import com.envisioncn.srm.contract.service.SupervisionService;
import com.envisioncn.srm.contract.service.TechnologyService;
import com.envisioncn.srm.contract.service.YearContractService;
import com.envisioncn.srm.supplier_basic.service.SupplierBasicService;
import com.envisioncn.srm.system.bean.UserBean;
import com.envisioncn.srm.system.service.UserService;

/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-27
 */
@SuppressWarnings("serial")
public class ContractApprovalAction extends ABasicAction<ContractBean> {
	private final String SAVE_PATH = getRealPath("/upload/contract");
	private ContractBean contractBean;
	private YearContractService yearcontractService;
	private ContractService contractService;
	private ContractCancelService contractCancelService;
	private DiviationService diviationService;
	private DiviationHeadService diviationHeadService;
	private PriceService priceService;
	private PurchaseInstructionService purchaseInstructionService;
	private TechnologyService technologyService;
	private SupervisionService supervisionService;
	private LogisticService logisticService;
	private EhsService ehsService;
	private QuanlityService quanlityService;
	private AttachmentService attachmentService;
	private UserService userService;
	private SupplierBasicService supplierBasicService;
	private ContractExcutionService contractExcutionService;
	private File attchment;
	private String attchmentFileName;
	@SuppressWarnings("unused")
	private InputStream file;
	
	public InputStream getFile()
	{
		InputStream is = ServletActionContext.getServletContext().getResourceAsStream("/upload/contract/" + attchment.getName());
		return is;
	}
	public void setFile(InputStream file)
	{
		this.file = file;
	}
	public File getAttchment()
	{
		return attchment;
	}
	public String getAttchmentFileName()
	{
		return attchmentFileName;
	}

	public void setAttchment(File attchment)
	{
		this.attchment = attchment;
	}

	public void setAttchmentFileName(String attchmentFileName)
	{
		this.attchmentFileName = attchmentFileName;
	}

	public String download() throws Exception
	{
		//String path=getRealPath(AppConstants.Contract.CONTRACT_DOWNLOAD_PATH);
		AttachmentBean bean = attachmentService.getObject(id);
		String fileName = bean.getAttachmentName();
		this.setAttchmentFileName(new String(fileName.getBytes(), "ISO8859-1"));
		File downFile = new File(SAVE_PATH + "/" + fileName);
		this.setAttchment(downFile);
		return "Download";
	}
	
	public String view() throws Exception{
		try {
			ConditionSet conditions0=new ConditionSet();
			ConditionSet conditions=new ConditionSet();
			contractBean=contractService.getObject(id);
			String contractid=contractBean.getContractId();
			conditions.put(new Condition("contractid",contractid));
			YearcontractBean yb=yearcontractService.getList(conditions0.put(new Condition("yearcontractid",contractBean.getYearcontractId()))).get(0);
			Map<String,String> map = new HashMap<String, String>();
			map.put("id", String.valueOf(contractBean.getId()));
			map.put("diviationId", String.valueOf(contractBean.getDiviationId()));
			map.put("supplierId", String.valueOf(contractBean.getSupplierId()));
			map.put("yearContractId", String.valueOf(contractBean.getYearcontractId()));
			map.put("contractId", contractid);
			map.put("supplierName", supplierBasicService.getObject(contractBean.getSupplierId()).getName());
			map.put("purchaseName", userService.getObjectById(UserBean.class, contractBean.getUserid()).getName() );
			switch(ContractExcutionStatus.fromValue(contractBean.getStatus())){
			case ContractCreated:
				map.put("status", ContractExcutionStatus.ContractCreated.toText());
				break;
			case ContractPendingApproval:
				map.put("status", ContractExcutionStatus.ContractPendingApproval.toText());
				break;
			case ContractBeenApproval:
				map.put("status", ContractExcutionStatus.ContractBeenApproval.toText());
				break;
			case ContractUnBeenApproval:
				map.put("status", ContractExcutionStatus.ContractUnBeenApproval.toText());
				break;
			case ContractCancel:
				map.put("status", ContractExcutionStatus.ContractCancel.toText());
				break;
			case ContractOver:
				map.put("status", ContractExcutionStatus.ContractOver.toText());
				break;
			case ContractModify:
				map.put("status", ContractExcutionStatus.ContractModify.toText());
				break;
			case ContractModify1:
				map.put("status", ContractExcutionStatus.ContractModify1.toText());
				break;
			}
			switch(YearContractType.fromValue(yb.getType())){
			case YearContract:
				map.put("yearContractType", YearContractType.YearContract.toText());
				break;
			case YearContractNo:
				map.put("yearContractType", YearContractType.YearContractNo.toText());
				break;
			}
			map.put("yearContractName", yb.getName());
			
			ConditionSet conditions2=new ConditionSet();
			conditions2.put(new Condition("pactId",priceService.getList(conditions).get(0).getId()))
			.put(new Condition("type","3"));
			map.put("price", attachmentService.getList(conditions2).get(0).getAttachmentName());
			map.put("priceRemark", priceService.getList(conditions).get(0).getRemark());
			
			map.put("diviationRemark", diviationHeadService.getList(conditions).get(0).getRemark());
			map.put("diviationVersion", diviationHeadService.getList(conditions).get(0).getVersion());
			map.put("quanlityRemark", quanlityService.getList(conditions).get(0).getRemark());
			map.put("purchaseInstructionRemark", purchaseInstructionService.getList(conditions).get(0).getRemark());
			map.put("technologyRemark", technologyService.getList(conditions).get(0).getRemark());
			map.put("supervisionRemark", supervisionService.getList(conditions).get(0).getRemark());
			map.put("logisticRemark", logisticService.getList(conditions).get(0).getRemark());
			map.put("ehsRemark", ehsService.getList(conditions).get(0).getRemark());
			
			ServletActionContext.getRequest().setAttribute(
					"contractConcent", map);
			
			long id0=diviationHeadService.getList(conditions).get(0).getId();
		
			conditions2.clear();
			conditions2.put(new Condition("diviationId",String.valueOf(id0)));
			List<DiviationBean> list = (List<DiviationBean>) diviationService.getList(conditions2);
			ServletActionContext.getRequest().setAttribute(
					"diviationList", list);
			
			ConditionSet conditions4=new ConditionSet();
			conditions4.put(new Condition("pactId",quanlityService.getList(conditions).get(0).getId()))
			.put(new Condition("type","4"));
			List<AttachmentBean> list4 = attachmentService.getList(conditions4);
			ServletActionContext.getRequest().setAttribute(
					"quanlityList", list4);
			
			ConditionSet conditions5=new ConditionSet();
			conditions5.put(new Condition("pactId",purchaseInstructionService.getList(conditions).get(0).getId()))
			.put(new Condition("type","5"));
			List<AttachmentBean> list5 = attachmentService.getList(conditions5);
			ServletActionContext.getRequest().setAttribute(
					"purchaseInstructionList", list5);
	
			ConditionSet conditions6=new ConditionSet();
			conditions6.put(new Condition("pactId",technologyService.getList(conditions).get(0).getId()))
			.put(new Condition("type","6"));
			List<AttachmentBean> list6 = attachmentService.getList(conditions6);
			ServletActionContext.getRequest().setAttribute(
					"technologyList", list6);
			
			ConditionSet conditions7=new ConditionSet();
			conditions7.put(new Condition("pactId",supervisionService.getList(conditions).get(0).getId()))
			.put(new Condition("type","7"));
			List<AttachmentBean> list7 = attachmentService.getList(conditions7);
			ServletActionContext.getRequest().setAttribute(
					"supervisionList", list7);
			
			ConditionSet conditions8=new ConditionSet();
			conditions8.put(new Condition("pactId",logisticService.getList(conditions).get(0).getId()))
			.put(new Condition("type","8"));
			List<AttachmentBean> list8 = attachmentService.getList(conditions8);
			ServletActionContext.getRequest().setAttribute(
					"logisticList", list8);
			
			ConditionSet conditions9=new ConditionSet();
			conditions9.put(new Condition("pactId",ehsService.getList(conditions).get(0).getId()))
			.put(new Condition("type","9"));
			List<AttachmentBean> list9 = attachmentService.getList(conditions9);
			ServletActionContext.getRequest().setAttribute(
					"ehsList", list9);
			
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String cancelView() throws Exception{
		try {
		ConditionSet conditions0=new ConditionSet();
		ConditionSet conditions=new ConditionSet();
		contractBean=contractService.getObject(id);
		String contractid=contractBean.getContractId();
		conditions.put(new Condition("contractid",contractid));
		ContractExcutionBean ceb=contractExcutionService.getList(conditions).get(0); 
		YearcontractBean yb=yearcontractService.getList(conditions0.put(new Condition("yearcontractid",contractBean.getYearcontractId()))).get(0);
		Map<String,String> map = new HashMap<String, String>();
		map.put("id", String.valueOf(contractBean.getId()));
		map.put("contractId", contractid);
		map.put("cancelReason", contractCancelService.getObject(ceb.getCancelReason()).getReason());
		map.put("supplierName", supplierBasicService.getObject(contractBean.getSupplierId()).getName());
		map.put("purchaseName", userService.getObjectById(UserBean.class, contractBean.getUserid()).getName() );
		switch(ContractExcutionStatus.fromValue(contractBean.getStatus())){
		case ContractCreated:
			map.put("status", ContractExcutionStatus.ContractCreated.toText());
			break;
		case ContractPendingApproval:
			map.put("status", ContractExcutionStatus.ContractPendingApproval.toText());
			break;
		case ContractBeenApproval:
			map.put("status", ContractExcutionStatus.ContractBeenApproval.toText());
			break;
		case ContractUnBeenApproval:
			map.put("status", ContractExcutionStatus.ContractUnBeenApproval.toText());
			break;
		case ContractCancel:
			map.put("status", ContractExcutionStatus.ContractCancel.toText());
			break;
		case ContractOver:
			map.put("status", ContractExcutionStatus.ContractOver.toText());
			break;
		case ContractModify:
			map.put("status", ContractExcutionStatus.ContractModify.toText());
			break;
		case ContractModify1:
			map.put("status", ContractExcutionStatus.ContractModify1.toText());
			break;
		}
		switch(YearContractType.fromValue(yb.getType())){
		case YearContract:
			map.put("yearContractType", YearContractType.YearContract.toText());
			break;
		case YearContractNo:
			map.put("yearContractType", YearContractType.YearContractNo.toText());
			break;
		}
		map.put("yearContractName", yb.getName());
		
		ConditionSet conditions2=new ConditionSet();
		conditions2.put(new Condition("pactId",priceService.getList(conditions).get(0).getId()))
		.put(new Condition("type","3"));
		map.put("price", attachmentService.getList(conditions2).get(0).getAttachmentName());
		map.put("priceRemark", priceService.getList(conditions).get(0).getRemark());
		
		map.put("diviationRemark", diviationHeadService.getList(conditions).get(0).getRemark());
		map.put("diviationVersion", diviationHeadService.getList(conditions).get(0).getVersion());
		map.put("quanlityRemark", quanlityService.getList(conditions).get(0).getRemark());
		map.put("purchaseInstructionRemark", purchaseInstructionService.getList(conditions).get(0).getRemark());
		map.put("technologyRemark", technologyService.getList(conditions).get(0).getRemark());
		map.put("supervisionRemark", supervisionService.getList(conditions).get(0).getRemark());
		map.put("logisticRemark", logisticService.getList(conditions).get(0).getRemark());
		map.put("ehsRemark", ehsService.getList(conditions).get(0).getRemark());
		
		ServletActionContext.getRequest().setAttribute(
				"contractConcent", map);
		
		long id0=diviationHeadService.getList(conditions).get(0).getId();
	
		conditions2.clear();
		conditions2.put(new Condition("diviationId",String.valueOf(id0)));
		List<DiviationBean> list = (List<DiviationBean>) diviationService.getList(conditions2);
		ServletActionContext.getRequest().setAttribute(
				"diviationList", list);
		
		ConditionSet conditions4=new ConditionSet();
		conditions4.put(new Condition("pactId",quanlityService.getList(conditions).get(0).getId()))
		.put(new Condition("type","4"));
		List<AttachmentBean> list4 = attachmentService.getList(conditions4);
		ServletActionContext.getRequest().setAttribute(
				"quanlityList", list4);
		
		ConditionSet conditions5=new ConditionSet();
		conditions5.put(new Condition("pactId",purchaseInstructionService.getList(conditions).get(0).getId()))
		.put(new Condition("type","5"));
		List<AttachmentBean> list5 = attachmentService.getList(conditions5);
		ServletActionContext.getRequest().setAttribute(
				"purchaseInstructionList", list5);
		
		ConditionSet conditions6=new ConditionSet();
		conditions6.put(new Condition("pactId",technologyService.getList(conditions).get(0).getId()))
		.put(new Condition("type","6"));
		List<AttachmentBean> list6 = attachmentService.getList(conditions6);
		ServletActionContext.getRequest().setAttribute(
				"technologyList", list6);
		
		ConditionSet conditions7=new ConditionSet();
		conditions7.put(new Condition("pactId",supervisionService.getList(conditions).get(0).getId()))
		.put(new Condition("type","7"));
		List<AttachmentBean> list7 = attachmentService.getList(conditions7);
		ServletActionContext.getRequest().setAttribute(
				"supervisionList", list7);
		
		ConditionSet conditions8=new ConditionSet();
		conditions8.put(new Condition("pactId",logisticService.getList(conditions).get(0).getId()))
		.put(new Condition("type","8"));
		List<AttachmentBean> list8 = attachmentService.getList(conditions8);
		ServletActionContext.getRequest().setAttribute(
				"logisticList", list8);
		
		ConditionSet conditions9=new ConditionSet();
		conditions9.put(new Condition("pactId",ehsService.getList(conditions).get(0).getId()))
		.put(new Condition("type","9"));
		List<AttachmentBean> list9 = attachmentService.getList(conditions9);
		ServletActionContext.getRequest().setAttribute(
				"ehsList", list9);
		
		return AppConstants.ContractReturnConstants.SUCCESS_CONTRACT_CANCEL_VIEW;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
	}
	
	public String modifyView() throws Exception{
		try {
		ConditionSet conditions0=new ConditionSet();
		ConditionSet conditions=new ConditionSet();
		contractBean=contractService.getObject(id);
		String contractid=contractBean.getContractId();
		conditions.put(new Condition("contractid",contractid));
		YearcontractBean yb=yearcontractService.getList(conditions0.put(new Condition("yearcontractid",contractBean.getYearcontractId()))).get(0);
		Map<String,String> map = new HashMap<String, String>();
		map.put("id", String.valueOf(contractBean.getId()));
		map.put("contractId", contractid);
		map.put("supplierName", supplierBasicService.getObject(contractBean.getSupplierId()).getName());
		map.put("purchaseName", userService.getObjectById(UserBean.class, contractBean.getUserid()).getName() );
		switch(ContractExcutionStatus.fromValue(contractBean.getStatus())){
		case ContractCreated:
			map.put("status", ContractExcutionStatus.ContractCreated.toText());
			break;
		case ContractPendingApproval:
			map.put("status", ContractExcutionStatus.ContractPendingApproval.toText());
			break;
		case ContractBeenApproval:
			map.put("status", ContractExcutionStatus.ContractBeenApproval.toText());
			break;
		case ContractUnBeenApproval:
			map.put("status", ContractExcutionStatus.ContractUnBeenApproval.toText());
			break;
		case ContractCancel:
			map.put("status", ContractExcutionStatus.ContractCancel.toText());
			break;
		case ContractOver:
			map.put("status", ContractExcutionStatus.ContractOver.toText());
			break;
		case ContractModify:
			map.put("status", ContractExcutionStatus.ContractModify.toText());
			break;
		case ContractModify1:
			map.put("status", ContractExcutionStatus.ContractModify1.toText());
			break;
		}
		switch(YearContractType.fromValue(yb.getType())){
		case YearContract:
			map.put("yearContractType", YearContractType.YearContract.toText());
			break;
		case YearContractNo:
			map.put("yearContractType", YearContractType.YearContractNo.toText());
			break;
		}
		map.put("yearContractName", yb.getName());
		
		ConditionSet conditions2=new ConditionSet();
		conditions2.put(new Condition("pactId",priceService.getList(conditions).get(0).getId()))
		.put(new Condition("type","3"));
		map.put("priceVersion", String.valueOf(priceService.getList(conditions).get(0).getVersion()));
		map.put("price", attachmentService.getList(conditions2).get(0).getAttachmentName());
		map.put("priceRemark", priceService.getList(conditions).get(0).getRemark());
		map.put("diviationRemark", diviationHeadService.getList(conditions).get(0).getRemark());
		map.put("diviationVersion", diviationHeadService.getList(conditions).get(0).getVersion());
		map.put("quanlityRemark", quanlityService.getList(conditions).get(0).getRemark());
		map.put("purchaseInstructionRemark", purchaseInstructionService.getList(conditions).get(0).getRemark());
		map.put("technologyRemark", technologyService.getList(conditions).get(0).getRemark());
		map.put("supervisionRemark", supervisionService.getList(conditions).get(0).getRemark());
		map.put("logisticRemark", logisticService.getList(conditions).get(0).getRemark());
		map.put("ehsRemark", ehsService.getList(conditions).get(0).getRemark());
		
		ServletActionContext.getRequest().setAttribute(
				"contractConcent", map);
		long id0=diviationHeadService.getList(conditions).get(0).getId();
		conditions2.clear();
		conditions2.put(new Condition("diviationId",String.valueOf(id0)));
		List<DiviationBean> list = (List<DiviationBean>) diviationService.getList(conditions2);
		ServletActionContext.getRequest().setAttribute(
				"diviationList", list);
		
		ConditionSet conditions4=new ConditionSet();
		conditions4.put(new Condition("pactId",quanlityService.getList(conditions).get(0).getId()))
		.put(new Condition("type","4"));
		List<AttachmentBean> list4 = attachmentService.getList(conditions4);
		ServletActionContext.getRequest().setAttribute(
				"quanlityList", list4);
		
		ConditionSet conditions5=new ConditionSet();
		conditions5.put(new Condition("pactId",purchaseInstructionService.getList(conditions).get(0).getId()))
		.put(new Condition("type","5"));
		List<AttachmentBean> list5 = attachmentService.getList(conditions5);
		ServletActionContext.getRequest().setAttribute(
				"purchaseInstructionList", list5);
		
		ConditionSet conditions6=new ConditionSet();
		conditions6.put(new Condition("pactId",technologyService.getList(conditions).get(0).getId()))
		.put(new Condition("type","6"));
		List<AttachmentBean> list6 = attachmentService.getList(conditions6);
		ServletActionContext.getRequest().setAttribute(
				"technologyList", list6);
		
		ConditionSet conditions7=new ConditionSet();
		conditions7.put(new Condition("pactId",supervisionService.getList(conditions).get(0).getId()))
		.put(new Condition("type","7"));
		List<AttachmentBean> list7 = attachmentService.getList(conditions7);
		ServletActionContext.getRequest().setAttribute(
				"supervisionList", list7);
		
		ConditionSet conditions8=new ConditionSet();
		conditions8.put(new Condition("pactId",logisticService.getList(conditions).get(0).getId()))
		.put(new Condition("type","8"));
		List<AttachmentBean> list8 = attachmentService.getList(conditions8);
		ServletActionContext.getRequest().setAttribute(
				"logisticList", list8);
		
		ConditionSet conditions9=new ConditionSet();
		conditions9.put(new Condition("pactId",ehsService.getList(conditions).get(0).getId()))
		.put(new Condition("type","9"));
		List<AttachmentBean> list9 = attachmentService.getList(conditions9);
		ServletActionContext.getRequest().setAttribute(
				"ehsList", list9);
		
		return AppConstants.ContractReturnConstants.SUCCESS_CONTRACT_MODIFY_VIEW;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
	}
	
	public JsonItem getJsonItem(ContractBean object) throws Exception {
		return null;
	}
	
	@Resource(name = "ContractCancelService")
	public void setContractCancelService(ContractCancelService contractCancelService)
	{
		this.contractCancelService = contractCancelService;
	}
	@Resource(name = "ContractExcutionService")
	public void setContractExcutionService(
			ContractExcutionService contractExcutionService) {
		this.contractExcutionService = contractExcutionService;
	}
	@Resource(name = "SupplierBasicService")
	public void setSupplierBasicService(
			SupplierBasicService supplierBasicService) {
		this.supplierBasicService = supplierBasicService;
	}
	@Resource(name = "UserService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Resource(name = "DiviationHeadService")
	public void setDiviationHeadService(
			DiviationHeadService diviationHeadService) {
		this.diviationHeadService = diviationHeadService;
	}
	@Resource(name = "YearcontractService")
	public void setYearcontractService(YearContractService yearcontractService) {
		this.yearcontractService = yearcontractService;
	}
	@Resource(name = "DiviationService")
	public void setDiviationService(DiviationService diviationService) {
		this.diviationService = diviationService;
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
	@Resource(name = "AttachmentService")
	public void setService(AttachmentService attachmentService) {
		this.attachmentService = attachmentService;
	}
	
}
