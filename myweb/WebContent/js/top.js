function logout(){
	if(confirm("确定退出吗")){
        
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
				//window.location.reload(); 
				location.href="index.jsp";
			}
		  }
		xmlhttp.open("get","logout",true);
		xmlhttp.send();		
	}else{
        location.href="index.jsp";
    }
}