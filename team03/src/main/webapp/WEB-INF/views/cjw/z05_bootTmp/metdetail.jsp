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
	span{text-align:left;}
	form{width: 70% !important; align-self: center !important; border-radius: 1% !important;}
	.input-group-prepend{width:80px !important;}
	/*
	.input-group-text{width:100%;background-color:linen;color:black;font-weight:bolder;}
	.input-group-prepend{width:20%;}
	#chatArea{
		width:80%;height:200px;overflow-y:auto;text-align:left;
		border:1px solid green;
	}
	*/
</style> 
 
     <!-- Custom fonts for this template-->
    <link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">
 
 
 
</head>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	//var empno = "${mem.empno}""
	//var name = "${mem.ename} / ${mem.dname}"
	var empno = "1000"
	var wempno = "${dmet.wempno}"
	$(document).ready(function(){
		var msg = "${msg}"
		if(msg!=""){
			alert(msg)
			location.href="${path}/meeting?deptno=10"
		}
		if(empno!=wempno){
			$("#uptBtn").hide();
			$("#delBtn").hide();
		}else{
			$("#uptBtn").show();
			$("#delBtn").show();
		}
		$("#mainBtn").click(function(){
			location.href="${path}/meeting?deptno=10"
		})
		$("#uptBtn").click(function(){
			$("#frm01").attr("action","${path}/updatemetFrm")
			$("#frm01").submit()
		})
		$("#delBtn").click(function(){
			$("#frm01").attr("action","${path}/deletemet")
			$("#frm01").submit()
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
                        <h1 class="h3 mb-0 text-gray-800">회의록 상세</h1>
                        
                    </div>
					<br>
					<div align="center">
                    	<form method="post" id="frm01" enctype="multipart/form-data">
                    	<input type="hidden" name="metno" value="${dmet.metno}"/>
						<div class="input-group mb-0">	
							<div class="input-group-prepend ">
								<span class="input-group-text w-100 justify-content-center">회의 날짜</span>
							</div>
							<span class="form-control">${dmet.metdteStr}</span>	
							<div class="input-group-prepend ">
								<span class="input-group-text w-100 justify-content-center">회의 시간</span>
							</div>
							<span class="form-control">${dmet.starttmStr} ~ ${dmet.fintmStr}</span>	
						</div>	
						<div class="input-group mb-0">	
							<div class="input-group-prepend ">
								<span class="input-group-text w-100 justify-content-center">등록 날짜</span>
							</div>
							<span class="form-control"><fmt:formatDate value="${dmet.regdte}" pattern="yyyy-MM-dd" type="date"/></span>	
							<div class="input-group-prepend ">
								<span class="input-group-text w-100 justify-content-center">작성자</span>
							</div>
							<span class="form-control">${dmet.writer}</span>	
						</div>	
						<div class="input-group mb-0">	
							<div class="input-group-prepend ">
								<span class="input-group-text w-100 justify-content-center">참석자</span>
							</div>
							<span class="form-control">${dmet.participant}</span>	
						</div>
						<div class="input-group mb-0">	
							<div class="input-group-prepend ">
								<span class="input-group-text w-100 justify-content-center">목적</span>
							</div>
							<span class="form-control">${dmet.title}</span>
						</div>
						<div class="input-group mb-0">	
							<div class="input-group-prepend ">
								<span class="input-group-text w-100 justify-content-center">첨부파일</span>
							</div>
							<c:choose>
								<c:when test="${not empty dmetfile}">
									<c:forEach var="mf" items="${dmetfile}">
										<span ondblclick="download('${mf.fno}','${mf.fname}')" class="form-control">${mf.fname}</span>	
									</c:forEach>
								</c:when>
								<c:otherwise>
									<span class="form-control"></span>
								</c:otherwise>
							</c:choose>
						</div>	
						<div class="input-group mb-0">	
							<div class="input-group-prepend ">
								<span class="input-group-text w-100 justify-content-center">회의 내용</span>
							</div>
							<div id="chatArea" class="form-control" style="height:200px;text-align:left;">${dmet.content}</div>	
						</div>
						<div class="input-group mb-0">	
							<div class="input-group-prepend ">
								<span class="input-group-text w-100 justify-content-center">결론</span>
							</div>
							<div id="chatArea" class="form-control" style="height:80px;text-align:left;">${dmet.conclusion}</div>	
						</div>
						<br>
						<div style="text-align:center;">
							<input type="button" class="btn btn-primary" value="수정" id="uptBtn"/>
							<input type="button" class="btn btn-danger" value="삭제" id="delBtn"/>
						</div>	
						<div style="text-align:right;">
							<input type="button" class="btn btn-info" value="목록" id="mainBtn"/>
						</div>
						</form>
					</div>
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- End of Main Content -->
			<script type="text/javascript">
				function download(fno, fname){
					if(confirm(fname+" 다운로드 하시겠습니까?")){
						location.href="${path}/download?fno="+fno
					}
				}
			</script>
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