package com.envisioncn.srm.supplier_basic.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.model.SRMException;
import com.envisioncn.srm.basic.model.constants.ErrorMessageConstants;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.basic.util.DataUtil;
import com.envisioncn.srm.basic.util.DateUtil;
import com.envisioncn.srm.basic.util.FileUtil;
import com.envisioncn.srm.supplier_basic.bean.SupplierInfo;
import com.envisioncn.srm.supplier_basic.model.SupplierInfoFile;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-19
 */
@Service("SupplierInfoService")
public class SupplierInfoService extends BasicService<SupplierInfo> implements ISupplierInfoService {
	@Resource(name = "SupplierInfoDao")
	public void setBasicDao(IBasicDao<SupplierInfo> basicDao) {
		this.basicDao = basicDao;
	}

	public SupplierInfo saveUploadFile(SupplierInfoFile files, SupplierInfo info, String path) throws SRMException {
		if (files.getSurveyTable() != null) {
			info.setSurveyTable(DateUtil.getCurrentDateFormatStringExcel());
			FileUtil.saveFile(files.getSurveyTable(), path, info.getSurveyTable());
		}
		if (files.getBusinessLicense() != null) {
			info.setBusinessLicense(DateUtil.getCurrentDateFormatStringPdf());
			FileUtil.saveFile(files.getBusinessLicense(), path, info.getBusinessLicense());
		}
		if (files.getLegalerIdentity() != null) {
			info.setLegalerIdentity(DateUtil.getCurrentDateFormatStringPdf());
			FileUtil.saveFile(files.getLegalerIdentity(), path, info.getLegalerIdentity());
		}
		if (files.getOrgCodeCertificate() != null) {
			info.setOrgCodeCertificate(DateUtil.getCurrentDateFormatStringPdf());
			FileUtil.saveFile(files.getOrgCodeCertificate(), path, info.getOrgCodeCertificate());
		}
		if (files.getTaxRegCertificate() != null) {
			info.setTaxRegCertificate(DateUtil.getCurrentDateFormatStringPdf());
			FileUtil.saveFile(files.getTaxRegCertificate(), path, info.getTaxRegCertificate());
		}
		if (files.getCreditRatingCertificate() != null) {
			info.setCreditRatingCertificate(DateUtil.getCurrentDateFormatStringPdf());
			FileUtil.saveFile(files.getCreditRatingCertificate(), path, info.getCreditRatingCertificate());
		}
		if (files.getEnvManageCertificate() != null) {
			info.setEnvManageCertificate(DateUtil.getCurrentDateFormatStringPdf());
			FileUtil.saveFile(files.getEnvManageCertificate(), path, info.getEnvManageCertificate());
		}
		if (files.getSecurityManageCertificate() != null) {
			info.setSecurityManageCertificate(DateUtil.getCurrentDateFormatStringPdf());
			FileUtil.saveFile(files.getSecurityManageCertificate(), path, info.getSecurityManageCertificate());
		}
		if (files.getQualityManageCertificate() != null) {
			info.setQualityManageCertificate(DateUtil.getCurrentDateFormatStringPdf());
			FileUtil.saveFile(files.getQualityManageCertificate(), path, info.getQualityManageCertificate());
		}
		if (files.getOtherMaterial() != null) {
			info.setOtherMaterial(DateUtil.getCurrentDateFormatStringPdf());
			FileUtil.saveFile(files.getOtherMaterial(), path, info.getOtherMaterial());
		}
		if (files.getProprietaryMaterial() != null) {
			info.setProprietaryMaterial(DateUtil.getCurrentDateFormatStringPdf());
			FileUtil.saveFile(files.getProprietaryMaterial(), path, info.getProprietaryMaterial());
		}
		if (files.getBankAccountInfo() != null) {
			info.setBankAccountInfo(DateUtil.getCurrentDateFormatStringPdf());
			FileUtil.saveFile(files.getBankAccountInfo(), path, info.getBankAccountInfo());
		}

		if (files.getSupplierDesc() != null) {
			info.setSupplierDesc(DateUtil.getCurrentDateFormatStringPdf());
			FileUtil.saveFile(files.getSupplierDesc(), path, info.getSupplierDesc());
		}
		if (files.getCapacityDesc() != null) {
			info.setCapacityDesc(DateUtil.getCurrentDateFormatStringPdf());
			FileUtil.saveFile(files.getCapacityDesc(), path, info.getCapacityDesc());
		}

		return info;
	}

