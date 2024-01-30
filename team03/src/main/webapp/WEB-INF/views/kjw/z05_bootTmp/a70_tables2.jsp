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
	var empno = ${mem.empno}
	var name = ${mem.ename}+" / "+${mem.dname}
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
                        <h1 class="h3 mb-0 text-gray-800">결재</h1>
                        <a href="${path}/insertapvFrm.do3" class="btn btn-secondary btn-icon-split">
                                <span class="icon text-white-50">
                                	<i class="fas fa-arrow-right"></i>
                            	</span>
                        	<span class="text">결재 작성하기</span>
                        </a>
                    </div>

                    <div class="row">
                        <div class="col-xl-3 col-md-6 mb-4" style="background-color:white; border:1px solid black;">
                        	<div class="card-body">
                            	<div class="row no-gutters align-items-center">
                                	<div class="col mr-2">
                                    	<div class="text-xs font-weight-bold text-uppercase mb-1">
                                        	상신한</div>
                                        <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">${myapvcnt}건</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="col-xl-3 col-md-6 mb-4" style="background-color:white; border:1px solid black;">
                        	<div class="card-body">
                            	<div class="row no-gutters align-items-center">
                                	<div class="col mr-2">
                                    	<div class="text-xs font-weight-bold text-uppercase mb-1">
                                        	반려된</div>
                                        <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">${badapvcnt}건</div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-xl-3 col-md-6 mb-4" style="background-color:white; border:1px solid black;">
                        	<div class="card-body">
                            	<div class="row no-gutters align-items-center">
                                	<div class="col mr-2">
                                    	<div class="text-xs font-weight-bold text-uppercase mb-1">
                                        	완료된</div>
                                        <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">${goodapvcnt}건</div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-xl-3 col-md-6 mb-4" style="background-color:white; border:1px solid black;">
                        	<div class="card-body">
                            	<div class="row no-gutters align-items-center">
                                	<div class="col mr-2">
                                    	<div class="text-xs font-weight-bold text-uppercase mb-1">
                                        	결제할</div>
                                        <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">${toapvcnt}건</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
					<br>
					<br>
					<br>
                    <div class="row">
                    	&nbsp;&nbsp;&nbsp;
                    	<a class="page-link" id="mysubmit" href="javascript:goPage('대기')">상신한 문서</a>
                    	<a class="page-link" id="return" href="javascript:goPage('반려')">반려된 문서</a>
                    	<a class="page-link" id="tocheck" href="javascript:goPage2()">결재할 문서</a>
                    	<a class="page-link" id="finish" href="javascript:goPage('완료')">완료된 문서</a>
                    </div>
                    <script type="text/javascript">
	                    function goPage(sts){
	            			location.href="${path}/myapv.do3?wempno=1000&mempno=1000&sts="+sts
	            		}
	                    function goPage2(){
	            			location.href="${path}/ckapv.do3?wempno=1000&mempno=1000"//+empno
	            		}
	                	function goDetail(apvno){
	                		location.href="${path}/detailapv.do3?apvno="+apvno
	                	}
                    </script>
                    <br>
                    <table class="table table-hover table-striped">
					   	<col width="15%">
					   	<col width="25%">
					   	<col width="20%">
					   	<col width="20%">
					   	<col width="20%">
					    <thead>
					      <tr class="text-center" style="background-color:skyblue;">
					        <th>결재 상태</th>
					        <th>제목</th>
					        <th>기안자</th>
					        <th>결재자</th>
					        <th>상신한 날짜</th>
					      </tr>
					    </thead>	
					    <tbody>
					    	<c:forEach var="emp" items="${emplist}">
					    		<tr ondblclick="goDetail(${emp.empno})"><td>${emp.ename}</td><td>${emp.egrade}</td><td>${emp.deptno}</td><td>${emp.salary}</td><td><fmt:formatDate value="${emp.hiredate}"/></td></tr>
					    	</c:forEach>
					    </tbody>
					</table>
 					
 					<ul class="pagination justify-content-center">
					  <li class="page-item"><a class="page-link" href="#">Previous</a></li>
					  <li class="page-item"><a class="page-link" href="#">1</a></li>
					  <li class="page-item"><a class="page-link" href="#">2</a></li>
					  <li class="page-item"><a class="page-link" href="#">3</a></li>
					  <li class="page-item"><a class="page-link" href="#">Next</a></li>
					</ul>
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

<%-- <!-- Page level plugins -->
<script src="${path}/a00_com/vendor/chart.js/Chart.min.js"></script>

<!-- Page level custom scripts -->
<script src="${path}/a00_com/js/demo/chart-area-demo.js"></script>
<script src="${path}/a00_com/js/demo/chart-pie-demo.js"></script> --%>	
</body>
</html>