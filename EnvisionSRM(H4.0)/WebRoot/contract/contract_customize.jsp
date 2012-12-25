<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>合同管理-采购平台</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <jsp:include page="../common/basicInclude.jsp" />
<script language="javascript" type="text/javascript" src="../js/supplier/supplier_common.js"></script>
<script language="javascript">
var id0=0;
 $(document).ready(function(e) {
		$("#diviationEdit").dialog({
			autoOpen: false,
			title: "偏差编辑",
			modal:true,
			width:800,
			height:500,
			resizable:false,
            
		});
		
		loadSupplier();
		
		$("#diviation_changeId").dialog({
			autoOpen: false,
		//	title: "新增偏差",
			modal:true,
			width:800,
			height:500,
			resizable:false,
            
		});
		
		$("#diviation_insertId").dialog({
			autoOpen: false,
		//	title: "新增偏差",
			modal:true,
			width:800,
			height:500,
			resizable:false,   
		});
		
		$("#submitBtn").click(function(){
			var form = $("#contractAddForm");
			form.ajaxForm({
				async: false,//async:false 同步请求
				url:"frameContract_add.action",
				beforeSubmit:validate,
				//dataType:"json",
				success:function(returnData){
					var data = $.parseJSON(returnData);
					if(data.success==true){
						alert(data.msg);
					    window.location.href = "frame_contract.jsp";
					}else{
						alert(data.msg);
					}
					
				}
			});
		});
    });
	

	function validate(formData, jqForm, options) {
		var diviationId = $("#diviationHead").val();
		var secrecy = $("#secrecy").val();
		var secrecyFormat = $("#secrecy").val().split(".");
		var price = $("#price").val();
		var priceFormat = $("#price").val().split(".");
		var quanlity = $("#quanlity").val();
		var purchaseInstruction = $("#purchaseInstruction").val();
		var technology = $("#technology").val();
		var supervision = $("#supervision").val();
		var logistic = $("#logistic").val();
		var ehs = $("#ehs").val();
		if (diviationId.length <= 0) {
			alert("偏差不能为空！");
			return false;
		}
		if (secrecy == "") {
			alert("保密协议不能为空！");
			return false;
		}
		if (secrecyFormat[secrecyFormat.length - 1] != 'pdf') {
			alert("保密协议文件格式必须为pdf！");
			return false;
		}
		if (price == "") {
			alert("价格协议不能为空！");
			return false;
		}
		var priceFormatValue=priceFormat[priceFormat.length - 1];
		if (priceFormatValue != 'xls' & priceFormatValue != 'xlsx') {
			alert("价格协议文件格式必须为excel！");
			return false;
		}
		if (quanlity == "") {
			if ($("#quanlityRemark").val().length <= 0) {
				alert("若无质量协议,请填写备注！");
				return false;
			} 
		}else {
				var quanlity1 = $("input[name='quanlity']");
				for ( var i = 0; i < quanlity1.length; i++) {
					var temp = quanlity1[i].value.split(".");
					if (temp[temp.length - 1] != "pdf") {
						alert("质量协议文件格式必须为pdf！");
						return false;
					}
				}
			}
		if (purchaseInstruction == "") {
			if ($("#purchaseInstructionRemark").val().length <= 0) {
				alert("若无采购说明书协议,请填写备注！");
				return false;
			}
		} else {
				var purchaseInstruction1 = $("input[name='purchaseInstruction']");
				for ( var i = 0; i < purchaseInstruction1.length; i++) {
					var temp = purchaseInstruction1[i].value.split(".");
					if (temp[temp.length - 1] != "pdf") {
						alert("采购说明协议文件格式必须为pdf！");
						return false;
					}
				}
			}
		if (technology == "") {
			if ($("#technologyRemark").val().length <= 0) {
				alert("若无技术协议,请填写备注！");
				return false;
			}
		} else {
				var technology1 = $("input[name='technology']");
				for ( var i = 0; i < technology1.length; i++) {
					var temp = technology1[i].value.split(".");
					if (temp[temp.length - 1] != "pdf") {
						alert("技术协议文件格式必须为pdf！");
						return false;
					}
				}
			}
		if (supervision == "") {
			if ($("#supervisionRemark").val().length <= 0) {
				alert("若无监造协议,请填写备注！");
				return false;
			}
		} else {
				var supervision1 = $("input[name='supervision']");
				for ( var i = 0; i < supervision1.length; i++) {
					var temp = supervision1[i].value.split(".");
					if (temp[temp.length - 1] != "pdf") {
						alert("监造协议文件格式必须为pdf！");
						return false;
					}
				}
			}
		if (logistic == "") {
			if ($("#logisticRemark").val().length <= 0) {
				alert("若无物流协议,请填写备注！");
				return false;
			}
		} else {
				var logistic1 = $("input[name='logistic']");
				for ( var i = 0; i < logistic1.length; i++) {
					var temp = logistic1[i].value.split(".");
					if (temp[temp.length - 1] != "pdf") {
						alert("物流协议文件格式必须为pdf！");
						return false;
					}
				}
			}
		if (ehs == "") {
			if ($("#ehsRemark").val().length <= 0) {
				alert("若无EHS协议,请填写备注！");
				return false;
			}
		} else {
				var ehs1 = $("input[name='ehs']");
				for ( var i = 0; i < ehs1.length; i++) {
					var temp = ehs1[i].value.split(".");
					if (temp[temp.length - 1] != "pdf") {
						alert("EHS协议文件格式必须为pdf！");
						return false;
					}
				}
			}
	}
	
