<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>Insert title here</title>
</head>
<body>
<div>
	<span><a href="admin/main.jsp" target="main">管理员</a></span>
	<span><a href="adminUser" target="main">管理用户</a></span>
	<span><a href="adminTopic?typeid=0" target="main">管理话题</a></span>
	<span><a href="adminReply" target="main">管理回帖</a></span>
	<span><a href="adminType" target="main">管理类型</a></span>
	<span><a href="adminImg" target="main">管理头像</a></span>
	
</div>
</body>
</html>