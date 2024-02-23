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
</style> 
 
     <!-- Custom fonts for this template-->
    <link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">
 
 
 
</head>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		if("${emp}"==""){
		   alert("로그인후 이용해주세요")
		   location.href="${path}/login"
		}
	})
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
                        <h1 class="h3 mb-0 text-gray-800">결재</h1>
                        <a href="javascript:goInsert()" class="btn btn-secondary btn-icon-split">
                                <span class="icon text-white-50">
                                	<i class="fas fa-arrow-right"></i>
                            	</span>
                        	<span class="text">결재 작성하기</span>
                        </a>
                    </div>
                    <form id="insapvFrm" method="post" action="${path}/insertapvFrm">
                    	<input type="hidden" name="deptno" value="${emp.deptno}" />
                    	<input type="hidden" name="pcode" value="${param.pcode}" />
                    </form>
					<script type="text/javascript">
						function goInsert(){
					    	$("#insapvFrm").submit()
						}
					</script>
                    <div class="row">
	                    <div class="col-xl-3 col-md-6 mb-4">
	                    	<div class="card border-left-primary shadow h-100 py-2">
	                        	<div class="card-body">
	                            	<div class="row no-gutters align-items-center">
	                                	<div class="col mr-2">
	                                    	<div class="text-xs font-weight-bold text-uppercase mb-1">
	                                        	상신한</div>
	                                        <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">${myapvcnt}건</div>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
                        
                        <div class="col-xl-3 col-md-6 mb-4">
	                    	<div class="card border-left-primary shadow h-100 py-2">
	                        	<div class="card-body">
	                            	<div class="row no-gutters align-items-center">
	                                	<div class="col mr-2">
	                                    	<div class="text-xs font-weight-bold text-uppercase mb-1">
	                                        	반려된</div>
	                                        <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">${badapvcnt}건</div>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    
	                    <div class="col-xl-3 col-md-6 mb-4">
	                    	<div class="card border-left-primary shadow h-100 py-2">
	                        	<div class="card-body">
	                            	<div class="row no-gutters align-items-center">
	                                	<div class="col mr-2">
	                                    	<div class="text-xs font-weight-bold text-uppercase mb-1">
	                                        	완료된</div>
	                                        <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">${goodapvcnt}건</div>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    
	                    <div class="col-xl-3 col-md-6 mb-4">
	                    	<div class="card border-left-primary shadow h-100 py-2">
	                        	<div class="card-body">
	                            	<div class="row no-gutters align-items-center">
	                                	<div class="col mr-2">
	                                    	<div class="text-xs font-weight-bold text-uppercase mb-1">
	                                        	결제할</div>
	                                        <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">${toapvcnt}건</div>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
                    </div>
					<br>
					<br>
					<br>
                    <div class="row">
                    	&nbsp;&nbsp;&nbsp;
                    	<ul class="pagination  justify-content-center">
                    	<li class="page-item ${sch.sts=='대기'?'active':''}">
                    	<a class="page-link" id="mysubmit" href="javascript:goPage1('대기')">상신한 문서</a></li>
                    	<li class="page-item ${sch.sts=='반려'?'active':''}">
                    	<a class="page-link" id="return" href="javascript:goPage1('반려')">반려된 문서</a></li>
                    	<li class="page-item ${sch.sts=='결재'?'active':''}">
                    	<a class="page-link" id="tocheck" href="javascript:goPage2('결재')">결재할 문서</a></li>
                    	<li class="page-item ${sch.sts=='완료'?'active':''}">
                    	<a class="page-link" id="finish" href="javascript:goPage1('완료')">완료된 문서</a></li>
                    	</ul>
                    	<form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search"
								id="frm01" class="form" method="post">
							<div class="input-group align-items-end" >
								<input class="form-control border-0 small" placeholder="제목" name="title" value="${sch.title}">
								<input type="hidden" name="curPage" value="${sch.curPage}"/>
								<input type="hidden" name="wempno" value="${emp.empno}"/>
								<input type="hidden" name="mempno" value="${emp.empno}"/>
								<input type="hidden" id="sts" name="sts" value="${sch.sts}"/>
								<input type="hidden" name="pcode" value="${param.pcode}"/>
								<div class="input-group-append">
									<button class="btn btn-primary" onclick="schapv()" type="button" id="schBtn">
										<i class="fas fa-search fa-sm"></i>
									</button>
								</div>
							</div>
						</form>
						<span id="cnt" class="mt-4" style="align-item:left important!; width:150px; font-weight: bolder; color:black;">검색결과: ${sch.count}건</span>
                    </div>
                    <script type="text/javascript">
		                $("[name=title]").keyup(function(){
							if(event.keyCode==13){
								schapv()
							}
		                })
	                    function goPage1(sts){
	                    	$("#sts").val(sts)
	                    	$("[name=title]").val("")
	                    	$("[name=curPage]").val("0")
							$("#frm01").attr("action","${path}/myapv")
					    	$("#frm01").submit()
	            		}
	                    function goPage2(sts){
	                    	$("#sts").val(sts)
	                    	$("[name=title]").val("")
	                    	$("[name=curPage]").val("0")
							$("#frm01").attr("action","${path}/ckapv")
					    	$("#frm01").submit()
	            		}
	                   var title = "${sch.title}"
	                   if(title==""){
	                	   $("#cnt").hide()
	                   }else{
	                	   $("#cnt").show()
	                   }
	                   function schapv(){
	                    	var sts = $("#sts").val()
	                    	if(sts=="결재"){
		                    	$("[name=curPage]").val("0")
								$("#frm01").attr("action","${path}/ckapv")
						    	$("#frm01").submit()
	                    	}else{
		                    	$("[name=curPage]").val("0")
								$("#frm01").attr("action","${path}/myapv")
						    	$("#frm01").submit()
	                    	}
	                    }
                    </script>
                    <br>
                    <table class="table table-hover table-striped">
					   	<col width="15%">
					   	<col width="25%">
					   	<col width="20%">
					   	<col width="20%">
					   	<col width="20%">
					    <thead>
					      <tr class="text-center" style="background-color:skyblue;">
					        <th>결재 상태</th>
					        <th>제목</th>
					        <th>기안자</th>
					        <th>결재자</th>
					        <th>상신한 날짜</th>
					      </tr>
					    </thead>	
					    <tbody>
					    	<c:forEach var="apv" items="${apvList}">
					    		<tr ondblclick="goDetail(${apv.apvno})"><td>${apv.sts}</td><td>${apv.title}</td><td>${apv.writer}</td><td>${apv.manager}</td><td><fmt:formatDate value="${apv.regdte}"/></td></tr>
					    	</c:forEach>
					    </tbody>
					</table>
					<form method="post" id="frm02" action="${path}/detailapv">
						<input id="test" name="apvno" type="hidden">
						<input name="pcode" type="hidden" value="${param.pcode}"/>
					</form>
					<script type="text/javascript">
					    function goDetail(no){
					    	$("#test").val(no)
					    	$("#frm02").submit()
					    }
					</script>
					<ul class="pagination  justify-content-center">
						<li class="page-item">
						<a class="page-link" href="javascript:goPage(${sch.startBlock-1})">Previous</a></li>
						<c:forEach var="pcnt" begin="${sch.startBlock}" end="${sch.endBlock}">
							<li class="page-item ${sch.curPage==pcnt?'active':''}">
							<a class="page-link" href="javascript:goPage(${pcnt})">${pcnt}</a></li>
						</c:forEach>
						<li class="page-item"><a class="page-link" href="javascript:goPage(${sch.endBlock+1})">Next</a></li>
					</ul>
					<script type="text/javascript">
						function goPage(pcnt){
							$("#sts").val("${param.sts}")
							$("[name=curPage]").val(pcnt)
							$("#frm01").submit();
						}
					</script>	
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

</body>
</html>