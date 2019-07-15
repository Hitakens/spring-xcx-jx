/**
 * Created by Administrator on 2019/11/15.
 */
var itemList = [ "A", "B", "C", "D", "E", "F" ]
var activeQuestion = 0; // 当前操作的考题编号
var questioned = 0; //
var checkQues = []; // 已做答的题的集合
var questionuuid = '';// 当前题的uuid

/* 实现计时器 */
function timedjs(isopen) {
	if (isopen) {
		var time = setInterval(function() {
			str = "";

			if (--ss == 0) {
				// alert($("#timeer").text());
				if (--mm == 0) {
					mm = 0;
				}
				if ($("#timeer").text() == '00:01') {
					clearInterval(time);
					$.toast("时间已到，请你停止答题！", "forbidden");
				}
				ss = 60;
			}
			str += mm < 10 ? "0" + mm : mm;
			str += ":";
			str += ss < 10 ? "0" + ss : ss;
			$("#timeer").text(str);
			if ("0-1:60" == str) {
				$("#timeer").text("00:00");
			}
		}, 1000);
	}
}

// 获取数据
function getKmsdata() {
	$.showLoading();
	$.ajax({
		type : "get",
		dataType : "html",
		url : pathName + "/xc/getKmsdata/" + cs, // 后台文件的url
		// 就是form的action,用ajax提交表单就不需要给form写action了
		success : function(result) {
			questions = eval(result);
			showQuestion(0);
			answerCard();
			showctlv();
		},
		error : function(data) {
			$.toast("网络错误,请稍后再试!", "cancel");
		}
	});

}
// 展示考卷信息
function showQuestion(id) {
	$(".questioned").text(id + 1);
	questioned = (id + 1) / questions.length
	if (activeQuestion != undefined) {
		$("#ques" + activeQuestion).removeClass("question_id").addClass(
				"active_question_id");
	}
	activeQuestion = id;
	$(".question").find(".question_info").remove();
	$(".question").find(".quest-sum").remove();
	var question = questions[id];
	questionuuid = question.uuid;
	var htmlpj = '<a  onclick="musicplay()" class=" weui-btn_default-zdy"><img class="jq-left-img"  src="'
			+ pathName + '/static/jx/img/sy/dt.png"></a>'
	$(".question_title").html(
			"<strong> " + question.tmxzlx + " </strong>、"
					+ question.questionTitle + htmlpj);
	$('#showjq').html(question.questionSkills);
	$('.bzda-db').html(question.answerAnalysis)
	var items = question.questionItems.split(";");
	var item = "";
	if (question.questionImg != '无') {
		$(".question").append(
				'<li class="quest-sum"><img class="question-img" alt="" src="'+ question.questionImg + '"></li>')
	}
	for (var i = 0; i < items.length; i++) {
		item = "<li class='question_info' onclick='clickTrim(this)' id='item"
				+ i + "'><input type='checkbox' name='item' value='"
				+ itemList[i] + "'>&nbsp;" + itemList[i] + "." + items[i]
				+ "</li>";
		$(".question").append(item);
	}
	$(".question").attr("id", "question" + id);
	$("#ques" + id).removeClass("active_question_id").addClass("question_id");
	for (var i = 0; i < checkQues.length; i++) {
		if (checkQues[i].id == id) {
			$("#" + checkQues[i].item).find("input").prop("checked", "checked");
			$("#" + checkQues[i].item).addClass("clickTrim");
			$("#ques" + activeQuestion).removeClass("question_id").addClass(
					"clickQue");
		}
	}
	$.hideLoading();
	iftmsc();
	$('.button_sp_area-zdy').show();
}

