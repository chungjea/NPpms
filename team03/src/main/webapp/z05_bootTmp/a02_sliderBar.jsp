<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<fmt:requestEncoding value="utf-8"/>
<script type="text/javascript">
	var pcode = ${param.pcode}
</script>
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<br>
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="${path}/mainpage">
				<div class="sidebar-brand-icon rotate-n-15">
				</div>
					<img class="sidebar-card-illustration mb-2"
					src="${path}/a00_com/img/logo.png" alt="늘품 PMS" width="100" height="90">
			</a>
			<br>
			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link"
				href="${path}/mainpage"> <i class="fas fa-fw fa-tachometer-alt"></i> <span>대시보드 Dashboard</span></a>
			</li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">category</div>

			<!-- Nav Item - Pages Collapse Menu -->
			<c:choose>
				<c:when test="${param.pcode != null && param.pcode > 0}">
					<li class="nav-item"><a class="nav-link collapsed" href="#"
						data-toggle="collapse" data-target="#collapsePages"
						aria-expanded="true" aria-controls="collapsePages"> <i
							class="fas fa-fw fa-folder"></i> <span>프로젝트 관리</span>
					</a>
					<div id="collapsePages" class="collapse"
							aria-labelledby="headingPages" data-parent="#accordionSidebar">
						<div class="bg-white py-2 collapse-inner rounded">
							<a class="collapse-item" href="${path}/noticePage?pcode=${param.pcode}">공지 게시판</a> 
							<a class="collapse-item" href="${path}/calendar_f_all?pcode=${param.pcode}">캘린더</a> 
							<a class="collapse-item" href="javascript:goApv()">결재</a>
							<a class="collapse-item" href="javascript:goRsk()">리스크 관리</a>
							<a class="collapse-item" href="javascript:goMet()">회의록</a>
						</div>
					</div></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link collapsed" href="projectList" > <i class="fas fa-fw fa-folder"></i> <span>프로젝트 관리</span> </a></li>
				</c:otherwise>
			</c:choose>
			<c:if test="${param.pcode != null && param.pcode > 0}">
			<li class="nav-item"><a class="nav-link" href="javascript:goFile()">
					<span>문서관리</span>
			</a></li>
			</c:if>
			<li class="nav-item"><a class="nav-link" href="${path}/HRFilter">
					<span>인사관리</span>
			</a></li>
			
			<li class="nav-item"><a class="nav-link" href="${path}/FIFilter">
					<span>재정관리</span>
			</a></li>

			<li class="nav-item"><a class="nav-link"   href="${path}/mypagefilter">
					<span>마이페이지</span>
			</a></li>
 <script>
 onclick="f_clickFunc()"
	var auth = "${emp.auth}"
		
		var sessAuth = "${emp.auth}"
				function f_clickFunc(){	
		if(sessAuth=="관리자") {
			location.href="a70_tablesadmin.jsp" 
			
			
		}else if(sessAuth=="직원"){
			location.href="a70_tables.jsp" 
		}else
			console.log("관리자페이지 권한이 없습니다. 마이페이지로 이동합니다.")
		}
 </script>

			
			<!-- Divider -->
			<hr class="sidebar-divider d-none d-md-block">

			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>

			<!-- Sidebar Message -->
			<div>
				<%--	
				<p class="text-center mb-2">
					<strong>SB Admin Pro</strong> is packed with premium features,
					components, and more!
				</p>
				<a class="btn btn-success btn-sm"
					href="https://startbootstrap.com/theme/sb-admin-pro">Upgrade to
					Pro!</a>
					/
				 --%>	
			</div>

		</ul>     
		<form id="frmapv" method="post" action="${path}/myapv">
			<input type="hidden" name="wempno" value="${emp.empno}" />
			<input type="hidden" name="mempno" value="${emp.empno}" />
			<input type="hidden" name="sts" value="대기"/>
			<input type="hidden" name="pcode" value="${param.pcode}"/>
		</form>
		<form id="frmrsk" method="post" action="${path}/myrsk">
			<input type="hidden" name="wempno" value="${emp.empno}"/>
			<input type="hidden" name="cempno" value="${emp.empno}"/>
			<input type="hidden" name="manager" value="${emp.empno}"/>
			<input type="hidden" name="pcode" value="${param.pcode}"/>
		</form>
		<form id="frmmet" method="post" action="${path}/meeting">
			<input type="hidden" name="pcode" value="${param.pcode}"/>
		</form>
		<form id="frmfile" method="post" action="${path}/file">
			<input type="hidden" name="empno" value="${emp.empno}"/>
			<input type="hidden" name="pcode" value="${param.pcode}"/>
		</form>
		