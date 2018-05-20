<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bbs.dao.*" import="bbs.javabean.*"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<link rel="stylesheet" type="text/css" href="css/userIndex.css" />
<title>我的主页</title>
<script type="text/javascript" src="js/userIndex.js" charset="UTF-8"></script>

</head>
<body onload="onLoadFunction(${requestScope.arg1});">

	<jsp:include page="top.jsp"></jsp:include>
	<div class="main">
		<div class="main_head">

			<div class="main_head_user">
				<%
					User u=(User)session.getAttribute("user");
					ImgDao imgdao=new ImgDao();
				%>
				<img alt="头像" src="<%=imgdao.getImg(u.getImgid()) %>">
				<div class="head_user">
					<div class="head_user_name">
						<span>${sessionScope.user.uname}</span>
						<div class="head_user_edituser">

							<a onclick="changeType(6);"><i class="icon_edit"></i>编辑资料</a>
						</div>
					</div>
					<div class="head_user_info">
					 <%
					 	request.setCharacterEncoding("utf-8");
					 	
					 	if(u.getSex()==1 ){
					  %> 
					<img class="user_info_sex_man" alt="sex" src="img/touming.gif">
					<%}else{ %>
					<img class="user_info_sex_woman" alt="sex" src="img/touming.gif">
					<%} %>
					<span>账号：${sessionScope.user.uid}</span>
					<span>等级：${sessionScope.user.level}</span>
					<span>发帖数：${sessionScope.user.level}</span>
					</div>
				</div>
			</div>
		</div>
		
		<div class="content">
			<div class="content_head" id="content_head">
				<ul>
					<li class="content_head_two" id="type_1"><a onclick="changeType(1);">我的话题</a></li>
					<li class="content_head_one" id="type_2"><a onclick="changeType(2);">我的回帖</a></li>
					<li class="content_head_one" id="type_3"><a onclick="changeType(3);">回复我的</a></li>
					<li class="content_head_one" id="type_4"><a onclick="changeType(4);">我的粉丝</a></li>
					<li class="content_head_one" id="type_5"><a onclick="changeType(5);">我关注的</a></li>
					<li class="content_head_one" id="type_6"><a onclick="changeType(6);">个人设置</a></li>
				</ul>
			</div>
			<!-- 我的话题 -->
			<div class="content_topic" style="display:block;" id="type1">
				<ul>
				<c:forEach var="topic" items="${requestScope.topic }">
					<li><div class="topic_name"><a href="topic?topicid=${topic.topicid}" target="_blank">${topic.topicname }</a></div>
					<div class="topic_time">${topic.date }</div>
					<div class="topic_content"> &rarr;${topic.content }</div>
					<div class="topic_delet"><a onclick="deleteTopic(${topic.topicid});">删除</a></div>
					
					<div class="topic_replys">${topic.replys }回复</div>
					<div class="topic_clicks">${topic.clicks }点击</div></li>
				</c:forEach>
				</ul>
			</div>
			<!-- 我的回复 -->
			<div class="content_myreply" style="display:none;"  id="type2">
				<ul>
					<c:forEach var="myreply" items="${requestScope.myReply }">
						<li><div class="myreply_replytime">于${myreply.date }</div>
						<div class="myreply_topicname">在<a href="topic?topicid=${myreply.topicid }" target="_blank">${myreply.topicname}</a></div>
						
						<div class="myreply_content">回复:"${myreply.reply }"</div>
						</li>
					</c:forEach>
				</ul>
			</div>
			<!-- 我的消息 -->
			<div class="content_replyme" style="display:none;"  id="type3">
				<ul>
					<c:forEach var="replyme" items="${requestScope.replyMe }">
						<li>
						<div class="replyme_uname"><a href="otherIndex?otheruid=${replyme.uid}" target="_blank">${replyme.uname }</a>于${replyme.date }在</div>
						<div class="replyme_topicname"><a href="topic?topicid=${replyme.topicid }" target="_blank">${replyme.topicname }</a>回复我</div>
						<div class="replyme_content">
						${replyme.reply }
						</div>
						</li>
					</c:forEach>
				</ul>
			</div>
			<!--我的粉丝 -->
			<div class="content_fans" style="display:none;"  id="type4">
				
					<c:forEach var="fans" items="${requestScope.fans }">
						<div class="fans">	
							<div class="fans_img"><a href="otherIndex?otheruid=${fans.uid }" target="_blank"><img src="${fans.myImg }"></a></div>
							<div class="fans_name"><a href="otherIndex?otheruid=${fans.uid }" target="_blank">${fans.uname}</a></div>
						</div>
						
						
					</c:forEach>
				<div style="clear:both;"></div>
			</div>
			<!-- 我关注的 -->
			<div class="content_follows" style="display:none;"  id="type5">
				
					<c:forEach var="follows" items="${requestScope.follows }">
						<div class="follows">	
							<div class="follows_img"><a href="otherIndex?otheruid=${follows.uid }" target="_blank"><img src="${follows.myImg }"></a></div>
							<div class="follows_name"><a href="otherIndex?otheruid=${follows.uid }" target="_blank">${follows.uname}</a></div>
							<div class="delete_follows"><span onclick="deleteFollow('${follows.uid}')">取消关注</span></div>
						</div>
						
						
					</c:forEach>
				<div style="clear:both;"></div>
			</div>
			<div class="edit" style="display:none;" id="type6">
				<div class="edit_left">
					<ul>
						<li>我的信息</li>
						<li>更改密码</li>
					</ul>
				</div>
				<div class="edit_right">
					<div class="myinfo" id="myinfo">
						<form action="">
						<span>我的账号：${sessionScope.user.uid }</span>
						<span>昵称:<input type="text" value="${sessionScope.user.uname }" id="uname"></span>
						<%		
						if(u.getSex()==1){
						%>
						<span>性别：<select name="sex" id="sex">
							<option value="1" selected>男</option>
							<option value="0">女</option>
						</select></span>
						<%}else{ %>
						<span>性别：<select name="sex"  id="sex">
							<option value="1">男</option>
							<option value="0" selected>女</option>
						</select></span>
						<%} %>
						<div><span>头像：<select name="imgid" onchange="changeImg(this.value);" id="imgid">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
							
						</select></span><div id="img"><img alt="" src="img/touxiang1.jpg"></div></div>
						<span>邮箱：<input type="text" name="email" value="${sessionScope.user.email }" id="email"></span>
						<input type="reset" value="取消">
						<input type="button" value="修改信息" onclick="changeUserInfo();">
						</form>
					</div>
					
					<div class="password" id="password">
						<form action="">
						<span>请输入原密码：<input type="password" name="oldpassword" id="oldpassword"></span>
						<span>请输入新密码：<input type="password" name="newpassword" id="newpassword"></span>
						<span>请确认新密码：<input type="password" name="nextpassword" id="nextpassword"></span>
						<input type="button" value="修改密码" onclick="changePassword();">
						</form>
					</div>
				</div>
				<div style="clear:both;"></div>
				
			</div>
		</div>
	</div>
	
</body>
</html>