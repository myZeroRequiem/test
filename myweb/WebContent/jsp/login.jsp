<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/login.css">
<title>登录</title>
<script type="text/javascript" src="js/login.js" charset="UTF-8"></script>

</head>
<body onkeyup="EnterPress(event);">
	<div class="main">
	<div class="back">
	
		<div class="login">
			<div class="login_head"><h1>用户登录</h1></div>
			<div class="login_main">
				<form action="" method="post" name="loginForm">
					<div class="login_uname">
						<input type="text" name="uid" id="uid"/>
						<img alt="用户名" src="img/userid.jpg">
					</div>
					<div class="login_password">
						<input type="password" name="password" id="password"/>
						<img alt="用户名" src="img/userpassword.jpg">
					</div>
					<div class="login_submit">
						<input type="button" value="登录" onclick="login();" id="loginButton"/>
					</div>
					
				</form>
				<div class="login_regist">
						<span>还没有账号？</span>
						<a href="jsp/regist.jsp">立即注册！</a>
						<a href="index.jsp">以游客身份浏览</a>
					</div>
			</div>
		</div>
		</div>
	</div>
</body>
</html>