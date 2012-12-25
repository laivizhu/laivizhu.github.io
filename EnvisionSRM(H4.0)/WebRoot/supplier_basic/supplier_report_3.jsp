<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<script language="javascript" type="text/javascript" src="../js/general.js"></script>
<div id="div3" class="small" style="width:100%;position:relative;display:none">
  <form name="contractApproval" action="" >
    <table border="0" cellspacing="1" cellpadding="0" width="100%" class="lvtBg">
      <tbody>
        <tr>
          <td>
            <table border="0" cellspacing="0" cellpadding="2" width="100%" class="small">
              <tbody>
                <tr>
                  <td width="38%" nowrap="nowrap" class="small" style="padding-right:20px">
                  <span class="small" style="padding-right:20px">
                    <input class="crmbutton small edit" type="button" style="width:80" value="跟踪" onclick="javascript:window.location.href='supplier_report_3_genzong.jsp'"/>
                  </span></td>
                  <td width="32%" align="center" nowrap="nowrap" class="small">
                  	共 1 页，<img src="../images/previous_disabled.gif" border="0" align="absmiddle" alt="上一页"/> 
                  	当前第&nbsp;1&nbsp;页&nbsp; <img src="../images/next_disabled.gif" border="0" align="absmiddle" alt="下一页"/></td>
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
                <td width="15%" class="lvtCol">供应商名称</td>
                <td width="15%" class="lvtCol">零部件名称</td>
                <td width="15%" class="lvtCol">部件序列号</td>
                <td width="15%" class="lvtCol">图纸编号</td>
                <td width="15%" class="lvtCol">图纸版本号</td>
                <td width="15%" class="lvtCol">缺陷等级</td>
                <td width="15%" class="lvtCol">发生时间</td>
              </tr>           
               <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
                <td width="3%"><input type="radio" onclick="check_object(this);" toggleselectall(this.name,"selectall")=""></td>
                <td>测试数据A</td>
                <td>测试数据A</td>
                <td>测试2</td>
                <td>2012-10-12</td>
                <td>weiweili@test.com</td>
                <td>2012-10-12</td>
                <td>weiweili@test.com</td>
              </tr>
              </tbody>          
            </table>
            </div>
            <table border="0" cellspacing="0" cellpadding="2" width="100%">
              <tbody>
                <tr>
                  <td width="38%" nowrap="nowrap" class="small" style="padding-right:20px">
                  <span class="small" style="padding-right:20px">
                    <input class="crmbutton small edit" type="button" style="width:80" value="跟踪" onclick=""javascript:window.location.href='supplier_report_3_genzong.jsp'"/>
                  </span></td>
                  <td width="32%" align="center" nowrap="nowrap" class="small"> 
                  共 1 页，<img src="../images/previous_disabled.gif" border="0" align="absmiddle" alt="上一页"/> 
                  当前第&nbsp;1&nbsp;页&nbsp; <img src="../images/next_disabled.gif" border="0" align="absmiddle" alt="下一页"/></td>
                  <td width="30%" align="right" class="small" style="padding-right:20px">每页显示 10 条记录</td>
                </tr>
              </tbody>
            </table>
          </td>
        </tr>
      </tbody>
    </table>
  </form>
</div>
