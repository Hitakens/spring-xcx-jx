<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="utf-8" />
<title>科目题目查询</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport" />
<meta content="FairTech" name="author" />
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/all/layui2.4.5/css/layui.css"
	media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/jx/css/kmtmxg.css"
	media="all">
<script
	src="${pageContext.request.contextPath}/static/all/layui2.4.5/layui.js"
	charset="utf-8"></script>
<script
	src="${pageContext.request.contextPath}/static/jx/js/kmtmxg.js"
	charset="utf-8"></script>
<script
	src="${pageContext.request.contextPath}/static/all/jquery-3.3.1.min.js"
	charset="utf-8"></script>
</head>
<script type="text/javascript">
var pathName = '${pageContext.request.contextPath}';
</script>
<script type="text/javascript">
layui.use([ 'form', 'layedit', 'laydate','table' ],
		function() {
			var form = layui.form,
			layer = layui.layer, 
			layedit = layui.layedit, 
			laydate = layui.laydate,
			table = layui.table,
			 $=layui.jquery;
			right_table(table,form);
})
	  function right_table(table,form){
			table.render({
				id:'zbgs_zh,zbms_zh,mxdm',
				height:400,
			    elem: '#right_table'  
			    ,url: pathName+'/tm/selectTMall' //数据接口
			    ,size: 'sm'
			    ,title: '用户数据表'
			    ,page: true //开启分页
			    ,cols: [[
					{type: 'numbers'}
				   ,{type: 'checkbox'}
			      ,{field:'mxywbm', title:'编码',align:'center',width:80}
			      ,{field:'zbmc', title:'指标名称',align:'center',width:320}
			      ,{field:'fxbdff', title:'风险判断方法',width:130}
			      ,{field:'pdgz', title:'判断规则', width:100,sort: true}
			      ,{field:'pdydz', title:'判断对应值', width:100}
			      ,{field:'jsgz', title:'计算规则', width:100}
			      ,{field:'zbgs_zh', width:0}
			      ,{field:'mxdm', width:0}
			      ,{field:'zbms_zh',  width:0}
			      ,{field:'jzgz', title:'极值规则', width:80, sort: true}
			      ,{field:'qz', title:'权重', width:100, sort: true}
			      ,{fixed: 'right', align:'center', title:'操作', toolbar: '#barDemo', width:130}
			    ]],done:function(res,curr,count){
			    	// 隐藏列 
			    	$(".layui-table-box").find("[data-field='zbgs_zh']").css("display","none");
			    	$(".layui-table-box").find("[data-field='zbms_zh']").css("display","none");
			    	$(".layui-table-box").find("[data-field='mxdm']").css("display","none");
			    }
			  });
			  table.on('edit(right_table)', function(obj){
				    var value = obj.value //得到修改后的值
				    ,data = obj.data //得到所在行所有键值
				    ,field = obj.field; //得到字段
				    layer.msg('[ID: '+ data.id +'] ' + field + ' 字段更改为：'+ value);
				  });
	}
</script>
<body>
<div class="warp">
<table id="right_table"  class="layui-table" lay-filter="test_right_table"></table>
	</div>
	<!-- 底部结束 -->
</body>
<!-- END BODY -->
</html>