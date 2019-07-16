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
<script src="${pageContext.request.contextPath}/static/jx/js/kmtmxg.js"
	charset="utf-8"></script>
<script
	src="${pageContext.request.contextPath}/static/all/jquery-3.3.1.min.js"
	charset="utf-8"></script>
</head>
<script type="text/javascript">
	var pathName = '${pageContext.request.contextPath}';
</script>
<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">修改选中行数据</button>
    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">上传图片</button>
  </div>
</script>

<body>
	<div class="warp">
		<div class="cx_top">

			<form class="layui-form" action="">
				<div class="demoTable">
					<div class="layui-inline layui-input-inline_zdy">
						<select id="kmlx">
							<option value='xckmy'>科目一题目</option>
							<option value='xckms'>科目四题目</option>
						</select>
					</div>
					<div class="layui-inline">
						<input class="layui-input" name="id" placeholder="请输入题目的关键字"
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

	<div id='opengz'>
		<div class="layui-form-item layui-form-item-zdy">
			<label class="layui-form-label">题目:</label>
			<div class="layui-input-block">
				<input type="text" name="questionTitle" id="questionTitle"
					lay-verify="title" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item layui-form-item-zdy">
			<label class="layui-form-label">选项:</label>
			<div class="layui-input-block">
				<input type="text" name="questionItems" id="questionItems"
					lay-verify="title" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item layui-form-item-zdy">
			<label class="layui-form-label">正确答案:</label>
			<div class="layui-input-block">
				<input type="text" name="questionAnswer" id="questionAnswer"
					lay-verify="title" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item layui-form-item-zdy">
			<label class="layui-form-label">技巧:</label>
			<div class="layui-input-block">
				<input type="text" name="questionSkills" id="questionSkills"
					lay-verify="title" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item layui-form-item-zdy">
			<label class="layui-form-label">答案解析:</label>
			<div class="layui-input-block">
				<input type="text" name="answerAnalysis" id="answerAnalysis"
					lay-verify="title" class="layui-input">
			</div>
		</div>
		<form class="layui-form" action="">
			<div class="layui-form-item layui-form-item-zdy">
				<label class="layui-form-label">题目类型</label>
				<div class="layui-input-block">
					<select name="tmxzlx" id="tmxzlx" lay-filter="aihao">
						<option value="单选题">单选题</option>
						<option value="多选题">多选题</option>
						<option value="判断题">判断题</option>
					</select>
				</div>
			</div>
		</form>
	</div>
</body>
<!-- END BODY -->
</html>