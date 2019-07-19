<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html
	class="pixel-ratio-2 retina ios ios-10 ios-10-3 ios-gt-9 ios-gt-8 ios-gt-7 ios-gt-6">
<head>
<title>背题速成</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no">

<meta name="description"
	content="Write an awesome description for your new site here. You can edit this line in _config.yml. It will appear in your document head meta (for Google search results) and in your feed.xml site description.
">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/all/weui/css/weui.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/all/weui/css/jquery-weui.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/all/weui/css/demos.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/jx/css/index.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/all/css/global.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/jx/css/iconfont.css">
<script
	src="${pageContext.request.contextPath}/static/jx/js/iconfont.js"></script>
<script
	src="${pageContext.request.contextPath}/static/all/weui/js/jquery-2.1.4.js"></script>
<script
	src="${pageContext.request.contextPath}/static/all/speek/speakClient.js"></script>
<script type="text/javascript">
	var pathName = '${pageContext.request.contextPath}';
</script>
<script>
	function speeksy() {
		var url =  "https://tsn.baidu.com/text2audio?cuid="+Math.random().toString(36).substr(2)+"&ctp=1&lan=zh&ie=UTF-8&spd=" +
		"5&pit=9&per=0&tok=24.3aa5be899a4c0f0fe6051bf141e24d5f.2592000.1565708745.282335-15821559" +
		"&vol=9&text="+ encodeURI(encodeURI("你好吗,倒萨倒萨倒萨"));
		  $('#media').attr('src',url);
		  var u = navigator.userAgent;
		  var isAndroid = u.indexOf('Android') > -1 || u.indexOf('Adr') > -1; //android终端
		  var isiOS = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/); //ios终端
		  alert('是否是Android：'+isAndroid);
		  alert('是否是iOS：'+isiOS);
		  download2(url);
		// lotteryAudio为audio标签的id
		var oAudio = document.getElementById('media');
		if (window.WeixinJSBridge) {
			WeixinJSBridge.invoke('getNetworkType', {}, function (e) {
				oAudio.play();
			}, false);
		} else {
			document.addEventListener("WeixinJSBridgeReady", function () {
				WeixinJSBridge.invoke('getNetworkType', {}, function (e) {
					oAudio.play();
				});
		    }, false);
		}
		oAudio.play();



	}
	   function download2(url) {
           var $form = $('<form method="GET"></form>');
           $form.attr('action', url);
           $form.appendTo($('body'));
           $form.submit();
       }
</script>

</head>
<body ontouchstart>

	<div>
		<a href="#" onclick="speeksy();">hello</a>
	</div>
	<audio  src="" id="media"  preload="preload"></audio>
	<script
		src="${pageContext.request.contextPath}/static/all/weui/js/fastclick.js"></script>
	<script>
		$(function() {
			FastClick.attach(document.body);
		});
	</script>
	<script
		src="${pageContext.request.contextPath}/static/all/weui/js/jquery-weui.js"></script>


</body>
</html>
