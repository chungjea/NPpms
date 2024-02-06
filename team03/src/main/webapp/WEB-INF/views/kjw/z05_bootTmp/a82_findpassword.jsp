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
	<div class="input-group mb-3" style="display:none;">	
		<div class="input-group-prepend ">
			<span class="input-group-text  justify-content-center">
				발신자</span>
		</div>
		<input readonly class="form-control" 
			value="ssangyoung5555@gmail.com" />	
	</div>
	<div class="input-group mb-3" >	
		<div class="input-group-prepend "  style="display:none;">
			<span class="input-group-text  justify-content-center">
				제목</span>
		</div>
		<input name="title"   class="form-control" />	
	</div>	
                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-password-image"></div>
                          <form method="post">
                            
                                <div class="p-5">
                                    <div class="text-center">
                                       		<div class="input-group-prepend " style="display:none;">
			<a>하단에 이메일을 적고 전송버튼을 누르시면 현재 비밀번호가 이메일로 전송됩니다.</a>
		</div>
                                    </div>
                                    <div class="input-group-prepend " style="display:none;">
			<span class="input-group-text  justify-content-center">
				메일내용</span>
				<textarea id="chatArea" name="content"
			 class="form-control"  >${emp.passwd}</textarea>	
				
		</div>
		<div class="input-group-prepend " style="display:none;">
			<span class="input-group-text  justify-content-center">
				사번</span>
				<input name="title"  placeholder="사번" class="form-control" />	
				
		</div>
	
                                    
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                               name="receiver" aria-describedby="emailHelp"
                                               placeholder="메일 주소 입력" >
                                        </div>
                                    
                                     <input type="submit" id="SendBtn" class="btn btn-primary btn-user btn-block">
                                           
                                        
			<script type="text/javascript">
			var msg = "${msg}"
			if(msg!=""){
				alert(msg);
			}
		</script>
                                    </form>
                                    <div class="text-center">
                                        <a class="small" href="${path}/login">계정이 있을시 클릭</a>
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

	
</body>
</html>