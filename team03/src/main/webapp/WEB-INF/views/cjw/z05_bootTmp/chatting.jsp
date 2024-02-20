<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Good day!!</title>




<%--
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script
	src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api"
	type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function() {

	});
</script>
 --%>


<style>
	table{
		 width:70%;
		 cellspacing:0;
	}
	td{
		text-align:center;
		background-color:whitesmoke;
		height:40px;
		line-height:40px;
		font-size:18px;
	}
	td:hover{
		background-color:gainsboro;
	}
	th{
		text-align:center !important;
		background-color:white;
		
	}
	table caption {
	    caption-side: top;
	    text-align: center;
	    font-size: x-large;
	    padding: 2px;
	    margin-bottom:5px;
	}
	.jumbotron{
		padding:2%;
	}
	.input-group-text{
		width:100%;
		color:black;
		font-weight:bolder;
	}
	.input-group-prepend{
		width:20%;
	}
	#chatroom-container::-webkit-scrollbar {
  		display: none;
	}
	#chatroom-container{
		width:50%;
		max-height: 70vh;
	    height: 70vh;
	    overflow-y: auto;
	}
	#scroll{
		width:70%;
	    margin: 0 auto;
	}
	#chat-container {
		width:50%;
    	align-items: center;
	    height: 70vh;
	}
	#chatArea {
	    width: 420px;
	    height: 550px;
	    background: white;
	    border-radius: 5px;
	    display: flex;
	    margin: 0 auto;
	    justify-content: center;
	    align-items: center;
	    flex-direction: column;
	}
	#chatName{
		width:100%;
		background-color:skyblue;
	}
	#chatGroup{
		width:100%;
		padding: 10px;
		text-align:center;
		color:white;
	}
	#chatMessageArea {
	    flex: 1;
	    padding: 10px;
	    overflow-y: auto;
	    text-align:left;
	    padding-right: 13px;
	    padding-left: 15px;
	}
	#msg {
	    border: light;
	    padding: 10px;
	    width: calc(100% - 80px);
	    margin-left: 10px;
	    margin-top: 10px;
	    margin-bottom: 10px;
	}
	#sndBtn {
	    width: 60px;
	    height: 38px;
	    margin-right: 10px;
	    margin-top: 10px;
	    margin-bottom: 10px;
	    text-align: center;
	}
</style> 
 
     <!-- Custom fonts for this template-->
    <link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">
 
 
 
</head>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	var empno = "${emp.empno}"
	var name = "${emp.ename}(${emp.dname})"
		// 화면 크기에 따라 동적으로 조절 처리
	window.addEventListener("resize",function(){
		$("#chatMessageArea>div").width($("#chatArea").width()-5)
	})
	var wsocket = null;
	function goChat(crno, userid){
		var idVal = userid;
		wsocket = new WebSocket("ws:localhost:3333/chat")
		// 주의: localhost:로 현재 pc로 완료가 되었으면 서버(공유아이피주소설정)
		// 업로드 후, 서버에서 잘 작동되는지 확인..
			
		wsocket.onopen = function(evt){
			console.log(evt)
				
			wsocket.send(crno+":"+idVal+":접속하셨습니다!")
		}
		wsocket.onmessage = function(evt){
			// 서버에서 push 접속한 모든 client에 전송..
			revMsg(evt.data) // 메시지 처리 공통 함수 정의				
		}
		$("#crno").val(crno)
	}
	
	$(document).ready(function(){
		function revMsg(msg){
			// 보내는 메시지는 오른쪽
			// 받는 메시지는 왼쪽 정렬 처리 : 사용자아이디:메시지 내용
			var msgArr = msg.split(":") // 사용자명:메시지 구분 하여 처리..
			var crno = msgArr[0]
			var sndId = msgArr[1] // 보내는 사람 메시지 id
			var msgtext = msgArr[2]
			var crnonow = $("#crno").val(crno);
			if(crnonow == crno){
				if(empno==sndId){ 
					// 보내는 사람과 받는 사람의 아이디 동일:현재 접속한 사람이 보낸 메시지 
					var alignOpt = "right"
					var msgObj = $("<div></div>").text(msgtext).attr("align",alignOpt).css("width",$("#chatArea").width()-10)
					$("#chatMessageArea").append(msgObj);
				}else{
					var alignOpt = "left"
					var msgObj = $("<div></div><br>").text(sndId).attr("align",alignOpt).css("width",$("#chatArea").width()-10)+$("<div></div>").text(msgtext).attr("align",alignOpt).css("width",$("#chatArea").width()-10)
					$("#chatMessageArea").append(msgObj);
				}
			}
			
			// 스크롤링 처리..
			// 1. 전체 해당 데이터의 높이를 구한다.
			// 2. 포함하고 있는 부모 객체(#chatArea)에서
			//    스크롤 기능 메서드로 스크롤되게 처리한다. scrollTop()
			var height = parseInt($("#chatMessageArea").height())
			mx += height+20
			$("#chatMessageArea ").scrollTop(mx)

		}
		var mx = 0;
		$("#sndBtn").click(function(){
			sendMsg()	
		})
		$("#msg").keyup(function(){
			if(event.keyCode==13){
				sendMsg()
			}
		})
		function sendMsg(){
			var crnonow = $("#crno").val();
			var id = $("#id").val();
			wsocket.send(crnonow+":"+id+":"+$("#msg").val())
			$("#msg").val("")			
		}
		
		
		$("#okBtn").click(function(){
			alert($("#frm02").serialize())
			$.ajax({
				type : "post",
				url : "${path}/makechatroom",
				data : $("#frm02").serialize(),
				dataType : "json",
				success : function(data) {
					var msg = data.msg
					if(msg!=""){
						alert(msg)
						location.href="${path}/chatting?empno="+empno
					}
				},
				error : function(err) {
					console.log(err)
				}
			})
		})
	});
