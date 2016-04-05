<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'login.jsp' starting page</title> 
<link rel="stylesheet" type="text/css" href="./css/board/showBoard.css"> 
  </head>
  
 <body>
<jsp:include page="/WEB-INF/univFrame.jsp"></jsp:include>
<div class="box">
<div class="postin">
<form action="<%=this.getServletContext().getContextPath()%>/login.do?flag=checkLogin&operate=post&board_id=${board.id}" method="post">
<input type="submit" value="版内发帖" />
</form>
</div>

<!-- 分页 -->
<div class="page">
<c:if test="${pageNow!=1}">
<a href="<%=this.getServletContext().getContextPath()%>/board.do?flag=gotoShowBoardUi&id=${board.id}&pageNow=${pageNow-1}">上一页</a>
</c:if>
<c:forEach begin="1" end="${pageCount}" var="page">
<a href="<%=this.getServletContext().getContextPath()%>/board.do?flag=gotoShowBoardUi&id=${board.id}&pageNow=${page}">${page}</a>
</c:forEach>
<c:if test="${pageNow!=pageCount}">
<a href="<%=this.getServletContext().getContextPath()%>/board.do?flag=gotoShowBoardUi&id=${board.id}&pageNow=${pageNow+1}">下一页</a>
</c:if>
</div>
<!-- 分页结束 -->

<!-- 帖子列表 -->
<div class="postList">
<table style="font-size: 10px" >
<tr><td width="486px" align="left"><h2>主题</h2></td><td width="120px"><h2>作者</h2></td><td width="120px"><h2>回复/查看</h2></td><td width="260px"><h2>最后发表</h2></td></tr>
<c:forEach var="post" items="${posts}">
<tr><td align="left"><a href="<%=this.getServletContext().getContextPath()%>/post.do?flag=gotoShowPostUi&id=${post.id }">${post.title}</a></td>
<td>${post.author.name}<br/>${post.postTime}</td><td>${post.replyCount}<br/>${post.hit}</td><td>${post.lastReplied.name}<br/>${post.dateLastReplied}</td></tr>
</c:forEach>
</table>
</div>
</div>
  </body> 
</html>