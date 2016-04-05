<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'login.jsp' starting page</title> 
<link rel="stylesheet" type="text/css" href="./css/post/changePost.css"> 
  </head>
  
 <body>
<jsp:include page="/WEB-INF/univFrame.jsp"></jsp:include>
<div class="box"> 
修改帖子
<form action="<%=this.getServletContext().getContextPath()%>/post.do?flag=change&id=${post.id}" method="post">
<input type="text" name="title" value="${post.title}"></input><br/>
<textarea rows="50" cols="100" name="content">${post.content}</textarea>
<input type="submit" value="保存"/>
</form>
</div>
  </body> 
</html>