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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.31.3/css/theme.grey.min.css" />
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

		<%@ include file="a02_sliderBar.jsp"%>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar-->
				<%@ include file="a03_topBar.jsp"%>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">
					<div class="row">
						<div class="col-xl-3 col-md-6 mb-4" id="link1">
							<div class="card border-left-primary shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-xs font-weight-bold text-primary text-uppercase mb-1">
												현재 사원수</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800"
												id="checking">${empcnt}</div>
										</div>
										<div class="col-auto">
											<i class="fas fa-calendar fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-3 col-md-6 mb-4" id="link2">
							<div class="card border-left-primary shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="co l mr-2">
											<div
												class="text-xs font-weight-bold text-primary text-uppercase mb-1">
												진행중 프로젝트 수</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800">${sumProj}건</div>
										</div>
										<div class="col-auto">
											<i class="fas fa-calendar fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-3 col-md-6 mb-4" id="link3">
							<div class="card border-left-primary shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-xs font-weight-bold text-primary text-uppercase mb-1">
												총수익</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800"
												id="checking1">1,000,000,000원</div>
										</div>
										<div class="col-auto">
											<i class="fas fa-calendar fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-xl-3 col-md-6 mb-4" id="link3">
							<div class="card border-left-primary shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-xs font-weight-bold text-primary text-uppercase mb-1">
												프로젝트 완료 갯수:</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800">총
												${doneProj}건</div>
										</div>
										<div class="col-auto">
											<i class="fas fa-calendar fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- Page Heading -->

					<h1 class="h3 mb-2 text-gray-800">${emp.dname}${emp.auth}페이지</h1>
					<ul class="nav nav-tabs nav-justified">
						<li class="nav-item active"><a class="nav-link" href="#home">전체회원</a></li>
						<li class="nav-item"><a class="nav-link" href="#tab02">삭제인원리스트</a></li>
						<li class="nav-item"><a class="nav-link disabled" href="#"></a></li>
						<li class="nav-item"><a class="nav-link disabled" href="#"></a>
						</li>
					</ul>


					<!-- DataTales Example -->
					<div class="tab-content">
						<div id="home" class="tab-pane fade in active">
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<c:if test='${emp.dname.equals("인사팀")}'>
										<div class="row" />
										<div class="col" />
										<a class="btn btn-danger btn-icon-split" id="delBtn"> <span
											class="icon text-white-50"> <i class="fas fa-trash"></i>
										</span> <span class="text">사원 삭제</span>
										</a>
										<a href="#" class="btn btn-warning btn-icon-split"> <span
											class="icon text-white-50"> <i
												class="fas fa-exclamation-triangle"></i>

										</span> <span class="text">사원정보수정</span>
										</a>


										<a href="${path}/registerFrm"
											class="btn btn-success btn-icon-split"> <span
											class="icon text-white-50"> <i class="fas fa-check"></i>
										</span> <span class="text">사원등록</span>
										</a>
									</c:if>


									<button type="button" class="btn btn-warning btn-circle"
										id="excelDownload" onclick='exportExcel'>
										<img src="${path}/a00_com/img/down_icon.png" width="15"
											height="15">
									</button>

									<a href="${path}/updateFrm"
										class="btn btn-warning btn-icon-split"> <span
										class="icon text-white-50"> <i
											class="fas fa-exclamation-triangle"></i>

									</span> <span class="text">개인정보수정</span>
									</a>



								</div>

								<%--           포멧                            <c:if test='${emp.dname.equals("인사팀")&&emp.auth.equals("관리자")}'>
                                         <a href="#" class="btn btn-warning btn-icon-split">
                                        <span class="icon text-white-50">
                           
                                        
                                            <i class="fas fa-exclamation-triangle"></i>
                                           
                                        </span>
                                        <span class="text">사원정보수정</span>
                                    </a>
                                    </c:if> --%>
								<div class="col-xl-7">
									<form
										class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search"
										id="frm01" class="form" method="post">
										<div class="input-group align-items-end">
											<select name="dname" class="form-control form-control-user">
												<option value="">부서선택</option>
												<option value="디자인팀">디자인팀</option>
												<option value="인사팀">인사팀</option>
												<option value="재무팀">재무팀</option>
												<option value="기획팀">기획팀</option>
												<option value="개발1팀">개발1팀</option>
												<option value="개발2팀">개발2팀</option>
												<option value="개발3팀">개발3팀</option>
											</select> <input class="form-control bg-light border-0 small"
												placeholder="검색할 사원번호" aria-label="Search"
												aria-describedby="basic-addon2" name="empno"
												value="${sch.empno}">

											<div class="input-group-append">
												<button class="btn btn-primary" type="submit">
													<i class="fas fa-search fa-sm">검색</i>

												</button>
											</div>
										</div>
									</form>
								</div>

								<div class="card-body">
									<div class="table-responsive">

										<div style="width: 100%; height: 200px;">
											<c:if test='${emp.dname!="재무팀"&&emp.auth.equals("관리자")}'>

												<table class="table table-bordered" id="dataTable"
													width="100%" cellspacing="0">

													<thead>
														<tr>
															<th>사원번호</th>
															<th>사원명</th>
															<th>부서명</th>
															<th>입사일</th>
															<th>급여</th>
															<th>패널티횟수</th>
															<th>마지막수정시각</th>
															<th>마지막수정인</th>
															<th><input type="checkbox" id="chkAll"></th>
														</tr>
													</thead>

													<tbody>
														<c:forEach var="el" items="${empList}">
															<tr>
																<td onClick="location.href=">${el.empno}</td>
																<td onClick="location.href=">${el.ename}</td>
																<td onClick="location.href=">${el.dname}</td>
																<td onClick="location.href=">${el.hiredate}</td>
																<td onClick="location.href=">${el.salary}</td>
																<td onClick="location.href=">${el.panaltytot}</td>
																<td onClick="location.href=">${el.lastfix}</td>
																<td onClick="location.href=">${el.lastone}</td>
																<td><input type="checkbox" id="chk" class="chkGrp"
																	value="${el.empno}" name="checkboxModel"></td>
															</tr>
														</c:forEach>
													</tbody>
												</table>

											</c:if>
										</div>
									</div>
									<div>
										<div class="card shadow mb-4">
											<div class="card-header py-3">
												<c:if test='${emp.dname.equals("인사팀")}'>
													<div class="row" />
													<div class="col" />
													<a class="btn btn-danger btn-icon-split" id="delBtn"> <span
														class="icon text-white-50"> <i class="fas fa-trash"></i>
													</span> <span class="text">사원 삭제</span>
													</a>
													<a href="#" class="btn btn-warning btn-icon-split"> <span
														class="icon text-white-50"> <i
															class="fas fa-exclamation-triangle"></i>

													</span> <span class="text">사원정보수정</span>
													</a>


													<a href="${path}/registerFrm"
														class="btn btn-success btn-icon-split"> <span
														class="icon text-white-50"> <i class="fas fa-check"></i>
													</span> <span class="text">사원등록</span>
													</a>
												</c:if>


												<button type="button" class="btn btn-warning btn-circle"
													id="excelDownload" onclick='exportExcel'>
													<img src="${path}/a00_com/img/down_icon.png" width="15"
														height="15">
												</button>

												<a href="${path}/updateFrm"
													class="btn btn-warning btn-icon-split"> <span
													class="icon text-white-50"> <i
														class="fas fa-exclamation-triangle"></i>

												</span> <span class="text">개인정보수정</span>
												</a>



											</div>

											<%--           포멧                            <c:if test='${emp.dname.equals("인사팀")&&emp.auth.equals("관리자")}'>
                                         <a href="#" class="btn btn-warning btn-icon-split">
                                        <span class="icon text-white-50">
                           
                                        
                                            <i class="fas fa-exclamation-triangle"></i>
                                           
                                        </span>
                                        <span class="text">사원정보수정</span>
                                    </a>
                                    </c:if> --%>
											<div class="col-xl-7">
												<form
													class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search"
													id="frm01" class="form" method="post">
													<div class="input-group align-items-end">
														<select name="dname"
															class="form-control form-control-user">
															<option value="">부서선택</option>
															<option value="디자인팀">디자인팀</option>
															<option value="인사팀">인사팀</option>
															<option value="재무팀">재무팀</option>
															<option value="기획팀">기획팀</option>
															<option value="개발1팀">개발1팀</option>
															<option value="개발2팀">개발2팀</option>
															<option value="개발3팀">개발3팀</option>
														</select> <input class="form-control bg-light border-0 small"
															placeholder="검색할 사원번호" aria-label="Search"
															aria-describedby="basic-addon2" name="empno"
															value="${sch.empno}">

														<div class="input-group-append">
															<button class="btn btn-primary" type="submit">
																<i class="fas fa-search fa-sm">검색</i>

															</button>
														</div>
													</div>
												</form>
											</div>
										</div>
										<div class="card-body">
											<div class="table-responsive">

												<div style="width: 100%; height: 200px;">
													<c:if test='${emp.dname!="재무팀"&&emp.auth.equals("관리자")}'>

														<table class="table table-bordered" id="dataTable"
															width="100%" cellspacing="0">

															<thead>
																<tr>
																	<th>사원번호</th>
																	<th>사원명</th>
																	<th>부서명</th>
																	<th>입사일</th>
																	<th>급여</th>
																	<th>패널티횟수</th>
																	<th>마지막수정시각</th>
																	<th>마지막수정인</th>
																	<th><input type="checkbox" id="chkAll"></th>
																</tr>
															</thead>

															<tbody>
																<c:forEach var="el" items="${empList}">
																	<tr>
																		<td onClick="location.href=">${el.empno}</td>
																		<td onClick="location.href=">${el.ename}</td>
																		<td onClick="location.href=">${el.dname}</td>
																		<td onClick="location.href=">${el.hiredate}</td>
																		<td onClick="location.href=">${el.salary}</td>
																		<td onClick="location.href=">${el.panaltytot}</td>
																		<td onClick="location.href=">${el.lastfix}</td>
																		<td onClick="location.href=">${el.lastone}</td>
																		<td><input type="checkbox" id="chk"
																			class="chkGrp" value="${el.empno}"
																			name="checkboxModel"></td>
																	</tr>
																</c:forEach>
															</tbody>
														</table>

													</c:if>
												</div>
											</div>
										</div>
									</div>
								</div>
							
							</div>
							
							</div>
										</div>
												<div id="tab02" class="tab-pane fade">
													<div class="card-body">
														<div class="table-responsive">


															<c:if
																test='${emp.dname.equals("재무팀")&&emp.auth.equals("관리자")}'>

																<table class="table table-bordered" id="dataTable1"
																	width="100%" cellspacing="0">
																	<thead>
																		<tr>
																			<th>사원번호</th>
																			<th>사원명</th>
																			<th>부서명</th>
																			<th>입사일</th>
																			<th>급여</th>
																			<th>인센티브</th>
																			<th>마지막수정시각</th>
																			<th><input type="checkbox" id="chkAll"></th>
																		</tr>
																	</thead>

																	<tbody>
																		<c:forEach var="sl" items="${salList}">
																			<tr>
																				<td
																					onClick="/team03/src/main/webapp/WEB-INF/views/kjw/z05_bootTmp/detailpage.jsp'">${sl.empno}</td>
																				<td
																					onClick="/team03/src/main/webapp/WEB-INF/views/kjw/z05_bootTmp/detailpage.jsp'">${sl.ename}</td>
																				<td
																					onClick="/team03/src/main/webapp/WEB-INF/views/kjw/z05_bootTmp/detailpage.jsp'">${sl.dname}</td>
																				<td
																					onClick="/team03/src/main/webapp/WEB-INF/views/kjw/z05_bootTmp/detailpage.jsp'">${sl.egrade}</td>
																				<td
																					onClick="/team03/src/main/webapp/WEB-INF/views/kjw/z05_bootTmp/detailpage.jsp'">${sl.salary}</td>
																				<td
																					onClick="/team03/src/main/webapp/WEB-INF/views/kjw/z05_bootTmp/detailpage.jsp'">${sl.incentive}</td>
																				<td
																					onClick="/team03/src/main/webapp/WEB-INF/views/kjw/z05_bootTmp/detailpage.jsp'">${sl.lastfix}</td>
																				<td><input type="checkbox" id="chk"
																					class="chkGrp" value="${sl.empno}"
																					name="checkboxModel"></td>
																			</tr>
																		</c:forEach>
																	</tbody>
																</table>
															</c:if>


														</div>

														<%@page buffer="8192kb" autoFlush="true"%>
													</div>
													<!-- /.container-fluid -->

												
										<!-- End of Main Content -->

										<!-- Footer -->
									</div>
								</div>
				</div>
				</div>
			</div>
		

		<footer class="sticky-footer bg-white">
			<div class="container my-auto">
				<div class="copyright text-center my-auto">
					<span>Copyright &copy; Your Website 2021</span>
					
				</div>
			</div>
			</footer>
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
	<script src="${path}/a00_com/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="${path}/a00_com/js/sb-admin-2.min.js"></script>

	<%-- <!-- Page level plugins -->
