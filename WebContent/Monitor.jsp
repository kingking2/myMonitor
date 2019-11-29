<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>远程监控</title>

<link href="./js/jQuery-flot/flot/examples/examples.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript" src="./js/jQuery-flot/flot/jquery.js"></script>
<script type="text/javascript" src="./js/jQuery-flot/flot/jquery.flot.js"></script>
<script type="text/javascript" src="./js/jQuery-flot/flot/jquery.flot.pie.js"></script>



<script type="text/javascript">


	
    	setInterval(function updata(){
		  $.ajax({
				type:"POST",
				url:"./ScreenServlet",
				dataType:"text",
				success:function(result){
				
			
					$("#01").attr("src",result);
				}			
			  });

			},1000);
	
</script>


</head>


<body onload="sesetInterval()">
<img id="01" alt="" >
</body>
</html>