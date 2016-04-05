<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'login.jsp' starting page</title>
<link rel="stylesheet" type="text/css" href="./css/mainFrame.css">    
  </head>
  
 <body>
<jsp:include page="/WEB-INF/univFrame.jsp"></jsp:include>
<div class="box">

<c:forEach var="cate_board" items="${cate_board}">
<div class="cate">
<a href="<%=this.getServletContext().getContextPath()%>/category.do?flag=gotoShowCateUi&id=${cate_board.key.id}">${cate_board.key.name}</a><br/>
</div>
<c:forEach var="board" items="${cate_board.value}">
<div class="board">
<a href="<%=this.getServletContext().getContextPath()%>/board.do?flag=gotoShowBoardUi&id=${board.id}">${board.name}</a><br/>
<span>主题：${board.postCount}帖数：${board.replyCount}<br/></span>
<span>最后发表：${board.lastPost.postTime}</span>
</div>
</c:forEach>
</c:forEach>
</div>
  </body> 
</html>