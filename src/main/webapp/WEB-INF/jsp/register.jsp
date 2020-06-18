<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
</head>
<body>
	<form action="register" method="post">
		<b>账号：</b>
		<input type="text" name="username"/><br/>
		<b>密码：</b>
		<input type="password" name="password"/><br/>
		<b>用户类型：</b>
		<select name="type">
			<option value="student">学生</option>
			<option value="teacher">教师</option>
		</select><br/>
		<b>姓：</b>
		<input type="text" name="firstName" /><br/>
		<b>名：</b>
		<input type="text" name="lastName" /><br/>
		<b>性别：</b>
		<select name="sex">
			<option value="m">男性</option>
			<option value="f">女性</option>
			<option value="n">无可奉告</option>
		</select><br/>
		<input type="submit" value="注册">
	</form>
	<button onclick="jumpToLogin()">返回</button>
	<script type="text/javascript">
		function jumpToLogin() {
			window.location.href = "login"
		}
	</script>
</body>
</html>