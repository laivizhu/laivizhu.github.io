package com.envisioncn.srm.supplier_basic.service;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.envisioncn.srm.basic.dao.IBasicDao;
import com.envisioncn.srm.basic.model.SRMException;
import com.envisioncn.srm.basic.model.constants.AppConstants;
import com.envisioncn.srm.basic.model.constants.ErrorMessageConstants;
import com.envisioncn.srm.basic.service.BasicService;
import com.envisioncn.srm.basic.util.DataUtil;
import com.envisioncn.srm.basic.util.ExcelUtil;
import com.envisioncn.srm.supplier_basic.bean.SupplierConsumer;
import com.envisioncn.srm.supplier_basic.bean.SupplierDevice;
import com.envisioncn.srm.supplier_basic.bean.SupplierProduces;
import com.envisioncn.srm.supplier_basic.bean.SupplierRFI;
import com.envisioncn.srm.supplier_basic.dao.ISupplierConsumerDao;
import com.envisioncn.srm.supplier_basic.dao.ISupplierDeviceDao;
import com.envisioncn.srm.supplier_basic.dao.ISupplierProducesDao;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @date 2012-11-30
 */
public class SupplierRFIService extends BasicService<SupplierRFI> implements ISupplierRFIService {
	private ISupplierDeviceDao supplierDeviceDao;
	private ISupplierConsumerDao supplierConsumerDao;
	private ISupplierProducesDao supplierProducesDao;

	@Resource(name = "SupplierDeviceDao")
	public void setSupplierDeviceDao(ISupplierDeviceDao supplierDeviceDao) {
		this.supplierDeviceDao = supplierDeviceDao;
	}

	@Resource(name = "SupplierConsumerDao")
	public void setSupplierConsumerDao(ISupplierConsumerDao supplierConsumerDao) {
		this.supplierConsumerDao = supplierConsumerDao;
	}

	@Resource(name = "SupplierProducesDao")
	public void setSupplierProducesDao(ISupplierProducesDao supplierProducesDao) {
		this.supplierProducesDao = supplierProducesDao;
	}

	@Resource(name = "SupplierRFIDao")
	public void setBasicDao(IBasicDao<SupplierRFI> basicDao) {
		this.basicDao = basicDao;
	}

	public SupplierRFI extractSupplierInfoFromExcel(File excelFile) throws SRMException {
		SupplierRFI info = new SupplierRFI();
		try {
			Workbook book = ExcelUtil.getWorkbook(excelFile);
			Sheet sheet = book.getSheetAt(0);
			getSupplierRFIBasic(info, sheet);
			getSupplierProduces(info, sheet);
			getSupplierConsumer(info, sheet);
			getSupplierDevices(info, sheet);
		} catch (IOException e) {
			throw new SRMException(ErrorMessageConstants.Common.FILE_NOT_FOUND);
		}
		return info;
	}

	private void getSupplierRFIBasic(SupplierRFI info, Sheet sheet) {
		info.setCompanyName(ExcelUtil.getExcelContent(sheet, 4, 'C'));
		info.setCompanyCategory(ExcelUtil.getExcelContent(sheet, 4, 'O'));
		info.setCreateDate(ExcelUtil.getExcelContent(sheet, 5, 'C'));
		info.setRegCapital(ExcelUtil.getExcelContent(sheet, 5, 'O'));
		info.setShareholder(ExcelUtil.getExcelContent(sheet, 6, 'C'));
		info.setAddress(ExcelUtil.getExcelContent(sheet, 7, 'C'));
		info.setState(ExcelUtil.getExcelContent(sheet, 7, 'O'));
		info.setCity(ExcelUtil.getExcelContent(sheet, 7, 'S'));
		info.setSubCompanyAddress(ExcelUtil.getExcelContent(sheet, 8, 'C'));
		info.setPerson(ExcelUtil.getExcelContent(sheet, 9, 'C'));
		info.setEmail(ExcelUtil.getExcelContent(sheet, 9, 'I'));
		info.setTelPhone(ExcelUtil.getExcelContent(sheet, 9, 'O'));
		info.setFax(ExcelUtil.getExcelContent(sheet, 9, 'S'));
		info.setPersonTotal(ExcelUtil.getExcelContent(sheet, 10, 'C'));
		info.setManageTotal(ExcelUtil.getExcelContent(sheet, 10, 'I'));
		info.setEngineerTotal(ExcelUtil.getExcelContent(sheet, 10, 'O'));
		info.setTecholTotal(ExcelUtil.getExcelContent(sheet, 10, 'S'));
		info.setBeforeLastYearSale(ExcelUtil.getExcelContent(sheet, 11, 'C'));
		info.setLastYearSale(ExcelUtil.getExcelContent(sheet, 11, 'I'));
		info.setTodayYearSale(ExcelUtil.getExcelContent(sheet, 11, 'O'));
		info.setCurrentCap(ExcelUtil.getExcelContent(sheet, 12, 'C'));
		info.setExpandPlan(ExcelUtil.getExcelContent(sheet, 12, 'O'));
	}

