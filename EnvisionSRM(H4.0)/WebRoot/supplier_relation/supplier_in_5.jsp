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
<div id="div5" class="small" style="width:100%;position:relative;display:none;">
  <form name="contractApproval" action="#" >
	<table border="0" align="center" cellspacing="1" cellpadding="3" width="99%" class="lvtBg">
       <tbody>
                      <tr style="height:25px">
                        <td width="37%" align="right" class="dvtCellLabel">供应商名称</td>
                        <td width="63%" colspan="2" align="left" bgcolor="#FFFFFF">
                        <input type="text" style="width:300px;" class="detailedViewTextBox" />
                        浏览供应商: 
                        <img tabindex="2" src="../images/select.gif" alt="选择" title="选择" onclick="supplierChoose()" align="absmiddle" style="cursor:hand;cursor:pointer"/> 
                        <img src="../images/clear.gif" alt="清除" title="清除" onclick="" align="absmiddle" style="cursor:hand;cursor:pointer" /> 
                        </td>
                      </tr>
                   </tbody>             
    </table>
    <table border="0" align="center" cellspacing="1" cellpadding="3" width="99%" class="lvt small">
                   <tbody>
                      <!--字段-->
                      <tr>
                        <td width="9%" nowrap="nowrap" class="lvtCol">领域</td>
                        <td width="80%" nowrap="nowrap" class="lvtCol">指标</td>
                        <td width="11%" nowrap="nowrap" class="lvtCol">得分</td>
                      </tr>
                      <!--M管理-->
                      <tr>
                        <td height="19px;" rowspan="3" nowrap="nowrap" class="lvtColData">需求</td>
                        <td height="19px;" class="lvtColData" nowrap="nowrap">1. 贵公司对远景的销售额占总销售的比重是多少?</td>
                        <td class="lvtColData">4</td>
                      </tr>
                      <tr>
                        <td height="19px;" class="lvtColData" nowrap="nowrap">2. 相比其他客户，远景的需求量的稳定性?</td>
                        <td height="19px;" class="lvtColData">5</td>
                      </tr>
                      <tr>
                        <td height="19px;" class="lvtColData">3. 远景的需求量的增长</td>
                        <td height="19px;"  class="lvtColData">3</td>
                      </tr>
                      <tr>
                        <td height="19px;" rowspan="2" class="lvtColData">合同 </td>
                        <td height="19px;" class="lvtColData">4.远景提供给贵公司的采购价格水平如何?</td>
                        <td height="19px;" class="lvtColData">3</td>
                      </tr>
                      <tr>
                        <td height="19px;" class="lvtColData">5.远景提供给贵公司合同条款如何?</td>
                        <td height="19px;" class="lvtColData">5</td>
                      </tr>
                      <tr>
                        <td height="19px;" rowspan="4" class="lvtColData">附加值</td>
                        <td height="19px;" class="lvtColData" nowrap="nowrap">6.远景是否愿意与贵公司共同承担投资/投入（包括人力资源）?</td>
                        <td height="19px;" class="lvtColData">5</td>
                      </tr>
                      <tr>
                        <td height="19px;" class="lvtColData">7.远景合作对贵公司的业务拓展有多少影响?</td>
                        <td height="19px;" class="lvtColData">5</td>
                      </tr>
                      <tr>
                        <td height="19px;" class="lvtColData" nowrap="nowrap">8.远景对贵公司未来发展（技术、管理）的影响程度是?</td>
                        <td height="19px;" class="lvtColData">5</td>
                      </tr>
                      <tr>
                        <td height="19px;" class="lvtColData" nowrap="nowrap">9.远景对贵公司各项工作的配合度</td>
                        <td height="19px;" class="lvtColData">5</td>
                      </tr>
                      <tr>
                        <td bgcolor="#FFFFFF" colspan="11" height="40" style="padding:5px"><div align="center">
                            <input title="确定 [Alt+S]" accesskey="S" class="crmbutton small save"  onclick="show2();" type="submit" name="button" value="确定" style="width:70px" />&nbsp;
                            <input title="取消 [Alt+X]" accesskey="X" class="crmbutton small cancel" onclick="window.location.href('supplier_in.jsp')"  type="button" name="button" value="  取消  " style="width:70px" />
                          </div></td>
                      </tr>
                    </tbody>
    </table>              
  </form>
</div>

<div id="supplier" style="display:none">
  <jsp:include page="../common/choice_supplier.jsp" flush="true"/>
</div>
