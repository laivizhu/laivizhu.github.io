<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<script language="javascript" type="text/javascript" src="../js/general.js"></script>
<div id="div6" class="small" style="width:100%;position:relative;display:none">
  <form name="contractConfirm" action="" >
    <table border="0" cellspacing="1" cellpadding="0" width="100%" class="lvtBg"><tbody>
      <tr><td>
      <table border="0" cellspacing="1" cellpadding="0" width="100%" class="lvtBg" >
              <tbody>
                <tr>
                  <td><div class="calDIV" style="overflow:auto;">
                  <table border="0" cellspacing="1" cellpadding="3" width="100%" class="lvt small">
                <tbody>
                  <tr>
                    <td width="10%" nowrap="nowrap" class="lvtCol">领域</td>
                    <td width="20%" nowrap="nowrap" class="lvtCol">指标</td>
                    <td width="10%"  class="lvtCol">权重</td>
                    <td width="10%"  class="lvtCol">采购</td>
                    <td width="10%"  class="lvtCol">质量工程(不含SQE)</td>
                    <td width="10%"  class="lvtCol">SQE</td>
                    <td width="10%"  class="lvtCol">制造(不含计划物流)</td>
                    <td width="10%"  class="lvtCol">计划/物流</td>
                    <td width="5%"  class="lvtCol">研发</td>
                  </tr>
                  <tr>
                    <td width="10%" nowrap="nowrap" class="lvtColData">质量</td>
                    <td width="20%" class="lvtColData">质量水平</td>
                    <td width="10%" class="td_border"><input type="text" name="" size="1" maxlength="1" class="input_score"/></td>
                    <td width="10%" class="td_border"><input type="text" name="input" size="1" maxlength="1" class="input_score"/></td>
                    <td width="10%" class="td_border"><input type="text" name="input2" size="1" maxlength="1" class="input_score"/></td>
                    <td width="10%" class="td_border"><input type="text" name="input3" size="1" maxlength="1" class="input_score"/></td>
                    <td width="10%" class="td_border"><input type="text" name="input4" size="1" maxlength="1" class="input_score"/></td>
                    <td width="10%" class="td_border">&nbsp;</td>
                    <td width="10%" class="td_border">&nbsp;</td>
                  </tr>
                  <tr>
                    <td width="10%" class="lvtColData">交货</td>
                    <td width="20%" class="lvtColData">准交情况</td>
                    <td width="10%" class="td_border"><input type="text" name="input10" size="1" maxlength="1" class="input_score"/></td>
                    <td width="10%" class="td_border"><input type="text" name="input11" size="1" maxlength="1" class="input_score"/></td>
                    <td width="10%" class="td_border">&nbsp;</td>
                    <td width="10%" class="td_border">&nbsp;</td>
                    <td width="10%" class="td_border">&nbsp;</td>
                    <td width="10%" class="td_border"><input type="text" name="input5" size="1" maxlength="1" class="input_score"/></td>
                    <td width="10%" class="td_border"><input type="text" name="input6" size="1" maxlength="1" class="input_score"/></td>
                  </tr>
                  <tr>
                    <td width="10%" rowspan="2" class="lvtColData">成本</td>
                    <td width="20%" nowrap="nowrap" class="lvtColData">总体拥有成本(TCO)</td>
                    <td width="10%" class="td_border"><input type="text" name="input9" size="1" maxlength="1" class="input_score"/></td>
                    <td width="10%" class="td_border"><input type="text" name="input8" size="1" maxlength="1" class="input_score"/></td>
                    <td width="10%" class="td_border">&nbsp;</td>
                    <td width="10%" class="td_border">&nbsp;</td>
                    <td width="10%" class="td_border">&nbsp;</td>
                    <td width="10%" class="td_border">&nbsp;</td>
                    <td width="10%" class="td_border"><input type="text" name="input7" size="1" maxlength="1" class="input_score"/></td>
                  </tr>
                  <tr>
                    <td width="20%" class="lvtColData">合同条款</td>
                    <td width="10%" class="td_border"><input type="text" name="input12" size="1" maxlength="1" class="input_score"/></td>
                    <td width="10%" class="td_border"><input type="text" name="input16" size="1" maxlength="1" class="input_score"/></td>
                    <td width="10%" class="td_border">&nbsp;</td>
                    <td width="10%" class="td_border">&nbsp;</td>
                    <td width="10%" class="td_border">&nbsp;</td>
                    <td width="10%" class="td_border">&nbsp;</td>
                    <td width="10%" class="td_border">&nbsp;</td>
                  </tr>
                  <tr>
                    <td width="10%" rowspan="3" class="lvtColData">服务</td>
                    <td width="20%" class="lvtColData">新产品开发</td>
                    <td width="10%" class="td_border"><input type="text" name="input13" size="1" maxlength="1" class="input_score"/></td>
                    <td width="10%" class="td_border"><input type="text" name="input17" size="1" maxlength="1" class="input_score"/></td>
                    <td width="10%" class="td_border">&nbsp;</td>
                    <td width="10%" class="td_border">&nbsp;</td>
                    <td width="10%" class="td_border">&nbsp;</td>
                    <td width="10%" class="td_border">&nbsp;</td>
                    <td width="10%" class="td_border"><input type="text" name="input27" size="1" maxlength="1" class="input_score"/></td>
                  </tr>
                  <tr>
                    <td width="20%" class="lvtColData">风场售后服务</td>
                    <td width="10%" class="td_border"><input type="text" name="input14" size="1" maxlength="1" class="input_score"/></td>
                    <td width="10%" class="td_border"><input type="text" name="input18" size="1" maxlength="1" class="input_score"/></td>
                    <td width="10%" class="td_border"><input type="text" name="input20" size="1" maxlength="1" class="input_score"/></td>
                    <td width="10%" class="td_border"><input type="text" name="input22" size="1" maxlength="1" class="input_score"/></td>
                    <td width="10%" class="td_border">&nbsp;</td>
                    <td width="10%" class="td_border">&nbsp;</td>
                    <td width="10%" class="td_border">&nbsp;</td>
                  </tr>
                  <tr>
                    <td width="20%" class="lvtColData">协同与配合</td>
                    <td width="10%" class="td_border"><input type="text" name="input15" size="1" maxlength="1" class="input_score"/></td>
                    <td width="10%" class="td_border"><input type="text" name="input19" size="1" maxlength="1" class="input_score"/></td>
                    <td width="10%" class="td_border"><input type="text" name="input21" size="1" maxlength="1" class="input_score"/></td>
                    <td width="10%" class="td_border"><input type="text" name="input23" size="1" maxlength="1" class="input_score"/></td>
                    <td width="10%" class="td_border"><input type="text" name="input24" size="1" maxlength="1" class="input_score"/></td>
                    <td width="10%" class="td_border"><input type="text" name="input25" size="1" maxlength="1" class="input_score"/></td>
                    <td width="10%" class="td_border"><input type="text" name="input26" size="1" maxlength="1" class="input_score"/></td>
                  </tr>
                  <tr>
                    <td bgcolor="#FFFFFF" colspan="10" height="40px;" style="padding:5px"><div align="center">
                        <input title="确定 [Alt+S]" accesskey="S" class="crmbutton small save"  onclick="show2();" type="submit" name="button" value="确定" style="width:70px" />
                        &nbsp;
                        <input title="取消 [Alt+X]" accesskey="X" class="crmbutton small cancel" onclick="window.location.href('supplier_in.jsp')"  type="button" name="button" value="  取消  " style="width:70px" />
                      </div></td>
                  </tr>
                </tbody>
              </table>
                  </div></td>
                </tr>
              </tbody>
            </table>
      <tr><td>
   </tbody></table>
  </form>
  <div style="margin-top:83px;"></div>
</div>