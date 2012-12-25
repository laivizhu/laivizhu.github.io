<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>年度招标</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<jsp:include page="../common/basicInclude.jsp" />
<script language="javascript" type="text/javascript" src="../js/material/material_choose.js"></script>
<script language="javascript" type="text/javascript" src="../js/supplier/supplier_common.js"></script>
<script language="javascript">
	$(document).ready(function(e) {
		loadSupplier();
		loadMaterial();
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
      <td class="level2SelTab" nowrap="nowrap"><a href="bid_frame.jsp">年度招标</a> </td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="auction_frame.jsp">电子竞标</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="strategy_material.jsp">物料类别策略执行</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="strategy_supplier.jsp">供应商管理策略执行</a></td>
      <td width="100%">&nbsp;</td>
    </tr>
  </tbody>
</table>
<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
    <td style="padding-left:15px;" nowrap="nowrap">您现在的位置： 采购项目管理管理 &gt; 年度招标 </td>
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
      	<div class="contentViewDiv">
          <form name="EditView" method="" action="" onsubmit="">
          <input type="hidden" id="supplierInputId" name="supplier.id"/>
           <input type="hidden" id="materialInputId" name="material.id"/>
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
															onclick="fnLoadValues('bi','mi','basicTab','moreTab','normal','Contacts')"><b>新建年度招标项目</b> </td>
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
                                            <td width="30%" align="left" class="dvtCellInfo">
                                            <table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
                                                <tbody>
                                                  <tr style="height:25px">
                                                    <td ><table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
                                                        <tbody>
                                                          <tr>
                                                            <td colspan="4" class="detailedViewHeader"><strong>新建年度招标项目</strong> </td>
                                                          </tr>
                                                          <tr style="height:25px">
                                                            <td width="36%" class="dvtCellLabel" align="right">年度招标项目名称</td>
                                                            <td width="64%" colspan="3" align="left" class="dvtCellInfo"><input type="text" name="lastname2" tabindex="" class="detailedViewTextBox" style="width:300px;" value="" /></td>
                                                          </tr>
                                                          <tr style="height:25px">
                                                            <td width="36%" class="dvtCellLabel" align="right">预计时间周期</td>
                                                            <td colspan="3" align="left" class="dvtCellInfo"><input type="text" name="lastname" tabindex="" class="detailedViewTextBox" style="width:300px;" value="" /></td>
                                                          </tr>
                                                          <tr style="height:25px">
                                                            <td width="36%" class="dvtCellLabel" align="right"><font color="red"></font>上传招标文件</td>
                                                            <td colspan="3" width="64%" align="left" class="dvtCellInfo"><input type="file" name="上传招标文件" tabindex="" class="detailedViewTextBox" style="width:308px;" value="" />                                                            </td>
                                                          </tr>
                                                          <tr style="height:25px">
                                                            <td width="36%" class="dvtCellLabel" align="right"> 供应商清单 </td>
                                                            <td colspan="3" align="left" class="dvtCellInfo"><input type="text" id="supplierNameInputId" name="lastname" tabindex="" class="detailedViewTextBox" onfocus="this.classname='detailedViewTextBoxOn'" onblur="this.className='detailedViewTextBox'" style="width:300px;" value="" />
                                                              浏览供应商:
                                                              <img tabindex="2" src="../images/select.gif" alt="选择" title="选择" onclick="supplierChoose()" align="absmiddle" style="cursor:hand;cursor:pointer"/>
                                                              <img src="../images/clear.gif" alt="清除" title="清除"   onclick="document.EditView.lastname2.value=''; document.EditView.lastname2.value='';"  align="absmiddle" style="cursor:hand;cursor:pointer" /></td>
                                                          </tr>
                                                          <tr style="height:25px">
                                                            <td width="36%" class="dvtCellLabel" align="right"><font color="red"></font>物料名称</td>
                                                            <td colspan="3" width="64%" align="left" class="dvtCellInfo"><a href="#">
                                                              <input type="text" id="materialNameInputId" name="lastname3" tabindex="" class="detailedViewTextBox" 
                                                 	 onfocus="this.className='detailedViewTextBoxOn'" 
                                                 	 onblur="this.className='detailedViewTextBox'" style="width:300px;" value="" />
                                                            </a>物料清单:
                                                              <img tabindex="2" src="../images/select.gif" alt="选择" title="选择" onclick="materialChoose()" align="absmiddle" style="cursor:hand;cursor:pointer"/> 
                                                            <img src="../images/clear.gif" alt="清除" title="清除"   onclick="document.EditView.lastname2.value=''; document.EditView.lastname2.value='';"  align="absmiddle" style="cursor:hand;cursor:pointer" /></td>
                                                          </tr>
                                                          
                                                          <tr style="height:25px">
                                                            <td class="dvtCellLabel" align="right">选择模板</td>
                                                            <td align="left" class="dvtCellInfo">
                                                             <select id = "standardTemplateID" style="width:308px;" name="securitBean.securitTemplateID">
                                                                <option value="-1" selected="selected">请选择...</option>
                                                              </select>
                                                            </td>
                                                          </tr>
                                              </tbody></table></td></tr></tbody></table>
                                              <table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
                                                <tbody>
                                                  <tr style="height:25px">
                                                    <td ><table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
                                                        <tbody>
                                                          <tr>
                                                            <td colspan="4" class="detailedViewHeader"><strong>评标参数设置</strong> </td>
                                                          </tr>
                                                          <tr style="height:25px">
                                                            <td width="151" class="dvtCellLabel" align="right">管理</td>
                                                            <td width="214" align="left" class="dvtCellInfo"><input type="radio" value="0" name="rdo">
                                                              是
                                                              <input type="radio" value="1" name="rdo">
                                                              否
                                                              &nbsp;&nbsp;&nbsp;&nbsp;权重
                                                              <select width:100px>
                                                                <option value="0">&nbsp;</option>
                                                                <option value="1">10%</option>
                                                                <option value="2">20%</option>
                                                                <option value="3">30%</option>
                                                                <option value="4">40%</option>
                                                                <option value="5">50%</option>
                                                                <option value="6">60%</option>
                                                                <option value="7">70%</option>
                                                                <option value="8">80%</option>
                                                                <option value="9">90%</option>
                                                              </select>
                                                            </td>
                                                            <td width="149" align="right" class="dvtCellLabel">业绩</td>
                                                            <td width="214" align="left" class="dvtCellInfo"><input type="radio" value="0" name="rdo">
                                                              是
                                                              <input type="radio" value="1" name="rdo">
                                                              否
                                                              &nbsp;&nbsp;&nbsp;&nbsp;权重
                                                              <select name="select4" width:100px="width:100px">
                                                                <option value="0">&nbsp;</option>
                                                                <option value="1">10%</option>
                                                                <option value="2">20%</option>
                                                                <option value="3">30%</option>
                                                                <option value="4">40%</option>
                                                                <option value="5">50%</option>
                                                                <option value="6">60%</option>
                                                                <option value="7">70%</option>
                                                                <option value="8">80%</option>
                                                                <option value="9">90%</option>
                                                              </select>
                                                            </td>
                                                          </tr>
                                                          <tr style="height:25px">
                                                            <td width="151" class="dvtCellLabel" align="right">技术</td>
                                                            <td width="214" align="left" class="dvtCellInfo"><input type="radio" value="0" name="rdo">
                                                              是
                                                              <input type="radio" value="1" name="rdo">
                                                              否
                                                              &nbsp;&nbsp;&nbsp;&nbsp;权重
                                                              <select name="select" width:100px="width:100px">
                                                                <option value="0">&nbsp;</option>
                                                                <option value="1">10%</option>
                                                                <option value="2">20%</option>
                                                                <option value="3">30%</option>
                                                                <option value="4">40%</option>
                                                                <option value="5">50%</option>
                                                                <option value="6">60%</option>
                                                                <option value="7">70%</option>
                                                                <option value="8">80%</option>
                                                                <option value="9">90%</option>
                                                              </select>
                                                            </td>
                                                            <td width="149" align="right" class="dvtCellLabel">质量</td>
                                                            <td width="214" align="left" class="dvtCellInfo"><input type="radio" value="0" name="rdo">
                                                              是
                                                              <input type="radio" value="1" name="rdo">
                                                              否
                                                              &nbsp;&nbsp;&nbsp;&nbsp;权重
                                                              <select name="select5" width:100px="width:100px">
                                                                <option value="0">&nbsp;</option>
                                                                <option value="1">10%</option>
                                                                <option value="2">20%</option>
                                                                <option value="3">30%</option>
                                                                <option value="4">40%</option>
                                                                <option value="5">50%</option>
                                                                <option value="6">60%</option>
                                                                <option value="7">70%</option>
                                                                <option value="8">80%</option>
                                                                <option value="9">90%</option>
                                                              </select>
                                                            </td>
                                                          </tr>
                                                          <tr style="height:25px">
                                                            <td width="151" class="dvtCellLabel" align="right">成本</td>
                                                            <td width="214" align="left" class="dvtCellInfo"><input type="radio" value="0" name="rdo">
                                                              是
                                                              <input type="radio" value="1" name="rdo">
                                                              否
                                                              &nbsp;&nbsp;&nbsp;&nbsp;权重
                                                              <select name="select2" width:100px="width:100px">
                                                                <option value="0">&nbsp;</option>
                                                                <option value="1">10%</option>
                                                                <option value="2">20%</option>
                                                                <option value="3">30%</option>
                                                                <option value="4">40%</option>
                                                                <option value="5">50%</option>
                                                                <option value="6">60%</option>
                                                                <option value="7">70%</option>
                                                                <option value="8">80%</option>
                                                                <option value="9">90%</option>
                                                              </select>
                                                            </td>
                                                            <td width="149" align="right" class="dvtCellLabel">交付</td>
                                                            <td width="214" align="left" class="dvtCellInfo"><input type="radio" value="0" name="rdo">
                                                              是
                                                              <input type="radio" value="1" name="rdo">
                                                              否
                                                              &nbsp;&nbsp;&nbsp;&nbsp;权重
                                                              <select name="select6" width:100px="width:100px">
                                                                <option value="0">&nbsp;</option>
                                                                <option value="1">10%</option>
                                                                <option value="2">20%</option>
                                                                <option value="3">30%</option>
                                                                <option value="4">40%</option>
                                                                <option value="5">50%</option>
                                                                <option value="6">60%</option>
                                                                <option value="7">70%</option>
                                                                <option value="8">80%</option>
                                                                <option value="9">90%</option>
                                                              </select>
                                                            </td>
                                                          </tr>
                                                          <tr style="height:25px">
                                                            <td width="151" class="dvtCellLabel" align="right">服务</td>
                                                            <td width="214" align="left" class="dvtCellInfo"><input type="radio" value="0" name="rdo">
                                                              是
                                                              <input type="radio" value="1" name="rdo">
                                                              否
                                                              &nbsp;&nbsp;&nbsp;&nbsp;权重
                                                              <select name="select3" width:100px="width:100px">
                                                                <option value="0">&nbsp;</option>
                                                                <option value="1">10%</option>
                                                                <option value="2">20%</option>
                                                                <option value="3">30%</option>
                                                                <option value="4">40%</option>
                                                                <option value="5">50%</option>
                                                                <option value="6">60%</option>
                                                                <option value="7">70%</option>
                                                                <option value="8">80%</option>
                                                                <option value="9">90%</option>
                                                              </select>
                                                            </td>
                                                            <td width="149" align="right" class="dvtCellLabel"></td>
                                                            <td width="214" align="left" class="dvtCellInfo"></td>
                                                          </tr>
                                                          <tr>
                                                            <td height="40" colspan="4" style="padding:5px"><div align="center">
                                                                <input title="保存 [Alt+S]" accesskey="S" class="crmbutton small save" 
                                                     onclick="show2();" type="submit" name="button" value="保存" style="width:70px" />
                                                                &nbsp;
                                                                <input title="取消 [Alt+X]" accesskey="X" class="crmbutton small cancel" 
                                                     onclick="window.location.href('bid_frame.jsp')" 
                                                     type="button" name="button" value="  取消  " style="width:70px" />
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
<jsp:include page="../common/choice_supplier.jsp" flush="true"/>
<jsp:include page="../common/choice_material.jsp" flush="true"/>
</body>
</html>
