<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'login.jsp' starting page</title> 
<link rel="stylesheet" type="text/css" href="./css/post/cateChoose.css"> 
  </head>
  
 <body>
<jsp:include page="/WEB-INF/univFrame.jsp"></jsp:include>
<div class="box">
<h1>请选择所要发帖的版块</h1><br/>
<table>
<c:forEach items="${categorys}" var="category">
<div class="cate">
<a href="<%=this.getServletContext().getContextPath()%>/post.do?flag=gotoAddPostUi&cate=${category.id }">${category.name}</a><br/>
<span>${category.description}</span>
</div>
</c:forEach>
</table>
</div>
  </body> 
</html>