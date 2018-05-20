function isTopTopic(topicid){
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
	xmlhttp.open("get","topTopic?isTop=0&topicid="+topicid,true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	
	xmlhttp.send();	

}
function noTopTopic(topicid){
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
	xmlhttp.open("get","topTopic?isTop=1&topicid="+topicid,true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	
	xmlhttp.send();	

}
function deleteTopic(topicid){
	
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
	xmlhttp.open("get","adminDeleteTopic?topicid="+topicid,true);
	
	xmlhttp.send();	

}

