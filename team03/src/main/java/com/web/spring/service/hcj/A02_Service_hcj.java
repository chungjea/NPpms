package com.web.spring.service.hcj;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.spring.dao.hcj.A03_Dao_hcj;
import com.web.spring.vo.Data;
import com.web.spring.vo.Emp_pinfo_f;
import com.web.spring.vo.Error_f;
import com.web.spring.vo.IconRep_f;
import com.web.spring.vo.ProjectSch;
import com.web.spring.vo.Project_f;
import com.web.spring.vo.Project_work_f;
import com.web.spring.vo.Task_f;
import com.web.spring.vo.Tmem_f;

@Service
public class A02_Service_hcj {
	@Autowired(required = false)
	private A03_Dao_hcj dao;
	//전체 프로젝트 수(admin-담당한)
	public int getAllMyProjectCntAdmin(int empno){return dao.getAllMyProjectCntAdmin(empno);}
	//전체 프로젝트 수(normal-참여한)
	public int getAllMyProjectCntNormal(int empno){return dao.getAllMyProjectCntNormal(empno);}
	
	// 완료중인 프로젝트 수(admin-담당한)
	public int getCompleteProjectCntAdmin(int empno){return dao.getCompleteProjectCntAdmin(empno);}
	// 완료중인 프로젝트 수(normal-참여한)
	public int getCompleteProjectCntNormal(int empno){return dao.getCompleteProjectCntNormal(empno);}
	// 예정중인 프로젝트 수(admin-담당한)
	public int getExpectedProjectCntAdmin(int empno){return dao.getExpectedProjectCntAdmin(empno);}
	// 예정중인 프로젝트 수(normal-참여한)
	public int getExpectedProjectCntNormal(int empno){return dao.getExpectedProjectCntNormal(empno);}
	// 중단된 프로젝트 수(admin-담당한)
	public int getStopedProjectCntAdmin(int empno){return dao.getStopedProjectCntAdmin(empno);}
	// 중단된 프로젝트 수(normal-참여한)
	public int getStopedProjectCntNormal(int empno){return dao.getStopedProjectCntNormal(empno);}
	// 진행중인 프로젝트 수(admin-담당한)
	public int getProceedProjectCntAdmin(int empno){return dao.getProceedProjectCntAdmin(empno);}
	// 진행중인 프로젝트 수(normal-참여한)
	public int getProceedProjectCntNormal(int empno){return dao.getProceedProjectCntNormal(empno);}
	
	
	// 내 담당 프로젝트 5개까지 불러오기(진행중인상태 우선)
	public List<Project_f> getprojectsAdmin(int empno){
		return dao.getprojectsAdmin(empno);	
	}
	// 내가 참여한 프로젝트 5개까지 불러오기(진행중인상태 우선)
	public List<Project_f> getprojectsNormal(int empno){
		return dao.getprojectsNormal(empno);
	}
	
	
	
	// 프로젝트 생성
	public String insertProject(Project_f ins) {
		System.out.println("프로젝트 생성 시작!!!");
		String msg = dao.insertProject(ins)>0?"프로젝트 생성성공!":"프로젝트 생성 실패";
		System.out.println(ins.getReports());
		if(ins.getReports()!= null) {	
			System.out.println("아이콘이미지 생성 시도!!!");
			String path = "C:/a01_springbt/workspace/maven.1708074911159/team03/src/main/resources/static/z01_upload/";
			String dbpath = "/z01_upload/";
			try {
						
					// 1. 파일 업로드
					// 파일명을 가져오기..
					
					String frealname = ins.getReports().getOriginalFilename();
					String savename = dao.getIconNum();
					String fname = frealname.substring(0, frealname.lastIndexOf("."));
					String ext = frealname.substring(frealname.lastIndexOf("."));
					
					
					System.out.println(path+savename+ext);
					System.out.println("리얼네임:"+frealname);
					System.out.println("파일이름:"+fname);
					System.out.println("확장자:"+ext);
					ins.getReports().transferTo(new File(path+savename+ext));
					
					// 2. 업로드된 파일정보를 DB저장..(추후에 활용할 목적)(
					dao.insertIconfile(new IconRep_f(fname,dbpath,ext));
					// FileRep(int no, String fname, String path, String etc) 
					System.out.println("아이콘이미지 생성 성공");
					
			} catch (IllegalStateException e) {
				System.out.println("파일업로드 예외1:"+e.getMessage());
			} catch (IOException e) {
				System.out.println("파일업로드 예외2:"+e.getMessage());
			}
		
		}
		/*
		 * if(!teams.equals("")) { String[] tmems = teams.split(","); int cnt = 0;
		 * for(String tmem : tmems) {
		 * 
		 * cnt += dao.insertTMemInNewProject(Integer.parseInt(tmem)); } msg +=
		 * cnt+"명의 팀 추가 완료"; }
		 */
		System.out.println("프로젝트 생성 완료");
		return msg;
	}
	
	public int updateProject(Project_f upt) {
		List<Tmem_f> curTmem = dao.getTeamMemeber(upt.getPcode());
		//List<Tmem_f> uptTmem = upt.get
		return 0;
	}
	
