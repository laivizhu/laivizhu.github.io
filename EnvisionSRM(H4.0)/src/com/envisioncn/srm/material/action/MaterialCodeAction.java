package com.envisioncn.srm.material.action;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.Restrictions;

import com.envisioncn.srm.basic.action.ABasicAction;
import com.envisioncn.srm.basic.model.CriterionSet;
import com.envisioncn.srm.basic.model.constants.ErrorMessageConstants;
import com.envisioncn.srm.basic.model.constants.MaterialConstants;
import com.envisioncn.srm.basic.model.json.JsonItem;
import com.envisioncn.srm.basic.model.json.JsonList;
import com.envisioncn.srm.basic.util.DateUtil;
import com.envisioncn.srm.basic.util.ParamAssert;
import com.envisioncn.srm.material.bean.MaterialCategory;
import com.envisioncn.srm.material.bean.MaterialCode;
import com.envisioncn.srm.material.bean.MaterialSupplier;
import com.envisioncn.srm.material.bean.Order;
import com.envisioncn.srm.material.bean.Price;
import com.envisioncn.srm.material.bean.Quota;
import com.envisioncn.srm.material.model.CodeSearchConditionType;
import com.envisioncn.srm.material.service.IMaterialCategoryService;
import com.envisioncn.srm.material.service.IMaterialCodeService;
import com.envisioncn.srm.material.service.IMaterialSupplierService;
import com.envisioncn.srm.material.service.IOrderService;
import com.envisioncn.srm.material.service.IPriceService;
import com.envisioncn.srm.material.service.IQuotaService;

/**
 * Copyright Envision
 * 
 * @author Janlu.Zhu
 * @version 1.0
 * @data 2012-11-14
 */
@SuppressWarnings("serial")
public class MaterialCodeAction extends ABasicAction<MaterialCode> {
	private MaterialCode materialCode;
	private long categoryValue;

	private IMaterialCodeService materialCodeService;
	private IMaterialCategoryService materialCategoryService;

	private IMaterialSupplierService materialSupplierService;
	@SuppressWarnings("unused")
	private IPriceService priceService;
	@SuppressWarnings("unused")
	private IOrderService orderService;
	private IQuotaService quotaService;

	public String search() throws Exception {
		try {
			ParamAssert.isNotEmptyString(key, ErrorMessageConstants.SEARCH_KEY_NOTEMPTY);
			ParamAssert.isNotEmptyString(value, ErrorMessageConstants.SEARCH_VALUE_NOTEMPTY);
			CriterionSet conditions = CriterionSet.CreateCriterion().put(Restrictions.eq(key, value));
			JsonList jsonList = new JsonList();
			for (MaterialCode code : materialCodeService.getList(conditions, start, limit)) {
				jsonList.add(getJsonItem(code));
			}
			return response(jsonList.toPageString(materialCodeService.getCount(conditions)));
		} catch (Exception e) {
			return response();
		}
	}

	public String deleteCodeRelation() throws Exception {
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		MaterialCode code = materialCodeService.getObject(id);
		code.setMaterialCategory(null);
		materialCodeService.modify(code);
		return response(true);
	}

	public String showCodeResult() throws Exception {
		ParamAssert.isNotEmptyString(materialCode.getCode(), MaterialConstants.ErrorMessage.MATERIAL_SAP_CODE);
		CriterionSet conditions = CriterionSet.CreateCriterion().put(Restrictions.eq("code", materialCode.getCode()));
		List<MaterialCode> codes = materialCodeService.getList(conditions);
		if (codes.size() > 0) {
			MaterialCode code = codes.get(0);
			if (code.getMaterialCategory() == null) {
				return response(true, code.getName());
			} else {
				return response(false, MaterialConstants.ErrorMessage.MATERIAL_SAPCODE_HASHSETTING);
			}
		} else {
			return response(false, MaterialConstants.ErrorMessage.SAPCODE_NOTEXIST);
		}
	}

