<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html
	class="pixel-ratio-2 retina ios ios-10 ios-10-3 ios-gt-9 ios-gt-8 ios-gt-7 ios-gt-6">
<head>
<title>卡密激活</title>
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
var pathName = '${pageContext.request.contextPath}';
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
    <img class="head" src="${imgurl}">
    <p class="nickname"></p>
</div>

<form>
	
    <div class="weui-cells weui-cells_form" id="bindcard-view">
        <div class="weui-cell">
            <div class="weui-cell__hd">
                <label class="weui-label" style="width:60px">
                    <img src="${pageContext.request.contextPath}/static/jx/img/gly/card.svg">
                </label>
            </div>
            <div class="weui-cell__bd">
                <input class="weui-input" type="text" name="str2" pattern="[11-32]*" placeholder="请输入卡密" >
                <input type="hidden" name="str1" value="${stuid}"/>
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
    
    if (data_opt.str2 == '') {
        $.toptip('请输入卡密', 'error');
        return ;
    } 
    
    $.showLoading();
    $.get(pathName+'/main/insertyh', data_opt, function (res) {
        $.hideLoading();
        if (res == "200") {
            $.toast("操作成功", 960);
            setTimeout(function() {
                window.location.href = pathName+'/main/joinpage?sid='+$(" input[ name='str1' ] ").val();
            }, 800);
        }else if (res == "201") {
            $.toast("卡密无效", "cancel");
        } else {
            $.toptip("网络错误", 'error');
        }
    });
}
    
</script>
</html>
