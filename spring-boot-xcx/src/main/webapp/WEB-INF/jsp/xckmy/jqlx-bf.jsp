<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html
	class="pixel-ratio-2 retina ios ios-10 ios-10-3 ios-gt-9 ios-gt-8 ios-gt-7 ios-gt-6">
<head>
<title>科目一>练习</title>
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
	href="${pageContext.request.contextPath}/static/all/css/global.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/jx/css/iconfont.css">

<style type="text/css">
.warp {
    height: 100%;
    min-height: 100%;
    position: relative;
    overflow: auto;
}
.first-weiui{
width: 100%;
height:12%;
background-color: white; 
font-size: 15px;
border-bottom: 2px solid silver;
}
.left-div{
width: 20%;

background-color: red;
}
.midel-div,.right-div{
width: 40%;
background-color: black;
}
.left-div,.midel-div,.right-div{
height:100%;
float: left;
}
</style>
</head>
<body ontouchstart>
	<div class="warp">
	 <div class='first-weiui'>
		 <div class='left-div'></div>
		 <div class='midel-div'></div>
		 <div class='right-div'></div>
      </div>  
	 </div>
	<!-- 练习一结束 --> 
	 
	<!-- 基础补充结束 -->  

	<script
		src="${pageContext.request.contextPath}/static/all/weui/js/jquery-2.1.4.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/all/weui/js/jquery-weui.js"></script>

</body>
</html>
