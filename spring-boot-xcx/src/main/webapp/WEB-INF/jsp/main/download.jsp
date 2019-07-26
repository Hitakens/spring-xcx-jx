<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html
	class="pixel-ratio-2 retina ios ios-10 ios-10-3 ios-gt-9 ios-gt-8 ios-gt-7 ios-gt-6">
<head>
<title>下载</title>
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
<script
	src="${pageContext.request.contextPath}/static/all/weui/js/jquery-2.1.4.js"></script>
<script>
//引入jQuery版本
function is_weixin() {
  var ua = navigator.userAgent.toLowerCase();
  if (ua.match(/MicroMessenger/i) == "micromessenger") {
      return true;
  } else {
      return false;
  }
}// 这个实现是否是在微信打开的，如果是返回true，如果不是，返回false
$(function(){
  var isWeixin = is_weixin();//调用is_weixin函数；获取到值
  var winHeight = typeof window.innerHeight != 'undefined' ?
  window.innerHeight : document.documentElement.clientHeight;
  var weixinTip = $('<div id="weixinTip"><div class="test"><img src="../../static/jx/img/ydxz.png"/></div></div>');
  if(isWeixin){
      $("body").append(weixinTip);
  }
  $("#weixinTip").css({
      "position":"fixed",
      "left":"0",
      "top":"0",
      "height":"100%",
      "width":"100%",
      "z-index":"1000",
      "background-color":"rgba(0,0,0,0.8)",
      "filter":"alpha(opacity=80)",
      "float":"left"
  });
 
  $("#weixinTip div").css({
      "display":"flex",
      "justify-content": "space-around",
      "align-items":"center",
      "padding-left":"4%",
      "padding-right":"4%" 

  })
  $("#weixinTip div img").css({
     
      "width":"100%",
      "height":"100%",
      "background-size":"100%"
     /*  "margin-top":"7%",
      "padding-left":"4%",
      "padding-right":"4%" */
  })
})

</script>
</head>
<style>
 

</style>
<body ontouchstart>
	 <div class="weui-msg">
      <div class="weui-msg__icon-area"><img width="200px" height="200px" src="${pageContext.request.contextPath}/static/jx/img/hklogo.png"></div>
      <div class="weui-msg__text-area">
        <h2 class="weui-msg__title">APP下载</h2>
        <p class="weui-msg__desc">红色筑梦中国火炬创业导师延安行</p>
      </div>
      <div class="weui-msg__opr-area">
        <p class="weui-btn-area">
          <a href="${pageContext.request.contextPath}/xz/downbrowser?fwqlj=/develop/file/红色筑梦延安行.apk"  class="weui-btn weui-btn_primary">下载</a>
        </p>
      </div>
      <div class="weui-msg__extra-area">
        <div class="weui-footer">
          <p class="weui-footer__text">Copyright © 2019-2022</p>
        </div>
      </div>
    </div>

</body>
</html>
