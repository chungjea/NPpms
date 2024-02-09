<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8" />
<!DOCTYPE html>
<%--


 --%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css">
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css">
<style>
td {
	text-align: center;
}

.jumbotron {
	padding: 2%;
}

body {
	margin: 40px 10px;
	padding: 0;
	font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	font-size: 14px;
}

.input-group-text {
	width: 100%;
	background-color: linen;
	color: black;
	font-weight: bolder;
}

.input-group-prepend {
	width: 20%;
}

#chatArea {
	width: 80%;
	height: 100px;
	overflow-y: auto;
	text-align: left;
	border: 1px solid green;
}

#calendar {
	max-width: 1100px;
	margin: 0 auto;
}
</style>
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script
	src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api"
	type="text/javascript"></script>
<script src='${path}/a00_com/dist/index.global.js'></script>
<script type="text/javascript">
	$(document).ready(function() {
		var calendarEl = document.getElementById('calendar');
		var today = new Date(); // 날짜형 js 객체
		console.log(today)
		console.log(today.toLocaleString())
		// GMT기준으로 시간별 경도의 날짜/시간표시
		console.log(today.toISOString())
		// 전세계 표준시간(GMT)
		console.log(today.toISOString().split("T"))
		// 시간과 날짜를 배열로 구분해서 출력..
		var todayTitle = today.toISOString().split("T")[0]
		// 날짜만 표현..(기준시간을 지정)
		console.log(todayTitle)
		var calendar = new FullCalendar.Calendar(calendarEl, {
			headerToolbar : {
				left : 'prev,next today',
				center : 'title',
				right : 'dayGridMonth,timeGridWeek,timeGridDay'
			},
			initialDate : todayTitle,
			navLinks : true, // can click day/week names to navigate views
			selectable : true,
			selectMirror : true,
			select : function(arg) {
				// 등록시 처리되는 이벤트 핸들러(날짜 클릭, 시간을 스크롤 하면 처리)
				console.log("# 날짜를 등록시 선택했을 때 #")
				console.log("시작일(문자날짜ISO):" + arg.startStr)
				console.log("시작일(Date):" + arg.start)
				console.log("종료일(문자날짜ISO):" + arg.endStr)
				console.log("종료일(Date):" + arg.end)
				console.log("종일여부:" + arg.allDay)
				// 초기화..
				// 등록하기 위해서 모달창을 로딩/모달창에 form name값에
				// 해당 기본데이터를 설정..
				$("#frm01")[0].reset() 
				//상세화면 로딩 후, 클릭시에는 상세화면내용을 가지고 있거나
				// 이전 입력 form내용을 가지고 있기에 초기화 처리
				$("#calTitle").text("일정등록")
				// 모달창을 상세화면과 같이 쓰기에 타이틀 변경
				$("#start").val(arg.start.toLocaleString())
				$("[name=start]").val(arg.startStr)
				$("#end").val(arg.end.toLocaleString())
				$("[name=end]").val(arg.endStr)
				// api에서는 boolean값을 가지고 있지만, 
				// 등록할 때는 vo로 1/0으로 처리하여 boolean으로
				// 할당하여야 되기에 처리.. 
				// js(boolean이 java boolean) 처리가 바로 되지 않는다.
				$("[name=allDay]").val(arg.allDay ? 1 : 0)
				// 등록/수정/삭제 버튼이 등록시와 상세화면에서
				// 출력하는 것이 다르기에 SHOW/HIDE로 설정..
				$("#regBtn").show()
				$("#uptBtn").hide()
				$("#delBtn").hide() 
				// 강제 클릭..모당창 로딩을 위한 이벤트..
				$("#calModal").click()				
				
				
				/*
				var title = prompt('Event Title:');
				if (title) {
					calendar.addEvent({
						title : title,
						start : arg.start,
						end : arg.end,
						allDay : arg.allDay
					})
				}
				
				 */
				calendar.unselect()
			},
			eventClick : function(arg) {
				$("#frm01")[0].reset()
				console.log("#일정 클릭시#")
				console.log(arg.event)
				addForm(arg.event)
				
				
				
				$("#calTitle").text("일정상세")	
				$("#regBtn").hide()
				$("#uptBtn").show()
				$("#delBtn").show() 
				$("#calModal").click()					
			},
			eventDrop:function(arg){
				addForm(arg.event)
				ajaxFunc("updateCalendar.do", "post")
			},
			eventResize:function(arg){
				addForm(arg.event)
				ajaxFunc("updateCalendar.do", "post")
			},
			editable : true,
			dayMaxEvents : true, // allow "more" link when too many events
			events : function(info, successCallback, failureCallBack) {
				$.ajax({
					url : "${path}/cal_fList",
					dataType : "json",
					success : function(data) {
						console.log(data.cal_fList)
						//alert(data.callist.length+"건!!")
						// 서버단에서 받은 json데이터를 
						// calendar api에 할당 처리..
						
						successCallback(data.cal_fList)
					},
					error : function(err) {
						console.log(err)
						failureCallBack(err)
					}
				})

			}
		});

		calendar.render();

		$("#regBtn").click(function() {
			ajaxFunc("insCal_f", "post")
		})
		$("#uptBtn").click(function(){
			if(confirm("수정하시겠습니까?")){
				ajaxFunc("uptCal_f", "post")
			}
		})
		$("#delBtn").click(function(){
			if(confirm("삭제하시겠습니까?")){
				ajaxFunc("delCal_f", "post")
			}
		})		
		// 링크된 페이지로 창을 로딩하여 이동하게 처리..
		$("[name=urlLink]").dblclick(function(){
			if(confirm("해당페이지로 이동하시겠습니까?")){
				window.open($(this).val(),"","")
			}
		})
		function ajaxFunc(url, type){
			$.ajax({
				type : type,
				url : "${path}/"+url,
				data : $("#frm01").serialize(),
				
				// 데이터를 입력하고 요청데이터 서버에 전송
				dataType : "json",
				
				success : function(data) {
					// 해당 controller에서 다시 모델데이터로 넘겨준 데이터
					// d.addAttribute("msg", service.insertCalendar(ins));
					// 등록 후, 전체 데이터 json데이터로 가지고 있음..
					// d.addAttribute("callist", service.getCalList());									
					console.log(data.msg);
					console.log(data.cal_fList);
					if(data.msg === '등록성공') {
						alert("등록성공"); // 등록성공/등록실패
					} else {
						alert("등록실패");
					}
					$("#clsBtn").click() // 등록 모달창 닫기..
					// 기존일정 삭제(full api에 등록된 데이터 삭제 js) 
					
					calendar.removeAllEvents();
					calendar.render();
					console.log(data.cal_fList)
					// 새로운 일정 추가..(서버에서 controller로 넘겨오 데이터)
					// 다시 추가 처리..
					calendar.addEventSource(data.cal_fList)
					window.location.reload();

				},
				error : function(err) {
					console.log(err)
				}
			})			
			
		}
		function addForm(evt){
			// evt.속성 : 기본적으로 fullcalendar에서 사용하는 속성 
			// evt.extendedProps.속성 : 기본속성이 아닌 추가적으로 
			//		상세화면에 출력시 사용되는 속성
			$("[name=id]").val(evt.id)
			$("[name=title]").val(evt.title)
			$("[name=writer]").val(evt.extendedProps.writer)
			$("#start").val(evt.start.toLocaleString())
			$("[name=start]").val(evt.startStr)
			$("#end").val(evt.end.toLocaleString())
			$("[name=end]").val(evt.endStr)
			
			$("[name=backgroundColor]").val(evt.backgroundColor)
			$("[name=textColor]").val(evt.textColor)
			$("[name=content]").val(evt.extendedProps.content)
			$("[name=urlLink]").val(evt.extendedProps.urlLink)
			$("[name=allDay]").val(evt.allDay?1:0)
		}

	});
