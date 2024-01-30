package com.web.spring.service.hcj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.spring.dao.hcj.A03_Dao_hcj;
import com.web.spring.vo.Emp_pinfo_f;
import com.web.spring.vo.Error_f;
import com.web.spring.vo.ProjectSch;
import com.web.spring.vo.Project_f;
import com.web.spring.vo.Project_work_f;

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
	public String insertProject(Project_f ins,String teams) {
		String msg = dao.insertProject(ins)>0?"프로젝트 생성성공!":"프로젝트 생성 실패";
		if(!teams.equals("")) {
			String[] tmems = teams.split(",");
			int cnt = 0;
			for(String tmem : tmems) {
				
				cnt += dao.insertTMemInNewProject(Integer.parseInt(tmem));
			}
			msg += cnt+"명의 팀 추가 완료";
		}
		return msg;
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
		
		System.out.println("CurPage:"+sch.getCurPage());
		System.out.println("start:"+sch.getStart());
		System.out.println("end:"+sch.getEnd());	
		System.out.println("status"+sch.getStatus());
		
		return auth.equals("관리자")?dao.getprojectListAdmim(sch):dao.getprojectListNormal(sch);
	}
	
}
