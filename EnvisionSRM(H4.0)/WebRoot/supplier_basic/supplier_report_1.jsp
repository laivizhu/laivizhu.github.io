<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<script language="javascript" type="text/javascript" src="../js/general.js"></script>
<script language="javascript">
	function supplierChoose() {
		$("#supplier").dialog({
			autoOpen : false,
			title : "选择供应商",
			modal : true,
			width : 800,
			height : 500,
			resizable : false,
		});

		$("#supplier").dialog("open");
	}
</script>
<div id="div1" class="small" style="width:100%;position:relative;">
  <form name="contractConfirm" action="" >
    <table width="100%" align="center" cellpadding="3" cellspacing="0"><tr>
    	<td class="detailedViewHeader"><b>发送改善对策报告书</b></td>
    </tr></table>
    <table border="0" cellspacing="0" cellpadding="0" width="100%" class="lvtBg">
      <tbody>
        
        <tr style="height:25px">
          <td width="20%" align="right" class="dvtCellLabel">供应商名称</td>
          <td width="30%" align="left" class="dvtCellInfo">
              <input type="text" style="width:60%;" class=" " />
              浏览供应商: 
              <img tabindex="2" src="../images/select.gif" alt="选择" title="选择" onclick="supplierChoose()" align="absmiddle" style="cursor:hand;cursor:pointer"/> 
              <img src="../images/clear.gif" alt="清除" title="清除" onclick="" align="absmiddle" style="cursor:hand;cursor:pointer" />          </td>
          <td align="right" class="dvtCellLabel">远景内部负责部门</td>
          <td align="left" class="dvtCellInfo"><input name="" type="radio" value="" />
            采购部 &nbsp;
            <input name="" type="radio" value="" />
            质量工程部 </td>
        </tr>

        <tr style="height:25px">
          <td align="right" class="dvtCellLabel">零部件名称</td>
          <td align="left" class="dvtCellInfo"><input type="text" style="width:60%;" class=" " /></td>
          <td align="right" class="dvtCellLabel">图纸编号</td>
          <td align="left" class="dvtCellInfo"><input type="text" style="width:60%;" class=" " /></td>
        </tr>
        
        <tr style="height:25px">
          <td align="right" class="dvtCellLabel">部件序列号</td>
          <td align="left" class="dvtCellInfo"><input type="text" style="width:60%;" class=" " /></td>
          <td align="right" class="dvtCellLabel">缺陷等级</td>
          <td align="left" class="dvtCellInfo"><input type="text" style="width:60%;" class=" " /></td>
        </tr>
        
        <tr style="height:25px">
          <td align="right" class="dvtCellLabel">图纸版本号</td>
          <td align="left" class="dvtCellInfo"><input type="text" style="width:60%;" class=" " /></td>
          <td align="right" class="dvtCellLabel">发现地点</td>
          <td align="left" class="dvtCellInfo"><input type="text" style="width:60%;" class=" " /></td>
        </tr>
        
        <tr style="height:25px">
          <td align="right" class="dvtCellLabel">发现人员</td>
          <td align="left" class="dvtCellInfo"><input type="text" style="width:60%;" class=" " /></td>
          <td align="right" class="dvtCellLabel">发生时间</td>
          <td align="left" class="dvtCellInfo"><input type="text" style="width:60%;" class=" " /></td>
        </tr>
        
        <tr style="height:25px">
          <td class="dvtCellLabel" align="right">上传改善对策报告书</td>
          <td align="left" class="dvtCellInfo"><input type="file" style="width:82%;"/></td>
          <td class="dvtCellLabel" align="right">附件(图片、视频、相关文件等)</td>
          <td align="left" class="dvtCellInfo"><input type="file" style="width:82%;"/></td>
        </tr>
        <tr style="height:25px">
          <td align="right" class="dvtCellLabel">潜在影响范围</td>
          <td align="left" class="dvtCellInfo"><input type="text" style="width:60%;" class=" " /></td>
          <td class="dvtCellLabel" align="right">问题描述</td>
          <td align="left" class="dvtCellInfo"><textarea style="width:60%;overflow-y:auto;"></textarea></td>
        </tr>
        
        <tr>
          <td colspan="10" height="40px;" style="padding:5px"><div align="center">
            <input title="确定 [Alt+S]" accesskey="S" class="crmbutton small save"  onclick="show2();" type="submit" name="button2" value="确定" style="width:70px" />
            &nbsp;
              <input title="取消 [Alt+X]" accesskey="X" class="crmbutton small cancel" onclick="window.location.href('supplier_report.jsp')"  type="button" name="button" value="  取消  " style="width:70px" />
            </div></td>
        </tr>
      </tbody>
    </table>
  </form>
</div>

<div id="supplier" style="display:none">
 <jsp:include page="../common/choice_supplier.jsp" flush="true"/>
</div> 