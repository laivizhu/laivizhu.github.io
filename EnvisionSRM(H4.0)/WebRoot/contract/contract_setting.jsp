<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>合同操作-采购平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="../common/basicInclude.jsp" />
<script language="javascript">
$(document).ready(function(e) {
		var table = new HouQianTable({
					url:"frameContract_listCancelReason.action",
					parentContainer:"#contractCancel",
					columns:[
						{name:"编号",width:"10%",bindingProperty:"id"},
						{name:"取消原因",width:"70%",bindingProperty:"reason"},
						{name:"创建日期",width:"10%",bindingProperty:"createTime"},
					],
					specialOperations:[
						{name:"新建",callback:function(data){
						   window.location.href = "contract_cancelreason_add.jsp";
						}}
					],
					commonOperations:[
			            {name:"删除",callback:function(data){
				           if(window.confirm("确认删除？"))
				           {
					          $.getJSON("frameContract_delete.action?id="+data.id,function(returnData){
						      if(returnData.success)
						      {
							    window.alert(returnData.msg);
							    window.location.reload();
						      }
					       });
				        }	
			            }}
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
    <tr>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="yearcontractList.action">年度合同模板</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="frame_contract.jsp">框架合同</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_modify.jsp">合同变更</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_cancel.jsp">合同取消</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_compliance.jsp">合同合规</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_query.jsp">历史查询</a></td>
      <td class="level2SelTab" nowrap="nowrap"><a href="contract_setting.jsp">参数设置</a></td>
      <td width="100%">&nbsp;</td>
    </tr>
  </tbody>
</table>

<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
  <tbody>
    <tr>
      <td style="padding-left:15px;" nowrap="nowrap">您现在的位置： 合同管理 &gt; 参数设置 &gt; 合同取消原因设置</td>
      <td width="100%" align="center" valign="middle"></td>
      <td align="right" style="padding-right:10px;"><table>
          <tr>
           
          
          </tr>
        </table></td>
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
                        <td id="test1" class="dvtSelectedCell" align="center" nowrap="nowrap" >合同取消原因设置</td>
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
                                <div id="contractCancel" class="small" style="width:100%;position:relative;">
                                    
                                  </div>
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
