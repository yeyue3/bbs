<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
    <title>My JSP 'login.jsp' starting page</title> 
<link rel="stylesheet" type="text/css" href="./css/post/showPost.css"> 

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

var editor1 = K.create('textarea[name="content"]', {

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
<jsp:include page="/WEB-INF/univFrame.jsp"></jsp:include>
<div class="box">
<div class="replyup">
<!--  <form action="#rep">
<input type="submit" value="回复" />
</form>-->
<a href="<%=this.getServletContext().getContextPath()%>/post.do?flag=gotoShowPostUi&id=${post.id }#rep">回复</a>
</div>

<!-- 分页 -->
<div class="page">
<c:if test="${pageNow!=1}">
<a href="<%=this.getServletContext().getContextPath()%>/post.do?flag=gotoShowPostUi&id=${post.id}&pageNow=${pageNow-1}">上一页</a>
</c:if>
<c:forEach begin="1" end="${pageCount}" var="page">
<a href="<%=this.getServletContext().getContextPath()%>/post.do?flag=gotoShowPostUi&id=${post.id}&pageNow=${page}">${page}</a>
</c:forEach>
<c:if test="${pageNow!=pageCount}">
<a href="<%=this.getServletContext().getContextPath()%>/post.do?flag=gotoShowPostUi&id=${post.id}&pageNow=${pageNow+1}">下一页</a>
</c:if>
</div>
<!-- 分页结束 -->

<h3>回复：${post.replyCount}　查看：${post.hit}</h3>
<h2>${post.title}</h2>
<!-- 第一页显示楼主 -->
<c:if test="${pageNow==1}">
<div class="person">
<div class="rowfl">${post.author.name}</div>
<a href="<%=this.getServletContext().getContextPath()%>/person.do?flag=gotoShowUserUi&userid=${post.author.id}">
<img src="<%=this.getServletContext().getContextPath()%>/photo/${post.author.photoName}" ></img>
</a><br/>
主题：${post.author.postCount}　帖子：${post.author.replyCount}
</div>
<div class="content">
<div class="rowfr">
<span>楼主</span>
</div>
<div class="rowsr">
${post.content}
</div>
<div class="rowtr">
<c:if test="${post.author.id==user.id}">
<a href="<%=this.getServletContext().getContextPath()%>/post.do?flag=gotoChangePostUi&post=${post.id}">修改</a>
</c:if>
</div>
</div>
</c:if>
<!-- 楼主显示完毕 -->

<c:forEach var="reply" items="${replys}">
<div class="person">
<div class="rowfl">
${reply.author.name}
</div>
<a href="<%=this.getServletContext().getContextPath()%>/person.do?flag=gotoShowUserUi&userid=${reply.author.id}">
<img src="<%=this.getServletContext().getContextPath()%>/photo/${reply.author.photoName}" ></img>
</a><br/>
主题：${reply.author.postCount}　帖子：${reply.author.replyCount}
</div>
<div class="content">
<div class="rowfr">
<c:if test="${new_reply==reply.id}">
<a name="new_reply"></a>
</c:if>
<span>${reply.floor}楼</span>
</div>
<div class="rowsr">
${reply.content}
</div>
<div class="rowtr">
<c:if test="${reply.author.id==user.id}">
<tr><td><a href="<%=this.getServletContext().getContextPath()%>/reply.do?flag=gotoChangReplyUi&reply=${reply.id}">修改</a></td></tr>
</c:if>
</div>
</div>
</c:forEach>
<a name="rep"></a>

<div class="replyd">
<form action="<%=this.getServletContext().getContextPath()%>/login.do?flag=checkLogin&operate=reply&post_id=${post.id}" method="post">
<textarea rows="5" cols="100" name="content"></textarea>
<input type="submit" value="回复"/>
</form>
</div>

</div>
  </body> 
</html>