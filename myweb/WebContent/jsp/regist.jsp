<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="css/regist.css">
<script type="text/javascript" src="js/regist.js" charset="UTF-8"></script>

<title>注册</title>
</head>
<body>
	<div class="main">
		<div class="back">
			<div class="regist">
				<div class="regist_head">
					<h1>用户注册</h1>
				</div>
				<div class="regist_main">
					<form action="regist" method="post" name="registForm">
						<div class="regist_main_uid">
							<span>账号：</span> 
							<div class="cue" id="cue1">6—11位的字母或数字</div>
							<input type="text" name="uid" id="uid" onkeyup="setUid(this.value);"/>
						</div>
						<div class="regist_main_uname">
							<span>昵称：</span> 
							<div class="cue" id="cue2">最多八个字符</div>
							<input type="text" name="uname" id="uname" onkeyup="setUname(this.value);"/>
						</div>
						<div class="regist_main_password">
							<span>密码：</span> 
							<div class="cue" id="cue3">8-16位的字母或数字</div>
							<input type="password" name="password" id="password" onkeyup="setPassword(this.value);"/>
						</div>

						<div class="regist_main_password">
							<span>确认密码：</span> 
							<div class="cue" id="cue4"></div>
							<input type="password" name="nextpassword" id="nextpassword" onkeyup="setNextpassword(this.value);"/>
						</div>
						<div class="regist_main_sex" >
							<span>性别：</span> <select name="sex" id="sex">
								<option value=1>男</option>
								<option value=0>女</option>
							</select>
						</div>
						<div class="regist_main_email">
							<span>邮箱：</span>
							<div class="cue" id="cue5"></div>
							<input type="text" name="email" id="email" onkeyup="setEmail(this.value);">
						</div>
						<div class="regist_main_agreement">
							<input type="checkbox" name="agreement" id="checkbox"> <span>我已阅读并同意<a
								onclick="agreement();" class="agreement">《用户使用协议》</a></span>
						</div>
						<div class="regist_main_reset">
							<input type="reset" value="清空">
						</div>
						<div class="regist_main_submit">
							<input type="button" value="注册" onclick="regist();">
						</div>

					</form>
					
				</div>
				<div class="regist_login">
				<span>已有账号？</span>
				<a href="jsp/login.jsp">立即登录！</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

