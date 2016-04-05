<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%

String path = request.getContextPath();

String basePath = request.getScheme() + "://"

+ request.getServerName() + ":" + request.getServerPort()

+ path + "/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

 

 

<html>

<head>

<base href="<%=basePath%>">

 

<title>My JSP 'index.jsp' starting page</title>

 

<meta http-equiv="pragma" content="no-cache">

<meta http-equiv="cache-control" content="no-cache">

<meta http-equiv="expires" content="0">

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">

<meta http-equiv="description" content="This is my page">

 

<link rel="stylesheet" type="text/css" href="css/layout.css">

<link rel="stylesheet" href="kindeditor/themes/default/default.css" />

<link rel="stylesheet" href="kindeditor/plugins/code/prettify.css" />

<script charset="utf-8" src="kindeditor/kindeditor.js">

</script>

<script charset="utf-8" src="kindeditor/lang/zh_CN.js">

</script>

<script charset="utf-8" src="kindeditor/plugins/code/prettify.js">

</script>

<script>

KindEditor.ready(function(K) {

var editor1 = K.create('textarea[name="article.content1"]', {

cssPath : 'kindeditor/plugins/code/prettify.css',

uploadJson : 'kindeditor/jsp/upload_json.jsp',

fileManagerJson : 'kindeditor/jsp/file_manager_json.jsp',

allowFileManager : true,

afterCreate : function() {

var self = this;

K.ctrl(document, 13, function() {

self.sync();

document.forms['example'].submit();

});

K.ctrl(self.edit.doc, 13, function() {

self.sync();

document.forms['example'].submit();

});

}

});

prettyPrint();

});

</script>

</head>

 

<body>

<div id="container">

<div id="header">

</div>

<div id="menu">

<ul>

<li>

<a href="main.jsp">首页</a>

</li>

<li>

<a href="jsp/update_password.jsp">个人信息</a>

</li>

<li>

<a href="jsp/article_add.jsp">提交论文</a>

</li>

<li>

<a href="article_returnList.action">审批论文</a>

</li>

<li>

<a href="#">后台管理</a>

</li>

</ul>

</div>

<div id="mainContent">

 

<form name="example" method="post" action="article_add.action">

题目：

<input  type="text" name="article.title">

<br />

内容：

<textarea name="article.content1" cols="100" rows="8"

></textarea>

<br />

<input type="submit" name="button" value="提交" />

(提交快捷键: Ctrl + Enter)

</form>

</div>

<div id="footer">

Copyright 2012 by Lai Xuansi.

</div>

</div>

</body>

</html>