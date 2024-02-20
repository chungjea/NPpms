//----프로젝트 생성------
	$("#regBtn").click(function(){
		//### 유효성 검사 ###
		if($("[name=pname]").val()==""){
			alert("프로젝트명을 입력해주세요")
			$("[name=pname]").focus()
			return;
		}
		if($("[name=ptype]").val()==0){
			alert("프로젝트유형을 선택해주세요")
			$("[name=ptype]").focus()
			return;
		}
		if($("[name=startdte]").val()==""||$("[name=enddte]").val()==""){
			alert("프로젝트 기간을 입력해주세요")
			
			if($("[name=startdte]").val()==""){
				$("[name=startdte]").focus()
			}else {
				$("[name=enddte]").focus()
			}
			return;
		}
		if($("[name=status]").val()==0){
			alert("프로젝트상태를 선택해주세요")
			$("[name=status]").focus()
			return;
		}
		if($("#teams").val()==""){
			if(!confirm("팀원이 존재하지 않습니다\n그대로 진행하시겠습니까? "))return;
			
		}
		// 프로젝트 생성 시작
		functproject("insertProject")
	
	})
	

	// 사원 조회 모달 - 검색버튼 클릭
	$("#schBtn").click(function(){
		
		 $.ajax({
			type:"post",
			url:"empsearch",
			data:$("#frmEmpSch").serialize(),
			dataType:"json",
			success:function(data){
				
				var emphtml = ""
				
				$.each(data.elist,function(idx, emp){
					
					emphtml += "<tr>"
					emphtml += "<td>"+emp.empno+"</td>"
					emphtml += "<td>"+emp.ename+"</td>"
					emphtml += "<td>"+emp.dname+"</td>"
					emphtml += "<td><a href='#' onclick='addemp(\" "+emp.ename+"\","+emp.empno+")' class='btn btn-success btn-circle btn-sm'> "
					emphtml += '<i class="fas fa-check"></i></a></td>'
					emphtml += "</tr>"
				})
			
				// 조회된 내용으로 tbody 변경
				$("#empSchTbody").html(emphtml)
		
			},
			error:function(err){
				console.log(err)
			}
		}) 
	})
	
	// 조회된 팀원을 프로젝트 팀에 추가
	function addemp(ename,empno){
		var team = $("#teams").val()
		var teams_name = $("#teams_name").text()
		if(team ==""||team == null){ 
			team = empno; 
		}
		else{
			let emps = team.split(",")
			let empck = false;
			emps.forEach(function(emp){
				if(empno == parseInt(emp)){
					alert("이미 추가된 사원입니다.")
					empck = true;
					return;				
				}
			})
			if(empck==true)return;
			else{
				team += ","+empno;
				
			}
		}
		$("#teams").val(team)	
		$("#teams_name").append('<button type="button" id="'+empno+'" class="btn btn-outline-secondary btn-sm" onclick="deleteTeams(this)">'+ename+'</button>')
		alert("팀원이 추가되었습니다")
		$("#echclsBtn").click()
  	}
	function deleteTeams(obj){
		if(confirm($(obj).text()+"사원을 팀에서 제외하시겠습니까?")){
			var teamemp = $("#teams").val().split(",")
			var retval = ""
			teamemp.forEach(function(emp){
				if($(obj).prop("id")!=emp){
					retval += emp+","
				}
			})
			$("#teams").val(retval.slice(0,retval.length-1))
			obj.remove()
			alert("삭제완료")
		}
	}
	function functproject(url){
		var formdata = new FormData($("#frm02")[0]);
		 $.ajax({
			type:"post",
			enctype: 'multipart/form-data',
			url:url,
			data:formdata,
			processData: false,	
			contentType: false,
			dataType:"json",
			success:function(data){
				if(data.msg!=""){
					alert(data.msg)
					location.reload()
				}	
			},
			error:function(err){
				console.log(err)
			}
		}) 
	}