<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bbs.dao.UserDao" import="bbs.javabean.User"%>
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
<title>top</title>
<link rel="stylesheet" type="text/css" href="css/top.css" />
<script type="text/javascript" src="js/top.js" charset="UTF-8"></script>

</head>
<body>

	<div class="body">
		<div class="head">
			<div class="head_inner">
				<div class="head_logo">
					<a href="index.jsp"><img alt="bbs" src="img/logo.jpg" /></a>
				</div>
				<div class="head_search">
					<form action="searchTopic" class="head_search_form" id="searchForm">
						<input type="text" name="keyword" class="head_search_form1" /> <input
							type="submit" value="搜索" class="head_search_form2" />
					</form>
				</div>
				<%
					request.setCharacterEncoding("GBK");
					//String uid = (String) session.getAttribute("uid");
					//if (uid == null || uid == "") {
						if(session.getAttribute("user")==null){
				%>
				<div class="login_regist">
					您未登录，请先<a href="jsp/login.jsp">登录</a>/<a href="jsp/regist.jsp">注册</a>
				</div>
				<%
					} else {
						//UserDao dao = new UserDao();
						//User u = dao.getInfo(uid);
				%>
				<div class="user">

					<div class="username">
						<span>${sessionScope.user.uname }</span>

						<div class="username_down">
							<ul>
								<li><a href="userIndex">个人信息</a></li>
								<li><a href="userIndex?arg1=3">我的消息</a></li>
								<li><a href="userIndex?arg1=6">设置</a></li>
								<li><a onclick="logout();">退出</a></li>
							</ul>
						</div>
					</div>
					<span>你好！</span>
				</div>
			</div>
			<%
				}
			%>
		</div>
	</div>
</body>
</html>