	public void updateSupplierInfo(SupplierInfo info, long supplierInfoId) throws SRMException {
		try {
			SupplierInfo supplierInfo = this.getObject(supplierInfoId);
			if (DataUtil.notEmptyString(info.getBusinessLicense())) {
				supplierInfo.setBusinessLicense(info.getBusinessLicense());
			}
			if (DataUtil.notEmptyString(info.getOrgCodeCertificate())) {
				supplierInfo.setOrgCodeCertificate(info.getOrgCodeCertificate());
			}
			if (DataUtil.notEmptyString(info.getTaxRegCertificate())) {
				supplierInfo.setTaxRegCertificate(info.getTaxRegCertificate());
			}
			if (DataUtil.notEmptyString(info.getSupplierDesc())) {
				supplierInfo.setSupplierDesc(info.getSupplierDesc());
			}
			if (DataUtil.notEmptyString(info.getCapacityDesc())) {
				supplierInfo.setCapacityDesc(info.getCapacityDesc());
			}
			if (DataUtil.notEmptyString(info.getCreditRatingCertificate())) {
				supplierInfo.setCreditRatingCertificate(info.getCreditRatingCertificate());
			}
			if (DataUtil.notEmptyString(info.getEnvManageCertificate())) {
				supplierInfo.setEnvManageCertificate(info.getEnvManageCertificate());
			}
			if (DataUtil.notEmptyString(info.getQualityManageCertificate())) {
				supplierInfo.setQualityManageCertificate(info.getQualityManageCertificate());
			}
			if (DataUtil.notEmptyString(info.getSecurityManageCertificate())) {
				supplierInfo.setSecurityManageCertificate(info.getSecurityManageCertificate());
			}
			if (DataUtil.notEmptyString(info.getProprietaryMaterial())) {
				supplierInfo.setProprietaryMaterial(info.getProprietaryMaterial());
			}
			if (DataUtil.notEmptyString(info.getOtherMaterial())) {
				supplierInfo.setOtherMaterial(info.getOtherMaterial());
			}
			if (DataUtil.notEmptyString(info.getLegalerIdentity())) {
				supplierInfo.setLegalerIdentity(info.getLegalerIdentity());
			}
			if (DataUtil.notEmptyString(info.getBankAccountInfo())) {
				supplierInfo.setBankAccountInfo(info.getBankAccountInfo());
			}
			if (DataUtil.notEmptyString(info.getSurveyTable())) {
				supplierInfo.setSurveyTable(info.getSurveyTable());
			}
			if (DataUtil.notEmptyString(info.getProductionLicense())) {
				supplierInfo.setProductionLicense(info.getProductionLicense());
			}
			if (DataUtil.notEmptyString(info.getSellName())) {
				supplierInfo.setSellName(info.getSellName());
			}
			if (DataUtil.notEmptyString(info.getSellPhone())) {
				supplierInfo.setSellPhone(info.getSellPhone());
			}
			if (DataUtil.notEmptyString(info.getSellLandline())) {
				supplierInfo.setSellLandline(info.getSellLandline());
			}
			if (DataUtil.notEmptyString(info.getSellEmail())) {
				supplierInfo.setSellEmail(info.getSellEmail());
			}
			if (DataUtil.notEmptyString(info.getQualityName())) {
				supplierInfo.setQualityName(info.getQualityName());
			}
			if (DataUtil.notEmptyString(info.getQualityPhone())) {
				supplierInfo.setQualityPhone(info.getQualityPhone());
			}
			if (DataUtil.notEmptyString(info.getQualityLandLine())) {
				supplierInfo.setQualityLandLine(info.getQualityLandLine());
			}
			if (DataUtil.notEmptyString(info.getQualityEmail())) {
				supplierInfo.setQualityEmail(info.getQualityEmail());
			}
			if (DataUtil.notEmptyString(info.getLogName())) {
				supplierInfo.setLogName(info.getLogName());
			}
			if (DataUtil.notEmptyString(info.getLogPhone())) {
				supplierInfo.setLogPhone(info.getLogPhone());
			}
			if (DataUtil.notEmptyString(info.getLogLandLine())) {
				supplierInfo.setLogLandLine(info.getLogLandLine());
			}
			if (DataUtil.notEmptyString(info.getLogEmail())) {
				supplierInfo.setLogEmail(info.getLogEmail());
			}
			if (DataUtil.notEmptyString(info.getAfterSaleName())) {
				supplierInfo.setAfterSaleName(info.getAfterSaleName());
			}
			if (DataUtil.notEmptyString(info.getAfterSalePhone())) {
				supplierInfo.setAfterSalePhone(info.getAfterSalePhone());
			}
			if (DataUtil.notEmptyString(info.getAfterSaleLandLine())) {
				supplierInfo.setAfterSaleLandLine(info.getAfterSaleLandLine());
			}
			if (DataUtil.notEmptyString(info.getAfterSaleEmail())) {
				supplierInfo.setAfterSaleEmail(info.getAfterSaleEmail());
			}
			if (DataUtil.notEmptyString(info.getITName())) {
				supplierInfo.setITName(info.getITName());
			}
			if (DataUtil.notEmptyString(info.getITPhone())) {
				supplierInfo.setITPhone(info.getITPhone());
			}
			if (DataUtil.notEmptyString(info.getITLandLine())) {
				supplierInfo.setITLandLine(info.getITLandLine());
			}
			if (DataUtil.notEmptyString(info.getITEmail())) {
				supplierInfo.setITEmail(info.getITEmail());
			}
			this.modify(supplierInfo);
		} catch (Exception e) {
			throw new SRMException(ErrorMessageConstants.OBJECT_NOT_EXIST);
		}
	}

}
