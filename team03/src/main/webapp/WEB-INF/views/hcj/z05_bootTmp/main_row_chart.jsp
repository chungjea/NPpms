<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>     

	<div class="col-xl-4 col-lg-5">
		<div class="card shadow mb-4">
			<!-- Card Header - Dropdown -->
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">내 프로젝트</h6>
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
	<script src="${path}/a00_com/vendor/chart.js/Chart.min.js"></script>
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
