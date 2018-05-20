/**
 * 
 */
 	var xmlhttp;
	function setXHR(url,cfunc)
	{
		if (window.XMLHttpRequest)
		  {// IE7+, Firefox, Chrome, Opera, Safari 代码
		  xmlhttp=new XMLHttpRequest();
		  }
		else
		  {// IE6, IE5 代码
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		xmlhttp.onreadystatechange=cfunc;
		xmlhttp.open("GET",url,true);
		xmlhttp.send();
	}
	//主页加载
	function onloadFunction(){
		var a=0;
		//hotTopic();
		setXHR("getTopic?typeid=0",function(){
			if (xmlhttp.readyState==4 && xmlhttp.status==200)
		    {
				var jsonStr=xmlhttp.responseText;
				var jsonObj=eval('('+jsonStr+')');
				if(jsonObj!=null&&jsonObj!=""){
				//document.getElementById("top_topic").innerHTML=jsonStr;
					for(i=0;i<jsonObj.length;i++){
						var lasttime=jsonObj[i].lasttime;
						var lastdate=changeTimeToDateNoYear(lasttime);
						
						//置顶
						if(a<3) {
							if(jsonObj[i].istop>0){
								document.getElementById("top_topic").innerHTML+="<div class='top_topic_replys'>"+jsonObj[i].replys+"</div>"
								+"<div class='top_topic_name'><span>置顶</span><a href='topic?topicid="+jsonObj[i].topicid+"' target='_blank'>"+jsonObj[i].topicname+"</a></div>"
								+"<div class='top_topic_uname'><div class='icon_author'></div><span><a target='_blank' href='otherIndex?otheruid="+jsonObj[i].uid+"'>"+jsonObj[i].uname+"</a></span></div>";
								
								a++;
							}else{//普通话题
								document.getElementById("next_topic_ul").innerHTML+="<li><div class='next_topic_replys'>"+jsonObj[i].replys+"</div>"
								+"<div class='next_topic_name'><a href='topic?topicid="+jsonObj[i].topicid+"' target='_blank' >"+jsonObj[i].topicname+"</a></div>"
								+"<div class='next_topic_uname'><div class='icon_author'></div><span><a  target='_blank' href='otherIndex?otheruid="+jsonObj[i].uid+"'>"+jsonObj[i].uname+"</a></span></div>"
								+"<div class='next_topic_content'>"+jsonObj[i].content+"</div>"
								+"<div class='next_topic_lastuname'><div class='icon_replayer'></div><span><a  target='_blank' href='otherIndex?otheruid="+jsonObj[i].lastuid+"'>"+jsonObj[i].lastuid+"</a></span></div>"
								+"<div class='next_topic_lasttime' >"+lastdate+"</div></li>";
							}
						}else{
							document.getElementById("next_topic_ul").innerHTML+="<li><div class='next_topic_replys'>"+jsonObj[i].replys+"</div>"
							+"<div class='next_topic_name'><a href='topic?topicid="+jsonObj[i].topicid+"' target='_blank' >"+jsonObj[i].topicname+"</a></div>"
							+"<div class='next_topic_uname'><div class='icon_author'></div><span><a  target='_blank' href='otherIndex?otheruid="+jsonObj[i].uid+"'>"+jsonObj[i].uname+"</a></span></div>"
							+"<div class='next_topic_content'>"+jsonObj[i].content+"</div>"
							+"<div class='next_topic_lastuname'><div class='icon_replayer'></div><span><a  target='_blank' href='otherIndex?otheruid="+jsonObj[i].lastuid+"'>"+jsonObj[i].lastuid+"</a></span></div>"
							+"<div class='next_topic_lasttime' >"+lastdate+"</div></li>";
							
						}
			    	}
				}
		    }
		});
		
		
	}
	/*function hotTopic(){
		setXHR("hotTopic",function(){
			if (xmlhttp.readyState==4 && xmlhttp.status==200)
		    {
				var jsonStr2=xmlhttp.responseText;
				var jsonObj2=eval('('+jsonStr2+')');
				for(i=1;i<11;i++){
					if(i<2){
						document.getElementById("hot_topic_ul").innerHTML+="<li><div class='hot_topic_name_first'><span class='hot_topic_No1'>"+i+"</span><span class='hot_topic_name1'>"+jsonObj2[i-1].topicname+"</span></div></li>";
					}
					else if(i<4&&i>1){
						document.getElementById("hot_topic_ul").innerHTML+="<li><div class='hot_topic_name_two'><span class='hot_topic_No2'>"+i+"</span class='hot_topic_name2'>"+jsonObj2[i-1].topicname+"<span></div></li>";
					}
					else{
						document.getElementById("hot_topic_ul").innerHTML+="<li><div class='hot_topic_name_three'><span class='hot_topic_No3'>"+i+"</span class='hot_topic_name3'>"+jsonObj2[i-1].topicname+"<span></div></li>";
					}
				}
		    }
		});
	}*/
	//更换类型
	function changeType(typeid){
		document.getElementById("topic").innerHTML="<div class='top_topic' id='top_topic'></div><div class='next_topic' id='next_topic'><ul class='next_topic_ul' id='next_topic_ul'></ul></div>";
		//document.getElementById("next_topic").innerHTML="b";
		for(var i=0;i<document.getElementById("type_style").getElementsByTagName("li").length;i++){
			document.getElementById("type_style").getElementsByTagName("li")[i].className="topic_type_one";
			}
			document.getElementById("type_style").getElementsByTagName("li")[typeid].className="topic_type_two";
		setXHR("getTopic?typeid="+typeid,function(){
			if (xmlhttp.readyState==4 && xmlhttp.status==200)
		    {
				
				var jsonStr=xmlhttp.responseText;
				var jsonObj=eval('('+jsonStr+')');
				var a=0;
				for(i=0;i<jsonObj.length;i++){
					var lasttime=jsonObj[i].lasttime;
					var lastdate=changeTimeToDateNoYear(lasttime);
					
					if(a<3) {//置顶
						if(jsonObj[i].istop==1){
							document.getElementById("top_topic").innerHTML+="<div class='top_topic_replys'>"+jsonObj[i].replys+"</div>"
							+"<div class='top_topic_name'><span>置顶</span><a href='topic?topicid="+jsonObj[i].topicid+"' target='_blank'>"+jsonObj[i].topicname+"</a></div>"
							+"<div class='top_topic_uname'><div class='icon_author'></div><span><a target='_blank'  href='otherIndex?otheruid="+jsonObj[i].uid+"'>"+jsonObj[i].uname+"</a></span></div>";
							
							a++;
						}else{//普通话题
							document.getElementById("next_topic_ul").innerHTML+="<li><div class='next_topic_replys'>"+jsonObj[i].replys+"</div>"
							+"<div class='next_topic_name'><a href='topic?topicid="+jsonObj[i].topicid+"' target='_blank' >"+jsonObj[i].topicname+"</a></div>"
							+"<div class='next_topic_uname'><div class='icon_author'></div><span><a target='_blank'  href='otherIndex?otheruid="+jsonObj[i].uid+"'>"+jsonObj[i].uname+"</a></span></div>"
							+"<div class='next_topic_content'>"+jsonObj[i].content+"</div>"
							+"<div class='next_topic_lastuname'><div class='icon_replayer'></div><span><a  target='_blank' href='otherIndex?otheruid="+jsonObj[i].lastuid+"'>"+jsonObj[i].lastuid+"</a></span></div>"
							+"<div class='next_topic_lasttime' >"+lastdate+"</div></li>";
						}
					}else{//普通话题
						document.getElementById("next_topic_ul").innerHTML+="<li><div class='next_topic_replys'>"+jsonObj[i].replys+"</div>"
						+"<div class='next_topic_name'><a href='topic?topicid="+jsonObj[i].topicid+"' target='_blank' >"+jsonObj[i].topicname+"</a></div>"
						+"<div class='next_topic_uname'><div class='icon_author'></div><span><a  target='_blank' href='otherIndex?otheruid="+jsonObj[i].uid+"'>"+jsonObj[i].uname+"</a></span></div>"
						+"<div class='next_topic_content'>"+jsonObj[i].content+"</div>"
						+"<div class='next_topic_lastuname'><div class='icon_replayer'></div><span><a  target='_blank' href='otherIndex?otheruid="+jsonObj[i].lastuid+"'>"+jsonObj[i].lastuid+"</a></span></div>"
						+"<div class='next_topic_lasttime' >"+lastdate+"</div></li>";
						
					}
		    	}
		    }
		});
		
	}
	//时间戳转日期
	function changeTimeToDateNoYear(time){
		var now=new Date(time);
		//var year=now.getFullYear(); 
	     var month=now.getMonth()+1; 
	     var date=now.getDate(); 
	     var hour=now.getHours(); 
	     var minute=now.getMinutes(); 
	     //var second=now.getSeconds(); 
	     return month+"月"+date+"日  "+hour+":"+minute; 
	}
	
	//监测窗口滚动
	window.onscroll=function(){
		
		//变量t就是滚动条滚动时，到顶部的距离
		var f=document.documentElement.scrollTop;
		var c=document.body.scrollTop;
		var t=document.getElementById("hot_topic").offsetTop;
		var tc =t-c;
		var tf =t-f;
		//var tf =document.getElementById("hot_topic").offsetTop-f;
		if(f==0){//谷歌，搜狗浏览器
			 if(tc<-181){
				 document.getElementById("hot_topic").className="hot_topic_fixed"; 
				// document.getElementById("a").innerHTML=t;
				 document.getElementById("toTop").style.display="block";
			}
			
			else{
				document.getElementById("hot_topic").className="hot_topic_relative";
				//document.getElementById("a").innerHTML=f;
				document.getElementById("toTop").style.display="none";
			}
		}else{//火狐
		 if(tf<-205){
			 document.getElementById("hot_topic").className="hot_topic_fixed"; 
			 //document.getElementById("a").innerHTML=tf;
			 document.getElementById("toTop").style.display="block";
		
		 }else{
			 document.getElementById("hot_topic").className="hot_topic_relative";
			//document.getElementById("a").innerHTML=tf;
			document.getElementById("toTop").style.display="none";
			
		 }
		}
	} 	
	
	//发表话题
	function toPublish(){
		document.querySelector("#publish").scrollIntoView(false);
	}
	//回帖按钮
	function toReply(){
		document.querySelector("#reply").scrollIntoView(false);
	}
	//回到顶部
	function toTop(){
		document.querySelector("#body").scrollIntoView(true);
	}
	
	function publichTopic(){
		var xmlhttp;
		var topicname=document.getElementById("topic_name").value;
		var typeid=document.getElementById("typeid").value;
		var content=document.getElementById("content").value;
		if(topicname==null||topicname==""){
			alert("话题名不能为空");
			
		}else if(content==null||content==""){
			alert("话题内容不能为空");
		}else if(content.length>1000){
			alert("话题内容超出范围");
		}else{
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
					//window.location.reload(); 
					location.href="index.jsp";
				}
			  }
			xmlhttp.open("post","publishTopic",true);
			xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			
			xmlhttp.send("topicname="+topicname+"&typeid="+typeid+"&content="+content);	
		}
	}
	function publichReply(){
		var xmlhttp;
		var topicid=document.getElementById("topicid").innerHTML;
		var reply=document.getElementById("content").value;
		//var content=document.getElementById("content").value;
		//alert(reply);
		if(reply==null||reply==""){
			alert("回帖不能为空");
		}else{
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
					//window.location.reload(); 
					location.href="topic?topicid="+topicid;
				}
			  }
			xmlhttp.open("post","reply",true);
			xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			xmlhttp.send("topicid="+topicid+"&reply="+reply);
		}
	}
	