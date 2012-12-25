<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<script language="javascript" type="text/javascript" src="../js/general.js"></script>

<table border="0" cellspacing="0" cellpadding="0" width="100%" class="hdrTabBg">
<tbody>
  <tr>
	<td style="width:10px; height:30px;" class="small">&nbsp;</td>
    
	<td class="small" nowrap="nowrap"> 
	  <table border="0" cellspacing="0" cellpadding="0">
		<tbody><tr>
			
            <td class="tabSeperator"><img src="../images/spacer.gif"></td>
            	
			<td class="tabUnSelected" onmouseover="fnDropDown(this,'workbench');" onmouseout="fnHideDrop('workbench');" align="center" nowrap="nowrap">
            <a href="../workbench/index.jsp">工作台</a><img src="../images/menuDnArrow.gif" border="0" style="padding-left:5px">
            </td>

            <td class="tabSeperator"><img src="../images/spacer.gif"></td>
			<td class="tabUnSelected" onmouseover="fnDropDown(this,'MaterialManagement');" onmouseout="fnHideDrop('MaterialManagement');" align="center" nowrap="nowrap">
            <a href="#">物料及类别管理</a><img src="../images/menuDnArrow.gif" border="0" style="padding-left:5px">
            </td>
            
            <td class="tabSeperator"><img src="../images/spacer.gif"></td>
			<td class="tabUnSelected" onmouseover="fnDropDown(this,'SupplierDevelopment');" onmouseout="fnHideDrop('SupplierDevelopment');" align="center" nowrap="nowrap">
            <a href="#">供应商开发</a><img src="../images/menuDnArrow.gif" border="0" style="padding-left:5px">
            </td>
            		
			<td class="tabSeperator"><img src="../images/spacer.gif"></td>
			<td class="tabUnSelected" onmouseover="fnDropDown(this,'SupplierDailyManagement');" onmouseout="fnHideDrop('SupplierDailyManagement');" align="center" nowrap="nowrap">
            <a href="#">供应商日常管理</a><img src="../images/menuDnArrow.gif" border="0" style="padding-left:5px">
            </td>
            		  
			<td class="tabSeperator"><img src="../images/spacer.gif"></td>
			<td class="tabUnSelected" onmouseover="fnDropDown(this,'SupplierRelationshipManagement');" onmouseout="fnHideDrop('SupplierRelationshipManagement');" align="center" nowrap="nowrap">
            <a href="#">供应商关系管理</a><img src="../images/menuDnArrow.gif" border="0" style="padding-left:5px">
            </td>
			
            <td class="tabSeperator"><img src="../images/spacer.gif"></td>
			<td class="tabUnSelected" onmouseover="fnDropDown(this,'ProcurementProjectManagement');" onmouseout="fnHideDrop('ProcurementProjectManagement');" align="center" nowrap="nowrap">
            <a href="#">采购项目管理</a><img src="../images/menuDnArrow.gif" border="0" style="padding-left:5px">
            </td>

			
            <td class="tabSeperator"><img src="../images/spacer.gif"></td>
			<td class="tabUnSelected" onmouseover="fnDropDown(this,'ContractManagement');" onmouseout="fnHideDrop('ContractManagement');" align="center" nowrap="nowrap">
            <a href="#">合同管理</a><img src="../images/menuDnArrow.gif" border="0" style="padding-left:5px">
            </td>

			<td class="tabSeperator"><img src="../images/spacer.gif"></td>
			<td class="tabUnSelected" onmouseover="fnDropDown(this,'InformationCenter');" onmouseout="fnHideDrop('InformationCenter');" align="center" nowrap="nowrap">
            <a href="#">信息中心</a><img src="../images/menuDnArrow.gif" border="0" style="padding-left:5px">
            </td>
            
			<td class="tabSeperator"><img src="../images/spacer.gif"></td>
			<td class="tabUnSelected" onmouseover="fnDropDown(this,'ReportCenter');" onmouseout="fnHideDrop('ReportCenter');" align="center" nowrap="nowrap">
			<a href="#">报表中心</a><img src="../images/menuDnArrow.gif" border="0" style="padding-left:5px">
            </td>
		                    
          
           	<td class="tabSeperator"><img src="../images/spacer.gif"></td>
			<td class="tabUnSelected" onmouseover="fnDropDown(this,'SystemManagement');" onmouseout="fnHideDrop('SystemManagement');" align="center" nowrap="nowrap">
            <a href="#">系统管理</a><img src="../images/menuDnArrow.gif" border="0" style="padding-left:5px">
            </td>

		</tr>
		</tbody>
        </table>
	</td>
    
	
