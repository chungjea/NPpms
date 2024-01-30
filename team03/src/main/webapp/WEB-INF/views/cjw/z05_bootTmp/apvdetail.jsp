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
	//var empno = ${mem.empno}
	//var name = ${mem.ename}+" / "+${mem.dname}
	var apvno = "${dapv.apvno}"
	var wempno = "${dapv.wempno}"
	var mempno = "${dapv.mempno}"
	var sts = "${dapv.sts}"
	$(document).ready(function(){
		$("#mainBtn").click(function(){
			location.href="${path}/myapv?wempno=1000&mempno=1000&sts="+sts
		})
		$("#okModal").click(function(){
			$("#modalTitle").text("승인 피드백")
			$("#okBtn").show();
			$("#noBtn").hide();
			$("#frm02 [name=apvno]").val(apvno)
			$("#frm02 [name=sts]").val("완료")
		})
		$("#noModal").click(function(){
			$("#modalTitle").text("반려 피드백")
			$("#noBtn").show();
			$("#okBtn").hide();
			$("#frm02 [name=apvno]").val(apvno)
			$("#frm02 [name=sts]").val("반려")
		})
		$("#okBtn").click(function(){
			apvajax()
		})
		$("#noBtn").click(function(){
			apvajax()
		})
		if(mempno==1000){
			$("#okModal").show();
			$("#noModal").show();
		}else{
			$("#okModal").hide();
			$("#noModal").hide();
		}
	});
	function apvajax(){
		$.ajax({
			type : "post",
			url : "${path}/doapv",
			data : $("#frm02").serialize(),
			dataType : "json",
			success : function(data) {
				$("#clsBtn").click()
				if(confirm(data.msg+"결재 홈으로 돌아가시겠습니까?")){
					location.href="${path}/myapv?wempno=1000&mempno=1000&sts="+sts
				}else{
					location.href="${path}/detailapv?apvno="+apvno
				}
				
			},
			error : function(err) {
				console.log(err)
			}
		})
	}
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
                        <h1 class="h3 mb-0 text-gray-800">결재 처리</h1>
                        
                    </div>
					<br><br>
					<div align="center">
                    	<form method="post" enctype="multipart/form-data" action="${path}/insertapv">
						<div class="input-group mb-0">	
							<div class="input-group-prepend ">
								<span class="input-group-text w-100 justify-content-center">제목</span>
							</div>
							<span class="form-control">${dapv.title}</span>
						</div>	
						<div class="input-group mb-0">	
							<div class="input-group-prepend ">
								<span class="input-group-text w-100 justify-content-center">작성자</span>
							</div>
							<span class="form-control">${dapv.writer}</span>	
							<div class="input-group-prepend ">
								<span class="input-group-text w-100 justify-content-center">등록일자</span>
							</div>
							<span class="form-control"><fmt:formatDate value="${dapv.regdte}" pattern="YYYY-MM-DD" type="date"/></span>	
						</div>	
						<div class="input-group mb-0">	
							<div class="input-group-prepend ">
								<span class="input-group-text w-100 justify-content-center">확인일자</span>
							</div>
							<span class="form-control"><fmt:formatDate value="${dapv.ckdte}" pattern="YYYY-MM-DD" type="date"/></span>
							<div class="input-group-prepend ">
								<span class="input-group-text w-100 justify-content-center">결재여부</span>
							</div>
							<span class="form-control">${dapv.sts}</span>		
						</div>
						<div class="input-group mb-0">	
							<div class="input-group-prepend ">
								<span class="input-group-text w-100 justify-content-center">첨부파일</span>
							</div>
							<c:if test="${not empty dapv.fnames}">
								<c:forEach var="fname" items="${dapv.fnames}">
									<span ondblclick="download('${fname}')" class="form-control">${fname}</span>	
								</c:forEach>
							</c:if>
							<c:if test="${empty dapv.fnames}">
								<span class="form-control"></span>
							</c:if>
						</div>	
						<div class="input-group mb-0">	
							<div class="input-group-prepend ">
								<span class="input-group-text w-100 justify-content-center">내용</span>
							</div>
							<div id="chatArea" class="form-control" style="height:200px;text-align:left;">${dapv.content}</div>	
						</div>
						<div class="input-group mb-0">	
							<div class="input-group-prepend ">
								<span class="input-group-text w-100 justify-content-center">피드백</span>
							</div>
							<div id="chatArea" class="form-control" style="height:200px;text-align:left;">${dapv.feedback}</div>	
						</div>
						<br>
						<div style="text-align:center;">
							<button id="okModal" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter" type="button">승인</button>
							&nbsp;
							<button id="noModal" class="btn btn-danger" data-toggle="modal" data-target="#exampleModalCenter" type="button">반려</button>
						</div>	
						<div style="text-align:right;">
							<input type="button" class="btn btn-info" value="목록" id="mainBtn"/>
						</div>
						</form>
					</div>
				</div>
				<!-- /.container-fluid -->
					<div class="modal fade" id="exampleModalCenter" tabindex="-1"
						role="dialog" aria-labelledby="exampleModalCenterTitle"
						aria-hidden="true">
						<div class="modal-dialog modal-dialog-centered" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="modalTitle">피드백</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body" align="center">
									<form id="frm02" class="form" method="post">
										<div class="row">
											<div class="col">
												<input type="hidden" name="apvno" value="${dapv.apvno}"/>
												<textarea class="form-control" placeholder="피드백 입력" name="feedback"> </textarea>
												<input type="hidden" name="sts" value=""/>
											</div>
										</div>
									</form>
								</div>
								<div class="modal-footer">
									<button id="okBtn" class="btn btn-primary" type="button">승인</button>
									<button id="noBtn" class="btn btn-danger" type="button">반려</button>
									<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
								</div>
							</div>
						</div>
					</div>
			</div>
			<!-- End of Main Content -->
			<script type="text/javascript">
				function download(fname){
					if(confirm(fname+" 다운로드 하시겠습니까?")){
						location.href="${path}/download?fname="+fname
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

<!-- Page level plugins -->
<script src="${path}/a00_com/vendor/chart.js/Chart.min.js"></script>

<!-- Page level custom scripts -->
<script src="${path}/a00_com/js/demo/chart-area-demo.js"></script>
<script src="${path}/a00_com/js/demo/chart-pie-demo.js"></script>	
</body>
</html>