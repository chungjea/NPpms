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
	padding: 10px;
	text-align: center;
	border-radius: 5%;
	width: 250px;
	height: 250px;
	-ms-user-select: none;
	-moz-user-select: -moz-none;
	-webkit-user-select: none;
	-khtml-user-select: none;
	user-select: none;
	transition-duration: 0.2s;
}

.pjbox:hover {
	outline: solid #A9BCF5;
	background-color: #EFF5FB;
	transform: scale(1.1, 1.1);
	transition-duration: 0.3s;
}

.pjicon {
	width: 150px;
	height: 150px;
	border-radius: 70%;
	overflow: hidden;
	margin: auto;
	border: solid gray 1px;
}

.pjiconImg {
	width: 100%;
	height: 100%;
	object-fit: cover;
}

.d_day {
	position: relative;
	border-radius: 100%;
	background: #e23442;
	color: white;
	text-align: center;
	padding: 5px 13px;
	top: -210px;
	right: -50px;
	font-size: 25px;
}

.pjtitle {
	font-size: 25px;
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
	margin-top: 10px;
	text-align: center;
	margin-bottom: -10px;
}

.pjcontainer {
	overflow-x: scroll;
	overflow-y: hidden;
	width: 100px;
	display: flex;
	margin-bottom: 10px;
}

.pjcontainer::-webkit-scrollbar {
	width: 1px; /* 스크롤바의 너비 */
}

.pjcontainer::-webkit-scrollbar-thumb {
	background: #A9BCF5; /* 스크롤바의 색상 */
	border-radius: 10px;
}

.pjcontainer::-webkit-scrollbar-track {
	background: rgba(33, 122, 244, .1); /*스크롤바 뒷 배경 색상*/
}
</style>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>


<!-- Content Column -->
<h2>진행중인 프로젝트</h2>
<div class="pjcontainer">
	<c:forEach var="pj" items="${projects}">
		<div class="pjbox">

			<div class="pjicon">
				<img class="pjiconImg"
					src="https://user-images.githubusercontent.com/79133602/135301843-9c3b3466-0639-489c-8913-6fdb846fb64c.png">
			</div>

			<div class="pjtitle">${pj.pname}</div>
			<div style="font-size: 12px">마감일 <fmt:parseDate var="enddte" value="${pj.enddte}" pattern="yyyy-MM-dd"/>
            		<fmt:formatDate value="${enddte}" pattern="yyyy-MM-dd"/> / PMS</div>
			<div class="progress">
				<div class="progress-bar" role="progressbar" style="width: ${pj.progress}%"
					aria-valuenow="${pj.progress}" aria-valuemin="0" aria-valuemax="100">${pj.progress}%</div>
			</div>
			<span class="d_day">7</span>
		</div>
	</c:forEach>
</div>