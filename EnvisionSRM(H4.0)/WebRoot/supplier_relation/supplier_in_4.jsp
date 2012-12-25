<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="../css/style.css"/>
<script language="javascript" type="text/javascript" src="../js/general.js"></script>
<div id="div4" class="small" style="width:100%;position:relative;display:none">
  <form name="contractApproval" action="" >
    <table border="0" cellspacing="1" cellpadding="0" width="100%" class="lvtBg">
      <tbody>
        <tr>
          <td><table border="0" cellspacing="1" cellpadding="0" width="100%" class="lvtBg" >
              <tbody>
                <tr>
                  <td><div class="calDIV" style="overflow:auto;">
                      <table border="0" cellspacing="1" cellpadding="3" width="100%"  class="lvt small">
                        <tbody>
                           <!--字段-->
                          <tr>
                            <td class="lvtCol" nowrap="nowrap">领域</td>
                            <td class="lvtCol" nowrap="nowrap">指标</td>
                            <td class="lvtCol" nowrap="nowrap">生产型-关键</td>
                            <td class="lvtCol" nowrap="nowrap">评分部门</td>
                            <td class="lvtCol" nowrap="nowrap">采购</td>
                            <td class="lvtCol" nowrap="nowrap">SQE</td>
                            <td class="lvtCol" nowrap="nowrap">制造</td>
                            <td class="lvtCol" nowrap="nowrap">质量</td>
                            <td class="lvtCol" nowrap="nowrap">计划物流</td>
                            <td class="lvtCol" nowrap="nowrap">研发</td>
                          </tr>
                          <!--M管理-->
                          <tr>
                            <td rowspan="5" nowrap="nowrap" class="lvtColData">M-管理</td>
                            <td class="lvtColData" nowrap="nowrap">环境、安全和健康</td>
                            <td class="lvtColData">10%</td>
                            <td class="lvtColData">采购</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                          </tr>
                          <tr>
                            <td class="lvtColData" nowrap="nowrap">经营业绩及产品地位</td>
                            <td class="lvtColData">20%</td>
                            <td class="lvtColData">采购</td>
                            <td class="td_border"><input type="text" name="input" size="1" maxlength="1" class="input_score"/></td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                          </tr>
                          <tr>
                            <td class="lvtColData">年度审核 </td>
                            <td class="lvtColData">45%</td>
                            <td class="lvtColData">采购</td>
                            <td class="td_border"><input type="text" name="input" size="1" maxlength="1" class="input_score"/>                            </td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                          </tr>
                          <tr>
                            <td class="lvtColData">合作愿景 </td>
                            <td class="lvtColData">25%</td>
                            <td class="lvtColData">采购</td>
                            <td class="td_border"><input type="text" name="input" size="1" maxlength="1" class="input_score"/></td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                          </tr>
                          <tr>
                            <td class="lvtColData">贸易资质 </td>
                            <td class="lvtColData">0%</td>
                            <td class="lvtColData">采购</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                          </tr>
                          <!--Q质量-->
                          <tr>
                            <td rowspan="5" class="lvtColData">Q-质量</td>
                            <td class="lvtColData" nowrap="nowrap">质量管理体系</td>
                            <td class="lvtColData">10%</td>
                            <td class="lvtColData">SQE</td>
                            <td class="td_border"><input type="text" name="input" size="1" maxlength="1" class="input_score"/></td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                          </tr>
                          <tr>
                            <td class="lvtColData" nowrap="nowrap">质量管理体系能力建设</td>
                            <td class="lvtColData">10%</td>
                            <td class="lvtColData">SQE</td>
                            <td class="td_border"><input type="text" name="input" size="1" maxlength="1" class="input_score"/></td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                          </tr>
                          <tr>
                            <td class="lvtColData">工厂停线</td>
                            <td class="lvtColData">20%</td>
                            <td class="lvtColData">制造</td>
                            <td class="td_border"><input type="text" name="input" size="1" maxlength="1" class="input_score"/></td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                          </tr>
                          <tr>
                            <td class="lvtColData" nowrap="nowrap">入厂不合格率</td>
                            <td class="lvtColData" nowrap="nowrap">*可以计算入厂</td>
                            <td class="lvtColData">SQE</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border"><input type="text" name="input" size="1" maxlength="1" class="input_score"/></td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                          </tr>
                          <tr>
                            <td class="lvtColData" nowrap="nowrap">风场质量合格率</td>
                            <td class="lvtColData" nowrap="nowrap">*无法计算入厂</td>
                            <td class="lvtColData">质量</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border"><input type="text" name="input" size="1" maxlength="1" class="input_score"/></td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                          </tr>
                          <!--C成本-->
                          <tr>
                            <td rowspan="5" class="lvtColData">C-成本</td>
                            <td class="lvtColData" nowrap="nowrap">成本改进表现</td>
                            <td class="lvtColData">15%</td>
                            <td class="lvtColData">采购</td>
                            <td class="td_border"><input type="text" name="input" size="1" maxlength="1" class="input_score"/></td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                          </tr>
                          <tr>
                            <td class="lvtColData" nowrap="nowrap">单价降低比率</td>
                            <td class="lvtColData">40%</td>
                            <td class="lvtColData">采购</td>
                            <td class="td_border"><input type="text" name="input" size="1" maxlength="1" class="input_score"/></td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                          </tr>
                          <tr>
                            <td class="lvtColData">成本透明度</td>
                            <td class="lvtColData">15%</td>
                            <td class="lvtColData">采购</td>
                            <td class="td_border"><input type="text" name="input" size="1" maxlength="1" class="input_score"/></td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                          </tr>
                          <tr>
                            <td class="lvtColData">质保条款</td>
                            <td class="lvtColData">10%</td>
                            <td class="lvtColData">采购</td>
                            <td class="td_border"><input type="text" name="input" size="1" maxlength="1" class="input_score"/></td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                          </tr>
                          <tr>
                            <td class="lvtColData">付款方式 </td>
                            <td class="lvtColData">20%</td>
                            <td class="lvtColData">采购</td>
                            <td class="td_border"><input type="text" name="input" size="1" maxlength="1" class="input_score"/></td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                          </tr>
                          <!--D交付-->
                          <tr>
                            <td rowspan="4" class="lvtColData">D-交付</td>
                            <td class="lvtColData" nowrap="nowrap">交货准时率 </td>
                            <td class="lvtColData">40%</td>
                            <td class="lvtColData">计划物流</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border"><input type="text" name="input" size="1" maxlength="1" class="input_score"/></td>
                            <td class="td_border">&nbsp;</td>
                          </tr>
                          <tr>
                            <td class="lvtColData" nowrap="nowrap">交货准确率 </td>
                            <td class="lvtColData">20%</td>
                            <td class="lvtColData">采购</td>
                            <td class="td_border"><input type="text" name="input" size="1" maxlength="1" class="input_score"/></td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                          </tr>
                          <tr>
                            <td class="lvtColData" nowrap="nowrap">交货管理体系 </td>
                            <td class="lvtColData">10%</td>
                            <td class="lvtColData">采购，计划物流</td>
                            <td class="td_border"><input type="text" name="input" size="1" maxlength="1" class="input_score"/></td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                          </tr>
                          <tr>
                            <td class="lvtColData">工厂停线 </td>
                            <td class="lvtColData">30%</td>
                            <td class="lvtColData">制造</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border"><input type="text" name="input" size="1" maxlength="1" class="input_score"/></td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                          </tr>
                          <!--S协作-->
                          <tr>
                            <td rowspan="5" class="lvtColData">D-交付</td>
                            <td class="lvtColData">售后服务 </td>
                            <td class="lvtColData">20%</td>
                            <td class="lvtColData">质量</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border"><input type="text" name="input" size="1" maxlength="1" class="input_score"/></td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                          </tr>
                          <tr>
                            <td class="lvtColData" nowrap="nowrap">质量协作度</td>
                            <td class="lvtColData">20%</td>
                            <td class="lvtColData">质量，SQE</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border"><input type="text" name="input" size="1" maxlength="1" class="input_score"/></td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border"><input type="text" name="input" size="1" maxlength="1" class="input_score"/></td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                          </tr>
                          <tr>
                            <td class="lvtColData" nowrap="nowrap">技术协作度</td>
                            <td class="lvtColData">20%</td>
                            <td class="lvtColData">研发</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border"><input type="text" name="input" size="1" maxlength="1" class="input_score"/></td>
                          </tr>
                          <tr>
                            <td class="lvtColData" nowrap="nowrap">采购协作度</td>
                            <td class="lvtColData">20%</td>
                            <td class="lvtColData">采购</td>
                            <td class="td_border"><input type="text" name="input" size="1" maxlength="1" class="input_score"/></td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                          </tr>
                          <tr>
                            <td class="lvtColData" nowrap="nowrap">供应协作度</td>
                            <td class="lvtColData">20%</td>
                            <td class="lvtColData">计划物流</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border"><input type="text" name="input" size="1" maxlength="1" class="input_score"/></td>
                            <td class="td_border">&nbsp;</td>
                          </tr>
                          <!--T技术-->
                          <tr>
                            <td rowspan="5" class="lvtColData">T-技术</td>
                            <td class="lvtColData">售后服务 </td>
                            <td class="lvtColData">20%</td>
                            <td class="lvtColData">研发</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border"><input type="text" name="input" size="1" maxlength="1" class="input_score"/></td>
                          </tr>
                          <tr>
                            <td class="lvtColData" nowrap="nowrap">质量协作度</td>
                            <td class="lvtColData">20%</td>
                            <td class="lvtColData">质量</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border"><input type="text" name="input" size="1" maxlength="1" class="input_score"/></td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                          </tr>
                          <tr>
                            <td class="lvtColData" nowrap="nowrap">技术协作度</td>
                            <td class="lvtColData">20%</td>
                            <td class="lvtColData">研发</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border"><input type="text" name="input" size="1" maxlength="1" class="input_score"/></td>
                          </tr>
                          <tr>
                            <td class="lvtColData" nowrap="nowrap">采购协作度</td>
                            <td class="lvtColData">20%</td>
                            <td class="lvtColData">采购</td>
                            <td class="td_border"><input type="text" name="input" size="1" maxlength="1" class="input_score"/></td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                          </tr>
                          <tr>
                            <td class="lvtColData" nowrap="nowrap">供应协作度</td>
                            <td class="lvtColData">20%</td>
                            <td class="lvtColData">计划物流</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border">&nbsp;</td>
                            <td class="td_border"><input type="text" name="input" size="1" maxlength="1" class="input_score"/></td>
                            <td class="td_border">&nbsp;</td>
                          </tr>
                          <tr>
                            <td bgcolor="#FFFFFF" colspan="11" height="40" style="padding:5px"><div align="center">
                                <input title="确定 [Alt+S]" accesskey="S" class="crmbutton small save"  onclick="show2();" type="submit" name="button" value="确定" style="width:70px" />&nbsp;
                                <input title="取消 [Alt+X]" accesskey="X" class="crmbutton small cancel" onclick="window.location.href('supplier_in.jsp')"  type="button" name="button" value="  取消  " style="width:70px" />
                              </div></td>
                          </tr>
                        </tbody>
                      </table>
                    </div></td>
                </tr>
              </tbody>
            </table></td></tr>
      </tbody>
    </table>
  </form>
</div>
