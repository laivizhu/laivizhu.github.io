package com.envisioncn.srm.supplier_basic.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.Restrictions;

import com.envisioncn.srm.basic.action.ABasicAction;
import com.envisioncn.srm.basic.model.CriterionSet;
import com.envisioncn.srm.basic.model.constants.AppConstants;
import com.envisioncn.srm.basic.model.constants.ErrorMessageConstants;
import com.envisioncn.srm.basic.model.constants.SupplierConstants;
import com.envisioncn.srm.basic.model.json.JsonItem;
import com.envisioncn.srm.basic.model.json.JsonList;
import com.envisioncn.srm.basic.model.type.ResponseType;
import com.envisioncn.srm.basic.service.SendEmailService;
import com.envisioncn.srm.basic.util.DataUtil;
import com.envisioncn.srm.basic.util.DateUtil;
import com.envisioncn.srm.basic.util.FileUtil;
import com.envisioncn.srm.basic.util.ParamAssert;
import com.envisioncn.srm.material.bean.MaterialCategory;
import com.envisioncn.srm.material.model.CategoryType;
import com.envisioncn.srm.material.service.IMaterialCategoryService;
import com.envisioncn.srm.supplier_basic.bean.SupplierBasic;
import com.envisioncn.srm.supplier_basic.bean.SupplierInfo;
import com.envisioncn.srm.supplier_basic.model.Password;
import com.envisioncn.srm.supplier_basic.model.Status;
import com.envisioncn.srm.supplier_basic.model.SupplierInfoFile;
import com.envisioncn.srm.supplier_basic.model.SupplierSearchType;
import com.envisioncn.srm.supplier_basic.service.ISupplierBasicService;
import com.envisioncn.srm.supplier_basic.service.ISupplierInfoService;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-19
 */
@SuppressWarnings("serial")
public class SupplierAction extends ABasicAction<SupplierBasic> {
	private SupplierBasic supplierBasic;
	private SupplierInfo supplierInfo;
	private ISupplierBasicService supplierBasicService;
	private IMaterialCategoryService materialCategoryService;
	private SendEmailService sendEmailService;
	private ISupplierInfoService supplierInfoService;

	private String receFileDate;
	private String deliveryNo;

	private int status;
	private long subCategoryId;
	private Password password;
	private String reason;

	private SupplierInfoFile supplierInfoFile;

	public SupplierAction() {
		downLoadPath = SupplierConstants.ValueConstants.SUPPLIER_DOWNLOAD_PATH;
	}

	public String add() throws Exception {
		ParamAssert.isNotEmptyString(supplierBasic.getName(), SupplierConstants.ErrorMessage.BASIC_NAME_NOTNULL);
		ParamAssert.isNotEmptyString(supplierBasic.getEmail(), SupplierConstants.ErrorMessage.BASIC_EMAIL_NOTNULL);
		ParamAssert.isNotEmptyString(supplierBasic.getPhone(), SupplierConstants.ErrorMessage.BASIC_PHONE_NOTNULL);
		ParamAssert.isNotEmptyString(supplierBasic.getPersonName(), SupplierConstants.ErrorMessage.BASIC_PERSON_NOTNULL);
		ParamAssert.isTrue(supplierBasic.getUserId() != 0, SupplierConstants.ErrorMessage.BASIC_PURCHASE_USER_NOTCHOISE);
		ParamAssert.isTrue(subCategoryId != 0, SupplierConstants.ErrorMessage.BASIC_MATERIALCATEGORY);
		supplierBasic.setStatus(Status.APPLYING.toValue());
		supplierBasic.setApplyDate(new Date());
		supplierBasic.setAccount("test"); // ????????????????????????????????????????
		supplierBasic.setPassword(DataUtil.getRandPassword());
		MaterialCategory category = this.materialCategoryService.getObject(subCategoryId);
		supplierBasic.getMaterialCategory().add(category);
		supplierBasicService.add(supplierBasic);
		File file = FileUtil.getFile(this.getRealPath(SupplierConstants.ValueConstants.SUPPLIER_FILE));
		sendEmailService.sendMail(supplierBasic.getEmail(), SupplierConstants.InfoMessage.EMAIL_CONFIRM_SUBJECT,
				sendEmailService.getMailText(supplierBasicService.getConfirmMailInfo(supplierBasic),
						AppConstants.MailTemplate.REGISTERCONFIRM), file);
		return response(true);
	}

