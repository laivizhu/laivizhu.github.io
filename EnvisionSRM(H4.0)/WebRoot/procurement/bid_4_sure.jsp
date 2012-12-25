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
	function show1() {
		if (confirm("是否确认供应商招标文件?")) {
			alert("确认成功");
		} else {
			alert("确认取消");
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
    <td style="padding-left:15px;" nowrap="nowrap">您现在的位置： 采购项目管理管理 &gt; 年度招标 &gt; 招标文件有效性确认 </td>
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
    
  <table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
  <tbody>
    <tr>
      <td>
      <table border="0" cellspacing="0" cellpadding="3" width="100%" class="small">
      <tbody><tr>
        <td class="dvtTabCache" style="width:10px" nowrap="">&nbsp;</td>
        <td style="width:15%" align="center" class="dvtSelectedCell" id="bi" nowrap="nowrap">
         招标文件有效性确认        </td>
        <td class="dvtTabCache" style="width:100%;" nowrap="nowrap">&nbsp;</td>
		
       
       </tr></tbody>
       </table>              
      </td>
    </tr>
    <tr>
      <td valign="top" align="left">
		<div id="basicTab" style="display: block; ">
		  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="dvtContentSpace">
		  <tbody><tr>
		    <td align="left">
              <div class="calDIV" style="overflow:auto; width:100%; margin:10px auto;">
              <table border="0" cellspacing="1" cellpadding="3" width="100%" class="lvt small">
                <tbody>
                    <tr>
                      <td width="18%" class="lvtCol">供应商名称</td>
                      <td width="20%" class="lvtCol">招标文件</td>
                      <td width="6%" class="lvtCol">其他附件</td>
                      <td width="15%" class="lvtCol">备注</td>
                      <td width="14%" class="lvtCol">确认供应商文件</td>
                    </tr>
                  <tr bgcolor="white"  id="row_116" class="lvtColData">
                    <td>黑龙江成铁有限公司</td>
                    <td><a href="#">黑龙江成铁有限公司投标20121021</a></td>
                    <td><a href="#">说明文件</a></td>
                    <td><input type="textarea" name="备注" rows="10" cols="30" /></td>
                    <td>
                      <input type="radio" name="radio" id="radio" value="radio" />是 <input type="radio" name="radio" id="radio" value="radio" />否                    </td>
                  </tr>
                   <tr bgcolor="white"  id="row_116" class="lvtColData">
                      <td>大同铸造有限公司</td>
                      <td><a href="#">大同铸造有限公司20121021</a></td>
                      <td><a href="#">说明文件</a></td>
                      <td><input type="textarea" name="备注" rows="10" cols="30" /></td>
                      <td><input type="radio" name="radio" id="radio" value="radio" />是 <input type="radio" name="radio" id="radio" value="radio" />否 </td>
                    </tr>
                    <tr bgcolor="white"  id="row_116" class="lvtColData">
                      <td>青岛碣石有限公司</td>
                      <td><a href="#">青岛碣石有限公司20121021</a></td>
                      <td>无</td>
                      <td><input type="textarea" name="备注" rows="10" cols="30" /></td>
                      <td><input type="radio" name="radio" id="radio" value="radio" />是 <input type="radio" name="radio" id="radio" value="radio" />否</td>
                    </tr>
					<tr>
                       <td  height="40" bgcolor="#FFFFFF" colspan="10" style="padding:5px"><div align="center" style="height:30px;">
                             <input title="保存 [Alt+S]" accesskey="S" class="crmbutton small save" onclick="show2();" type="submit" name="button" value="保存" style="width:70px" />&nbsp;
                             <input title="取消 [Alt+X]" accesskey="X" class="crmbutton small cancel" onclick="window.location.href('bid_frame.jsp')" type="button" name="button" value="  取消  " style="width:70px" />
                       </div></td>
                    </tr>
                </tbody>
              </table>
              </div>         
           </td>
        </tr>
        </tbody>
        </table>
        </div>
      </td>
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
