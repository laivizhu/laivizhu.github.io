<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>供应商质量文档中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="../common/basicInclude.jsp" />
<script language="javascript">
	$(document).ready(function(e) {
		new HouQianTable({
				url:"supplierBasic_list.action",
				parentContainer:"#supplierListTableId",
				columns:[
				    {name:"编号",width:"10%",bindingProperty:"code"},
					{name:"供应商名称",width:"30%",bindingProperty:"name"},
					{name:"电话",width:"10%",bindingProperty:"phone"},
					{name:"负责人",width:"10%",bindingProperty:"personName"},
					{name:"创办时间",width:"10%",bindingProperty:"establishDate"}
				],
				specialOperations:[
					{name:"确定",isAjax:true,callback:chooseSupplier}	
				],
				pageCount:pageSize,
				selectType:1
		});
		categoryList('supplierBasic_searchTypeList.action',$("bas_searchfield"));
	});

	function DispContent( i , count){
		var m=i;
		var test = document.getElementById('test'+i);	
		var div = document.getElementById( 'div' + i );
		
		for(var n=1;n<7;n++){
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
	function supplierChoose() {
			dialogOpen($("#supplier"),'选择供应商',500,800);
		}
		
	function suppliesChoose() {
		dialogOpen($("#supplies"),'选择供应商',500,800);
	}
	
	var chooseSupplier=function(data){
		$("#supplierNameInputId").val(data.name);
		$("#supplierInputId").val(data.id);
		$("#supplier").dialog("close");
	};
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
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_performance.jsp">供应商日常绩效管理</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_monthManage.jsp">供应商月度绩效评价</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="complaint_list.jsp">供应商投诉</a> </td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="advice_list.jsp">供应商合理化建议</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_report.jsp">供应商改善对策报告</a> </td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="supplier_terrace.jsp">供应商质量管理平台</a> </td>
      <td class="level2SelTab" nowrap="nowrap"><a href="supplier_document.jsp">供应商质量文档中心</a></td>
      <td width="100%">&nbsp;</td>
    </tr>
  </tbody>
</table>
<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
    <td style="padding-left:15px;" nowrap="nowrap">您现在的位置： 供应商日常管理 &gt; 供应商质量文档中心 &gt; 供应商资格审核报告 </td>
	<td width="100%" align="center" valign="middle"></td>
    <td align="right" style="padding-right:15px;">
        <jsp:include page="../common/toolbar.jsp" flush="true"/>
    </td>
</tr></tbody>
</table>
<!-- 工作台 -->
<table width="100%" class="showPanelBg" cellpadding="0" cellspacing="0" border="0" align="center" >
  <tbody>
    <tr>
      <td align="left" valign="top" width="100%">
      	<div class="contentListDiv">
          <form name="EditView" method="" action="" onsubmit="">
          <input type="hidden" id="supplierInputId" name="supplier.id"/>
            <table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
              <tbody>
                <!-- 新建竞标设置 -->
                <tr>
                  <td><table border="0" cellspacing="0" cellpadding="3" width="100%" class="small">
                      <tbody>
                        <tr>
                          <td class="dvtTabCache" style="width:10px" nowrap="">&nbsp;</td>
                          <td style="width:15%" align="center" nowrap=""
															class="dvtSelectedCell" id="bi"
															onclick="fnLoadValues('bi','mi','basicTab','moreTab','normal','Contacts')">供应商资格审核报告</td>
                          <td class="dvtTabCache" style="width:85%" nowrap="">&nbsp;</td>
                        </tr>
                      </tbody>
                    </table></td>
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
                                            <td align="left" class="dvtCellInfo">
                                            <table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
                                                <tbody>
                                                  <tr style="height:25px">
                                                    <td ><table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
                                                        <tbody>
                                                          <tr>
                                                            <td colspan="4" class="detailedViewHeader"><b>新建报告</b></td>
                                                          </tr>
                                                          
                                                          <tr style="height:25px">
                                                            <td width="20%" class="dvtCellLabel" align="right">报告类别</td>
                                                            <td width="30%" align="left" class="dvtCellInfo">
                                                            <input type="text" name="lastname" tabindex="" class="detailedViewTextBox" style="width:50%;" value="测试" />                                                            </td>
                                                            <td width="20%" class="dvtCellLabel" align="right">报告标题</td>
                                                            <td width="30%" align="left" class="dvtCellInfo">
                                                            <input type="text" name="lastname" tabindex="" class="detailedViewTextBox" style="width:50%;" value="测试数据" />                                                            </td>
                                                          </tr>
                                                         
                                                          <tr style="height:25px">
                                                            <td width="20%" class="dvtCellLabel" align="right">提交人</td>
                                                            <td width="30%" align="left" class="dvtCellInfo">
                                                            <input type="text" name="lastname" tabindex="" class="detailedViewTextBox" style="width:50%;" value="张丽丽" />                                                            </td>
                                                            <td width="20%" class="dvtCellLabel" align="right">物料类别</td>
                                                            <td width="30%" align="left" class="dvtCellInfo">
                                                            <input type="text" name="lastname" tabindex="" class="detailedViewTextBox" style="width:50%;" value="测试" />                                                            </td>
                                                          </tr>
                                                          
                                                          <tr style="height:25px">
                                                            <td width="20%" class="dvtCellLabel" align="right">供应商</td>
                                                            <td width="30%" align="left" class="dvtCellInfo">
<input type="text" id="supplierNameInputId2" name="supplierNameInputId" class="detailedViewTextBox" style="width:50%;" value="供应商1" />
浏览供应商: <img tabindex="2" src="../images/select.gif" alt="选择" title="选择" onclick="supplierChoose()" align="absmiddle" style="cursor:hand;cursor:pointer"/> 
<img src="../images/clear.gif" alt="清除" title="清除"   onclick="document.EditView.lastname2.value=''; document.EditView.lastname2.value='';"  align="absmiddle" style="cursor:hand;cursor:pointer" /></td>
                                                            <td width="20%" class="dvtCellLabel" align="right">文件附件</td>
                                                            <td width="30%" align="left" class="dvtCellInfo"><input type="file" name="lastname2" tabindex="" class="detailedViewTextBox" style="width:72%;" value="2" /></td>
                                                          </tr>
                                                          
                                                          <tr style="height:25px">
                                                            <td width="20%" class="dvtCellLabel" align="right">上传日期</td>
                                                            <td width="30%" align="left" class="dvtCellInfo"><input type="text" name="lastname4" tabindex="" class="detailedViewTextBox" style="width:50%;" value="2012-10-30" /></td>
                                                            <td width="20%" class="dvtCellLabel" align="right">上传人</td>
                                                            <td width="30%" align="left" class="dvtCellInfo"><input type="text" name="lastname3" tabindex="" class="detailedViewTextBox" style="width:50%;" value="李作哲" /></td>
                                                          </tr>
                                              </tbody></table></td></tr></tbody></table>
                                              <table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
                                                <tbody>
                                                  <tr style="height:25px">
                                                    <td ><table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
                                                        <tbody>
                                                          <tr>
                                                            <td height="40" colspan="4" style="padding:5px"><div align="center">
                                                                <input title="保存 [Alt+S]" accesskey="S" class="crmbutton small save" 
                                                     onclick="" type="submit" name="button" value="保存" style="width:70px" />
                                                                &nbsp;
                                                                <input title="取消 [Alt+X]" accesskey="X" class="crmbutton small cancel" 
                                                     onclick="window.location.href('supplier_document.jsp')" 
                                                     type="button" name="button3" value="  取消  " style="width:70px" />
                                                            </div></td>
                                                          </tr>
                                                        </tbody>
                                                    </table></td>
                                                  </tr>
                                                </tbody>
                                              </table></td>
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
                  </td>
                </tr>
              </tbody>
            </table>
          </form>
        </div></td>
    </tr>
  </tbody>
</table>
<!-- 网站底部 -->
<jsp:include page="../common/bottom.jsp" flush="true"/>



<div id="supplier" style="display:none">
 <table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
    <tbody>
      <tr>
        <td><div style="margin-top:10px;"><table border="0" cellspacing="0" cellpadding="3" width="100%" class="small">
            <tbody>
              <tr bgcolor="white"  id="row_116" class="lvtColData">
                <td class="lvtColData" colspan="10" >
                <table width="652" cellpadding="5" cellspacing="0" class="searchUIBasic small" align="center" border="0">
                    <tbody>
                      <tr>
                      <td></td>
                        <td class="small" align="left" nowrap="nowrap"><span class="moduleName">搜索&nbsp;-&nbsp;供应商</span> </td>
                        <td class="small" nowrap="nowrap" align="right" ><b>在</b>&nbsp;
                          <select name="search_field" id="bas_searchfield" class="txtBox" style="width:120px">
                          </select>
                          <b>中&nbsp;&nbsp;&nbsp;&nbsp;查找</b>
                          <input type="text" class="txtBox" style="width:150px" name="search_text"/>
                          &nbsp;&nbsp;
                          <input name="submit" type="button" class="crmbutton small create" value=" 立刻查找 "/>                                </td>
                        <td></td>
                      </tr>
                    </tbody>
                  </table></td>
              </tr>
            </tbody>
          </table></div></td>
      </tr>    
       <tr><td style="height:10px;">&nbsp;</td></tr>     
      <tr>
        <td valign="top" align="left">
        <div id="supplierListTableId" style="display: block; ">
         </div>
         </td>
      </tr>
    </tbody>
  </table>
</div> 
<div id="supplies" style="display:none">
 <jsp:include page="../common/choice_supplies.jsp" flush="true"/>
</div> 




</body>
</html>
