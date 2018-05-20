<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
function addType(){
	var typeid=document.getElementById("_typeid").value;
	var type=document.getElementById("_type").value;
	
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
	xmlhttp.open("post","adminAddType?typeid="+typeid+"&type="+type,true);	
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
管理类型
<table>
<tr>
<th>编号</th>
<th>类型名称</th>
</tr>
<c:forEach var="type" items="${requestScope.type }">
<tr>
<td>${type.typeid }</td>
<td>${type.type }</td>
</tr>
</c:forEach>
<tr>
<td><input type="text" id="_typeid"></td>
<td><input type="text" id="_type"></td>

<td><a onclick="addType();">添加</a></td>

</tr>
</table>
</body>
</html>