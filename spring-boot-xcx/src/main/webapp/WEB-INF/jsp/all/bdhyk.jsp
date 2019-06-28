<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html
	class="pixel-ratio-2 retina ios ios-10 ios-10-3 ios-gt-9 ios-gt-8 ios-gt-7 ios-gt-6">
<head>
<title>${param.title}>提交成功</title>
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
<script
	src="${pageContext.request.contextPath}/static/jx/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript"> 
</script>
<style type="text/css">
body {
    height: auto;
    min-height: 100%;
    position: relative;
    overflow: auto;
    background-color: #EFF4FD;
}

.top {
    width: 100%;
    background-color: #62B900;
    padding: 30px 0 25px;
    text-align: center;
}
.top .head {
    width: 60px;
    height: 60px;
    border-radius: 30px;
}
.top .nickname {
    color: #fff;
    font-size: 14px;
}

form { margin: 30px 16px; }
.weui-label img {
    width: 32px;height: 32px;vertical-align: middle;
}
.weui-btn_dt { background-color: #09B9E0; }
.weui-btn_dt:active { background-color: #299CB5; }

.weui-footer {
    position: relative;
     bottom: -320px;
    width: 100%;
   
}

input {     
     -webkit-user-select:auto;
}
</style>

</head>
<body ontouchstart="">


<div class="top">
    <img class="head" src="https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJe2v5tzdicP1qDprlbJ3aMdoG47aEE86n7ib8tMlsJVQq0CibZnSeNACIVJdsvgGDXLPHqNBiaslTRLg/132">
    <p class="">id:273716</p>
    <p class="nickname"></p>
</div>

<form>
	
    <div class="weui-cells weui-cells_form" id="bindcard-view">
    	<input id="stuid" type="hidden" name="stuid" value="273716">
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label" style="width:60px">
                    <img src="${pageContext.request.contextPath}/static/jx/img/gly/card.svg">
                </label>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text" name="number" pattern="[0-14]*" placeholder="请输入卡密" onkeyup="this.value=this.value.replace(/[^0-9]/g,&#39;&#39;)" onafterpaste="this.value=this.value.replace(/[^0-9]/g,&#39;&#39;)">
            </div>
        </div>
        <div class="weui-cell" style="display: none;">
            <div class="weui-cell__hd">
                <label class="weui-label" style="width:60px">
                    <img src="${pageContext.request.contextPath}/static/jx/img/gly/pass.svg">
                </label>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="number" name="password" pattern="[0-6]*" placeholder="请输入卡密">
            </div>
        </div>
    </div>
    <a href="javascript:;" class="weui-btn weui-btn_dt" style="margin-top: 20px;background-color: #62B900;" id="btnBindCard">立即绑定</a>
</form>

<div class="weui-footer">
  <p class="weui-footer__text">Copyright © 2019 </p>
</div>
	<script
		src="${pageContext.request.contextPath}/static/all/weui/js/jquery-weui.js"></script>

</body>
<script type="text/javascript">
$(function() {
    // 绑定会员卡
    $('#btnBindCard').on('click', submitBindCard);
});

// 绑定会员卡
function submitBindCard() {
    var data_opt = {};
    $('#bindcard-view').find('input').each(function(index) {
        var name = this.name;
        data_opt[name] = this.value;
    });
    
    if (data_opt.number == '') {
        $.toptip('请输入卡密', 'error');
        return ;
    } 
    
    $.showLoading();
    ajax().post('/pub/api?op=card.active', data_opt, function (res) {
        $.hideLoading();
        if (res.status == 201) {
            $.toast("操作成功", 960);
            setTimeout(function() {
                window.location.href = '/student/main.html?stuid='+GetQueryString("stuid");
            }, 800);
        }else if (res.status == 202) {
            $.toast("操作成功", 960);
            setTimeout(function() {
                window.location.href = '/student/test-main.jsp';
            }, 800);
        } else {
            $.toptip(res.data.error, 'error');
        }
    });
}
    
</script>
</html>
