<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'mainView.jsp' starting page</title>
  </head>
  
  <body> 
主界面 <br/>
<c:forEach items="${userlist}" var="user">
<c:out value="${user.name}"></c:out>
<img src="/strutsupanddown/file/${user.newpName}" width="50px"/>
<a href="/strutsupanddown/download.do?user=${user.name}" >点击下载</a>
<br/>

</c:forEach> 
  </body>
</html>
