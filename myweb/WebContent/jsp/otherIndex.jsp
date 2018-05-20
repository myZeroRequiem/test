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
<title>${requestScope.others.uname }的主页</title>
<script type="text/javascript" src="js/otherIndex.js" charset="UTF-8"></script>
</head>
<body>

	<jsp:include page="top.jsp"></jsp:include>
	<div class="main">
		<div class="main_head">

			<div class="main_head_user">
				<img alt="头像" src="${requestScope.others.myImg}">
				<div class="head_user">
					<div class="head_user_name">
						<span>${requestScope.others.uname}</span>
						<div class="head_user_edituser">
						<%
							String isfollow=(String)request.getAttribute("isfollows");
							if(isfollow=="0"){
						%>
							<a onclick="addFans('${requestScope.others.uid }')">关注</a>
							<%}else{ %>
							<a onclick="deleteFans('${requestScope.others.uid }')">取消关注</a>
							<%} %>
						</div>
					</div>
					<div class="head_user_info">
					 <%
					 	request.setCharacterEncoding("utf-8");
					 	User u=(User)request.getAttribute("others");
					 	
					 	if(u.getSex()==1 ){
					  %> 
					<img class="user_info_sex_man" alt="sex" src="img/touming.gif">
					<%}else{ %>
					<img class="user_info_sex_woman" alt="sex" src="img/touming.gif">
					<%} %>
					<span>账号：${requestScope.others.uid}</span>
					<span>等级：${requestScope.others.level}</span>
					<span>发帖数：${requestScope.others.level}</span>
					</div>
				</div>
			</div>
		</div>
		
		<div class="content">
			<div class="content_head" id="content_head">
				<ul>
					<li class="content_head_two" id="type_1"><a onclick="changeType(1);">他的话题</a></li>
					<li class="content_head_one" id="type_2"><a onclick="changeType(2);">他的回帖</a></li>
					
					<li class="content_head_one" id="type_3"><a onclick="changeType(3);">他的粉丝</a></li>
					<li class="content_head_one" id="type_4"><a onclick="changeType(4);">他关注的</a></li>
					
				</ul>
			</div>
			<!-- 他的话题 -->
			<div class="content_topic" style="display:block;" id="type1">
				<ul>
				<c:forEach var="topic" items="${requestScope.topic }">
					<li><div class="topic_name"><a href="topic?topicid=${topic.topicid}" target="_blank">${topic.topicname }</a></div>
					<div class="topic_time">${topic.date }</div>
					<div class="topic_content"> &rarr;${topic.content }</div>
					<div class="topic_delet"></div>
					
					<div class="topic_replys">${topic.replys }回复</div>
					<div class="topic_clicks">${topic.clicks }点击</div></li>
				</c:forEach>
				</ul>
			</div>
			<!-- 他的回帖 -->
			<div class="content_myreply" style="display:none;"  id="type2">
				<ul>
					<c:forEach var="myreply" items="${requestScope.myReply }">
						<li>
							<div class="myreply_replytime">于${myreply.date }</div>
							<div class="myreply_topicname">
								在<a href="topic?topicid=${myreply.topicid }" target="_blank">
								${myreply.topicname}
								</a>
							</div>
						
							<div class="myreply_content">回复:"${myreply.reply }"</div>
						</li>
					</c:forEach>
				</ul>
			</div>
			<!-- 他的粉丝 -->
			<div class="content_fans" style="display:none;"  id="type3">
				
					<c:forEach var="fans" items="${requestScope.fans }">
						<div class="fans">	
							<div class="fans_img"><a href="otherIndex?otheruid=${fans.uid }" target="_blank"><img src="${fans.myImg }"></a></div>
							<div class="fans_name"><a href="otherIndex?otheruid=${fans.uid }" target="_blank">${fans.uname}</a></div>
						</div>
						
						
					</c:forEach>
				<div style="clear:both;"></div>
			</div>
			<!-- 他的关注 -->
			<div class="content_follows" style="display:none;"  id="type4">
				
					<c:forEach var="follows" items="${requestScope.follows }">
						<div class="follows">	
							<div class="follows_img"><a href="otherIndex?otheruid=${follows.uid }" target="_blank"><img src="${follows.myImg }"></a></div>
							<div class="follows_name"><a href="otherIndex?otheruid=${follows.uid }" target="_blank">${follows.uname}</a></div>
						</div>
						
						
					</c:forEach>
				<div style="clear:both;"></div>
			</div>
			
		</div>
	</div>
	
</body>
</html>