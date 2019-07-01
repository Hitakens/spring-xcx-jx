/**
 * Created by Administrator on 2019/11/15.
 */
var itemList = [ "A", "B", "C", "D", "E", "F" ]
var activeQuestion = 0; // 当前操作的考题编号
var questioned = 0; //
var checkQues = []; // 已做答的题的集合
var questionuuid='';//当前题的uuid
//获取数据

function getKmydata(pa) {
	 $.ajax({
         type: "get",
         dataType: "html",
         url: pathName+"/kt/getKmydata/"+pa, //后台文件的url 就是form的action,用ajax提交表单就不需要给form写action了
         success: function (result) {
        	 questions=eval(result);
        	    showQuestion(0);
        		answerCard();
        		showctlv();
        		showQuestion(0);
         },
         error: function(data) {
        	 $.toast("网络错误,请稍后再试!", "cancel");
          }  
         });
	
}
// 展示考卷信息
function showQuestion(id) {
	$(".questioned").text(id+1);
	questioned = (id+1) / questions.length
	if (activeQuestion != undefined) {
		$("#ques" + activeQuestion).removeClass("question_id").addClass(
				"active_question_id");
	}
	activeQuestion = id;
	$(".question").find(".question_info").remove();
	$(".question").find(".quest-sum").remove();
	var question = questions[id];
	questionuuid=question.uuid;
	var htmlpj = '<a onclick="musicplay()" href="javascript:;" class=" weui-btn_default-zdy"><img class="jq-left-img"  src="../../static/jx/img/sy/dt.png"></a>'
	$(".question_title").html(
			"<strong>第 " + (id+1) + " 题 、</strong>" + question.questionTitle+ htmlpj);
	$('#showjq').html(question.questionSkills);
	$('.bzda-db').html(question.answerAnalysis)
	var items = question.questionItems.split(";");
	var item = "";
	if(question.questionImg!='无'){
		$(".question")
		.append(
				'<li class="quest-sum"><img class="question-img" alt="" src="../../static/jx/img/xckmy/'+question.questionImg+'"></li>')
	}
	for (var i = 0; i < items.length; i++) {
		item = "<li class='question_info' onclick='clickTrim(this)' id='item"
				+ i + "'><input type='radio' name='item' value='" + itemList[i]
				+ "'>&nbsp;" + itemList[i] + "." + items[i] + "</li>";
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
					+ ")' class='questionIdcw'>" + eval((checkQues[i].id)+1) + "</li>";
			$("#answerCardcw1 ul").append(questionId);
		}

	}
}
/* 选中考题 */
var Question;
function clickTrim(source) {
	var id = source.id;
	$("#" + id).find("input").prop("checked", "checked");
	$("#ques" + activeQuestion).removeClass("question_id").addClass("clickQue");
	var ques = 0;
	var zqid;
	// 正确答案
	var zqda = questions[activeQuestion].questionAnswer;
	if (zqda == $("#" + id).find("input[name=item]:checked").val()) {
		$("#" + id).addClass("clickTrim");
		for (var i = 0; i < checkQues.length; i++) {
			if (checkQues[i].id == activeQuestion && checkQues[i].item != id) {
				ques = checkQues[i].id;
				checkQues[i].item = id;// 获取当前考题的选项ID
				checkQues[i].answer = $("#" + id).find(
						"input[name=item]:checked").val();// 获取当前考题的选项值
				checkQues[i].zqda = 1;
			}
		}

		if (checkQues.length == 0 || Question != activeQuestion
				&& activeQuestion != ques) {
			var check = {};
			check.id = activeQuestion;// 获取当前考题的编号
			check.item = id;// 获取当前考题的选项ID
			check.answer = $("#" + id).find("input[name=item]:checked").val();// 获取当前考题的选项值
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
			if (checkQues[i].id == activeQuestion && checkQues[i].item != id) {
				ques = checkQues[i].id;
				checkQues[i].item = id;// 获取当前考题的选项ID
				checkQues[i].answer = $("#" + id).find(
						"input[name=item]:checked").val();// 获取当前考题的选项值
				checkQues[i].zqda = 0;
			}
		}

		if (checkQues.length == 0 || Question != activeQuestion
				&& activeQuestion != ques) {
			var check = {};
			check.id = activeQuestion;// 获取当前考题的编号
			check.item = id;// 获取当前考题的选项ID
			check.answer = $("#" + id).find("input[name=item]:checked").val();// 获取当前考题的选项值
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
		$('#jqhide').show();
	}

	$(".question_info").each(function() {
		var otherId = $(this).attr("id");
		if (otherId != id && otherId != zqid) {
			$("#" + otherId).find("input").prop("checked", false);
			$("#" + otherId).removeClass("clickTrim");
			$("#" + otherId).removeClass("clickTrimcw");
		}
	})
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
function musicplay() {
	var t = $('.question_title').text()
	var list = $('.question_info').text()
	var url = "http://tts.baidu.com/text2audio?lan=zh&ie=UTF-8&text="
			+ encodeURI(t);
	var audio = new Audio(url);
	audio.src = url;
	audio.play();
}
function musicjqplay(){
	var list = $('#showjq').text()
	var url = "http://tts.baidu.com/text2audio?lan=zh&ie=UTF-8&text="
			+ encodeURI(list);
	var audio = new Audio(url);
	audio.src = url;
	audio.play();
}
//收藏本题
function scthisquestion(pa) {
	 $.ajax({
         type: "post",
         dataType: "html",
         url: pathName+"/kt/scbt", //后台文件的url 就是form的action,用ajax提交表单就不需要给form写action了
         data:{uuid:questionuuid,sclx:pa},
         dataType: "json",
         success: function (result) {
        	
         },
         error: function(data) {
        	 $.toast("网络错误,请稍后再试!", "cancel");
          }  
         });
}
$(function() {
/* 收藏按钮的切换 */
$("#unHeart").click(function() {
	$(this).hide();
	$("#heart").show();
})
$("#heart").click(function() {
	$(this).hide();
	$("#unHeart").show();
})

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

// 提交试卷
$("#submitQuestions").click(
		function() {
			var sum = [];
			if (checkQues.length < 1) {
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
		if(sum.length<80){
			$('#mlssimg').html('<img class="tjimg" src="../../static/jx/img/sy/mlss.jpeg"></img>')
			$('#pjsp').html('超级马路杀手');
			$('#pjsp').addClass('markedred')
		}else if(sum.length<100 && sum.length>80){
			$('#mlssimg').html('<img class="tjimg" src="../../static/jx/img/sy/nl.png"></img>')
			$('#pjsp').html('继续加油');
			$('#pjsp').addClass('markedaqua')
		}else{
			$('#mlssimg').html('<img  class="tjimg" src="../../static/jx/img/sy/100.jpeg"></img>')
			$('#pjsp').html('秋名山车神');
			$('#pjsp').addClass('markedgreen')
		}
		$('#pjspdesc').html("已做答:" +checkQues.length + "道题,错了"+eval(checkQues.length-sum.length)+"道题,还有"
				+ (questions.length - checkQues.length)+ "道题未完成");
			
		})
// 进入下一题
$("#nextQuestion").click(function() {
	if ((activeQuestion + 1) != questions.length) {
		showQuestion(activeQuestion + 1);
		$('#jqhide').hide();
	} else {
		showQuestion(activeQuestion)
	}

})

$("#previousQuestion").click(function() {
	if ((activeQuestion - 1) >= 0) {
		showQuestion(activeQuestion - 1);
	} else {
		showQuestion(activeQuestion)
	}
})
})