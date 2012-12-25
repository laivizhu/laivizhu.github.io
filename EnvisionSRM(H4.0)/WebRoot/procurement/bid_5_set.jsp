<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>年度招标</title>
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
</script>


<script type="text/javascript">
var count = 1;
function add() {
  var tbl = document.all.ci;
  var rows = tbl.rows.length;
  var tr = tbl.insertRow(rows);
  
  var pingfenyuanze = tr.insertCell(0);
  pingfenyuanze.innerHTML = '<select onbeforeactivate="return false" onfocus="this.blur()"onmouseover="this.setCapture()"onmouseout="this.releaseCapture()">'+
							  '<option value="0">&nbsp;</option>'+
							  '<option value="1">商务</option>'+
							  '<option value="2">技术</option>'+
							  '<option value="3">价格</option></select>';
  
  var quanzhong = tr.insertCell(1);
  
  quanzhong.innerHTML = '<select onbeforeactivate="return false" onfocus="this.blur()"onmouseover="this.setCapture()"onmouseout="this.releaseCapture()">'+
						  '<option value="0"></option>'+
						  '<option value="1">10%</option>'+
						  '<option value="2">20%</option>'+
						  '<option value="3">30%</option>'+
						  '<option value="1">40%</option>'+
						  '<option value="2">50%</option></select>';
  
  var name = tr.insertCell(2);
  name.innerHTML = '<input type="text">';
  
  var tel = tr.insertCell(3);
  tel.innerHTML = '<input type="text">';
  
  var tel = tr.insertCell(4);
  tel.innerHTML = '<input type="text">';
  
  var del = tr.insertCell(5);
  del.innerHTML = '<input type="button" onclick="del(this)" value="删除">';
  count++;
}

function del(btn) {
  var tr = btn.parentElement.parentElement;
  var tbl = tr.parentElement;
  tbl.deleteRow(tr.rowIndex-1);
}
//-->
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
    <td style="padding-left:15px;" nowrap="nowrap">您现在的位置： 采购项目管理管理 &gt; 年度招标 &gt; 评标设置 </td>
	<td width="100%" align="center" valign="middle"></td>
    <td align="right" style="padding-right:15px;">
        <jsp:include page="../common/toolbar.jsp" flush="true"/>
    </td>
</tr></tbody>
</table>
<!-- 工作台 -->
<table width="100%" class="showPanelBg" cellpadding="0" cellspacing="0" border="0" align="center" ><tbody><tr><td align="left" valign="top" width="100%">
<div class="contentViewDiv">

<table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
<tbody>

<tr><td><table border="0" cellspacing="0" cellpadding="3" width="100%" class="small">
                      <tbody>
                        <tr>
                          <td class="dvtTabCache" style="width:10px" nowrap="">&nbsp;</td>
                          <td style="width:15%" align="center" nowrap="" class="dvtSelectedCell" id="bi" onclick="fnLoadValues('bi','mi','basicTab','moreTab','normal','Contacts')">评标设置</td>
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
                                                  <tr>
                                                    <td colspan="10" class="detailedViewHeader"><div align="left"><strong>评标设置</strong> </div></td>
                                                  </tr>
<tr>
<td>                                                  
                                                  
