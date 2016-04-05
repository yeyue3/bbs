<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'login.jsp' starting page</title> 
<link rel="stylesheet" type="text/css" href="./css/person/registerUi.css"> 
  </head>
  
 <body>
<jsp:include page="/WEB-INF/univFrame.jsp"></jsp:include>
<div class="box">
注册界面<a href="">已有帐号？现在登录</a>


<form action="<%=this.getServletContext().getContextPath()%>/person.do?flag=register" method="post">
<table>
<tr><td>用户名</td><td><input type="text" name="name"></td></tr>
<tr><td>密码</td><td><input type="password"></td></tr>
<tr><td>确认密码</td><td><input type="password" name="password"></td></tr>
<tr><td>邮箱</td><td><input type="text" name="email"></td></tr>
<tr><td><input type="submit" value="提交"/></td><td><input type="reset" value="重新填写"/></td></tr>
</table>
</form>
</div>
  </body> 
</html>
