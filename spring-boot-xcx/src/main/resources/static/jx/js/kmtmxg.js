layui.use([ 'form', 'layedit', 'laydate', 'table' ],
		function() {
			var form = layui.form,
			layer = layui.layer,
			layedit = layui.layedit,
			laydate = layui.laydate, 
			table = layui.table,
			 $ = layui.$
			$('#opengz').hide();
		     table.render({
				elem : '#right_table',
				url : pathName + '/tm/selectTMall', // 数据接口
				title : '用户数据表',
				toolbar: '#toolbarDemo',
				limits:[8,20,40,60,80,100],
				cols : [ [  {type:'radio'},{
					field : 'uuid',
					title : '编码',
					align : 'center',
					width : 80
				}, {
					field : 'questionTitle',
					title : '题目',
					align : 'center',
					width : 340
				}, {
					field : 'questionItems',
					title : '选项',
					width : 80
				}, {
					field : 'questionAnswer',
					title : '答案',
					width : 80
				}, {
					field : 'questionSkills',
					title : '技巧',
					width : 100
				}, {
					field : 'answerAnalysis',
					title : '分析',
					width : 100
				}, {
					field : 'questionImg',
					title : '图片',
					width : 100
				}, {
					field : 'tmxzlx',
					title : '题目类型',
					width : 100
				} ] ],
		     page : true, // 开启分页,
			limit : 8,
			id:'testReload1',
			});
		active = {
			        reload: function(){
			            var demoReload = $('#demoReload');
			            var kmlx = $('#kmlx');
			            table.reload('testReload1', {
			                where: {
			                	str1: kmlx.val(),
			                	 str2: demoReload.val()
			                }
			            });
			        }
			    };

		  $('.demoTable .layui-btn').on('click', function(){
			    var type = $(this).data('type');
			    active[type] ? active[type].call(this) : '';
			  });
		  table.on('toolbar(right_table)', function(obj){
			    var checkStatus = table.checkStatus(obj.config.id); //获取选中行状态
			    switch(obj.event){
			      case 'getCheckData':
			        var data = checkStatus.data[0];  //获取选中行数据
			        opengz(data);
			      break;
			    };
			  });


		})
function opengz(data){
		layer.open({
			  type: 1,
			  title:'题目编号:'+data.uuid,
			  area: ['720px', '500px'],
			  btn: ['确定'],
			    yes: function(index, layero){
			    
			    layer.close(index);
			    },
			  content:$('#opengz')
			});
		
	}