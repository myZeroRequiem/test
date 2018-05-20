<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="bbs.dao.*" import="bbs.javabean.*"
	import="java.util.ArrayList,java.text.SimpleDateFormat,java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%
String path=request.getContextPath();
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath %>">
<link rel="stylesheet" type="text/css" href="css/index.css" />
<script type="text/javascript" src="js/index.js" charset="UTF-8"></script>
<title>搜索：${requestScope.keyword }</title>
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
	<%-- <%	if(session.getAttribute("user")==null){ %>
	<jsp:forward page="Index_UserInfo"></jsp:forward>
	<%} %> --%>
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
									<span class='hot_topic_name1'><a href="topic?topicid=<%=hotTopicList.get(i).getTopicid()%>" target="_back"><%=hotTopicList.get(i).getTopicname()%></a></span>
									</div>
								</li>
							<%}else if(i>0&&i<3){ %>
								<li>
									<div class='hot_topic_name_two'>
									<span><%=i+1  %></span>
									<span class='hot_topic_name2'><a href="topic?topicid=<%=hotTopicList.get(i).getTopicid()%>" target="_back"><%=hotTopicList.get(i).getTopicname()%></a></span>
									</div>
								</li>
							<%}else{ %>
								<li>
									<div class='hot_topic_name_three'>
									<span><%=i+1  %></span>
									<span class='hot_topic_name3'><a href="topic?topicid=<%=hotTopicList.get(i).getTopicid()%>" target="_back"><%=hotTopicList.get(i).getTopicname()%></a></span>
									</div>
								</li>
								<%}} %>
							</ul>
						</div>
					
					<div class="ad2"></div>
				</div>
			</div>
			<div class="main_right">
				<div class="topic_search_top" >
						搜索关键字为<span>：${requestScope.keyword }</span>
						搜索结果共<span>${requestScope.listsize }</span>条
					<div class="searchtopic_toIndex">
						<a href="index.jsp">返回首页</a>
					</div>
				</div>
				
				<div class="topic" id="topic">
					
					<div class="next_topic" id="next_topic">
					<ul class="next_topic_ul" id="next_topic_ul">
						<c:forEach var="topic" items="${requestScope.search }">
							<li>
								<div class="next_topic_replys">${topic.replys }</div>
								<div class="next_topic_name"><a href="topic?topicid=${topic.topicid }" target="_blank">${topic.topicname }</a></div>
								<div class="next_topic_uname">
									<div class="icon_author"></div>
									<span><a href="otherIndex?otheruid=${topic.uid }" target="_blank">${topic.uname }</a></span>
								</div>
								<div class="next_topic_content">${topic.content }</div>
								<div class="next_topic_lastuname" style="width:90px;overflow:hidden;">
									<div class="icon_replayer"></div>
									<span><a href="otherIndex?otheruid=${topic.lastuid }" target="_blank">${topic.lastuid }</a></span>
								</div>
								<div class="next_topic_lasttime"><span style="font-size: 12px;width: 90px;display: inline-block;">${topic.lastdate }</span></div>
							</li>
						</c:forEach>
					</ul>
					</div>

				</div>
			</div>
			<div style="clear:both;"></div>	
		</div>
	
		<div style="clear:both;"></div>	
	</div>
	<div class="foot">
		<div class="publish" id="publish">
			<div class="publish_head"><span>发表新帖</span></div>
			<div class="publish_main"> 
				<form action="publishTopic" class="publish_form" method="post">
					<div class="publish_topic_head">
						<span>起个题目：</span>
						<input type="text" name="topic_name" class="publish_topic_name">
						<span>咱要讲哪一方面的事：</span>
						<select name="typeid" class="publish_topic_type">
							<c:forEach var="type" items="${requestScope.type }">
								<option value="${type.typeid}">${type.type}</option>
							</c:forEach>
						</select>
					</div>
					<div class="publish_topic_main">
						<span>你要说啥：</span>
						<textarea name="content" class="publish_topic_content"></textarea>
						<input type="submit" value="发表" class="publish_topic_submit">
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
	<div class="toTop" id="toTop" onclick="toTop();"><a ></a></div>
</body>
</html>