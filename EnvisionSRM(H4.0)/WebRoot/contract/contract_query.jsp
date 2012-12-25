<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>合同操作-采购平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="../common/basicInclude.jsp" />
<script language="javascript" type="text/javascript">
	$(document).ready(function(e) {
		var table = new HouQianTable({
					url:"frameContract_list.action?status="+"",
					parentContainer:"#div1",
					columns:[
						{name:"合同编号",width:"15%",bindingProperty:"contractId"},
						{name:"供应商名称",width:"37%",bindingProperty:"suppierId"},
						{name:"采购员",width:"10%",bindingProperty:"userId"},
						{name:"创建时间",width:"10%",bindingProperty:"createTime"},
						{name:"合同状态",width:"10%",bindingProperty:"status"},
					],
					commonOperations:[
						{name:"查看",callback:function(data){
						   window.location.href = "contract_totalview.jsp";	
						}},
						
					],
					
					pageCount:8,
					selectType:0
				});

    });
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
    <s:if test="#session.user.id==1001">	
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_maincontractlist.jsp">年度合同模板</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="frame_contract.jsp">框架合同</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_modify.jsp">合同变更</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_cancel.jsp">合同取消</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_compliance.jsp">合同合规</a></td>
      <td class="level2SelTab" nowrap="nowrap"><a href="contract_query.jsp">历史查询</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_setting.jsp">参数设置</a></td>
    </s:if>
	<s:elseif test="#session.user.id==1002">
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_approval.jsp">合同审批</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_compliance.jsp">合同合规</a></td>
      <td class="level2SelTab" nowrap="nowrap"><a href="contract_query.jsp">历史查询</a></td>
    </s:elseif>
      <td width="100%">&nbsp;</td>
    </tr>
  </tbody>
</table>

<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
  <tbody>
    <tr>
      <td style="padding-left:15px;" nowrap="nowrap">您现在的位置： 合同管理 &gt; 历史查询 </td>
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
                        <td id="test1" class="dvtSelectedCell" align="center" nowrap="nowrap" onClick="DispContent(1,5);">合同信息列表</td>                       
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
        <div id="searchBox">
<form name="basicSearch" method="post" action="">
<table width="652" height="40" cellpadding="5" cellspacing="0" class="searchUIBasic small" align="center" border="0">
  <tbody><tr>
    <td></td>
	<td class="small" align="left" nowrap="nowrap">
        <span class="moduleName">搜索 - 合同</span>
    </td>
	<td class="small" nowrap="nowrap" align="right" >
        <b>在</b>&nbsp;
        <select name="search_field" id="bas_searchfield" class="txtBox" style="width:120px">
            <option value="title" selected="selected">合同编号</option>
            <option value="title" >状态</option>
            <option value="title" >供应商名称</option>
            <option value="title" >年度合同</option>
            <option value="title" >物料号</option>
            <option value="title" >物料小组</option>
            <option value="title" >交货期</option>
        </select>
        <b>中&nbsp;&nbsp;&nbsp;&nbsp;查找</b>
        <input type="text" class="txtBox" style="width:150px" name="search_text"/>&nbsp;&nbsp;
        <input name="submit" type="button" class="crmbutton small create" value=" 立刻查找 "/>
	</td>
    <td></td>
  </tr>
  </tbody>
</table>
</form>
</div> 
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
        </div>
      </td>
    </tr>
  </tbody>
</table>

<!-- 网站底部 -->
<jsp:include page="../common/bottom.jsp" flush="true"/>
</body>
</html>
