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
				id:'uuid',
				height:800,
			    elem: '#right_table'  
			    ,url: pathName+'/tm/selectTMall' //数据接口
			    ,size: 'sm'
			    ,title: '用户数据表'
			    ,page: true //开启分页
			    ,limit:100
			    ,defaultToolbar: ['filter', 'print', 'exports']
			    ,cols: [[
					{type: 'numbers'}
				   ,{type: 'checkbox'}
			      ,{field:'uuid', title:'编码',align:'center',width:80}
			      ,{field:'questionTitle', title:'指标名称',align:'center',width:320}
			      ,{field:'questionItems', title:'风险判断方法',width:130}
			      ,{field:'questionAnswer', title:'判断规则', width:100,sort: true}
			      ,{field:'questionSkills', title:'判断对应值', width:100}
			      ,{field:'answerAnalysis', title:'计算规则', width:100}
			      ,{field:'questionImg', width:0}
			      ,{field:'tmxzlx', width:0}
			      ,{field:'zbms_zh',  width:0}
			      ,{fixed: 'right', align:'center', title:'操作', toolbar: '#barDemo', width:130}
			    ]]
			  
	})
}