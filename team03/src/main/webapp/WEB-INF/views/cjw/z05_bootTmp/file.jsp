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
	table caption {
	    caption-side: top;
	    text-align: center;
	    font-size: x-large;
	    padding: 10px;
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
                        <h1 class="h3 mb-0 text-gray-800">문서관리</h1>
                        <a href="${path}/insertmetFrm" class="btn btn-secondary btn-icon-split">
                                <span class="icon text-white-50">
                                	<i class="fas fa-arrow-right"></i>
                            	</span>
                        	<span class="text">파일 업로드</span>
                        </a>
                    </div>
					<br>
					<br>
                    <div align="center">
                    	&nbsp;&nbsp;&nbsp;
                    <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search"
								id="frm01" class="form" method="get">
						<div class="input-group align-items-end" >
							<select class="form-control border-0 small" style="width:120px;" name="type">
								<option value="fname">파일명</option>
								<option value="page">파일위치</option>
							</select>
							<input class="form-control border-0 small" style="width:400px;" placeholder="파일명" name="fname" id="sch" value="${sch.fname}">
							<input type="hidden" name="empno" value="${sch.empno}"/>
							<input type="hidden" name="deptno" value="${sch.deptno}"/>
							<div class="input-group-append">
								<button class="btn btn-primary" type="button" id="schBtn">
									<i class="fas fa-search fa-sm"></i>
								</button>
							</div>
						</div>
					</form>
                    </div>
                    <script type="text/javascript">
	                    $("#schBtn").click(function(){
	                   		schfile()
		                 })
		                 $("#sch").keyup(function(){
								if(event.keyCode==13){
									schfile()
								}
		                  })
		                  function schmet(){
	                    		$("#frm01").attr("action","${path}/file")
		    					$("#frm01").submit()
		                  }
                    </script>
                    <br><br><br>
                    <div class="row" style="width:100%;">
                    	<div style="width:33%; border-right: solid 1px;">
	                    	<table class="table table-hover table-striped" style="width:80%; margin: auto;">
	                    		<caption>게시판</caption>
							   	<col width="50%">
							   	<col width="50%">
							    <thead>
							      <tr class="text-center" style="background-color:skyblue;">
							        <th>파일명</th>
							        <th>파일위치</th>
							      </tr>
							    </thead>	
							    <tbody>
							    	<tr><td>1</td><td>2</td></tr>
							    </tbody>
							</table>
						</div>
						<div style="width:33%; border-right: solid 1px;">
							<table class="table table-hover table-striped" style="width:80%; margin: auto;">
								<caption>채팅</caption>
							   	<col width="50%">
							   	<col width="50%">
							    <thead>
							      <tr class="text-center" style="background-color:skyblue;">
							        <th>파일명</th>
							        <th>파일위치</th>
							      </tr>
							    </thead>	
							    <tbody>
							    	<tr><td>1</td><td>2</td></tr>
							    </tbody>
							</table>
						</div>
						<div style="width:33%;">
							<table class="table table-hover table-striped" style="width:80%; margin: auto;">
								<caption>개인</caption>
							   	<col width="50%">
							   	<col width="50%">
							    <thead>
							      <tr class="text-center" style="background-color:skyblue;">
							        <th>파일명</th>
							        <th>파일위치</th>
							      </tr>
							    </thead>	
							    <tbody>
							    	<tr><td>1</td><td>2</td></tr>
							    </tbody>
							</table>
						</div>
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

</body>
</html>