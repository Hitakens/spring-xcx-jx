<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html
	class="pixel-ratio-2 retina ios ios-10 ios-10-3 ios-gt-9 ios-gt-8 ios-gt-7 ios-gt-6">
<head>
<title>科目一>答题</title>
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
	href="${pageContext.request.contextPath}/static/jx/css/jqlxdt.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/jx/css/bootstrap.css">
<script
	src="${pageContext.request.contextPath}/static/jx/js/jquery-1.9.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/static/jx/js/bootstrap.js"></script>
	<script
	src="${pageContext.request.contextPath}/static/jx/js/Questions.js"></script>
<style type="text/css">
.warp {
    width:100%;
	height: 90%;
	position: relative;
	overflow: auto;
	font-size: 13px;
	font-style: normal;
}
</style>
</head>
<body ontouchstart>
	<div class="warp">
		<div class="col-md-10">
			<div class="content">
				

				<div
					style="width: 100%; height: auto; display: inline-block;">
					<div style="width: 100%;">
						<div style="width: 100%; margin: 0px auto">
								<div class="middle-top"
									style="width: 100%; height: 30px;  background: #2D3339; position: relative;">
									<a href="">
									<div class='top_left'><img alt="" width="30px" height="29px" src="${pageContext.request.contextPath}/static/jx/img/db/cz.png">重做</div></a>
										<a id="submitQuestions" href="javascript:void(0)" ><div class='top_right'>提交<img alt="" width="30px" height="29px" src="${pageContext.request.contextPath}/static/jx/img/db/tj.png"></div></a>
								</div>
							
							<div
								style="width: 100%; height: auto; display: inline-block; border-bottom: 1px dashed #CCC; background: #FFF;">
								<div
									style="width: 100%; height: 90%; padding: 10px 20px 0px 20px;">
									<!--试题区域-->
									<ul class="list-unstyled question" id="" name="">
										<li class="question_title"></li>
									</ul>
									
								</div>
		                      <span class=markedred>标红的字</span>
							</div>
							<!-- 答题卡 -->
						</div>
					</div>
				</div>
			
				<!-- 底部 -->
				
			</div>
		</div>
		</div>
		 <div class="weui-tabbar weui-tabbar-zdy">
        <a id='previousQuestion' href="javascript:void(0)" class="weui-tabbar__item weui-bar__item--on">
          <div class="weui-tabbar__icon">
            <img src="${pageContext.request.contextPath}/static/jx/img/db/syt.png" alt="">
          </div>
          <p class="weui-tabbar__label">上一题</p>
        </a>
        <a id="unHeart" href="javascript:void(0)" class="weui-tabbar__item">
          <div class="weui-tabbar__icon">
           <img src="${pageContext.request.contextPath}/static/jx/img/db/sc.png" alt="">
          </div>
          <p class="weui-tabbar__label">收藏本题</p>
        </a>
        <a  id="heart" href="javascript:void(0)" class="weui-tabbar__item" style="color: #C40000; display: none;">
          <div class="weui-tabbar__icon">
           <img src="${pageContext.request.contextPath}/static/jx/img/db/bsc.png" alt="">
          </div>
          <p class="weui-tabbar__label">已收藏</p>
        </a>
        <a id='openCardcw' href="javascript:void(0)" class="weui-tabbar__item open-popup" data-target="#half">
          <div class="weui-tabbar__icon">
            <img src="${pageContext.request.contextPath}/static/jx/img/db/ct.png" alt="">
          </div>
          <p class="weui-tabbar__label">错题率<span class='questionctl'></span></p>
        </a>
       
        <a id='openCard' href="javascript:void(0)" class="weui-tabbar__item open-popup" data-target="#half">
           <div class="weui-tabbar__icon">
            <img src="${pageContext.request.contextPath}/static/jx/img/db/sl.png" alt="">
          </div>
          <p class="weui-tabbar__label"><span class="questioned"></span>题/共<span
												class="question_sum"></span>题</p>
        </a>
        <a id='nextQuestion' href="javascript:void(0)" class="weui-tabbar__item">
          <div class="weui-tabbar__icon">
            <img src="${pageContext.request.contextPath}/static/jx/img/db/xyt.png" alt="">
          </div>
          <p class="weui-tabbar__label">下一题</p>
        </a>
      </div>
	<div id="half" class='weui-popup__container popup-bottom'>
      <div class="weui-popup__overlay"></div>
      <div class="weui-popup__modal">
        <div class="toolbar">
          <div class="toolbar-inner">
            <a href="javascript:;" class="picker-button close-popup">关闭</a>
           
          </div>
        </div>
        <div class="modal-content">
        <!-- 展示答题卡 -->
             <div id="answerCard" style="display: none;">
											<div class="panel-body form-horizontal" style="padding: 0px;">
												<ul class="list-unstyled">
												</ul>
											</div>
										</div>
	   <!-- 展示错误的答题卡 -->
             <div id="answerCardcw1" style="display: none;">
											<div class="panel-body form-horizontal" style="padding: 0px;">
												<ul class="list-unstyled list-unstyled-zdy">
												</ul>
											</div>
										</div>
          </div>
        </div>
      </div>
<script
		src="${pageContext.request.contextPath}/static/all/weui/js/jquery-weui.js"></script>

    

</body>
</html>
