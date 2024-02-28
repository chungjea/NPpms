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
.iconhover{
 margin-left:5px; 
}
.iconhover:hover{
	border : solid 0.5px gray;
	border-radius: 5px;
	box-sizing: border-box;
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
<script type="text/javascript">
if("${emp}"==""){
		alert("로그인후 이용해주세요")
		location.href="${path}/login"
	}
</script>
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
					<div class=" text-center">
						<h2 style="border-radius: 10px; background: #a1b6f2; color: white; padding: 10px 0px" id="titleheader">
							${pinfo.pname}
						</h2>
							
						
					</div>

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

	<script src="${path}/customjs/slidbar.js"></script>
	<!-- Page level plugins -->
	<script>	
	/* $("#delBtn").click(function(){
		if(confirm("정말로 삭제하시겠습니까?")){
			
		}
	})
	$("#uptBtn").click(function(){
		functproject("updateProject")
	})
	 */
	//프로젝트 수정 정보 불러오기
						gantt.plugins({
							quick_info: false,
							tooltip: true,
							critical_path: true
						});
						gantt.config.min_duration = 24*60*60*1000;
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
							{name:"writer",label:"담당자",resize: true},
							{name: "add", width: 40}
						];
						gantt.templates.lightbox_header = function(start_date,end_date,task){
						    return  task.text;
						};
						gantt.config.date_format = "%Y-%m-%d";
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
						var tmem;
							$.ajax({
								url:"${path}/Tmem",
								type:"post",
								async:false,
								data:"pcode=${pcode}",
								dataType:"json",
								success:function(data){
									tmem = data.mem;	
								},
								error:function(err){								
								}	
							})
						gantt.config.lightbox.sections = [
						    {name:"description", height:50, map_to:"text", type:"textarea", focus:true},
						    {name:"assignor", height:30, type:"select", options:tmem,map_to:"assignor"},
						    {name:"time", height:50, type:"duration", map_to:"auto",time_format:["%Y","%m","%d"]}   
						];
						gantt.config.lightbox_additional_height = 130;
						gantt.locale.labels.section_description = "작업명";
						gantt.locale.labels.section_time = "기간";
						gantt.locale.labels.section_assignor = "담당배정"
						
						 if("${emp.auth}" != "관리자"){
							gantt.config.readonly = true;
						} 
						
						gantt.attachEvent("onAfterLinkAdd", function(id,item){
						    funclink("insertLink",item)
						});
						gantt.attachEvent("onAfterLinkDelete", function(id,item){
							funclink("deleteLink",item)
						});
						/* gantt.attachEvent("onBeforeTaskUpdate", function(id,new_item){
							if(gantt.getChildren(id) !=0){
								
								
								
								
								console.log("하위존재")
							
								
								
							}
							
						}); */
						var bdforeMoveDate;
						var beforeResizeStart;
						gantt.attachEvent("onBeforeTaskDrag", function(id, mode, e){
							const Task = gantt.getTask(id)
						    //any custom logic here
						    if(mode === "move"){
						    	bdforeMoveDate = Task.start_date
						    }
							
						    return true;
						});
						gantt.attachEvent("onAfterTaskDrag", function(id, mode, e){
						    //any custom logic here
						    const Task = gantt.getTask(id)
						    if(mode === "move"){
						    	if(gantt.getChildren(id) !=0){
							    	var moveStep =  Task.start_date.getDate() - bdforeMoveDate.getDate()  
							    	gantt.getChildren(id).forEach(function(childid){
							    		var childTask = gantt.getTask(childid)
							    		console.log(childTask.start_date.getDate())
							    		childTask.start_date.setDate(childTask.start_date.getDate()+moveStep)
							    		childTask.end_date.setDate(childTask.end_date.getDate()+moveStep)
							    		funcTask("updateTask",childTask)
							    	})
							    	gantt.render()
							
						    	}
						    }
						    if(mode === "resize"){
								if(gantt.getChildren(id) !=0){
									var sendmsg = "";
									gantt.getChildren(id).forEach(function(childid){
										var childTask = gantt.getTask(childid)
										if(Task.start_date>childTask.start_date){
											Task.start_date = childTask.start_date
											sendmsg = "하위 작업보다 시작일이 빠를수 없습니다"
										}else if(Task.end_date<childTask.end_date){
											Task.end_date=childTask.end_date
											sendmsg = "하위 작업보다 마감일이 빠를수 없습니다"
										}
									})
									funcTask("updateTask",Task)
									gantt.render()
									if(sendmsg != "")
									gantt.message(sendmsg)
								
								}
							}
						    
						    return true;
						});
								
						gantt.attachEvent("onAfterTaskUpdate", function(id,item){
							const parent = item.parent
							const child = gantt.getChildren(id)
							
							funcTask("updateTask",item)	
							// 상위 작업이 있을경우 할 일
							if(parent !=0){
								const Siblings = gantt.getChildren(item.parent)
								const parentdata = gantt.getTask(parent)
								var tot = 0;
								Siblings.forEach(function(Siblingid){
									var Sibling = gantt.getTask(Siblingid)
									tot +=Sibling.progress;
									if(parentdata.start_date>Sibling.start_date) parentdata.start_date = Sibling.start_date			
									if(parentdata.end_date<Sibling.end_date) parentdata.end_date = Sibling.end_date;
								})
								var progress = tot/Siblings.length
								parentdata.progress = Math.round(progress * 10)/10
								// 업데이트 후 랜더
								
								funcTask("updateTask",parentdata)
								gantt.render()
								gantt.updateTask(parentdata.id)
								
								
							}
						});
						
						gantt.attachEvent("onAfterTaskAdd", function(id,item){				
							funcTask("insertTask",item)	
						});
						gantt.attachEvent("onAfterTaskDelete", function(id,item){
							funcTask("deleteTask",item)
						});
						
						gantt.init("gantt_here");
						gantt.load("${path}/Taskdata?pcode="+${pcode},"json")
								
				function funcTask(type,item){
						var datas = item
						const start = {startdte:transferDateformat(item.start_date)};
						const end = {enddte:transferDateformat(item.end_date)};
						const pcode = {"pcode":"${pcode}"}
						var data = {...datas,...start,...end,...pcode}
						console.log(datas)
						 $.ajax({
								url:"${path}/"+type,
								type:"post",
								contentType: "application/json",
								dataType:"text",
								data :JSON.stringify(data),
								success:function(msg){
								},
								error:function(err){
									console.log(err)
								}
							})
				}
				
				function funclink(url,item){
					var linkdata = {...item,...{pcode:"${pcode}"}}
				 	$.ajax({
						url:url,
						type:"post",
						dataType:"text",
						contentType: "application/json",
						data:JSON.stringify(linkdata),
						success:function(msg){
							gantt.message(msg)
						},
						error:function(err){
							console.log(err)
						}
					}) 
				}
						
				function transferDateformat(date){
					const year = date.getFullYear()
					const month = (date.getMonth()+1)
					const day = date.getDate()
					return year+"-"+month+"-"+day;
				}
			
			
					</script>

	<!-- Page level custom scripts -->
	<%-- <script src="${path}/a00_com/js/demo/chart-area-demo.js"></script>
<script src="${path}/a00_com/js/demo/chart-pie-demo.js"></script> --%>
</body>
</html>