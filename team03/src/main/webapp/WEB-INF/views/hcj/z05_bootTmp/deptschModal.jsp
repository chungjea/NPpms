<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>     
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >

<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://developers.google.com/web/ilt/pwa/working-with-the-fetch-api" type="text/javascript"></script>
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">


<div class="modal fade" id="DeptSearchModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">사원 조회</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
		<form id="frmEmpSch" class="form"  method="post">
  	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <input type="number" placeholder="부서번호" name="deptno"  class="form-control mr-sm-2" />
	    <input placeholder="부서명" name="dname"  class="form-control mr-sm-2"/>
	    <button class="btn btn-info" type="button" id="schBtn">검색</button>
	    
 	</nav>
	</form>
   <table class="table table-hover table-striped">
   	<col width="33%">
   	<col width="34%">
   	<col width="33%">
    <thead>
    
      <tr class="table-success text-center">
        <th>부서번호</th>
        <th>부서명</th>
        <th>주소</th>
      </tr>
    </thead>	
    <tbody id="empSchTbody">
    	<c:forEach var="emp" items="${elist}">
    	<tr>
	    	<td>${emp.empno}</td>
	    	<td>${emp.ename}</td>
	    	<td>${emp.dname}</td>
	    	<td><a href="#" onclick="addemp('${emp.ename}')" class="btn btn-success btn-circle btn-sm">
	            <i class="fas fa-check"></i>
	 			</a>
	 		</td>
 		</tr>
    	</c:forEach>
    </tbody>
	</table>    
      </div>
      <div class="modal-footer">    
        <button type="button" class="btn btn-secondary" data-dismiss="modal" id="echclsBtn">닫기</button>
      </div>
    </div>
  </div>
</div>

