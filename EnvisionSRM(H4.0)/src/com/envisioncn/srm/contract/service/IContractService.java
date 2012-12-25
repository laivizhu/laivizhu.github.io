/**
 * 
 */
package com.envisioncn.srm.contract.service;


import java.io.File;

import com.envisioncn.srm.basic.model.json.JsonItem;
import com.envisioncn.srm.basic.service.IBasicService;
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
import com.google.gson.JsonObject;

/**
 * Copyright Envision
 *
 * @author mingsongliao
 * @version
 * @data 2012-11-15
 */
public interface IContractService extends IBasicService<ContractBean> {
	
	JsonItem getStatusItem(ContractBean contract,JsonItem item);
	
	JsonObject getStatusItem1(ContractBean contract,JsonObject item);
	
	void addContract(File[] ehs,String[] ehsFileName,File[] logistic,String[] logisticFileName,
			File[] supervision,String[] supervisionFileName,File[] technology,String[] technologyFileName,
			File[] purchaseInstruction,String[] purchaseInstructionFileName,File[] quanlity,String[] quanlityFileName,
			File price,String priceFileName,File secrecy,String secrecyFileName,ContractBean contractBean,
			long diviationHead,DiviationHeadBean dhb,SecrecyBean sb,PriceBean pb,QuanlityBean qb,
			PurchaseInstructionBean pib,TechnologyBean tb,SupervisionBean svb,LogisticBean lb,EhsBean eb,AttachmentBean ab,String path)throws Exception;
	
}
