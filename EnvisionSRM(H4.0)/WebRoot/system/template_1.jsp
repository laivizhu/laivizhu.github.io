<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
		$(document).ready(
			function(){
				var table1 = new HouQianTable({
					url:"material/materialCategory_list.action",
					parentContainer:"#div1",
					columns:[
						{name:"模板编号",width:"10%"},
						{name:"标准协议模板名称",width:"40%"},
						{name:"附件",width:"37%"},
						{name:"创建时间",width:"10%"}
						
					],
					specialOpertions:[
						{name:"新建",callback:NewSecuritTemplate}
				],
					pageCount:10,
					selectType:1
				});
			}
		);
		

		function NewSecuritTemplate(data) {
			window.location = "securit_sure.action?id=" + data.id;
		}
</script>
<div>
<table width="652" height="40" cellpadding="5" cellspacing="0" align="center" border="0" class="search_table">
    <tbody><tr>
    <td></td>
	<td align="left" nowrap="nowrap">
        <span class="search_title">搜索 - 保密协议模板</span></td>
	<td nowrap="nowrap" align="right" valign="middle">
        <b> 在</b>&nbsp;
        <select name="searchCondition" class="search_input"  style="width:120px">
            <option value="name" selected="selected">模板类型</option>
            <option value="createTime">模板名称</option>
            <option value="modifyTime">创建时间</option>
        </select>
        <b>中&nbsp;&nbsp;&nbsp;&nbsp;查找&nbsp;&nbsp;&nbsp;&nbsp;</b>
        <input type="text" name="keyword" class="search_input" style="width:150px" />&nbsp;&nbsp;
        <input name="submit" type="button" value=" 立刻查找 " class="search_button"/>
	</td>
    <td></td>
  </tr></tbody></table>
</div>  

<div id="div1" class="small" style="width:100%;position:relative;">
</div>