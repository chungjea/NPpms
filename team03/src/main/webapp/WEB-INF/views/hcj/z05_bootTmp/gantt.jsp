<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8" />
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
	height: calc(80vh - 50px);
}
</style>






<!-- Custom fonts for this template-->
<script src="${path}/a00_com/gantt/codebase/dhtmlxgantt.js?v=8.0.6"></script>
<link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="${path}/a00_com/gantt/codebase/skins/dhtmlxgantt_material.css?v=8.0.6">
<link rel="stylesheet"
	href="${path}/a00_com/gantt/common/controls_styles.css?v=8.0.6">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Open+Sans|Roboto:regular,medium,thin,bold">



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
				<%-- <%@ include file="backendweb/z05_bootTmp/a03_topBar.jsp" %>   
				     <jsp:include page="${path}/z05_bootTmp/a03_topBar.jsp"/> --%>

				<!-- Topbar   %>  
				-->
				<%@ include file="/z05_bootTmp/a03_topBar.jsp"%>
				<!-- End of Topbar -->
				<!-- Begin Page Content -->
				<div class="container-fluid">
					<div class="main-content">
						<div id="gantt_here"
							style='width: 100%; height: 100%; padding: 0px;'></div>
					</div>
				</div>

				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; Your Website 2024</span>
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
	<%@ include file="/WEB-INF/views/hcj/z05_bootTmp/a08_logout_modal.jsp"%>

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
							quick_info: false,
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
							{name: "wbs", label: "번호", width: 40, template: gantt.getWBSCode, resize: true},
							{name: "text", label: "작업명", tree: true, width: 170, resize: true, min_width: 10},
							{name: "start_date",label:"시작일",align: "center", width: 90, resize: true},
							{name: "duration",label:"작업일수" ,align: "center", width: 80, resize: true},
							{name:"writer",label:"담당자",resize: false},
							{name: "add", width: 40},
							{name: "del", width: 40}
						];
					
						gantt.templates.rightside_text = function (start, end, task) {
							if (task.type == gantt.config.types.milestone)
								return task.text + " / ID: #" + task.id;
							return "";
						};
					
						gantt.config.start_on_monday = true;
					
						gantt.config.scale_height = 36 * 3;
						gantt.config.scales = [
							{unit: "month", step: 1, format: "%m월"},
							{unit: "week", step: 1, format: function (date) {
								var dateToStr = gantt.date.date_to_str("%d");
								return parseInt((dateToStr(date)/7)+1) + "주차 ";
							}},
							{unit: "day", step: 1, format: "%d일"}
						];
						
						var tmem = [
						    { key: 199001001, label: '홍길동' },
						    { key: 199001001, label: '김길동' },
						    { key: 199001001, label: '한길동' }
						];
						
						gantt.config.lightbox.sections = [
						    {name:"description", height:50, map_to:"text", type:"textarea", focus:true},
						    {name:"assignor", height:30, type:"select", options:tmem,map_to:"assignor"},
						    {name:"time", height:40, type:"duration", map_to:"auto",time_format:["%Y","%m","%d"]},
						    {name:"pcode",map_to:"pcode",type:"textarea",default_value:"${param.pcode}"}
						    
						];
					
						
						
						
						gantt.locale.labels.section_description = "작업명";
						gantt.locale.labels.section_time = "기간";
						gantt.locale.labels.section_assignor = "담당배정"
					
						console.log(gantt.getSelectedId());
						
					
							gantt.attachEvent("onLightbox", function (task_id){
							   console.log("작업생성 모달 열림")
							   console.log(gantt.getLightboxValues());
							});
						gantt.attachEvent("onLightboxCancel", function(id){
							console.log("취소버튼 클릭")
						})
						// 업데이트시 활용하면 됨
						gantt.attachEvent("onAfterTaskDrag", function(id, mode, e){
							console.log("테스크 드래그 후 놓기 완료")
						});
						// 테스크의 인덱스 위치를 바꿨을때로 추측
						gantt.attachEvent("onAfterTaskMove", function(id, parent, tindex){
							console.log("onmove:움직임이 있을때")
						});
						
						gantt.attachEvent("onAfterTaskUpdate", function(id,item){
							console.log("taskUpdate:테스크에변화가 있을때")
						});
						
						gantt.attachEvent("onAfterTaskAdd", function(id,item){
							console.log("onAfterTaskAdd:테스크 생성시 쓰면 될듯")
							var newdata = gantt.getLightboxValues();
	
							 var testdata = {"source":[],"text":"fsddsffsdfsd"}
							var taskdata = JSON.stringify(testdata);
							var taskdata2 = JSON.stringify(newdata)
							var testtaskdata = newdata.id 
							/* var datas = "id="+newdata.id +"&text="+newdata.text+"&start_date="+newdata.start_date
							+"end_date="+newdata.end_date+"&progress="+newdata.progress+"&assignor="+newdata.assignor+"&parent="+newdata.parent
							+"&pcode=${param.pcode}" */ ;

							//alert(datas)
							 $.ajax({
								url:"${path}/insertTask",
								type:"post",
								contentType: "application/json",
								dataType:"json",
								data :taskdata2,
								success:function(data){
									alert(data.msg)
								},
								error:function(err){
									console.log(err)
								}
							}) 
						
							
						});
						
						gantt.attachEvent("onAfterTaskDelete", function(id,item){
							console.log("onAfterTaskDelete:테스크 섹제시 쓰면 될듯")
						});
						
						gantt.init("gantt_here");
						gantt.load("${path}/Taskdata?pcode="+${param.pcode},"json")
						
				
				
					</script>

	<!-- Page level custom scripts -->
	<%-- <script src="${path}/a00_com/js/demo/chart-area-demo.js"></script>
<script src="${path}/a00_com/js/demo/chart-pie-demo.js"></script> --%>
</body>
</html>