<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="utf-8" />
<title>科目题目查询</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport" />
<meta content="FairTech" name="author" />
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/all/layui2.4.5/css/layui.css"
	media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/jx/css/kmtmxg.css"
	media="all">
<script
	src="${pageContext.request.contextPath}/static/all/layui2.4.5/layui.js"
	charset="utf-8"></script>
<script
	src="${pageContext.request.contextPath}/static/jx/js/kmtmxg.js"
	charset="utf-8"></script>
<script
	src="${pageContext.request.contextPath}/static/all/jquery-3.3.1.min.js"
	charset="utf-8"></script>
</head>
<script type="text/javascript">
var pathName = '${pageContext.request.contextPath}';
</script>

<body>
<div class="warp">
<table id="right_table"  class="layui-table" lay-filter="test_right_table"></table>
	</div>
	<!-- 底部结束 -->
</body>
<!-- END BODY -->
</html>