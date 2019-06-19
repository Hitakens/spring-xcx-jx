<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html class="pixel-ratio-2 retina ios ios-10 ios-10-3 ios-gt-9 ios-gt-8 ios-gt-7 ios-gt-6"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教练登陆</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/all/weui/weui.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/all/weui/jquery-weui.css">

<link rel="stylesheet" type="${pageContext.request.contextPath}/static/all/weui/global.css">
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
        <p class="jkname">快乐驾陪</p>
    </div>
    <form>
        <div class="weui-cells weui-cells_form" style="padding: 5px 0 4px!important;display: none;">
            <div class="weui-cell weui-cell_switch">
                <div class="weui-cell__bd">
                    <img class="wx" src="${pageContext.request.contextPath}/static/jx/img/wx.svg"> 微信授权登录
                </div>
                <div class="weui-cell__ft">
                    <input class="weui-switch" type="checkbox" id="btnTrun">
                </div>
            </div>
        </div>
        <div class="weui-cells weui-cells_form" id="loginiptView">
            <div class="weui-cell">
                <div class="weui-cell__hd">
                    <label class="weui-label" style="width:60px">
                        <img src="${pageContext.request.contextPath}/static/jx/img/user.svg">
                    </label>
                </div>
                <div class="weui-cell__bd">
                    <input class="weui-input" type="number" value="" id="username" pattern="[0-11]*" name="username" placeholder="请输入手机号码">
                </div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__hd">
                    <label class="weui-label" style="width:60px">
                        <img src="${pageContext.request.contextPath}/static/jx/img/pass.svg">
                    </label>
                </div>
                <div class="weui-cell__bd">
                    <input class="weui-input" type="password" value="" id="password" name="password" placeholder="请输入登录密码">
                </div>
            </div>
            
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    		记住密码
                </div>
                <div class="weui-cell__ft">
                    <input class="weui-switch" type="checkbox" id="remember" checked="checked">
                </div>
            </div>
        </div>
        <a href="javascript:;" class="login weui-btn weui-btn_dt" style="margin-top: 20px;" id="submitLogin">登 录</a>
        <div class="" style="padding-top: 30px;text-align: center;">
        	<p class="weui-footer__text">微信登录</p>
        	<img class="wx" src="${pageContext.request.contextPath}/static/jx/img/wx.svg" onclick="submitLoginWX()">
    	</div>
    </form>
    <div class="weui-footer">
        <p class="weui-footer__text">Copyright © 2019 快乐驾陪</p>
    </div>
</div>


<script type="text/javascript" src="${pageContext.request.contextPath}/static/all/weui/jquery-2.1.4.js.下载"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/all/weui/jquery-weui.min.js.下载"></script>
<script type="text/javascript">
// 消除iOS系统下默认的click事件的300毫秒延迟
$(function() {FastClick.attach(document.body);});

function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}
 
// 调用方法
if(GetQueryString("q")=='1'){
	$.toptip('请先使用帐号登录绑定微信后使用!', 'error');
}

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
<script type="text/javascript">
    $(function() {
        // 监听微信登录开关
        $('#btnTrun').on('change', function(e) {
            var ischecked = $(this).prop('checked');
            if (ischecked) {
                // 开-微信登录
                // 设置按钮使用方法
                $('#submitLogin').data('cmd', 1);
                // 隐藏账号输入表单
                $('#loginiptView').slideUp();
            } else {
                // 关-普通登录
                // 设置按钮使用方法
                $('#submitLogin').data('cmd', 2);
                // 显示账号输入表单
                $('#loginiptView').slideDown();
            }
        });
        
        // 绑定登录按钮
        $('#submitLogin').on('click', submitLogin);
    });
    
    // 登录
    function submitLogin() {
        var cmd = $(this).data('cmd');
        if (cmd == 1) {
            // 微信登录
            submitLoginWX();
        } else {
            // 普通登录
            submitLoginPT();
        }
    }
    
    // 微信登录
    function submitLoginWX() {
        //$.showLoading();
       // ajax().post(api.agent.wxLogin, loginCallback);
    	window.location.href = '/wx.jsp?state=agent-'+Math.random();
    }
    
    // 普通登录
    function submitLoginPT() {
        var data_opt = {};
        $('#loginiptView').find('input').each(function(index) {
            var name = this.name;
            if(name == 'password'){
            
            	data_opt[name] = this.value;
            }
        });
        
        if (data_opt.username == '') {
            $.toptip('请输入账号', 'error');
            return ;
        } else if (data_opt.password == '') {
            $.toptip('请输入密码', 'error');
            return ;
        }
        
        $.showLoading();
        ajax().post('/pub/api?op=agentlogin', data_opt, loginCallback);
    }
    
    // 代理登录回调
    function loginCallback(res) {
        $.hideLoading();
        if (res.status == 201) {
        	loginSuccSaveInfo();
            window.location.href = '/agent/system.jsp';
        } else {
        	//$.toast(res.error, "cancel");
            //$.toptip(JSON.stringify(res), 'error');
        	$.toptip(res.data.error, 'error');
        }
    }
</script>

</body>
<!-- END BODY -->
</html>