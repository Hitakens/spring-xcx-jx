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
		<div class="top">
			<img style="width: 90px; height: 76px; vertical-align: middle;"
				src="${pageContext.request.contextPath}/static/jx/img/gly/km.png">
			<p class="jkname">卡密生成</p>
		</div>
		<form>

			<div class="weui-cells weui-cells_form" id="loginiptView">
				<div class="weui-cell">
					<div class="weui-cell__hd">
						<label class="weui-label" style="width: 40px"> <img
							src="${pageContext.request.contextPath}/static/jx/img/gly/pass.svg">
						</label>
					</div>
					<div class="weui-cell__bd">
						<input type="hidden" name="uname" id="uname" value="${uname}">
						<input class="weui-input" type="text" minlength="11"
							maxlength="32" value="${cardmi}" id="carpass" name="carpass"
							placeholder="自定义卡密(11-32)">
					</div>
					<div class="weui-cell__ft">
						<a href='javascript:;' onclick="confirmkm();"
							class="weui-vcode-btn"> <label class="weui-label"
							style="width: 32px"><img
								style="width: 40px; height: 32px; line-height: 45px; margin-top: 5px;"
								src="${pageContext.request.contextPath}/static/jx/img/gly/sj.svg">
						</label></a>
					</div>
				</div>

				<!-- <div class="weui-cell">
					<div class="weui-cell__bd weui-cell__bd——zdy">随机生成(<span id='job'></span>)</div>
				</div> -->
			</div>
			<a href="javascript:;"
				class="login weui-btn weui-btn_dt" style="margin-top: 20px;"
				id="submitLogin" data-clipboard-action="copy"
				data-clipboard-target="#carpass">确认卡密</a>

		</form>
		<div class="weui-footer">
			<p class="weui-footer__text">Copyright © 2019 通关驾考</p>
		</div>
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
		function confirmkm() {
			$.get('/main/admin/ajaxkmsc', {
				"n" : 1
			}, function(res) {
				$('#carpass').val(res);
			});
		}

		var btn = document.getElementById('submitLogin');
		var clipboard = new Clipboard(btn);//实例化
		clipboard.on('success', function(e) {//复制成功执行的回调，可选
			$.post('/main/admin/submitinsert', {
				"str1" : $('#uname').val(),
				"str2" : $('#carpass').val()
			}, function(res) {
				if (res == "200") {
					$.toast("复制成功")
				} else if (res == "201") {
					$.toast("卡密生成失败！", "cancel")
				} else {
					$.toptip(res, 'error');
				}
			});
		});
		clipboard.on('error', function(e) {//复制失败执行的回调，可选
			$.toast("复制失败", "cancel")
		});
	</script>

</body>
<!-- END BODY -->
</html>