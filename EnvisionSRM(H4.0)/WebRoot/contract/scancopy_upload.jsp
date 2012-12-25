<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>合同管理-采购平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="../common/basicInclude.jsp" />
<script language="javascript">
$(document).ready(function(e) {
	var contractId = $("#contractId");
	var id = window.location.href.split("=")[1];
	$.getJSON("frameContract_getContract.action?id=" + id+"&time="+Math.random(),function(returnData){
		    $("#contractId0").val(returnData.contractId);
		    $("#contractId").html(returnData.contractId);
		    $("#supplierName").html(returnData.supplierName);
			$("#purchaser").html(returnData.purchaseName);
			$("#status").html(returnData.status);
			});
			
	/*		houQian.submitForm($("#scanCopyForm"), "frameContract_addScan.action", function(data){
					houQian.alert(data.msg);
					window.location.href = "frame_contract.jsp#2";
			});*/
			$("#submitBtn1").click(function(){
			var form = $("#scanCopyForm");
			form.ajaxForm({
				url:"frameContract_addScan.action",
				beforeSubmit:validate,
				//dataType:"json",
				success:function(returnData){
					alert(returnData.msg);
					window.location.href = "frame_contract.jsp#2";
				}
			});
		});
    });

function validate(formData, jqForm, options)
{
	var yearContract=$("#yearContract").val();
	var diviation=$("#diviation").val();
	var price=$("#price").val();
	if(yearContract==""){
			alert("年度合同扫描件不能为空！");
			return false;
	}
	if(diviation==""){
			alert("偏差协议扫描件不能为空！");
			return false;
	}
	if(price==""){
			alert("价格协议不能为空！");
			return false;
	}
}
</script>

</head>

<body class="small" leftmargin="0" topmargin="0" marginheight="0" marginwidth="0"  rightmargin="0" bottommargin="0">
<!-- 网站顶部 -->
<jsp:include page="../common/top.jsp" flush="true"/>

<!-- 网站导航 -->
<jsp:include page="../common/navigation.jsp" flush="true"/>

<!-- 二级菜单 -->
<table border="0" cellpadding="0" width="100%" class="level2Bg">
  <tbody>
    <tr>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="yearcontractList.action">年度合同</a></td>
      <td class="level2SelTab" nowrap="nowrap"><a href="frame_contract.jsp">框架合同</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contractCompliance.jsp">合同合规</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contractSearch.jsp">合同查询</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contractParaSetting.jsp">参数设置</a></td>
      <td width="100%">&nbsp;</td>
    </tr>
  </tbody>
</table>

<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
  <tbody>
    <tr>
      <td style="padding-left:15px;" nowrap="nowrap">您现在的位置： 合同管理 &gt; 框架合同 &gt; 合同上传</td>
      <td width="100%" align="center">&nbsp;</td>
      <td align="right" style="padding-right:15px;"><jsp:include page="../common/toolbar.jsp" flush="true"/></td>
    </tr>
  </tbody>
</table>

<!-- 网站中部 -->
<table width="100%" class="showPanelBg" cellpadding="0" cellspacing="0" border="0" align="center" >
<tbody>
<tr>
  <td width="100%" align="left" valign="top">
  <!-- 内容开始 -->
<div class="contentListDiv">
        <form id="scanCopyForm" method="post" enctype="multipart/form-data" >
        <input type="hidden" name="contractid" id="contractId0" value="" />
        <table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
          <tbody>
            <tr>
              <td><table border="0" cellspacing="0" cellpadding="3" width="100%" class="small">
                  <tbody>
                    <tr>
                      <td class="dvtTabCache" style="width:10px" nowrap="">&nbsp;</td>
                      <td style="width:15%" align="center" nowrap="" class="dvtSelectedCell" id="bi" onclick="fnLoadValues('bi','mi','basicTab','moreTab','normal','Contacts')"><b>合同扫描件上传</b></td>
                      <td class="dvtTabCache" style="width:85%" nowrap="">&nbsp;</td>
                    </tr>
                    <tr> </tr>
                  </tbody>
                </table></td>
            </tr>
            <tr>
              <td valign="top" align="left">
              <div id="basicTab" style="display: block; ">
                  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="dvtContentSpace">
                    <tbody>
                      <tr>
                        <td align="left"><table border="0" cellspacing="0" cellpadding="0" width="100%">
                            <tbody>
                              <tr>
                                <td id="autocom">&nbsp;</td>
                              </tr>
                              <tr>
                                <td style="padding:10px"><!-- General details -->
                                  
                                  <table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
                                    <tbody>
                                      <tr style="height:25px">
                                        <td ><table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
                                            <tbody>
                                              <tr>
                                                <td colspan="4" class="detailedViewHeader"><b>合同基本信息</b></td>
                                              </tr>
                                              <tr style="height:25px">
                                                <td width="25%" class="dvtCellLabel" align="right">合同编号</td>
                                                <td width="30%"  align="left" class="dvtCellInfo" id="contractId"></td>
                                                <td width="25%" class="dvtCellLabel" align="right">供应商名称</td>
                                                <td width="25%" align="left" class="dvtCellInfo" id="supplierName"></td>
                                                <!-- Non Editable field, only configured value will be loaded --> 
                                              </tr>
                                              <tr style="height:25px">
                                                <td width="25%" class="dvtCellLabel" align="right">采购负责人</td>
                                                <td width="30%"  align="left" class="dvtCellInfo" id="purchaser"></td>
                                                <td width="25%" class="dvtCellLabel" align="right">状态</td>
                                                <td width="25%" align="left" class="dvtCellInfo" id="status"></td>
                                                
                                              </tr>
                                              <tr>
                                                <td colspan="4" class="detailedViewHeader"><b>扫描件信息</b>(注：扫描件全为签字文件)</td>
                                              </tr>
                                              <tr style="height:25px">
                                                <td width="25%" height="32" align="right" class="dvtCellLabel"><font color="red"></font>年度合同</td>
                                                <td colspan="3" width="30%" align="left" class="dvtCellInfo"><input type="file" name="yearContract" id="yearContract" class="detailedViewTextBox" style="width:40%;" value="" /></td>
                                              </tr>
                                              <tr style="height:25px">
                                                <td width="25%" height="32" align="right" class="dvtCellLabel"><font color="red"></font>偏差协议</td>
                                                <td colspan="3" width="30%" align="left" class="dvtCellInfo"><input type="file" name="diviation" id="diviation" tabindex="" class="detailedViewTextBox" style="width:40%;" value="" /></td>
                                              </tr>
                                              <tr style="height:25px">
                                                <td width="25%" height="32" align="right" class="dvtCellLabel"><font color="red"></font>价格协议</td>
                                                <td colspan="3" width="30%" align="left" class="dvtCellInfo"><input type="file" name="price" id="price" tabindex="" class="detailedViewTextBox" style="width:40%;" value="" /></td>
                                              </tr>
                                              <tr>
                                                <td colspan="4" style="padding:5px" height="40"><div align="center">
                                                    <input id="submitBtn1" title="保存" class="crmbutton small save"  type="submit"  value="  保存  " style="width:70px"/>
                                                    &nbsp;
                                                    <input title="取消" class="crmbutton small cancel" onclick="window.history.back()" type="button" value="  取消  " style="width:70px"/>
                                                  </div></td>
                                              </tr>
                                            </tbody>
                                          </table>
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
                </div>
                
                <!-- Basic Information Tab Closed --> 
      </td></tr>
  </tbody></table>
</form>
</div>

</td></tr></tbody></table>
<!-- 网站底部 -->

<jsp:include page="../common/bottom.jsp" flush="true"/>
</body>
</html>