	// 사원 검색
	public List<Emp_pinfo_f> getemplist(Emp_pinfo_f sch){
		if(sch.getDname()==null||sch.getDname()=="")return dao.getemplist(sch);
		return dao.getemplistByLike(sch);
	}
	// 미완료 상태인 담당프로젝트의 작업들건수 불러오기(Admin)
	public int getmyWorkCntAdmin(int empno) {
		return dao.getmyWorkCntAdmin(empno);
	}
	// 미완료 상태인 내프로젝트의 작업들건수 불러오기(Normal)
		public int getmyWorkCntNormal(int empno) {
			return dao.getmyWorkCntNormal(empno);
		}
	
	
	// 내 작업리스트 가져오기byempno(Admin)
	public List<Project_work_f> getProjectWorkByEmpnoAdmin(int empno){
		return dao.getProjectWorkByEmpnoAdmin(empno);
	}
	
	// 내 작업리스트 가져오기byempno(Normal)
	public List<Project_work_f> getProjectWorkByEmpnoNormal(int empno){
		return dao.getProjectWorkByEmpnoNormal(empno);
	}
	
	// 내 담당 프로젝트의 미처리 상태인 이슈건수 불러오기
	public int getMyErrorCntAdmin(int empno) {
		return dao.getMyErrorCntAdmin(empno);
	}
	// 내 참여 프로젝트의 미처리 상태인 이슈건수 불러오기
	public int getMyErrorCntNormal(int empno) {
		return dao.getMyErrorCntNormal(empno);
	}
	
	// 내 담당 프로젝트 이슈 5개(Admin)
	public List<Error_f> getMyErrsListAdmin(int empno){
		return dao.getMyErrsListAdmin(empno);
	}
	// 내 참여 프로젝트 이슈 5개(Normal)
	public List<Error_f> getMyErrsListNormal(int empno){
		return dao.getMyErrsListNormal(empno);
	}
	
	// 내가 참여한 진행중인 프로젝트 수 가져오기
	
	//검색된 프로젝트 리스트 가져오기
	public List<Project_f> getprojectList(ProjectSch sch,int empno,String auth){
		if(sch.getPname()==null)sch.setPname("");	
		if(sch.getStatus()!=null&&sch.getStatus().equals(""))sch.setStatus(null);
		sch.setEmpno(empno);
		//권한이 관리자인지 사원인지 판별해서 총데이터 할당
		if(auth.equals("관리자")) sch.setTotdata(dao.getprojectListCntAdmim(sch));
		else sch.setTotdata(dao.getprojectListCntNormal(sch));
		System.out.println("Totdata:"+sch.getTotdata());
		if(sch.getPageSize()==0)sch.setPageSize(10);
		if(sch.getCurPage()==0)sch.setCurPage(1);
		sch.setPageCount((int)Math.ceil(sch.getTotdata()/(double)sch.getPageSize()));
		if(sch.getCurPage()>sch.getPageCount()) {
			sch.setCurPage(sch.getPageCount());
		}		
		sch.setEnd(sch.getCurPage()*sch.getPageSize());	
		if(sch.getEnd()>sch.getTotdata()) sch.setEnd(sch.getTotdata());
		sch.setStart((sch.getCurPage()-1)*sch.getPageSize()+1);
		sch.setBolckSize(5);
		int blockCount = (int)Math.ceil(sch.getCurPage()/(double)sch.getBolckSize());
		sch.setEndBlock(blockCount*sch.getBolckSize());
		if(sch.getEndBlock()>sch.getPageCount())sch.setEndBlock(sch.getPageCount());
		sch.setStartBlock((blockCount-1)*sch.getBolckSize()+1);
		
		return auth.equals("관리자")?dao.getprojectListAdmim(sch):dao.getprojectListNormal(sch);
	}
	///--------------프로젝트----------------------
	public List<Tmem_f> getTeamMemeber(int pcode){
		return dao.getTeamMemeber(pcode);
	}
	// 프로젝트 테스크 출력
	public List<Data> getTaskdatas(int pcode) {
		return dao.getTaskdatas(pcode);
	}
	
	public String insertTask(Task_f ins) {
		System.out.println("--insertTask 서비스 접근--");
		
		return dao.insertTask(ins)>0?"등록성공":"등록실패";
	}

	public String updateTask(Task_f upt) {
		System.out.println("--UpdateTask 서비스 접근--");
		
		return dao.updateTask(upt)>0?"수정성공":"수정실패";
	}
	public String deleteTask(Task_f del) {
		System.out.println("--deleteTask 서비스 접근--");
		return dao.deleteTask(del)>0?"삭제성공":"삭제실패";
	}
	public Project_f getProjectInfo(int pcode) {
		Project_f pinfo =dao.getProjectInfo(pcode);
		
		
	/*	 for(Tmem_f f :dao.getTmemEmp(pcode)) {
		 System.out.println("사원번호1:"+f.getKey());
		 System.out.println("이름1:"+f.getLabel()); }
		 */
		 pinfo.setTmem(dao.getTmemEmp(pcode)); 
		 for(Tmem_f f :pinfo.getTmem()) {
			 System.out.println("사원번호2:"+f.getKey());
			 System.out.println("이름2:"+f.getLabel()); 
		 }
		 
		return pinfo;
	}
	
}
