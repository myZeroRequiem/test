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
<script type="text/javascript">
function deleteReply(replyno){
	//alert("确定删除？");
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
		  	var str=xmlhttp.responseText;
			
				alert(str);
				window.location.reload(); 
			
			
		}
	  }
	xmlhttp.open("get","adminDeleteReply?replyno="+replyno,true);
	
	xmlhttp.send();	

}
</script>
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
管理回帖
<form action="adminReply" method="post">
话题id:<input type="text" name="tid">
用户：<input type="text" name="uid">
<input type="submit" value="查询">
</form>
<table>
<tr>
<th>序号</th>
<th>话题ID</th>
<th>发布者</th>
<th>楼层</th>

<th></th>
</tr>

<c:forEach var="reply" items="${requestScope.reply }">

<tr>

<td>${reply.replyno}</td>
<td>${reply.topicid }</td>
<td>${reply.uid }</td>
<td>${reply.floor}</td>
<td><a onclick="deleteReply(${reply.replyno});">删除</a></td>

</tr>
</c:forEach>

</table>
</body>
</html>