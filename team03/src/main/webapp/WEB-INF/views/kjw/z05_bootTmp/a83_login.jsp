<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<c:set var="path" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NPpms</title>






<!-- Custom fonts for this template1-->
<link href="${path}/a00_com/vendor/fontawesome-free/css/all.min.css"
   rel="stylesheet" type="text/css">
<link
   href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
   rel="stylesheet">

<!-- Custom styles for this template-->
<link href="${path}/a00_com/css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body class="bg-gradient-primary" onload="noBack();"
   onpageshow="if(event.persisted) noBack();" onunload="">

   <div class="container">

      <!-- Outer Row -->
      <div class="row justify-content-center">

         <div class="col-xl-10 col-lg-12 col-md-9">

            <div class="card o-hidden border-0 shadow-lg my-5">
               <div class="card-body p-0">
                  <!-- Nested Row within Card Body -->
                  <div class="row">
                     <div class="col-lg-6 d-none d-lg-block">
                        <img src="a00_com/images/pms_logo_re.png" />
                     </div>
                     <div class="col-lg-6">
                        <div class="p-5">
                           <div class="text-center">
                              <h1 class="h4 text-gray-900 mb-4">
                                 <spring:message code="login" />
                              </h1>
                           </div>
                           <form class="user" method="post" id="userform">
                              <div class="form-group">
                                 <input type="text" name="empno"
                                    class="form-control form-control-user"
                                    id="exampleInputEmail" aria-describedby="emailHelp"
                                    placeholder='<spring:message
                     code="empno" />' />
                     <h6 id="emptyempno">※사번을 입력해주세요</h6>
                              </div>
                              <div class="form-group">
                                 <input type="password" name="passwd"
                                    class="form-control form-control-user"
                                    id="exampleInputPassword"
                                    placeholder='<spring:message
                     code="passwd" />' />
                     <h6 id="emptypwd">※비밀번호를 입력해주세요</h6>
                              </div>
                              <div class="form-group"></div>
                              <button type="button" onclick="check()"
                                 class="btn btn-primary btn-user btn-block"> <spring:message
                                    code="login" />
                              </button>
                             <input type="hidden" name="multiLang" value="">
                              <hr>
                              <select class="form-control" id="selectLan">
                                 <option value=""><spring:message code="chlange" /></option>
                                 <option value="ko"><spring:message code="ko" /></option>
                                 <option value="en"><spring:message code="en" /></option>
                              </select>

                           </form>
                           <form>
                           
                           </form>
                           <hr>
                           <div class="text-center">
                              <a class="small" href="${path}/findpwd">비밀번호찾기</a>
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

   <!-- Page level plugins -->
   <%-- <script src="${path}/a00_com/vendor/chart.js/Chart.min.js"></script>

<!-- Page level custom scripts -->
<script src="${path}/a00_com/js/demo/chart-area-demo.js"></script>
<script src="${path}/a00_com/js/demo/chart-pie-demo.js"></script>    --%>

   <script>
   document.getElementById("emptyempno").style.color = "red";
   document.getElementById("emptypwd").style.color = "red";
   var empno = "${emp.empno}"
   var emptyempno;
   var emptypwd;
   function check(){
	   if ($("[name=empno]").val() == "" && $("[name=passwd]").val() == "") { // 사번 값과 비밀번호 값이 공백일 때
	        alert("아이디와 비밀번호를 입력해주세요");
	        $("#emptyempno").show();
	        $("#emptypwd").show();
	        return false;
	    } else if ($("[name=empno]").val() == "") { // 사번 값이 공백일 때
	        alert("아이디를 입력해주세요");
	        $("#emptyempno").show();
	        $("#emptypwd").hide();
	        return false;
	    } else if ($("[name=passwd]").val() == "") { // 비밀번호 값이 공백일 때
	        alert("비밀번호를 입력해주세요");
	        $("#emptypwd").show();
	        $("#emptyempno").hide();
	        return false;
	    } else { // 비밀번호 값과 사번 값이 모두 입력되어 있을 때
	        $("#emptyempno").hide();
	        $("#emptypwd").hide();
	        $("#userform").submit();
	        return true;
	    }

   }
   
   
$(document).ready(function() {
   // 다국어처리와 로그인관련 경고글
   $("#selectLan").val("${param.lang}").change(function() {
      var chVal = $(this).val()
       $("[name=multiLang]").val = $(this).val()
      if (chVal != '') {
         location.href = "${path}/login?lang=" + chVal
      }
   })
   $("#emptyempno").hide();
   $("#emptypwd").hide();
})

if ("${param.empno}" != "") {
   if (empno != "") {
      location.href = "${path}/mainpage"
      
   } else {
      alert("로그인 실패\n다시 로그인하세요")
      console.log(${param.empno})

   }
}



      $("[name=passwd]").keyup(function() {
      if (event.keyCode == 13) {
             check();
         }
      })
      $("[name=empno]").keyup(function() {
      if (event.keyCode == 13) {
             check();
         }
      })
 

 

            
/*       window.history.forward();
      function noBack() {
         window.history.forward();
      } */
   </script>

</body>
</html>