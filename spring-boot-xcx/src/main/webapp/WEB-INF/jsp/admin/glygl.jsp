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
<script src="${pageContext.request.contextPath}/static/jx/js/glygl.js"
	charset="utf-8"></script>
<script
	src="${pageContext.request.contextPath}/static/all/jquery-3.3.1.min.js"
	charset="utf-8"></script>
</head>
<script type="text/javascript">
	var pathName = '${pageContext.request.contextPath}';
</script>
<style>
.layui-form-item-zdy{
margin-left: 10px;
width: 300px;
}
.layui-form-item-zdy input{
width: 200px;
}
</style>
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="add"><i class="layui-icon layui-icon-add-circle"></i>添加</button>
    <button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="update"><i class="layui-icon layui-icon-edit"></i>修改</button>
    <button class="layui-btn layui-btn-sm  layui-btn-danger" lay-event="del"><i class="layui-icon layui-icon-delete"></i>删除</button>
  </div>
</script>
<script type="text/html" id="checkboxTpl">
  <!-- 这里的 checked 的状态只是演示 -->
  <input type="checkbox"  name="{{d.username}}" value="{{d.yxbz}}" title="可用" lay-filter="lockDemo" {{ d.yxbz == 'Y' ? 'checked' : '' }}>
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
    <!-- 添加 -->
	<div id='add'>
	<div class="layui-form-item layui-form-item-zdy">
			<label class="layui-form-label">用户账号:</label>
			<div class="layui-input-block">
				<input type="text"  name="questionTitle" id="username"
					lay-verify="title" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item layui-form-item-zdy">
			<label class="layui-form-label">用户密码:</label>
			<div class="layui-input-block">
				<input type="text" name="questionItems" id="userpass"
					lay-verify="title" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item layui-form-item-zdy">
			<label class="layui-form-label">用户备注:</label>
			<div class="layui-input-block">
				<input type="text" name="questionSkills" id="bz"
					lay-verify="title" class="layui-input">
			</div>
		</div>
		<form class="layui-form" action="">
		<div class="layui-form-item layui-form-item-zdy">
    <label class="layui-form-label">管理员:</label>
    <div class="layui-input-block" id="IsPurchased">
      <input type="radio" name="sfgly" value="Y" title="是">
      <input type="radio" name="sfgly" value="N" title="否"  checked="">
    </div>
  </div>
  </form>
	</div>
	<!-- 修改 -->
	<div id='upd'>
	 	<div class="layui-form-item layui-form-item-zdy">
			<label class="layui-form-label">用户账号:</label>
			<div class="layui-input-block">
				<input type="text" readonly readonly name="questionTitle" id="questionTitle"
					lay-verify="title" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item layui-form-item-zdy">
			<label class="layui-form-label">用户密码:</label>
			<div class="layui-input-block">
				<input type="text" name="questionItems" id="questionItems"
					lay-verify="title" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item layui-form-item-zdy">
			<label class="layui-form-label">用户备注:</label>
			<div class="layui-input-block">
				<input type="text" name="questionSkills" id="questionSkills"
					lay-verify="title" class="layui-input">
			</div>
		</div>
	</div>
</body>
<!-- END BODY -->
</html>