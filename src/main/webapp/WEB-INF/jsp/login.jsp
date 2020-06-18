<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<form action="login" method="post">
		<b>账号：</b>
		<input type="text" name="username"/><br/>
		<b>密码：</b>
		<input type="password" name="password"/><br/>
		<b>用户类型：</b>
		<select name="type">
			<option value="student">学生</option>
			<option value="teacher">教师</option>
		</select><br/>
		<input type="submit" value="登录">
	</form>
	<button onclick="jumpToRegister()">注册</button>
	<script type="text/javascript">
		function jumpToRegister() {
			window.location.href = "register"
		}
	</script>
</body>
</html>