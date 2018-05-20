function changeType(id){
	//document.getElementById("a").innerHTML="aaaaaaaaaaa";
		
		document.getElementById("type_1").className="content_head_one";
		document.getElementById("type_2").className="content_head_one";
		document.getElementById("type_3").className="content_head_one";
		document.getElementById("type_4").className="content_head_one";
		document.getElementById("type_5").className="content_head_one";
		document.getElementById("type_6").className="content_head_one";
		document.getElementById("content_head").getElementsByTagName("li")[id-1].className="content_head_two";
		//document.getElementById("type_style").getElementsByTagName("li")[typeid].className="topic_type_two";
		switch(id){
		case 1:
			document.getElementById("type1").style.display="block";
			document.getElementById("type2").style.display="none";
			document.getElementById("type3").style.display="none";
			document.getElementById("type4").style.display="none";
			document.getElementById("type5").style.display="none";
			document.getElementById("type6").style.display="none";
			break;
		case 2:
			document.getElementById("type1").style.display="none";
			document.getElementById("type2").style.display="block";
			document.getElementById("type3").style.display="none";
			document.getElementById("type4").style.display="none";
			document.getElementById("type5").style.display="none";
			document.getElementById("type6").style.display="none";
			break;
		case 3:
			document.getElementById("type1").style.display="none";
			document.getElementById("type2").style.display="none";
			document.getElementById("type3").style.display="block";
			document.getElementById("type4").style.display="none";
			document.getElementById("type5").style.display="none";
			document.getElementById("type6").style.display="none";
			break;
		case 4:
			document.getElementById("type1").style.display="none";
			document.getElementById("type2").style.display="none";
			document.getElementById("type3").style.display="none";
			document.getElementById("type4").style.display="block";
			document.getElementById("type5").style.display="none";
			document.getElementById("type6").style.display="none";
			break;
		case 5:
			document.getElementById("type1").style.display="none";
			document.getElementById("type2").style.display="none";
			document.getElementById("type3").style.display="none";
			document.getElementById("type4").style.display="none";
			document.getElementById("type5").style.display="block";
			document.getElementById("type6").style.display="none";
			break;
		case 6:
			document.getElementById("type1").style.display="none";
			document.getElementById("type2").style.display="none";
			document.getElementById("type3").style.display="none";
			document.getElementById("type4").style.display="none";
			document.getElementById("type5").style.display="none";
			document.getElementById("type6").style.display="block";
			break;
		}
	}
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
function onLoadFunction(arg1){
	switch(arg1){
	case 1:
		document.getElementById("type_1").className="content_head_one";
		document.getElementById("type_2").className="content_head_one";
		document.getElementById("type_3").className="content_head_one";
		document.getElementById("type_4").className="content_head_one";
		document.getElementById("type_5").className="content_head_one";
		document.getElementById("type_6").className="content_head_one";
		document.getElementById("content_head").getElementsByTagName("li")[arg1-1].className="content_head_two";
		
		document.getElementById("type1").style.display="block";
		document.getElementById("type2").style.display="none";
		document.getElementById("type3").style.display="none";
		document.getElementById("type4").style.display="none";
		document.getElementById("type5").style.display="none";
		document.getElementById("type6").style.display="none";
		break;
	case 2:
		document.getElementById("type_1").className="content_head_one";
		document.getElementById("type_2").className="content_head_one";
		document.getElementById("type_3").className="content_head_one";
		document.getElementById("type_4").className="content_head_one";
		document.getElementById("type_5").className="content_head_one";
		document.getElementById("type_6").className="content_head_one";
		document.getElementById("content_head").getElementsByTagName("li")[arg1-1].className="content_head_two";
		
		document.getElementById("type1").style.display="none";
		document.getElementById("type2").style.display="block";
		document.getElementById("type3").style.display="none";
		document.getElementById("type4").style.display="none";
		document.getElementById("type5").style.display="none";
		document.getElementById("type6").style.display="none";
		break;
	case 3:
		document.getElementById("type_1").className="content_head_one";
		document.getElementById("type_2").className="content_head_one";
		document.getElementById("type_3").className="content_head_one";
		document.getElementById("type_4").className="content_head_one";
		document.getElementById("type_5").className="content_head_one";
		document.getElementById("type_6").className="content_head_one";
		document.getElementById("content_head").getElementsByTagName("li")[arg1-1].className="content_head_two";
		
		document.getElementById("type1").style.display="none";
		document.getElementById("type2").style.display="none";
		document.getElementById("type3").style.display="block";
		document.getElementById("type4").style.display="none";
		document.getElementById("type5").style.display="none";
		document.getElementById("type6").style.display="none";
		break;
	case 4:
		document.getElementById("type_1").className="content_head_one";
		document.getElementById("type_2").className="content_head_one";
		document.getElementById("type_3").className="content_head_one";
		document.getElementById("type_4").className="content_head_one";
		document.getElementById("type_5").className="content_head_one";
		document.getElementById("type_6").className="content_head_one";
		document.getElementById("content_head").getElementsByTagName("li")[arg1-1].className="content_head_two";
		
		document.getElementById("type1").style.display="none";
		document.getElementById("type2").style.display="none";
		document.getElementById("type3").style.display="none";
		document.getElementById("type4").style.display="block";
		document.getElementById("type5").style.display="none";
		document.getElementById("type6").style.display="none";
		break;
	case 5:
		document.getElementById("type_1").className="content_head_one";
		document.getElementById("type_2").className="content_head_one";
		document.getElementById("type_3").className="content_head_one";
		document.getElementById("type_4").className="content_head_one";
		document.getElementById("type_5").className="content_head_one";
		document.getElementById("type_6").className="content_head_one";
		document.getElementById("content_head").getElementsByTagName("li")[arg1-1].className="content_head_two";
		
		document.getElementById("type1").style.display="none";
		document.getElementById("type2").style.display="none";
		document.getElementById("type3").style.display="none";
		document.getElementById("type4").style.display="none";
		document.getElementById("type5").style.display="block";
		document.getElementById("type6").style.display="none";
		break;
	case 6:
		document.getElementById("type_1").className="content_head_one";
		document.getElementById("type_2").className="content_head_one";
		document.getElementById("type_3").className="content_head_one";
		document.getElementById("type_4").className="content_head_one";
		document.getElementById("type_5").className="content_head_one";
		document.getElementById("type_6").className="content_head_one";
		document.getElementById("content_head").getElementsByTagName("li")[arg1-1].className="content_head_two";
		
		document.getElementById("type1").style.display="none";
		document.getElementById("type2").style.display="none";
		document.getElementById("type3").style.display="none";
		document.getElementById("type4").style.display="none";
		document.getElementById("type5").style.display="none";
		document.getElementById("type6").style.display="block";
		break;
	default:
		document.getElementById("type_1").className="content_head_one";
		document.getElementById("type_2").className="content_head_one";
		document.getElementById("type_3").className="content_head_one";
		document.getElementById("type_4").className="content_head_one";
		document.getElementById("type_5").className="content_head_one";
		document.getElementById("type_6").className="content_head_one";
		document.getElementById("content_head").getElementsByTagName("li")[arg1-1].className="content_head_two";
	
		document.getElementById("type1").style.display="block";
		document.getElementById("type2").style.display="none";
		document.getElementById("type3").style.display="none";
		document.getElementById("type4").style.display="none";
		document.getElementById("type5").style.display="none";
		document.getElementById("type6").style.display="none";
	break;
	}
}