function showDiviationEditDialog() {
	if ("" == $("#supplierInputId").val()) {
		alert("请选择供应商");
	} else {
		if (0 == id0) {
			alert("请选择年度合同");
		} else {
			var dialog = $("#diviationEdit");
			$("#yearContractId").val(id0);
			var id = $("#yearContractId").val();
			dialog.dialog("open");
			$("#diviation_changeId").dialog("close");
			$("#diviation_insertId").dialog("close");
			$
					.getJSON(
							"yearContract_diviationList.action",
							{
								id : "" + id,
								rand : Math.random()
							},
							function(data) {
								$("#diviationList").empty();
								$("#diviationList")
										.append(
												"<tr class='detailedViewHeader'><td width='15%' height='30'><b>序号</b></td><td width='40%'><b>预览</b></td><td width='40%'><b>偏差</b></td><td width='5%'><b>操作</b></td></tr>");
								$
										.each(
												data.root,
												function(i, item) {
													$("#diviationList")
															.append(
																	"<tr><td class='dvtCellInfo'>"
																			+ item.projectnumber
																			+ "</td><td class='dvtCellInfo'>"
																			+ item.contentold
																			+ "</td><td class='dvtCellInfo'><textarea class='textarea_style'>"
																			+ item.contentnew
																			+ "</textarea></td><td class='dvtCellInfo'><a href='#' onclick='diviationDelete("
																			+ item.id
																			+ ","
																			+ id
																			+ ")'>删除</a></td></tr>");
												});
							});

		}
	}
}

	function showDiviationChangeDialog() {
		var dialog = $("#diviationEdit");
		$("#yearContractId").val(id0);
		dialog.dialog("open");
		$("#diviation_changeId").dialog("close");
		$("#diviation_insertId").dialog("close");
		var id = $("#yearContractId").val();
		var projectnum = $("#diviationid").val();
		var contentold = $("#wordcontent").val();
		var contentnew = $("#diviationContent").val();
		$
				.getJSON(
						"yearContract_diviationSave.action",
						{
							id : "" + id,
							projectnum : "" + projectnum,
							contentold : encodeURI("" + contentold, "utf-8"),
							contentnew : "" + encodeURI(contentnew, "utf-8"),
							rand : Math.random()
						},
						function(data) {
							$("#diviationList").html("");
							$("#diviationList")
									.append(
											"<tr class='detailedViewHeader'><td width='15%' height='30'><b>序号</b></td><td width='40%'><b>预览</b></td><td width='40%'><b>偏差</b></td><td width='5%'><b>操作</b></td></tr>");
							showDiviationEditDialog();
						});

	}
	function showDiviationInsertDialog() {
		var dialog = $("#diviationEdit");
		$("#yearContractId").val(id0);
		dialog.dialog("open");
		$("#diviation_changeId").dialog("close");
		$("#diviation_insertId").dialog("close");
		var id = $("#yearContractId").val();
		var projectnum = $("#newid").val();
		var contentold = "";
		var contentnew = $("#diviationContent1").val();
		$
				.getJSON(
						"yearContract_diviationInsertSave.action",
						{
							id : "" + id,
							projectnum : "" + projectnum,
							contentold : encodeURI("" + contentold, "utf-8"),
							contentnew : "" + encodeURI(contentnew, "utf-8"),
							rand : Math.random()
						},
						function(data) {
							$("#diviationList").html("");
							$("#diviationList")
									.append(
											"<tr class='detailedViewHeader'><td width='15%' height='30'><b>序号</b></td><td width='40%'><b>预览</b></td><td width='40%'><b>偏差</b></td><td width='5%'><b>操作</b></td></tr>");
							showDiviationEditDialog();
						});
	}
	function diviationDelete(id, projectnum) {
		$
				.getJSON(
						"yearContract_diviationDelete.action",
						{
							id : "" + id,
							projectnum : "" + projectnum,
							rand : Math.random()
						},
						function(data) {
							$("#diviationList").html("");
							$("#diviationList")
									.append(
											"<tr class='detailedViewHeader'><td width='15%' height='30'><b>序号</b></td><td width='40%'><b>预览</b></td><td width='40%'><b>偏差</b></td><td width='5%'><b>操作</b></td></tr>");
							showDiviationEditDialog();
						});
	}
	//新增偏差
	function changediviation() {
		$("#diviationEdit").dialog("close");
		$("#diviation_changeId").dialog("open");
		var id = $("#yearContractId").val();
		$.getJSON("yearContract_diviationAdd.action", {
			id : "" + id,
			rand : Math.random()
		}, function(data) {
			$("#diviationid").empty();
			$.each(data.root, function(i, item) {
				$("#diviationid").append(
						"<option value='"+item.projectnumber+"'>"
								+ item.projectnumber + "</option>");
			});
		});
	}
	function changedetail() {
		projectnum = $("#diviationid").val();
		var id = $("#yearContractId").val();
		$.getJSON("yearContract_wordcontentGet.action", {
			id : "" + id,
			projectnum : "" + projectnum,
			rand : Math.random()
		}, function(data) {
			$("#wordcontent").val(data.wordContent);
		});

	}
	//插入偏差
	function insertdiviation() {
		$("#diviationEdit").dialog("close");
		$("#diviation_insertId").dialog("open");
		var id = $("#yearContractId").val();
		$.getJSON("yearContract_diviationInsert.action", {
			id : "" + id,
			rand : Math.random()
		}, function(data) {
			$("#diviationid1").empty();
			$.each(data.root, function(i, item) {
				$("#diviationid1").append(
						"<option value='"+item.projectnumber+"'>"
								+ item.projectnumber + "</option>");
			});
		});
	}
	function changediviationid() {
		projectnum = $("#diviationid1").val();
		var id = $("#yearContractId").val();
		$.getJSON("yearContract_newIdGet.action", {
			id : "" + id,
			projectnum : "" + projectnum,
			rand : Math.random()
		}, function(data) {
			$("#newid").val(data.newId);
		});
	}
	//保存
	function confirmDiviation() {
		$("#diviationEdit").dialog("close");
		$("#diviation_changeId").dialog("close");
		$("#diviation_insertId").dialog("close");
		var id = $("#yearContractId").val();
		var supplierId = $("#supplierInputId").val();
		var version = "01";
		var name = "偏差V01";
		$.getJSON("yearContract_diviationHeadSave.action", {
			id : "" + id,
			projectnum : "" + version,
			supplierId : "" + supplierId,
			rand : Math.random()
		}, function(data) {
			$("#diviationHead").val(data.diviationId);
			$("#diviationName").val(name);
		});
	}
	function diviationCancel() {
		$("#diviationEdit").dialog("open");
		$("#diviation_changeId").dialog("close");
		$("#diviation_insertId").dialog("close");
	}

	var i = 1;
	function addFile(dvID, inputNamePrefix) {
		var dv = document.getElementById(dvID);
		var file = document.createElement("input");
		file.type = "file";
		file.className = "detailedViewTextBox";
		file.style.width = "400px";
		file.style.height = "22px";
		file.id = inputNamePrefix + i;
		file.name = inputNamePrefix;

		dv.appendChild(file);

		var btn = document.createElement("input");
		btn.type = "button";
		btn.id = btn.name = "btn" + i;
		btn.value = "删除";

		btn.onclick = function() {
			var b = document.getElementById(btn.id);
			dv.removeChild(b.nextSibling); //remove <BR>
			dv.removeChild(b.previousSibling); //file
			dv.removeChild(b); //btn
		}

		dv.appendChild(btn);

		dv.appendChild(document.createElement("BR"));

		i++;
	}

	function choise_type() {
		var type = $("#yearContractType").val();
		$.getJSON("yearContract_choise.action", {
			type : "" + type
		}, function(data) {
			if (data.yearContractChoise) {
				$("#yearContractName").val(data.yearContractName);
				id0 = data.yearContractId;
				$("#yearcontractId").val(id0);
			} else {
				$("#yearContractName").val("");
				alert("无法找到年度合同");
			}
		});
	}
	function clearSupplier() {
		$("#supplierNameInputId").val("");
		$("#supplierInputId").val("");
	}
