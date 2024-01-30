<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<div class="col-xl-3 col-lg-4">
		<div class="card shadow mb-4">
			<!-- Card Header - Dropdown -->
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">담당 프로젝트</h6>
			</div>
            <!-- Card Body -->
			<div class="card-body">
			<h5>전체 프로젝트:${allprojectCnt}개</h5>
				<div class="chart-pie pt-4">
					<canvas id="myProjectChart"></canvas>
				</div>                                    
			</div>
		</div>
	</div>
<!-- Content Column -->
<div class="col-lg-9 mb-4">
	<!-- Project Card Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
			<h6 class="m-0 font-weight-bold text-primary" onclick="location.href='${path}/projectList.do2'">프로젝트</h6>
			<c:if test='${emp.auth =="관리자"}'>
			<button type="button" data-toggle="modal" data-target="#newprojectModal" class="btn btn-outline-secondary">+</button>
			</c:if>
		</div>
		
		<div class="card-body">
			<div class="table-responsive">
            	<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
            		<tr>
            		<th>팀</th>
            		<th>프로젝트 명</th>
            		<th>프로젝트 유형</th>
            		<th>마감일</th>
            		<th>상태</th>
            		<th>진행도</th>
            		</tr>
            	<c:forEach var="pj" items="${projects}">
            		<tr>
            		<td>${pj.tname}</td>
            		<td>${pj.pname}</td>
            		<td>${pj.ptype}</td>
            		<td><fmt:parseDate var="enddte" value="${pj.enddte}" pattern="yyyy-MM-dd"/>
            		<fmt:formatDate value="${enddte}" pattern="yyyy-MM-dd"/></td>
            		<td>${pj.status}</td>
            		<td><div class="progress">
				<div class="progress-bar" role="progressbar"
					style="width:${pj.progress}%" aria-valuenow="${pj.progress}" aria-valuemin="0"
					aria-valuemax="100">${pj.progress}%</div>
			</div></td>
            		</tr>
            	</c:forEach>
            	</table>
			</div>
		</div>
	</div>
</div>	

<%-- <div class="modal fade" id="newprojectModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">프로젝트 생성</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
		<form id="frm02" class="form" action="${path}/insertProject.do2" method="post">
	     <div class="row">
	      <div class="col">
	      	프로젝트 명
	        <input type="text" class="form-control" placeholder="프로젝트 명을 입력헤주세요" name="pname">
	      </div>  
	     </div>
	     <div class="row">
	     <div class="col">
	     	프로젝트 유형
	        <select class="form-control" name="ptype">
	        <option hidden value="0">프로젝트 유형을 선택해주세요</option>
		        <option>웹서비스</option>
		        <option>emp</option>
		        <option>pms</option>
		        <option>자재관리</option>
		        <option>기타요청</option>
	        </select>
	      </div>
	     </div>
	      <div class="row">
	     <div class="col">
	     	팀장
	        <input type="text" readonly class="form-control" value="${emp.ename}">
	        <input type="hidden" name="empnoStr" value="${emp.empno}">
	      </div>
	     </div>
	     팀개발
	     <div class="row">
	     
	     <div class="col">
	   
	     <input type="button"  class="form-control" value="부서개발" id="deptBtn"/>
	     </div>
	     <div class="col">
	     	<input type="button"  class="form-control" value="팀개발" id="teamBtn"/>
	     </div>
	     </div>
	     <span id="teamname"></span>
	     <div class="row">
	     <div class="col-9">
	     	
	        <input type="hidden" id="team" class="form-control" name="tname"/> <!-- 팀이름 -->
	        <input type="hidden" id="teams" name="teams"/><!-- 팀원의 사원번호값 -->
	        <input type="hidden" id="teamtype" name="ttype" value=""/><!-- 팀 타입 -->
      		
	      </div>
	      <div class="col-3">
	      <input type="hidden" class="form-control" id="teamaddBtn" value="팀원추가" data-toggle="modal" data-target="#empSearchModal"/>
	      </div>
	     </div>
	     <div class="row">
	     	<div class="col" id="teams_name" ><!-- 팀원이름을 표시할 칸 -->
	     		
	     	</div>
	     </div>
	     <div class="row">
	     	<div class="col">
	     		시작일
	     		<input type="date" class="form-control" name="startdte"/>
	     	</div>
	     	<div class="col">
	     		마감일
	     		<input type="date" class="form-control" name="enddte"/>
	     	</div>
	     </div>
	     <div class="row">
	     	<div class="col">
	     	프로젝트 내용
	     		<textarea class="form-control" name="content"></textarea>
	     	</div>
	     </div>
	     <div class="row">
	     <div class="col">
	     	프로젝트 상태
	        <select class="form-control" name="status">
	        <option hidden value="0">프로젝트 상태를 선택해주세요</option>
	        <option>예정</option>
	        <option>진행중</option>
	        <option>완료</option>
	        <option>중단</option>
	        </select>
	      </div>
	     </div>

	    </form> 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="regBtn">생성</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
      </div>
    </div>
  </div>
</div>
 --%>

<script src="${path}/WEB-INF/views/hcj/a00_com/vendor/chart.js/Chart.min.js"></script>
	<script type="text/javascript">
	
	
	var ctx = document.getElementById("myProjectChart");
	var myProjectChart = new Chart(ctx, {
	  type: 'doughnut',
	  data: {
	    labels: ["완료된 프로젝트","진행중인 프로젝트","예정된 프로젝트","중단된 프로젝트"],
	    datasets: [{
	      data: [${CompleteprojectCnt}, ${projectCnt},${ExpectedprojectCnt},${stopedprojectCnt}],
	      backgroundColor: ['#4e73df', '#1cc88a','#eded1f',"#ed261f"],
	      hoverBackgroundColor: ['#2e59d9', '#17a673','#ccc618','#cc1f18'],
	      hoverBorderColor: "rgba(234, 236, 244, 1)",
	    }],
	  },
	  options: {
	    maintainAspectRatio: false,
	    tooltips: {
	      backgroundColor: "rgb(255,255,255)",
	      bodyFontColor: "#858796",
	      borderColor: '#dddfeb',
	      borderWidth: 1,
	      xPadding: 15,
	      yPadding: 15,
	      displayColors: false,
	      caretPadding: 10,
	    },
	    legend: {
	      display: false
	    },
	    cutoutPercentage: 80,
	  },
	});
	</script>
