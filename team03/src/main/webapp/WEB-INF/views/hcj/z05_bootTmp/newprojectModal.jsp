<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" import="backendweb.z01_vo.*"
	import="backendweb.d01_dao.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8" />
<div class="modal fade" id="newprojectModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="projectmodalheader">프로젝트 생성</h5>
				
			</div>
			<div class="modal-body">
				<form id="frm02" class="form" action="${path}/insertProject"
					method="post" enctype="multipart/form-data">
				<input type="hidden" name="pcode"  value="0"/> 
					<div class="row">
						<div class="col">
							프로젝트 명 <input type="text" class="form-control"
								placeholder="프로젝트 명을 입력헤주세요" name="pname">
						</div>
					</div>
					<div class="row">
						<div class="col">
							사진선택 <input class="form-control" type="file" id="image"
								accept="image/*" onchange="seticonimage(this)" name="reports" />


						</div>

					</div>
					<div class="row">
						<div
							style="width: 150px; height: 150px; border-radius: 70%; border: solid 1px; margin: 10px auto; overflow: hidden;"
							id="image_preview">
							<img class="pjiconImg" id="previewImage" src="" style="width: 100%;height: 100%;object-fit: cover">
						</div>
					</div>
					<div class="row">
						<div class="col">
							프로젝트 유형 <select class="form-control" name="ptype">
								<option hidden value="0">프로젝트 유형을 선택해주세요</option>
								<option>웹서비스</option>
								<option>emp</option>
								<option>pms</option>
								<option>자재관리</option>
								<option>기타요청</option>
							</select>
						</div>
					</div>
					<div class="row">
						<div class="col">
							프로젝트 매니저 <input type="text" readonly class="form-control"
								value="${emp.ename}"  name="mgname"> <input type="hidden" name="empno"
								value="${emp.empno}">
						</div>
					</div>
					팀원 설정 <span id="teamname"></span>
					<div class="row">
						<div class="col-9">
							<input type="text" id="team" class="form-control" name="tname" />
							<!-- 팀이름 -->

							<!-- 팀원의 사원번호값 -->

						</div>
						<div class="col-3">
							<input type="button" class="form-control" id="teamaddBtn"
								value="팀원추가" data-toggle="modal" data-target="#empSearchModal" />
						</div>
					</div>
					<div class="row">
						<div class="col" id="teams_name">
							<!-- 팀원이름을 표시할 칸 -->

						</div>
					</div>
					<div class="row">
						<div class="col">
							시작일 <input type="date" class="form-control" name="startdte" />
						</div>
						<div class="col">
							마감일 <input type="date" class="form-control" name="enddte" />
						</div>
					</div>
					<div class="row">
						<div class="col">
							프로젝트 내용
							<textarea class="form-control" name="content"></textarea>
						</div>
					</div>
					<div class="row">
						<div class="col">
							프로젝트 상태 <select class="form-control" name="status">
								<option hidden value="0">프로젝트 상태를 선택해주세요</option>
								<option>예정</option>
								<option>진행중</option>
								<option>완료</option>
								<option>중단</option>
							</select>
						</div>
					</div>

				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-success" id="uptBtn">수정</button>
				<button type="button" class="btn btn-danger" id="delBtn">삭제</button>
				<button type="button" class="btn btn-primary" id="regBtn">생성</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>	
			</div>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/hcj/z05_bootTmp/empsch.jsp" %>
<script>
const img = document.getElementById("previewImage");
const imgbox = document.getElementById("image_preview")
imgbox.style.display="none";
	function seticonimage(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(event) {
				imgbox.style.display = "";
				img.src = event.target.result;
			};
			reader.readAsDataURL(input.files[0]);

		} else {
			img.src = "";
		}
	}
</script>
