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

<!-- 여기서부터 내꺼 -->
<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script
	src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api"
	type="text/javascript"></script>
<script type="text/javascript">
	var proc = "${proc}"
	var msg = "${msg}"
	if (proc != "") {
		if (proc == "upt") {
			if (confirm(msg + "\n메인화면으로 이동하시겠습니까?")) {
				location.href = "${path}/noticePage"
			}
		}
		if (proc == "del") {
			alert(msg)
			location.href = "${path}/noticePage"
		}
	}

	$(document).ready(function() {
		$("#mainBtn").click(function() {
			location.href = "${path}/noticePage"
		})
		var sessId = "${emp.auth}"
		$("#uptBtn").click(function() {
			/*var writer = $("[name=writer]").val()
			// 수정권한에 대한 check
			// 로그인 인증 후, session에 있는 id값과 비교해서,
			// 작성자의 id와 비교해서 같을 때만 수정 가능 처리
			if(sessId!=writer){
				alert("수정은 관리자만 가능합니다.")
				return
			}*/
			// 수정처리하는 controller    		 
			$("form").attr("action", "${path}/updateNotice")
			$("form").submit()
		})

		/*deleteBoard?no=10*/

		$("#delBtn").click(function() {
			/*var writer = $("[name=writer]").val()
			if(sessId!=writer){
				alert("삭제는 관리자만 가능합니다.")
				return
			}*/
			var no = $("[name=notice_num]").val()
			if (confirm("삭제하시겠습니까?")) {
				location.href = "${path}/deleteNotice?no=" + no
			}
		})

		$("#insBtn").click(function() {
			/*var writer = $("[name=writer]").val()
			if(sessId!=writer){
				alert("등록은 관리자만 가능합니다.")
				return
			}*/
			var no = $("[name=notice_num]").val()
			if (confirm("등록하시겠습니까?")) {
				location.href = "${path}/InsertBoard"
			}
		})
	});
</script>
</head>

<body>
	<div class="jumbotron text-center">
		<h2>공지 세부사항</h2>

	</div>
	<%-- 
Noticeboard_f 
private int notice_num;
private String title;	
private String writer;
private String content;
private Date regDate;
private Date updateDate;
	
--%>
	<div class="container">
		<form method="post">
			<div class="input-group mb-0">
				<div class="input-group-prepend ">
					<span class="input-group-text  justify-content-center"> 공지번호</span>
				</div>
				<input name="notice_num" class="form-control" readonly
					value="${notice.notice_num}" />
				<div class="input-group-prepend ">
					<span class="input-group-text  justify-content-center"> 작성자</span>
				</div>
				<input name="writer" class="form-control" readonly
					value="${notice.writer}" />
			</div>
			<!-- 제목 : 한칸크게 -->
			<div class="input-group mb-0">
				<div class="input-group-prepend ">
					<span class="input-group-text  justify-content-center"> 제목</span>
				</div>
				<input name="title" class="form-control" value="${notice.title}" />
			</div>
			<div class="input-group mb-0">
				<div class="input-group-prepend ">
					<span class="input-group-text  justify-content-center"> 등록일</span>
				</div>
				<input type="date" class="form-control"
					value='<fmt:formatDate value="${notice.regDate}" 
				pattern="yyyy-MM-dd"/>'
					readonly />
				<div class="input-group-prepend ">
					<span class="input-group-text  justify-content-center"> 수정일</span>
				</div>
				<input type="date" class="form-control"
					value='<fmt:formatDate value="${notice.updateDate}" 
				pattern="yyyy-MM-dd"/>'
					readonly />
			</div>
			<div class="input-group mb-0">
				<div class="input-group-prepend ">
					<span class="input-group-text  justify-content-center"> 공지내용</span>
				</div>
				<textarea id="chatArea" name="content" class="form-control">${notice.content}
		</textarea>
			</div>
			<div class="input-group mb-0">
				<div class="input-group mb-0">
					<div class="input-group-prepend ">
						<span class="input-group-text  justify-content-center">
							첨부파일</span>
					</div>
					<c:forEach var="nf" items="${noticeFile}">
						<span ondblclick="download('${nf.fno}','${nf.fname}')"
							class="form-control">${nf.fname}</span>
					</c:forEach>
				</div>

			</div>
			<script type="text/javascript">
				function download(fno, fname) {
					if (confirm(fname + " 다운로드 하시겠습니까?")) {
						location.href = "${path}/downloadNotice?fno=" + fno
					}
				}
			</script>
			<div style="text-align: right;  margin-top: 20px;">
				<c:if test="${emp.auth eq '관리자'}">
					<input type="button" class="btn btn-warning" value="수정" id="uptBtn" />
					<input type="button" class="btn btn-danger" value="삭제" id="delBtn" />
				</c:if>
				<input type="button" class="btn btn-success" value="전체공지"
					id="mainBtn" />
			</div>
		</form>

	</div>
</body>
</html>