<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<script language="javascript" type="text/javascript" src="../js/general.js"></script>
<script type="text/javascript">
	function show2() {
		if (confirm("是否提交分析?")) {
			alert("提交成功");
		} else {
			alert("取消提交");
		}
	}
</script>
<div id="div2" class="small" style="width:100%;position:relative;display:none">
  <form name="contractApproval" action="" >
    <table border="0" cellspacing="1" cellpadding="0" width="100%" class="lvtBg">
      <tbody>
        <tr>
          <td><table border="0" cellspacing="0" cellpadding="2" width="100%" class="small">
              <tbody>
                <tr>
                  <td width="38%" nowrap="nowrap" style="padding-right:10px"><span class="calDIV" style="overflow:auto;">
                    <input class="crmbutton small edit" type="button" value="开始分析" onclick="show1();" style="width:80" />
                    </span></td>
                  <td width="32%" align="center" nowrap="nowrap" class="small"> 共 1 页，<img src="../images/previous_disabled.gif" border="0" align="absmiddle" alt="上一页"/>&nbsp;当前第&nbsp;1&nbsp;页&nbsp;<img src="../images/next_disabled.gif" border="0" align="absmiddle" alt="下一页"/></td>
                  <td width="30%" align="right" class="small" style="padding-right:20px">每页显示 10 条记录</td>
                </tr>
              </tbody>
            </table>
            <div class="calDIV" style="overflow:auto;">
            <table border="0" cellspacing="1" cellpadding="3" width="100%" class="lvt small">
                <tbody>
                  <tr>
                    <td width="10%" class="lvtCol">供应商编号</td>
                    <td width="30%" class="lvtCol">供应商名称</td>
                    <td width="30%" class="lvtCol">评价组</td>
                    <td width="30%" class="lvtCol">是否纳入分析</td>
                  </tr>
                  <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
                    <td>201200432</td>
                    <td>测试数据A</td>
                    <td><select >
                      <option value="1">生产型-关键</option>
                      <option value="1">生产型-瓶颈</option>
                      <option value="1">生产型-杠杆/常规</option>
                      <option value="1">贸易型-关键/瓶颈</option>
                      <option value="1">贸易型-杠杆/常规</option>
                    </select></td>
                    <td ><input type="checkbox" /></td>
                  </tr>
                  <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
                    <td>201200123</td>
                    <td>测试数据B</td>
                    <td><select >
                      <option value="1">生产型-关键</option>
                      <option value="1">生产型-瓶颈</option>
                      <option value="1">生产型-杠杆/常规</option>
                      <option value="1">贸易型-关键/瓶颈</option>
                      <option value="1">贸易型-杠杆/常规</option>
                    </select></td>
                    <td ><input type="checkbox" /></td>
                  </tr>
                </tbody>
              </table>
            </div>
            <table border="0" cellspacing="0" cellpadding="2" width="100%">
              <tbody>
                <tr>
                  <td width="38%" nowrap="nowrap" class="small" style="padding-right:20px">
                  <span class="small" style="padding-right:20px">
                    <input class="crmbutton small edit" type="button" style="width:80" value="开始分析" onclick="show2();"/>
                  </span></td>
                  <td width="32%" align="center" nowrap="nowrap" class="small"> 共 1 页，<img src="../images/previous_disabled.gif" border="0" align="absmiddle" alt="上一页"/>&nbsp;当前第&nbsp;1&nbsp;页&nbsp;<img src="../images/next_disabled.gif" border="0" align="absmiddle" alt="下一页"/></td>
                  <td width="30%" align="right" class="small" style="padding-right:20px">每页显示 10 条记录</td>
                </tr>
              </tbody>
            </table></td>
        </tr>
      </tbody>
    </table>
  </form>
  <div style="margin-top:210px;"></div>
</div>

