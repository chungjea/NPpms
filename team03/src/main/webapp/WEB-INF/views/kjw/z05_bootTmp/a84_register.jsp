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

 
 
     <!-- Custom fonts for this template-->
    <link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">
 
 
 
</head>

<body class="bg-gradient-primary">

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                            </div>
                            <form method="post" id="send" action="${path}/register.do4">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                      
                                        <input name="ename" class="form-control form-control-user"   placeholder="사원명" />	
                                    </div>
                                    <div class="col-sm-6">
 										<input name="egrade" class="form-control form-control-user"   placeholder="직급" />	
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input name="dname" class="form-control form-control-user"   placeholder="부서명" />	
                                </div>
                                <div class="form-group row">

                                    <div class="col-sm-6">
                                        <input name="hiredate" class="form-control form-control-user"   placeholder="입사일" />	
                                    </div>
                                    <div class="col-sm-6">
                                        <input name="passwd" class="form-control form-control-user" type="password"  placeholder="비밀번호" />	
                                    </div>
                                </div>
                                <a class="btn btn-primary btn-user btn-block" id="regBtn">
                                    Register Account
                                </a>
                                <hr>


                            </form>
                            <hr>
                            <div class="text-center">
                                <a class="small" href="forgot-password.jsp">Forgot Password?</a>
                            </div>
                            <div class="text-center">
                                <a class="small" href="login.do4">Already have an account? Login!</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; Your Website 2021</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->
	
<!-- Bootstrap core JavaScript-->
    <script src="${path}/a00_com/vendor/jquery/jquery.min.js"></script>
<script
	src="${path}/a00_com/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="${path}/a00_com/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="${path}/a00_com/js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<script src="${path}/a00_com/vendor/chart.js/Chart.min.js"></script>

<!-- Page level custom scripts -->
<%-- <script src="${path}/a00_com/js/demo/chart-area-demo.js"></script>
<script src="${path}/a00_com/js/demo/chart-pie-demo.js"></script>	 --%>
            <script type="text/javascript">
				$("#regBtn").click(function(){
					alert($("#send").serialize())
					
					if(confirm("등록하시겠습니까?")){
						if($("[name=ename]").val()==""){
							alert("이름을 입력해야합니다.")
							return;
						}
						$("#send").submit()
					}
					
				})
			var msg = "${msg}"
			if(msg!=""){
				if(!confirm(msg+"\n계속 등록하시겠습니까?")){
					location.href="${path}/registerFrm"
				}
			}
			</script>
</body>
</html>