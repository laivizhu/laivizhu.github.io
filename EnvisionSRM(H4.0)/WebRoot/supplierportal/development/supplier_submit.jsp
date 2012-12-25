<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>供应商基本信息管理</title>
  
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<link rel="stylesheet" type="text/css" href="../css/content.css"/>
<link rel="stylesheet" type="text/css" href="../css/common.css"/>
<link rel="stylesheet" type="text/css" href="../css/jquery-ui-1.9.0.custom.css"/>
<link rel="stylesheet" type="text/css" href="../css/jbox_Green/jbox.css"/>
<script language="javascript" type="text/javascript" src="../js/general.js"></script>
<script language="javascript" type="text/javascript" src="../js/jquery-1.8.2.js"></script>
<script language="javascript" type="text/javascript" src="../js/jquery-ui-1.9.0.custom.js"></script>
<script language="javascript" type="text/javascript" src="../js/jquery.form.js"></script>
<script language="javascript" type="text/javascript" src="../js/jquery.jBox-2.3.min.js"></script>
<script language="javascript" type="text/javascript" src="../js/jquery.jBox-zh-CN.js"></script>
<script language="javascript" type="text/javascript" src="../js/common.js"></script>
<script language="javascript" type="text/javascript" src="../js/basic.js"></script>
<script language="javascript" type="text/javascript" src="../js/HouqianTable.js"></script>
<script language="javascript" type="text/javascript" src="../js/HouqianTab.js"></script>
<script language="javascript" type="text/javascript" src="../js/DatePicker/WdatePicker.js"></script>
  <script language="javascript" type="text/javascript" src="../js/supplier/supplier_submit.js"></script>
<style type="text/css">
<!--

.STYLE1 {color: red; font-size: 12; }
-->
</style>
</head>

<body class="small" style="margin:0;">
<!-- 网站顶部 -->
<jsp:include page="../common/top.jsp" flush="true"/>

<!-- 网站导航 -->
<jsp:include page="../common/navigation.jsp" flush="true"/>

<!-- 二级菜单 -->
<table border="0" cellpadding="0" width="100%" class="level2Bg">
  <tbody>
    <tr>
      <td class="level2SelTab" nowrap="nowrap"><a href="supplier_submit.jsp">供应商注册管理</a> </td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplierPortalSecurit_checkIsStandard.action">供应商保密协议管理</a></td>
      <td width="100%">&nbsp;</td>
    </tr>
  </tbody>
</table>

<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
    <td style="padding-left:15px;" nowrap="nowrap"> 您现在的位置：供应商开发 &gt; 供应商注册管理 &gt; 供应商信息提交</td>
	<td width="100%" align="center" valign="middle"></td>
    <td align="right" style="padding-right:15px;">
        <jsp:include page="../common/toolbar.jsp" flush="true"/>
    </td>
</tr></tbody>
</table>

<!-- 网站中部 -->
<table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
<tbody><tr>
<td>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="small">
<tbody><tr>
  <td class="dvtTabCache" style="width:10px" >&nbsp;</td>
<td style="width:15%" align="center" class="dvtSelectedCell" id="bi" onclick="fnLoadValues('bi','mi','basicTab','moreTab','normal','Contacts')">提交供应商信息</td>
<td class="dvtTabCache" style="width:85%">&nbsp;</td>
</tr><tr>
</tr></tbody></table>
</td>
</tr>
<tr>
<td valign="top" align="left">

<div id="basicTab" style="display: block; ">

<table border="0" cellspacing="0" cellpadding="3" width="100%" class="dvtContentSpace">
<tbody><tr>
<td align="left">