	public String supplierInfoSave() throws Exception {
		try {
			ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
			SupplierBasic supplier = this.supplierBasicService.getObject(id);
			this.supplierBasicService.saveSupplierBasic(id, supplierBasic, subCategoryId);
			if (supplier.getSupplierInfoId() == 0) {
				supplierInfoService.saveUploadFile(supplierInfoFile, supplierInfo,
						this.getRealPath(SupplierConstants.ValueConstants.SUPPLIER_UPLOAD_PATH));
				this.supplierBasicService.saveSupplierInfo(id, supplierInfo);
				return response(ResponseType.JSON, SupplierConstants.InfoMessage.SUBMIT_SUCCESS);
			} else {
				supplierInfoService.saveUploadFile(supplierInfoFile, supplierInfo,
						this.getRealPath(SupplierConstants.ValueConstants.SUPPLIER_UPLOAD_PATH));
				supplierInfoService.updateSupplierInfo(supplierInfo, supplier.getSupplierInfoId());
				return response(ResponseType.JSON, SupplierConstants.InfoMessage.SAVE_SUCCESS);
			}
		} catch (Exception e) {
			return response(ResponseType.JSON, e.getMessage());
		}
	}

	public String supplierSubmit() throws Exception {
		try {
			ParamAssert.isNotNULLFilePDF(this.supplierInfoFile.getBankAccountInfo(),
					supplierInfoFile.getBankAccountInfoFileName(),SupplierConstants.ErrorMessage.bankAccountInfo_NOTNULL);
			ParamAssert.isNotNULLFilePDF(this.supplierInfoFile.getBusinessLicense(),
					supplierInfoFile.getBusinessLicenseFileName(),SupplierConstants.ErrorMessage.businessLicense_NOTNULL);
			ParamAssert.isNotNULLFilePDF(this.supplierInfoFile.getLegalerIdentity(),
					supplierInfoFile.getLegalerIdentityFileName(),SupplierConstants.ErrorMessage.legalerIdentity_NOTNULL);
			ParamAssert.isNotNULLFilePDF(this.supplierInfoFile.getOrgCodeCertificate(),
					supplierInfoFile.getOrgCodeCertificateFileName(),SupplierConstants.ErrorMessage.orgCodeCertificate_NOTNULL);
			ParamAssert.isNotNULLFilePDF(this.supplierInfoFile.getTaxRegCertificate(),
					supplierInfoFile.getTaxRegCertificateFileName(),SupplierConstants.ErrorMessage.taxRegCertificate_NOTNULL);
			ParamAssert.isNotNULLFilePDF(this.supplierInfoFile.getSupplierDesc(),
					supplierInfoFile.getSupplierDescFileName(), SupplierConstants.ErrorMessage.supplierDesc_NOTNULL);
			ParamAssert.isNotNULLFilePDF(this.supplierInfoFile.getCapacityDesc(),
					supplierInfoFile.getCapacityDescFileName(), SupplierConstants.ErrorMessage.capacityDesc_NOTNULL);
			ParamAssert.isNotNULLFilePDF(this.supplierInfoFile.getCreditRatingCertificate(),
					supplierInfoFile.getCreditRatingCertificateFileName(),SupplierConstants.ErrorMessage.creditRatingCertificate_NOTNULL);
			ParamAssert.isNotNULLFilePDF(this.supplierInfoFile.getEnvManageCertificate(),
					supplierInfoFile.getEnvManageCertificateFileName(),SupplierConstants.ErrorMessage.envManageCertificate_NOTNULL);
			ParamAssert.isNotNULLFilePDF(this.supplierInfoFile.getQualityManageCertificate(),
					supplierInfoFile.getQualityManageCertificateFileName(),SupplierConstants.ErrorMessage.qualityManageCertificate_NOTNULL);
			ParamAssert.isNotNULLFilePDF(this.supplierInfoFile.getSecurityManageCertificate(),
					supplierInfoFile.getSecurityManageCertificateFileName(),SupplierConstants.ErrorMessage.securityManageCertificate_NOTNULL);
			ParamAssert.isNotNULLFilePDF(this.supplierInfoFile.getProprietaryMaterial(),
					supplierInfoFile.getProprietaryMaterialFileName(),SupplierConstants.ErrorMessage.proprietaryMaterial_NOTNULL);
			ParamAssert.isNotNULLFilePDF(this.supplierInfoFile.getOtherMaterial(),
					supplierInfoFile.getOtherMaterialFileName(), SupplierConstants.ErrorMessage.otherMaterial_NOTNULL);
			ParamAssert.isNotNULLFilePDF(this.supplierInfoFile.getProductionLicense(),
					supplierInfoFile.getProductionLicenseFileName(),SupplierConstants.ErrorMessage.productionLicense_NOTNULL);
			ParamAssert.isNotNULLFileExcel(this.supplierInfoFile.getSurveyTable(),
					supplierInfoFile.getSurveyTableFileName(), SupplierConstants.ErrorMessage.surveyTable_NOTNULL);

			ParamAssert.isNotEmptyString(this.supplierInfo.getSellName(),
					SupplierConstants.ErrorMessage.SUPPLIERINFO_SELLNAME_NOTNULL);
			ParamAssert.isNotEmptyString(this.supplierInfo.getSellPhone(),
					SupplierConstants.ErrorMessage.SUPPLIERINFO_SELLPHONE_NOTNULL);
			ParamAssert.isNotEmptyString(this.supplierInfo.getSellLandline(),
					SupplierConstants.ErrorMessage.SUPPLIERINFO_SELLLANDLINE_NOTNULL);
			ParamAssert.isNotEmptyString(this.supplierInfo.getSellEmail(),
					SupplierConstants.ErrorMessage.SUPPLIERINFO_SELLEMAIL_NOTNULL);

			ParamAssert.isNotEmptyString(this.supplierInfo.getQualityName(),
					SupplierConstants.ErrorMessage.SUPPLIERINFO_QUALITYNAME_NOTNULL);
			ParamAssert.isNotEmptyString(this.supplierInfo.getQualityPhone(),
					SupplierConstants.ErrorMessage.SUPPLIERINFO_QUALITYPHONE_NOTNULL);
			ParamAssert.isNotEmptyString(this.supplierInfo.getQualityLandLine(),
					SupplierConstants.ErrorMessage.SUPPLIERINFO_QUALITYLANDLINE_NOTNULL);
			ParamAssert.isNotEmptyString(this.supplierInfo.getQualityEmail(),
					SupplierConstants.ErrorMessage.SUPPLIERINFO_QUALITYEMAIL_NOTNULL);

			ParamAssert.isNotEmptyString(this.supplierInfo.getLogName(),
					SupplierConstants.ErrorMessage.SUPPLIERINFO_LOGNAME_NOTNULL);
			ParamAssert.isNotEmptyString(this.supplierInfo.getLogPhone(),
					SupplierConstants.ErrorMessage.SUPPLIERINFO_LOGPHONE_NOTNULL);
			ParamAssert.isNotEmptyString(this.supplierInfo.getLogLandLine(),
					SupplierConstants.ErrorMessage.SUPPLIERINFO_LOGLANDLINE_NOTNULL);
			ParamAssert.isNotEmptyString(this.supplierInfo.getLogEmail(),
					SupplierConstants.ErrorMessage.SUPPLIERINFO_LOGEMAIL_NOTNULL);

			ParamAssert.isNotEmptyString(this.supplierInfo.getITName(),
					SupplierConstants.ErrorMessage.SUPPLIERINFO_ITNAME_NOTNULL);
			ParamAssert.isNotEmptyString(this.supplierInfo.getITPhone(),
					SupplierConstants.ErrorMessage.SUPPLIERINFO_ITPHONE_NOTNULL);
			ParamAssert.isNotEmptyString(this.supplierInfo.getITLandLine(),
					SupplierConstants.ErrorMessage.SUPPLIERINFO_ITLANDLINE_NOTNULL);
			ParamAssert.isNotEmptyString(this.supplierInfo.getITEmail(),
					SupplierConstants.ErrorMessage.SUPPLIERINFO_ITEMAIL_NOTNULL);

			ParamAssert.isNotEmptyString(this.supplierInfo.getAfterSaleName(),
					SupplierConstants.ErrorMessage.SUPPLIERINFO_AFTERSALENAME_NOTNULL);
			ParamAssert.isNotEmptyString(this.supplierInfo.getAfterSalePhone(),
					SupplierConstants.ErrorMessage.SUPPLIERINFO_AFTERSALEPHONE_NOTNULL);
			ParamAssert.isNotEmptyString(this.supplierInfo.getAfterSaleLandLine(),
					SupplierConstants.ErrorMessage.SUPPLIERINFO_AFTERSALELANDLINE_NOTNULL);
			ParamAssert.isNotEmptyString(this.supplierInfo.getAfterSaleEmail(),
					SupplierConstants.ErrorMessage.SUPPLIERINFO_AFTERSALEEMAIL_NOTNULL);

			ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
			SupplierBasic supplier = this.supplierBasicService.getObject(id);
			if (supplier.getSupplierInfoId() == 0) {
				supplierInfoService.saveUploadFile(supplierInfoFile, supplierInfo,
						this.getRealPath(SupplierConstants.ValueConstants.SUPPLIER_UPLOAD_PATH));
				this.supplierBasicService.saveSupplierInfo(id, supplierInfo);
				return response(ResponseType.JSON, SupplierConstants.InfoMessage.SUBMIT_SUCCESS);
			} else {
				return response(ResponseType.JSON, SupplierConstants.ErrorMessage.SUPPLIERINFO_HAS_EXIST);
			}
		} catch (Exception e) {
			return response(ResponseType.JSON, e.getMessage());
		}
	}