	public String get() throws Exception {
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		return response(getJsonItem(materialCodeService.getObject(id)).toFormDataString(true));
	}

	public String getMaterialMainValue() throws Exception {
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		MaterialCode supplier = this.materialCodeService.getObject(id);
		String supplierId = supplier.getMaterialSupplierIds().split(",")[0];
		MaterialSupplier materialSupplier = this.materialSupplierService.getObject(Long.parseLong(supplierId));
		JsonItem item = new JsonItem();
		item.add("confirmControl", materialSupplier.getConfirmControl())
				.add("denoUnit", materialSupplier.getDenoUnit())
				.add("exchangeTime", materialSupplier.getExchangeTime())
				.add("materialCode", materialSupplier.getMaterialCode())
				.add("minOrderCount", materialSupplier.getMinOrderCount())
				.add("moleUnit", materialSupplier.getMoleUnit()).add("", materialSupplier.getName())
				.add("orderUnit", materialSupplier.getOrderUnit()).add("standCount", materialSupplier.getStandCount())
				.add("taxCode", materialSupplier.getTaxCode()).add("purchGroup", materialSupplier.getPurchGroup());
		return response(item.toFormDataString(true));
	}

	public String getQuatoTable() throws Exception {
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		MaterialCode supplier = this.materialCodeService.getObject(id);
		JsonList jsonList = new JsonList();
		for (String qid : supplier.getQuotaIds().split(",")) {
			Quota quota = this.quotaService.getObject(Long.parseLong(qid));
			jsonList.createItem().add("id", quota.getId())
					.add("effectDate", DateUtil.formatDate(quota.getEffectDate()))
					.add("purchType", quota.getPurchType()).add("quota", quota.getQuota())
					.add("specialPurchType", quota.getSpecialPurchType())
					.add("supplierAccount", quota.getSupplierAccount())
					.add("supplierFactory", quota.getSupplierFactory());
		}
		return response(jsonList);
	}

	public String getPriceTable() throws Exception {
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		MaterialCode supplier = this.materialCodeService.getObject(id);
		String supplierId = supplier.getMaterialSupplierIds().split(",")[0];
		MaterialSupplier materialSupplier = this.materialSupplierService.getObject(Long.parseLong(supplierId));
		JsonList jsonList = new JsonList();
		for (Price price : materialSupplier.getPrices()) {
			jsonList.createItem().add("id", price.getId()).add("countUnit", price.getCountUnit())
					.add("currency", price.getCurrency()).add("nett", price.getNett())
					.add("priceUnit", price.getPriceUnit()).add("startDate", DateUtil.formatDate(price.getStartDate()))
					.add("endDate", DateUtil.formatDate(price.getEndDate()));
		}
		return response(jsonList);
	}

	public String getOrderTable() throws Exception {
		ParamAssert.isTrue(id != 0, ErrorMessageConstants.OBJECT_NOT_EXIST);
		MaterialCode supplier = this.materialCodeService.getObject(id);
		String supplierId = supplier.getMaterialSupplierIds().split(",")[0];
		MaterialSupplier materialSupplier = this.materialSupplierService.getObject(Long.parseLong(supplierId));
		JsonList jsonList = new JsonList();
		for (Order order : materialSupplier.getOrders()) {
			jsonList.createItem().add("id", order.getId()).add("endDate", DateUtil.formatDate(order.getEndDate()))
					.add("orderUnit", order.getOrderUnit()).add("planPro", order.getPlanPro())
					.add("startDate", DateUtil.formatDate(order.getStartDate()))
					.add("purcharOrg", order.getPurcharOrg());
		}
		return response(jsonList);
	}

	public String list() throws Exception {
		JsonList jsonList = new JsonList();
		CriterionSet conditions = CriterionSet.CreateCriterion().put(Restrictions.ne("materialCategory.id", (long) 0));
		for (MaterialCode code : materialCodeService.getList(conditions, start, limit)) {
			jsonList.add(getJsonItem(code));
		}
		return response(jsonList.toPageString(materialCodeService.getCount(conditions)));
	}