/* 答题卡 */
function answerCard() {
	$(".question_sum").text(questions.length);
	for (var i = 0; i < questions.length; i++) {
		var questionId = "<li id='ques" + i + "'onclick='saveQuestionState("
				+ i + ")' class='questionId'>" + (i + 1) + "</li>";
		$("#answerCard ul").append(questionId);
	}
}
/* 展现错误的答题卡 */
function answerCardcw() {
	$('.list-unstyled-zdy').empty();
	for (var i = 0; i < checkQues.length; i++) {
		if (checkQues[i].zqda == 0) {
			var questionId = "<li id='ques" + checkQues[i].id
					+ "'onclick='saveQuestionState(" + checkQues[i].id
					+ ")' class='questionIdcw'>" + eval((checkQues[i].id) + 1)
					+ "</li>";
			$("#answerCardcw1 ul").append(questionId);
		}

	}
}
/* 选中考题 */
function clickTrim(source) {
	var id = source.id;
	if ($("#" + id).find("input").prop("checked")) {
		$("#" + id).find("input").prop("checked", "");
	} else {
		$("#" + id).find("input").prop("checked", "checked");
	}
	$("#ques" + activeQuestion).removeClass("question_id").addClass("clickQue");
	var ques = 0;
	// 正确答案
	var zqda = questions[activeQuestion].questionAnswer;
	// 判断答案是不是多选
	if (zqda.length == 1) {
		if (zqda == $("#" + id).find("input[name=item]:checked").val()) {
			$("#" + id).addClass("clickTrim");
			for (var i = 0; i < checkQues.length; i++) {
				if (checkQues[i].id == activeQuestion) {
					ques = checkQues[i].id;
					checkQues[i].item = id;// 获取当前考题的选项ID
					checkQues[i].answer = $("#" + id).find(
							"input[name=item]:checked").val();// 获取当前考题的选项值
					checkQues[i].zqda = 1;
				}
			}

			if (checkQues.length == 0 || activeQuestion != ques) {
				var check = {};
				check.id = activeQuestion;// 获取当前考题的编号
				check.item = id;// 获取当前考题的选项ID
				check.answer = $("#" + id).find("input[name=item]:checked")
						.val();// 获取当前考题的选项值
				check.zqda = 1;
				checkQues.push(check);
			}
			if ((activeQuestion + 1) != questions.length) {
				showQuestion(activeQuestion + 1);
			} else {
				showQuestion(activeQuestion)
			}
		} else {
			$("#" + id).addClass("clickTrimcw");
			for (var i = 0; i < checkQues.length; i++) {
				if (checkQues[i].id == activeQuestion) {
					ques = checkQues[i].id;
					checkQues[i].item = id;// 获取当前考题的选项ID
					checkQues[i].answer = $("#" + id).find(
							"input[name=item]:checked").val();// 获取当前考题的选项值
					checkQues[i].zqda = 0;
				}
			}
			if (checkQues.length == 0 || activeQuestion != ques) {
				var check = {};
				check.id = activeQuestion;// 获取当前考题的编号
				check.item = id;// 获取当前考题的选项ID
				check.answer = $("#" + id).find("input[name=item]:checked")
						.val();// 获取当前考题的选项值
				check.zqda = 0;
				checkQues.push(check);
			}
			// 把正确的答案显示出来
			$(".question_info").each(function() {
				var otherId = $(this).attr("id");
				if (zqda == $("#" + otherId).find("input[name=item]").val()) {
					zqid = otherId;
					$("#" + otherId).addClass("clickTrim");
				}
			})
			cwthisquestion();
			$(".markedred").addClass("markedred1");
			if ($('#showjq').text().length < 1) {
				$('.button_sp_area-zdy').hide();
			}
			$('#jqhide').show();
		}
	} else {
		// 这里是多选题
		obj = document.getElementsByName("item");
		check_val = '';
		for (k in obj) {
			if (obj[k].checked)
				check_val += obj[k].value;
		}
		if (check_val.length == zqda.length) {
			if (zqda == check_val) {
				var daxs = [ 'A', 'B', 'C', 'D' ];
				// 把正确的答案显示出来
				for (var i = 0; i < daxs.length; i++) {
					if (zqda.search(daxs[i]) == -1) {

					} else {
						$("#item" + i).addClass("clickTrim");
					}
				}
				for (var i = 0; i < checkQues.length; i++) {
					if (checkQues[i].id == activeQuestion) {
						ques = checkQues[i].id;
						checkQues[i].item = id;// 获取当前考题的选项ID
						checkQues[i].answer = $("#" + id).find(
								"input[name=item]:checked").val();// 获取当前考题的选项值
						checkQues[i].zqda = 1;
					}
				}

				if (checkQues.length == 0 || activeQuestion != ques) {
					var check = {};
					check.id = activeQuestion;// 获取当前考题的编号
					check.item = id;// 获取当前考题的选项ID
					check.answer = $("#" + id).find("input[name=item]:checked")
							.val();// 获取当前考题的选项值
					check.zqda = 1;
					checkQues.push(check);
				}
				if ((activeQuestion + 1) != questions.length) {
					showQuestion(activeQuestion + 1);
				} else {
					$.toast("已经是最后一题了！");
					// showQuestion(activeQuestion)
				}
			} else {
				var daxs = [ 'A', 'B', 'C', 'D' ];
				// 把正确的答案显示出来
				for (var i = 0; i < daxs.length; i++) {
					if (zqda.search(daxs[i]) == -1) {
						$("#item" + i).addClass("clickTrimcw");
					} else {
						$("#item" + i).addClass("clickTrim");
					}
				}
				for (var i = 0; i < checkQues.length; i++) {
					if (checkQues[i].id == activeQuestion) {
						ques = checkQues[i].id;
						checkQues[i].item = id;// 获取当前考题的选项ID
						checkQues[i].answer = $("#" + id).find(
								"input[name=item]:checked").val();// 获取当前考题的选项值
						checkQues[i].zqda = 0;
					}
				}
				if (checkQues.length == 0 || activeQuestion != ques) {
					var check = {};
					check.id = activeQuestion;// 获取当前考题的编号
					check.item = id;// 获取当前考题的选项ID
					check.answer = $("#" + id).find("input[name=item]:checked")
							.val();// 获取当前考题的选项值
					check.zqda = 0;
					checkQues.push(check);
				}
				cwthisquestion();
				$(".markedred").addClass("markedred1");
				if ($('#showjq').text().length < 1) {
					$('.button_sp_area-zdy').hide();
				}
				$('#jqhide').show();
			}

		} else {

		}
	}
	Question = activeQuestion;
	showctlv();
}

