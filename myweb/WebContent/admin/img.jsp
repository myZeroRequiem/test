<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/admin_img.js" charset="UTF-8"></script>

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
管理头像
<table>
<tr>
<th>编号</th>
<th>图片地址</th>
<th></th>

</tr>
<c:forEach var="img" items="${requestScope.img }">
<tr>
<td>${img.imgid }</td>
<td><input type="text" value="${img.img }" id="${img.imgid }_img"></td>
<td><img src="${img.img }" width="100px" height="100px"></td>
<td><a onclick="editImg(${img.imgid });">修改</a>
</tr>
</c:forEach>
<tr>
<td><input type="text" id="_imgid"></td>
<td><input type="text" id="_img"></td>
<td></td>
<td><a onclick="addImg();">添加</a></td>

</tr>
</table>
</body>
</html>