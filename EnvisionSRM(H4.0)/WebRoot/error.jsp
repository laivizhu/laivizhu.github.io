<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>请求失败</title>
    <jsp:include page="common/basicInclude.jsp"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	
  </head>
  
 <body class="small" style="margin:0;">
<!-- 网站顶部 -->
<jsp:include page="common/top.jsp" flush="true"/>
<!-- 网站导航 -->
<jsp:include page="common/navigation.jsp" flush="true"/>
<center>
<h1>请求提交失败</h1>
	<s:if test="hasActionErrors()">         
         <s:iterator value="actionErrors">         
             <h2><font color="red"><s:property escape="false"/></font></h2>         
        </s:iterator>         
     </s:if>
     <input type="button" class="crmbutton small cancel" onclick="window.history.back()" value="返回">
</center>

  </body>
</html>
