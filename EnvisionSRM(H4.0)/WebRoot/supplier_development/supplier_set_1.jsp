<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script language="javascript" type="text/javascript" src="../js/user/user_choose.js"></script>
<script type="text/javascript">
	loadUser();
	var level1 = $("#materialClassifyId");
	var level2 = $("#materialCategoryId");
	var level3 = $("#materialSubCategoryId");
	
	var categoryListUrl='materialCategory_categoryListByType.action';
	categoryList('materialCategory_categoryListByType.action',level1,"categoryValue=0");
	cascadeChoose(categoryListUrl,level1,level2,level3,null,true);
	var supplierAdd = function(){
		houQian.confirm("确认要提交注册码？", function(){
			houQian.submitForm($("#supplierAddFormId"), 'supplierBasic_add.action', function(data){
				houQian.alert("注册成功");
				$("#supplierAddFormId").resetForm();
			},false,true);
		});
	};
	
</script>
<div id="div1" class="small" style="width:100%;position:relative;">
  <form id="supplierAddFormId" action="" >
  <input type="hidden" name="supplierBasic.userId" id="userInputId" value="0">
    <table width="100%" align="center" cellpadding="3" cellspacing="0"><tr>
    	<td class="detailedViewHeader"><b>注册供应商</b></td>
    </tr></table>
    <table border="0" cellspacing="0" cellpadding="0" width="100%" class="lvtBg">
      <tbody>
        <tr style="height:25px">
          <td width="25%" align="right" class="dvtCellLabel">供应商全称</td>
          <td width="25%"  align="left" class="dvtCellInfo">
       	  <input type="text" tabindex="" class="detailedViewTextBox" style="width:90%;" name="supplierBasic.name"/></td>
          <td width="25%" align="right" class="dvtCellLabel">采购部门申请人</td>
          <td width="25%" align="left" class="dvtCellInfo">
          	<input type="text" tabindex="" class="detailedViewTextBox" style="width:70%;" id="userNameInputId" />
          	<img tabindex="2" src="../images/select.gif" alt="选择" title="选择" onclick="userChoose()" align="absmiddle" style="cursor:hand;cursor:pointer"/>
            <img src="../images/clear.gif" alt="清除" title="清除"   onclick="cleanUser()"  align="absmiddle" style="cursor:hand;cursor:pointer" />
          </td>
        </tr>
        
        <tr style="height:25px">
          <td class="dvtCellLabel" align="right">是否生产性物料</td>
          <td align="left" class="dvtCellInfo">
          	<input type="radio" value="true" name="supplierBasic.productivityMaterial">是 <input type="radio" value="false" name="supplierBasic.productivityMaterial">否          
          </td>
          <td class="dvtCellLabel" align="right">负责人姓名</td>
          <td align="left" class="dvtCellInfo">
          	<input type="text" tabindex="" class="detailedViewTextBox" style="width:90%;" name="supplierBasic.personName" />          </td>
        </tr>
        
        <tr style="height:25px">
          <td class="dvtCellLabel" align="right">物料分类</td>
          <td align="left" class="dvtCellInfo">
          	<select  style="width:93%;" id="materialClassifyId">
            </select>	
          </td>
          <td class="dvtCellLabel" align="right">负责人手机号</td>
          <td align="left" class="dvtCellInfo">
          	<input type="text" tabindex="" class="detailedViewTextBox" style="width:90%;" name="supplierBasic.phone" />          </td>
        </tr>
        <tr style="height:25px">
          <td class="dvtCellLabel" align="right">物料类别</td>
          <td align="left" class="dvtCellInfo">
         	<select style= "width:93%;" id="materialCategoryId"> 
            </select>	
          </td>
          <td class="dvtCellLabel" align="right">负责人Email</td>
          <td align="left" class="dvtCellInfo">
            <input type="text" tabindex="" class="detailedViewTextBox" style="width:90%;" name="supplierBasic.email" />          </td>
        </tr>
        
        <tr style="height:25px">
          <td class="dvtCellLabel" align="right">物料子类别</td>
          <td align="left" class="dvtCellInfo">
         	<select style= "width:93%;" id="materialSubCategoryId" name="subCategoryId"> 
            </select>	
          </td>
          <td class="dvtCellLabel" align="right"></td>
          <td align="left" class="dvtCellInfo">
          </td>
        </tr>
        
        <tr>
          <td colspan="10" style="padding:5px" height="40px;"><div align="center">
              <input title="确定 [Alt+S]" accesskey="S" class="crmbutton small save"  type="button" onclick="supplierAdd()"  value="注册" style="width:70px" />
              &nbsp;
              <input title="取消 [Alt+X]" accesskey="X" class="crmbutton small cancel" type="reset"  value="  返回  " style="width:70px" />
            </div></td>
        </tr>
      </tbody>
    </table>
  </form>
</div>
<jsp:include page="../common/choice_user.jsp"/>
