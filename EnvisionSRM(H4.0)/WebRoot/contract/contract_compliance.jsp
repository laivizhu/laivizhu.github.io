<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<title>合同操作-采购平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<script language="javascript" type="text/javascript" src="../js/general.js"></script>
<script language="javascript">
function DispContent( i , count)
{
var m=i;
var test = document.getElementById('test'+i);	
var div = document.getElementById( 'div' + i );

for(var n=1;n<6;n++){
   if(m==n){
     if( div.style.display == "none" )
    {
     div.style.display = '';
    }
	if(test.className == "dvtUnSelectedCell")
	{
	  test.className="dvtSelectedCell";
	}
   }else{
     var test_1= document.getElementById('test'+n);
     var div_1 = document.getElementById( 'div' + n );
     if( div_1.style.display == "none" ){div_1.style.display ="none";}
     else div_1.style.display ="none";
     if(test_1.className == "dvtUnSelectedCell"){test_1.className = "dvtUnSelectedCell";}
     else test_1.className = "dvtUnSelectedCell";
   }
}
}
function confirmsubmit(){
   var resualt=false;
for(var i=0;i<document.contractConfirm.selectedid_confirm.length;i++)
{
    if(document.contractConfirm.selectedid_confirm[i].checked)
    {
      resualt=true;
    }
}
if(!resualt)
{
   alert("请选择一份合同提交审批！");
}else{
   alert("提交成功！");
   window.location="frame_contract.jsp";
}
}

function approval(){
   var resualt=false;
for(var i=0;i<document.contractApproval.selectedid_approval.length;i++)
{
    if(document.contractApproval.selectedid_approval[i].checked)
    {
      resualt=true;
    }
}
if(!resualt)
{
   alert("请选择合同！");
}else{
   alert("审批通过！");
 //  window.location="frame_contract.jsp";
}
}

function disapproval(){
    var resualt=false;
for(var i=0;i<document.contractApproval.selectedid_approval.length;i++)
{
    if(document.contractApproval.selectedid_approval[i].checked)
    {
      resualt=true;
    }
}
if(!resualt)
{
   alert("请选择合同！");
}else{
   var	sUrl = "approval_failed_reason.jsp";
	var sFeatures = "height=200, width=400, top=100, left=200, toolbar=no, menubar=no, scrollbars=no,resizable=no,location=no, status=no";
	var rtnValue = window.open(sUrl,"",sFeatures);
}
}

function scanCopyUpload(){
var resualt=false;
for(var i=0;i<document.scancopyUpload.selectedid_scancopy.length;i++)
{
    if(document.scancopyUpload.selectedid_scancopy[i].checked)
    {
      resualt=true;
    }
}
if(!resualt)
{
   alert("请选择合同！");
}else{
   window.location="scancopy_upload.jsp";
}
}

function contract_modification(){
var resualt=false;
for(var i=0;i<document.contractModification.selectedid_modification.length;i++)
{
    if(document.contractModification.selectedid_modification[i].checked)
    {
      resualt=true;
    }
}
if(!resualt)
{
   alert("请选择合同！");
}else{
   window.location="contract_modification.jsp";
}
}

function contract_Cancel(){
   var resualt=false;
for(var i=0;i<document.contractCancel.selectedid_cancel1.length;i++)
{
    if(document.contractCancel.selectedid_cancel1[i].checked)
    {
      var reason=document.contractCancel.contractCancelReason[i].value;
       if(reason==""){
        alert("请选择合同取消原因！");
      }else{
        alert("合同取消成功！");
      }
      resualt=true;
    }
}
if(!resualt)
{
   alert("请选择合同！");
}
}
</script>
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
    <s:if test="#session.user.id==1001">	
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_maincontractlist.jsp">年度合同模板</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="frame_contract.jsp">框架合同</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_modify.jsp">合同变更</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_cancel.jsp">合同取消</a></td>
      <td class="level2SelTab" nowrap="nowrap"><a href="contract_compliance.jsp">合同合规</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_query.jsp">历史查询</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_setting.jsp">参数设置</a></td>
    </s:if>
	<s:elseif test="#session.user.id==1002">
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_approval.jsp">合同审批</a></td>
      <td class="level2SelTab" nowrap="nowrap"><a href="contract_compliance.jsp">合同合规</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_query.jsp">历史查询</a></td>
    </s:elseif>
      <td width="100%">&nbsp;</td>
    </tr>
  </tbody>
</table>

<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
  <tbody>
    <tr>
      <td style="padding-left:15px;" nowrap="nowrap">您现在的位置： 合同管理 &gt; 合同合规 </td>
      <td width="100%" align="center" valign="middle"></td>
      <td align="right" style="padding-right:10px;">&nbsp;</td>
      <td align="right" style="padding-right:20px;"><jsp:include page="../common/toolbar.jsp" flush="true"/></td>
    </tr>
  </tbody>
</table>

<!-- 工作台 -->

<table width="100%" class="showPanelBg" cellpadding="0" cellspacing="0" border="0" align="center" >
  <tbody>
    <tr>
      <td width="100%" align="left" valign="top"><!-- 内容开始 -->
        
        <div class="contentListDiv">
          <table align="center" border="0" cellpadding="0" cellspacing="0" width="100%">
            <tbody>
              <tr>
                <td><table class="small" border="0" cellpadding="3" cellspacing="0" width="100%">
                    <tbody>
                      <tr>
                        <td class="dvtTabCache" style="width: 10px;" nowrap="nowrap">&nbsp;</td>
                        <td id="test1" class="dvtSelectedCell" align="center" nowrap="nowrap" onClick="DispContent(1,5);">时间与价格合规性</td>
                        <td class="dvtTabCache" style="width: 10px;" nowrap="nowrap">&nbsp;</td>
                        <td id="test2" class="dvtUnSelectedCell" align="center" nowrap="nowrap" onClick="DispContent(2,5);">数量与价格合规性</td>
                        <td class="dvtTabCache" style="width: 100%;">&nbsp;</td>
                      </tr>
                    </tbody>
                  </table></td>
              </tr>
              <tr>
                <td align="left" valign="top"><table class="dvtContentSpace" border="0" cellpadding="3" cellspacing="0" width="100%">
                    <tbody>
                      <tr>
                        <td align="left"><!-- content cache -->
                          
                          <table border="0" cellpadding="0" cellspacing="0" width="100%">
                            <tbody>
                              <tr>
                                <td style="padding: 10px;">
                                  <jsp:include page="compliance_timediv.jsp" flush="true"/>
                                  <jsp:include page="compliance_numberdiv.jsp" flush="true"/>
                                </td>
                              </tr>
                            </tbody>
                          </table></td>
                      </tr>
                    </tbody>
                  </table></td>
              </tr>
            </tbody>
          </table>
        </div></td>
    </tr>
  </tbody>
</table>

<!-- 网站底部 -->
<jsp:include page="../common/bottom.jsp" flush="true"/>
</body>
</html>
