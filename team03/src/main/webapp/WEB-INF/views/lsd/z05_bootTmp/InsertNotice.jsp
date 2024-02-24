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
<style type="text/css">
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
	height: 200px;
	overflow-y: auto;
	text-align: left;
}
</style>
 <!-- Custom fonts for this template-->
    <link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script
	src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api"
	type="text/javascript"></script>
<script type="text/javascript">
	
</script>
</head>

<body id="page-top">
	<div id="wrapper">
	<!-- Sidebar -->
		<%@ include file="/z05_bootTmp/a02_sliderBar.jsp"%>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar    -->
				<%@ include file="/z05_bootTmp/a03_topBar.jsp"%>
				<!-- End of Topbar -->
				<div
					class="d-sm-flex align-items-center justify-content-between mb-4">
					<h1 class="h3 mb-0 text-gray-800">공지등록</h1>

				</div>
	
	<!--  <div class="jumbotron text-center">
		<h2>공지등록</h2>

	</div>-->
	<%-- 
기본 게시판 등록 + 답글 등록		
--%>
	<div class="container">
		<form method="post" enctype="multipart/form-data"
			action="${path}/insertNotice">
			<%-- <div class="input-group mb-3">	
		<div class="input-group-prepend ">
			<span class="input-group-text  justify-content-center">
				공지번호</span>
		</div>
		<input name="notice_num" class="form-control" value=board_seq/>	
	</div>--%>
			<input type="hidden" name="pcode" value="${param.pcode}" />
			<%-- <input type="hidden" name="dname" value="${emp.dname}" />--%>
			<div class="input-group mb-0">
				<div class="input-group-prepend ">
					<span class="input-group-text  justify-content-center"> 글제목</span>
				</div>
				<input name="title" class="form-control" value="${notice.title}" />
			</div>

			<div class="input-group mb-0">
				<div class="input-group-prepend ">
					<span class="input-group-text  justify-content-center"> 작성자</span>
				</div>
				<input placeholder="관리자" name="writer" class="form-control" value="${emp.ename}" readonly/>
			</div>

			<div class="input-group mb-0">
				<div class="input-group-prepend ">
					<span class="input-group-text  justify-content-center"> 글내용</span>
				</div>
				<textarea id="chatArea" name="content" class="form-control">${notice.content}</textarea>
			</div>
			<div class="input-group mb-0">
				<div class="input-group-prepend ">
					<span class="input-group-text  justify-content-center"> 첨부파일</span>
				</div>
				<input type="file" name="reports" multiple="multiple"
					class="form-control" value="" />
			</div>
			<div style="text-align: right; margin-top: 20px;">
				<input type="button" class="btn btn-success" value="등록" id="regBtn" />
				<input type="button" class="btn btn-info" value="게시글 조회"
					id="mainBtn" />
			</div>
			<script type="text/javascript">
			var pcode = $("[name=pcode]").val();
			var msg = "${msg}"
			
				if (msg === '등록성공') {
					if (!confirm("등록되었습니다.")) {
						location.href = "${path}/noticePage?pcode=" + pcode
					}
				}
			
				$("#regBtn").click(function() {
					<%--if (confirm("등록하시겠습니까?")) {
						if ($("[name=writer]").val() == "") {
							alert("한글/영어로 입력하세요")
							return;
						}
						$("form").submit()
					}--%>
					$("form").submit()
				})
				

				$("#mainBtn").click(function() {
					location.href = location.href = "${path}/noticePage?pcode=" + pcode
				})
			</script>
		</form>

	</div>
</div>
	<%@ include file="/z05_bootTmp/a08_logout_modal.jsp" %>
	<script src="${path}/customjs/slidbar.js"></script>
</body>
</html>