<table border="0" width="100%" id="ci" name="ci" cellpadding="0" cellspacing="0">
  <thead>
    <tr>
      <td class="dvtCellLabel" height="18px" align="center">评分领域</td>
      <td class="dvtCellLabel" height="18px" align="center">领域权重</td>
      <td class="dvtCellLabel" height="18px" align="center">平分细则</td>
      <td class="dvtCellLabel" align="center">权重</td>
      <td class="dvtCellLabel" align="center">黑龙江成铁有限公司</td>
      <td class="dvtCellLabel" align="center">大同铸造有限公司</td>
      <td class="dvtCellLabel" align="center">青岛碣石有限公司</td>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td  rowspan="2" class="dvtCellInfo">管理</td>
      <td  rowspan="2" class="dvtCellInfo">5%</td>
      <td  class="dvtCellInfo">安全健康管理</td>
      <td  rowspan="2" class="dvtCellInfo">5%</td>
      <td  class="dvtCellInfo"><input type="text"></td>
      <td  class="dvtCellInfo"><input type="text"></td>
      <td  class="dvtCellInfo"><input type="text"></td>
    </tr>
    <tr>
      <td  class="dvtCellInfo">环境管理</td>
      <td  class="dvtCellInfo"><input type="text"></td>
      <td  class="dvtCellInfo"><input type="text"></td>
      <td  class="dvtCellInfo"><input type="text"></td>
    </tr>
    
    <tr>
      <td  rowspan="2" class="dvtCellInfo">业绩</td>
      <td  rowspan="2" class="dvtCellInfo">5%</td>
      <td  class="dvtCellInfo">经营业绩及产品地位</td>
      <td  rowspan="2" class="dvtCellInfo">5%</td>
      <td  class="dvtCellInfo"><input type="text"></td>
      <td  class="dvtCellInfo"><input type="text"></td>
      <td  class="dvtCellInfo"><input type="text"></td>
    </tr>    
    <tr>
      <td  class="dvtCellInfo">成交金额</td>
      <td  class="dvtCellInfo"><input type="text"></td>
      <td  class="dvtCellInfo"><input type="text"></td>
      <td  class="dvtCellInfo"><input type="text"></td>
    </tr>
    
    <tr>
      <td  rowspan="3" class="dvtCellInfo">技术</td>
      <td  rowspan="3" class="dvtCellInfo">10%</td>
      <td  class="dvtCellInfo">产品设计能力</td>
      <td  rowspan="3" class="dvtCellInfo">10%</td>
      <td  class="dvtCellInfo"><input type="text"></td>
      <td  class="dvtCellInfo"><input type="text"></td>
      <td  class="dvtCellInfo"><input type="text"></td>
    </tr>        
    <tr>
      <td  class="dvtCellInfo">技术支持能力</td>
      <td  class="dvtCellInfo"><input type="text"></td>
      <td  class="dvtCellInfo"><input type="text"></td>
      <td  class="dvtCellInfo"><input type="text"></td>
    </tr>
    <tr>
      <td  class="dvtCellInfo">产品技术水平</td>
      <td  class="dvtCellInfo"><input type="text"></td>
      <td  class="dvtCellInfo"><input type="text"></td>
      <td  class="dvtCellInfo"><input type="text"></td>
    </tr>
    
    <tr>
      <td  rowspan="5" class="dvtCellInfo">质量</td>
      <td  rowspan="5" class="dvtCellInfo">30%</td>
      <td  class="dvtCellInfo">ISO9000认证</td>
      <td  rowspan="5" class="dvtCellInfo">30%</td>
      <td  class="dvtCellInfo"><input type="text"></td>
      <td  class="dvtCellInfo"><input type="text"></td>
      <td  class="dvtCellInfo"><input type="text"></td>
    </tr>            
    <tr>
      <td  class="dvtCellInfo">质量管理体系</td>
      <td  class="dvtCellInfo"><input type="text"></td>
      <td  class="dvtCellInfo"><input type="text"></td>
      <td  class="dvtCellInfo"><input type="text"></td>
    </tr>
    <tr>
      <td  class="dvtCellInfo">产品质量水平</td>
      <td  class="dvtCellInfo"><input type="text"></td>
      <td  class="dvtCellInfo"><input type="text"></td>
      <td  class="dvtCellInfo"><input type="text"></td>
    </tr>
    <tr>
      <td  class="dvtCellInfo">客户抱怨处理配合度</td>
      <td  class="dvtCellInfo"><input type="text"></td>
      <td  class="dvtCellInfo"><input type="text"></td>
      <td  class="dvtCellInfo"><input type="text"></td>
    </tr>    
    <tr>
      <td  class="dvtCellInfo">产品使用情况</td>
      <td  class="dvtCellInfo"><input type="text"></td>
      <td  class="dvtCellInfo"><input type="text"></td>
      <td  class="dvtCellInfo"><input type="text"></td>
    </tr>  
    
    
  </tbody>
</table>
</tr>
                                                  
                                                  
                                                  <tr>
                                                    <td height="40" colspan="10" style="padding:5px"><div align="center">
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
                      </table>
                    </div></td>
                </tr>
              </tbody>
            </table>
   
</div>

</td></tr></tbody></table>
<!-- 网站底部 -->
<jsp:include page="../common/bottom.jsp" flush="true"/>
</body>
</html>
