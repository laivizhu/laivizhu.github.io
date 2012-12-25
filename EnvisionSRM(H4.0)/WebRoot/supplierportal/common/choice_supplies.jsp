<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div>
<!-- 工作台 -->
  <table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
    <tbody>
      <tr>
        <td><div style="margin-top:10px;"><table border="0" cellspacing="0" cellpadding="3" width="100%" class="small">
            <tbody>
              <tr bgcolor="white"  id="row_116" class="lvtColData">
                <td class="lvtColData" colspan="10" ><table width="652" cellpadding="5" cellspacing="0" class="searchUIBasic small" align="center" border="0">
                  <tbody>
                    <tr>
                    <td></td>
                      <td class="small" align="left" nowrap="nowrap"><span class="moduleName">搜索 - 物料</span> </td>
                      <td class="small" nowrap="nowrap" align="right" ><b>在</b>&nbsp;
                        <select name="search_field" id="bas_searchfield" class="txtBox" style="width:120px">
                          <option value="title" selected="selected">物料编号</option>
                          <option value="title" >物料名称</option>
                          <option value="title" >物料类别</option>
                        </select>
                        <b>中&nbsp;&nbsp;&nbsp;&nbsp;查找</b>
                          <input type="text" class="txtBox" style="width:150px" name="search_text"/>
                        &nbsp;&nbsp;
                        <input name="submit" type="button" class="crmbutton small create" value=" 立刻查找 "/>                      </td>
                      <td></td>
                    </tr>
                  </tbody>
                </table></td>
              </tr>
            </tbody>
          </table></div></td>
      </tr>
		
        <tr><td style="height:10px;">&nbsp;</td></tr>
      <tr>
        <td valign="top" align="left"><div id="basicTab" style="display: block;">
        <div>
        </div>
          <table border="0" cellspacing="0" cellpadding="3" width="100%" class="dvtContentSpace" style=" border:none;">
            <tbody>
              <tr>
                <td align="left"><div class="calDIV" style="overflow:auto; width:100%; margin:10px auto;">
                  <div>
                      <table border="0" cellspacing="0" cellpadding="2" width="100%" class="small">
                        <tbody>
                          <tr>
                            <td width="38%" nowrap="nowrap" style="padding-right:10px"><input title="保存 [Alt+S]" accesskey="S" class="crmbutton small save" onclick="" type="submit" name="button2" value="  确定  " style="width:70px" />                                    </td>
                            <td width="32%" align="center" nowrap="nowrap" class="small"> 共 1 页，<img src="../images/previous_disabled.gif" border="0" align="absmiddle" alt="上一页"/> 当前第&nbsp;1&nbsp;页&nbsp; <img src="../images/next_disabled.gif" border="0" align="absmiddle" alt="下一页"/> </td>
                            <td width="30%" align="right" class="small" style="padding-right:20px">每页显示 10 条记录</td>
                          </tr>
                        </tbody>
                      </table>
                    </div>  
                  <table border="0" cellspacing="1" cellpadding="3" width="100%" class="lvt small">
                      <tbody>
                        <tr>
                          <td class="lvtCol"></td>
                          <td width="40%" class="lvtCol">物料名称</td>
                          <td width="10%" class="lvtCol">编号</td>
                          <td width="37%" class="lvtCol">物料类别</td>
                          <td width="10%" class="lvtCol">物料小组负责人</td>
                        </tr>
                        <tr bgcolor="white"  id="row_" class="lvtColData">
                          <td width="3%"><div align="center">
                              <input type="radio" name="id" value=""/>
                          </div></td>
                          <td>中性笔</td>
                          <td>BGYP1210</td>
                          <td>办公用具</td>
                          <td>林安琪</td>
                        </tr>
                        <tr bgcolor="white"  id="row_" class="lvtColData">
                          <td width="3%"><div align="center">
                              <input type="radio" name="id" value=""/>
                          </div></td>
                          <td>A4打印纸</td>
                          <td>BGYP0207</td>
                          <td>办公用具</td>
                          <td>陈力丹</td>
                        </tr>
                        <tr bgcolor="white"  id="row_" class="lvtColData">
                          <td width="3%"><div align="center">
                              <input type="radio" name="id" value=""/>
                          </div></td>
                          <td>抽取面纸</td>
                          <td>BGYP0812</td>
                          <td>生活用品</td>
                          <td>刘小龙</td>
                        </tr>
                        <tr bgcolor="white"  id="row_2" class="lvtColData">
                          <td><div align="center">
                              <input type="radio" name="id" value=""/>
                          </div></td>
                          <td>书架</td>
                          <td>PXQC1101</td>
                          <td>办公用具</td>
                          <td>陈晓旭</td>
                        </tr>
                        <tr bgcolor="white"  id="row_6" class="lvtColData">
                          <td><div align="center">
                              <input type="radio" name="id" value=""/>
                          </div></td>
                          <td>变压器</td>
                          <td>SPYL1212</td>
                          <td>器件</td>
                          <td>李文峰</td>
                        </tr>
                        <tr bgcolor="white"  id="row_5" class="lvtColData">
                          <td><div align="center">
                              <input type="radio" name="id" value=""/>
                          </div></td>
                          <td>定制外壳</td>
                          <td>JTYS0628</td>
                          <td>器件</td>
                          <td>刘恺威</td>
                        </tr>
                        <tr bgcolor="white"  id="row_4" class="lvtColData">
                          <td><div align="center">
                              <input type="radio" name="id" value=""/>
                          </div></td>
                          <td>变压器</td>
                          <td>JTYS9922</td>
                          <td>器件</td>
                          <td>孙思泉</td>
                        </tr>
                        <tr bgcolor="white"  id="row_4" class="lvtColData">
                          <td><div align="center">
                              <input type="radio" name="id" value=""/>
                          </div></td>
                          <td>变压器</td>
                          <td>JTYS9922</td>
                          <td>器件</td>
                          <td>孙思泉</td>
                        </tr>
                        <tr bgcolor="white"  id="row_4" class="lvtColData">
                          <td><div align="center">
                              <input type="radio" name="id" value=""/>
                          </div></td>
                          <td>变压器</td>
                          <td>JTYS9922</td>
                          <td>器件</td>
                          <td>孙思泉</td>
                        </tr>
                        <tr bgcolor="white"  id="row_4" class="lvtColData">
                          <td><div align="center">
                              <input type="radio" name="id" value=""/>
                          </div></td>
                          <td>变压器</td>
                          <td>JTYS9922</td>
                          <td>器件</td>
                          <td>孙思泉</td>
                        </tr>
                      </tbody>
                    </table>
                  <div>
                      <table border="0" cellspacing="0" cellpadding="2" width="100%" class="small">
                        <tbody>
                          <tr>
                            <td width="38%" nowrap="nowrap" style="padding-right:10px"><input title="保存 [Alt+S]" accesskey="S" class="crmbutton small save" onclick="" type="submit" name="button2" value="  确定  " style="width:70px" />                                    </td>
                            <td width="32%" align="center" nowrap="nowrap" class="small"> 共 1 页，<img src="../images/previous_disabled.gif" border="0" align="absmiddle" alt="上一页"/> 当前第&nbsp;1&nbsp;页&nbsp; <img src="../images/next_disabled.gif" border="0" align="absmiddle" alt="下一页"/> </td>
                            <td width="30%" align="right" class="small" style="padding-right:20px">每页显示 10 条记录</td>
                          </tr>
                        </tbody>
                      </table>
                  </div>
                </div></td>
              </tr>
            </tbody>
          </table>
        </div></td>
      </tr>
    </tbody>
  </table>        
</div>