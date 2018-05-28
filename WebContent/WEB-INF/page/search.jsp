<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list</title>
<script src="resources/jquery-3.3.1.min.js"></script>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<script src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript">

function deleteSure() {
	if (confirm("确认删除？")) {
		return true;
	}
	return false;
}

$(function(){
	$("#refresh").click(function(){
		location.assign("list");
	});
});

$(function(){
	$("#add").click(function(){
		location.assign("add");
	});
});

$(function(){
	var listcnt = $("#lp").children("tr").size();
	var txt = "<tr><td></td><td></td><td></td><td></td><td></td></tr>"
	while (listcnt < 5) {
		$("#lp").append(txt);
		listcnt++;
	}
})

</script>
<style type="text/css">
body {
	font-family: Microsoft YaHei;
}
table {
	
}
td {
	width: 20%;
	height: 40px;
	text-align: center;
}
th {
	width: 20%;
	height: 40px;
	text-align: center;
}
.dropdown-menu {
	min-width: 70px;
}
</style>
</head>
<body>
	<div style="padding-top: 10px; padding-bottom: 10px; background-color: lightgray">
	
	<table style="margin-left: 10%; margin-right: 20%">
	<tr><td style="width: 100%; text-align: left">
	<div class="btn-group btn-group-lg" role="group" aria-label="web">
		<button id="add" type="button" class="btn btn-default">增加</button>
		<button id= "refresh" type="button" class="btn btn-default">刷新</button>
		<button type="button" class="btn btn-default">打印</button>
	</div>
	</td>
	<td style="width: 240px">
	<form action="search" method="post">
	<div class="input-group">
      <input style="width: 200px" type="text" class="form-control" name="searchByName" placeholder="Search for...">
      <span class="input-group-btn">
        <button class="btn btn-default" type="submit">搜索</button>
      </span>
    </div>
    </form>
	</td>
	</tr>
	
	</table>
	</div>
	<div style="margin-left: 10%; margin-right: 20%; padding-top: 20px">
	<table style="width: 100%" class="table-bordered table-hover">
		<thead>
			<tr>
				<th>Id</th>
				<th>姓名</th>
				<th>邮箱</th>
				<th>电话</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody id="lp">
			<c:forEach items="${userInfos}" var="userInfo">
				<tr>
					<td>${userInfo.id}</td>
					<td>${userInfo.name}</td>
					<td>${userInfo.email}</td>
					<td>${userInfo.telephone}</td>
					<td>
						<a href="view?id=${userInfo.id}">
							<span style="padding-right: 20px; border-right: 1px solid #999"><button class="btn btn-default">查看</button></span>
						</a>
						<a href="delete?id=${userInfo.id}" onclick="return deleteSure()">
							<span style="padding-left: 20px"><button class="btn btn-default">删除</button></span>
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div style="float: right; margin-top: 20px; margin-left: 20px" class="btn-group">
	    <div class="input-group">
 			<button style="color: #337ab7; width: 55px" type="button" class="btn btn-default dropdown-toggle"  data-toggle="dropdown">
	     		${pageInfo.page}
	      		<span style="color: black" class="caret"></span>         
    		</button>
  			
		
	      
	    <ul class="dropdown-menu" role="menu">
	    	<c:forEach var="i" begin="1" end="${pageInfo.last}">
	    		<li>
	    			<a href="?searchByName=${searchByName}&page=${i}">${i}</a>
	    		</li>
	    	</c:forEach>
	    </ul>
	    <span style="width: 20px" class="input-group-addon" id="basic-addon2">/ ${pageInfo.last}</span>
	</div>
	
	</div>
	<nav style="float: right">
	  <ul class="pagination">
	    <li><a href="?searchByName=${searchByName}&page=1" aria-label="Previous">首页</a></li>
	    <li><a href="?searchByName=${searchByName}&page=${pageInfo.pre}">上一页</a></li>
	    <li><a href="?searchByName=${searchByName}&page=${pageInfo.next}">下一页</a></li>
	    <li><a href="?searchByName=${searchByName}&page=${pageInfo.last}" aria-label="Next">尾页</a></li>
	  </ul>
	</nav>
	
	</div>

</body>
</html>