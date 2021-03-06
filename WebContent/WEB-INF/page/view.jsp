<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add</title>
<script src="resources/jquery-3.3.1.min.js"></script>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<script src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript">
function saveSure() {
	if (confirm("确认保存？")) {
		if ($("input:first").val() != ""){
			return ture;
		}
		alert("姓名不能为空");
		return false;
	}
	return false;
}
function cancelSure() {
	if (confirm("确认取消？将返回首页..")) {
		location.assign("list");
	}
	return false;
}

function editSure() {
	if (confirm("确认编辑？")) {
		$("div.panel-heading").text("编辑");
		$("input").removeAttr("readonly");
		$("#sure").toggleClass("hide");
		$("#cancel").toggleClass("hide");
		$("#edit").toggleClass("hide");
		$("#back").toggleClass("hide");
	}
	return false;
}

$(function(){
	$("input:first").blur(function(){
		if ($(this).val() != ""){
			$("#checkName").hide();
		} else {
			$("#checkName").show();
		}
		
	});
});
</script>
<style>
div {
	margin-bottom: 5px;
}
form {
	margin-top:50px;
}
button {
	margin-top: 40px;
}
.input-group .form-control {
	width: 350px;
}
.hide {
	display: none;
}
</style>
</head>
<body>
	<div style="margin-left: 10%; margin-right: 20%; padding-top: 60px">
	<div style="width:600px" class="panel panel-info">
		<div class="panel-heading">查看</div>
  		<div class="panel-body">
		<form action="update" method="post">
			<div class="input-group">
  				<span class="input-group-addon">姓名</span>
  				<input readonly="readonly" type="text" class="form-control" name="name" value="${userInfo.name}"><div style="color: red; display:none;" id="checkName">姓名不能为空</div>
			</div>
			<div class="input-group">
  				<span class="input-group-addon">邮箱</span>
  				<input readonly="readonly" type="text" class="form-control" name="email" value="${userInfo.email}">
			</div>
			<div class="input-group">
  				<span class="input-group-addon">电话</span>
  				<input readonly="readonly" type="text" class="form-control" name="telephone" value="${userInfo.telephone}">
			</div>
			<input type="text" class="form-control hide" name="id" value="${userInfo.id}">
			
			<button id="sure" type="submit" class="btn btn-success hide" onclick="return saveSure()">确认</button>
			<button id="cancel" type="button" class="btn btn-danger hide" onclick="cancelSure()">取消</button>
			<button id="edit" style="display:" type="button" class="btn btn-primary" onclick="editSure()">编辑</button>
			<a id="back" href="list" class="">
				<button type="button" class="btn btn-primary">返回</button>
			</a>
		</form>
		</div>
	</div>
	</div>

</body>
</html>