function deleteTopic(topicid){
	setXHR("deleteTopic?topicid="+topicid,function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
			var str=xmlhttp.responseText;
			alert(str);
			
			window.location.reload(); 
	    }
	});
}
function deleteFollow(followsid){
	setXHR("deleteFans?followsid="+followsid,function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
			var str=xmlhttp.responseText;
			alert(str);
			window.location.reload(); 
	    }
	});
}
function changeImg(imgid){
	setXHR("getImg?imgid="+imgid,function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
			var str=xmlhttp.responseText;
			document.getElementById("img").innerHTML="<img src='"+str+"'>";
	    }
	});
}
function changeUserInfo(){
	var xmlhttp;
	var uname=document.getElementById("uname").value;
	var sex=document.getElementById("sex").value;
	var imgid=document.getElementById("imgid").value;
	var email=document.getElementById("email").value;
	//document.getElementById("a").innerHTML=uname;
	if(!/^[a-zA-Z0-9\u4E00-\u9FA5]{1,8}$/.test(uname)){
		alert("昵称不可用");
	}	
	else if(!/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/.test(email)){
		alert("邮箱不可用");
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
				window.location.reload(); 
			}
		  }
		xmlhttp.open("POST","editUser",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send("uname="+uname+"&sex="+sex+"&imgid="+imgid+"&email="+email);
	}	
}
function changePassword(){
	var xmlhttp;
	var oldpassword=document.getElementById("oldpassword").value;
	var newpassword=document.getElementById("newpassword").value;
	var nextpassword=document.getElementById("nextpassword").value;
	if(!/^[a-zA-Z0-9]{8,16}$/.test(oldpassword)){
		alert("旧密码应为8-16位的数字或字母");
	}else if(!/^[a-zA-Z0-9]{8,16}$/.test(newpassword)){
		alert("新密码应为8-16位的数字或字母");
	}else if(newpassword!=nextpassword){
		alert("两次输入密码不一样！\n请重新输入");
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
					window.location.reload(); 
				}
			  }
			xmlhttp.open("POST","updataPassword",true);
			xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			xmlhttp.send("oldpassword="+oldpassword+"&newpassword="+newpassword);
	
	}
			
}