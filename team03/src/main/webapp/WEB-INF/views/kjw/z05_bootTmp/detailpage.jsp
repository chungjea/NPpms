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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.31.3/css/theme.grey.min.css" />
<!-- Custom fonts for this template-->
<link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">


</head>
<body id="page-top" onload="noBack();"
	onpageshow="if(event.persisted) noBack();" onunload="">
	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->

		<%@ include file="/z05_bootTmp/a02_sliderBar.jsp"%>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar-->
				<%@ include file="/z05_bootTmp/a03_topBar.jsp"%>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">
					<div class="row">
						
					</div>
					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">상세페이지</h1>
<ul class="nav nav-tabs nav-justified">
                     
                  </ul>

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						

						
						<div class="col-xl-7">
							<form
								class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search"
								id="frm01" class="form" method="post">
								
							</form>
						</div>

						<div class="card-body">
							
                            <form method="post" id="send" action="${path}/updateinfo">
                                
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input name="ename" class="form-control form-control-user"  value="${emp.ename}" />	
                                    </div>
                                    <div class="col-sm-6">
 										 <select name="egrade" id="egrade" class="form-control form-control-user">
                                    <option value="" disabled selected>${emp.egrade}</option>
                                    <option value="사원">사원</option>
                                    <option value="팀장">팀장</option>
                                    <option value="전무">전무</option>
                                    <option value="사장">사장</option>

                                    </select>
                                    </div>
                               
                                </div>
                                <div class="form-group row">
                                <div class="col-sm-6 ">
                                    <select name="dname" id="dname" class="form-control form-control-user">
                                   <option value="" disabled selected>${emp.dname}</option>
                                    <option value="디자인팀">디자인팀</option>
                                    <option value="인사팀">인사팀	</option>
                                    <option value="재무팀">재무팀	</option>
                                    <option value="기획팀">기획팀	</option>
                                    <option value="개발1팀">개발1팀</option>
                                    <option value="개발2팀">개발2팀</option>
                                    <option value="개발3팀">개발3팀</option>
                                    </select>
                                </div>
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="date" readonly name="hiredate" class="form-control form-control-user"  value="${emplist.hiredate}" />	
                                    </div>
                                    </div>
                                    <input type="hidden" name="lastone" value="${emp.empno}">
                                <div class="form-group row">

                                    <div class="col-sm-5 mb-3 mb-sm-0">
                                        <input type="emailH" name="emailH" id="emailH" class="form-control form-control-user"   placeholder="${emp.email}" />	
                                    </div>
                                    <span class="col-sm-0 mb-3 mb-sm-0">@</span>
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                         <select name="emailE" id="emailE" class="form-control">
                                    <option value="@naver.com">naver.com</option>
                                    <option value="@daum.net">daum.net</option>
                                    <option value="@gmail.com">gmail.com</option>
                                    </select>
                                    <input type="hidden" id="email" name="email" value="">
                                    <input type="hidden" name="lastone" value="${emp.empno}">
                                    
                                    
                                    
                                    </div>
                                    <div class="col-sm-6 ">
                                    <select name="auth" class="form-control form-control-user">
                                    <option value=""disabled selected>${emp.auth}</option>
                                    <option value="직원">직원</option>
                                    <option value="관리자">관리자	</option>
                                    </select>
                                </div>
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="number" readonly name="empno" class="form-control form-control-user" value="${emp.empno}"  />	
                                    </div>
                                     <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text"  name="passwd" class="form-control form-control-user" value="${emp.passwd}"  />	
                                    </div>
                                </div>
                                
                                <input type="button"  class="btn btn-primary btn-user btn-block" id="uptBtn" value="정보수정">
                                    
                                </a>
                                <hr>


                            </form>

									
									<%@page buffer="8192kb" autoFlush="true"%>
								
								<!-- /.container-fluid -->

							</div>
							<!-- End of Main Content -->

							<!-- Footer -->
							
							</div>
							</div>
							</div>
							</div>
							</div>
							</div>
							
<footer class="sticky-footer bg-white">
								<div class="container my-auto">
									<div class="copyright text-center my-auto">
										<span>Copyright &copy; Your Website 2021</span>
									</fotter>
									</div>
</div>
							<!-- End of Footer -->

					
						<!-- End of Content Wrapper -->
							
					
					<!-- End of Page Wrapper -->

								
					<!-- Scroll to Top Button-->
					<!-- <a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a> -->
	
					<!-- Logout Modal-->
					<%@ include file="a08_logout_modal.jsp"%>
					
					<!-- Bootstrap core JavaScript-->
					<script src="${path}/a00_com/vendor/jquery/jquery.min.js"></script>
					<script
						src="${path}/a00_com/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

					<!-- Core plugin JavaScript-->
					<script
						src="${path}/a00_com/vendor/jquery-easing/jquery.easing.min.js"></script>

					<!-- Custom scripts for all pages-->
					<script src="${path}/a00_com/js/sb-admin-2.min.js"></script>

					<%-- <!-- Page level plugins -->
<script src="${path}/a00_com/vendor/chart.js/Chart.min.js"></script>

<!-- Page level custom scripts -->
<script src="${path}/a00_com/js/demo/chart-area-demo.js"></script>
<script src="${path}/a00_com/js/demo/chart-pie-demo.js"></script>	 --%>

<!-- Sheet JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.31.3/js/jquery.tablesorter.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.14.3/xlsx.full.min.js"></script>
<!--FileSaver savaAs 이용 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/FileSaver.js/1.3.8/FileSaver.min.js"></script>




</body>

<script type="text/javascript">




$("#dname").val("${emplist.dname}").prop("selected", true);
$("#egrade").val("${emplist.egrade}").prop("selected", true);
$("#uptBtn").click(function(){
if(confirm("수정하시겠습니까?")){
	var emailE = document.getElementById('emailE').value;
	var emailH = document.getElementById('emailH').value;
	var email = emailH+emailE;
	if($("[name=ename]").val()==""){
		alert("이름을 입력해야합니다.")
		return;
	}
	$("#send").submit()
}

})
var msg = "${msg}"
if(msg!=""){
if(!confirm(msg+"\n계속 수정하시겠습니까?")){
	session.getAttribute("emp");
location.href="${path}/mainpage"
}
}
</script>
</html>