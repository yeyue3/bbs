<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'login.jsp' starting page</title>

	<link rel="stylesheet" type="text/css" href="./css/univFrame.css">    

  </head>
  
 <body>
<div id="all">
<div class="post">
<form action="<%=this.getServletContext().getContextPath()%>/login.do?flag=checkLogin&operate=post" method="post">
<input type="submit" value="发帖" />
</form>
<a href="<%=this.getServletContext().getContextPath()%>/mainUi.do?flag=gotoMainUi">主界面直达</a>
</div>
<div class="login">
<c:if test="${user!=null}">
<a href="<%=this.getServletContext().getContextPath()%>/person.do?flag=gotoShowUserUi">
<c:choose>
<c:when test="${user.photoName!=null}">
<img src="<%=this.getServletContext().getContextPath()%>/photo/${user.photoName}"/ width="70px" height="70px">
</c:when>
<c:otherwise>
<img src="<%=this.getServletContext().getContextPath()%>/photo/default.jpg"/ width="70px" height="70px">
</c:otherwise>
</c:choose>
</a>
<span>
<a href="<%=this.getServletContext().getContextPath()%>/login.do?flag=loginOut">退出登陆</a>
<a href="">${user.name}</a>
</span>
</c:if>

<c:if test="${user==null}">
<span>
<a href="<%=this.getServletContext().getContextPath()%>/login.do?flag=gotoLoginUi">登录</a>
<a href="<%=this.getServletContext().getContextPath()%>/person.do?flag=gotoRegisterUi">注册</a>
</span>
</c:if>
</div>
</div>
  </body> 
</html>