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
	if("${emp}"==""){
	    alert("로그인후 이용해주세요")
		location.href="${path}/login"
	}

	var empno = "${emp.empno}"
	var name = "${emp.ename}(${emp.dname})"
	$(document).ready(function(){
		var msg = "${msg}"
		var msg2 = "${msg2}"
		var type = "${type}"
		if(msg!=""){
			alert(msg)
			$("#frmmet").submit()
		}
		if(msg2!=""){
			alert(msg2)
			$("#frm01").attr("action","${path}/detailmet")
			$("#frm01").submit()
		}
		if(type=="reg"){
			$("#page").text("회의록 등록")
			$("#regBtn").show();
			$("#uptBtn").hide();
		}else if(type=="upt"){
			$("#page").text("회의록 수정")
			$("#regBtn").hide();
			$("#uptBtn").show();
			$("#files").hide();
		}
		$("#regBtn").click(function(){
			if($("[name=metdte]").val()==""){
				alert("회의 날짜를 입력하세요")
				return;
			}
			if($("[name=starttm]").val()==""){
				alert("회의 시간을 입력하세요")
				return;
			}
			if($("[name=fintm]").val()==""){
				alert("회의 시간을 입력하세요")
				return;
			}
			if($("[name=participant]").val()==""){
				alert("참석자를 입력하세요")
				return;
			}
			if($("[name=title]").val()==""){
				alert("회의 목적을 입력하세요")
				return;
			}
			if($("[name=content]").val()==""){
				alert("회의 내용을 입력하세요")
				return;
			}
			if($("[name=conclusion]").val()==""){
				alert("회의 결론을 입력하세요")
				return;
			}
			if(confirm("등록하시겠습니까?")){
				$("#frm01").attr("action","${path}/insertmet")
				$("#frm01").submit()
			}
		})
		$("#uptBtn").click(function(){
			if($("[name=metdte]").val()==""){
				alert("회의 날짜를 입력하세요")
				return;
			}
			if($("[name=starttm]").val()==""){
				alert("회의 시간을 입력하세요")
				return;
			}
			if($("[name=fintm]").val()==""){
				alert("회의 시간을 입력하세요")
				return;
			}
			if($("[name=participant]").val()==""){
				alert("참석자를 입력하세요")
				return;
			}
			if($("[name=title]").val()==""){
				alert("회의 목적을 입력하세요")
				return;
			}
			if($("[name=content]").val()==""){
				alert("회의 내용을 입력하세요")
				return;
			}
			if($("[name=conclusion]").val()==""){
				alert("회의 결론을 입력하세요")
				return;
			}
			if(confirm("수정하시겠습니까?")){
				$("#frm01").attr("action","${path}/updatemet")
				$("#frm01").submit()
			}
		})
		$("#mainBtn").click(function(){
			$("#frmmet").submit()
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
                        <h1 class="h3 mb-0 text-gray-800" id="page">회의록 등록/수정</h1>
                        
                    </div>
					<br>
					<div align="center">
                    	<form method="post" id="frm01" enctype="multipart/form-data">
                    		<c:if test="${not empty umet}">
                    			<input type="hidden" name="metno" value="${umet.metno}"/>
                    		</c:if>
						<div class="input-group mb-0">	
							<div class="input-group-prepend ">
								<span class="input-group-text w-100 justify-content-center">회의 날짜</span>
							</div>
							<input type="date" name="metdteStr" class="form-control" value="${umet.metdteStr}" />	
							<div class="input-group-prepend ">
								<span class="input-group-text w-100 justify-content-center">작성자</span>
							</div>
							<c:choose>
								<c:when test="${not empty umet}">
									<input name="writer" class="form-control" value="${umet.ename}(${umet.dname})" readonly style="background-color:white !important;"/>	
									<input type="hidden" name="wempno" value="${umet.empno}" readonly />
									<input type="hidden" name="pcode" value="${param.pcode}" readonly />
								</c:when>
								<c:otherwise>
									<input name="writer" class="form-control" value="${emp.ename}(${emp.dname})" readonly style="background-color:white !important;"/>	
									<input type="hidden" name="wempno" value="${emp.empno}" readonly />
									<input type="hidden" name="pcode" value="${param.pcode}" readonly />
								</c:otherwise>
							</c:choose>
						</div>	
						<div class="input-group mb-0">	
							<div class="input-group-prepend ">
								<span class="input-group-text w-100 justify-content-center">회의 시간</span>
							</div>
							<input type="time" name="starttmStr" class="form-control" value="${umet.starttmStr}" placeholder="HH:mm"/>
							<span style="border-top: 1px solid #d2d2d2; border-bottom: 1px solid #d2d2d2; width:20px; background-color:white; line-height: 30px;"> ~ </span>	
							<input type="time" name="fintmStr" class="form-control" value="${umet.fintmStr}" placeholder="HH:mm"/>
						</div>			
						<div class="input-group mb-0">	
							<div class="input-group-prepend ">
								<span class="input-group-text w-100 justify-content-center">참석자</span>
							</div>
							<input name="participant" class="form-control" value="${umet.participant}" />	
						</div>			
						<div class="input-group mb-0">	
							<div class="input-group-prepend ">
								<span class="input-group-text w-100 justify-content-center">목적</span>
							</div>
							<input name="title" class="form-control" value="${umet.title}" />	
						</div>
						<div class="input-group mb-0" id="files">	
							<div class="input-group-prepend ">
								<span class="input-group-text w-100 justify-content-center">첨부파일</span>
							</div>
							<input type="file" name="reports" multiple="multiple" class="form-control" value="" />
						</div>
						<div class="input-group mb-0">	
							<div class="input-group-prepend ">
								<span class="input-group-text w-100 justify-content-center">회의 내용</span>
							</div>
							<textarea id="chatArea" name="content" class="form-control" style="height:400px;" >${umet.content}</textarea>	
						</div>	
						<div class="input-group mb-0">	
							<div class="input-group-prepend ">
								<span class="input-group-text w-100 justify-content-center">결론</span>
							</div>
							<textarea id="chatArea" name="conclusion" class="form-control" style="height:150px;" >${umet.conclusion}</textarea>	
						</div>	
						<br>
						<div style="text-align:center;">
							<input type="button" class="btn btn-success" value="등록" id="regBtn"/>
							<input type="button" class="btn btn-primary" value="수정" id="uptBtn"/>
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

<script src="${path}/customjs/slidbar.js"></script>

</body>
</html>