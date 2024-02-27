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
<script type="text/javascript">
	if("${emp}"==""){
	    alert("로그인후 이용해주세요")
		location.href="${path}/login"
	}
</script>

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
	//var empno = "${mem.empno}"
	//var name = "${mem.ename} / ${mem.dname}"
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
                        <h1 class="h3 mb-0 text-gray-800">리스크 관리</h1>
                        <a href="javascript:goInsert()" class="btn btn-secondary btn-icon-split">
                                <span class="icon text-white-50">
                                	<i class="fas fa-arrow-right"></i>
                            	</span>
                        	<span class="text">리스크 등록</span>
                        </a>
                    </div>
                    <form id="insrskFrm" method="post" action="${path}/insertrskFrm">
                    	<input type="hidden" name="pcode" value="${param.pcode}" />
                    </form>
					<script type="text/javascript">
						function goInsert(){
					    	$("#insrskFrm").submit()
						}
					</script>
					
                    <div class="row" style="align-self: center !important; display:flex;">
                    	<div class="col-xl-3 col-md-6 mb-4">
	                    	<div class="card border-left-primary shadow h-100 py-2">
	                        	<div class="card-body">
	                            	<div class="row no-gutters align-items-center">
	                                	<div class="col mr-2">
	                                    	<div class="text-xs font-weight-bold text-uppercase mb-1">
	                                        	등록한</div>
	                                        <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">${myrskcnt}건</div>
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
	                                        	처리할</div>
	                                        <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">${ckrskcnt}건</div>
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
	                                        	담당중</div>
	                                        <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">${torskcnt}건</div>
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
	                                        <div class="h5 mb-0 font-weight-bold text-gray-800 text-center">${finrskcnt}건</div>
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
                    	<li class="page-item ${sts=='1'?'active':''}">
                    	<a class="page-link" id="mysubmit" href="javascript:goPage1(${emp.empno})">등록한 리스크</a></li>
                    	<li class="page-item ${sts=='2'?'active':''}">
                    	<a class="page-link" id="myck" href="javascript:goPage2(${emp.empno})">처리할 리스크</a></li>
                    	<li class="page-item ${sts=='3'?'active':''}">
                    	<a class="page-link" id="tocheck" href="javascript:goPage3(${emp.empno})">담당중인 리스크</a></li>
                    	<li class="page-item ${sts=='4'?'active':''}">
                    	<a class="page-link" id="finish" href="javascript:goPage4(${emp.empno})">완료된 리스크</a></li>
                    	</ul>
                    <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search"
								id="frm01" class="form" method="post">
						<div class="input-group align-items-end" >
							<input class="form-control border-0 small" placeholder="제목" name="title" value="${sch.title}">
							<input type="hidden" name="curPage" value="${sch.curPage}"/>
	                    	<input type="hidden" name="wempno" id="1" value="${emp.empno}"/>
	                    	<input type="hidden" name="cempno" id="2" value="${emp.empno}"/>
	                    	<input type="hidden" name="manager" id="3" value="${emp.empno}"/>
	                    	<input type="hidden" name="pcode" value="${param.pcode}"/>
							<div class="input-group-append">
								<button class="btn btn-primary" onclick="schrsk()" type="button" id="schBtn">
									<i class="fas fa-search fa-sm"></i>
								</button>
							</div>
						</div>
					</form>
					<span id="cnt" class="mt-4" style="align-item:left important!; width:150px; font-weight: bolder; color:black;">검색결과: ${sch.count}건</span>
                    </div>
                    <script type="text/javascript">
	                    function goPage1(no){
							$("[name=curPage]").val("0")
					    	$("#1").val(no)
					    	$("#2").val(no)
					    	$("#3").val(no)
							$("#frm01").attr("action","${path}/myrsk")
					    	$("#frm01").submit()
	            		}
	                    function goPage2(no){
							$("[name=curPage]").val("0")
					    	$("#1").val(no)
					    	$("#2").val(no)
					    	$("#3").val(no)
							$("#frm01").attr("action","${path}/ckrsk")
					    	$("#frm01").submit()
	            		}
	                    function goPage3(no){
							$("[name=curPage]").val("0")
					    	$("#1").val(no)
					    	$("#2").val(no)
					    	$("#3").val(no)
							$("#frm01").attr("action","${path}/torsk")
					    	$("#frm01").submit()
	            		}
	                    function goPage4(no){
							$("[name=curPage]").val("0")
					    	$("#1").val(no)
					    	$("#2").val(no)
					    	$("#3").val(no)
							$("#frm01").attr("action","${path}/finrsk")
					    	$("#frm01").submit()
	            		}
		                 $("[name=title").keyup(function(){
								if(event.keyCode==13){
									schrsk()
								}
		                  })
		                   var title = "${sch.title}"
		                   if(title==""){
		                	   $("#cnt").hide()
		                   }else{
		                	   $("#cnt").show()
		                   }
		                  function schrsk(){
	                    		var sts = "${sts}"
	                    		if(sts=="1"){
		    						$("#frm01").attr("action","${path}/myrsk")
		    					    $("#frm01").submit()
	                    		}else if(sts=="2"){
	                    			$("#frm01").attr("action","${path}/ckrsk")
		    					    $("#frm01").submit()
	                    		}else if(sts=="3"){
	                    			$("#frm01").attr("action","${path}/torsk")
		    					    $("#frm01").submit()
	                    		}else if(sts=="4"){
	                    			$("#frm01").attr("action","${path}/finrsk")
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
					        <th>리스크 상태</th>
					        <th>제목</th>
					        <th>담당자</th>
					        <th>우선순위</th>
					        <th>기한</th>
					      </tr>
					    </thead>	
					    <tbody>
					    	<c:forEach var="rsk" items="${rskList}">
					    		<tr ondblclick="goDetail(${rsk.rskno})"><td>${rsk.sts}</td><td>${rsk.title}</td><td>${rsk.charge}</td><td>${rsk.priority}</td><td><fmt:formatDate value="${rsk.finaldte}"/></td></tr>
					    	</c:forEach>
					    </tbody>
					</table>
					<form method="post" id="frm02" action="${path}/detailrsk">
						<input id="test" name="rskno" type="hidden">
                    	<input type="hidden" name="empno" value="${emp.empno}" />
						<input name="pcode" type="hidden" value="${param.pcode}">
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
							var empno = "${emp.empno}"
					    	$("#1").val(empno)
					    	$("#2").val(empno)
					    	$("#3").val(empno)
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

<!-- Page level plugins -->
<script src="${path}/a00_com/vendor/chart.js/Chart.min.js"></script>

<script src="${path}/customjs/slidbar.js"></script>

</body>
</html>