<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="utf-8" />
<title>管理员管理</title>
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
<script src="${pageContext.request.contextPath}/static/jx/js/usergl.js"
	charset="utf-8"></script>
<script
	src="${pageContext.request.contextPath}/static/all/jquery-3.3.1.min.js"
	charset="utf-8"></script>
</head>
<script type="text/javascript">
	var pathName = '${pageContext.request.contextPath}';
</script>

<script type="text/html" id="checkboxTpl">
  <!-- 这里的 checked 的状态只是演示 -->
  <input type="checkbox"  name="{{d.openid}}" value="{{d.yxbz1}}" title="可用" lay-filter="lockDemo" {{ d.yxbz1 == 'Y' ? 'checked' : '' }}>
</script>

<body>
	<div class="warp">
		<div class="cx_top">

			<form class="layui-form" action="">
				<div class="demoTable">
					<div class="layui-inline">
						<input class="layui-input" name="id" placeholder="请输入用户关键字"
							id="demoReload" autocomplete="off">
					</div>
					<a class="layui-btn" data-type="reload">搜索</a>
				</div>
			</form>
		</div>

		<!-- 查询条件结束 -->


		<table id="right_table" class="layui-table" lay-filter="right_table"></table>
	</div>
	<!-- 底部结束 -->
    
</body>
<!-- END BODY -->
</html>