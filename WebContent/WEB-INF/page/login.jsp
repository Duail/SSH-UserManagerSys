<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="resources/jquery-3.3.1.min.js"></script>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<script src="resources/js/bootstrap.min.js"></script>
<!-- <script src="/demo/resources/json2.js"></script> -->
<script type="text/javascript">
$(function(){
	$("#test").click(function(){
		
		var page ="/demo/checkManager.do";
		var manager = $("input:first").val();
		var password = $("input:last").val();
		var data = {id:1, manager: "123", password: "123123"};
		debugger;
		alert($("#loginForm").serializeJson());
		$.ajax({
			url:page,
			type:'post',
			dataType:'json',
			contentType: "application/json; charset=utf-8",
			data:JSON.stringify(data),
			success:function(data){
				if (data == "true"){
					$("#test").submit();
				}else{
					$("#checkName").show();
				}
			}
		});
		
	});
});

$(function(){
	$("#test1").click(function(){
		
		var page ="checkManager";
		var manager = $("input:first").val();
		var password = $("input:last").val();
		debugger;
		$.ajax({
			url:page,
			type:"POST",
			dataType:'json',
			data:{"manager": manager, "password": password},
			success:function(data){
				debugger;
				if (data.msg == "true"){
					$("#loginForm").submit();
				}
				$("#checkName").show();
			}
		});
		
	});
});

</script>
</head>
<body>
login<br/>
<div style="color: red; display:none;" id="checkName">错误</div>
<form id="loginForm" action="managerLogin" method="post">
	<input type="text" name="manager">
	<input type="password" name="password">
	
</form>
<button id="test1">accept</button>
</body>
</html>