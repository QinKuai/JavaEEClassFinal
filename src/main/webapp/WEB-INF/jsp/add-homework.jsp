<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	Integer taskId = (Integer) request.getAttribute("taskId");
	String sid = (String) request.getAttribute("sid");
%>
<title>上传作业</title>
</head>
<body>
	<form action="add-homework" method="post">
		<input type="text" name="sid" style="display: none" value=<%=sid%>>
		<input type="text" name="taskId" style="display: none"value=<%=taskId%>> 
		<b>作业内容：</b><input type="text" name="content"><br>
		<br> <input type="submit" value="上传作业">
	</form>
</body>
</html>