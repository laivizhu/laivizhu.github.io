<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>供应商基本信息管理</title>
  
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <jsp:include page="../common/basicInclude.jsp" />
  <script language="javascript" type="text/javascript" src="../js/supplier/supplier_set_view.js"></script>
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
      <td class="level2SelTab" nowrap="nowrap"><a href="supplier_set.jsp">供应商基本信息管理</a> </td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_performance.jsp">供应商日常绩效管理</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_monthManage.jsp">供应商月度评估管理</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_monthResult.jsp">供应商月度评估结果</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_report.jsp">供应商改善对策报告</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_terrace.jsp">供应商质量管理平台</a> </td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_document.jsp">供应商质量文档中心</a></td>
      <td width="100%">&nbsp;</td>
    </tr>
  </tbody>
</table>

<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
    <td style="padding-left:15px;" nowrap="nowrap"> 您现在的位置：供应商日常管理 &gt; 供应商基本信息管理 &gt; 供应商信息审核</td>
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
<td style="width:15%" align="center" class="dvtSelectedCell" id="bi" onclick="fnLoadValues('bi','mi','basicTab','moreTab','normal','Contacts')">供应商信息审核</td>
<td class="dvtTabCache" style="width:85%">&nbsp;</td>
</tr><tr>
</tr></tbody></table></td>
</tr>
<tr>
<td valign="top" align="left"><div id="basicTab" style="display: block; ">
  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="dvtContentSpace">
    <tbody>
      <tr>
        <td align="left"><table border="0" cellspacing="0" cellpadding="0" width="100%">
          <tbody>
            <tr>
              <td id="autocom"></td>
            </tr>
            <tr>
              <td style="padding:10px"><!-- General details -->
                    <table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
                      <tbody>
                        <tr style="height:25px">
                          <td >
                          <table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
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
                                  <td colspan="2" align="center" class="dvtCellInfo"><b>部门</b></td>
                                  <td colspan="2" align="center" class="dvtCellInfo"><b>联系人</b></td>
                                  <td colspan="2" align="center" class="dvtCellInfo"><b>手机</b></td>
                                  <td colspan="2" align="center" class="dvtCellInfo"><b>座机</b></td>
                                  <td colspan="2" align="center" class="dvtCellInfo"><b>邮件</b></td>
                                </tr>
                                
                                <tr style="height:25px">
                                  <td colspan="2" align="center" class="dvtCellLabel">销售</td>
                                  <td colspan="2" align="center" class="dvtCellInfo"><label id="sellNameFormFieldId"></label></td> 								  <td colspan="2" align="center"class="dvtCellInfo"><label id="sellPhoneFormFieldId"></label></td>
                                  <td colspan="2" align="center" class="dvtCellInfo"><label id="sellLandlineFormFieldId"></label></td>
                                  <td colspan="2" align="center" class="dvtCellInfo"><label id="sellEmailFormFieldId"></label></td>
                                </tr>
                                
                                 <tr style="height:25px">
                                  <td colspan="2" align="center" class="dvtCellLabel">质量</td>
                                  <td colspan="2" align="center" class="dvtCellInfo"><label id="qualityNameFormFieldId"></label></td>
                                  
                                  <td colspan="2" align="center"  class="dvtCellInfo" ><label id="qualityPhoneFormFieldId"></label></td>
                                  <td colspan="2" class="dvtCellInfo" align="center"><label id="qualityLandLineFormFieldId"></label></td>
                                  <td colspan="2" class="dvtCellInfo" align="center"><label id="qualityEmailFormFieldId"></label></td>
                                </tr>
                                
                                <tr style="height:25px">
                                  <td colspan="2" class="dvtCellLabel" align="center">技术/研发</td>
                                  <td colspan="2" align="center" class="dvtCellInfo"><label id="iTNameFormFieldId"></label></td>
                                  <td colspan="2" align="center" class="dvtCellInfo"><label id="iTPhoneFormFieldId"></label></td>
                                  <td colspan="2" align="center" class="dvtCellInfo"><label id="iTLandLineFormFieldId"></label></td>
                                  <td colspan="2" align="center" class="dvtCellInfo"><label id="iTEmailFormFieldId"></label></td>
                                
                                </tr>
                                <tr style="height:25px">
                                  <td colspan="2" class="dvtCellLabel" align="center">物流</td>
                                  <td colspan="2" align="center" class="dvtCellInfo"><label id="logNameFormFieldId"></label></td>
                                  <td colspan="2" align="center"  class="dvtCellInfo"><label id="logPhoneFormFieldId"></label></td>
                                  <td colspan="2" align="center" class="dvtCellInfo"><label id="logLandLineFormFieldId"></label></td>
                                  <td colspan="2" align="center" class="dvtCellInfo"><label id="logEmailFormFieldId"></label></td>
                           
                                  
                                </tr>
                                <tr style="height:25px">
                                	<td colspan="2"class="dvtCellLabel" align="center">售后</td>
                                    <td colspan="2" align="center" class="dvtCellInfo"><label id="afterSaleNameFormFieldId"></label></td>
                                    <td colspan="2" align="center"  class="dvtCellInfo"><label id="afterSalePhoneFormFieldId"></label></td>
                                    <td colspan="2" align="center" class="dvtCellInfo"><label id="afterSaleLandLineFormFieldId"></label></td>
                                    <td colspan="2" align="center" class="dvtCellInfo"><label id="afterSaleEmailFormFieldId"></label></td>
                                    
                                </tr>
                                </tbody></table>
                             <table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
                              <tbody>
                                <tr>
                                  <td colspan="10" class="detailedViewHeader"><b>供应商信息调查表</b></td>
                                </tr>
                                <tr style="height:25px">
                                  <td width="25%" colspan="2"class="dvtCellLabel" align="right"><font color="red"></font>供应商信息调查表</td>
                                  <td colspan="8" align="left" class="dvtCellInfo"><label id="surveyTableFormFieldId"></label></td>
                                </tr>
                                </tbody></table>
                              <table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
                              <tbody>
                                <tr>
                                  <td colspan="10" class="detailedViewHeader"><b>合同附件信息 </b>(注：*号表示必须填写项)</td>
                                </tr>
                                <tr style="height:25px">
                                  <td width="25%" colspan="2" align="right" class="dvtCellLabel"></td>
                                  <td width="25%" colspan="3" align="left" class="dvtCellInfo"><b>附件文件</b></td>
                                  <td width="25%" colspan="2" align="right" class="dvtCellLabel"></td>
                                  <td width="25%" colspan="3" align="left" class="dvtCellInfo" ><b>附件文件</b></td>
                                </tr>
                                <tr style="height:25px">
                                  <td colspan="2" class="dvtCellLabel" align="right">*企业法人营业执照</td>
                                  <td colspan="3" align="left" class="dvtCellInfo"><label id="businessLicenseFormFieldId"></label></td>
                                  <td colspan="2" class="dvtCellLabel" align="right">*法人代表及经办人身份证明</td>
                                  <td colspan="3" align="left" class="dvtCellInfo"><label id="legalerIdentityFormFieldId"></label></td>
                                </tr>
                                <tr style="height:25px">
                                  <td colspan="2" class="dvtCellLabel" align="right">*组织机构代码证</td>
                                  <td colspan="3" align="left" class="dvtCellInfo"><label id="orgCodeCertificateFormFieldId"></label></td>
                                  <td colspan="2" class="dvtCellLabel" align="right">*国税地税登记证、一般纳税人资格证</td>
                                  <td colspan="3"  align="left" class="dvtCellInfo"><label id="taxRegCertificateFormFieldId"></label></td>
                                </tr>
                                <tr style="height:25px">
                                  <td colspan="2" class="dvtCellLabel" align="right"><font color="red"></font>银行帐号信息</td>
                                  <td colspan="3"  align="left" class="dvtCellInfo"><label id="bankAccountInfoFormFieldId"></label></td>
                                  <td colspan="2" class="dvtCellLabel" align="right">生产许可证</td>
                                  <td colspan="3"  align="left" class="dvtCellInfo"><label id="productionLicenseFormFieldId"></label></td>
                                </tr>
                                <tr style="height:25px">
                                  <td colspan="2" class="dvtCellLabel" align="right"><font color="red"></font>环境管理认证证书</td>
                                  <td colspan="3"  align="left" class="dvtCellInfo"><label id="envManageCertificateFormFieldId"></label></td>
                                  <td colspan="2" class="dvtCellLabel" align="right">专利证明材料</td>
                                  <td colspan="3"  align="left" class="dvtCellInfo"><label id="proprietaryMaterialFormFieldId"></label></td>
                                </tr>
                                <tr style="height:25px">
                                  <td colspan="2"class="dvtCellLabel" align="right"><font color="red"></font>质量管理认证证书</td>
                                  <td colspan="3"  align="left" class="dvtCellInfo"><label id="qualityManageCertificateFormFieldId"></label></td>
                                  <td colspan="2" class="dvtCellLabel" align="right">供应商介绍</td>
                                  <td colspan="3"  align="left" class="dvtCellInfo"><label id="supplierDescFormFieldId"></label></td>
                                </tr>
                                <tr style="height:25px">
                                  <td colspan="2" height="25" align="right" class="dvtCellLabel"><font color="red"></font>企业资信等级证书</td>
                                  <td colspan="3"  align="left" class="dvtCellInfo"><label id="creditRatingCertificateFormFieldId"></label></td>
                                  <td colspan="2" class="dvtCellLabel" align="right">其他补充材料</td>
                                  <td colspan="3"  align="left" class="dvtCellInfo"><label id="otherMaterialFormFieldId"></label></td>
                                </tr>
                                <tr style="height:25px">
                                  <td colspan="2" height="25" align="right" class="dvtCellLabel"><font color="red"></font>产能说明</td>
                                  <td colspan="3"  align="left" class="dvtCellInfo"><label id="capacityDescFormFieldId"></label></td>
                                  <td colspan="2" height="25" align="right" class="dvtCellLabel"><font color="red"></font>安全管理认证说明</td>
                                  <td colspan="3"  align="left" class="dvtCellInfo"><label id="securityManageCertificateFormFieldId"></label></td>
                                </tr>
                                </tbody></table>
                             <table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
                              <tbody>
                                <tr>
                                  <td colspan="10" class="detailedViewHeader"><b>正本文件确认</b></td>
                                </tr>
                                <tr style="height:25px">
                                  <td width="25%"  colspan="2" height="25" align="right" class="dvtCellLabel"><font color="red"></font>正本文件日期</td>
                                  <td width="25%"  colspan="3"  align="left" class="dvtCellInfo"><input type="text" name="receFileDate" class="Wdate" id="receFileDateId"onclick="WdatePicker()" /></td>
                                  <td width="25%"  colspan="2" class="dvtCellLabel" align="right">快递单号</td>
                                  <td width="25%"  colspan="3"  align="left" class="dvtCellInfo"><input type="text" id="deliveryNoId" name="deliveryNo"/>                                  </td>
                                </tr>
                                <tr>
                                  <td height="40px;" colspan="10" style="padding:5px"><div align="center">
                                      <input title="通过 [Alt+S]" accesskey="S" class="crmbutton small save" onclick="finallyPass()" type="button" name="button" value="  通过  " style="width:70px" />
                                    &nbsp;
                                    <input title="不通过 [Alt+X]" accesskey="X" class="crmbutton small cancel" onclick="unPass()" type="button" name="button" value="  不通过" style="width:70px" />
                                    &nbsp; <input title="返回[Alt+B]" accesskey="B" class="crmbutton small cancel" onclick="window.history.back()" type="button" name="button" value="  返回 " style="width:70px" />
                                  </div></td>
                                </tr>
                              </tbody>
                            </table>
                              <span id="assign_user" style="display:block"></span></td>
                        </tr>
                      </tbody>
                  </table></td>
            </tr>
          </tbody>
        </table></td>
      </tr>
    </tbody>
  </table>
</div>
  <!-- Basic Information Tab Closed --></td>
</tr>
</tbody></table>



<!-- 网站底部 -->

<jsp:include page="../common/bottom.jsp" flush="true"/>


</body>
</html>