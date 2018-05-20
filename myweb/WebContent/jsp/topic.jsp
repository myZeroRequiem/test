<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="bbs.dao.*" import="bbs.javabean.*"
	import="java.util.ArrayList,java.text.SimpleDateFormat,java.util.Date"%>
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
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="stylesheet" type="text/css" href="css/topic.css" />
<title>我正在看：${requestScope.topic.topicname}</title>
<script type="text/javascript" src="js/index.js" charset="UTF-8"></script>

</head>
<body id="body">

	<jsp:include page="top.jsp"></jsp:include>
	<div class="head2">
		<img alt="bbs" src="img/test.jpg" />
	</div>
	<div class="content">
		<div class="main">
			<div class="main_left">
				<%if(session.getAttribute("user")!=null){ 
					User u=(User)session.getAttribute("user");
					ImgDao imgdao=new ImgDao();
				%>
				<div class="main_left_myinfo">
					<h4>我的信息</h4>
					<div class="myinfo_head">
						<a href="userIndex?arg1=1"><img alt="" src="<%=imgdao.getImg(u.getImgid()) %>" /></a>
						<div class="myinfo_head_name">
							<p class="myname"><a href="userIndex?arg1=1">${sessionScope.user.uname }</a></p>
							<p>等级：${sessionScope.user.level }</p>
							<p>关注：<a href="userIndex?arg1=5" class="myinfo_head_name_a">${sessionScope.user.fans }</a></p>
							<p>粉丝：<a href="userIndex?arg1=4" class="myinfo_head_name_a">${sessionScope.user.follows }</a></p>
						</div>
					</div>
					<div class="myinfo_mytopic">

						<h4>我的话题：</h4>
						<div class="mytopic">
							<%
								TopicDao td=new TopicDao();
								ArrayList<Topic> myTopic=td.getMyNewTopicInIndex(u.getUid());
								for(int i=0;i<myTopic.size();i++){
							%>
							
							<span><a href="topic?topicid=<%=myTopic.get(i).getTopicid() %>" target="_blank"><%=myTopic.get(i).getTopicname() %></a></span>					
							<%} %>
							<div class="mytopic_more">
							<a href="userIndex" >…点击查看更多…</a>
							</div>
						</div>
					</div>
				</div>
				<%} %>
				<div class="ad1"><img alt="" src="img/ad_example.jpg"></div>
				<div class="hot_topic_relative" id="hot_topic" >
					<span>热门话题</span>
					<div class="hot_topic_content">
							<ul >
					<%
						TopicDao hotTD=new TopicDao();
						ArrayList<Topic> hotTopicList=hotTD.getHotTopic();
						for(int i=0;i<hotTopicList.size();i++){
							if(i<1){
					%>
						
								<li>
									<div class='hot_topic_name_first'>
									<span><%=i+1 %></span>
									<span class='hot_topic_name1'><a href="topic?topicid=<%=hotTopicList.get(i).getTopicid()%>" target="_blank"><%=hotTopicList.get(i).getTopicname()%></a></span>
									</div>
								</li>
							<%}else if(i>0&&i<3){ %>
								<li>
									<div class='hot_topic_name_two'>
									<span><%=i+1  %></span>
									<span class='hot_topic_name2'><a href="topic?topicid=<%=hotTopicList.get(i).getTopicid()%>" target="_blank"><%=hotTopicList.get(i).getTopicname()%></a></span>
									</div>
								</li>
							<%}else{ %>
								<li>
									<div class='hot_topic_name_three'>
									<span><%=i+1  %></span>
									<span class='hot_topic_name3'><a href="topic?topicid=<%=hotTopicList.get(i).getTopicid()%>" target="_blank"><%=hotTopicList.get(i).getTopicname()%></a></span>
									</div>
								</li>
								<%}} %>
							</ul>
						</div>
					
					<div class="ad2"></div>
				</div>

			</div>
			<div class="main_right">
				<div class="jsp_main_right_head">
					<p>
						共<span>${requestScope.topic.replys }</span>回复，共<span>1</span>页
					</p>
					<div class="jsp_toIndex">
						<a href="index.jsp">返回首页</a>
					</div>
				</div>
				<div class="jsp_topic_main">
					<div class="jsp_topic_head">
						<div class="jsp_topic_name">
							<span>${requestScope.topic.topicname }</span>
							<div class="toReply">
								<span onclick="toReply();">我要回贴</span>
							</div>
						</div>
					</div>
					<div class="jsp_topic_main_content">
						<div class="jsp_one_floor">
							<div class="jsp_one_floor_number">1楼————发表于${requestScope.topic.date}</div>
							<div class="jsp_topic_content">
									<p>${requestScope.topic.content}</p>
								</div>
							<div class="jsp_author">
								<div class="jsp_topic_user">
									<%
										Topic topic = (Topic) request.getAttribute("topic");
										String uid = topic.getUid();
										int topicid = topic.getTopicid();
										UserDao ud = new UserDao();
										User u = ud.getInfo(uid);
									%>
									<a href="otherIndex?otheruid=<%=u.getUid()%>"><img alt="" src="<%=u.getMyImg()%>"></a>
									<div class="jsp_topic_user_name"><a href="otherIndex?otheruid=<%=u.getUid()%>" target="_blank" ><%=u.getUname() %></a></div>
									<div class="jsp_topic_user_level">
										<img alt="" src="img/s2_1d1b36a.gif"><%=u.getLevel()%>级
									</div>
								</div>
								
							</div>
								
						</div><!-- jsp_one_floor -->
						<c:forEach var="reply" items="${requestScope.reply }">
						<div class="jsp_one_floor">
						
							
							<div class="jsp_other_floor_number">${reply.floor}楼————发表于${reply.date}</div>
								<div class="jsp_topic_content">
										<p>${reply.reply}</p>
									</div>
								<div class="jsp_author">
									<div class="jsp_topic_user">
										
										<a href="otherIndex?otheruid=${reply.uid}"><img alt="" src="${reply.img }"></a>
										<div class="jsp_topic_user_name"><a href="otherIndex?otheruid=${reply.uid}" target="_blank">${reply.uname }</a></div>
										<div class="jsp_topic_user_level">
											<img alt="" src="img/s2_1d1b36a.gif">${reply.level}级
										</div>
									</div>
									
								</div>
							
						</div><!-- jsp_other_floor -->
						</c:forEach>
					</div><!-- jsp_topic_main_content -->
				</div><!-- jsp_topic_main -->

			</div><!-- main_right -->

		</div><!-- main -->

	<div style="clear:both;"></div>
	</div><!-- content -->
	<div class="foot">
		<div class="jsp_foot" id="reply">
			<div class="jsp_foot_reply">
				<div class="jsp_foot_reply_head">我要跟帖！</div>
				<div class="jsp_foot_reply_content">
					<span>说吧：</span>
					<form action="" >
						<textarea class="jsp_foot_replys" name="reply"  id="content"></textarea>
						<input type="button" value="发表" class="reply_submit" onclick="publichReply();">
						<div style="display:none;">
						<div id="topicid">${requestScope.topic.topicid}</div>
						<div id="topicuid">${requestScope.topic.uid}</div>
						
						</div>
					</form>
				</div>
			</div>
			<div class="footer">
				<div class="connection_me">
					<div class="connection_me_main">11111</div>
				</div>
			</div>
		</div>
	</div>
	<div class="toTop" id="toTop" onclick="toTop();">
		<a ></a>
	</div>

</body>
</html>