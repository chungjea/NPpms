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
	border: 1px solid green;
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
<script type="text/javascript">
	
</script>
</head>

<body>
	<div class="jumbotron text-center">
		<h2>공지등록</h2>

	</div>
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
				<input placeholder="관리자" name="writer" class="form-control" value="관리자" readonly/>
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
			<div style="text-align: right;">
				<input type="button" class="btn btn-success" value="등록" id="regBtn" />
				<input type="button" class="btn btn-info" value="게시글 조회"
					id="mainBtn" />
			</div>
			<script type="text/javascript">
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
				var msg = "${msg}"
				if (msg != "") {
					if (!confirm(msg + "\n계속 등록하시겠습니까?")) {
						location.href = "${path}/noticePage"
					}
				}
				$("#mainBtn").click(function() {
					location.href = "${path}/noticePage"
				})
			</script>
		</form>

	</div>
</body>
</html>