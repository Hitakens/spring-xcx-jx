layui
		.use(
				[ 'form', 'layedit', 'laydate', 'table', 'upload' ],
				function() {
					var form = layui.form, layer = layui.layer, layedit = layui.layedit, laydate = layui.laydate, table = layui.table, upload = layui.upload, $ = layui.$
					$('#upd').hide();
					$('#add').hide();
					 var tableIns =	table.render({
						elem : '#right_table',
						url : pathName + '/tm/selectUserKm', // 数据接口
						title : '用户数据表',
						toolbar : '#toolbarDemo',
						limits : [ 7, 20, 40, 60, 80, 100 ],
						cols : [ [ {
							type : 'radio'
						}, {
							field : 'min_key',
							title : '用户名称',
							align : 'center'
						},{
							field : 'sjsj',
							title : '创建时间',
							align : 'center',
							templet: "<div>{{layui.util.toDateString(d.sjsj, 'yyyy-MM-dd')}}</div>",
						},{
							field : 'lrry',
							title : '录入人员',
							align : 'center'
						},{
							field : 'yxbz',
							title : '是否被用',
							align : 'center'
						}
						] ],
						done: function (res, curr, count) {
			                //如果是异步请求数据方式，res即为你接口返回的信息。
			                //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
			                $("[data-field='yxbz']").children().each(function () {
			                    if ($(this).text() == 'Y') {
			                        $(this).text('否');
			                    } else if ($(this).text() == 'N') {
			                        $(this).text('是');
			                    }else{
			                    	$(this).text('是否被用');
			                    }
			                });
			            },
						page : true, // 开启分页,
						limit : 7,
						id : 'testReload1',
					});
					active = {
						reload : function() {
							var demoReload = $('#demoReload');
							var kmlx = $('#kmlx');
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
					table.on('toolbar(right_table)', function(obj) {
						var checkStatus = table.checkStatus(obj.config.id); // 获取选中行状态
						if (checkStatus.data[0] == undefined && obj.event!="add") {
							layer.msg('请选择一行进行操作！', {
								time : 2000
							});
							return;
						}
						switch (obj.event) {
						case 'update':
							var data = checkStatus.data[0]; // 获取选中行数据
							opengz(data,table);
							break;
						case 'add':
							//var data = checkStatus.data[0]; // 获取选中行数据
							opentp(table);
							break;
						case 'del':
							var data = checkStatus.data[0]; // 获取选中行数据
							layer.confirm('真的删除行么', function (index) {
			                    $.ajax({
			                        url: pathName+"/tm/deleteOpenByKm",
			                        type: "POST",
			                        data: {min_key: data.min_key},
			                          success: function (msg) {
			                                layer.close(index);
			                                table.reload('testReload1', {
			    								where : {
			    									str1 : $('#demoReload').val()
			    								}
			    							});
			                                layer.msg(msg);
			                        }
			                    });
			                    return true;
			                });
							break;
						break;
					}
					;
				}	);

				})
function opengz(data,table) {
	$('#questionTitle').val(data.username);
	$('#questionItems').val(data.userpass);
	$('#questionSkills').val(data.bz);
	layer.open({
		type : 1,
		title : '用户账号:' + data.username,
		area : [ '350px', '250px' ],
		btn : [ '确定' ],
		yes : function(index, layero) {
			$.ajax({
				cache : false,// 保留缓存数据
				type : "POST",// 为post请求
				url : pathName + "/tm/updateGlyzt",// 这是我在后台接受数据的文件名
				data : {
					username : $('#questionTitle').val(),
					userpass : $('#questionItems').val(),
					bz : $('#questionSkills').val(),
				},// 将该表单序列化
				async : false,// 设置成true，这标志着在请求开始后，其他代码依然能够执行。如果把这个选项设置成false，这意味着所有的请求都不再是异步的了，这也会导致浏览器被锁死
				error : function(request) {// 请求失败之后的操作
					layer.msg('网络错误')
				},
				success : function(data) {// 请求成功之后的操作
					table.reload('testReload1', {
						where : {
							str1 : $('#demoReload').val()
						}
					});
					layer.msg(data);
				}
			});
			layer.close(index);
		},
		content : $('#upd')
	});

}
function updateGlyzt(uname,sf) {
	$.ajax({
		cache : false,// 保留缓存数据
		type : "POST",// 为post请求
		url : pathName + "/tm/updateGlyzt",// 这是我在后台接受数据的文件名
		data : {
			username:uname,
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
function opentp(table){
	layer.open({
		type : 2,
		title : '添加卡密',
		area : [ '450px', '400px' ],
		closeBtn:'1',
		shadeClose:true,
		skin:'layui-layer-rim layui-layer-lan',
		content : pathName+'/main/admin/kmsc?uname='+uname,
		 cancel: function () {
				table.reload('testReload1', {
					where : {
						str1 : $('#demoReload').val()
					}
				});
         }
	});

		
	}