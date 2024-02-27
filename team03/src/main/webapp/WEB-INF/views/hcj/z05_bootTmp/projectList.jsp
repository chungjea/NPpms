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
td{text-align:center;}
	.jumbotron{padding:2%;}
</style>
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
				
				<!-- Topbar   %>  
				-->
				<%@ include file="/z05_bootTmp/a03_topBar.jsp" %> 
				<!-- End of Topbar -->
				<!-- Begin Page Content -->
				<div class="container-fluid">
				<!--  내용 -->
				<div class="card shadow mb-4">
						<div class="card-header py-3 d-flex justify-content-between">
					<form id="frm01" class="row"  method="post">
					<div class="col-auto">
			    		<select class="form-control" name="status">
			    			<option value="">프로젝트 상태를 선택해주세요</option>
			    			<option>예정</option>
			    			<option>진행중</option>
			    			<option>중단</option>
			    			<option>완료</option>
			    		</select>	
			   		</div>
			   		<div class="col-auto">
		    			<div class="input-group">
								<input type="text" class="form-control bg-light border-0 small"
									placeholder="프로젝트명으로 검색" name="pname" value="${sch.pname}" aria-label="Search"
									aria-describedby="basic-addon2">
									<div class="input-group-append">
											<button class="btn btn-primary" type="submit">
												<i class="fas fa-search fa-sm"></i>
											</button>
									</div>
						</div>
					</div>
		    			
		    			<c:if test="${emp.auth=='관리자'}">
		    			<div class="col-auto " align="right">
		    			<button class="btn btn-success " data-toggle="modal" data-target="#newprojectModal" type="button" id="newProject">프로젝트 생성</button>
		    			</div>
		    			</c:if>
					 <input type="hidden" name="curPage" value="${sch.curPage}"/>
					</form>
					</div>
					
					<div class="card-body">
							<div class="table-responsive">
   					<table class="table table-hover table-striped">
					   	<col width="6/1">
					   	<col width="6/1">
					   	<col width="6/1">
					   	<col width="6/1">
					   	<col width="6/1">
					   	<col width="6/1">
	    				<thead>
	      					<tr class="text-center" style="background-color:skyblue;">
								<th>팀</th>
								<th>프로젝트 명</th>
								<th>프로젝트 유형</th>
								<th>마감일</th>
								<th>상태</th>
								<th>진행도</th>
	      					</tr>
	    				</thead>	
	    				<tbody>
					   	<c:forEach var="pj" items="${projectSchList}">
					   	<tr ondblclick="goproject(${pj.pcode})">
						   	<td>${pj.tname}</td>
						   	<td>${pj.pname}</td>
						   	<td>${pj.ptype}</td>
						   	<td>${pj.enddte}</td>
						   	<td>${pj.status}</td>
					   		<td><div class="progress" >
									<div class="progress-bar" role="progressbar"
									style="width:${pj.progress*100}%" aria-valuenow="${pj.progress*100}" aria-valuemin="0"
									aria-valuemax="100"><fmt:formatNumber value="${pj.progress*100}" pattern="00"/>%</div>
								</div>
								<c:if test="${emp.auth=='관리자'}">
		    						<button style="float:right" class="btn btn-success" data-toggle="modal" data-target="#newprojectModal" type="button" onclick="loadProjectinfo(${pj.pcode})">관리</button>	
		    					</c:if>
		    				</td>	
					   	</tr>
					   	</c:forEach>
	    				</tbody>
					</table>    
					<ul class="pagination">
					  	<li class="page-item">
					  	<a class="page-link" 
					  		href="javascript:goPage(${sch.startBlock-1})">이전</a></li>
						<c:forEach var="pNo" begin="${sch.startBlock}" end="${sch.endBlock}">
					  	<li class="page-item ${sch.curPage==pNo?'active':''}">
					  		<a class="page-link" 
					  			href="javascript:goPage(${pNo})">${pNo}</a></li>
					  	</c:forEach>
					  	<li class="page-item">
					  	<a class="page-link" 
					  		href="javascript:goPage(${sch.endBlock+1})">다음</a></li>
					</ul>
						</div>
					</div>
				</div>
  				<%@ include file="/WEB-INF/views/hcj/z05_bootTmp/newprojectModal.jsp" %>
				<%@ include file="/WEB-INF/views/hcj/z05_bootTmp/empsch.jsp" %>
				<form id="goprojectfrm" action="project">
					<input type="hidden" name="pcode"/>
				</form>
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
    <script type="text/javascript">
$("[name=status]").val("${sch.status}")

$("#newProject").click(function(){
	$("#uptBtn").hide()
	$("#delBtn").hide()
	$("#regBtn").show()
	$("#frm02")[0].reset()

	img.src=""
	$("#frm02 #teams_name").html("");
	members.clear()
})

$("#delBtn").click(function(){
	if(confirm("정말 삭제하시겠습니까?"))functproject("deleteProject");
})
$("#uptBtn").click(function(){
	if(confirm("정말 수정하시겠습니까?"))functproject("updateProject");
})

function goPage(pNo){
	$("[name=curPage]").val(pNo)
	$("#frm01").submit()
}
function goproject(pcode){
	$("[name=pcode]").val(pcode)
	$("#goprojectfrm").submit()
}
</script>
<script
	src="${path}/a00_com/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="${path}/a00_com/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="${path}/a00_com/js/sb-admin-2.min.js"></script>
<script src="${path}/customjs/slidbar.js"></script>
<script src="${path}/customjs/projectmodal.js"></script>

</body>
</html>