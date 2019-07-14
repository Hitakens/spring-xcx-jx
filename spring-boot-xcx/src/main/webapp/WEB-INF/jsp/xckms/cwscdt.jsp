<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html
	class="pixel-ratio-2 retina ios ios-10 ios-10-3 ios-gt-9 ios-gt-8 ios-gt-7 ios-gt-6">
<head>
<title>科目四>${cwsc}</title>
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
	src="${pageContext.request.contextPath}/static/jx/js/Questions-xckms.js"></script>
<script type="text/javascript">
	var pathName = '${pageContext.request.contextPath}';
	var lx = '${lx}';//页面参数 //只有在展示收藏和错误的时候才能赋值
	var questions = [];
	var mm = 44;// 分
	var ss = 60;// 秒
	var pa = '${palx}';//(收藏类型,本题错误)A为小车科目一，A1为 小车科目四，依次类推
	var questionData = '${cwscdata}';//错误或者收藏的题目数
	$(function() {
		questions = JSON.parse(questionData);
		showQuestion(0);
		answerCard();
		showctlv();
		/* 收藏按钮的切换 */
		$("#unHeart").click(function() {
			$(this).hide();
			scthisquestion()
			$("#heart").show();
		})
		$("#heart").click(function() {
			$(this).hide();
			scthisquestion()
			$("#unHeart").show();
		})
	})
</script>
<style type="text/css">
.warp {
	width: 100%;
	height: 90%;
	position: relative;
	overflow: auto;
	font-size: 15px;
	font-style: normal;
}
</style>
</head>
<body ontouchstart>
	<div class="warp">
		<div class="col-md-10">
			<div class="content">
				<div style="width: 100%; height: auto; display: inline-block;">
					<div style="width: 100%;">
						<div style="width: 100%; margin: 0px auto">
							<div class="middle-top">
								<a href="">
									<div class='top_left'>
										<img alt="" width="30px" height="29px"
											src="${pageContext.request.contextPath}/static/jx/img/db/cz.png">重做
									</div>
								</a>
								<div class='top_right'>
									<a onclick="deletebt()"> 删除<img alt="" width="30px"
										height="29px"
										src="${pageContext.request.contextPath}/static/jx/img/db/dele.png">
									</a>
								</div>
							</div>

							<div
								style="width: 100%; height: auto; display: inline-block; background: #FFF;">
								<div
									style="width: 100%; height: 90%; padding: 10px 20px 0px 20px;">
									<!--试题区域-->
									<ul class="list-unstyled question" id="" name="">
										<li class="question_title"></li>
									</ul>

								</div>
							</div>
							<!-- 技巧 -->
							<div id='jqhide' style="display: none;">
								<div class="button_sp_area button_sp_area-zdy">
									<ul style="list-style: none;">
										<li><a onclick="musicjqplay()"
											class=" weui-btn_default-zdy"> <img class='jq-left-img'
												src="${pageContext.request.contextPath}/static/jx/img/sy/yy1.png"></a>
											<span id='showjq'></span></li>
									</ul>

								</div>

								<div class="personal-mybuluo-head">
									<div class="personal-mybuluo-wording">试题详解</div>
									<div class="personal-border jmu-border-1px border-bottom"></div>
								</div>
								<span class='bzda-db'></span>
							</div>
							<!-- 技巧 -->
						</div>
					</div>
				</div>

				<!-- 底部 -->

			</div>
		</div>
	</div>
	<div class="weui-tabbar weui-tabbar-zdy">
		<a id='previousQuestion' href="javascript:void(0)"
			class="weui-tabbar__item weui-bar__item--on">
			<div class="weui-tabbar__icon">
				<img
					src="${pageContext.request.contextPath}/static/jx/img/db/syt.png"
					alt="">
			</div>
			<p class="weui-tabbar__label">上一题</p>
		</a> <a id='openCardcw' href="javascript:void(0)"
			class="weui-tabbar__item open-popup" data-target="#half">
			<div class="weui-tabbar__icon">
				<img
					src="${pageContext.request.contextPath}/static/jx/img/db/ct.png"
					alt="">
			</div>
			<p class="weui-tabbar__label">
				<span class='questionctl'></span>
			</p>
		</a> <a id='openCard' href="javascript:void(0)"
			class="weui-tabbar__item open-popup" data-target="#half">
			<div class="weui-tabbar__icon">
				<img
					src="${pageContext.request.contextPath}/static/jx/img/db/sl.png"
					alt="">
			</div>
			<p class="weui-tabbar__label">
				<span class="questioned"></span>/<span class="question_sum"></span>
			</p>
		</a> <a id='nextQuestion' href="javascript:void(0)"
			class="weui-tabbar__item">
			<div class="weui-tabbar__icon">
				<img
					src="${pageContext.request.contextPath}/static/jx/img/db/xyt.png"
					alt="">
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