</script>
<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<%@ include file="/z05_bootTmp/a02_sliderBar.jsp" %>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar    -->
				<%@ include file="/z05_bootTmp/a03_topBar.jsp" %>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">채팅</h1>
                        <button type="button" class="btn btn-secondary btn-icon-split" id="chatModal" data-toggle="modal" data-target="#exampleModalCenter">
                                <span class="icon text-white-50">
                                	<i class="fas fa-arrow-right"></i>
                            	</span>
                        	<span class="text">채팅방 생성</span>
                        </button>
                    </div>
                    <br>
                    <div class="row">
	                    <div id="chatroom-container">
	                    	<div id="scroll">
		                    	<table class="table table-bordered" id="roominfo">
		                            <caption>채팅방</caption>
		                            <tbody>
		                            	<c:forEach var = "cr" items="${crlist}">
		                                	<tr ondblclick="goChat(${cr.crno}, ${emp.empno})"><td>${cr.crname}</td></tr>
		                                </c:forEach>
		                        	</tbody>
		                    	</table>
		                    </div>
	                    </div>
	                    <div id="chat-container">
	                    		<!-- <div class="input-group mb-3">	
		<div class="input-group-prepend ">
			<span class="input-group-text  justify-content-center">
			아이디</span>
		</div>
		<input type="text" id="id" 
			class="form-control" placeholder="접속할 아이디 입력" />
		<input id="enterBtn" type="button" class="btn btn-info" value="채팅방입장" />
		<input id="exitBtn" type="button" class="btn btn-danger" value="채팅방나가기" />
				
	</div> -->
							<div id="chatArea" style="overflow-x:hidden" class="input-group-append"><input type="hidden" id="crno" /><input type="hidden" id="id" />
								<div class="input-group-append" id="chatName">
									<div id="chatGroup">선택된 채팅방 없음</div>
								</div>			
								<div id="chatMessageArea"></div>
								<div class="input-group align-items-end" >
									<input type="text" id="msg" class="form-control" placeholder="전송할 메시지 입력"/>
									<div class="input-group-append">
										<button type="button" id="sndBtn" class="btn btn-success">전송</button>
									</div>
								</div>
							</div>
						</div>
					</div>
					<script type="text/javascript">
						$("#mainBtn").click(function(){
							location.href=""
						})
					</script> 
				</div>
				<!-- /.container-fluid -->
				<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
					<div class="modal-dialog modal-dialog-centered" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="modalTitle">채팅방 생성</h5>
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body" align="center">
								<form id="frm02" class="form" method="post" action="${path}/makechatroom">
									<div class="input-group-prepend" style="width:200px !important;">
										<span class="justify-content-center" style="font-size:20px; width:100%">사원 리스트</span>
									</div>
									<div align="right">
										<input type="reset" class="btn btn-link btn-outline-light" style="background-color:none;" name="reset" value="선택 해제"/>
									</div>
									<div style="max-height: 400px; overflow-x: auto; font-size:17px;">
										<c:forEach var="e" items="${elist}">
											<br>
											<c:choose>
												<c:when test="${emp.empno == e.empno}">
													<label><input type="checkbox" name="chatter" class="checkSelect" value="${e.empno}" checked onClick="return false;"/> ${e.ename}</label>
												</c:when>
												<c:otherwise>
													<label><input type="checkbox" name="chatter" class="checkSelect" value="${e.empno}"/> ${e.ename}</label>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</div>
								</form>
							</div>
							<div class="modal-footer">
								<button id="okBtn" class="btn btn-primary" type="button">완료</button>
								<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; Your Website 2021</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> 
		<i class="fas fa-angle-up"></i>
	</a>
	<!-- Logout Modal-->
	<%@ include file="/z05_bootTmp/a08_logout_modal.jsp" %>
	
<!-- Bootstrap core JavaScript-->
    <script src="${path}/a00_com/vendor/jquery/jquery.min.js"></script>
<script
	src="${path}/a00_com/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="${path}/a00_com/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="${path}/a00_com/js/sb-admin-2.min.js"></script>

<script src="${path}/customjs/slidbar.js"></script>

</body>
</html>