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
<script type="text/javascript">
	function noticeDetail(notice_num) {
		location.href = "${path}/noticeboardDetail?notice_num=" + notice_num
	}
</script>

<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script
	src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api"
	type="text/javascript"></script>

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
				<!--  <form
					class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search"
					method="post">
					<div class="input-group">
						<input type="text" class="form-control bg-light border-0 small"
							placeholder="공지검색" name="title" value="${noticeboard_f.title}"
							aria-label="Search" aria-describedby="basic-addon2">
						<div class="input-group-append">
							<button class="btn btn-primary" type="submit">
								<i class="fas fa-search fa-sm"></i>
							</button>
						</div>
					</div>
				</form>-->
				<!-- <//%@ include file="/WEB-INF/views/lsd/z05_bootTmp/a03_topBar.jsp"%>-->
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">공지게시판</h1>

					<form id="frm01" class="form" method="post">
						<input type="hidden" name="curPage" value="${sch.curPage}" />
					</form>
					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3 d-flex justify-content-between">
							<div>
								<h6 class="m-0 font-weight-bold text-primary">공지사항</h6>
							</div>
							<div>
								<form
									class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search"
									method="post">
									<div class="input-group">
										<input type="text"
											class="form-control bg-light border-0 small"
											placeholder="공지검색" name="title"
											value="${noticeboard_f.title}" aria-label="Search"
											aria-describedby="basic-addon2">
										<div class="input-group-append">
											<button class="btn btn-primary" type="submit">
												<i class="fas fa-search fa-sm"></i>
											</button>
										</div>
									</div>
								</form>
							</div>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>번호</th>
											<th>공지번호</th>
											<th>제목</th>
											<th>작성자</th>
											<th>등록날짜</th>
											<th>조회수</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach var="nt" items="${noticeboard}">
											<tr ondblclick="noticeDetail(${nt.notice_num})">
												<td>${nt.cnt}</td>
												<td>${nt.notice_num}</td>
												<td>${nt.title}</td>
												<td>${nt.writer}</td>
												<td><fmt:formatDate value="${nt.regDate}" /></td>
												<td>${nt.readcnt}</td>
											</tr>
										</c:forEach>


									</tbody>
								</table>
								<script type="text/javascript">
									function goPage(pcnt) {
										$("[name=curPage]").val(pcnt)
										$("form").submit()
									}
								</script>
								<ul class="pagination  justify-content-center">
									<li class="page-item"><a class="page-link" href="#">이전</a></li>
									<c:forEach var="pcnt" begin="1" end="${sch.pageCount}">
										<li class="page-item ${sch.curPage==pcnt?'active':''}"><a
											class="page-link" href="javascript:goPage(${pcnt})">${pcnt}</a></li>
									</c:forEach>
									<li class="page-item"><a class="page-link" href="#">다음</a></li>
								</ul>
							</div>
						</div>
					</div>

				</div>
				<!-- /.container-fluid -->
				<div style="text-align: right;">
					<c:if test="${emp.auth eq '관리자'}">
						<input type="button" class="btn btn-success" value="등록"
							id="insBtn" />
					</c:if>

				</div>
			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; 늘품 PMS</span>
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
	<script type="text/javascript">
		$("#insBtn").click(function() {
			location.href = "${path}/insertNoticeFrm"
		})
	</script>
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

	<!-- Page level plugins -->
	<script src="${path}/a00_com/vendor/chart.js/Chart.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="${path}/a00_com/js/demo/chart-area-demo.js"></script>
	<script src="${path}/a00_com/js/demo/chart-pie-demo.js"></script>
</body>
</html>