<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<link rel="stylesheet" type="text/css" href="../css/content.css"/>
<link rel="stylesheet" type="text/css" href="../css/common.css"/>
<script language="javascript" type="text/javascript" src="../js/general.js"></script>
<div id="div2" class="small" style="width:100%;position:relative;display:none">
 
 
 
  <form name="contractConfirm" action="" >
    <table width="652" height="40" cellpadding="5" cellspacing="0" align="center" border="0" class="search_table">
    <tbody><tr>
    <td></td>
	<td align="left" nowrap="nowrap">
        <span class="search_title">搜索 - 供应商</span>
    </td>
	<td nowrap="nowrap" align="right" valign="middle">
        <b>在</b>&nbsp;
        <select id="categorySearchConditionId" name="searchCondition" class="search_input"  style="width:120px">
        </select>
        <b>中&nbsp;&nbsp;&nbsp;&nbsp;查找&nbsp;&nbsp;&nbsp;&nbsp;</b>
        <input type="text" name="keyword" class="search_input" style="width:150px" />&nbsp;&nbsp;
        <input name="submit" type="button" value=" 立刻查找 " class="search_button"/>
	</td>
    <td></td>
  </tr></tbody></table>
    <table border="0" cellspacing="1" cellpadding="0" width="100%" class="lvtBg">
      <tbody>
        <tr>
          <td>
          
            <!-- 上部分导航 -->
          	<table border="0" cellspacing="0" cellpadding="2" width="100%" class="small">
              <tbody>
                <tr>
                  <td height="22px;" width="38%" nowrap="nowrap" style="padding-right:10px"><input class="crmbutton small edit" type="button" value="新建报告" onclick="javascript:window.location.href='supplier_document_2_new.jsp'" style="width:80" />
                  </td>
                  <td width="32%" align="center" nowrap="nowrap" class="small">
                        共 1 页，<img src="../images/previous_disabled.gif" border="0" align="absmiddle" alt="上一页"/>
                    当前第&nbsp;1&nbsp;页&nbsp; <img src="../images/next_disabled.gif" border="0" align="absmiddle" alt="下一页"/>
                  </td>
                  <td width="30%" align="right" class="small" style="padding-right:20px">每页显示 10 条记录</td>
                </tr>
              </tbody>
            </table>
            
            <!-- 内容 -->
            <div class="calDIV" style="overflow:auto;">
              <table border="0" cellspacing="1" cellpadding="3" width="100%" class="lvt small">
                <tbody>
                  <tr>
                    <td width="10%" class="lvtCol">报告类别</td>
                    <td width="15%" class="lvtCol">报告标题</td>
                    <td width="10%" class="lvtCol">提交人</td>
                    <td width="10%" class="lvtCol">物料类别</td>
                    <td width="15%" class="lvtCol">供应商</td>
                    <td width="10%" class="lvtCol">文件附件</td>
                    <td width="10%" class="lvtCol">上传日期</td>
                    <td width="10%" class="lvtCol">上传人</td>
                    <td width="10%" class="lvtCol">操作</td>
                  </tr>
                  <tr bgcolor="white"  id="row_116" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
                    <td height="19">测试数据</td>
                    <td>测试2</td>
                    <td>周芳芳</td>
                    <td>测试</td>
                    <td>测试</td>
                    <td><a>测试数据</a></td>
                    <td>2012-10-30</td>
                    <td>李东</td>
                    <td><a href="supplier_document_2_edit.jsp">编辑</a>&nbsp;|&nbsp;<a href="#">删除</a></td>
                  </tr>

                </tbody>
              </table>
            </div>
            
            <!-- 下部分导航 -->
            <table border="0" cellspacing="0" cellpadding="2" width="100%">
              <tbody>
                <tr>
                  <td width="38%" nowrap="nowrap" style="padding-right:10px">
                  <input class="crmbutton small edit" type="button" value="新建报告" onclick="javascript:window.location.href='supplier_document_2_new.jsp'"  style="width:80" />
                  </td>
                  <td width="32%" align="center" nowrap="nowrap" class="small"> 
                  	共 1 页，<img src="../images/previous_disabled.gif" border="0" align="absmiddle" alt="上一页"/>
                 	&nbsp;当前第&nbsp;1&nbsp;页&nbsp; <img src="../images/next_disabled.gif" border="0" align="absmiddle" alt="下一页"/>
                  </td>
                  <td width="30%" align="right" class="small" style="padding-right:20px">每页显示 10 条记录</td>
                  <!-- Page Navigation -->
                </tr>
              </tbody>
            </table>
          
          
          </td>
        </tr>
      </tbody>
    </table>
  </form>
  
  
  
</div>
