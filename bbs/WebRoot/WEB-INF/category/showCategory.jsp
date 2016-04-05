<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'login.jsp' starting page</title> 
<link rel="stylesheet" type="text/css" href="./css/category/showCategory.css"> 
  </head>
  
 <body>
<jsp:include page="/WEB-INF/univFrame.jsp"></jsp:include>
<div class="box">
<div class="cate">
<h2>${cate.name}<br/></h2>
<span>　　${cate.description}</span>
</div>

<c:forEach items="${boards}" var="board">
<div class="board">
<a href="<%=this.getServletContext().getContextPath()%>/board.do?flag=gotoShowBoardUi&id=${board.id}">${board.name}</a>
<span>主题：${board.postCount}　帖数：${board.replyCount}<br/></span>
<span>最后发表：${board.lastPost.title}　</span>
</div>
</c:forEach>

</div>
  </body> 
</html>