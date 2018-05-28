<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>success</title>
<script src="resources/jquery-3.3.1.min.js"></script>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<script src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript">
function returnList() {
	location.assign("list");
}
</script>
</head>
<body>
	<div style="margin-left: 10%; margin-right: 20%; padding-top: 60px">
	<div style="width:600px" class="panel panel-success">
		<div class="panel-heading">成功</div>
  		<div class="panel-body">
			<div style="padding-top: 90px; padding-bottom: 90px">操作成功，确认返回...</div>
			<button type="button" class="btn btn-primary" onclick="returnList()">返回</button>
		</div>
	</div>
	</div>
</body>
</html>