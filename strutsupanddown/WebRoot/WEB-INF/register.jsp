<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'register.jsp' starting page</title>
    

  </head>
  
  <body>
    <form enctype="multipart/form-data" action="/strutsupanddown/regi.do" method="post">
	用户:<input type="text" name="username" /><br/>
	头像:<input type="file" name="myPhoto" /><br/>
	<input type="submit" value="注册" /><br/>
</form>
  </body>
</html>
