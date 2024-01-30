<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    import="backendweb.z01_vo.*"
    import="backendweb.d01_dao.*"
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
	<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >
	<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >
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
		<%@ include file="/pmsprj_makerplace/kjw/z05_bootTmp/a02_sliderBar.jsp" %>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">
				 <%-- <%@ include file="backendweb/z05_bootTmp/a03_topBar.jsp" %>   
				     <jsp:include page="${path}/z05_bootTmp/a03_topBar.jsp"/> --%>
				
				<!-- Topbar   %>  
				-->
				<%@ include file="/pmsprj_makerplace/kjw/z05_bootTmp/a03_topBar.jsp" %> 
				<!-- End of Topbar -->
				<!-- Begin Page Content -->
				<div class="container-fluid">
				<!--  내용 -->
					<form id="frm01" class="form"  method="post">
	  					<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  					<input type="hidden" name="curPage" value="${sch.curPage}"/>
			    		<input class="form-control" name="pname" placeholder="프로젝트명으로 검색"/>
			    		<select class="form-control" name="status">
			    			<option hidden value="">프로젝트 상태를 선택해주세요</option>
			    			<option>예정</option>
			    			<option>진행중</option>
			    			<option>중단</option>
			    			<option>완료</option>
			    		</select>	
		    			<button class="btn btn-info" type="submit">검색</button>
		    			<c:if test="${emp.auth=='admin'}">
		    			<button class="btn btn-success" data-toggle="modal" data-target="#newprojectModal" type="button">프로젝트 생성</button>
		    			</c:if>
	 					</nav>
					</form>
   					<table class="table table-hover table-striped">
					   	<col width="6/1">
					   	<col width="6/1">
					   	<col width="6/1">
					   	<col width="6/1">
					   	<col width="6/1">
					   	<col width="6/1">
	    				<thead>
	      					<tr class="table-success text-center">
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
					   	<tr>
						   	<td>${pj.tname}</td>
						   	<td>${pj.pname}</td>
						   	<td>${pj.ptype}</td>
						   	<td>${pj.enddte}</td>
						   	<td>${pj.status}</td>
					   		<td><div class="progress">
				<div class="progress-bar" role="progressbar"
					style="width:${pj.progress}%" aria-valuenow="${pj.progress}" aria-valuemin="0"
					aria-valuemax="100">${pj.progress}%</div>
			</div></td>
					   	</tr>
					   	</c:forEach>
	    				</tbody>
					</table>    
					<ul class="pagination">
					  	<li class="page-item">
					  	<a class="page-link" 
					  		href="javascript:goPage(${sch.startBlock-1})">이전</a></li>
						<c:forEach var="pNo" begin="${sch.startBlock}" 
											  end="${sch.endBlock}">
					  	<li class="page-item ${sch.curPage==pNo?'active':''}">
					  		<a class="page-link" 
					  			href="javascript:goPage(${pNo})">${pNo}</a></li>
					  	</c:forEach>
					  	<li class="page-item">
					  	<a class="page-link" 
					  		href="javascript:goPage(${sch.endBlock+1})">다음</a></li>
					</ul>
  				<%@ include file="/pmsprj_makerplace/hcj/z05_bootTmp/newprojectModal.jsp" %>
				<%@ include file="/pmsprj_makerplace/hcj/z05_bootTmp/empsch.jsp" %>
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
	<%@ include file="/pmsprj_makerplace/kjw/z05_bootTmp/a08_logout_modal.jsp" %>
	
<!-- Bootstrap core JavaScript-->
    <script src="${path}/a00_com/vendor/jquery/jquery.min.js"></script>
<script
	src="${path}/a00_com/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="${path}/a00_com/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="${path}/a00_com/js/sb-admin-2.min.js"></script>
<script type="text/javascript">
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
		if($("[name=ttype]").val()=="팀개발"&&$("teams_name").text()==""){
			if(!confirm("팀원이 존재하지 않습니다\n그대로 진행하시겠습니까? "))return;
			else ;
		}
	//alert($("#frm02").serialize())
		 $.ajax({
			type:"post",
			url:"${path}/insertProject",
			data:$("#frm02").serialize(),
			dataType:"json",
			success:function(data){
				if(data.msg!=""){
					alert(data.msg)
					location.href="${path}/mainpape.do2"
					//$("#frm02")[0].reset();
				}
					
			},
			error:function(err){
				console.log(err)
			}
			
		}) 
		//$("#frm02").submit()
	})
	
	
	$("#schBtn").click(function(){
		//alert($("#frmEmpSch").serialize())
		 $.ajax({
			type:"post",
			url:"${path}/empsearch",
			data:$("#frmEmpSch").serialize(),
			dataType:"json",
			success:function(data){
				
				var emphtml = ""
				
				$.each(data.elist,function(idx, emp){
					//alert("emp:"+emp+"  emp.empno:"+emp.empno+"  emp.ename:"+emp.ename+"  emp.dname:"+emp.dname)
					emphtml += "<tr>"
					emphtml += "<td>"+emp.empno+"</td>"
					emphtml += "<td>"+emp.ename+"</td>"
					emphtml += "<td>"+emp.dname+"</td>"
					emphtml += "<td><a href='#' onclick='addemp(\" "+emp.ename+"\","+emp.empno+")' class='btn btn-success btn-circle btn-sm'> "
					emphtml += '<i class="fas fa-check"></i></a></td>'
					emphtml += "</tr>"
				})
			
				
				$("#empSchTbody").html(emphtml)
				
				
					
				
			},
			error:function(err){
				console.log(err)
			}
		}) 
	})
	function addemp(ename,empno){
		var team = $("#teams").val()
		var teams_name = $("#teams_name").text()
		if(team ==""||team == null){ 
			team = empno; 
			//teams_name = "팀원:"+ename;
		
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
				team += ","+empno;// teams_name += ","+ename
				
			}
		}
	
		$("#teams").val(team)
		//alert("변수:"+teams_name+"/실제 text:"+$("#teams_name").text())
		//$("#teams_name").text(teams_name)
		$("#teams_name").append('<button type="button" id="'+empno+'" class="btn btn-outline-secondary btn-sm" onclick="deleteTeams(this)">'+ename+'</button>')
		alert("팀원이 추가되었습니다")
		//$("#empSearchModal").modal("hide");
		$("#echclsBtn").click()
  	}
	

	/* getworkcnt()
	function getworkcnt(){
		$.ajax({
			url:"workcnt.do2",
			data:"empno=${emp.empno}",
			dataType:"json",
			success:function(data){
				$("#sp_workcnt").text(data.workcnt)
				console.log("작업건수 호출")
			},
			error:function(err){
				console.log(err)
			}
			
		})
	} */
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
	
	function goPage(pNo){
		$("[name=curPage]").val(pNo)
		$("#frm01").submit()
	}
</script>
<!-- Page level plugins -->


<!-- Page level custom scripts -->
<%-- <script src="${path}/a00_com/js/demo/chart-area-demo.js"></script>
<script src="${path}/a00_com/js/demo/chart-pie-demo.js"></script> --%>
</body>
</html>