</script>
<style type="text/css">
<!--

.STYLE1 {color: red; font-size: 12; }
-->
</style>
</head>

<body class="small" style="margin:0;">
<!-- 网站顶部 -->
<jsp:include page="../common/top.jsp" flush="true"/>

<!-- 网站导航 -->
<jsp:include page="../common/navigation.jsp" flush="true"/>

<!-- 二级菜单 -->
<table border="0" cellpadding="0" width="100%" class="level2Bg">
<tbody><tr>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_maincontractlist.jsp">年度合同模板</a></td>
      <td class="level2SelTab" nowrap="nowrap"><a href="frame_contract.jsp">框架合同</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_modify.jsp">合同变更</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_cancel.jsp">合同取消</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_compliance.jsp">合同合规</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_query.jsp">合同查询</a></td>
      <td class="level2UnSelTab" nowrap="nowrap"><a href="contract_setting.jsp">参数设置</a></td>
    <td width="100%">&nbsp;</td>
</tr></tbody>
</table>

<!-- 工具栏 -->
<table border="0" cellspacing="0" width="100%" class="homePageButtons">
<tbody><tr>
    <td style="padding-left:15px;" nowrap="nowrap">您现在的位置： 合同管理 &gt; 框架合同 &gt; 新建框架合同</td>
	<td width="100%" align="center">&nbsp;</td>
    <td align="right" style="padding-right:15px;">
        <jsp:include page="../common/toolbar.jsp" flush="true"/>
    </td>
