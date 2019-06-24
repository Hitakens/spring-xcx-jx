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
								style="width: 100%; height: 100px; border-bottom: none; background: #FFF;">
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
								<div
									style="width: 100%; height: 50px; font-size: 15px; color: #000; line-height: 50px; padding-left: 20px;">
									<div
										style="color: #FFF; background: red; width: 22px; height: 22px; border-radius: 11px; line-height: 22px; font-size: 13px; text-align: center;"
										class="glyphicon glyphicon-map-marker"></div>
									[单选题]
								</div>
							</div>
							<div
								style="width: 100%; height: auto; display: inline-block; border-bottom: 1px dashed #CCC; background: #FFF;">
								<div
									style="width: 100%; height: 90%; padding: 20px 20px 0px 20px;">
									<!--试题区域-->
									<ul class="list-unstyled question" id="" name="">
										<li class="question_title"></li>
									</ul>
									<!--考题的操作区域-->
									<div class="operation" style="margin-top: 20px;">
										<div class="text-left"
											style="margin-left: 20px; font-size: 15px; float: left; line-height: 30px;">
											<div id="unHeart" style="color: #999999;">
												<span class="glyphicon glyphicon-heart-empty"></span> <span>收藏本题</span>
											</div>
											<div id="heart" style="color: #C40000; display: none;">
												<span class="glyphicon glyphicon-heart"></span> <span>已收藏</span>
											</div>
										</div>
										<div class="text-right" style="margin-right: 20px;">
											<div class="form-group" style="color: #FFF;">
												<button class="btn btn-success" id="submitQuestions">提交试卷</button>
												<button class="btn btn-info" id="nextQuestion">下一题</button>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div
								style="width: 100%; height: auto; display: inline-block; border: 1px solid #CCC; border-top: none; background: #FFF;">
								<div style="width: 100%; padding: 20px;">
									<div class="panel-default">
										<div class="panel-heading" class="panel-heading"
											id="closeCard"
											style="color: #DCE4EC; font-size: 15px; display: none; background: none;">
											<span>收起答题卡</span> <span
												class="glyphicon glyphicon-chevron-up"></span>
										</div>
										<div class="panel-heading" id="openCard"
											style="font-size: 15px; background: none;">
											<span>展开答题卡</span> <span
												class="glyphicon glyphicon-chevron-down"></span>
										</div>
										<div id="answerCard" style="display: none;">
											<div class="panel-body form-horizontal" style="padding: 0px;">
												<ul class="list-unstyled">
												</ul>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div
					style="width: 100%; height: auto; display: inline-block; border: 1px solid white;">
					<div class="text-center" style="width: 100%;">底部</div>
				</div>
			</div>
		</div>
		<div class="col-md-1"></div>
	</div>


</body>
</html>
