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
<script type="text/javascript">
	var pathName = '${pageContext.request.contextPath}';
</script>
<script>
	var re = [];
	function tztab(p) {
		$.showLoading();
		if (p == '1') {
			btztab('xc')
            if(re.length<1){
            	$.hideLoading();
            	return;
            }
			$('#xckmywdctk').html('(' + re[0] + ')');
			$('#xckmywdsc').html('(' + re[1] + ')')

			$('#xckmswdctk').html('(' + re[2] + ')');
			$('#xckmswdsc').html('(' + re[3] + ')')
		} else {
			$.toast("此功能尚未开发完成!", "cancel");
			return;
		}
		$.hideLoading();
	}

	function btztab(clx) {

		$.ajax({
			type : "get",
			url : pathName + "/xc/ctsc/" + clx, //后台文件的url 就是form的action,用ajax提交表单就不需要给form写action了
			dataType : "text",
			success : function(da1) {
				da1 = eval('(' + da1 + ')')
				re.push(da1.kmyct)
				re.push(da1.kmysc)
				re.push(da1.kmsct)
				re.push(da1.kmssc)
			},
			error : function(data) {
				$.toast("网络错误,请稍后再试!", "cancel");
			}
		});

	}
</script>
<style type="text/css">
.icon-img {
	width: 4.5em;
	height: 2.5em;
	overflow: hidden;
	margin-top: 5px;
}

.img-midel {
	position: relative;
	top: -8px;
}

