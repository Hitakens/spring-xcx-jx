<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html
	class="pixel-ratio-2 retina ios ios-10 ios-10-3 ios-gt-9 ios-gt-8 ios-gt-7 ios-gt-6">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>卡密生成</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/all/weui/css/weui.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/all/weui/css/jquery-weui.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/all/weui/css/demos.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/all/css/global.css"
	type="text/css">
<script type="text/javascript">
	var pathName = '${pageContext.request.contextPath}';
</script>
<style type="text/css">
body {
	background-color: #EFF4FD;
}

.warp {
	height: auto;
	min-height: 100%;
	position: relative;
	overflow: auto;
}

.top {
	width: 100%;
	border-radius: 0 0 25px 25px;
	padding: 30px 0 25px;
	text-align: center;
}

.top .jkname {
	font-size: 16px;
}

form {
	margin: 30px 16px;
}

.weui-label img {
	width: 32px;
	height: 32px;
	vertical-align: middle;
}

.weui-btn_dt {
	background-color: #62B900;
}

.weui-btn_dt:active {
	background-color: #007aff;
}

.login-btns {
	
}

.login-btns a {
	
}

.login-btns a.wxOauth {
	float: left;
	width: 40%;
}

.login-btns a.login {
	float: right;
	width: 55%;
	margin-left: 5%;
}

img.logo {
	width: 76px;
	height: 76px;
	vertical-align: middle;
}

img.wx {
	width: 64px;
	height: 64px;
	vertical-align: middle;
}

.clearfix {
	zoom: 1
}

.clearfix::after {
	content: "\0020";
	display: block;
	height: 0;
	clear: both;
}

.weui-footer {
	position: absolute;
	width: 100%;
	bottom: 10px;
}

.jkname {
	margin-left: -17px;
}

.weui-cell__bd——zdy {
	position: relative;
	right: -70%;
}
</style>

</head>
<body ontouchstart="">


	<div class="warp">
		<a href="javascript:;" onclick="fubh()"></a>

      </div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/all/weui/js/jquery-2.1.4.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/all/weui/js/jquery-weui.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/all/weui/js/fastclick.js"></script>

	<script type="text/javascript">
		// 消除iOS系统下默认的click事件的300毫秒延迟
		$(function() {
			FastClick.attach(document.body);
		});
	</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/all/clipboard.min.js"></script>
	<script type="text/javascript">
		function fubh() {
			
		}
	</script>

</body>
<!-- END BODY -->
</html>