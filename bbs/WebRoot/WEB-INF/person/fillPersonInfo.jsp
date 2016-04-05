<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'login.jsp' starting page</title> 
<link rel="stylesheet" type="text/css" href="./css/person/fillPersonInfo.css"> 
  </head>
  
 <body>
<jsp:include page="/WEB-INF/univFrame.jsp"></jsp:include>
<div class="box">
<c:choose>
<c:when test="${user.photoName!=null}">
<img src="<%=this.getServletContext().getContextPath()%>/photo/${user.photoName}"/ width="70px" height="70px">
</c:when>
<c:otherwise>
<img src="<%=this.getServletContext().getContextPath()%>/photo/default.jpg"/ width="70px" height="70px">
</c:otherwise>
</c:choose><br/>
<!--enctype:规定表单数据在发送到服务器之前应该如何编码
"multipart/form-data"：不对字符编码，在使用包含文件上传控件的表单时，必须使用该值 -->
<form enctype="multipart/form-data" action="<%=this.getServletContext().getContextPath()%>/person.do?flag=change" method="post">
上传新头像<br/>
<input type="file" name="myPhoto" value="选择文件"/><br/>
${user.name}
<table>
<tr><td>性别</td><td><select name="sex" >
<c:choose>
<c:when test="${user.sex=='男'}">
<option value="男" selected="selected">男</option><option value="女">女</option>
</c:when>
<c:otherwise>
<option value="男">男</option><option value="女" selected="selected">女</option>
</c:otherwise>
</c:choose>
</select>
</td></tr>
<tr><td>年龄</td><td><input type="text" name="age" value="${user.age}"></td></tr>
<tr><td>邮箱</td><td><input type="text" name="email" value="${user.email}"></td></tr>
<tr><td><input type="submit" value="提交"/></td><td><input type="reset" value="重新填写"></td></tr>
</table>
</form>
</div>
  </body> 
</html>