/* 设置进度条 */
function progress() {
	var prog = ($(".active_question_id").length + 1) / questions.length;
	var pro = $(".progress").parent().width() * prog;
	$(".progres").text((prog * 100).toString().substr(0, 5) + "%")
	$(".progress").animate({
		width : pro,
		opacity : 0.5
	}, 1000);
}

/* 保存考题状态 已做答的状态 */
function saveQuestionState(clickId) {
	showQuestion(clickId)
}

function sleep(numberMillis) {
	var now = new Date();
	var exitTime = now.getTime() + numberMillis;
	while (true) {
		now = new Date();
		if (now.getTime() > exitTime)
			return;
	}
}
/** 算出错题率* */
function showctlv() {
	var sum = [];
	if (checkQues.length < 1) {
		$('.questionctl').text('0/0')
	} else {
		for (var i = 0; i < checkQues.length; i++) {
			if (checkQues[i].zqda == 0) {
				sum.push(1);
			}
		}
		$('.questionctl').text(sum.length + '/' + checkQues.length)
	}
}
var audio = null;
// 语音读题
function musicplay() {
	var text = $('.question_title').text()
	var url = "https://tsn.baidu.com/text2audio?cuid="
			+ Math.random().toString(36).substr(2)
			+ "&ctp=1&lan=zh&ie=UTF-8&spd="
			+ "5&pit=9&per=0&tok=24.3aa5be899a4c0f0fe6051bf141e24d5f.2592000.1565708745.282335-15821559"
			+ "&vol=9&text=" + encodeURIComponent(encodeURIComponent(text));
	if(audio==null){
		audio=new Audio(url);
	     audio.src = url;
	     audio.play();
	}
   audio.src = url;
    audio.play();
}
// 语音技巧
function musicjqplay() {
	var text = $('#showjq').text()
	var url = "https://tsn.baidu.com/text2audio?cuid="
			+ Math.random().toString(36).substr(2)
			+ "&ctp=1&lan=zh&ie=UTF-8&spd="
			+ "5&pit=9&per=0&tok=24.3aa5be899a4c0f0fe6051bf141e24d5f.2592000.1565708745.282335-15821559"
			+ "&vol=9&text=" + encodeURIComponent(encodeURIComponent(text));
	if(audio==null){
		audio=new Audio(url);
	     audio.src = url;
	     audio.play();
	}
   audio.src = url;
    audio.play();
}
// 判断题目是否已经收藏
function iftmsc() {
	if (lx == null || lx.length <= 0) {
		$.ajax({
			type : "get",
			url : pathName + "/xc/iftmsc", // 后台文件的url
			// 就是form的action,用ajax提交表单就不需要给form写action了
			data : {
				uuid : questionuuid,
				cwlx : pa
			},
			dataType : "json",
			success : function(result) {
				if (result == '1') {
					$("#heart").show();
					$("#unHeart").hide();
				} else {
					$("#unHeart").show();
					$("#heart").hide();
				}
			},
			error : function(data) {
				$.toast("网络错误,请稍后再试!", "cancel");
			}
		});
	}
}
// 收藏本题
function scthisquestion() {
	$.ajax({
		type : "post",
		url : pathName + "/xc/scbt", // 后台文件的url
		// 就是form的action,用ajax提交表单就不需要给form写action了
		data : {
			uuid : questionuuid,
			sclx : pa
		},
		dataType : "text",
		success : function(result) {
			$.toast(result);
		},
		error : function(data) {
			$.toast("网络错误,请稍后再试!", "cancel");
		}
	});
}

