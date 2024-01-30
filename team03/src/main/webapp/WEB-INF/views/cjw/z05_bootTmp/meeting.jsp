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
</style> 
 
     <!-- Custom fonts for this template-->
    <link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">
 
 
 
</head>
<script type="text/javascript">
	//var empno = "${mem.empno}"
	//var name = "${mem.ename} / ${mem.dname}"
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
                        <h1 class="h3 mb-0 text-gray-800">회의록</h1>
                        <a href="${path}/insertmetFrm.do3" class="btn btn-secondary btn-icon-split">
                                <span class="icon text-white-50">
                                	<i class="fas fa-arrow-right"></i>
                            	</span>
                        	<span class="text">회의록 작성하기</span>
                        </a>
                    </div>
					
					<br>
					<br>
                    <table class="table table-hover table-striped">
					   	<col width="15%">
					   	<col width="22%">
					   	<col width="21%">
					   	<col width="20%">
					   	<col width="22%">
					    <thead>
					      <tr class="text-center" style="background-color:skyblue;">
					        <th>No</th>
					        <th>회의 날짜</th>
					        <th>회의 목적</th>
					        <th>작성자</th>
					        <th>등록 날짜</th>
					      </tr>
					    </thead>	
					    <tbody>
					    	<c:forEach var="met" items="${metList}">
					    		<tr ondblclick="goDetail(${met.metno})"><td>${met.metno}</td><td><fmt:formatDate value="${met.metdte}"/></td><td>${met.title}</td><td>${met.writer}</td><td><fmt:formatDate value="${met.regdte}"/></td></tr>
					    	</c:forEach>
					    </tbody>
					</table>
					<form method="post" id="frm02" action="${path}/detailmet.do3">
						<input id="test" name="metno" type="hidden">
					</form>
					<script type="text/javascript">
					    function goDetail(no){
					    	$("#test").val(no)
					    	$("#frm02").submit()
					    }
					</script>
					<form method="get" id="frm03">
						<input type="hidden" name="curPage" value="${sch.curPage}"/>
						<input type="hidden" name="deptno" value="10"/>
					</form>
					<ul class="pagination  justify-content-center">
						<li class="page-item">
						<a class="page-link" href="javascript:goPage(${sch.startBlock-1})">Previous</a></li>
						<c:forEach var="pcnt" begin="${sch.startBlock}" end="${sch.endBlock}">
							<li class="page-item ${sch.curPage==pcnt?'active':''}">
							<a class="page-link" href="javascript:goPage(${pcnt})">${pcnt}</a></li>
						</c:forEach>
						<li class="page-item"><a class="page-link" href="javascript:goPage(${sch.endBlock+1})">Next</a></li>
					</ul>
					<script type="text/javascript">
						function goPage(pcnt){
							$("[name=curPage]").val(pcnt)
							$("#frm03").submit();
						}
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

</body>
</html>