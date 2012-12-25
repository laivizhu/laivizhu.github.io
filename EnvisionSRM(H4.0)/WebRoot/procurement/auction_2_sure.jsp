<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>电子竞标</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<script language="javascript" type="text/javascript" src="../js/general.js"></script>
<script language="javascript">
function DispContent( i , count)
{
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
</script></head>
<body class="small" leftmargin="0" topmargin="0" marginheight="0" marginwidth="0"  rightmargin="0" bottommargin="0">
<!-- 网站顶部 -->
<jsp:include page="../common/top.jsp" flush="true"/>
<!-- 网站导航 -->
<jsp:include page="../common/navigation.jsp" flush="true"/>
<!-- 二级菜单 -->
<table border="0" cellpadding="0" width="100%" class="level2Bg">
  <tbody>
    <tr>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="bid_frame.jsp">年度招标</a> </td>
      <td class="level2SelTab" nowrap="nowrap"><a href="auction_frame.jsp">电子竞标</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="strategy_material.jsp">物料类别策略执行</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="strategy_supplier.jsp">供应商管理策略执行</a></td>
      <td width="100%">&nbsp;</td>
    </tr>
  </tbody>
</table>
<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
  <tbody>
    <tr>
      <td style="padding-left:15px;" nowrap="nowrap"> 您现在的位置： 采购项目管理管理 &gt; 电子竞标 &gt; 竞标协议确认</td>
      <td width="100%" align="center" valign="middle"></td>
      <td align="right" style="padding-right:15px;"><jsp:include page="../common/toolbar.jsp" flush="true"/>
      </td>
    </tr>
  </tbody>
</table>
<!-- 工作台 -->
<table width="100%" class="showPanelBg" cellpadding="0" cellspacing="0" border="0" align="center" >
  <tbody>
    <tr>
      <td align="left" valign="top" width="100%"><div class="contentListDiv">
          <form name="EditView" method="" action="" onsubmit="">
            <table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
              <tbody>
                <tr>
                  <td><table border="0" cellspacing="0" cellpadding="3" width="100%" class="small">
                      <tbody>
                        <tr>
                          <td class="dvtTabCache" style="width:10px" nowrap="">&nbsp;</td>
                          <td style="width:15%" align="center" nowrap="" class="dvtSelectedCell" id="bi" onclick="fnLoadValues('bi','mi','basicTab','moreTab','normal','Contacts')">竞标相关文件确认</td>
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
                                            <td width="30%" align="left" class="dvtCellInfo"><table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
                                                <tbody>
                                                  <tr style="height:25px">
                                                    <td >
                                                    <table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
                                                        <tbody>
                                                          <tr>
                                                            <td colspan="10" class="detailedViewHeader"><strong>项目名称</strong> </td>
                                                          </tr>
                                                          <tr style="height:25px">
                                                            <td width="36%" class="dvtCellLabel" align="right">项目名称</td>
                                                            <td width="64%" colspan="8" align="left" class="dvtCellInfo">
                                                              <input type="text" value="" name="text" style="width:300px;">
                                                            </td>
                                                            <!-- Non Editable field, only configured value will be loaded -->
                                                          </tr>
                                                          </tbody>
                                                     </table>
                                                     <table  border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
                                                       <tbody>
                                                        
                                                          <tr style="height:25px">
                                                            <td>
                                                            <div class="calDIV" style="overflow:auto; width:100%;">
                                                              <table border="0" cellspacing="1" cellpadding="3" width="100%" class="lvt small">
                                                                <tbody>
                                                                  <tr>
                                                            <td colspan="15" class="detailedViewHeader"><strong>供应商</strong></td>
                                                          </tr>
                                      <tr>
                                        <td rowspan="2" width="10%" class="lvtCol">供应商编号</td>
                                        <td rowspan="2" width="14%" class="lvtCol">供应商名称</td>
                                        <td rowspan="2" width="7%" class="lvtCol">投标状态</td>
                                        <td rowspan="2" width="9%" class="lvtCol">押金确认</td>
                                        <td width="30%" colspan="4" class="lvtCol"><div align="center">竞标文件</div></td>
                                        <td width="30%" colspan="4" class="lvtCol"><div align="center">竞标协议</div></td>
                                      </tr> 
                                      <tr bgcolor="white" style="height:25px">
                                        <td class="lvtCol">内容确认</td>
                                        <td class="lvtCol">正本文件确认</td>
                                        <td class="lvtCol">邮寄单号</td>
                                        <td class="lvtCol">附件</td>
                                        
                                        <td class="lvtCol">内容确认</td>
                                        <td class="lvtCol">正本文件确认</td>
                                        <td class="lvtCol">邮寄单号</td>
                                        <td class="lvtCol">附件</td>
                                      </tr>
                                      <tr bgcolor="white" style="height:25px">
                                        <td class="dvtCellInfo">20112311</td>
                                        <td class="dvtCellInfo">厚谦咨询</td>
                                        <td class="dvtCellInfo">测试</td>
                                        <td class="dvtCellInfo">
                                        	<input type="radio" value="0" name="rdo">是
                                            <input type="radio" value="1" name="rdo">否                                        </td>
                                        <td class="dvtCellInfo">
                                        	<input type="radio" value="0" name="rdo">是
                                            <input type="radio" value="1" name="rdo">否                                        </td>
                                        <td class="dvtCellInfo">
                                        	<input type="radio" value="0" name="rdo">是
                                            <input type="radio" value="1" name="rdo">否                                        </td>
                                        <td class="dvtCellInfo">测试数据</td>
                                        <td class="dvtCellInfo"><a href="check_history.jsp">测试数据1.pdf</a></td>
                                        
                                           <td class="dvtCellInfo">
                                        	<input type="radio" value="0" name="rdo">是
                                            <input type="radio" value="1" name="rdo">否                                        </td>
                                        <td class="dvtCellInfo">
                                        	<input type="radio" value="0" name="rdo">是
                                            <input type="radio" value="1" name="rdo">否                                        </td>
                                        <td class="dvtCellInfo">测试数据</td>
                                        <td class="dvtCellInfo"><a href="check_history.jsp">测试数据1.pdf</a></td>
                                      </tr>
                                                                </tbody>
                                                              </table>
                                                            </div></td>
                                                          </tr>
                                                          
                                                          <tr>
                                                            <td height="40px;" colspan="4" style="padding:5px"><div align="center">
                                                                <input title="保存 [Alt+S]" accesskey="S" class="crmbutton small save" 
                                                     onclick="show2();" type="submit" name="button" value="保存" style="width:70px" />
                                                                &nbsp;
                                                                <input title="取消 [Alt+X]" accesskey="X" class="crmbutton small cancel" 
                                                     onclick="window.location.href('auction_frame.jsp')" 
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
</body>
</html>
