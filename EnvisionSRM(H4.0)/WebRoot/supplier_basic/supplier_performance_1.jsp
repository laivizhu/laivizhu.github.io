<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<script language="javascript" type="text/javascript" src="../js/general.js"></script>
<div id="div1" class="small" style="width:100%;position:relative;">
  <form name="supplierConfirm" action="" >
    <table border="0" cellspacing="0" cellpadding="0" width="100%" class="lvtBg">
      <tbody>
        <tr>
          <td colspan="2" class="detailedViewHeader"><strong>供应商确认</strong> </td>
        </tr>
        <tr style="height:25px">
          <td width="40%" align="right" class="dvtCellLabel">供应商名称</td>
         <td width="60%" class="dvtCellInfo"  alitypeteamgn="left">
            <input type="text" name="suppliername" tabindex="" class="detailedViewTextBox"  style="width:30%;" value="" />
浏览供应商:   <img tabindex="2" src="../images/select.gif" alt="选择" title="选择" onclick="supplierChoose()" align="absmiddle" style="cursor:hand;cursor:pointer" /></td>
        </tr>
        <tr>
          <td colspan="8" style="padding:5px;" height="40" ><div align="center">
              <input title="确定 [Alt+S]" accesskey="S" class="crmbutton small save"  onclick="confirmChoise();" type="button" name="button" value="确定" style="width:70px" />
              &nbsp;
              <input title="取消 [Alt+X]" accesskey="X" class="crmbutton small cancel" onclick="javascript:reset()"  type="reset" name="button" value="  取消  " style="width:70px" />
            </div></td>
        </tr>
      </tbody>
    </table>
  </form>

<div id="supplierid" style="display:none">
 <jsp:include page="../common/choice_supplier.jsp" flush="true"/>
</div> 
<div style="margin-top:250px;"></div>

</div>