	public String delete() throws Exception {
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		SupplierBasic supplier = this.supplierBasicService.getObject(id);
		supplier.setMaterialCategory(null);
		this.supplierBasicService.remove(id);
		return response(true);
	}

	public String getSupplierInfoForm() throws Exception {
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		SupplierBasic supplier = this.supplierBasicService.getObject(id);
		SupplierInfo supplierInfo = this.supplierInfoService.getObject(supplier.getSupplierInfoId());
		return response(this.getSupplierInfoJsonItem(supplierInfo).toFormDataString(true));
	}

	private JsonItem getSupplierInfoJsonItem(SupplierInfo info) {
		JsonItem jsonItem = new JsonItem();
		if (info != null) {
			jsonItem.add("afterSaleEmail", info.getAfterSaleEmail())
			.add("sellName", info.getSellName()).add("sellPhone", info.getSellPhone())
			.add("sellLandline", info.getSellLandline()).add("sellEmail", info.getSellEmail())
			.add("qualityName", info.getQualityName()).add("qualityPhone", info.getQualityPhone())
			.add("qualityLandLine", info.getQualityLandLine()).add("qualityEmail", info.getQualityEmail())
			.add("iTName", info.getITName()).add("iTPhone", info.getITPhone())
			.add("iTLandLine", info.getITLandLine()).add("iTEmail", info.getITEmail())
			.add("logName", info.getLogName()).add("logPhone", info.getLogPhone())
			.add("logLandLine", info.getLogLandLine()).add("logEmail", info.getLogEmail())
			.add("afterSaleName", info.getAfterSaleName()).add("afterSalePhone", info.getAfterSalePhone())
			.add("afterSaleLandLine", info.getAfterSaleLandLine()).add("afterSaleEmail", info.getAfterSaleEmail())
			.add("businessLicense",FileUtil.getFileUrl(SupplierConstants.ValueConstants.DOWNLOADFILE_ACTION,
							info.getBusinessLicense(), SupplierConstants.InfoMessage.businessLicense))
			.add("legalerIdentity",FileUtil.getFileUrl(SupplierConstants.ValueConstants.DOWNLOADFILE_ACTION,
							info.getLegalerIdentity(), SupplierConstants.InfoMessage.legalerIdentity))
			.add("orgCodeCertificate",FileUtil.getFileUrl(SupplierConstants.ValueConstants.DOWNLOADFILE_ACTION,
							info.getOrgCodeCertificate(), SupplierConstants.InfoMessage.orgCodeCertificate))
			.add("taxRegCertificate",FileUtil.getFileUrl(SupplierConstants.ValueConstants.DOWNLOADFILE_ACTION,
							info.getTaxRegCertificate(), SupplierConstants.InfoMessage.taxRegCertificate))
			.add("bankAccountInfo",FileUtil.getFileUrl(SupplierConstants.ValueConstants.DOWNLOADFILE_ACTION,
							info.getBankAccountInfo(), SupplierConstants.InfoMessage.bankAccountInfo))
			.add("supplierDesc",FileUtil.getFileUrl(SupplierConstants.ValueConstants.DOWNLOADFILE_ACTION,
							info.getSupplierDesc(), SupplierConstants.InfoMessage.supplierDesc))
			.add("capacityDesc",FileUtil.getFileUrl(SupplierConstants.ValueConstants.DOWNLOADFILE_ACTION,
							info.getCapacityDesc(), SupplierConstants.InfoMessage.capacityDesc))
			.add("creditRatingCertificate",FileUtil.getFileUrl(SupplierConstants.ValueConstants.DOWNLOADFILE_ACTION,
							info.getCreditRatingCertificate(),SupplierConstants.InfoMessage.creditRatingCertificate))
			.add("envManageCertificate",FileUtil.getFileUrl(SupplierConstants.ValueConstants.DOWNLOADFILE_ACTION,
							info.getEnvManageCertificate(), SupplierConstants.InfoMessage.envManageCertificate))
			.add("qualityManageCertificate",FileUtil.getFileUrl(SupplierConstants.ValueConstants.DOWNLOADFILE_ACTION,
							info.getQualityManageCertificate(),SupplierConstants.InfoMessage.qualityManageCertificate))
			.add("securityManageCertificate",FileUtil.getFileUrl(SupplierConstants.ValueConstants.DOWNLOADFILE_ACTION,
							info.getSecurityManageCertificate(),SupplierConstants.InfoMessage.securityManageCertificate))
			.add("proprietaryMaterial",FileUtil.getFileUrl(SupplierConstants.ValueConstants.DOWNLOADFILE_ACTION,
							info.getProprietaryMaterial(), SupplierConstants.InfoMessage.proprietaryMaterial))
			.add("otherMaterial",FileUtil.getFileUrl(SupplierConstants.ValueConstants.DOWNLOADFILE_ACTION,
							info.getOtherMaterial(), SupplierConstants.InfoMessage.otherMaterial))
			.add("surveyTable",FileUtil.getFileUrl(SupplierConstants.ValueConstants.DOWNLOADFILE_ACTION,
							info.getSurveyTable(), SupplierConstants.InfoMessage.surveyTable))
			.add("productionLicense",FileUtil.getFileUrl(SupplierConstants.ValueConstants.DOWNLOADFILE_ACTION,
							info.getProductionLicense(), SupplierConstants.InfoMessage.productionLicense));
		}
		return jsonItem;
	}

