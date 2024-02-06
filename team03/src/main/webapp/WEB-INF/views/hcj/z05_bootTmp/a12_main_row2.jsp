<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8" />
<style>
.pjbox {
	float: left;
	margin: 20px;
	padding: 10px; text-align : center;
	border-radius: 5%;
	width: 250px;
	height:250px;
	
}

.pjbox:hover {
	outline: solid gray;
}

.pjicon {
	width: 150px;
	height: 150px;
	border-radius: 70%;
	overflow: hidden;
	margin: auto;

}

.pjiconImg {
	width: 100%;
	height: 100%;
	object-fit: cover;
}
.d_day{
	position:relative;
	border-radius: 8px;
	background: #e23442;
	color: white;
	text-align: center;
	padding: 5px 5px;
	top: -210px;
 	right: -50px;
 	font-size: 25px;
 	
 	
}
.pjtitle{
	font-size:25px; 
	overflow:hidden;
	white-space:nowrap;
	text-overflow:ellipsis;
	margin-top : 10px ;
	text-align: center;
}
</style>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>


<!-- Content Column -->
<div class="col-lg-12 mb-4">
	<!-- Project Card Example -->
	<div class="card shadow mb-4">
		<div
			class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
			<h6 class="m-0 font-weight-bold text-primary"
				onclick="location.href='${path}/projectList'">프로젝트</h6>
			<c:if test='${emp.auth =="관리자"}'>
				<button type="button" data-toggle="modal"
					data-target="#newprojectModal" class="btn btn-outline-secondary">+</button>
			</c:if>
		</div>

		<div class="card-body">

		<c:forEach begin="1" end="7">
			<div class="pjbox">
			
				<div class="pjicon">
					<img class="pjiconImg"
						src="https://user-images.githubusercontent.com/79133602/135301843-9c3b3466-0639-489c-8913-6fdb846fb64c.png">
				</div>
				
				<div class="pjtitle">프로젝트sdsd</div>
				<div class="progress">
					<div class="progress-bar" role="progressbar" style="width: 70%"
						aria-valuenow="70" aria-valuemin="0" aria-valuemax="100">70%</div>
				</div>
				<span class="d_day">D-7</span>
			</div>

		</c:forEach>
		


		</div>


	</div>
</div>