</tr>
</tbody>
</table>

<%-- 导航栏首页菜单 子菜单  --%>
<div class="drop_mnu" id="workbench" onMouseOut="fnHideDrop('workbench')" onMouseOver="fnShowDrop('workbench')">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"><tbody>
      <tr><td><a href="../workbench/index.jsp" class="drop_down">首页</a></td></tr>
      <tr><td><a href="../workbench/schedule.jsp" class="drop_down">日程提醒</a></td></tr>
	</tbody></table>
</div>

<%-- 物料管理 --%>
<div class="drop_mnu" id="MaterialManagement" onMouseOut="fnHideDrop('MaterialManagement')" onMouseOver="fnShowDrop('MaterialManagement')">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"><tbody>
    	<tr><td><a href="../material/category.jsp" class="drop_down">物料类别设置</a></td></tr>
    	<tr><td><a href="../material/material_main.jsp" class="drop_down">物料主数据查询</a></td></tr>
    	<tr><td><a href="../material/expenditure.jsp" class="drop_down">物料支出分析</a></td></tr>
        <tr><td><a href="../material/sourcing.jsp" class="drop_down">类别管理七步法</a></td></tr>
	</tbody></table>
</div>


<%-- 供应商开发 --%>
<div class="drop_mnu" id="SupplierDevelopment" onMouseOut="fnHideDrop('SupplierDevelopment')" onMouseOver="fnShowDrop('SupplierDevelopment')">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"><tbody>
    	<tr><td><a href="../supplier_development/supplier_set.jsp" class="drop_down">供应商注册管理</a></td></tr>
        <tr><td><a href="../supplier_development/supplier_sourceProject.jsp" class="drop_down">供应商寻源项目管理</a></td></tr>
		<tr><td><a href="../supplier_development/supplier_develop.jsp" class="drop_down">寻源进度报告</a></td></tr>
		<tr><td><a href="../supplier_development/supplier_securit.jsp" class="drop_down">供应商保密协议管理</a></td></tr>
	</tbody></table>
</div>


<%-- 供应商日常管理 --%>
<div class="drop_mnu" id="SupplierDailyManagement" onMouseOut="fnHideDrop('SupplierDailyManagement')" onMouseOver="fnShowDrop('SupplierDailyManagement')">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"><tbody>
        
        <tr><td><a href="../supplier_basic/supplier_performance.jsp" class="drop_down">供应商日常绩效管理</a></td></tr>
        <tr><td><a href="../supplier_basic/supplier_monthManage.jsp" class="drop_down">供应商月度绩效评价</a></td></tr>
    	<tr><td><a href="../supplier_basic/complaintList.action" class="drop_down">供应商投诉</a></td></tr>
		<tr><td><a href="../supplier_basic/advice_list.jsp" class="drop_down">供应商合理化建议</a></td></tr>
        <tr><td><a href="../supplier_basic/supplier_report.jsp" class="drop_down">供应商改善对策报告</a></td></tr>
		<tr><td><a href="../supplier_basic/supplier_terrace.jsp" class="drop_down">供应商质量管理平台</a></td></tr>
        <tr><td><a href="../supplier_basic/supplier_document.jsp" class="drop_down">供应商质量文档中心</a></td></tr>
       <!--  <tr><td><a href="../supplier_basic/supplier_claimant_add.jsp" class="drop_down">供应商索赔信息录入</a></td></tr>
        <tr><td><a href="../supplier_basic/supplier_coordination_add.jsp" class="drop_down">供应商协同信息录入</a></td></tr>-->
    </tbody></table>
</div>


<%-- 供应商关系管理 --%>
<div class="drop_mnu" id="SupplierRelationshipManagement" onMouseOut="fnHideDrop('SupplierRelationshipManagement')" onMouseOver="fnShowDrop('SupplierRelationshipManagement')">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"><tbody>
		<tr><td><a href="../supplier_relation/supplier_importance.jsp" class="drop_down">物料重要性分析</a></td></tr>
		<tr><td><a href="../supplier_relation/supplier_attraction.jsp" class="drop_down">相对吸引力分析</a></td></tr>
		<tr><td><a href="../supplier_relation/supplier_subdivide.jsp" class="drop_down">供应商关系细分分析</a></td></tr>
		<tr><td><a href="../supplier_relation/supplier_annual.jsp" class="drop_down">供应商年度评价</a></td></tr>
		<tr><td><a href="../supplier_relation/supplier_distinguish.jsp" class="drop_down">供应商区分及策略</a></td></tr>
		<tr><td><a href="../supplier_relation/supplier_information.jsp" class="drop_down">供应商信息维护</a></td></tr>
        </tbody></table>
