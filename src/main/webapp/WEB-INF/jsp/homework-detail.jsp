<%@page import="com.qinkuai.core.util.TimeUtils"%>
<%@page import="java.util.List"%>
<%@page import="com.qinkuai.db.model.Homework"%>
<%@page import="com.qinkuai.db.model.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	String courseId = (String) request.getAttribute("cid");
	Student student = (Student)request.getAttribute("student");
	List<Homework> homeworks = (List<Homework>)request.getAttribute("homeworks");
%>
<title><%=courseId%>-作业详情</title>
</head>
<body>
	<h2><%=student.getFirstName() + student.getLastName()%>提交的作业</h2>
	<table border="1">
		<tr>
			<td>作业内容</td>
			<td>作业提交时间</td>
			<td>更新</td>
		</tr>
		
		<%
			for (Homework homework : homeworks) {
		%>
		<tr>
			<td><%=homework.getContent() %></td>
			<td><%=TimeUtils.dateToString(homework.getUploadTime()) %></td>
			<td><button onclick="updateHomework()">更新</button></td>
		</tr>

		<%
			}
		%>
	</table>

	<input type="button" value="上传作业" onclick="jumpToAddNewHomework()">
	<script type="text/javascript">
		function jumpToAddNewHomework() {
			window.location.href = "add-homework"
		}
	</script>
	<script type="text/javascript">
		function updateHomework() {
			window.location.href = "update-homework?homeworkId="
		}
	</script>
</body>
</html>