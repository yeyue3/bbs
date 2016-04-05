<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
		<link rel="stylesheet" type="text/css" href="./css/post/addPost.css">

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
			<h1>
				发帖页面
			</h1>
			<form
				action="<%=this.getServletContext().getContextPath()%>/post.do?flag=addPost"
				method="post">
				<c:if test="${boards != null}">
					<select name="board_id">
						<option value="0" selected="selected">
							请选择主题分类
						</option>
						<c:forEach items="${boards}" var="board">
							<option value="${board.id}">
								${board.name}
							</option>
						</c:forEach>
					</select>
				</c:if>
				<c:if test="${board!=null}">
					<input type="hidden" name="board_id" value="${board.id}"></input>
				</c:if>
				题目
				<input type="text" name="title" style="width: 200px"></input>
				<br />
				<textarea id="content_1" rows="15" cols="100" name="content"></textarea>
				<br />
				<input type="submit" value="发帖" />
			</form>
		</div>
	</body>
</html>