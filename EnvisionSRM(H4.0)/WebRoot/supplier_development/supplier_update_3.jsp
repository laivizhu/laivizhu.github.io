<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div id="div3" class="small" style="width:100%;position:relative;display:none">
  <form name="contractApproval" action="" >
    <table border="0" cellspacing="1" cellpadding="0" width="100%" class="lvtBg">
      <tbody>
        <tr>
          <td><table border="0" cellspacing="0" cellpadding="2" width="100%" class="small">
              <tbody>
                <tr>
                  <td width="38%" nowrap="nowrap" class="small" style="padding-right:20px">
                  <span class="small" style="padding-right:20px">
                    <input class="crmbutton small edit" type="button" style="width:80" value="供应商信息修改" onclick="javascript:window.location.href='supplier_set_3_alter.jsp'"/>
                  </span></td>
                  <td width="32%" align="center" nowrap="nowrap" class="small">
                  	共 1 页，<img src="../images/previous_disabled.gif" border="0" align="absmiddle" alt="上一页"/> 
                  	当前第&nbsp;1&nbsp;页&nbsp; <img src="../images/next_disabled.gif" border="0" align="absmiddle" alt="下一页"/></td>
                  <td width="30%" align="right" class="small" style="padding-right:20px">每页显示 10 条记录</td>
                  <!-- Page Navigation -->
                </tr>
              </tbody>
            </table>

            <table border="0" cellspacing="1" cellpadding="3" width="100%" class="lvt small">
			<tbody>
                          <tr>
                            <td class="lvtCol"></td>
                            <td width="15%" class="lvtCol">供应商编号</td>
                            <td width="15%" class="lvtCol">供应商名称</td>
                            <td width="15%" class="lvtCol">供应商代表</td>
                            <td width="15%" class="lvtCol">供应商修改申请时间</td>
                            <td width="15%" class="lvtCol">申请编号</td>
                            <td width="15%" class="lvtCol">供应商邮箱</td>
                          </tr>
                          <tr bgcolor="white"  id="row_" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
                            <td width="3%" align="center"><input type="radio" onclick="check_object(this);" toggleselectall(this.name,"selectall")="">
                            </td>
                            <td>201200432</td>
                            <td>测试X</td>
                            <td>张亚雯</td>
                            <td>2012-12-12</td>
                            <td>2921874921</td>
                            <td>weiweili@test.com</td>
                          </tr>
                          <tr bgcolor="white"  id="row_" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
                            <td width="3%" align="center"><input type="radio" onclick="check_object(this);" toggleselectall(this.name,"selectall")="">
                            </td>
                            <td>201200123</td>
                            <td>测试数据B</td>
                            <td>林丹全</td>
                            <td>2012-11-15</td>
                            <td>3259833220</td>
                            <td>dashenglei@test.com</td>
                          </tr>
                        </tbody>
              </table>
              
            <table border="0" cellspacing="0" cellpadding="2" width="100%">
              <tbody>
                <tr>
                  <td width="38%" nowrap="nowrap" class="small" style="padding-right:20px">
                  <span class="small" style="padding-right:20px">
                    <input class="crmbutton small edit" type="button" style="width:80" value="供应商信息修改" onclick="javascript:window.location.href='supplier_set_3_alter.jsp'"/>
                  </span></td>
                  <td width="32%" align="center" nowrap="nowrap" class="small"> 
                  共 1 页，<img src="../images/previous_disabled.gif" border="0" align="absmiddle" alt="上一页"/> 
                  当前第&nbsp;1&nbsp;页&nbsp; <img src="../images/next_disabled.gif" border="0" align="absmiddle" alt="下一页"/></td>
                  <td width="30%" align="right" class="small" style="padding-right:20px">每页显示 10 条记录</td>
                </tr>
              </tbody>
            </table></td>
        </tr>
      </tbody>
    </table>
  </form>
</div>
