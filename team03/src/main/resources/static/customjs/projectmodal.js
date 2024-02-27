//----프로젝트 생성------
var members = new Map();
	$("#regBtn").click(function(){
		//### 유효성 검사 ###
		if($("#frm02 [name=pname]").val()==""){
			alert("프로젝트명을 입력해주세요")
			$("#frm02 [name=pname]").focus()
			return;
		}
		if($("#frm02 [name=ptype]").val()==0){
			alert("프로젝트유형을 선택해주세요")
			$("#frm02 [name=ptype]").focus()
			return;
		}
		if($("#frm02 [name=startdte]").val()==""||$("#frm02 [name=enddte]").val()==""){
			alert("프로젝트 기간을 입력해주세요")
			
			if($("#frm02 [name=startdte]").val()==""){
				$("#frm02 [name=startdte]").focus()
			}else {
				$("#frm02 [name=enddte]").focus()
			}
			return;
		}
		if($("#frm02 [name=status]").val()==0){
			alert("프로젝트상태를 선택해주세요")
			$("#frm02 [name=status]").focus()
			return;
		}
		if($("#frm02 #teams").val()==""){
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
		if(members.has(empno)){
			alert("중복된 사원입니다.")
		}else{
			members.set(empno,ename)
			alert(ename+"사원 추가")
			$("#teams_name").append('<button type="button" id="'+empno+'" class="btn btn-outline-secondary btn-sm" onclick="deleteTeams(this)">'+ename+'</button>')
			$("#echclsBtn").click()
		}
 	}
 	
	function deleteTeams(obj){
		if(confirm($(obj).text()+"사원을 팀에서 제외하시겠습니까?")){
			if(members.delete(parseInt($(obj).prop("id")))){
				obj.remove()
				alert("삭제완료")	
			}			
		}
	}
	
	function functproject(url){
		var formdata = new FormData($("#frm02")[0]);
	  	var memidx = 0;
		members.forEach(function(value,key){
			formdata.append("tmem["+memidx+"].key",key)
			formdata.append("tmem["+memidx+"].label",value)
			memidx++;
		})   
		
		  $.ajax({
			type:"post",
			enctype: 'multipart/form-data',
			url:url,
			data:formdata,
			processData: false,	
			contentType: false,
			dataType:"text",
			success:function(data){
			
					location.reload()
				
			},
			error:function(err){
				console.log(err)
			}
		})  
	}
	
	function loadProjectinfo(pcode){
		$("#projectmodalheader").text("프로젝트 관리") 
		$("#uptBtn").show()
		$("#delBtn").show()
		$("#regBtn").hide()
		$.ajax({
			url:"loadpinfo",
			type:"post",
			data:"pcode="+pcode,
			datatype:"json",
			success:function(pinfo){
					
				$("#frm02 #titleheader").text(pinfo.pname);
				$("#frm02 [name=pcode]").val(pinfo.pcode);
				$("#frm02 [name=pname]").val(pinfo.pname);
				$("#frm02 [name=ptype]").val(pinfo.ptype);
				$("#frm02 [name=empno]").val(pinfo.empno);
				$("#frm02 [name=mgname]").val(pinfo.mgname);
				$("#frm02 [name=startdte]").val(pinfo.startdte.substring(0,10));
				$("#frm02 [name=enddte]").val(pinfo.enddte.substring(0,10));
				$("#frm02 [name=content]").val(pinfo.content);
				$("#frm02 [name=status]").val(pinfo.status);
				$("#frm02 [name=teams]").val(pinfo.tname);
				
				$("#frm02 #teams_name").html("");
				members.clear()
				if(pinfo.tmem.length >0){
						pinfo.tmem.forEach(function(mem){	
						$("#frm02 #teams_name").append('<button type="button" id="'+mem.key+'" class="btn btn-outline-secondary btn-sm" onclick="deleteTeams(this)">'+mem.label+'</button>');
						members.set(mem.key,mem.label);			
					})
				}
				if(pinfo.ino == ""){
							imgbox.style.display="none";	
				}else{
					imgbox.style.display="";				
					img.src=pinfo.path+"icon"+pinfo.ino+pinfo.ext;
				}
				
			},
			error:function(err){
				console.log(err)
			}
		})
		
	}