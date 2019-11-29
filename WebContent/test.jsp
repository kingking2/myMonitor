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
<script type="text/javascript"
	src="./js/jQuery-flot/flot/jquery.flot.js"></script>



<script type="text/javascript">



$(document).ready(function(){

	$.ajax({
		type:"POST",
		url:"./CpuServlet",
		dataType:"json",
		success:function(result){
			setDiv(result);
		}			
	  });

	
	function setDiv(result){
		var json=JSON.stringify(result);    //将数据转换为 json格式的字符串     
		var s=JSON.parse(json);        //json字符串转换为javascript中的json对象
		var obj=Object.keys(s);    //获取cpu核数
		
		for(var i=1;i<=obj.length;i++){
			var aDiv='<div id="placeholder'+i+'" style="width:300px;height:200px;float:left;"  ></div>';      
			$("body").append(aDiv);
		}
	
		for(k=0;k<obj.length;k++){
		
			 this['CpuList'+k]=[];
	      
			   
			  
		}

	
	}	

setInterval(function (){
	
	$.ajax({
		type:"POST",
		url:"./CpuServlet",
		dataType:"json",
		success:function(result){
			DrawDiv(result);
		}			
	  });
	
 function DrawDiv(result){
	 
		var json=JSON.stringify(result);    //将数据转换为 json格式的字符串     
		var s=JSON.parse(json);        //json字符串转换为javascript中的json对象
		var obj=Object.keys(s);    //获取cpu核数
		
		

		
	
		function updata(i){
			
	
	

		console.log( this['CpuList'+i].length);
		
		if(this['CpuList'+i].length>10){
			this['CpuList'+i].shift();
			}else{
				this['CpuList'+i].push(s["CPU"+(i)]);
			}  
		
	 		var data=[ [1, this['CpuList'+i][0]], [2,this['CpuList'+i][1]], [3,this['CpuList'+i][2]], [4, this['CpuList'+i][3]], [5, this['CpuList'+i][4]], [6, this['CpuList'+i][5]], 
			    [7, this['CpuList'+i][6]], [8,  this['CpuList'+i][7]], [9, this['CpuList'+i][8]], [10,  this['CpuList'+i][9] ] ];
		   return data;  
		   
		}
		
		
		
		
		for(i=0;i<obj.length;i++){
			
		
			
			var dataset = [
			    {
			    	
			     label: "CPU"+(i+1),
			      series: { lines: { show: true }, points: { show: true} },   
			      data:updata(i)
			   
			    },
			];
			

		    var options = {
		    	
		    		lines: { show: true },
		    		 
		    		points: { show: true},
		    		
		    
		    
		    	 	xaxis: {
		    			show: false
		    		},
		    	   
			     yaxis : {
						ticks : 6,
						tickDecimals : 1,
						min : 0.0,
						max : 100.0
					},

				};

			$.plot($("#placeholder"+(i+1)), dataset, options);
		
		}
		
		
		
	
	
	
    

	}
 
 
},500)
});




</script>


</head>

<body>
	
	
</body>
</html>