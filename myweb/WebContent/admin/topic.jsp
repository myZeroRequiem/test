<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ page import="bbs.dao.*" import="bbs.javabean.*"
	import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/admin_topic.js" charset="UTF-8"></script>

<title>Insert title here</title>
<style type="text/css">
a{
	color:blue;
}
a:hover{
	cursor:pointer;
}
td{
border:1px solid black;
}
th{
border:1px solid black;
}
table
  {
  border-collapse:collapse;
  }
</style>
</head>
<body>
管理话题<form action="adminTopic" method="post">
标题:<input type="text" name="topicname">
用户：<input type="text" name="uid">
类型：<select name="typeid">
		<option value=0>所有类型</option>
		<%
			TypeDao td=new TypeDao();
			ArrayList<Type> type=td.getType();	
		
			for(int i=0;i<type.size();i++){ 
		%>
		<option value=<%=i+1%>><%=type.get(i).getType() %></option>
		<%} %>
	</select>
	
<input type="submit" value="查询">
</form>
<table>
<tr>
<th>序号</th>
<th>标题</th>
<th>发布者</th>
<th>类型</th>
<th>是否置顶</th>
<th></th>
</tr>

<c:forEach var="topic" items="${requestScope.topic }">

<tr>

<td>${topic.topicid }</td>
<td>${topic.topicname }</td>
<td>${topic.uid }</td>
<td>${topic.typeid }</td>
<td>${topic.istop }</td>
<td><a onclick="isTopTopic(${topic.topicid});">置顶</a>
/<a onclick="noTopTopic(${topic.topicid});">取消置顶</a>
/<a onclick="deleteTopic(${topic.topicid});">删除</a></td>

</tr>
</c:forEach>

</table>
</body>
</html>