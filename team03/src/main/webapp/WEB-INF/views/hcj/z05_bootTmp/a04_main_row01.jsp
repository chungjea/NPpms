<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8" />
<!-- Earnings (Monthly) Card Example -->
<div class="col-xl-3 col-md-6 mb-4">
	<div class="card border-left-primary shadow h-100 py-2">
		<div class="card-body">
			<div class="row no-gutters align-items-center">
				<div class="col mr-2">
					<div
						class="text-xs font-weight-bold text-primary text-uppercase mb-1">
						진행중인 ${emp.auth=='관리자'?'담당':'참여' } 프로젝트</div>
					<div class="h5 mb-0 font-weight-bold text-gray-800">${projectCnt}건</div>
				</div>
				<div class="col-auto">
					<i class="fas fa-calendar fa-2x text-gray-300"></i>
				</div>
			</div>
		</div>
	</div>
</div>



<!-- Earnings (Monthly) Card Example -->
<div class="col-xl-3 col-md-6 mb-4">
	<div class="card border-left-info shadow h-100 py-2">
		<div class="card-body">
			<div class="row no-gutters align-items-center">
				<div class="col mr-2">
					<div class="text-xs font-weight-bold text-info text-uppercase mb-1">
					진행중인 ${emp.auth=='관리자'?'담당':'참여' } 프로젝트 작업
					</div>
							<div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">${workcnt}건</div>			
				</div>
				<div class="col-auto">
					<i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Pending Requests Card Example -->
<div class="col-xl-3 col-md-6 mb-4">
	<div class="card border-left-warning shadow h-100 py-2">
		<div class="card-body">
			<div class="row no-gutters align-items-center">
				<div class="col mr-2">
					<div
						class="text-xs font-weight-bold text-warning text-uppercase mb-1">
						${emp.auth=='관리자'?'담당':'참여' } 프로젝트의 미처리된 이슈</div>
					<div class="h5 mb-0 font-weight-bold text-gray-800">${errcnt}건</div>
				</div>
				<div class="col-auto">
					<i class="fas fa-comments fa-2x text-gray-300"></i>
				</div>
			</div>
		</div>
	</div>
</div>