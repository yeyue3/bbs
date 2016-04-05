<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'login.jsp' starting page</title> 
<link rel="stylesheet" type="text/css" href="./css/person/showUser.css"> 
  </head>
  
 <body>
<jsp:include page="/WEB-INF/univFrame.jsp"></jsp:include>
<div class="box">
<div>
<c:choose>
<c:when test="${person.photoName!=null}">
<img src="<%=this.getServletContext().getContextPath()%>/photo/${person.photoName}"/ width="70px" height="70px">
</c:when>
<c:otherwise>
<img src="<%=this.getServletContext().getContextPath()%>/photo/default.jpg"/ width="70px" height="70px">
</c:otherwise>
</c:choose><br/>
${person.name}
</div>
<c:if test="${isSelf=='true'}">
<a href="<%=this.getServletContext().getContextPath()%>/person.do?flag=gotoChangeUserUi">完善个人信息</a>
</c:if>
<div>
<table>
<tr><td>用户名</td><td>${person.name}</td></tr>
<tr><td>性　别</td><td>${person.sex}</td></tr>
<tr><td>邮　箱</td><td>${person.email}</td></tr>
<tr><td>年　龄</td><td>${person.age}</td></tr>
</table>
</div>
主题
<table>
<c:forEach var="post" items="${posts}">
<tr><td><a href="<%=this.getServletContext().getContextPath()%>/post.do?flag=gotoShowPostUi&id=${post.id }">${post.title}</a></td><td>${post.dateLastReplied}</td></tr>
</c:forEach>
</table>
<a href="">查看更多</a><!-- 未完成  -->
</div>
  </body> 
</html>