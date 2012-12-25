<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<script language="javascript" type="text/javascript" src="../js/supplier/supplier_common.js"></script>
<script language="javascript">
	var parseTemplate = function(data){
		$.each(data,function(i,item){
			$("#standardTemplateID").append("<option value='"+item.id+"'>"+item.templateName+"</option>");
		});
	};
	var requestTemplate = function(){
		$.getJSON("securitTemplate_selectList.action",
			parseTemplate
		);	
	};
	

	$(document).ready(function(){
		requestTemplate();
		loadSupplier();
/* 		 houQian.submitForm($("#add"), "securit_add.action", function(data){
		  houQian.alert("发送保密协议成功");
		  $("#add").resetForm();
		}); */
		
		
		$("#standardTemplateID").change(function(){
		
			var value=$("#standardTemplateID").val();
			if(value=="-2"){
				$("#mars").css('display','');
			}else{
				$("#mars").css('display','none');
			}
		});
	});
	
	
</script>
<div id="div1" class="small" style="width:100%;position:relative;">
  <form id="#" enctype="multipart/form-data" action="securit_add.action" method="post" target="_parent">
    <input type="hidden" name="securitBean.supplierID" id="supplierInputId" />
    <table width="100%" align="center" cellpadding="3" cellspacing="0">
      <tr>
        <td class="detailedViewHeader"><b>发送保密协议</b></td>
      </tr>
    </table>
    <table border="0" cellspacing="0" cellpadding="0" width="100%" class="lvtBg">
      <tbody>
        <tr style="height:25px">
          <td width="37%" align="right" class="dvtCellLabel">采购项目名称（选填）</td>
          <td width="63%" align="left" class="dvtCellInfo"><input type="text" style="width:300px;" class="detailedViewTextBox" name="securitBean.name" /></td>
        </tr>
        <tr style="height:25px">
          <td align="right" class="dvtCellLabel">供应商名称</td>
          <td align="left" class="dvtCellInfo"><input type="text" style="width:300px;" class="detailedViewTextBox" disabled id="supplierNameInputId"/>
            浏览供应商: <img tabindex="2" src="../images/select.gif" alt="选择" title="选择" onClick="supplierChoose();" align="absmiddle" style="cursor:hand;cursor:pointer"/> <img src="../images/clear.gif" alt="清除" title="清除" onClick="" align="absmiddle" style="cursor:hand;cursor:pointer" /> </td>
        </tr>
        <tr style="height:25px">
          <td class="dvtCellLabel" align="right">标准保密协议模板</td>
          <td align="left" class="dvtCellInfo"><select id = "standardTemplateID" style="width:308px;" name="securitBean.securitTemplateID">
              <option value="-1" selected="selected">---请选择---</option>
              <option value="-2" >非标准协议模板</option>
            </select>
          </td>
        </tr>
      </tbody>
    </table>
    
    
    <div id="mars" style="display:none;">
      <table border="0" cellspacing="0" cellpadding="0" width="100%" class="lvtBg">
        <tbody>
          <tr style="height:25px">
            <td width="37%" align="right" class="dvtCellLabel">非标准保密协议模板</td>
            <td width="63%" align="left" class="dvtCellInfo"><input type="file" style="width:308px;" name="upload"/></td>
          </tr>
        </tbody>
      </table>
    </div>
    
    
    
    <table border="0" cellspacing="0" cellpadding="0" width="100%" class="lvtBg">
      <tbody>
        <tr style="height:25px">
          <td width="37%" align="right" class="dvtCellLabel">备注</td>
          <td width="63%" align="left" class="dvtCellInfo"><textarea style="width:303px;overflow-y:auto;" name="securitBean.remark"></textarea></td>
        </tr>
        <tr>
          <td colspan="10" style="padding:5px" height="40px;"><div align="center">
              <input title="发送 [Alt+S]" accesskey="S" class="crmbutton small save" type="submit" name="button2" value="发送" style="width:70px" />
              &nbsp;
              <input title="取消 [Alt+X]" accesskey="X" class="crmbutton small cancel" onClick="requestTemplate();"  type="button" name="button" value="  取消  " style="width:70px" />
          </div></td>
        </tr>
      </tbody>
    </table>
  </form>
</div>
<jsp:include page="../common/choice_supplier.jsp" flush="true"/>
