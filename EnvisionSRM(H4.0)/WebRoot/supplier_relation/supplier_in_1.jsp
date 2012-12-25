<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<script language="javascript" type="text/javascript" src="../js/general.js"></script>
<script type="text/javascript">
	function show1() {
		if (confirm("是否设为缺省?")) {
			alert("设置成功");
		} else {
			alert("取消设置");
		}
	}
</script>
<div id="div1" class="small" style="width:100%;position:relative;">
  <form name="contractConfirm" action="" >
    <table border="0" cellspacing="0" cellpadding="0" width="100%" class="lvtBg">
      <tbody>
        <tr>
          <td><!-- 上部分导航 -->
            <table border="0" cellspacing="0" cellpadding="2" width="100%" class="small">
              <tbody>
                <tr>
                  <td width="38%" nowrap="nowrap" style="padding-right:10px"><span class="calDIV" style="overflow:auto;">
                    <input class="crmbutton small edit" type="button" value="设为缺省" onclick="show1();" style="width:80" />
                    </span></td>
                  <td width="32%" align="center" nowrap="nowrap" class="small"> 共 1 页，<img src="../images/previous_disabled.gif" border="0" align="absmiddle" alt="上一页"/>&nbsp;当前第&nbsp;1&nbsp;页&nbsp;<img src="../images/next_disabled.gif" border="0" align="absmiddle" alt="下一页"/></td>
                  <td width="30%" align="right" class="small" style="padding-right:20px">每页显示 10 条记录</td>
                </tr>
              </tbody>
            </table>
            <!-- 内容 -->
            <div class="calDIV" style="overflow:auto;">
              <table border="0" cellspacing="1" cellpadding="3" width="100%" class="lvt small">
                <tbody>
                  <tr>
                    <td width="3%" class="lvtCol"><div align="center"></div></td>
                    <td width="10%" align="left" class="lvtCol">小组ID</td>
                    <td width="37%" align="left" class="lvtCol">小组名称</td>
                    <td width="20%" align="left" class="lvtCol">所属类别</td>
                    <td width="10%" align="left" class="lvtCol">小组负责人</td>
                    <td width="10%" align="left" class="lvtCol">创建时间</td>
                    <td width="10%" align="left" class="lvtCol">修改时间</td>
                  </tr>
                  <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
                    <td ><div align="center"><input type="radio" name="id" value=""/></div></td>
                    <td align="left" width="10%">5000001</td>
                    <td align="left" >定制紧固件物料小组</td>
                    <td align="left" >定制紧固件</td>
                    <td align="left">李雯雯</td>
                    <td align="left" >2012-10-10</td>
                    <td align="left" >2012-11-01</td>
                  </tr>
                  <tr bgcolor="white" onmouseover="this.className='lvtColDataHover'" onmouseout="this.className='lvtColData'">
                    <td><div align="center"><input type="radio" name="id" value=""/></div></td>
                    <td align="left" >5000002</td>
                    <td align="left" >定制塑料件物料小组</td>
                    <td align="left" >定制塑料件</td>
                    <td align="left">张晓东</td>
                    <td align="left" >2012-10-10</td>
                    <td align="left" >2012-11-01</td>
                  </tr>
                </tbody>
              </table>
            </div>
            <!-- 下部分导航 -->
            <table border="0" cellspacing="0" cellpadding="2" width="100%">
              <tbody>
                <tr>
                  <td width="38%" nowrap="nowrap" style="padding-right:10px"><input class="crmbutton small edit" type="button" value="设为缺省" onclick="show1();" style="width:80"/></td>
                  <td width="32%" align="center" nowrap="nowrap" class="small">共 1 页，<img src="../images/previous_disabled.gif" border="0" align="absmiddle" alt="上一页"/>&nbsp;当前第&nbsp;1&nbsp;页&nbsp;<img src="../images/next_disabled.gif" border="0" align="absmiddle" alt="下一页"/></td>
                  <td width="30%" align="right" class="small" style="padding-right:20px">每页显示 10 条记录</td>
                </tr>
              </tbody>
            </table></td>
        </tr>
      </tbody>
    </table>
  </form>
<div style="margin-top:213px;"></div>
</div>
