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
	form{width: 70% !important; align-self: center !important; border-radius: 1% !important;}
	.input-group-prepend{width:80px !important;}
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
	$(document).ready(function(){
		var msg = "${msg}"
		if(msg!=""){
			alert(msg)
			$("#frmrsk").submit()
		}		
		$("#regBtn").click(function(){
			if($("[name=title]").val()==""){
				alert("제목을 입력하세요")
				return;
			}
			if($("[name=content]").val()==""){
				alert("내용을 입력하세요")
				return;
			}
			if(confirm("등록하시겠습니까?")){
				$("form").submit()				
			}
		})
		$("#mainBtn").click(function(){
			$("#frmrsk").submit()
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
                        <h1 class="h3 mb-0 text-gray-800">리스크 등록</h1>
                        
                    </div>
					<br>
					<div align="center">
                    	<form method="post" enctype="multipart/form-data" action="${path}/insertrsk">
						<div class="input-group mb-0">	
							<div class="input-group-prepend ">
								<span class="input-group-text w-100 justify-content-center">제목(*)</span>
							</div>
							<input name="title" class="form-control" value="" />	
						</div>	
						<div class="input-group mb-0">	
							<div class="input-group-prepend ">
								<span class="input-group-text w-100 justify-content-center">작성자(*)</span>
							</div>
							<input name="writer" class="form-control" value="홍길동 / 전산팀" readonly/>	
							<input type="hidden" name="wempno" value=1000 readonly />
							<input type="hidden" name="manager" value=1003 readonly />
						</div>			
						<div class="input-group mb-0">	
							<div class="input-group-prepend ">
								<span class="input-group-text w-100 justify-content-center">가능성(*)</span>
							</div>
							<select name="probability" class="form-control">
								<option value="최상">최상</option>
								<option value="상">상</option>
								<option value="중">중</option>
								<option value="하">하</option>
								<option value="최하">최하</option>
							</select>	
							<div class="input-group-prepend ">
								<span class="input-group-text w-100 justify-content-center">위험도(*)</span>
							</div>
							<select name="danger" class="form-control">
								<option value="최상">최상</option>
								<option value="상">상</option>
								<option value="중">중</option>
								<option value="하">하</option>
								<option value="최하">최하</option>
							</select>
						</div>
						<div class="input-group mb-0">	
							<div class="input-group-prepend ">
								<span class="input-group-text w-100 justify-content-center">첨부파일</span>
							</div>
							<input type="file" name="reports" multiple="multiple" class="form-control" value="" />
						</div>
						<div class="input-group mb-0">	
							<div class="input-group-prepend ">
								<span class="input-group-text w-100 justify-content-center">내용</span>
							</div>
							<textarea id="chatArea" name="content" class="form-control" style="height:400px;" > </textarea>	
						</div>	
						<br>
						<div style="text-align:center;">
							<input type="button" class="btn btn-success" value="등록" id="regBtn"/>
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

<script src="${path}/customjs/slidbar.js"></script>

</body>
</html>