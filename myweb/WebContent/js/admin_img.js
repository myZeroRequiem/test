function addImg(){
	var imgid=document.getElementById("_imgid").value;
	var img=document.getElementById("_img").value;
	
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
	xmlhttp.open("get","adminAddImg?imgid="+imgid+"&img="+img,true);
	
	xmlhttp.send();	

}
function editImg(imgid){
	
	var img=document.getElementById(imgid+"_img").value;
	
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
	xmlhttp.open("get","adminEditImg?imgid="+imgid+"&img="+img,true);
	
	xmlhttp.send();	

}