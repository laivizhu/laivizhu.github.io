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
			<td class="tabUnSelected" onmouseover="fnDropDown(this,'InformationCenter');" onmouseout="fnHideDrop('InformationCenter');" align="center" nowrap="nowrap">
            <a href="#">信息中心</a><img src="../images/menuDnArrow.gif" border="0" style="padding-left:5px">
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
	</tbody></table>
</div>



<%-- 供应商开发 --%>
<div class="drop_mnu" id="SupplierDevelopment" onMouseOut="fnHideDrop('SupplierDevelopment')" onMouseOver="fnShowDrop('SupplierDevelopment')">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"><tbody>
        <tr><td><a href="../development/supplier_submit.jsp" class="drop_down">供应商注册管理</a></td></tr>
		<tr><td><a href="../development/supplierPortalSecurit_checkIsStandard.action" class="drop_down">供应商保密协议管理</a></td></tr>
    </tbody></table>
</div>



<%-- 供应商日常管理 --%>
<div class="drop_mnu" id="SupplierDailyManagement" onMouseOut="fnHideDrop('SupplierDailyManagement')" onMouseOver="fnShowDrop('SupplierDailyManagement')">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"><tbody>
    	<tr><td><a href="../supplier_relation/complaintList.action" class="drop_down">供应商投诉</a></td></tr>
		<tr><td><a href="../supplier_relation/advice_list.jsp" class="drop_down">供应商合理化建议</a></td></tr>
        <tr><td><a href="../basic/report.jsp" class="drop_down">供应商改善对策报告</a></td></tr>
    </tbody></table>
</div>


<%-- 供应商关系管理 --%>
<div class="drop_mnu" id="SupplierRelationshipManagement" onMouseOut="fnHideDrop('SupplierRelationshipManagement')" onMouseOver="fnShowDrop('SupplierRelationshipManagement')">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"><tbody>
		<tr><td><a href="#" class="drop_down">供应商评价远景</a></td></tr>
        </tbody></table>
</div>



<%--  采购项目管理--%>
<div class="drop_mnu" id="ProcurementProjectManagement" onMouseOut="fnHideDrop('ProcurementProjectManagement')" onMouseOver="fnShowDrop('ProcurementProjectManagement')">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"><tbody>
		<tr><td><a href="#" class="drop_down">年度招标</a></td></tr>
		<tr><td><a href="#" class="drop_down">电子竞标</a></td></tr>
	</tbody></table>
</div>




<%--  信息中心 --%>
<div class="drop_mnu" id="InformationCenter" onMouseOut="fnHideDrop('InformationCenter')" onMouseOver="fnShowDrop('InformationCenter')">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"><tbody>
        <tr><td><a href="#" class="drop_down">外部公告</a></td></tr>
	</tbody></table>
</div>

<%-- 系目管理 --%>
<div class="drop_mnu" id="SystemManagement" onMouseOut="fnHideDrop('SystemManagement')" onMouseOver="fnShowDrop('SystemManagement')">
	<table width="100%" border="0" cellpadding="0" cellspacing="0"><tbody>
        <tr><td><a href="#" class="drop_down">工作台管理</a></td></tr>
        <tr><td><a href="../system/changepassword.jsp" class="drop_down">密码管理</a></td></tr>
	</tbody></table>
</div>

