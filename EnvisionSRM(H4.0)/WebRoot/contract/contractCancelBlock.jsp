<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div id="div4" class="small" style="width:100%;position:relative;">
<form name="contractCancel" method="POST">
               <table border="0" cellspacing="1" cellpadding="0" width="100%" class="lvtBg">
	            <tbody><tr>
		      <td>
		        <table border="0" cellspacing="0" cellpadding="2" width="100%" class="small">
<tbody><tr>
<td width="42%"  style="padding-right:20px"><input class="crmbutton small edit" type="button" value="合同取消" onclick="contract_Cancel()" >
</td>
<td width="34%" class="small">
<table width="187" border="0" cellpadding="0" cellspacing="0" class="small">
  <tbody><tr>
    <td align="right" style="padding: 5px;">共 1 页， <a href="#" style="text-decoration:none;"><img src="../images/previous_disabled.gif" border="0" align="absmiddle" alt="上一页"/></a> &nbsp;当前第&nbsp;1&nbsp;页&nbsp; <a href="#" style="text-decoration:none;"><img src="../images/next_disabled.gif" border="0" align="absmiddle" alt="下一页"/></a> &nbsp;</td></tr>
</tbody></table></td>
<!-- Page Navigation -->
<td width="24%" align="right"><span style="padding-right:20px">每页显示 10 条记录</span></td>	
</tr>
</tbody></table>
                         <div class="calDIV" style="overflow:auto;">
		   <table border="0" cellspacing="1" cellpadding="3" width="100%" class="lvt small">
			      <tbody><tr height="30">
             			 <td width="3%" class="lvtCol">&nbsp;</td>
                         <td width="15%"class="lvtCol">合同编号</td>
                         <td width="27%" class="lvtCol">供应商名称</td>
                         <td width="10%" class="lvtCol">开始日期</td>
                         <td width="10%" class="lvtCol">结束日期</td>
                         <td width="10%" class="lvtCol">采购员</td>
                         <td width="10%" class="lvtCol">状态</td>
                         <td width="15%" class="lvtCol">取消原因</td>
                          </tr>
			      			      <tr bgcolor="white"  id="row_116" class="lvtColData" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
			      			        <td width="2%" align="center"><input type="radio" name="selectedid_cancel1" id="116" value="116" onclick="check_object(this);" ></td>
			      			        
			      			        <td>供应商编号+年度合同号+V01 <span type="vtlib_metainfo" vtrecordid="116" vtfieldname="activitytype" vtmodule="Calendar" style="display:none;"></span></td>
			      			        
			      			        <td>供应商B <span type="vtlib_metainfo" vtrecordid="116" vtfieldname="parent_id" vtmodule="Calendar" style="display:none;"></span></td>
			      			        
			      			        <td>2012-09-12 <span type="vtlib_metainfo" vtrecordid="116" vtfieldname="date_start" vtmodule="Calendar" style="display:none;"></span></td>
			      			        
			      			        <td>2012-10-12 <span type="vtlib_metainfo" vtrecordid="116" vtfieldname="due_date" vtmodule="Calendar" style="display:none;"></span></td>
			      			        
			      			        <td>采购员B  <span type="vtlib_metainfo" vtrecordid="116" vtfieldname="assigned_user_id" vtmodule="Calendar" style="display:none;"></span></td>
			      			        <td>待审批<span type="vtlib_metainfo" vtrecordid="116" vtfieldname="taskstatus" vtmodule="Calendar" style="display:none;"></span></td>
			      			        
			      			        <td><select name="contractCancelReason">
			      			          <option value="">请选择取消原因</option>
			      			          <option value="1">取消原因A</option>
			      			          <option value="2">取消原因B</option>
			      			          <option value="3">取消原因C</option>
			      			          <option value="4">取消原因D</option>
		      			            </select></td>
			      			        </tr>
	                         			      <tr bgcolor="white"  id="row_116" class="lvtColData" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
				 <td width="2%" align="center"><input type="radio" name="selectedid_cancel1" id="116" value="116" onclick="check_object(this);" ></td>
				 	
				 <td>供应商编号+年度合同号+V01 <span type="vtlib_metainfo" vtrecordid="116" vtfieldname="activitytype" vtmodule="Calendar" style="display:none;"></span></td>
	                         	
				 <td>供应商C <span type="vtlib_metainfo" vtrecordid="116" vtfieldname="parent_id" vtmodule="Calendar" style="display:none;"></span></td>
	                         	
				 <td>2012-09-12 <span type="vtlib_metainfo" vtrecordid="116" vtfieldname="date_start" vtmodule="Calendar" style="display:none;"></span></td>
	                         	
				 <td>2012-10-12 <span type="vtlib_metainfo" vtrecordid="116" vtfieldname="due_date" vtmodule="Calendar" style="display:none;"></span></td>
	                         	
				 <td>采购员C  <span type="vtlib_metainfo" vtrecordid="116" vtfieldname="assigned_user_id" vtmodule="Calendar" style="display:none;"></span></td>
				 <td>待审批<span type="vtlib_metainfo" vtrecordid="116" vtfieldname="taskstatus" vtmodule="Calendar" style="display:none;"></span><span type="vtlib_metainfo" vtrecordid="116" vtfieldname="taskstatus" vtmodule="Calendar" style="display:none;"></span></td>
	                         	
				 <td><select name="contractCancelReason">
				      <option value="">请选择取消原因</option>
			          <option value="1">取消原因A</option>
			          <option value="2">取消原因B</option>
			          <option value="3">取消原因C</option>
			          <option value="4">取消原因D</option>
				   </select></td>
	                         			      </tr>
	                         			       <tr bgcolor="white"  id="row_116" class="lvtColData" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
				 <td width="2%" align="center"><input type="radio" name="selectedid_cancel1" id="116" value="116" onclick="check_object(this);" ></td>
				 	
				 <td>供应商编号+年度合同号+V01 <span type="vtlib_metainfo" vtrecordid="116" vtfieldname="activitytype" vtmodule="Calendar" style="display:none;"></span></td>
	                         	
				 <td>供应商D <span type="vtlib_metainfo" vtrecordid="116" vtfieldname="parent_id" vtmodule="Calendar" style="display:none;"></span></td>
	                         	
				 <td>2012-09-12 <span type="vtlib_metainfo" vtrecordid="116" vtfieldname="date_start" vtmodule="Calendar" style="display:none;"></span></td>
	                         	
				 <td>2012-10-12 <span type="vtlib_metainfo" vtrecordid="116" vtfieldname="due_date" vtmodule="Calendar" style="display:none;"></span></td>
	                         	
				 <td>采购员D<span type="vtlib_metainfo" vtrecordid="116" vtfieldname="assigned_user_id" vtmodule="Calendar" style="display:none;"></span></td>
				 <td>待审批<span type="vtlib_metainfo" vtrecordid="116" vtfieldname="taskstatus" vtmodule="Calendar" style="display:none;"></span><span type="vtlib_metainfo" vtrecordid="116" vtfieldname="taskstatus" vtmodule="Calendar" style="display:none;"></span></td>
	                         	
				 <td><select name="contractCancelReason">
                      <option value="">请选择取消原因</option>
 			          <option value="1">取消原因A</option>
 			          <option value="2">取消原因B</option>
 			          <option value="3">取消原因C</option>
 			          <option value="4">取消原因D</option>
				   </select></td>
	                         			      </tr>
			      			 </tbody></table>
			 </div>
			 <table border="0" cellspacing="0" cellpadding="2" width="100%" class="small">
<tbody><tr>
<td width="42%" nowrap="" style="padding-right:20px"><input class="crmbutton small edit" type="button" value="合同取消" onclick="generalContract()">
</td>
<td width="34%" nowrap="" class="small">
<table width="187" border="0" cellpadding="0" cellspacing="0" class="small">
  <tbody><tr>
    <td align="right" style="padding: 5px;">共 1 页， <a href="#" style="text-decoration:none;"><img src="../images/previous_disabled.gif" border="0" align="absmiddle" alt="上一页"/></a> &nbsp;当前第&nbsp;1&nbsp;页&nbsp; <a href="#" style="text-decoration:none;"><img src="../images/next_disabled.gif" border="0" align="absmiddle" alt="下一页"/></a> &nbsp;</td></tr>
</tbody></table></td>
<!-- Page Navigation -->
<td width="24%" align="right"><span style="padding-right:20px">每页显示 10 条记录</span></td>	
</tr>
</tbody></table>
		       </td>
		   </tr>
	    </tbody></table>

   </form>	

	</div>




