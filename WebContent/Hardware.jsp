<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Flot Examples</title>

<link href="./js/jQuery-flot/flot/examples/examples.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript" src="./js/jQuery-flot/flot/jquery.js"></script>
<script type="text/javascript" src="./js/jQuery-flot/flot/jquery.flot.js"></script>
<script type="text/javascript" src="./js/jQuery-flot/flot/jquery.flot.pie.js"></script>



<script type="text/javascript">



$(document).ready(function(){

	$.ajax({
		type:"POST",
		url:"./HardwareServlet",
		dataType:"json",
		success:function(result){
			setDiv(result);
			DrawDiv(result);
		}			
	  });

	
	function setDiv(result){
		var json=JSON.stringify(result);    //将数据转换为 json格式的字符串     
		var s=JSON.parse(json);        //json字符串转换为javascript中的json对象
		var obj=Object.keys(s);    //获取磁盘数
		
		for(var i=1;i<=obj.length;i++){
			var aDiv='<div id="pie'+i+'" style="width:400px;height:300px;float:left;"  ></div>';      
			$("body").append(aDiv);	
			}	
	}
	
	
	function DrawDiv(result){
		var json=JSON.stringify(result);    //将数据转换为 json格式的字符串     
		var s=JSON.parse(json);        //json字符串转换为javascript中的json对象
		var obj=Object.keys(s);    //获取磁盘数
		

		console.log(s);
		
	     	var i=1;
		for (var key in s) {
			   
		      
			
		
	    var data = [  
	        { label: key+"使用量",  data:  s[key]},  
	        { label:  key+"剩余量",  data: 100-s[key]},  
	    ];  
	  
	    
	   var options ={
			   
			  
			        series: {  
			                     pie: {   
			                                show: true //显示饼图  
			                     }  
			        },  
			        legend: {  
			                    show: false //不显示图例  
			        }  
			    	   
			   
	   };
	   
	
			 $.plot($("#pie"+i), data, options); 
		        
			    i++;
		  }
	}
	
	
	
}
);



</script>


</head>


<body>

</body>
</html>