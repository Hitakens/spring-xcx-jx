layui.use([ 'element', 'carousel' ], function() {
		var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
		var carousel = layui.carousel
		carousel.render({
			elem : '#test1',
			width : '100%',
			height : '440px',
			interval : 3000
		});
		$('#cplyyc').show();
		$('#gywmyc').show();
		$('#syalyc').show();
		go();
		go1();
		go2();
	});
function chagetab(e) {
	$('#layui-tab-item1').removeClass('layui-show');
	$('#layui-tab-item2').removeClass('layui-show');
	$('#layui-tab-item3').removeClass('layui-show');
	$('#layui-tab-item4').removeClass('layui-show');
	$('#layui-tab-item5').removeClass('layui-show');
	$('#layui-tab-item6').removeClass('layui-show');
	$('#layui-tab-item7').removeClass('layui-show');
	$('#layui-tab-item8').removeClass('layui-show');
	$('#layui-tab-item9').removeClass('layui-show');
	$('#layui-tab-item10').removeClass('layui-show');
	$('#layui-tab-item11').removeClass('layui-show');
	$('#layui-tab-item12').removeClass('layui-show');
	$('#layui-tab-item13').removeClass('layui-show');
	$('#layui-tab-item14').removeClass('layui-show');
	$('#layui-tab-item'+e).addClass('layui-show');
}
var s=1;
function showcpyl() {
	
	if(s % 2==0){
		$('#cplyyc').show();
		s++;
	}else{
		$('#cplyyc').hide();
		s++;
	}


}
var a=1;
function showgywm() {
	
	if(a % 2==0){
		$('#gywmyc').show();
		a++;
	}else{
		$('#gywmyc').hide();
		a++;
	}	
}

var b=1;
function syalycshow() {
	
	if(b % 2==0){
		$('#syalyc').show();
		b++;
	}else{
		$('#syalyc').hide();
		b++;
	}	
}

function go(){
	var t,tt;
    var _div=document.getElementById("show");
    var obj=_div.getElementsByTagName('h2')[0];
    obj.style.bottom="-100px";
    var change=function(){
    	 var obj_h=parseInt(obj.style.bottom);
         if(obj_h<0){obj.style.bottom=(obj_h+Math.floor((0-obj_h)*0.1))+"px"}//if
         else{clearInterval(t)}
    }
    var back=function(){
        var obj_hh=parseInt(obj.style.bottom);
        if(obj_hh>-100){
        	obj.style.bottom=(obj_hh+Math.floor((-100-obj_hh)*0.1))+"px"
        	}else{
        	clearInterval(tt)
        	}
        }
_div.onmouseover=function(){
	clearInterval(tt);t=setInterval(change,10);
	}
_div.onmouseout=function(){
	clearInterval(t);tt=setInterval(back,10)
	} 

}
function go1(){
	var t,tt;
    var _div=document.getElementById("show1");
    var obj=_div.getElementsByTagName('h2')[0];
    obj.style.bottom="-100px";
    var change=function(){
    	 var obj_h=parseInt(obj.style.bottom);
         if(obj_h<0){obj.style.bottom=(obj_h+Math.floor((0-obj_h)*0.1))+"px"}//if
         else{clearInterval(t)}
    }
    var back=function(){
        var obj_hh=parseInt(obj.style.bottom);
        if(obj_hh>-100){
        	obj.style.bottom=(obj_hh+Math.floor((-100-obj_hh)*0.1))+"px"
        	}else{
        	clearInterval(tt)
        	}
        }
_div.onmouseover=function(){
	clearInterval(tt);t=setInterval(change,10);
	}
_div.onmouseout=function(){
	clearInterval(t);tt=setInterval(back,10)
	} 

}
function go2(){
	var t,tt;
    var _div=document.getElementById("show2");
    var obj=_div.getElementsByTagName('h2')[0];
    obj.style.bottom="-100px";
    var change=function(){
    	 var obj_h=parseInt(obj.style.bottom);
         if(obj_h<0){obj.style.bottom=(obj_h+Math.floor((0-obj_h)*0.1))+"px"}//if
         else{clearInterval(t)}
    }
    var back=function(){
        var obj_hh=parseInt(obj.style.bottom);
        if(obj_hh>-100){
        	obj.style.bottom=(obj_hh+Math.floor((-100-obj_hh)*0.1))+"px"
        	}else{
        	clearInterval(tt)
        	}
        }
_div.onmouseover=function(){
	clearInterval(tt);t=setInterval(change,10);
	}
_div.onmouseout=function(){
	clearInterval(t);tt=setInterval(back,10)
	} 

}