<script src="${path}/a00_com/vendor/chart.js/Chart.min.js"></script>

<!-- Page level custom scripts -->
<script src="${path}/a00_com/js/demo/chart-area-demo.js"></script>
<script src="${path}/a00_com/js/demo/chart-pie-demo.js"></script>	 --%>

	<!-- Sheet JS -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.31.3/js/jquery.tablesorter.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.14.3/xlsx.full.min.js"></script>
	<!--FileSaver savaAs 이용 -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/FileSaver.js/1.3.8/FileSaver.min.js"></script>




</body>

<script type="text/javascript">
$(document).ready(function(){
	  $(".nav-tabs a").click(function(){
	    $(this).tab('show');
	  });
	});
var dname="${el.dname}"


$('input:checkbox[name=checkboxModel]').each(function (index) {
	if($(this).is(":checked")==true){
    	console.log($(this).val());
    }
})
$(function() {
  $("#dataTable").tablesorter();
});

$("#checking").hide();
$("#checking1").hide();
	var sessId = "${emp.empno}"
	if(sessId==""){
		alert("로그인을 하여야 현재화면을 볼 수 있습니다\n로그인 페이지 이동")
		location.href="${path}/login"
	}
	$(function (){
		$("#chkAll").click(function(){
			$(".chkGrp").attr("checked",this.checked);
			var chk=$(this).is(":checked");
			console.log(chk);
		});
	});



	
	$("#delBtn").click(function(){
	var checkedvals =$(".chkGrp:checked").map(function(){
	return $(this).val();
	console.log($(this).val());
	}).get();
	if(checkedvals.length==0){
	alert("삭제처리할 인원을 1명이상 선택하세요");
	return;
	}
	var confirming = confirm(" 삭제하시겠습니까?");
	if(!confirming){
	return;
	}
	
	$.ajax({
		url:'${path}/deleteEmps',
		method:'POST',
		contentType:'application/json; charset=utf-8',
		data:JSON.stringify(checkedvals),
		success:function(response){
		if(response.status=="success"){
		alert("선택된 인원정보가 삭제되었습니다");
		console.log(response)
		location.reload();
		}else{
		alert("실패:"+response.message);
		}
},
error:function(xhr,status,err){
alert("진행도중 문제발생");
console.error("Error:",status,err);
}
		});
	
});
	var count=0;
