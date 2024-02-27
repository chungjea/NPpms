a<%@ page language="java" contentType="text/html; charset=UTF-8"
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

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <img src="${path}/a00_com/img/logo.png"  class="col-lg-6 d-none d-lg-block " />
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-2">비밀번호를 찾아드립니다</h1>
                                        <p class="mb-4">하단에 사번을 입력하여 저장된 이메일로 비밀번호를 전달해드립니다.</p>
                                    </div>
                                    <form method="post" id="send" action="${path}/register">
                                        <div class="form-group">
                                            <input type="empno" class="form-control form-control-user"
                                                id="empno" 
                                                placeholder="사번을 입력하세요">
                                                <input type="hidden" id="password" value="">
                                        </div>
                                        <a type="button" id="sendBtn" class="btn btn-primary btn-user btn-block">
                                            전송
                                        </a>
                                    </form>
                                    <hr>
                                    
                                    <div class="text-center">
                                        <a class="small" href="${path}/login">계정이 있으십니까? 이 링크를 눌러 로그인 해주세요</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>
	
<!-- Bootstrap core JavaScript-->
    <script src="${path}/a00_com/vendor/jquery/jquery.min.js"></script>
<script
	src="${path}/a00_com/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="${path}/a00_com/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="${path}/a00_com/js/sb-admin-2.min.js"></script>

<script>
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
document.getElementById('password').value = temp_pw_issuance();

</script>
</body>
</html>