<table border="0" cellspacing="0" cellpadding="0" width="100%">
<tbody><tr>
<td id="autocom"></td>
</tr>
<tr>
<td style="padding:10px">
<!-- General details -->
<form id="supplierInfoFormId" method="post" action="supplierBasic_supplierSubmit.action" enctype="multipart/form-data">
<input name="supplierInfo.id" type="hidden"  value="0"/>
<table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
<tbody>
  <tr style="height:25px">
    <td ><table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
      <tbody>
        <tr>
                                  <td colspan="10" class="detailedViewHeader"><b>供应商信息</b></td>
                                </tr>
                                <tr style="height:25px">
                                  <td width="25%" colspan="2" class="dvtCellLabel" align="right">供应商全称</td>
                                  <td width="25%" colspan="3" align="left" class="dvtCellInfo"><label id="nameFormFieldId"></label></td>
                                  <td width="25%" colspan="2" align="right" class="dvtCellLabel">采购部门申请人</td>
                                  <td width="25%" colspan="3" align="left" class="dvtCellInfo"><label id="codeFormFieldId"></label></td>
                                  
                                </tr>
                                <tr style="height:25px">
                                	<td colspan="2" class="dvtCellLabel" align="right">是否生产性物料</td>
                                 	<td colspan="3" align="left" class="dvtCellInfo"><label id="productivityMaterialFormFieldId"></label></td>
                                  <td colspan="2"class="dvtCellLabel" align="right">负责人姓名</td>
                                  <td colspan="3" align="left" class="dvtCellInfo"><label id="personNameFormFieldId"></label></td>
                                  
                                </tr>
                                <tr style="height:25px">
                                <td colspan="2" align="right" class="dvtCellLabel">负责人手机号</td>
                                  <td colspan="3" align="left" class="dvtCellInfo"><label id="phoneFormFieldId"></label></td>
                                  <td colspan="2" class="dvtCellLabel" align="right">负责人Email</td>
                                  <td colspan="3" align="left" class="dvtCellInfo"><label id="emailFormFieldId"></label></td>
                                </tr>
                                <tr style="height:25px">
                                  <td colspan="2" class="dvtCellLabel" align="right">物料分类</td>
                                  <td colspan="3" align="left" class="dvtCellInfo"><label id="classifyFormFieldId"></label></td>
                                  <td colspan="2" align="right" class="dvtCellLabel">物料类别</td>
                                  <td colspan="3" align="left" class="dvtCellInfo"><label id="categoryFormFieldId"></label></td>
                                </tr>
                                <tr style="height:25px">
                                 <td colspan="2" class="dvtCellLabel" align="right">物料子类别</td>
                                 <td colspan="8" align="left" class="dvtCellInfo"><label id="subCategoryFormFieldId"></label></td>
                                </tr>
                           </tbody></table>
                           <table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
                              <tbody>
                                 <tr>
                                  <td colspan="10" class="detailedViewHeader"><b>供应商联系人信息 </b></td>
                                 </tr>
                                <tr style="height:25px">
                                  <td width="25%" colspan="2" align="center" class="dvtCellInfo"><b>部门</b></td>
                                  <td width="19%" colspan="2" align="center" class="dvtCellInfo"><b>联系人</b></td>
                                  <td width="19%" colspan="2" align="center" class="dvtCellInfo"><b>手机</b></td>
                                  <td width="19%" colspan="2" align="center" class="dvtCellInfo"><b>座机</b></td>
                                  <td width="18%" colspan="2" align="center" class="dvtCellInfo"><b>邮件</b></td>
                                </tr>
                                
                                <tr style="height:25px">
                                  <td colspan="2" align="center" class="dvtCellLabel">销售</td>
                                  <td colspan="2" align="left" class="dvtCellInfo"><input id="sellNameFormFieldId" name="supplierInfo.sellName" type="text"  /></td> 								  
                                  <td colspan="2" align="left"class="dvtCellInfo"><input id="sellPhoneFormFieldId" name="supplierInfo.sellPhone" type="text" /></td>
                                  <td colspan="2" align="left" class="dvtCellInfo"><input id="sellLandlineFormFieldId" name="supplierInfo.sellLandline" type="text" /></td>
                                  <td colspan="2" align="left" class="dvtCellInfo"><input id="sellEmailFormFieldId" name="supplierInfo.sellEmail" type="text"  /></td>
                                </tr>
                                
                                 <tr style="height:25px">
                                  <td colspan="2" align="center" class="dvtCellLabel">质量</td>
                                  <td colspan="2" align="left" class="dvtCellInfo"><input id="qualityNameFormFieldId" name="supplierInfo.qualityName" type="text" /></td>
                                  
                                  <td colspan="2" align="left"  class="dvtCellInfo" ><input id="qualityPhoneFormFieldId" name="supplierInfo.qualityPhone" type="text"/></td>
                                  <td colspan="2" class="dvtCellInfo" align="left"><input id="qualityLandLineFormFieldId" name="supplierInfo.qualityLandLine" type="text" /></td>
                                  <td colspan="2" class="dvtCellInfo" align="left"><input id="qualityEmailFormFieldId" name="supplierInfo.qualityEmail" type="text"  /></td>
                                </tr>
                                
                                <tr style="height:25px">
                                  <td colspan="2" class="dvtCellLabel" align="center">技术/研发</td>
                                  <td colspan="2" align="left" class="dvtCellInfo"><input id="iTNameFormFieldId" name="supplierInfo.iTName" type="text" /></td>
                                  <td colspan="2" align="left" class="dvtCellInfo"><input id="iTPhoneFormFieldId" name="supplierInfo.iTPhone" type="text" /></td>
                                  <td colspan="2" align="left" class="dvtCellInfo"><input id="iTLandLineFormFieldId" name="supplierInfo.iTLandLine" type="text"  /></td>
                                  <td colspan="2" align="left" class="dvtCellInfo"><input id="iTEmailFormFieldId" name="supplierInfo.iTEmail" type="text" /></td>
                                
                                </tr>
                                <tr style="height:25px">
                                  <td colspan="2" class="dvtCellLabel" align="center">物流</td>
                                  <td colspan="2" align="left" class="dvtCellInfo"><input id="logNameFormFieldId" name="supplierInfo.logName" type="text" /></td>
                                  <td colspan="2" align="left"  class="dvtCellInfo"><input id="logPhoneFormFieldId" name="supplierInfo.logPhone" type="text" /></td>
                                  <td colspan="2" align="left" class="dvtCellInfo"><input id="logLandLineFormFieldId" name="supplierInfo.logLandLine" type="text"  /></td>
                                  <td colspan="2" align="left" class="dvtCellInfo"><input id="logEmailFormFieldId" name="supplierInfo.logEmail" type="text" /></td>
                           
                                  
                                </tr>
                                <tr style="height:25px">
                                	<td colspan="2"class="dvtCellLabel" align="center">售后</td>
                                    <td colspan="2" align="left" class="dvtCellInfo"><input id="afterSaleNameFormFieldId" name="supplierInfo.afterSaleName" type="text" /></td>
                                    <td colspan="2" align="left"  class="dvtCellInfo"><input id="afterSalePhoneFormFieldId" name="supplierInfo.afterSalePhone" type="text" /></td>
                                    <td colspan="2" align="left" class="dvtCellInfo"><input id="afterSaleLandLineFormFieldId" name="supplierInfo.afterSaleLandLine" type="text" /></td>
                                    <td colspan="2" align="left" class="dvtCellInfo"><input id="afterSaleEmailFormFieldId" name="supplierInfo.afterSaleEmail" type="text"  /></td>
                                    
                                </tr>
                                </tbody></table>
                             <table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
                              <tbody>
                                <tr>
                                  <td colspan="10" class="detailedViewHeader"><b>供应商信息调查表</b></td>
                                </tr>
                                <tr style="height:25px">
                                  <td width="15%" colspan="2"class="dvtCellLabel" align="right"><font color="red"></font>供应商信息调查表</td>
                                  <td colspan="8" align="left" class="dvtCellInfo"><input name="supplierInfoFile.surveyTable" type="file" accept="application/msexcel"/>&nbsp;<label id="surveyTableFormFieldId"></label></td>
                                </tr>
                                </tbody></table>
                              <table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
                              <tbody>
                                <tr>
                                  <td colspan="10" class="detailedViewHeader"><b>合同附件信息 </b>(注：*号表示必须填写项)</td>
                                </tr>
                                <tr style="height:25px">
                                  <td width="15%" colspan="1" align="right" class="dvtCellLabel"></td>
                                  <td width="35%" colspan="4" align="left" class="dvtCellInfo"><b>附件文件</b></td>
                                  <td width="15%" colspan="1" align="right" class="dvtCellLabel"></td>
                                  <td width="35%" colspan="4" align="left" class="dvtCellInfo" ><b>附件文件</b></td>
                                </tr>
                                <tr style="height:25px">
                                  <td colspan="1" class="dvtCellLabel" align="right">*企业法人营业执照</td>
                                  <td colspan="4" align="left" class="dvtCellInfo"><input name="supplierInfoFile.businessLicense" type="file" accept="application/pdf"/><label id="businessLicenseFormFieldId"></label></td>
                                  <td colspan="1" class="dvtCellLabel" align="right">*法人代表及经办人身份证明</td>
                                  <td colspan="4" align="left" class="dvtCellInfo"><input name="supplierInfoFile.legalerIdentity" type="file" accept="application/pdf"/><label id="legalerIdentityFormFieldId"></label></td>
                                </tr>
                                <tr style="height:25px">
                                  <td colspan="1" class="dvtCellLabel" align="right">*组织机构代码证</td>
                                  <td colspan="4" align="left" class="dvtCellInfo"><input name="supplierInfoFile.orgCodeCertificate" type="file" accept="application/pdf"/><label id="orgCodeCertificateFormFieldId"></label></td>
                                  <td colspan="1" class="dvtCellLabel" align="right">*国税地税登记证、一般纳税人资格证</td>
                                  <td colspan="4"  align="left" class="dvtCellInfo"><input name="supplierInfoFile.taxRegCertificate" type="file" accept="application/pdf"/><label id="taxRegCertificateFormFieldId"></label></td>
                                </tr>
                                <tr style="height:25px">
                                  <td colspan="1" class="dvtCellLabel" align="right"><font color="red"></font>银行帐号信息</td>
                                  <td colspan="4"  align="left" class="dvtCellInfo"><input name="supplierInfoFile.bankAccountInfo" type="file" accept="application/pdf"/><label id="bankAccountInfoFormFieldId"></label></td>
                                  <td colspan="1" class="dvtCellLabel" align="right">生产许可证</td>
                                  <td colspan="4"  align="left" class="dvtCellInfo"><input name="supplierInfoFile.productionLicense" type="file" accept="application/pdf"/><label id="productionLicenseFormFieldId"></label></td>
                                </tr>
                                <tr style="height:25px">
                                  <td colspan="1" class="dvtCellLabel" align="right"><font color="red"></font>环境管理认证证书</td>
                                  <td colspan="4"  align="left" class="dvtCellInfo"><input name="supplierInfoFile.envManageCertificate" type="file" accept="application/pdf"/><label id="envManageCertificateFormFieldId"></label></td>
                                  <td colspan="1" class="dvtCellLabel" align="right">专利证明材料</td>
                                  <td colspan="4"  align="left" class="dvtCellInfo"><input name="supplierInfoFile.proprietaryMaterial" type="file" accept="application/pdf"/><label id="proprietaryMaterialFormFieldId"></label></td>
                                </tr>
                                <tr style="height:25px">
                                  <td colspan="1"class="dvtCellLabel" align="right"><font color="red"></font>质量管理认证证书</td>
                                  <td colspan="4"  align="left" class="dvtCellInfo"><input name="supplierInfoFile.qualityManageCertificate" type="file" accept="application/pdf"/><label id="qualityManageCertificateFormFieldId"></label></td>
                                  <td colspan="1" class="dvtCellLabel" align="right">供应商介绍</td>
                                  <td colspan="4"  align="left" class="dvtCellInfo"><input name="supplierInfoFile.supplierDesc" type="file" accept="application/pdf"/><label id="supplierDescFormFieldId"></label></td>
                                </tr>
                                <tr style="height:25px">
                                  <td colspan="1" height="25" align="right" class="dvtCellLabel"><font color="red"></font>企业资信等级证书</td>
                                  <td colspan="4"  align="left" class="dvtCellInfo"><input name="supplierInfoFile.creditRatingCertificate" type="file" accept="application/pdf"/><label id="creditRatingCertificateFormFieldId"></label></td>
                                  <td colspan="1" class="dvtCellLabel" align="right">其他补充材料</td>
                                  <td colspan="4"  align="left" class="dvtCellInfo"><input name="supplierInfoFile.otherMaterial" type="file" accept="application/pdf"/><label id="otherMaterialFormFieldId"></label></td>
                                </tr>
                                <tr style="height:25px">
                                  <td colspan="1" height="25" align="right" class="dvtCellLabel"><font color="red"></font>产能说明</td>
                                  <td colspan="4"  align="left" class="dvtCellInfo"><input name="supplierInfoFile.capacityDesc" type="file" accept="application/pdf"/><label id="capacityDescFormFieldId"></label></td>
                                  <td colspan="1" height="25" align="right" class="dvtCellLabel"><font color="red"></font>安全管理认证说明</td>
                                  <td colspan="4"  align="left" class="dvtCellInfo"><input name="supplierInfoFile.securityManageCertificate" type="file" accept="application/pdf"/><label id="securityManageCertificateFormFieldId"></label></td>
                                </tr>
                                </tbody></table>
                             <table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
                              <tbody>
        <tr>
          <td height="40px;" colspan="10" style="padding:5px"><div align="center">
           <input title="提交 [Alt+C]" accesskey="C" onclick="submitSupplierInfo()" class="crmbutton small save"  type="button" value="  提交  " style="width:70px" />&nbsp;
              <input title="保存 [Alt+S]" accesskey="S" class="crmbutton small save"  type="button" onclick="saveSupplierInfo()" value="  保存  " style="width:70px" />&nbsp;
              <input title="取消[Alt+B]" accesskey="B" class="crmbutton small cancel" type="button"  value="  取消 " style="width:70px" />
          </div></td>
        </tr>
      </tbody>
    </table>
      <span id="assign_user" style="display:block"></span></td>
  </tr>
</tbody></table>
</form>
</td>
</tr>
</tbody></table>
</td>
</tr>
</tbody></table>
</div>
<!-- Basic Information Tab Closed -->


</td>
</tr>
</tbody></table>

<!-- 网站底部 -->

<jsp:include page="../common/bottom.jsp" flush="true"/>


</body>
</html>