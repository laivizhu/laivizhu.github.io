<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>合同审批-采购平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="../common/basicInclude.jsp" />
<script language="javascript">
$(document).ready(function(e) {
		var table01 = new HouQianTable({
					url:"frameContract_list.action?status="+"",
					parentContainer:"#div1",
					columns:[
						{name:"合同编号",width:"15%",bindingProperty:"contractId"},
						{name:"供应商名称",width:"55%",bindingProperty:"suppierId"},
						{name:"采购员",width:"10%",bindingProperty:"userId"},
						{name:"创建时间",width:"10%",bindingProperty:"createTime"},
						{name:"合同状态",width:"10%",bindingProperty:"status"},
					],
					specialOperations:[
						{name:"取消",isAjax:true,callback:contractCancel}
					],
					pageCount:8,
					selectType:1
				});
		categoryList("frameContract_listReason.action",$("#cancelReasonID"));
		houQian.submitForm($('#contractCancelId'), 'frameContract_cancel.action', function(data){
			dialogClose();
			houQian.alert(data.msg);
		    table01.refresh();
	    });
});

function contractCancel(data){
	//if(houQian.isNotNull(data)){
    dialogOpen($("#contractCancel"),'合同取消',200,400);
	$('#contractCancelId').resetForm();
	alert(data.id);
	$("#id").val(data.id);
	//}
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
      <td class="level2UnSelTab" nowrap="nowrap"><a href="yearcontractList.action">年度合同模板</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="frame_contract.jsp">框架合同</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_modify.jsp">合同变更</a></td>
      <td class="level2SelTab" nowrap="nowrap"><a href="contract_cancel.jsp">合同取消</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_compliance.jsp">合同合规</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_query.jsp">历史查询</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_setting.jsp">参数设置</a></td>
      <td width="100%">&nbsp;</td>
    </tr>
  </tbody>
</table>

<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
  <tbody>
    <tr>
      <td style="padding-left:15px;" nowrap="nowrap">  您现在的位置： 合同管理 &gt; 合同取消 </td>
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
      <td width="100%" align="left" valign="top">
      <!-- 内容开始 -->
        <div class="contentListDiv">
          <table align="center" border="0" cellpadding="0" cellspacing="0" width="100%">
            <tbody>
              <tr>
                <td><table class="small" border="0" cellpadding="3" cellspacing="0" width="100%">
                    <tbody>
                      <tr>
                        <td class="dvtTabCache" style="width: 10px;" nowrap="nowrap">&nbsp;</td>
                        <td id="test2" class="dvtSelectedCell" align="center" nowrap="nowrap">合同取消</td>
                        <td class="dvtTabCache" style="width: 100%;">&nbsp;</td>
                      </tr>
                    </tbody>
                  </table></td>
              </tr>
              <tr>
                <td align="left" valign="top"><table class="dvtContentSpace" border="0" cellpadding="3" cellspacing="0" width="100%">
                    <tbody>
                      <tr>
                        <td align="left">
                          <table border="0" cellpadding="0" cellspacing="0" width="100%">
                            <tbody>
                              <tr>
                                <td style="padding: 10px;">
                                 <div id="div1" class="small" style="width:100%;position:relative;"></div>
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
<div id="contractCancel" style="margin:0;display:none;">
<br />
 <form id="contractCancelId" method="post" >
 <input name="id" id="id" type="hidden" value="" />
 	<table width="100%" align="center" border="0" cellpadding="3" cellspacing="0" class="table_border">
      <tr>
        <td width="30%" align="right" valign="middle" class="td_border">合同取消原因：</td>
        <td width="70%" align="left" valign="middle" class="td_border">
        <select name="reasonId" id="cancelReasonID" style="width:90%;">
        </select>
        </td>
     </tr>
  	</table>
        <table width="100%">
        <tr>
        <td colspan="2" align="center" height="40">
          <input id="submitBtn2" class="crmbutton small save" type="submit" value="保存" style="width:70px"/>&nbsp;
          <input class="crmbutton small cancel" type="reset" value="取消"  onclick="dialogClose()" style="width:70px"/>
        </td>
        </tr>
    </table>
 </form>
</div>
<!-- 网站底部 -->
<jsp:include page="../common/bottom.jsp" flush="true"/>
</body>
</html>
