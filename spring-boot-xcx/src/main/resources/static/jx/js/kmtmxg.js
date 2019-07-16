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
				}, {
					field : 'questionTitle',
					title : '题目',
					align : 'center',
				}, {
					field : 'questionItems',
					title : '选项',
					align : 'center',
				}, {
					field : 'questionAnswer',
					title : '答案',
					align : 'center',
				}, {
					field : 'questionSkills',
					title : '技巧',
					align : 'center',
				}, {
					field : 'answerAnalysis',
					title : '分析',
				}, {
					field : 'questionImg',
					title : '图片',
					align : 'center',
				}, {
					field : 'tmxzlx',
					title : '题目类型',
					align : 'center',
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
			    var checkStatus = table.checkStatus(obj.config.id); // 获取选中行状态
			    switch(obj.event){
			      case 'getCheckData':
			        var data = checkStatus.data[0];  // 获取选中行数据
			        opengz(data);
			      break;
			    };
			  });


		})
function opengz(data){
	$('#questionTitle').val(data.questionTitle);
	$('#questionItems').val(data.questionItems);
	$('#questionAnswer').val(data.questionAnswer);
	$('#questionSkills').val(data.questionSkills);
	$('#answerAnalysis').val(data.answerAnalysis);
	$("select[name='tmxzlx']").val(data.tmxzlx);
	layui.form.render('select');
		layer.open({
			  type: 1,
			  title:'题目编号:'+data.uuid,
			  area: ['720px', '500px'],
			  btn: ['确定'],
			    yes: function(index, layero){
			    	 $.ajax({
			                cache:false,// 保留缓存数据
			                type:"POST",// 为post请求
			                url:pathName+"/tm/insertKm",// 这是我在后台接受数据的文件名
			                data:{
			                	questionTitle:$('#questionTitle').val(),
			    	            questionItems:$('#questionItems').val(),
			    	 			questionAnswer:$('#questionAnswer').val(),
			    	 			questionSkills:$('#questionSkills').val(),
			    	 			answerAnalysis:$('#answerAnalysis').val(),
			    	 			tmxzlx:$('#tmxzlx').val(),
			    	 			kmlx:$('#kmlx').val(),
			    	 			uuid:data.uuid
			                },// 将该表单序列化
			                async:false,// 设置成true，这标志着在请求开始后，其他代码依然能够执行。如果把这个选项设置成false，这意味着所有的请求都不再是异步的了，这也会导致浏览器被锁死
			                error:function(request){// 请求失败之后的操作
			                	layer.msg('网络错误')
			                },
			                success:function(data){// 请求成功之后的操作
			                    
			                }
			            });
			    layer.close(index);
			    },
			  content:$('#opengz')
			});
		
	}