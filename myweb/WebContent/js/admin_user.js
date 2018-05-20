function editUser(uid){
	var uname=document.getElementById(uid+"_uname").value;
	var password=document.getElementById(uid+"_password").value;
	var sex=document.getElementById(uid+"_sex").value;
	var imgid=document.getElementById(uid+"_imgid").value;
	var email=document.getElementById(uid+"_email").value;
	var level=document.getElementById(uid+"_level").value;
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
	xmlhttp.open("post","adminEditUser",true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	
	xmlhttp.send("uid="+uid+"&uname="+uname+"&password="+password+"&level="+level+"&sex="+sex+"&email="+email+"&imgid="+imgid);	

}
function deleteUser(uid){
	
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
			//alert(uid);
			
		}
	  }
	xmlhttp.open("get","adminDeleteUser?uid="+uid,true);
	
	xmlhttp.send();	

}
function addUser(){
	var uid=document.getElementById("_uid").value;
	var uname=document.getElementById("_uname").value;
	var password=document.getElementById("_password").value;
	var sex=document.getElementById("_sex").value;
	var imgid=document.getElementById("_imgid").value;
	var email=document.getElementById("_email").value;
	var level=document.getElementById("_level").value;
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
	xmlhttp.open("post","adminAddUser",true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	
	xmlhttp.send("uid="+uid+"&uname="+uname+"&password="+password+"&level="+level+"&sex="+sex+"&email="+email+"&imgid="+imgid);	

}
