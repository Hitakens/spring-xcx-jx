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
	height: 100%;
	min-height: 100%;
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
							<div
								style="width: 100%; height: 51px; border-bottom: none; background: #FFF;">
								<div class="middle-top"
									style="width: 100%; height: 51px;  background: #2D3339; position: relative;">
									<div class="middle-top-left pull-left"
										style="height: 100%; background: #232C31; color: #FFF;width: 60%;">
										<div class="pull-left"
											style="width: 135px; line-height: 20px; height: 20px; margin: 15px; font-size: 15px;">
											<!--已做答的数量和考题总数-->
											当前第<span class="questioned"></span>题/共<span
												class="question_sum"></span>题
										</div>
									</div>
									<div class="middle-top-right text-center pull-left"
										style="width: 40%; height: 100%; border-left: 1px solid red; position: absolute; right: 0px; ">
										<div class="stop pull-left"
											style="width: 50px; height: 100%; padding: 10px;">
											<a href="javascript:void(0);" class="text-center"
												style="color: #FE6547;">
												<div class="time-stop glyphicon glyphicon-pause" title="暂停"
													style="width: 30px; height: 30px; line-height: 30px; border-radius: 15px; border: 1px solid #FE6547;"></div>
												<div class="time-start glyphicon glyphicon-play" title="开始"
													style="width: 30px; height: 30px; line-height: 30px; border-radius: 15px; border: 1px solid #FE6547; display: none;"></div>
											</a>
										</div>
										<div class="pull-left"
											style="width: 50px; height: 100%; padding: 10px 0px 10px 0px;">
											<div class="time"
												style="width: 50px; height: 30px; line-height: 30px; border-radius: 15px; font-size: 15px; color: #FFF;">
											</div>
										</div>
									</div>
								</div>
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
        <a href="#tab1" class="weui-tabbar__item weui-bar__item--on">
          <div class="weui-tabbar__icon">
            <img src="${pageContext.request.contextPath}/static/jx/img/db/ct.png" alt="">
          </div>
          <p class="weui-tabbar__label">错题(0)</p>
        </a>
        <a href="#tab1" class="weui-tabbar__item weui-bar__item--on">
          <div class="weui-tabbar__icon">
            <img src="${pageContext.request.contextPath}/static/jx/img/db/dt.png" alt="">
          </div>
          <p class="weui-tabbar__label">对题</p>
        </a>
        <a href="#tab3" class="weui-tabbar__item">
           <div class="weui-tabbar__icon">
            <img src="${pageContext.request.contextPath}/static/jx/img/db/sl.png" alt="">
          </div>
          <p class="weui-tabbar__label">5/100</p>
        </a>
        <a id='nextQuestion' href="javascript:void(0)" class="weui-tabbar__item">
          <div class="weui-tabbar__icon">
            <img src="${pageContext.request.contextPath}/static/jx/img/db/xyt.png" alt="">
          </div>
          <p class="weui-tabbar__label">下一题</p>
        </a>
        <a id="submitQuestions" href="javascript:void(0)" class="weui-tabbar__item" style="color: #C40000; display: none;">
          <div class="weui-tabbar__icon">
            <img src="${pageContext.request.contextPath}/static/jx/img/db/xyt.png" alt="">
          </div>
          <p class="weui-tabbar__label">提交</p>
        </a>
      </div>
	

</body>
</html>
