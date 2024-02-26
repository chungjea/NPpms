<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.text.SimpleDateFormat" %>

<c:set var="path" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<%

Date time1 = new Date();
SimpleDateFormat formatter1 = new SimpleDateFormat(
		"yyyy-MM-dd: (E) HH:mm:ss", Locale.KOREA
		); 
Date starttime=(Date) session.getAttribute("inputS");
Date endtime=(Date) session.getAttribute("inputE");
long timeDifference;
%>

<div class="col-xl-3 col-md-6 mb-4">
							<div class="card border-left-primary shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col mr-2">
											<div
												class="text-xs font-weight-bold text-primary text-uppercase mb-1">
												근태관리</div>
											<div class="card-body"><%=formatter1.format(time1)%></div>
											<div class="h5 mb-0 font-weight-bold text-gray-800">${inputE}-${inputS}</div>
											<div class="progress progress-sm mr-2"></div>

											<div class="h5 mb-0 font-weight-bold text-gray-800">출근시간
												:${inputS}</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800">퇴근시간
												:${inputE}</div>
											<div class="h5 mb-0 font-weight-bold text-gray-800">야근시간
												:${commute_s.overtime}</div>
											<hr
												style="border-width: 1px 0 0 0; border-style: dotted; border-color: #bbb;">
											<form method="post" class="user" action ="${path}/commute_start">
												
												<a href='javascript:$(".user").submit()' id="StartBtn" class="btn btn-light btn-icon-split"> <span
													class="text">&nbsp &nbsp &nbsp &nbsp출근&nbsp &nbsp
														&nbsp &nbsp</span>
												</a> <input type="hidden" name="empno" value="${emp.empno}">
												<input type="hidden" name="ename" value="${emp.ename}">
												<input type="hidden" name="ALLTIME" value="">
												<input type="hidden" name="status" value="s">
												

											</form>
											<form method="post" class="user1" action ="${path}/commute_end">
												
												<a href='javascript:$(".user1").submit()' id="EndBtn" class="btn btn-light btn-icon-split"> <span
													class="text">&nbsp &nbsp &nbsp &nbsp퇴근&nbsp &nbsp
														&nbsp &nbsp</span>
												</a> <input type="hidden" name="empno" value="${emp.empno}">
												<input type="hidden" name="ename" value="${emp.ename}">
												<input type="hidden" name="ALLTIME" value="">
												<input type="hidden" name="status" value="e">
												

											</form>
										</div>


									</div>
								</div>
							</div>
						</div>

<div class="col-xl-4">
	<div class="card shadow ">
		<!-- Card Header - Dropdown -->
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">${emp.auth=='관리자'?'담당':'참여'}
				프로젝트</h6>
		</div>
		<!-- Card Body -->
		<div class="card-body">
			<h5 id="dchartheader"></h5>
			<div class="chart-pie" style="height: 250px;margin:5px">
				<canvas id="myProjectChart"></canvas>
			</div>
		
		</div>
	</div>
</div>
<div class="col-xl-4">
	<div class="card shadow">
		<div class="card-header py-3">
			<div class="row">
			<h6 class="m-0 font-weight-bold text-primary">작업 진행차트</h6>
			</div>
		</div>
		<div class="card-body">
			<div class="chart-bar" style="height: 250px">
				<canvas id="myBarChart"></canvas>
			</div>
			<hr>
			<select class="form-select form-select-sm" style="margin:0px" id="pjselect" onchange="selectpjwork()">
			<c:forEach var="pj" items="${projects}">
				<option value="${pj.pcode}">${pj.pname}</option>
				</c:forEach>
			</select>
		</div>
	</div>
</div>


<script src="${path}/a00_com/vendor/chart.js/Chart.min.js"></script>
<script type="text/javascript">

var labeldata = [];
var cntdata =[];
var totcnt =0;
<c:forEach items="${pjcnt}" var="pj" varStatus="sts">
	labeldata["${sts.index}"] = "${pj.status}"
	cntdata["${sts.index}"] = "${pj.cnt}"
	totcnt += ${pj.cnt}
</c:forEach>
	document.getElementById("dchartheader").innerText = "전체 프로젝트 "+totcnt+"건"

	 console.log(labeldata)
	//도넛차트
	var ctx = document.getElementById("myProjectChart");
	var myProjectChart = new Chart(ctx, {
	  type: 'doughnut',
	  data: {
	    labels:labeldata,
	    datasets: [{
	      data: cntdata,
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
	      displayColors: true
	    },
	    legend: {
	      display: true,
	      position:'bottom',
	      labels: {
	    	  boxWidth:15,
	    	  fontSize:15
          }
	    },
	    cutoutPercentage: 80,
	  },
	});

	//바 차트
	var ctx = document.getElementById("myBarChart");
	var myBarChart = new Chart(ctx, {
  	type: 'horizontalBar',
  data: {
    labels: ["총작업", "진행중인 작업","처리된 작업"],
    datasets: [{
      label: "작업",
      backgroundColor: "#4e73df",
      hoverBackgroundColor: "#2e59d9",
      borderColor: "#4e73df",
      barPercentage: 0.5,
      data: []   
    }],
  },
  options: {
     maintainAspectRatio: false,
     tooltips: {
      titleMarginBottom: 10,
      titleFontColor: '#6e707e',
      titleFontSize: 14,
      backgroundColor: "rgb(255,255,255)",
      bodyFontColor: "#858796",
      borderColor: '#dddfeb',
      borderWidth: 1,
      xPadding: 10,
      yPadding: 10,
      displayColors: true
 
    },  
    scales: {
    	xAxes: [{
            stacked: true
        }]
      }
     
  
  }
});
	</script>
