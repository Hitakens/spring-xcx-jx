<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html
	class="pixel-ratio-2 retina ios ios-10 ios-10-3 ios-gt-9 ios-gt-8 ios-gt-7 ios-gt-6">
<head>
<title>${tok}</title>
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

<script>
var pathName='${pageContext.request.contextPath}';
$(document).on("click", "#show-confirm", function() {
    $.confirm("该APP17M,你确定下载吗?", function() {
    	window.location.href = pathName+'/xz/downbrowser?fwqlj=/develop/file/红色筑梦延安行.apk';
    }, function() {
      //取消操作
    });
  });

</script>

</head>
<body ontouchstart>

    <div class="weui-msg">
      <div class="weui-msg__icon-area"><img width="200px" height="200px" src="${pageContext.request.contextPath}/static/jx/img/hklogo.png"></div>
      <div class="weui-msg__text-area">
        <h2 class="weui-msg__title">APP下载</h2>
        <p class="weui-msg__desc">红色筑梦中国火炬创业导师延安行</p>
      </div>
      <div class="weui-msg__opr-area">
        <p class="weui-btn-area">
          <a href="javascript:;" id='show-confirm' class="weui-btn weui-btn_primary">下载</a>
        </p>
      </div>
      <div class="weui-msg__extra-area">
        <div class="weui-footer">
          <p class="weui-footer__text">Copyright © 2019-2022</p>
        </div>
      </div>
    </div>
	
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
