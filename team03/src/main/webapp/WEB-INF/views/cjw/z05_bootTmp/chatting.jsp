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
	td{text-align:center;}
	.jumbotron{padding:2%;}
	.input-group-text{width:100%;
		color:black;font-weight:bolder;}
	.input-group-prepend{width:20%;}
	#chatArea{
		width:80%;height:200px;overflow-y:scroll;text-align:left;
		border:1px solid green;
		padding-right: 15px;
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
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	//var empno = "${mem.empno}"
	//var name = "${mem.ename} / ${mem.dname}"
		// 화면 크기에 따라 동적으로 조절 처리
	window.addEventListener("resize",function(){
		$("#chatMessageArea>div").width(
				$("#chatArea").width()-5)
	})
	$(document).ready(function(){
		var wsocket = null;
		$("#enterBtn").click(function(){
			var idVal = $("#id").val()
			wsocket = new WebSocket(
				"ws:localhost:5050/chat"	
			)
			// 주의: localhost:로 현재 pc로 완료가 되었으면 서버(공유아이피주소설정)
			// 업로드 후, 서버에서 잘 작동되는지 확인..
			
			wsocket.onopen = function(evt){
				console.log(evt)
				
				wsocket.send(idVal+":접속하셨습니다!")
			}
			wsocket.onmessage = function(evt){
				// 서버에서 push 접속한 모든 client에 전송..
				revMsg(evt.data) // 메시지 처리 공통 함수 정의				
			}
		})
		
		function revMsg(msg){
			// 보내는 메시지는 오른쪽
			// 받는 메시지는 왼쪽 정렬 처리 : 사용자아이디:메시지 내용
			var alignOpt = "left"
			var msgArr = msg.split(":") // 사용자명:메시지 구분 하여 처리..
			var sndId = msgArr[0] // 보내는 사람 메시지 id
			if($("#id").val()==sndId){ 
				// 보내는 사람과 받는 사람의 아이디 동일:현재 접속한 사람이 보낸 메시지 
				alignOpt = "right"
				msg = msgArr[1] // 받는 사람 아이디 생략 처리
			}
			var msgObj = $("<div></div>").text(msg).attr("align",
					alignOpt).css("width",$("#chatArea").width())
			$("#chatMessageArea").append(msgObj);
			
			// 스크롤링 처리..
			// 1. 전체 해당 데이터의 높이를 구한다.
			// 2. 포함하고 있는 부모 객체(#chatArea)에서
			//    스크롤 기능 메서드로 스크롤되게 처리한다. scrollTop()
			var height = parseInt($("#chatMessageArea").height())
			mx += height+20
			$("#chatArea").scrollTop(mx)

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
		$("#exitBtn").click(function(){
			if(confirm("접속을 종료하시겠습니까?")){
				wsocket.close()
			}
		})
		function sendMsg(){
			wsocket.send($("#id").val()+":"+$("#msg").val())
			$("#msg").val("")			
		}
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
                        <h1 class="h3 mb-0 text-gray-800">채팅방</h1>
                    </div>
                    <br>
                    <div class="input-group mb-3">	
						<div class="input-group-prepend ">
							<span class="input-group-text  justify-content-center">아이디</span>
						</div>
						<input type="text" id="id" class="form-control" placeholder="접속할 아이디 입력" />
						<input id="enterBtn" type="button" class="btn btn-info" value="채팅방입장" />
						<input id="exitBtn" type="button" class="btn btn-danger" value="채팅방나가기" />
					</div>	
					<div class="input-group mb-3">	
						<div class="input-group-prepend ">
							<span class="input-group-text  justify-content-center">접속자</span>
						</div>
						<div class="input-group-append" id="chatM">
							<div id="chatGroup"></div>
						</div>			
					</div>
					<div class="input-group mb-3">	
						<div class="input-group-prepend ">
							<span class="input-group-text  justify-content-center">메시지</span>
						</div>
						<div id="chatArea" style="overflow-x:hidden" class="input-group-append">
							<div id="chatMessageArea"></div>
						</div>
					</div>		
					<div class="input-group mb-3">	
						<div class="input-group-prepend ">
							<span class="input-group-text  justify-content-center">메시지</span>
						</div>
						<input type="text" id="msg" class="form-control" placeholder="전송할 메시지 입력"/>
						<input type="button" id="sndBtn" class="btn btn-success" value="메시지전송" />	
					</div>		
					<%--
					<div class="input-group mb-3">
						<div class="input-group-prepend ">
							<span class="input-group-text  justify-content-center">기타기능</span>
						</div>
						<input type="button" class="btn btn-info" value="수정" id="uptBtn"/>
						<input type="button" class="btn btn-danger" value="삭제" id="delBtn"/>
						<input type="button" class="btn btn-success" value="조회리스트" id="mainBtn"/>
					</div>
					 --%>	
					<script type="text/javascript">
						$("#mainBtn").click(function(){
							location.href="${path}/deptList02.do"
						})
					</script>
				</div>
				<!-- /.container-fluid -->
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