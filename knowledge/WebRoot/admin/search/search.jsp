<%--
	User: janlu.sword@gmail.com
	Time: 12-11-11 下午11:08
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>错误笔记查询</title>
	<link rel="stylesheet" type="text/css" href="../../css/bootstrap/bootstrap.css"/>
	<link rel="stylesheet" type="text/css" href="../../css/bootstrap/bootstrap-responsive.css"/>
	<link rel="stylesheet" type="text/css" href="../../css/lanrenzhijia.css" />
	<jsp:include page="../../common/includeJs.jsp"/>
	<script type="text/javascript" src="../../js/bootstrap.js"></script>
	<script type="text/javascript" src="../../js/lanrenzhijia.js"></script>
	<script type="text/javascript">
		$(document).ready(function(e){
			laivi.getJson('search_topKeywordList.action', function(data){
				var topDiv=$("#div1");
				var count=0;
				$.each(data.root,function(i,item){
					count++;
					if(count<=5){
						topDiv.append('<a href='+item.url+' class="red">'+item.keyword+'</a>');
					}else if(count>5 && count<=10){
						topDiv.append('<a href='+item.url+' class="blue">'+item.keyword+'</a>');
					}else{
						topDiv.append('<a href='+item.url+' class="yellow">'+item.keyword+'</a>');
					}
					
				});
				load3DKeyword();
			});
		});
		var search=function(){
			var value=$("#searchKeywordId").val();
			window.location.href='search_result.jsp?value='+value;
		};
	</script>
</head>
<body>
<form action="search">
<table width="100%" border="0" height="100%">
  <tr>
    <td width="10%">&nbsp;</td>
    <td width="80%">&nbsp;</td>
    <td width="10%">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td align="center">
    	<div id="div1">
    		
    	</div>
    </td>
    <td>&nbsp;</td>
  </tr>

  <tr>
    <td>&nbsp;</td>
    <td align="center">
    <!-- <div class="navbar navbar-inverse" style="width:35%">
      <div class="navbar-inner">
        <div class="container">
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><a href="#">Error</a></li>
              <li><a href="#">Information</a></li>
              <li><a href="#">More</a></li>
            </ul>
          </div>/.nav-collapse
        </div>
      </div>
    </div> -->
    </td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>
        <div align="center">
            <input id='searchKeywordId' type="text" class="span2"  style="width:95%;height:32px">
        </div>
</td>
    <td>
        <div align="left">
            <button  type="button" onclick="search()" class="btn">搜索</button>
        </div>
    </td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
</form>
</body>
</html>
		