function login(){
	var uid=document.getElementById("uid").value;
	var password=document.getElementById("password").value;
	//alert(password);
	if(uid==null||uid==""){
		alert("请输入账号");
	}else if(password==null||password==""){
		alert("请输入密码");
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
				if(str=="登录成功"){
					alert(str);
					location.href="index.jsp";
				}
				//window.location.reload(); 
				else{
					alert(str);
					location.href="jsp/login.jsp";
				}
				
			}
		  }
		xmlhttp.open("post","login",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		
		xmlhttp.send("uid="+uid+"&password="+password);	
	
	}
}
function EnterPress(e){ //传入 event     
    var e =  window.event;     
    if(e.keyCode == 13){     
        document.getElementById("loginButton").click();     
    }     
}    