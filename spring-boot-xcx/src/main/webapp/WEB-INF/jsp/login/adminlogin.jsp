<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html class="pixel-ratio-2 retina ios ios-10 ios-10-3 ios-gt-9 ios-gt-8 ios-gt-7 ios-gt-6"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登陆</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/all/weui/css/weui.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/all/weui/css/jquery-weui.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/all/weui/css/demos.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/all/css/global.css"
	type="text/css">
	<script type="text/javascript">
	var pathName = '${pageContext.request.contextPath}';
</script>
<style type="text/css">
body {
	background-color: #EFF4FD;
}
.warp {
    height: auto;
    min-height: 100%;
    position: relative;
    overflow: auto;
}

.top {
    width: 100%;
    border-radius: 0 0 25px 25px;
    padding: 30px 0 25px;
    text-align: center;
}
.top .jkname {
    font-size: 16px;
}

form { margin: 30px 16px; }
.weui-label img {
    width: 32px;height: 32px;vertical-align: middle;
}
.weui-btn_dt { background-color: #62B900; }
.weui-btn_dt:active { background-color: #007aff; }

.login-btns {}
.login-btns a {}
.login-btns a.wxOauth { float: left;width: 40%; }
.login-btns a.login { float: right;width: 55%;margin-left: 5%; }


img.logo { width: 76px;height: 76px;vertical-align: middle; }
img.wx { width: 64px;height: 64px;vertical-align: middle; }

.clearfix {zoom: 1}
.clearfix::after {
    content: "\0020";
    display: block;
    height: 0;
    clear: both;
}

.weui-footer {
    position: absolute;
    width: 100%;
    bottom: 10px;
}
</style>

</head>
<body ontouchstart="">


<div class="warp">
	<div class="top">
        <img class="logo" src="${pageContext.request.contextPath}/static/jx/img/logo.png">
        <p class="jkname">通关驾考</p>
    </div>
    <form>
   
        <div class="weui-cells weui-cells_form" id="loginiptView">
            <div class="weui-cell">
                <div class="weui-cell__hd">
                    <label class="weui-label" style="width:60px">
                        <img src="${pageContext.request.contextPath}/static/jx/img/gly/user.svg">
                    </label>
                </div>
                <div class="weui-cell__bd">
                    <input class="weui-input" type="number" value="" id="username" pattern="[0-11]*" name="str1" placeholder="请输入手机号码">
                </div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__hd">
                    <label class="weui-label" style="width:60px">
                        <img src="${pageContext.request.contextPath}/static/jx/img/gly/pass.svg">
                    </label>
                </div>
                <div class="weui-cell__bd">
                    <input class="weui-input" type="password" value="" id="password" name="str2" placeholder="请输入登录密码">
                </div>
            </div>
            
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    		记住密码
                </div>
                <div class="weui-cell__ft">
                    <input class="weui-switch" type="checkbox" id="remember" name='xz'>
                </div>
            </div>
        </div>
        <a href="javascript:;" onclick="submitLogin();" class="login weui-btn weui-btn_dt" style="margin-top: 20px;">登 录</a>
        
    </form>
    <div class="weui-footer">
        <p class="weui-footer__text">Copyright © 2019 通关驾考</p>
    </div>
</div>


<script type="text/javascript" src="${pageContext.request.contextPath}/static/all/weui/js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/all/weui/js/jquery-weui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/all/weui/js/fastclick.js"></script>

<script type="text/javascript">
// 消除iOS系统下默认的click事件的300毫秒延迟
$(function() {FastClick.attach(document.body);});

$(document).ready(function(){
	 
    var strName = localStorage.getItem('agentloginname');
    var strPass = localStorage.getItem('agentloginpass');
    if(strName){
        $('#username').val(strName);
    }
	if(strPass){
        $('#password').val(strPass);
    }

});
function loginSuccSaveInfo(){
    var strName = $('#username').val();
    var strPass = $('#password').val();
    localStorage.setItem('agentloginname',strName);
    localStorage.setItem('agentloginpass',strPass);
    if($('#remember').is(':checked')){
        localStorage.setItem('agentloginpass',strPass);
    }else{
        localStorage.removeItem('agentloginpass');
    }
}
</script>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/all/jquery-3.3.1.js"></script>
<script src="${pageContext.request.contextPath}/static/all/weui/js/jquery-weui.js"></script>
<script type="text/javascript">    
    // 登录
    function submitLogin() {
        var data_opt = {};
        $('#loginiptView').find('input').each(function(index) {
            var name = this.name;
            if(name=='str1' || name=='str2'){
            	data_opt[name] = this.value;
            }
           
            
        });
        
        if (data_opt.str1 == '') {
            $.toptip('请输入账号', 'error');
            return ;
        } else if (data_opt.str2 == '') {
            $.toptip('请输入密码', 'error');
            return ;
        }
        
        $.showLoading();
        $.post(pathName+'/main/admin.html', data_opt, loginCallback);
    }
    
    // 代理登录回调
    function loginCallback(res) {
        $.hideLoading();
        if (res == "200") {
        	loginSuccSaveInfo();
            window.location.href =pathName+'/main/admin/kmsc?uname='+$('#username').val();
        } else if(res=="201"){
        	$.toast("你没有权限！请联系管理员","cancel")
        }else {
        	$.toptip('网络错误,请稍后再试', 'error');
        }
    }
</script>

</body>
<!-- END BODY -->
</html>