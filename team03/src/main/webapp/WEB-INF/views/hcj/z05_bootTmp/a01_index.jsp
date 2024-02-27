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
<style>
	
</style>


  
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
 <script type="text/javascript">
 	
  	if("${emp}"==""){
 		alert("로그인후 이용해주세요")
 		location.href="${path}/login"
 	}  
 	

 	
 </script>
 
     <!-- Custom fonts for this template-->
    <link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
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
	<%@ include file="/z05_bootTmp/a02_sliderBar.jsp" %>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">
				 <%-- <%@ include file="backendweb/z05_bootTmp/a03_topBar.jsp" %>   
				     <jsp:include page="${path}/z05_bootTmp/a03_topBar.jsp"/> --%>
				
				<!-- Topbar   %>  -->
				<%@ include file="/z05_bootTmp/a03_topBar.jsp" %> 
				<!-- End of Topbar -->
				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<div
						class="d-sm-flex align-items-center justify-content-between mb-4">
						<h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
						<a href="#"
							class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
							class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
					</div>

					<!-- Content Row -->
					<div class="row">
						<%@ include file="/WEB-INF/views/hcj/z05_bootTmp/a04_main_row01.jsp" %>
					</div>
					<%-- <!-- Content Row -->
					<div class="row">
						<%@ include file="/pmsprj_makerplace/hcj/z05_bootTmp/main_row_chart.jsp" %>
					</div> --%>


					<!-- Content Row -->
					
					<c:choose> 
						
						<c:when test="${projects.size()>0}">
						<div class="row">
							<%@ include file="/WEB-INF/views/hcj/z05_bootTmp/a12_main_row2.jsp" %>
						</div>
						<div class="row">
							<%@ include file="/WEB-INF/views/hcj/z05_bootTmp/a06_main_row03.jsp" %>
						</div>
						<%-- <div class="row">
						<%@ include file="/WEB-INF/views/hcj/z05_bootTmp/a05_main_row02.jsp" %>
					</div> --%>
						</c:when> 
						<c:otherwise>
							<h1>진행한 프로젝트가 없습니다</h1>
							<c:if test="${emp.auth == '관리자'}">
							<Button type="button" data-toggle="modal" data-target="#newprojectModal" class="btn btn-primary btn-block"> 프로젝트 생성</Button>
							</c:if>
						</c:otherwise> 
					</c:choose> 
					
					<%@ include file="/WEB-INF/views/hcj/z05_bootTmp/newprojectModal.jsp" %>	
		
					<!-- Content Row -->

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
<script src="${path}/customjs/projectmodal.js"></script>
<script type="text/javascript">
$("#uptBtn").hide();
$("#delBtn").hide();
selectpjwork()
function selectpjwork(){
	$.ajax({
		url:"workcnt",
		type:"post",
		data:"pcode="+$("#pjselect").val()+"&empno=${emp.empno}&auth=${emp.auth}",
		dataType:"json",
		success:function(datas){
		
			myBarChart.data.datasets[0].data = Object.keys(datas).map(item =>datas[item]);
			myBarChart.update();
		},
		error:function(){
			console.log(err)
		}
	})
	
	
}
/* 	var members = new Map();

 	//----프로젝트 생성------
	$("#regBtn").click(function(){
		//### 유효성 검사 ###
	 	if($("[name=pname]").val()==""){
			alert("프로젝트명을 입력해주세요")
			$("[name=pname]").focus()
			return;
		}
		if($("[name=ptype]").val()==0){
			alert("프로젝트유형을 선택해주세요")
			$("[name=ptype]").focus()
			return;
		}
		if($("[name=startdte]").val()==""||$("[name=enddte]").val()==""){
			alert("프로젝트 기간을 입력해주세요")
			
			if($("[name=startdte]").val()==""){
				$("[name=startdte]").focus()
			}else {
				$("[name=enddte]").focus()
			}
			return;
		}
		if($("[name=status]").val()==0){
			alert("프로젝트상태를 선택해주세요")
			$("[name=status]").focus()
			return;
		}
		if($("#teams").val()==""){
			if(!confirm("팀원이 존재하지 않습니다\n그대로 진행하시겠습니까? "))return;
			
		} 

		
		// 프로젝트 생성 시작
		functproject("insertProject")
		
		
	})
	

	// 사원 조회 모달 - 검색버튼 클릭
	$("#schBtn").click(function(){
		
		 $.ajax({
			type:"post",
			url:"${path}/empsearch",
			data:$("#frmEmpSch").serialize(),
			dataType:"json",
			success:function(data){
				
				var emphtml = ""
				
				$.each(data.elist,function(idx, emp){
					
					emphtml += "<tr>"
					emphtml += "<td>"+emp.empno+"</td>"
					emphtml += "<td>"+emp.ename+"</td>"
					emphtml += "<td>"+emp.dname+"</td>"
					emphtml += "<td><a href='#' onclick='addemp2(\" "+emp.ename+"\","+emp.empno+")' class='btn btn-success btn-circle btn-sm'> "
					emphtml += '<i class="fas fa-check"></i></a></td>'
					emphtml += "</tr>"
				})
			
				// 조회된 내용으로 tbody 변경
				$("#empSchTbody").html(emphtml)
		
			},
			error:function(err){
				console.log(err)
			}
		}) 
	})
	
	function addemp2(ename,empno){
		if(members.has(empno)){
			alert("중복된 사원입니다.")
		}else{
			members.set(empno,ename)
			alert(ename+"사원 추가")
			$("#teams_name").append('<button type="button" id="'+empno+'" class="btn btn-outline-secondary btn-sm" onclick="deleteTeams2(this)">'+ename+'</button>')
			$("#echclsBtn").click()
		}
 	}
	
	// 조회된 팀원을 프로젝트 팀에 추가
	function addemp(ename,empno){
		var team = $("#teams").val()
		var teams_name = $("#teams_name").text()
		if(team ==""||team == null){ 
			team = empno; 
		}
		else{
			let emps = team.split(",")
			let empck = false;
			emps.forEach(function(emp){
				if(empno == parseInt(emp)){
					alert("이미 추가된 사원입니다.")
					empck = true;
					return;				
				}
			})
			if(empck==true)return;
			else{
				team += ","+empno;
				
			}
		}
		$("#teams").val(team)	
		$("#teams_name").append('<button type="button" id="'+empno+'" class="btn btn-outline-secondary btn-sm" onclick="deleteTeams(this)">'+ename+'</button>')
		alert("팀원이 추가되었습니다")
		$("#echclsBtn").click()
  	}
	function deleteTeams2(obj){
		if(confirm($(obj).text()+"사원을 팀에서 제외하시겠습니까?")){
			if(members.delete(parseInt($(obj).prop("id")))){
				obj.remove()
				alert("삭제완료")	
			}			
		}
	}
	
	function deleteTeams(obj){
		if(confirm($(obj).text()+"사원을 팀에서 제외하시겠습니까?")){
			var teamemp = $("#teams").val().split(",")
			var retval = ""
			teamemp.forEach(function(emp){
				if($(obj).prop("id")!=emp){
					retval += emp+","
				}
			})
			$("#teams").val(retval.slice(0,retval.length-1))
			obj.remove()
			alert("삭제완료")
		}
	}
	function functproject(url){
		var formdata = new FormData($("#frm02")[0]);

	  	var memidx = 0;
		members.forEach(function(value,key){
			formdata.append("tmem["+memidx+"].key",key)
			formdata.append("tmem["+memidx+"].label",value)
			memidx++;
		})   
		
		  for (let value of formdata) {
			  console.log(value)
			  }
		
		  $.ajax({
			type:"post",
			enctype: 'multipart/form-data',
			url:"${path}/"+url,
			data:formdata,
			processData: false,	
			contentType: false,
			dataType:"json",
			success:function(data){
				if(data.msg!=""){
					alert(data.msg)
					location.reload()
				}	
			},
			error:function(err){
				console.log(err)
			}
		})  
	}  */ 
</script>
<!-- Page level plugins -->


<!-- Page level custom scripts -->
<%-- <script src="${path}/a00_com/js/demo/chart-area-demo.js"></script>
<script src="${path}/a00_com/js/demo/chart-pie-demo.js"></script> --%>
</body>
</html>