</div>



<%--  采购项目管理--%>
<div class="drop_mnu" id="ProcurementProjectManagement" onMouseOut="fnHideDrop('ProcurementProjectManagement')" onMouseOver="fnShowDrop('ProcurementProjectManagement')">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"><tbody>
		<tr><td><a href="../procurement/bid_frame.jsp" class="drop_down">年度招标</a></td></tr>
		<tr><td><a href="../procurement/auction_frame.jsp" class="drop_down">电子竞标</a></td></tr>
        <tr><td><a href="../procurement/strategy_material.jsp" class="drop_down">物料类别策略执行</a></td></tr>
        <tr><td><a href="../procurement/strategy_supplier.jsp" class="drop_down">供应商管理策略执行</a></td></tr>
	</tbody></table>
</div>


<%-- 合同管理 --%>
<div class="drop_mnu" id="ContractManagement" onMouseOut="fnHideDrop('ContractManagement')" onMouseOver="fnShowDrop('ContractManagement')">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"><tbody>
     <s:if test="#session.user.id==1001">	
    	<tr><td><a href="../contract/contract_maincontractlist.jsp" class="drop_down">年度合同</a></td></tr>
    	<tr><td><a href="../contract/frame_contract.jsp" class="drop_down">框架合同</a></td></tr>
    	<tr><td><a href="../contract/contract_modify.jsp" class="drop_down">合同变更</a></td></tr>
	    <tr><td><a href="../contract/contract_cancel.jsp" class="drop_down">合同取消</a></td></tr>
	    <tr><td><a href="../contract/contract_compliance.jsp" class="drop_down">合同合规</a></td></tr>
	    <tr><td><a href="../contract/contract_query.jsp" class="drop_down">历史查询</a></td></tr>
	    <tr><td><a href="../contract/contract_setting.jsp" class="drop_down">参数设置</a></td></tr>
	</s:if>
	<s:elseif test="#session.user.id==1002">
	    <tr><td><a href="../contract/contract_approval.jsp" class="drop_down">合同审批</a></td></tr>
	    <tr><td><a href="../contract/contract_compliance.jsp" class="drop_down">合同合规</a></td></tr>
	    <tr><td><a href="../contract/contract_query.jsp" class="drop_down">历史查询</a></td></tr>
	</s:elseif>
	</tbody></table>
</div>

<%--  信息中心 --%>
<div class="drop_mnu" id="InformationCenter" onMouseOut="fnHideDrop('InformationCenter')" onMouseOver="fnShowDrop('InformationCenter')">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"><tbody>
    	<tr><td><a href="../infocenter/notice_inner_list.jsp" class="drop_down">内部公告</a></td></tr>
        <tr><td><a href="../infocenter/notice_outer_list.jsp" class="drop_down">外部公告</a></td></tr>
	</tbody></table>
</div>


<%-- 报表中心 --%>
<div class="drop_mnu" id="ReportCenter" onMouseOut="fnHideDrop('ReportCenter')" onMouseOver="fnShowDrop('ReportCenter')">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"><tbody>
    	<tr><td><a href="#" class="drop_down">分析报表</a></td></tr>
		<tr><td><a href="#" class="drop_down">KPI报告</a></td></tr>
	</tbody></table>
</div>

<%-- 系统目管理 --%>
<div class="drop_mnu" id="SystemManagement" onMouseOut="fnHideDrop('SystemManagement')" onMouseOver="fnShowDrop('SystemManagement')">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"><tbody>
    	<tr><td><a href="#" class="drop_down">用户查询</a></td></tr>
		<tr><td><a href="#" class="drop_down">人员管理</a></td></tr>
        <tr><td><a href="#" class="drop_down">角色管理</a></td></tr>
        <tr><td><a href="#" class="drop_down">权限管理</a></td></tr>
        <tr><td><a href="#" class="drop_down">工作台管理</a></td></tr>
        <tr><td><a href="../system/template.jsp" class="drop_down">模板管理</a></td></tr>
        <tr><td><a href="#" class="drop_down">数据同步</a></td></tr>
	</tbody></table>
</div>