</script>

</head>

<body>
	<div class="jumbotron text-center">
		<h2>일정</h2>
	</div>
	<%-- 
		
--%>
	<div class="container">
		<div id='calendar'></div>
	</div>
	<button id="calModal" class="btn btn-success d-none"
		data-toggle="modal" data-target="#exampleModalCenter" type="button">등록</button>

	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header"><!-- 

				
				 -->
					<h5 class="modal-title" id="calTitle">일정등록</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="frm01" class="form" method="post">
						<input type="hidden" name="id" value="0"/>
						<div class="input-group mb-3">
							<div class="input-group-prepend ">
								<span class="input-group-text  justify-content-center">
									제목</span>
							</div>
							<input type="text" name="title" class="form-control" value="" />
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend ">
								<span class="input-group-text  justify-content-center">
									시작일</span>
							</div>
							<input type="text" id="start" readonly class="form-control" /> <input
								type="hidden" name="start" />
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend ">
								<span class="input-group-text  justify-content-center">
									종료일</span>
							</div>
							<input type="text" id="end" readonly class="form-control" /> <input
								type="hidden" name="end" />
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend ">
								<span class="input-group-text  justify-content-center">
									작성자</span>
							</div>
							<input name="writer" class="form-control" value="" />
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend ">
								<span class="input-group-text  justify-content-center">
									내용</span>
							</div>
							<textarea name="content" id="chatArea" class="form-control"></textarea>
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend ">
								<span class="input-group-text  justify-content-center">
									배경색</span>
							</div>
							<input type="color" name="backgroundColor" class="form-control"
								value="#0099cc" />
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend ">
								<span class="input-group-text  justify-content-center">
									글자색</span>
							</div>
							<input type="color" name="textColor" class="form-control"
								value="#ccffff" />
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend ">
								<span class="input-group-text  justify-content-center">
									종일여부</span>
							</div>

							<select name="allDay" class="form-control">
								<option value="1">종일</option>
								<option value="0">시간</option>
							</select>
						</div>
						<div class="input-group mb-3">
							<div class="input-group-prepend ">
								<span class="input-group-text  justify-content-center">
									참고 link</span>
							</div>
							<input type="text" name="urlLink" class="form-control" value="" />
						</div>
					</form>
				</div>
				<div class="modal-footer"><!-- -->
					<button type="button" id="regBtn" class="btn btn-primary">일정등록</button>
					<button type="button" id="uptBtn" class="btn btn-info">일정수정</button>
					<button type="button" id="delBtn" class="btn btn-warning">일정삭제</button>
					<button type="button" id="clsBtn" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
				<script type="text/javascript">
					
				</script>
			</div>
		</div>
	</div>
</body>
</html>