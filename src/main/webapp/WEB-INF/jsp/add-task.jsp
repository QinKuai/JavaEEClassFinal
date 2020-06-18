<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%String courseId = (String)request.getAttribute("courseId"); %>
<title><%=courseId %>-添加任务</title>
</head>
<body>
	<h1><%=courseId %>-添加新任务</h1>
	<form action="add-task" method="post">
	<input type="text" name="cid" style="display:none" value=<%=courseId %>>
	<b>任务内容：</b><input type="text" name="content"><br><br>
	<b>开始时间(yyyy-MM-dd HH:mm:ss)：</b><input type="datetime" name="upload_time"><br><br>
	<b>持续时间(h)：</b><input type="text" name="time_last"><br><br>
	<input type="submit" value="上传任务">
	</form>
	
</body>
</html>