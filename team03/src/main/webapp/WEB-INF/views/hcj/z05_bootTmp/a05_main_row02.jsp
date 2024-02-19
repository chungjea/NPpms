<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8" />






<div class="col-xl-5 col-lg-7">
	<div class="card shadow mb-4">
		<!-- Card Header - Dropdown -->
		<div
			class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
			<h6 class="m-0 font-weight-bold text-primary">이슈</h6>
			
		</div>
		<!-- Card Body -->
		<div class="card-body">
			<div class="table-responsive">
            	<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
	                <tr>
	                <th>프로젝트명</th>
	                <th>작업</th>
	                <th>이슈사항</th>
	                <th>상태</th>
	                </tr>
	            
	            <c:forEach var="err" items="${errList}">
	            <tr>
	            <td>${err.pname}</td>
	            <td>${err.wname}</td>
	            <td>${err.content}</td>
	            <td>${err.status}</td>
	            </tr>
	            </c:forEach>
	            
                </table>
		</div>
	</div>
</div>
</div>


<div class="col-xl-7 col-lg-5">
	<div class="card shadow mb-4">
		<!-- Card Header - Dropdown -->
		<div
			class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
			<h6 class="m-0 font-weight-bold text-primary">내 작업</h6>
			
		</div>
		<!-- Card Body -->
		<div class="card-body">
			<table class="table table-bordered" id="workTable" width="100%" cellspacing="0">
	                <tr>
	                <th>프로젝트명</th>
	                <th>작업명</th>
	                <th>마감일</th>
	                <th>작업 진행도</th>
	            <c:forEach var="work" items="${workList}">
	                </tr>
	        	    	<td>${work.pname}</td>
	    	        	<td></td>
		            	<td><fmt:parseDate var="enddte" value="${work.enddte}" pattern="yyyy-MM-dd"/>
            		<fmt:formatDate value="${enddte}" pattern="yyyy-MM-dd"/></td>
		            	<td><div class="progress">
				<div class="progress-bar" role="progressbar"
					style="width:${work.progress}%" aria-valuenow="${work.progress}" aria-valuemin="0"
					aria-valuemax="100">${work.progress}%</div>
			</div></td>
		            </tr>
	            </c:forEach>
            </table>
		</div>
	</div>
</div>