</tr></tbody>
</table>


<!-- 网站中部 -->
<table width="100%" class="showPanelBg" cellpadding="0" cellspacing="0" border="0" align="center" >
<tbody>
<tr>
  <td width="100%" align="left" valign="top">
<!-- -->
<div class="contentViewDiv">
<form id="contractAddForm" enctype="multipart/form-data" method="post"  >
<input type="hidden" name="contractBean.yearcontractId" id="yearcontractId" value=""/>  
<table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
<tbody><tr>
<td>
<table border="0" cellspacing="0" cellpadding="3" width="100%" class="small">
<tbody><tr>
  <td class="dvtTabCache" style="width:10px" >&nbsp;</td>
<td style="width:15%" align="center" class="dvtSelectedCell" id="bi" onclick="fnLoadValues('bi','mi','basicTab','moreTab','normal','Contacts')"><b>新建框架合同</b></td>
<td class="dvtTabCache" style="width:85%">&nbsp;</td>
</tr><tr>
</tr></tbody></table>
</td>
</tr>
<tr>
<td valign="top" align="left">

<div id="basicTab" style="display: block; ">

<table border="0" cellspacing="0" cellpadding="3" width="100%" class="dvtContentSpace">
<tbody><tr>
<td align="left">


<table border="0" cellspacing="0" cellpadding="0" width="100%">
<tbody><tr>
<td id="autocom"></td>
</tr>
<tr>
<td style="padding:10px">
<!-- General details -->
<table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
<tbody>
  <tr style="height:25px">
    <td ><table border="0" cellspacing="0" cellpadding="0" width="100%" class="small">
      <tbody>
       
        <tr>
          <td colspan="6" class="detailedViewHeader"><b>供应商信息</b></td>
        </tr>
        <tr style="height:25px">
          <td width="19%" class="dvtCellLabel" align="right">供应商名称</td>
          <td colspan="5" align="left" class="dvtCellInfo"><input type="text" id="supplierNameInputId" name="lastname2" class="detailedViewTextBox" style="width:250px;" value="" readonly="readonly" /><input type="hidden" id="supplierInputId" name="contractBean.supplierId" value="" />
            浏览供应商:
            <img tabindex="2" src="../images/select.gif" alt="选择" title="选择" onclick="supplierChoose()" align="absmiddle" style="cursor:hand;cursor:pointer">
            <img src="../images/clear.gif" alt="清除" title="清除" language="javascript" onclick="clearSupplier()" align="absmiddle" style="cursor:hand;cursor:pointer">          </td>
          <!-- Non Editable field, only configured value will be loaded -->          </tr>
       
        <tr>
          <td colspan="6" class="detailedViewHeader"><b>主合同条款</b></td>
        </tr>
         <tr style="height:25px">
          <td width="19%" class="dvtCellLabel" align="right">年度合同类型</td>
          <td width="42%" colspan="" align="left" valign="middle" class="dvtCellInfo">
            <select id="yearContractType" style="width:250px;height:22px; font-size:12px" onchange="choise_type()">
              <option value="">---请选择---</option>
              <option value="0">生产性物料年度合同模板</option>
              <option value="1">非生产性物料年度合同模板</option>
            </select>
          </td>
          <td width="19%" align="right" valign="middle" class="dvtCellLabel">当前年度合同</td>
          <td colspan="" align="left" valign="middle" class="dvtCellInfo">
            <input type="text" id="yearContractName" style="font-size:12px;" name="yearContractName" value="" readonly="readonly"/> 
          </td>
         </tr>
         <tr>
          <td colspan="6" class="detailedViewHeader"><b>合同附件信息 </b>(注：*号表示必须填写项)</td>
        </tr>
         <tr style="height:25px">
          <td width="19%" height="25" align="right" class="dvtCellLabel"><font color="red"></font></td>
          <td colspan="2" align="left" class="dvtCellInfo"><b>附件文件</b></td>
          <td width="25%" align="left" class="dvtCellInfo"><b>备注说明</b></td>
        </tr>
         <tr style="height:25px">
          <td width="19%" height="28" align="right" class="dvtCellLabel"><font color="red"></font>*偏差</td>
          <td colspan="2" align="left" class="dvtCellInfo">
          <input type="hidden" name="diviationHead" id="diviationHead" value="" /><input type="text" style="width:250px" name="diviationName" id="diviationName" value="" readonly="readonly"/>&nbsp;&nbsp;&nbsp;
            <input type="button" value="编辑偏差" style="font-size:12px;height:22px;" onclick="showDiviationEditDialog()"/></td>
          <td width="25%" align="left" class="dvtCellInfo"><input type="text" name="diviationRemark" id="diviationRemark" style="width:80%"/></td>
        </tr>
          <tr style="height:25px">
          <td class="dvtCellLabel" align="right"><font color="red"></font>*保密协议</td>
          <td colspan="2"  align="left" class="dvtCellInfo"><input type="file" accept="application/pdf" name="secrecy" id="secrecy" class="detailedViewTextBox" style="width:400px; height:22px" value="" />
           &nbsp; &nbsp;&nbsp;
            <select name="secrecyType" id="secrecyType" style="font-size:12px;height:22px;">
              <option value="">---请选择---</option>
              <option value="1">标准保密协议</option>
              <option value="0">非标准保密协议</option>
            </select></td>
          <td  align="left" class="dvtCellInfo"><input type="text" name="secrecyRemark" id="secrecyRemark" style="width:80%"/></td>
        </tr>
          <tr style="height:25px">
          <td class="dvtCellLabel" align="right"><font color="red"></font>*价格协议</td>
          <td colspan="2" align="left" class="dvtCellInfo"><input type="file" name="price" id="price" class="detailedViewTextBox" style="width:400px; height:22px" value="" />            &nbsp; &nbsp;&nbsp;&nbsp;<span class="STYLE1">(文件格式必须为excel)</span>
          </td>
          <td align="left" class="dvtCellInfo"><input type="text" name="priceRemark" id="priceRemark" style="width:80%"/></td>
        </tr>
         <tr style="height:25px">
          <td class="dvtCellLabel" align="right"><font color="red"></font>质量协议</td>
          <td colspan="2" align="left" valign="top" class="dvtCellInfo"><input type="file" name="quanlity" id="quanlity" class="detailedViewTextBox" style="width:400px; height:22px" value="" />            &nbsp; &nbsp;&nbsp;&nbsp;
            <input type="button" value="继续添加" style="font-size:12px" onclick="addFile('quanlity1','quanlity')" />
            <div id="quanlity1"></div>
          </td>
          <td align="left" class="dvtCellInfo"><input type="text" name="quanlityRemark" id="quanlityRemark" style="width:80%"/>
          </td>
         </tr>
         <tr style="height:25px">
          <td class="dvtCellLabel" align="right"><font color="red"></font>采购说明书</td>
          <td colspan="2" align="left" valign="top" class="dvtCellInfo"><input type="file" name="purchaseInstruction" id="purchaseInstruction" class="detailedViewTextBox" style="width:400px; height:22px" value="" />            &nbsp; &nbsp;&nbsp;&nbsp;
            <input type="button" value="继续添加" style="font-size:12px" onclick="addFile('purchaseExplaintion','purchaseInstruction')" />
            <div id="purchaseExplaintion"></div>
          </td>
          <td align="left" class="dvtCellInfo"><input type="text" name="purchaseInstructionRemark" id="purchaseInstructionRemark" style="width:80%"/></td>
        </tr>
         <tr style="height:25px">
          <td class="dvtCellLabel" align="right"><font color="red"></font>技术协议</td>
          <td colspan="2" align="left" valign="top" class="dvtCellInfo"><input type="file" name="technology" id="technology" class="detailedViewTextBox" style="width:400px; height:22px" value="" />            &nbsp; &nbsp;&nbsp;&nbsp;
            <input type="button" value="继续添加" style="font-size:12px" onclick="addFile('techExplaintion','technology')" />
            <div id="techExplaintion"></div>
          </td>
          <td align="left" class="dvtCellInfo"><input type="text" name="technologyRemark" id="technologyRemark" style="width:80%"/></td>
        </tr>
         <tr style="height:25px">
          <td height="25" align="right" class="dvtCellLabel"><font color="red"></font>监造协议</td>
          <td colspan="2" align="left" valign="top" class="dvtCellInfo"><input type="file" name="supervision" id="supervision"  class="detailedViewTextBox" style="width:400px; height:22px" value="" />            &nbsp; &nbsp;&nbsp;&nbsp;
            <input type="button" value="继续添加" style="font-size:12px" onclick="addFile('mactualExplaintion','supervision')" />
            <div id="mactualExplaintion"></div>
          </td>
          <td align="left" class="dvtCellInfo"><input type="text" name="supervisionRemark" id="supervisionRemark" style="width:80%"/></td>
         </tr>
          <tr style="height:25px">
          <td class="dvtCellLabel" align="right"><font color="red"></font>物流协议</td>
          <td colspan="2" align="left" class="dvtCellInfo"><input type="file" name="logistic" id="logistic" class="detailedViewTextBox" style="width:400px; height:22px" value="" />            &nbsp; &nbsp;&nbsp;&nbsp;
            <input type="button" value="继续添加" style="font-size:12px" onclick="addFile('transportation','logistic')" />
            <div id="transportation"></div>
          </td>
          <td align="left" class="dvtCellInfo"><input type="text" name="logisticRemark" id="logisticRemark" style="width:80%"/></td>
        </tr>
        <tr style="height:25px">
          <td class="dvtCellLabel" align="right"><font color="red"></font>EHS协议</td>
          <td colspan="2" align="left" class="dvtCellInfo"><input type="file" name="ehs" id="ehs" class="detailedViewTextBox" style="width:400px; height:22px" value="" />            &nbsp; &nbsp;&nbsp;&nbsp;
            <input type="button" value="继续添加" style="font-size:12px" onclick="addFile('EHS','ehs')" />
            <div id="EHS"></div>
          </td>
          <td align="left" class="dvtCellInfo"><input type="text" name="ehsRemark" id="ehsRemark" style="width:80%"/></td>
        </tr>
        <tr>
          <td colspan="6" style="padding:5px" height="40"><div align="center">
            <input id="submitBtn" title="保存 [Alt+S]" accesskey="S" class="crmbutton small save" onclick="" type="submit" name="button" value="  保存  " style="width:70px" />
            &nbsp;
            <input title="取消 [Alt+X]" accesskey="X" class="crmbutton small cancel" onclick="window.history.back()" type="button" name="button" value="  取消  " style="width:70px" />
          </div></td>
        </tr>
      </tbody>
    </table></td>
  </tr>
</tbody></table></td>
</tr>
</tbody></table>
</td>
</tr>
</tbody></table>
</div>
<!-- Basic Information Tab Closed -->


</td>
</tr>
</tbody></table>
</form>
</div>
</td></tr></tbody></table>

<div id="diviationEdit" style="display:none">
 <jsp:include page="diviation_edit.jsp" flush="true"/>
</div> 
<div id="diviation_changeId" style="display:none">
 <jsp:include page="diviation_change.jsp" flush="true"/>
</div> 
<div id="diviation_insertId" style="display:none">
 <jsp:include page="diviation_insert.jsp" flush="true"/>
</div> 

<jsp:include page="../common/choice_supplier.jsp" flush="true"/>


<!-- 网站底部 -->

<jsp:include page="../common/bottom.jsp" flush="true"/>


</body>
</html>