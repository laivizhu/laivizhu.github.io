<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="div1" class="small" style="width:100%;position:relative;">
  <form id="changePasswordFormId" method="post" action="">
  <input type="hidden" name="securitBean.supplierID" id="supplierInputId" /> 
  <table width="100%" align="center" cellpadding="3" cellspacing="0"><tr>
    	<td class="detailedViewHeader"><strong>修改密码</strong></td>
  </tr></table>
  <table border="0" cellspacing="0" cellpadding="0" width="100%" class="lvtBg">
    <tbody>
    
      <tr style="height:25px">
        <td width="37%" align="right" class="dvtCellLabel"><label>输入旧密码</label></td>
        <td width="63%" align="left" class="dvtCellInfo"><input type="text" style="width:300px;" class="detailedViewTextBox" name="password.oldPassword" /></td>
      </tr>
      
      <tr style="height:25px">
        <td align="right" class="dvtCellLabel"><label>输入新密码</label></td>
        <td align="left" class="dvtCellInfo"><input type="text" style="width:300px;" class="detailedViewTextBox" name="password.newPassword" /></td>
      </tr> 
      
      <tr style="height:25px">
        <td class="dvtCellLabel" align="right"><label>确认新密码</label></td>
        <td align="left" class="dvtCellInfo"><input type="text" style="width:300px;" class="detailedViewTextBox" name="password.confirmPassword" /></td>
      </tr>
      
      <tr>
        <td colspan="10" style="padding:5px" height="40px;"><div align="center">
          <input title="确定 [Alt+S]" accesskey="S" class="crmbutton small save" type="submit"  value="确定" style="width:70px" />
          &nbsp;
          <input title="取消 [Alt+X]" accesskey="X" class="crmbutton small cancel" type="reset" value="取消 " style="width:70px" />
        </div></td>
      </tr>
    </tbody>
  </table>
  </form>
</div>

