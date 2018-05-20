<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/admin_user.js" charset="UTF-8"></script>
<style type="text/css">
a{
	color:blue;
}
a:hover{
	cursor:pointer;
}
</style>
</head>
<body>
管理用户<form action="adminUser" method="get" style="display:inline-block;">
<input type="text" name="uid">
<input type="submit" value="查询">
</form>
<table>
<tr>
<th>用户账号</th>
<th>用户昵称</th>
<th>用户密码</th>
<th>用户性别</th>
<th>头像id</th>
<th>用户邮箱</th>
<th>用户等级</th>
<th></th>
</tr>
<c:forEach var="user" items="${requestScope.user }">

<tr>

<td>${user.uid }</td>
<td><input type="text" value="${user.uname }" id="${user.uid }_uname"></td>
<td><input type="text" value="${user.password }" id="${user.uid }_password"></td>
<td><input type="text" value="${user.sex }" id="${user.uid }_sex"></td>
<td><input type="text" value="${user.imgid }" id="${user.uid }_imgid"></td>
<td><input type="text" value="${user.email }" id="${user.uid }_email"></td>
<td><input type="text" value="${user.level }" id="${user.uid }_level"></td>
<td><a onclick="editUser('${user.uid}');">修改</a>/<a onclick="deleteUser('${user.uid}');">删除</a></td>
</tr>
</c:forEach>
<tr>
<td><input type="text" id="_uid"></td>
<td><input type="text" id="_uname"></td>
<td><input type="text" id="_password"></td>
<td><input type="text" id="_sex"></td>
<td><input type="text" id="_imgid"></td>
<td><input type="text" id="_email"></td>
<td><input type="text" id="_level"></td>
<td><a onclick="addUser();">添加</a></td>

</tr>
</table>
</body>
</html>