	public String list() throws Exception {
		JsonList jsonList = new JsonList();
		CriterionSet conditions = null;
		if (status != Status.LISTALL.toValue()) {
			conditions = CriterionSet.CreateCriterion().put(Restrictions.eq("status", status));
		}
		List<SupplierBasic> supplierList = this.supplierBasicService.getList(conditions, start, limit);
		for (SupplierBasic supplier : supplierList) {
			jsonList.add(getJsonItem(supplier));
		}
		return response(jsonList.toPageString(this.supplierBasicService.getCount(conditions)));
	}

	public String searchTypeList() throws Exception {
		JsonList jsonList = new JsonList();
		for (SupplierSearchType type : SupplierSearchType.values()) {
			jsonList.createItem().add("id", type.toProperty()).add("name", type.toText());
		}
		return response(jsonList);
	}

	public String get() throws Exception {
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		return response(getJsonItem(supplierBasicService.getObject(id)).toFormDataString(true));
	}

	/**
	 * 
	 * 函数功能说明:供应商端修改密码 修改者名字Janlu 修改日期 2012-11-25 修改内容
	 * 
	 * @参数： @return
	 * @参数： @throws Exception
	 * @return String
	 * @throws
	 */
	public String chanagePassword() throws Exception {
		ParamAssert.isTrue(password.getNewPassword().endsWith(password.getConfirmPassword()),
				SupplierConstants.ErrorMessage.NEWPASSWORDNOTSAMPLE);
		SupplierBasic supplier = this.supplierBasicService.getObject((long) 1); // ?????????????现在默认为1
		if (!supplier.getPassword().endsWith(password.getOldPassword())) {
			return response(false, SupplierConstants.ErrorMessage.OLDPASSWORD_ERROR);
		} else {
			supplier.setPassword(password.getNewPassword());
			this.supplierBasicService.modify(supplier);
			return response(true);
		}
	}

