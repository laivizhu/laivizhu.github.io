package com.envisioncn.srm.basic.model.constants;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-28
 */
public interface SupplierConstants {
	interface ValueConstants {
		String SUPPLIER_UPLOAD_PATH = "upload\\supplier\\";
		String SUPPLIER_FILE = "upload\\template\\supplier\\供应商基本信息调查表.xlsx";

		String DOWNLOADFILE_ACTION = "supplierBasic_downLoad.action";

		String SUPPLIER_DOWNLOAD_PATH = "/upload/supplier/";
	}

	interface InfoMessage {
		String CATEGORY_NOT_SETTING = "未归类";
		String IS_PRODUCE_MATERIAL = "是";
		String NOT_PRODUCE_MATERIAL = "不是";
		String EMAIL_CONFIRM_SUBJECT = "注册确认";
		String SUBMIT_SUCCESS = "提交成功";
		String SAVE_SUCCESS = "保存成功";
		String EMAIL_REJECT_REASON_SUBJECT = "供应商审核驳回原因";

		String businessLicense = "营业执照文件";
		String legalerIdentity = "法人身份证明文件";
		String orgCodeCertificate = "组织结构代码证文件";
		String taxRegCertificate = "税务登记证文件";
		String bankAccountInfo = "银行账户信息文件";
		String supplierDesc = "供应商商介绍文件";
		String capacityDesc = "产能说明文件";
		String creditRatingCertificate = "资信等级证书文件";
		String envManageCertificate = "环境管理认证文件";
		String qualityManageCertificate = "质量管理认证文件";
		String securityManageCertificate = "安全管理认证文件";
		String proprietaryMaterial = "专利材料文件";
		String otherMaterial = "其他补充材料文件";
		String surveyTable = "供应商信息调查表文件";
		String productionLicense = "生产许可证文件";

	}

	interface ErrorMessage {
		String BASIC_NAME_NOTNULL = "供应商名称不能为空";
		String BASIC_PHONE_NOTNULL = "供应商电话不能为空";
		String BASIC_EMAIL_NOTNULL = "供应商Email不能为空";
		String BASIC_PERSON_NOTNULL = "供应商负责人不能为空";
		String BASIC_PURCHASE_USER_NOTCHOISE = "没有选择采购用户";
		String BASIC_MATERIALCATEGORY = "必须选择物料类型";

		String NEWPASSWORDNOTSAMPLE = "新密码与确认密码不一致";
		String OLDPASSWORD_ERROR = "旧密码错误";

		String SUPPLIERINFO_RECEFILE_DATE_NOTNULL = "正本文件日期不能为空";
		String SUPPLIERINFO_DELIVERNO_NOTNULL = "供应商快递单号不能为空";

		String SUPPLIERINFO_SELLNAME_NOTNULL = "销售联系人不能为空";
		String SUPPLIERINFO_SELLPHONE_NOTNULL = "销售电话不能为空";
		String SUPPLIERINFO_SELLLANDLINE_NOTNULL = "销售座机不能为空";
		String SUPPLIERINFO_SELLEMAIL_NOTNULL = "销售Email不能为空";

		String SUPPLIERINFO_QUALITYNAME_NOTNULL = "质量联系人不能为空";
		String SUPPLIERINFO_QUALITYPHONE_NOTNULL = "质量电话不能为空";
		String SUPPLIERINFO_QUALITYLANDLINE_NOTNULL = "质量座机不能为空";
		String SUPPLIERINFO_QUALITYEMAIL_NOTNULL = "质量Email不能为空";

		String SUPPLIERINFO_ITNAME_NOTNULL = "IT技术和研发联系人不能为空";
		String SUPPLIERINFO_ITPHONE_NOTNULL = "IT技术和研发电话不能为空";
		String SUPPLIERINFO_ITLANDLINE_NOTNULL = "IT技术和研发座机不能为空";
		String SUPPLIERINFO_ITEMAIL_NOTNULL = "IT技术和研发Email不能为空";

		String SUPPLIERINFO_LOGNAME_NOTNULL = "物流联系人不能为空";
		String SUPPLIERINFO_LOGPHONE_NOTNULL = "物流电话不能为空";
		String SUPPLIERINFO_LOGLANDLINE_NOTNULL = "物流座机不能为空";
		String SUPPLIERINFO_LOGEMAIL_NOTNULL = "物流Email不能为空";

		String SUPPLIERINFO_AFTERSALENAME_NOTNULL = "售后联系人不能为空";
		String SUPPLIERINFO_AFTERSALEPHONE_NOTNULL = "售后电话不能为空";
		String SUPPLIERINFO_AFTERSALELANDLINE_NOTNULL = "售后座机不能为空";
		String SUPPLIERINFO_AFTERSALEEMAIL_NOTNULL = "售后Email不能为空";

		String REJECT_REASON_NOTNULL = "驳回原因不能为空";

		String SUPPLIERINFO_HAS_EXIST = "已经提交过供应商资料";

		String businessLicense_NOTNULL = "营业执照文件必须上传";
		String legalerIdentity_NOTNULL = "法人身份证明文件必须上传";
		String orgCodeCertificate_NOTNULL = "组织结构代码证文件必须上传";
		String taxRegCertificate_NOTNULL = "税务登记证文件必须上传";
		String bankAccountInfo_NOTNULL = "银行账户信息文件必须上传";
		String supplierDesc_NOTNULL = "供应商商介绍文件必须上传";
		String capacityDesc_NOTNULL = "产能说明文件必须上传";
		String creditRatingCertificate_NOTNULL = "资信等级证书文件必须上传";
		String envManageCertificate_NOTNULL = "环境管理认证文件必须上传";
		String qualityManageCertificate_NOTNULL = "质量管理认证文件必须上传";
		String securityManageCertificate_NOTNULL = "安全管理认证文件必须上传";
		String proprietaryMaterial_NOTNULL = "专利材料文件必须上传";
		String otherMaterial_NOTNULL = "其他补充材料文件必须上传";
		String surveyTable_NOTNULL = "供应商信息调查表文件必须上传";
		String productionLicense_NOTNULL = "生产许可证文件必须上传";
	}
}
