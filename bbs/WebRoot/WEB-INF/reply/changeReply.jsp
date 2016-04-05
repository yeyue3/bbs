<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'login.jsp' starting page</title> 
<link rel="stylesheet" type="text/css" href="./css/reply/changeReply.css"> 
  </head>
  
 <body> 
<jsp:include page="/WEB-INF/univFrame.jsp"></jsp:include>
<div class="box">
修改回复
<form action="<%=this.getServletContext().getContextPath()%>/reply.do?flag=change&id=${reply.id}" method="post">
<textarea rows="50" cols="100" name="content">${reply.content}</textarea>
<input type="submit" value="保存"/>
</form>
</div>
  </body> 
</html>