	/**
	 * 
	 * 函数功能说明:初审通过 修改者名字Janlu 修改日期 2012-11-25 修改内容
	 * 
	 * @参数： @return
	 * @参数： @throws Exception
	 * @return String
	 * @throws
	 */
	public String passDeal() throws Exception {
		try {
			ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
			if (status == Status.PASS.toValue()) {
				ParamAssert.isNotEmptyString(receFileDate,
						SupplierConstants.ErrorMessage.SUPPLIERINFO_RECEFILE_DATE_NOTNULL);
				ParamAssert.isNotEmptyString(deliveryNo, SupplierConstants.ErrorMessage.SUPPLIERINFO_DELIVERNO_NOTNULL);
			}
			SupplierBasic supplier = this.supplierBasicService.getObject(id);
			supplier.setStatus(Status.fromValue(status).toValue());
			if (status == Status.PASS.toValue()) {
				SupplierInfo info = this.supplierInfoService.getObject(supplier.getSupplierInfoId());
				info.setDeliveryNo(deliveryNo);
				info.setReceiveFileDate(DateUtil.formatString(receFileDate));
				this.supplierInfoService.modify(info);
			}
			this.supplierBasicService.modify(supplier);
			return response(true);
		} catch (Exception e) {
			return response(false, e.getMessage());
		}

	}

