function regist(){
	var xmlhttp;
	var uid=document.getElementById("uid").value;
	var uname=document.getElementById("uname").value;
	var password=document.getElementById("password").value;
	var nextpassword=document.getElementById("nextpassword").value;
	var sex=document.getElementById("sex").value;
	var email=document.getElementById("email").value;
	var check=document.getElementById("checkbox");
	if(check.checked){
		if(!/^[a-zA-Z][a-zA-Z0-9]{5,10}$/.test(uid)){
			alert("账号不可用");
		}else if(!/^[a-zA-Z0-9\u4E00-\u9FA5]{1,8}$/.test(uname)){
			alert("昵称不可用");
		}
		else if(!/^[a-zA-Z0-9]{8,16}$/.test(password)){
			alert("密码不可用");
		}
		else if(nextpassword!=password){
			alert("两次密码不一样");
		}		
		else if(!/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/.test(email)){
			alert("邮箱不可用");
		}
		
		else{
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
					if(str=="注册成功"){
						alert(str);
						location.href="jsp/login.jsp";
					}
					//window.location.reload(); 
					else{
						alert(str);
						location.href="jsp/regist.jsp";
					}
					
				}
			  }
			xmlhttp.open("post","regist",true);
			xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			
			xmlhttp.send("uid="+uid+"&password="+password+"&uname="+uname+"&sex="+sex+"&email="+email);	
		
		}
	}else{
		alert("请勾选我已阅读《用户使用协议》");
		
	}
}

function setUid(uid){
	if(uid==null||uid==""){
		document.getElementById("cue1").innerHTML="6—11位的字母或数字";
		
	}else{
		var first=uid.charAt(0);
		if(!/^[a-zA-Z]$/.test(first)){
			document.getElementById("cue1").innerHTML="<span style='color:red;'>账号只能以字母开头!</span>";
		}else{
			if(!/^[a-zA-Z][a-zA-Z0-9]{5,10}$/.test(uid)){
				document.getElementById("cue1").innerHTML="<span style='color:red;'>账号为6-11位的数字或字母</span>";
			}
			else{
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
						if(str=="账号可用"){
							document.getElementById("cue1").innerHTML="<span style='color:#24B324;'>"+str+"</span>";
							
						}
						//window.location.reload(); 
						else{
							document.getElementById("cue1").innerHTML="<span style='color:red;'>"+str+"</span>";
							
						}
						
					}
				  }
				xmlhttp.open("get","uidIsUsed?uid="+uid,true);
				
				xmlhttp.send();	
			
			}
		}
	}
}
function setUname(uname){
	if(uname==null||uname==""){
		document.getElementById("cue2").innerHTML="最多八个字符";
		
	}else{
		if(!/^[a-zA-Z0-9\u4E00-\u9FA5]{1,8}$/.test(uname)){
			document.getElementById("cue2").innerHTML="<span style='color:red;'>昵称最大为8个字符</span>";
			
		}else{
			document.getElementById("cue2").innerHTML="<span style='color:#24B324;'>昵称可用</span>";
			
		}
	}
}
function setPassword(password){
	
	if(password==null||password==""){
		document.getElementById("cue3").innerHTML="8-16位的字母或数字";		
	}else{
		if(!/^[a-zA-Z0-9]{8,16}$/.test(password)){
			document.getElementById("cue3").innerHTML="<span style='color:red;'>密码应为8-16位数字或字母</span>";		
		}else{				
				document.getElementById("cue3").innerHTML="<span style='color:#24B324;'>密码可用</span>";								
		}
	}
}
function setNextpassword(nextpassword){
	var password=document.getElementById("password").value;
	if(password!=nextpassword){
		document.getElementById("cue4").innerHTML="<span style='color:red;'>两次输入密码不一样</span>";
	}else{
		document.getElementById("cue4").innerHTML="<span style='color:#24B324;'>密码可用</span>";

	}
}
function setEmail(email){
	if(!/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/.test(email)){
		document.getElementById("cue5").innerHTML="<span style='color:red;'>请输入正确的邮箱格式</span>";

	}else{
		document.getElementById("cue5").innerHTML="<span style='color:#24B324;'>邮箱可用</span>";

	}
}
function agreement(){
	//alert("1111");
	var xmlhttp;
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
		}
	  }
	xmlhttp.open("get","agreement.txt",true);	
	xmlhttp.send();	

}

