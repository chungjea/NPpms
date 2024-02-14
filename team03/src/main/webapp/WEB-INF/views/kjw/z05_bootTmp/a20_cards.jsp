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






<%
Date time1 = new Date();
SimpleDateFormat formatter1 = new SimpleDateFormat(
		"YYYY-MM-DD: (E) hh:mm:ss",Locale.KOREA
		);
long lasttime1=session.getLastAccessedTime();
long createdtime1=session.getCreationTime();
var empno = "${emp.empno}";
var ename = "${emp.ename}";

%>




<!-- Custom fonts for this template-->
<link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">



</head>
<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<%@ include file="/z05_bootTmp/a02_sliderBar.jsp"%>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar    -->
				<%@ include file="z05_bootTmp/a03_topBar.jsp"%>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">Cards</h1>
					</div>

					<div class="row">

						<!-- Earnings (Monthly) Card Example -->
						<div class="col-xl-3 col-md-6 mb-4">
							<div class="card border-left-primary shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-xs font-weight-bold text-primary text-uppercase mb-1">
												근태관리</div>
											<div class="card-body"><%=formatter1.format(time1)%></div>
											<div class="h5 mb-0 font-weight-bold text-gray-800">0h0m</div>
											<div class="progress progress-sm mr-2"></div>

											<div class="h5 mb-0 font-weight-bold text-gray-800">출근시간
												&nbsp &nbsp &nbsp &nbsp :${commute.starttime}</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800">퇴근시간
												&nbsp &nbsp &nbsp &nbsp :${commute.endtime}</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800">야근시간
												&nbsp &nbsp &nbsp &nbsp :${commute.overtime}</div>
											<hr
												style="border-width: 1px 0 0 0; border-style: dotted; border-color: #bbb;">
											<form method="post" id="send" action="${path}/commute_s"
												class="btn btn-light btn-icon-split">
												<a href="${path}/commute_s" id="StartBtn"
													class="btn btn-light btn-icon-split"> <span
													class="text">&nbsp &nbsp &nbsp &nbsp출근&nbsp &nbsp
														&nbsp &nbsp</span>
												</a> <input type="hidden" name="empno" value="${emp.empno}">
												<input type="hidden" name="ename" value="${emp.ename}">


											</form>
											<form method="post" id="send" action="${path}/ECommute"
												class="btn btn-light btn-icon-split">
												<a href="#" id="EndBtn" class="btn btn-light btn-icon-split">

													<span class="text">&nbsp &nbsp &nbsp &nbsp퇴근&nbsp
														&nbsp &nbsp &nbsp </span>
												</a>
											</form>
										</div>


									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="row">

						<div class="col-lg-6">

							<!-- Default Card Example -->
							<div class="card mb-4">
								<div class="card-header">Default Card Example</div>
								<div class="card-body">This card uses Bootstrap's default
									styling with no utility classes added. Global styles are the
									only things modifying the look and feel of this default card
									example.</div>
							</div>

							<!-- Basic Card Example -->
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary">Basic Card
										Example</h6>
								</div>
								<div class="card-body">The styling for this basic card
									example is created by using default Bootstrap utility classes.
									By using utility classes, the style of the card component can
									be easily modified with no need for any custom CSS!</div>
							</div>

						</div>

						<div class="col-lg-6">

							<!-- Dropdown Card Example -->
							<div class="card shadow mb-4">
								<!-- Card Header - Dropdown -->
								<div
									class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
									<h6 class="m-0 font-weight-bold text-primary">Dropdown
										Card Example</h6>
									<div class="dropdown no-arrow">
										<a class="dropdown-toggle" href="#" role="button"
											id="dropdownMenuLink" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="false"> <i
											class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
										</a>
										<div
											class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
											aria-labelledby="dropdownMenuLink">
											<div class="dropdown-header">Dropdown Header:</div>
											<a class="dropdown-item" href="#">Action</a> <a
												class="dropdown-item" href="#">Another action</a>
											<div class="dropdown-divider"></div>
											<a class="dropdown-item" href="#">Something else here</a>
										</div>
									</div>
								</div>
								<!-- Card Body -->
								<div class="card-body">Dropdown menus can be placed in the
									card header in order to extend the functionality of a basic
									card. In this dropdown card example, the Font Awesome vertical
									ellipsis icon in the card header can be clicked on in order to
									toggle a dropdown menu.</div>
							</div>

							<!-- Collapsable Card Example -->
							<div class="card shadow mb-4">
								<!-- Card Header - Accordion -->
								<a href="#collapseCardExample" class="d-block card-header py-3"
									data-toggle="collapse" role="button" aria-expanded="true"
									aria-controls="collapseCardExample">
									<h6 class="m-0 font-weight-bold text-primary">Collapsable
										Card Example</h6>
								</a>
								<!-- Card Content - Collapse -->
								<div class="collapse show" id="collapseCardExample">
									<div class="card-body">
										This is a collapsable card example using Bootstrap's built in
										collapse functionality. <strong>Click on the card
											header</strong> to see the card body collapse and expand!
									</div>
								</div>
							</div>

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
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>
	<!-- Logout Modal-->
	<%@ include file="/z05_bootTmp/a08_logout_modal.jsp"%>

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
<script src="${path}/a00_com/js/demo/chart-pie-demo.js"></script>	 --%>
	<script>
console.log(${emp.empno})
</script>
</body>
</html>