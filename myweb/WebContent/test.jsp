<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@page import="bbs.dao.*,java.util.ArrayList,bbs.javabean.*,java.util.Collections,
java.util.Comparator" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.username {
	position: relative;
	display: inline-block;
	float:right;
}

.user_down {
	position: absolute;
	display: none;
	min-width: 160px;
	
	right:0;
}
.user_down a{
 	color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
     box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
}
.user_down ul{
list-style-type:none;
}
.username:hover .user_down {
	display: block;
}
</style>
</head>
<body>
	<div class="username">
		欢迎您！ <a href="#">昵称</a>

		<div class="user_down">
			<ul>
				<li><a href="#">个人信息</a></li>
				<li><a href="#">我的消息</a></li>
				<li><a href="#">设置</a></li>
				<li><a href="#">退出</a></li>
			</ul>
		</div>
	</div>
	<%-- <%
		TopicDao td=new TopicDao();
		ArrayList<Topic> allTopic=td.getAllTopic();
		//Collections.sort(allTopic,new SortByAge());
		request.setAttribute("allTopic", allTopic);
		
		%> --%>
		<ul>
						<%
						TypeDao td=new TypeDao();
						ArrayList<Type> type=td.getType();	
						request.setAttribute("type", type);
					%>
						<li class="topic_type_two"><a
							onclick="changeType(0);">最新</a> <c:forEach var="type"
								items="${requestScope.type }">
								<li class="topic_type_one"><a 
									onclick="changeType(${type.typeid});">${type.type}</a></li>
							</c:forEach>
							<div class="publish_button" onclick="toPublish();"><span>发表话题</span></div>
					</ul>
</body>
</html>