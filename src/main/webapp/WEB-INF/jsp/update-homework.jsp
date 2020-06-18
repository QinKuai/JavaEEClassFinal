<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	Integer homeworkId = (Integer) request.getAttribute("homeworkId");
%>
<title>更新作业</title>
</head>
<body>
	<form action="update-homework" method="post">
		<input type="text" name="homeworkId" style="display: none"value=<%=homeworkId%>> 
		<b>更新作业内容：</b><input type="text" name="content"><br>
		<br> <input type="submit" value="更新作业">
	</form>
</body>
</html>