.weui-tab__bd-item {
	background-color: white;
}
</style>
</head>
<body ontouchstart>
	<div class="warp">
		<div class="top">
			<img class="top_img" align="middle"
				src="${avatarurl}">
			<span>学员姓名:${wxname}(永久VIP会员)</span>
		</div>
		<div class="weui-tab">
			<div class="weui-navbar">
				<a
					class="weui-navbar__item weui-bar__item--on  weui-navbar__item-zdy"
					onclick="tztab(1);" href="#tab1"> <img class='icon-img'
					src="${pageContext.request.contextPath}/static/jx/img/c.png">
					<span class="img-midel">小车(C1/C2/C3)</span>
				</a> <a class="weui-navbar__item  weui-navbar__item-zdy"
					onclick="tztab(2);" href="#tab2"> <img class='icon-img'
					src="${pageContext.request.contextPath}/static/jx/img/hc.png">
					<span class="img-midel">货车(A2/B2)</span></a> <a
					class="weui-navbar__item  weui-navbar__item-zdy"
					onclick="tztab(3);" href="#tab3"><img class='icon-img'
					src="${pageContext.request.contextPath}/static/jx/img/kc.png">
					<span class="img-midel">货车(A1/B1/A3)</span></a>
			</div>
			<div class="weui-tab__bd">
				<div id="tab1" class="weui-tab__bd-item weui-tab__bd-item--active">
					<!-- 科目yi -->

					<h4 class="demos-title">科目一</h4>


					<div class="weui-grids">
						<a href="${pageContext.request.contextPath}/main/xckmy/bzt"
							class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/lx.png"
									alt="">
							</div>
							<p class="weui-grid__label">必做题</p>
						</a> <a href="${pageContext.request.contextPath}/main/xckmy/xzt"
							class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/lx1.png"
									alt="">
							</div>
							<p class="weui-grid__label">选做题</p>
						</a> <a href="${pageContext.request.contextPath}/xc/kmMnks/xckmy" class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/100.png"
									alt="">
							</div>
							<p class="weui-grid__label">模拟考试</p>
						</a> 
						<a href="${pageContext.request.contextPath}/xc/cwsc/cw/kmy" class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/ct.png"
									alt="">
							</div>
							<p class="weui-grid__label">
								错题库<span id="xckmywdctk">(${maps.kmyct})</span>
							</p>
						</a> <a href="${pageContext.request.contextPath}/xc/cwsc/sc/kmy" class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/wdsc.png"
									alt="">
							</div>
							<p class="weui-grid__label">
								我的收藏<span id="xckmywdsc">(${maps.kmysc})</span>
							</p>
						</a> <%-- <a href="" class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/hj.png"
									alt="">
							</div>
							<p class="weui-grid__label">快板技巧</p>
						</a>
 --%>


					</div>
					<!-- end科目yi -->
					<!-- 科目四开始 -->
					<h4 class="demos-title">科目四</h4>
					<div class="weui-grids">
						<a href="${pageContext.request.contextPath}/main/xckms/jqlx"
							class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/lx.png"
									alt="">
							</div>
							<p class="weui-grid__label">必做题</p>
						</a> <a href="${pageContext.request.contextPath}/main/xckms/fllx"
							class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/lx1.png"
									alt="">
							</div>
							<p class="weui-grid__label">选做题</p>
						</a> <a href="" class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/100.png"
									alt="">
							</div>
							<p class="weui-grid__label">模拟考试</p>
						</a> <a href="" class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/ct.png"
									alt="">
							</div>
							<p class='weui-grid__label'>
								错题库<span id='xckmswdctk'>(${maps.kmsct})</span>
							</p>
						</a> <a href="" class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/wdsc.png"
									alt="">
							</div>
							<p class="weui-grid__label">
								我的收藏<span id='xckmswdsc'>(${maps.kmssc})</span>
							</p>
						</a>



					</div>
					<!-- 科目四end -->
				</div>
				<div id="tab2" class="weui-tab__bd-item">
					<!-- 科目yi -->

					<h4 class="demos-title">科目一</h4>


					<div class="weui-grids">
						<a href="" class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/lx.png"
									alt="">
							</div>
							<p class="weui-grid__label">技巧练习</p>
						</a> <a href="" class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/lx1.png"
									alt="">
							</div>
							<p class="weui-grid__label">分类练习</p>
						</a> <a href="" class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/100.png"
									alt="">
							</div>
							<p class="weui-grid__label">模拟考试</p>
						</a> <a href="" class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/ct.png"
									alt="">
							</div>
							<p class="weui-grid__label">错题库</p>
						</a> <a href="" class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/wdsc.png"
									alt="">
							</div>
							<p class="weui-grid__label">我的收藏</p>
						</a> <a href="" class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/hj.png"
									alt="">
							</div>
							<p class="weui-grid__label">快板技巧</p>
						</a>



					</div>
					<!-- end科目yi -->
					<!-- 科目四开始 -->
					<h4 class="demos-title">科目四</h4>
					<div class="weui-grids">
						<a href="" class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/lx.png"
									alt="">
							</div>
							<p class="weui-grid__label">技巧练习</p>
						</a> <a href="" class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/lx1.png"
									alt="">
							</div>
							<p class="weui-grid__label">分类练习</p>
						</a> <a href="" class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/100.png"
									alt="">
							</div>
							<p class="weui-grid__label">模拟考试</p>
						</a> <a href="" class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/ct.png"
									alt="">
							</div>
							<p class="weui-grid__label">错题库</p>
						</a> <a href="" class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/wdsc.png"
									alt="">
							</div>
							<p class="weui-grid__label">我的收藏</p>
						</a>



					</div>
					<!-- 科目四end -->
				</div>
				<div id="tab3" class="weui-tab__bd-item">
					<!-- 科目yi -->

					<h4 class="demos-title">科目一</h4>


					<div class="weui-grids">
						<a href="" class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/lx.png"
									alt="">
							</div>
							<p class="weui-grid__label">技巧练习</p>
						</a> <a href="" class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/lx1.png"
									alt="">
							</div>
							<p class="weui-grid__label">分类练习</p>
						</a> <a href="" class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/100.png"
									alt="">
							</div>
							<p class="weui-grid__label">模拟考试</p>
						</a> <a href="" class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/ct.png"
									alt="">
							</div>
							<p class="weui-grid__label">错题库</p>
						</a> <a href="" class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/wdsc.png"
									alt="">
							</div>
							<p class="weui-grid__label">我的收藏</p>
						</a> <a href="" class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/hj.png"
									alt="">
							</div>
							<p class="weui-grid__label">快板技巧</p>
						</a>



					</div>
					<!-- end科目yi -->
					<!-- 科目四开始 -->
					<h4 class="demos-title">科目四</h4>
					<div class="weui-grids">
						<a href="" class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/lx.png"
									alt="">
							</div>
							<p class="weui-grid__label">技巧练习</p>
						</a> <a href="" class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/lx1.png"
									alt="">
							</div>
							<p class="weui-grid__label">分类练习</p>
						</a> <a href="" class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/100.png"
									alt="">
							</div>
							<p class="weui-grid__label">模拟考试</p>
						</a> <a href="" class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/ct.png"
									alt="">
							</div>
							<p class="weui-grid__label">错题库</p>
						</a> <a href="" class="weui-grid js_grid">
							<div class="weui-grid__icon">
								<img
									src="${pageContext.request.contextPath}/static/jx/img/wdsc.png"
									alt="">
							</div>
							<p class="weui-grid__label">我的收藏</p>
						</a>



					</div>
					<!-- 科目四end -->
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
