<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html class="x-admin-sm">
<head>
<meta charset="UTF-8">
<title>后台管理模块</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/admin/css/font.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/admin/css/xadmin.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/all/layui2.4.5/css/layui.css"
	media="all">

<script
	src="${pageContext.request.contextPath}/static/all/jquery-3.3.1.min.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/admin/js/xadmin.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/admin/js/cookie.js"></script>
	<script
	src="${pageContext.request.contextPath}/static/all/layui2.4.5/layui.js"
	charset="utf-8"></script>
<script>
	// 是否开启刷新记忆tab功能
	// var is_remember = false;
</script>
</head>
<style>
.copyright{
text-align: center;
}
</style>
<body>
	<!-- 顶部开始 -->
	<div class="container">
		<div class="logo">
			<a href="./index.html">后台管理</a>
		</div>
		<div class="left_open">
			<i title="展开左侧栏" class="iconfont">&#xe699;</i>
		</div>
	
		<ul class="layui-nav right" lay-filter="">
			<li class="layui-nav-item"><a href="javascript:;">admin</a>
				<dl class="layui-nav-child">
					<!-- 二级菜单 -->
					
					<dd>
						<a onclick="x_admin_show('切换帐号','http://www.baidu.com')">切换帐号</a>
					</dd>
					<dd>
						<a href="./login.html">退出</a>
					</dd>
				</dl></li>
			<li class="layui-nav-item to-index"><a href="#">前台首页</a></li>
		</ul>

	</div>
	<!-- 顶部结束 -->
	<!-- 中部开始 -->
	<!-- 左侧菜单开始 -->
	<div class="left-nav">
		<div id="side-nav">
			<ul id="nav">
				<li><a href="javascript:;"> <i class="iconfont">&#xe6b8;</i>
						<cite>会员管理</cite> <i class="iconfont nav_right">&#xe697;</i>
				</a>
					<ul class="sub-menu">
						<li date-refresh="1"><a _href="member-list.html"> <i
								class="iconfont">&#xe6a7;</i> <cite>管理员列表</cite>

						</a></li>
						<li><a _href="member-list1.html"> <i class="iconfont">&#xe6a7;</i>
								<cite>管理员添加</cite>

						</a></li>
						<li date-refresh="1"><a _href="member-del.html"> <i
								class="iconfont">&#xe6a7;</i> <cite>管理员删除</cite>

						</a></li>
						
					</ul></li>
				<li><a href="javascript:;"> <i class="iconfont">&#xe723;</i>
						<cite>题目管理</cite> <i class="iconfont nav_right">&#xe697;</i>
				</a>
					<ul class="sub-menu">
						<li><a _href="${pageContext.request.contextPath}/main/admin/xcgl"> <i class="iconfont">&#xe6a7;</i>
								<cite>小车管理</cite>
						</a></li>
					</ul>
					<ul class="sub-menu">
						<li><a _href="${pageContext.request.contextPath}/main/admin/hcgl"> <i class="iconfont">&#xe6a7;</i>
								<cite>货车管理</cite>
						</a></li>
					</ul>
					<ul class="sub-menu">
						<li><a _href="${pageContext.request.contextPath}/main/admin/kcgl"> <i class="iconfont">&#xe6a7;</i>
								<cite>客车管理</cite>
						</a></li>
					</ul>
					</li>
			</ul>
		</div>
	</div>
	<!-- <div class="x-slide_left"></div> -->
	<!-- 左侧菜单结束 -->
	<!-- 右侧主体开始 -->
	<div class="page-content">
		<div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
			<ul class="layui-tab-title">
				<li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
			</ul>
			<div class="layui-unselect layui-form-select layui-form-selected"
				id="tab_right">
				<dl>
					<dd data-type="this">关闭当前</dd>
					<dd data-type="other">关闭其它</dd>
					<dd data-type="all">关闭全部</dd>
				</dl>
			</div>
			<div class="layui-tab-content">
				<div class="layui-tab-item layui-show">
					<iframe src='${pageContext.request.contextPath}/main/admin/welcome' frameborder="0" scrolling="yes"
						class="x-iframe"></iframe>
				</div>
			</div>
			<div id="tab_show"></div>
		</div>
	</div>
	<div class="page-content-bg"></div>
	<!-- 右侧主体结束 -->
	<!-- 中部结束 -->
	<!-- 底部开始 -->
	<div class="footer">
		<div class="copyright">Copyright ©2019
			</div>
	</div>
	<!-- 底部结束 -->
	<script>
	
	</script>
</body>
</html>