	public String newList() throws Exception {
		JsonList jsonList = new JsonList();
		CriterionSet conditions = CriterionSet.CreateCriterion().put(Restrictions.ne("materialCategory.id", (long) 0));
		for (MaterialCode code : materialCodeService.getList(conditions, start, limit)) {
			jsonList.add(getJsonItem(code));
		}
		return response(jsonList.toPageString(materialCodeService.getCount(conditions)));
	}

	public String setCodeRelation() throws Exception {
		ParamAssert.isNotEmptyString(materialCode.getCode(), MaterialConstants.ErrorMessage.MATERIAL_SAP_CODE);
		ParamAssert.isTrue(categoryValue != 0, MaterialConstants.ErrorMessage.MATERIAL_CATEGORY_TYPE_NOTNULL);
		materialCodeService.setRelation(materialCode.getCode(), categoryValue);
		return response(true);
	}

	public String codeSearchConditionList() throws Exception {
		JsonList jsonList = new JsonList();
		for (CodeSearchConditionType condition : CodeSearchConditionType.values()) {
			jsonList.createItem().add("id", condition.toProperty()).add("name", condition.toText());
		}
		return response(jsonList);
	}

	public JsonItem getJsonItem(MaterialCode code) throws Exception {
		JsonItem item = new JsonItem();
		item.add("id", code.getId())
				.add("name", code.getName())
				.add("code", code.getCode())
				.add("materialSAPGroup", code.getMaterialSAPGroup())
				.add("drawNo", code.getDrawNo())
				.add("basicUnit", code.getBasicUnit())
				.add("norm", code.getNorm())
				.add("purchaseGroup", code.getPurchaseGroup())
				.add("supplierAccountNo", code.getSupplierAccountNo())
				.add("isImport",
						code.getMaterialCategory() != null ? MaterialConstants.InfoMessage.HASH_IMPORT
								: MaterialConstants.InfoMessage.NOT_IMPORT)
				.add("inDate", DateUtil.formatDate(code.getInDate()));
		if (code.getMaterialCategory() == null) {
			item.add("categoryTeam", MaterialConstants.InfoMessage.TABLE_EMPTY);
		} else {
			item.add("categoryTeam", code.getMaterialCategory().getName());
			MaterialCategory subCategory = this.materialCategoryService.getObject(code.getMaterialCategory()
					.getParentId());
			if (subCategory != null) {
				item.add("subCategory", subCategory.getName());
				MaterialCategory category = this.materialCategoryService.getObject(subCategory.getParentId());
				if (category != null) {
					item.add("category", category.getName());
					MaterialCategory classify = this.materialCategoryService.getObject(category.getParentId());
					if (classify != null) {
						item.add("classify", classify.getName());
					}

				}

			}

		}

		return item;
	}

	public MaterialCode getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(MaterialCode materialCode) {
		this.materialCode = materialCode;
	}

	@Resource(name = "MaterialCodeService")
	public void setMaterialCodeService(IMaterialCodeService materialCodeService) {
		this.materialCodeService = materialCodeService;
	}

	@Resource(name = "MaterialCategoryService")
	public void setMaterialCategoryService(IMaterialCategoryService materialCategoryService) {
		this.materialCategoryService = materialCategoryService;
	}

	public long getCategoryValue() {
		return categoryValue;
	}

	public void setCategoryValue(long categoryValue) {
		this.categoryValue = categoryValue;
	}

	@Resource(name = "MaterialSupplierService")
	public void setMaterialSupplierService(IMaterialSupplierService materialSupplierService) {
		this.materialSupplierService = materialSupplierService;
	}

	@Resource(name = "MaterialPriceService")
	public void setPriceService(IPriceService priceService) {
		this.priceService = priceService;
	}

	@Resource(name = "OrderService")
	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}

	@Resource(name = "QuotaService")
	public void setQuotaService(IQuotaService quotaService) {
		this.quotaService = quotaService;
	}
}
