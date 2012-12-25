<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<link rel="stylesheet" type="text/css" href="../css/content.css"/>
<link rel="stylesheet" type="text/css" href="../css/common.css"/>
<script language="javascript" type="text/javascript" src="../js/general.js"></script>
<div id="div5" class="small" style="width:100%;position:relative;display:none">
  <form name="contractApproval" action="" >
    <table border="0" cellspacing="1" cellpadding="0" width="100%" class="lvtBg">
      <tbody>
        <tr>
          <td><table border="0" cellspacing="0" cellpadding="2" width="100%" class="small">
              <tbody>
                <tr>
                  <td height="22px;" width="38%" nowrap="nowrap" class="small" style="padding-right:20px"><input class="crmbutton small edit" type="button" style="width:80" value="确认竞标设置" onclick="javascript:window.location.href='auction_5_set.jsp'"/></td>
                  <td width="32%" align="center" nowrap="nowrap" class="small">共 1 页，<img src="../images/previous_disabled.gif" border="0" align="absmiddle" alt="上一页"/> 当前第&nbsp;1&nbsp;页&nbsp; <img src="../images/next_disabled.gif" border="0" align="absmiddle" alt="下一页"/></td>
                  <td width="30%" align="right" class="small" style="padding-right:20px">每页显示 10 条记录</td>
                  <!-- Page Navigation -->
                </tr>
              </tbody>
            </table>
            <div class="calDIV" style="overflow:auto;">
              <table border="0" cellspacing="1" cellpadding="3" width="100%" class="lvt small">
                <tbody>
                  <tr>
                    <td class="lvtCol"></td>
                    <td width="10%" class="lvtCol">编号</td>
                    <td width="30%" class="lvtCol">竞标项目名称</td>
                    <td width="10%" class="lvtCol">发起人</td>
                    <td width="27%" class="lvtCol">竞标状态</td>
                    <td width="10%" class="lvtCol">开始时间</td>
                    <td width="10%" class="lvtCol">操作</td>
                  </tr>
                  <tr bgcolor="white"  id="row_116" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
                    <td width="3%" align="center"><input type="radio" name="selectedid_approval" id="116" value="116" onclick="check_object(this);" toggleselectall(this.name,"selectall")=""></td>
                    <td>201210201</td>
                    <td>测试数据A</td>
                    <td>采购员A</td>
                    <td>待确认竞标设置</td>
                    <td>2012-10-20</td>
                    <td><a href="auction_5_check.jsp">查看</a>&nbsp;|&nbsp;<a href="#">删除</a></td>
                  </tr>
                </tbody>
              </table>
            </div>
            <table border="0" cellspacing="0" cellpadding="2" width="100%">
              <tbody>
                <tr>
                  <td width="38%" nowrap="nowrap" class="small" style="padding-right:20px"><input class="crmbutton small edit" type="button" value="确认竞标设置"  onclick="javascript:window.location.href='auction_5_set.jsp'"/></td>
                  <td width="32%" align="center" nowrap="nowrap" class="small"> 共 1 页，<img src="../images/previous_disabled.gif" border="0" align="absmiddle" alt="上一页"/> 当前第&nbsp;1&nbsp;页&nbsp; <img src="../images/next_disabled.gif" border="0" align="absmiddle" alt="下一页"/></td>
                  <td width="30%" align="right" class="small" style="padding-right:20px">每页显示 10 条记录</td>
                  <!-- Page Navigation -->
                </tr>
              </tbody>
            </table></td>
        </tr>
      </tbody>
    </table>
  </form>
</div>