	private void getSupplierProduces(SupplierRFI info, Sheet sheet) {
		for (int row = 15; row < 23; row++) {
			if (DataUtil.notEmptyString(ExcelUtil.getExcelContent(sheet, row, 'B'))) {
				SupplierProduces produces = new SupplierProduces();
				produces.setName(ExcelUtil.getExcelContent(sheet, row, 'B'));
				produces.setHoldRate(ExcelUtil.getExcelContent(sheet, row, 'C'));
				produces.setPatent(ExcelUtil.getExcelContent(sheet, row, 'J'));
				produces.setProfessionCertify(ExcelUtil.getExcelContent(sheet, row, 'O'));
				if (row == 15) {
					info.setProducesIds(supplierProducesDao.add(produces) + AppConstants.EMPTY);
				} else {
					info.setProducesIds(info.getProducesIds() + "," + supplierProducesDao.add(produces));
				}
			}
		}
	}

	private void getSupplierConsumer(SupplierRFI info, Sheet sheet) {
		for (int row = 25; row < 33; row++) {
			if (DataUtil.notEmptyString(ExcelUtil.getExcelContent(sheet, row, 'B'))) {
				SupplierConsumer consumer = new SupplierConsumer();
				consumer.setName(ExcelUtil.getExcelContent(sheet, row, 'B'));
				consumer.setMainConsumer(ExcelUtil.getExcelContent(sheet, row, 'C'));
				consumer.setSales(ExcelUtil.getExcelContent(sheet, row, 'J'));
				consumer.setRate(ExcelUtil.getExcelContent(sheet, row, 'O'));
				if (row == 25) {
					info.setConsumerIds(supplierConsumerDao.add(consumer) + AppConstants.EMPTY);
				} else {
					info.setConsumerIds(info.getConsumerIds() + "," + supplierConsumerDao.add(consumer));
				}
			}
		}
	}

	private void getSupplierDevices(SupplierRFI info, Sheet sheet) {
		for (int row = 35; row < 43; row++) {
			if (DataUtil.notEmptyString(ExcelUtil.getExcelContent(sheet, row, 'B'))) {
				SupplierDevice device = new SupplierDevice();
				device.setName(ExcelUtil.getExcelContent(sheet, row, 'B'));
				device.setBrand(ExcelUtil.getExcelContent(sheet, row, 'C'));
				device.setFormat(ExcelUtil.getExcelContent(sheet, row, 'H'));
				device.setYield(ExcelUtil.getExcelContent(sheet, row, 'N'));
				device.setUsedYear(ExcelUtil.getExcelContent(sheet, row, 'Q'));
				device.setCount(ExcelUtil.getExcelContent(sheet, row, 'S'));
				device.setProduceDevice(true);
				if (row == 35) {
					info.setProduceDeviceIds(supplierDeviceDao.add(device) + AppConstants.EMPTY);
				} else {
					info.setProduceDeviceIds(info.getProduceDeviceIds() + "," + supplierDeviceDao.add(device));
				}
			}
		}

		for (int row = 45; row < 53; row++) {
			if (DataUtil.notEmptyString(ExcelUtil.getExcelContent(sheet, row, 'B'))) {
				SupplierDevice device = new SupplierDevice();
				device.setName(ExcelUtil.getExcelContent(sheet, row, 'B'));
				device.setBrand(ExcelUtil.getExcelContent(sheet, row, 'C'));
				device.setFormat(ExcelUtil.getExcelContent(sheet, row, 'H'));
				device.setYield(ExcelUtil.getExcelContent(sheet, row, 'N'));
				device.setUsedYear(ExcelUtil.getExcelContent(sheet, row, 'Q'));
				device.setCount(ExcelUtil.getExcelContent(sheet, row, 'S'));
				device.setProduceDevice(false);
				if (row == 45) {
					info.setDetectDeviceIds(supplierDeviceDao.add(device) + AppConstants.EMPTY);
				} else {
					info.setDetectDeviceIds(info.getDetectDeviceIds() + "," + supplierDeviceDao.add(device));
				}
			}
		}
	}
}
