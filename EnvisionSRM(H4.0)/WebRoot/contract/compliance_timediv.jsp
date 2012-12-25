<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div id="div1" class="small" style="width:100%;position:relative;">
<div id="searchBox">
<form name="basicSearch" method="post" action="">
<table width="652" height="40" cellpadding="5" cellspacing="0" class="searchUIBasic small" align="center" border="0">
  <tbody><tr>
    <td></td>
	<td class="small" align="left" nowrap="nowrap">
        <span class="moduleName">搜索 - 合规性</span>
    </td>
	<td class="small" nowrap="nowrap" align="right" >
        <b>在</b>&nbsp;
        <select name="search_field" id="bas_searchfield" class="txtBox" style="width:120px">
            <option value="title" selected="selected">合同编号</option>
            <option value="title" >供应商名称</option>
        </select>
        <b>中&nbsp;&nbsp;&nbsp;&nbsp;查找</b>
        <input type="text" class="txtBox" style="width:150px" name="search_text"/>&nbsp;&nbsp;
        <input name="submit" type="button" class="crmbutton small create" value=" 立刻查找 "/>
	</td>
    <td></td>
  </tr>
  </tbody>
</table>
</form>
</div>
<form name="contractConfirm" action="" >
<table border="0" cellspacing="1" cellpadding="0" width="100%" class="lvtBg">
<tbody>
  <tr>
    <td><table border="0" cellspacing="0" cellpadding="2" width="100%" class="small">
      <tbody>
        <tr>
          <td width="42%" nowrap="nowrap" style="padding-right:10px">&nbsp;</td>
          <td width="34%" nowrap="" class="small"><table width="187" border="0" cellpadding="0" cellspacing="0" class="small">
                      <tbody>
                        <tr>
                          <td align="right" style="padding: 5px;">共 1 页， <a href="#" style="text-decoration:none;"><img src="../images/previous_disabled.gif" border="0" align="absmiddle" alt="上一页"/></a> &nbsp;当前第&nbsp;1&nbsp;页&nbsp; <a href="#" style="text-decoration:none;"><img src="../images/next_disabled.gif" border="0" align="absmiddle" alt="下一页"/></a> &nbsp;</td>
                        </tr>
                      </tbody>
                    </table></td>
          <td width="24%" align="right" style="padding-right:20px">每页显示 8 条记录</td>
          <!-- Page Navigation -->
          </tr>
        </tbody>
      </table>
      <div class="calDIV" style="overflow:auto;">
        <table border="0" cellspacing="1" cellpadding="3" width="100%" class="lvt small">
          <tbody>
            <tr height="30">
              <td width="3" class="lvtCol"></td>
              <td width="15%" class="lvtCol">合同编号</td>
              <td width="42%" class="lvtCol">供应商名称</td>
              <td width="10%" class="lvtCol">采购员</td>
              <td width="10%" class="lvtCol">合同创建日期</td>
              <td width="10%" class="lvtCol">合同状态</td>
              <td width="10%" class="lvtCol">操作</td>
              </tr>
            <tr bgcolor="white"  id="row_116" class="lvtColData" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
              <td width="3%" align="center"><input type="radio" name="selectedid_confirm" id="116" value="116" onclick="check_object(this);" toggleselectall(this.name,"selectall")=""></td>
              <td>供应商编号+年度合同号+V01 </td>
              <td>厚谦咨询</td>
              <td>采购员A</td>
              <td>2012-09-2</td>
              <td>已审批</td>
              <td><a href="compliancetime_view.jsp">查看合规性</a></td>
              </tr>
            </tbody>
          </table>
        </div>
      <table border="0" cellspacing="0" cellpadding="2" width="100%">
        <tbody>
          <tr>
            <td width="42%" nowrap="nowrap" style="padding-right:10px">&nbsp;</td>
          <td width="34%" nowrap="" class="small"><table width="187" border="0" cellpadding="0" cellspacing="0" class="small">
                      <tbody>
                        <tr>
                          <td align="right" style="padding: 5px;">共 1 页， <a href="#" style="text-decoration:none;"><img src="../images/previous_disabled.gif" border="0" align="absmiddle" alt="上一页"/></a> &nbsp;当前第&nbsp;1&nbsp;页&nbsp; <a href="#" style="text-decoration:none;"><img src="../images/next_disabled.gif" border="0" align="absmiddle" alt="下一页"/></a> &nbsp;</td>
                        </tr>
                      </tbody>
                    </table></td>
          <td width="24%" align="right" style="padding-right:20px">每页显示 8 条记录</td>
            <!-- Page Navigation -->
            </tr>
          </tbody>
        </table></td>
    </tr>
  </tbody>
</table>
</form>
</div>


