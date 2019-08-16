layui
		.use(
				[ 'form', 'layedit', 'laydate', 'table', 'upload' ],
				function() {
					var form = layui.form, layer = layui.layer, layedit = layui.layedit, laydate = layui.laydate, table = layui.table, upload = layui.upload, $ = layui.$
					$('#upd').hide();
					$('#add').hide();
					 var tableIns =	table.render({
						elem : '#right_table',
						url : pathName + '/tm/selectqdUser', // 数据接口
						title : '用户数据表',
						limits : [ 8, 20, 40, 60, 80, 100 ],
						cols : [ [ {
							type : 'radio'
						},{
							field : 'openid',
							title : '用户ID',
							align : 'center',
						}, {
							field : 'wxname',
							title : '微信名称',
							align : 'center',
						} ,{
							field : 'sjsj',
							title : '最后访问时间',
							align : 'center',
							templet: "<div>{{layui.util.toDateString(d.sjsj, 'yyyy-MM-dd')}}</div>",
							width: 150
						},{
							field : 'avatarurl',
							title : '微信头像',
							align : 'center',
						},{
							field : 'min_key',
							title : '用户密钥',
							align : 'center',
						},{
							field : 'lrry',
							title : '密钥录入人',
							align : 'center'
						},{
							field : 'yxbz',
							title : '用户状态',
							align : 'center',
						},{
							field : 'yxbz1',
							title : '是否可用',
							templet : '#checkboxTpl',
							unresize : true
						}
						] ],
						done: function (res, curr, count) {
			                //如果是异步请求数据方式，res即为你接口返回的信息。
			                //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
			                $("[data-field='yxbz']").children().each(function () {
			                    if ($(this).text() == 'Y') {
			                        $(this).text('可用');
			                    } else if ($(this).text() == 'N') {
			                        $(this).text('不可用');
			                    }else{
			                    	$(this).text('用户状态');
			                    }
			                });
			            },
						page : true, // 开启分页,
						limit : 8,
						id : 'testReload1',
					});
					active = {
						reload : function() {
							var demoReload = $('#demoReload');
							table.reload('testReload1', {
								where : {
									str1 : demoReload.val()
								}
							});
						}
					};

					$('.demoTable .layui-btn').on('click', function() {
						var type = $(this).data('type');
						active[type] ? active[type].call(this) : '';
						
					});

					  table.reload('testReload1', {
							where : {
								str1 : $('#demoReload').val()
							}
						});
				})
function updateGlyzt(uname,sf) {
	$.ajax({
		cache : false,// 保留缓存数据
		type : "POST",// 为post请求
		url : pathName + "/tm/updateYhxxbyopenid",// 这是我在后台接受数据的文件名
		data : {
			openid:uname,
			yxbz:sf
		},// 将该表单序列化
		async : false,// 设置成true，这标志着在请求开始后，其他代码依然能够执行。如果把这个选项设置成false，这意味着所有的请求都不再是异步的了，这也会导致浏览器被锁死
		error : function(request) {// 请求失败之后的操作
			layer.msg('网络错误')
		},
		success : function(data) {// 请求成功之后的操作
			layer.msg(data)
		}
	});
}