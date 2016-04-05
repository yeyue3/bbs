<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'login.jsp' starting page</title> 
<link rel="stylesheet" type="text/css" href="./css/login.css">   
  </head>
  
 <body>
<jsp:include page="/WEB-INF/univFrame.jsp"></jsp:include>
<div class="box">
<form action="<%=this.getServletContext().getContextPath() %>/login.do?flag=loginCheck" method="post">
	<table>
	<tr><td>帐　号</td><td><input type="text" name="id" style="width: 130px"/></td></tr>
	<tr><td>密　码</td><td><input type="password" name="password" style="width: 130px"/></td></tr>
	<tr><td><input type="submit" value="登录" /></td><td><input type="reset" value="重新填写"/></td></tr>
	<tr><td><input type="checkbox" name="rember" value="true"/></td><td>记住用户名和密码</td></tr>
	</table>
	</form>
</div>
  </body> 
</html>