// 错误题目入库
function cwthisquestion() {
	var res = '';
	$.ajax({
		type : "post",
		url : pathName + "/xc/btcw", // 后台文件的url
		// 就是form的action,用ajax提交表单就不需要给form写action了
		data : {
			uuid : questionuuid,
			cwlx : pa
		},
		dataType : "json",
		success : function(result) {

		},
		error : function(data) {

		}
	});
}
// 提交试卷

function submitQuestions() {
	var sum = [];
	if (checkQues.length < 1) {
		$.toast("你还没有答题，不能提交", "cancel");
		return;
	} else {
		for (var i = 0; i < checkQues.length; i++) {
			if (checkQues[i].zqda == 1) {
				sum.push(1);
			}
		}
	}
	$('#pjsp').removeClass('markedred')
	$('#pjsp').removeClass('markedaqua')
	$('#pjsp').removeClass('markedgreen')
	if (sum.length < 80) {
		$('#mlssimg').html(
				'<img class="tjimg" src="' + pathName
						+ '/static/jx/img/sy/mlss.jpeg"></img>')
		$('#pjsp').html('超级马路杀手');
		$('#pjsp').addClass('markedred')
	} else if (sum.length < 90 && sum.length > 80) {
		$('#mlssimg').html(
				'<img class="tjimg" src="' + pathName
						+ '/static/jx/img/sy/nl.png"></img>')
		$('#pjsp').html('继续加油');
		$('#pjsp').addClass('markedaqua')
	} else if (sum.length < 100 && sum.length > 90) {
		$('#mlssimg').html(
				'<img  class="tjimg" src="' + pathName
						+ '/static/jx/img/sy/kstg.jpeg"></img>')
		$('#pjsp').html('通关达人');
		$('#pjsp').addClass('markedgreen')
	} else if (sum.length >= 100) {
		$('#mlssimg').html(
				'<img  class="tjimg" src="' + pathName
						+ '/static/jx/img/sy/100.jpeg"></img>')
		$('#pjsp').html('秋名山车神');
		$('#pjsp').addClass('markedgreen')
	}
	$('#pjspdesc').html(
			"已做答:" + checkQues.length + "道题,错了"
					+ eval(checkQues.length - sum.length) + "道题,还有"
					+ (questions.length - checkQues.length) + "道题未完成");

}

// 删除本题
function deletebt() {
	$.ajax({
		type : "post",
		url : pathName + "/xc/deletebt", // 后台文件的url
		// 就是form的action,用ajax提交表单就不需要给form写action了
		data : {
			str1 : questionuuid,
			str2 : lx,
			str3 : pa
		},
		dataType : "json",
		success : function(result) {
			if (result == "200") {
				$.toast("删除成功！");
				window.location.href = pathName + '/xc/cwsc/' + lx + '/kmy';
			} else {
				$.toast("删除失败！");
			}

		},
		error : function(data) {
			$.toast("网络错误", "cancel");
		}
	});
}
$(function() {
	/* 答题卡的切换 */
	$("#openCard").click(function() {
		$("#answerCardcw1").hide();
		$("#answerCard").slideDown();

	})

	$("#openCardcw").click(function() {
		$("#answerCard").hide();
		answerCardcw();
		$("#answerCardcw1").show();
	})

	$("#closeCard").click(function() {
		$("#openCard").show();
		$("#answerCard").slideUp();
		$(this).hide();
	})

	// 进入下一题
	$("#nextQuestion").click(function() {
		if ((activeQuestion + 1) != questions.length) {
			showQuestion(activeQuestion + 1);
			$('#jqhide').hide();
		} else {
			showQuestion(activeQuestion)
		}
		if (audio != null) {
			audio.pause();
		} else {
			audio == null;
		}

	})

	$("#previousQuestion").click(function() {
		if ((activeQuestion - 1) >= 0) {
			showQuestion(activeQuestion - 1);
		} else {
			showQuestion(activeQuestion)
		}
		if (audio != null) {
			audio.pause();
		} else {
			audio == null;
		}
	})
})