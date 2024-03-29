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
<title>NPpms</title>




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
<link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
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
					<div class="col-lg-5 d-none d-lg-block">
						<img src="${path}/a00_com/images/pms_logo_re.png" alt="늘품 PMS">
					</div>
					<div class="col-lg-7">
						<div class="p-5">
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">회원등록</h1>
							</div>
							<form method="post" id="send" action="${path}/register">

								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<p>
											<strong>사원명을 입력하세요</strong> <input
												name="ename" id="ename"
												class="form-control form-control-user" placeholder="사원명" />
									</div>
									<div class="col-sm-6 mb-3 mb-sm-0">
										<p>
											<strong>직급을 선택하세요</strong> <select
												name="egrade" id="egrade" class="form-control form-control-user">
												<option value="">직급</option>
												<option value="사원">사원</option>
												<option value="팀장">팀장</option>
												<option value="전무">전무</option>
												<option value="사장">사장</option>

											</select>
									</div>

								</div>
								<div class="form-group row">
									<div class="col-sm-6 ">
										<select name="dname" class="form-control form-control-user">
											<option value="">부서선택</option>
											<option value="디자인팀">디자인팀</option>
											<option value="인사팀">인사팀</option>
											<option value="재무팀">재무팀</option>
											<option value="기획팀">기획팀</option>
											<option value="개발1팀">개발1팀</option>
											<option value="개발2팀">개발2팀</option>
											<option value="개발3팀">개발3팀</option>
										</select>
									</div>
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="date" name="hiredate"
											class="form-control form-control-user" placeholder="입사일" />
									</div>
								</div>

								<div class="form-group row">

									<div class="col-sm-5 mb-3 mb-sm-0">
										<input type="text" name="emailH" id="emailH" 
											class="form-control form-control-user" placeholder="이메일주소" />
	
									</div>


									<span class="col-sm-0 mb-3 mb-sm-0">@</span>
									<div class="col-sm-6 mb-3 mb-sm-0">
										<select name="emailE" id="emailE" class="form-control">
											<option value="@naver.com">naver.com</option>
											<option value="@daum.net">daum.net</option>
											<option value="@gmail.com">gmail.com</option>
										</select>
										<div id="resultArea"></div>
										  <!-- <input type="hidden" id="password" name="password" value=""> 
										 -->
										<input type="hidden" id="email" name="email" value="">
											<div class="col-sm-6 mb-3 mb-sm-0">
										<select name="auth" class="form-control form-control-user">
											<option value="">권한</option>
											<option value="직원">직원</option>
											<option value="관리자">관리자</option>

										</select>
									<br>
									<br>
									<br>
										
										
										  <!-- <input type="hidden" id="password" name="password" value=""> 
										 -->
										<input type="hidden" id="email" name="email" value="">
							<input type="hidden" id="passwd" name="passwd" value="">
										<!-- <input type="hidden" id="title" name="title"
											value="회원등록된 정보를 전송해드립니다.">
 -->



									</div>
								</div>

								<input type="button" class="btn btn-primary btn-user btn-block"
									id="regBtn" value="등록">


								<hr>

</div>
							</form>


							<hr>
							<div class="text-center">
								<a class="small" href="forgot-password.jsp">Forgot Password?</a>
							</div>
							<div class="text-center">
								<a class="small" href="${path}/login">Already have an
									account? Login!</a>
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
				<span>Copyright &copy; 늘품 PMS</span>
			</div>
		</div>
	</footer>
	<!-- End of Footer -->


	<!-- End of Content Wrapper -->


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

            	/* var msg = "${msg}"
						if(msg!=""){
							alert(msg);
						}else{
							$("#email").submit()
						} */
												$("#regBtn").click(function(){ //등록
														temp_pw_issuance();
													 var egrade=document.getElementById('egrade'); 
													 var passwd=document.getElementById('passwd').value; 
														 var emailE=document.getElementById('emailE').value;
															var emailH=document.getElementById('emailH').value;
														var receiver=document.getElementById('emailH').value+document.getElementById('emailE').value;
														
														  
														document.getElementById('email').value= emailH+emailE;
														 document.getElementById('passwd').value= passwd; 
													
            	
						if (confirm("등록하시겠습니까?")) {
			                // 이름이 비어있는지 확인
			                if (ename === "") {
			                    alert("이름을 입력해야합니다.");
			                    return;
			                }

			                // Ajax를 통해 서버로 데이터 전송
			                $.ajax({
			                    type: "POST",
			                    url: "${path}/register",
			                    data: $("#send").serialize(), // 폼 데이터 전송
			                    success: function (response) {
			                        // 서버 응답을 화면에 표시
			                        alert("등록성공");
			                    },
			                    error: function () {
			                        alert("서버 오류가 발생했습니다.");
			                    }
			                });
						}
						})
		/* 	var msg = "${msg}"
			if(msg!=""){
				
				if(!confirm(msg+"\n계속 등록하시겠습니까?")){
					location.href="${path}/mainpage"
						
				}
			} */

		//비밀번호 생성기
		function temp_pw_issuance() {
			let ranValue1 = [ '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' ];
			let ranValue2 = [ 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
					'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
					'W', 'X', 'Y', 'Z' ];
			let ranValue3 = [ 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
					'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
					'w', 'x', 'y', 'z' ];
			let ranValue4 = [ '!', '@', '#', '$', '%', '^', '&', '*', '(', ')' ];

			var temp_pw = "";

			for (i = 0; i < 2; i++) {
				let ranPick1 = Math.floor(Math.random() * ranValue1.length);
				let ranPick2 = Math.floor(Math.random() * ranValue2.length);
				let ranPick3 = Math.floor(Math.random() * ranValue3.length);
				let ranPick4 = Math.floor(Math.random() * ranValue4.length);
				temp_pw = temp_pw + ranValue1[ranPick1] + ranValue2[ranPick2]
						+ ranValue3[ranPick3] + ranValue4[ranPick4];
			}
			return temp_pw;
		}
		document.getElementById('passwd').value = temp_pw_issuance();
		/* document.getElementById('password').value = temp_pw_issuance(); */
		
		
		
		
		//ajax를 통해 실시간으로 db저장된 이메일값 비교
		
        
		
		
		
		
		
		
	</script>
</body>
</html>