	/**
	 * 
	 * 函数功能说明:供应商审核被驳回处理 修改者名字Janlu 修改日期 2012-11-25 修改内容
	 * 
	 * @参数： @return
	 * @参数： @throws Exception
	 * @return String
	 * @throws
	 */
	public String reject() throws Exception {
		ParamAssert.isNotEmptyString(reason, SupplierConstants.ErrorMessage.REJECT_REASON_NOTNULL);
		SupplierBasic supplier = this.supplierBasicService.getObject(id);
		sendEmailService.sendMail(supplier.getEmail(), SupplierConstants.InfoMessage.EMAIL_REJECT_REASON_SUBJECT,
				sendEmailService.getMailText(supplierBasicService.getRejectMainInfo(supplier, reason),
						AppConstants.MailTemplate.SUPPLIER_REJECT));
		return response(true);
	}

	public String stop() throws Exception {
		ParamAssert.isNotEmptyString(reason, SupplierConstants.ErrorMessage.REJECT_REASON_NOTNULL);
		SupplierBasic supplier = this.supplierBasicService.getObject(id);
		supplier.setStopReason(reason);
		supplier.setStatus(Status.STOP.toValue());
		this.supplierBasicService.modify(supplier);
		return response(true);
	}

	public JsonItem getJsonItem(SupplierBasic supplier) throws Exception {
		JsonItem item = new JsonItem();
		if (supplier != null) {
			item.add("id", supplier.getId())
				.add("name", supplier.getName())
				.add("code", supplier.getId())
				.add("phone", supplier.getPhone())
				.add("personName", supplier.getPersonName())
				.add("email", supplier.getEmail())
				.add("status", Status.fromValue(supplier.getStatus()).toText())
				.add("classify",materialCategoryService.getParentCategoryByType(
								supplier.getMaterialCategory().get(0).getId(), CategoryType.MaterialClassify).getName())
				.add("category",materialCategoryService.getParentCategoryByType(
								supplier.getMaterialCategory().get(0).getId(), CategoryType.MaterialCategory).getName())
				.add("subCategory",materialCategoryService.getParentCategoryByType(
								supplier.getMaterialCategory().get(0).getId(), CategoryType.MaterialSubCategory).getName())
				.add("applyDate", DateUtil.formatDate(supplier.getApplyDate()))
				.add("productivityMaterial",supplier.isProductivityMaterial() ? SupplierConstants.InfoMessage.IS_PRODUCE_MATERIAL
								: SupplierConstants.InfoMessage.NOT_PRODUCE_MATERIAL)
				.add("establishDate", DateUtil.formatDate(supplier.getEstablishDate()));
		}
		return item;
	}

