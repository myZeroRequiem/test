function changeType(id){
	//document.getElementById("a").innerHTML="aaaaaaaaaaa";
		
		document.getElementById("type_1").className="content_head_one";
		document.getElementById("type_2").className="content_head_one";
		document.getElementById("type_3").className="content_head_one";
		document.getElementById("type_4").className="content_head_one";
		document.getElementById("content_head").getElementsByTagName("li")[id-1].className="content_head_two";
		//document.getElementById("type_style").getElementsByTagName("li")[typeid].className="topic_type_two";
		switch(id){
		case 1:
			document.getElementById("type1").style.display="block";
			document.getElementById("type2").style.display="none";
			document.getElementById("type3").style.display="none";
			document.getElementById("type4").style.display="none";
			break;
		case 2:
			document.getElementById("type1").style.display="none";
			document.getElementById("type2").style.display="block";
			document.getElementById("type3").style.display="none";
			document.getElementById("type4").style.display="none";
			break;
		case 3:
			document.getElementById("type1").style.display="none";
			document.getElementById("type2").style.display="none";
			document.getElementById("type3").style.display="block";
			document.getElementById("type4").style.display="none";
			break;
		case 4:
			document.getElementById("type1").style.display="none";
			document.getElementById("type2").style.display="none";
			document.getElementById("type3").style.display="none";
			document.getElementById("type4").style.display="block";
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
function addFans(followsid){
	setXHR("addFans?followsid="+followsid,function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
			var str=xmlhttp.responseText;
			alert(str);
			window.location.reload(); 
	    }
	});
}
function deleteFans(followsid){
	setXHR("deleteFans?followsid="+followsid,function(){
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
			var str=xmlhttp.responseText;
			alert(str);
			window.location.reload(); 
	    }
	});
}