var dname= "${emp.dname}"
	var auth="${emp.auth}"
		$(document).ready(function(){
			if(dname=="인사팀"){
				$("#checking").show();
			}
			if(dname=="재무팀"){
				$("#checking1").show();
			}
	    });
			
			//엑셀 외부 js 사용할진 미지수
			const excelDownload = document.querySelector('#excelDownload');

document.addEventListener('DOMContentLoaded', ()=>{
    excelDownload.addEventListener('click', exportExcel);
});

function exportExcel(){ 
	count=count+1;
  // step 1. workbook 생성
  var wb = XLSX.utils.book_new();

  // step 2. 시트 만들기 
  var newWorksheet = excelHandler.getWorksheet();

  // step 3. workbook에 새로만든 워크시트에 이름을 주고 붙인다.  
  XLSX.utils.book_append_sheet(wb, newWorksheet, excelHandler.getSheetName());

  // step 4. 엑셀 파일 만들기 
  var wbout = XLSX.write(wb, {bookType:'xlsx',  type: 'binary'});

  // step 5. 엑셀 파일 내보내기 
  saveAs(new Blob([s2ab(wbout)],{type:"application/octet-stream"}), excelHandler.getExcelFileName());
}

var excelHandler = {
    getExcelFileName : function(){
        return '${emp.dname}'+'인원리스트'+count+'.xlsx';	//파일명
    },
    getSheetName : function(){
        return '${emp.dname}'+'인원리스트';	//시트명
    },
    getExcelData : function(){
        return document.getElementById('dataTable'); 	//TABLE id
    },
    getWorksheet : function(){
        return XLSX.utils.table_to_sheet(this.getExcelData());
    }
}

function s2ab(s) { 
  var buf = new ArrayBuffer(s.length); //convert s to arrayBuffer
  var view = new Uint8Array(buf);  //create uint8array as viewer
  for (var i=0; i<s.length; i++) view[i] = s.charCodeAt(i) & 0xFF; //convert to octet
  return buf;    
}
//이전키 방지
window.history.forward();
function noBack(){window.history.forward();}



			
</script>
</html>