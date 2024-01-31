<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>     
<!DOCTYPE html>
<%--


 --%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	html, body {
			background: #fff;
			font-family: arial;
			height: 100%;
			padding: 0px;
			margin: 0px;
			overflow: hidden;
		}
		.main-content {
			height: 600px;
			height: calc(100vh - 50px);
		}
</style>





 
     <!-- Custom fonts for this template-->
      	<script src="${path}/a00_com/gantt/codebase/dhtmlxgantt.js?v=8.0.6"></script>
    <link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${path}/a00_com/gantt/codebase/skins/dhtmlxgantt_material.css?v=8.0.6">
	<link rel="stylesheet" href="${path}/a00_com/gantt/common/controls_styles.css?v=8.0.6">
	<script src="${path}/a00_com/gantt/common/testdata.js?v=8.0.6"></script>
 	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans|Roboto:regular,medium,thin,bold">

 
 
</head>
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
				 <%-- <%@ include file="backendweb/z05_bootTmp/a03_topBar.jsp" %>   
				     <jsp:include page="${path}/z05_bootTmp/a03_topBar.jsp"/> --%>
				
				<!-- Topbar   %>  
				-->
				<%@ include file="/z05_bootTmp/a03_topBar.jsp" %> 
				<!-- End of Topbar -->
				<!-- Begin Page Content -->
				<div class="container-fluid">
			
					<div class="main-content">
						<div id="gantt_here" style='width:100%; height:100%;padding: 0px;'></div>
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
	<%@ include file="/WEB-INF/views/hcj/z05_bootTmp/a08_logout_modal.jsp" %>
	
<!-- Bootstrap core JavaScript-->
    <script src="${path}/a00_com/vendor/jquery/jquery.min.js"></script>
<script
	src="${path}/a00_com/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="${path}/a00_com/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="${path}/a00_com/js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script>
						gantt.plugins({
							quick_info: true,
							tooltip: true,
							critical_path: true
						});
					
						var toggleCritical = function () {
							if (gantt.config.highlight_critical_path)
								gantt.config.highlight_critical_path = !true;
							else
								gantt.config.highlight_critical_path = true;
							gantt.render();
						};
					
						gantt.config.columns = [
							{name: "wbs", label: "WBS", width: 40, template: gantt.getWBSCode, resize: true},
							{name: "text", label: "Task name", tree: true, width: 170, resize: true, min_width: 10},
							{name: "start_date", align: "center", width: 90, resize: true},
							{name: "duration", align: "center", width: 80, resize: true},
							{name: "add", width: 40}
						];
					
						gantt.templates.rightside_text = function (start, end, task) {
							if (task.type == gantt.config.types.milestone)
								return task.text + " / ID: #" + task.id;
							return "";
						};
					
						gantt.config.start_on_monday = false;
					
						gantt.config.scale_height = 36 * 3;
						gantt.config.scales = [
							{unit: "month", step: 1, format: "%F"},
							{unit: "week", step: 1, format: function (date) {
								var dateToStr = gantt.date.date_to_str("%d %M");
								var endDate = gantt.date.add(gantt.date.add(date, 1, "week"), -1, "day");
								return dateToStr(date) + " - " + dateToStr(endDate);
							}},
							{unit: "day", step: 1, format: "%D"}
						];
					
						gantt.init("gantt_here");
						/* gantt.message({text: "Some asddsa", expire: -1});
						gantt.message({text: "Some gsdgsh", type: "error", expire: -1}); */
						$.ajax({
							url:"Taskdata",
							dataType:"json",
							success:function(data){
								var tttt = data
								alert(data)
								
								gantt.parse(gantt.load(data));

							}
						})
				/* 	 var testtest = {"data":[
						{"id":11, "text":"Project #1", type:gantt.config.types.project, "progress": 0.6, "open": true},

						]}
						
						
						gantt.parse(testtest) */
					</script>

<!-- Page level custom scripts -->
<%-- <script src="${path}/a00_com/js/demo/chart-area-demo.js"></script>
<script src="${path}/a00_com/js/demo/chart-pie-demo.js"></script> --%>
</body>
</html>