	public SupplierBasic getSupplierBasic() {
		return supplierBasic;
	}

	public void setSupplierBasic(SupplierBasic supplierBasic) {
		this.supplierBasic = supplierBasic;
	}

	public SupplierInfo getSupplierInfo() {
		return supplierInfo;
	}

	public void setSupplierInfo(SupplierInfo supplierInfo) {
		this.supplierInfo = supplierInfo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Password getPassword() {
		return password;
	}

	public void setPassword(Password password) {
		this.password = password;
	}

	public long getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(long subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getReceFileDate() {
		return receFileDate;
	}

	public void setReceFileDate(String receFileDate) {
		this.receFileDate = receFileDate;
	}

	public String getDeliveryNo() {
		return deliveryNo;
	}

	public void setDeliveryNo(String deliveryNo) {
		this.deliveryNo = deliveryNo;
	}

	public SupplierInfoFile getSupplierInfoFile() {
		return supplierInfoFile;
	}

	public void setSupplierInfoFile(SupplierInfoFile supplierInfoFile) {
		this.supplierInfoFile = supplierInfoFile;
	}

	@Resource(name = "SupplierBasicService")
	public void setSupplierBasicService(ISupplierBasicService supplierBasicService) {
		this.supplierBasicService = supplierBasicService;
	}

	@Resource(name = "SupplierInfoService")
	public void setSupplierInfoService(ISupplierInfoService supplierInfoService) {
		this.supplierInfoService = supplierInfoService;
	}

	@Resource(name = "MaterialCategoryService")
	public void setMaterialCategoryService(IMaterialCategoryService materialCategoryService) {
		this.materialCategoryService = materialCategoryService;
	}

	@Resource(name = "SendEmailService")
	public void setSendEmailService(SendEmailService sendEmailService) {
		this.sendEmailService = sendEmailService;
	}
}
