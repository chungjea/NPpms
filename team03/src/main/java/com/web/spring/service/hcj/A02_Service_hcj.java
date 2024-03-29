package com.web.spring.service.hcj;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.web.spring.dao.hcj.A03_Dao_hcj;
import com.web.spring.vo.Data;
import com.web.spring.vo.Emp_pinfo_f;
import com.web.spring.vo.Error_f;
import com.web.spring.vo.IconRep_f;
import com.web.spring.vo.ProjectCnt;
import com.web.spring.vo.ProjectSch;
import com.web.spring.vo.Project_f;
import com.web.spring.vo.Project_work_f;
import com.web.spring.vo.TaskRink_f;
import com.web.spring.vo.Task_f;
import com.web.spring.vo.Tmem_f;
import com.web.spring.vo.Workcnt;

@Service
public class A02_Service_hcj {
	@Autowired(required = false)
	private A03_Dao_hcj dao;
	/*
	 * //전체 프로젝트 수(admin-담당한) public int getAllMyProjectCntAdmin(int empno){return
	 * dao.getAllMyProjectCntAdmin(empno);} //전체 프로젝트 수(normal-참여한) public int
	 * getAllMyProjectCntNormal(int empno){return
	 * dao.getAllMyProjectCntNormal(empno);}
	 */
	
	// 완료중인 프로젝트 수(admin-담당한)
	public List<ProjectCnt> getProjectCntAdmin(Emp_pinfo_f emp){
		if(emp.getAuth().equals("관리자")) return dao.getProjectCntByStatusAdmin(emp.getEmpno());
		else return dao.getProjectCntByStatusNormal(emp.getEmpno());
	}
	/*
	 * // 완료중인 프로젝트 수(normal-참여한) public int getCompleteProjectCntNormal(int
	 * empno){return dao.getCompleteProjectCntNormal(empno);} // 예정중인 프로젝트
	 * 수(admin-담당한) public int getExpectedProjectCntAdmin(int empno){return
	 * dao.getExpectedProjectCntAdmin(empno);} // 예정중인 프로젝트 수(normal-참여한) public int
	 * getExpectedProjectCntNormal(int empno){return
	 * dao.getExpectedProjectCntNormal(empno);} // 중단된 프로젝트 수(admin-담당한) public int
	 * getStopedProjectCntAdmin(int empno){return
	 * dao.getStopedProjectCntAdmin(empno);} // 중단된 프로젝트 수(normal-참여한) public int
	 * getStopedProjectCntNormal(int empno){return
	 * dao.getStopedProjectCntNormal(empno);} // 진행중인 프로젝트 수(admin-담당한) public int
	 * getProceedProjectCntAdmin(int empno){return
	 * dao.getProceedProjectCntAdmin(empno);} // 진행중인 프로젝트 수(normal-참여한) public int
	 * getProceedProjectCntNormal(int empno){return
	 * dao.getProceedProjectCntNormal(empno);}
	 */
	
	
	public Workcnt getWorkCnt(int empno, int pcode,String auth) {

			return auth.equals("관리자")?
					dao.getWorkCntAdmin(pcode):dao.getWorkCntNormal(empno, pcode);
	}

	// 내가 참여한 프로젝트 5개까지 불러오기(진행중인상태 우선)
	public List<Project_f> getprojects(Emp_pinfo_f emp){
		return emp.getAuth().equals("관리자")?
				dao.getprojectsAdmin(emp):dao.getprojectsNormal(emp);
	}
	
	public int getRisk(int empno, String auth) {
		return auth.equals("관리자")?dao.getRiskAdmin(empno):dao.getRiskNormal(empno);
	}
	
	
	@Value("${file.upload}")
	   private String path;
	
	// 프로젝트 생성
	public String insertProject(Project_f ins) {
		System.out.println("프로젝트 생성 시작!!!");
		String msg = dao.insertProject(ins)>0?"프로젝트 생성성공!":"프로젝트 생성 실패";
		System.out.println(ins.getReports());
		if(ins.getReports()!= null&&!ins.getReports().getOriginalFilename().equals("")) {	
			System.out.println("아이콘이미지 생성 시도!!!");
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
		int cnt = 0;
		if(ins.getTmem()!=null) {
			for(Tmem_f mem:ins.getTmem()) {
				cnt += dao.insertTMemInNewProject(mem.getKey());
				System.out.println("현재팀원 "+cnt+"명!!");
			}
		}
		msg += cnt+"명의 팀 추가 완료";

		System.out.println("프로젝트 생성 완료");
		return msg;
	}
	
	public String updateProject(Project_f upt) {
		
		String msg = dao.updateProject(upt)>0?"수정성공":"수정실패";
		
		dao.deleteTmemALL(upt.getPcode());

		if(upt.getTmem()!=null) {	
			int pcode = upt.getPcode();
			List<Integer> uptmem = new ArrayList<Integer>();
			List<Integer> curmem = dao.getCurMem(pcode);
			
			for(Tmem_f mem: upt.getTmem()) {
				uptmem.add(mem.getKey());
			
			}
			// 현태팀원이 upt팀원에 없을경우 삭제
			for(int mem:curmem) {
				if(uptmem.indexOf(mem)==-1) {
					dao.deleteTMem(mem,pcode);
				}
			}
			
			for(int mem:uptmem) {
				if(curmem.indexOf(mem)==-1) {
					dao.insertTMemProject(mem, pcode);
				}
			}
		}			
			MultipartFile file = upt.getReports();
			if(file !=null)System.out.println("!null");
			if(!(file.getOriginalFilename().equals("")))System.out.println("파일이름있음");
			if(file !=null&&(!file.getOriginalFilename().equals(""))) {
				String filename = "icon"+dao.getfilename(upt.getPcode());
				File deletefile = new File(path+filename);
				System.out.println("파일이름:"+filename);
				System.out.println("경로+파일이름:"+path+filename);
				System.out.println("삭제파일생성:"+deletefile.getName());
				if(deletefile.exists()) {
					System.out.println(deletefile.getName()+" 삭제!!");
					deletefile.delete();
					System.out.println("삭제 완료");
					try {
						System.out.println("업데이트 파일 생성 시도");
						String uptfilename = upt.getReports().getOriginalFilename();
						System.out.println(uptfilename+"파일 생성 시도");
						String fname = uptfilename.substring(0, uptfilename.lastIndexOf("."));
						String ext = uptfilename.substring(uptfilename.lastIndexOf("."));
						int ino = dao.getIconNumupdate(upt.getPcode());
						upt.getReports().transferTo(new File(path+"icon"+ino+ext));
						System.out.println(uptfilename+"파일 생성 완료");
						dao.updatefile(fname, ext, ino);
						System.out.println("DB업데이트 완료");
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		return msg;
	}
	
	public String deleteProject(Project_f del) {
		dao.deleteTmemALL(del.getPcode());
		MultipartFile file = del.getReports();
		String filename = "icon"+dao.getfilename(del.getPcode());
		File deletefile = new File(path+filename);
		System.out.println("파일이름:"+filename);
		System.out.println("경로+파일이름:"+path+filename);
		System.out.println("삭제파일생성:"+deletefile.getName());
			if(deletefile.exists()) {
				System.out.println(deletefile.getName()+" 삭제!!");
				deletefile.delete();
				dao.deletefile(del.getPcode());
				System.out.println("iconrep삭제");
			}
		
		return dao.deleteProject(del)>0?"프로젝트 삭제":"프로젝트 삭제 실패";
	}
	
	// 사원 검색
	public List<Emp_pinfo_f> getemplist(Emp_pinfo_f sch,String empnoSch){
		if(sch.getDname()==null)sch.setDname("");
		if(empnoSch == ""||empnoSch ==null)empnoSch="0";
		sch.setEmpno(Integer.parseInt(empnoSch));
		return dao.getemplistByLike(sch);
	}
	
	// 미완료 상태인 내프로젝트의 작업들건수 불러오기(Normal)
		public int getmyWorkCnt(int empno,String auth) {
			return auth.equals("관리자")?dao.getmyWorkCntAdmin(empno):dao.getmyWorkCntNormal(empno);
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
		if(auth.equals("관리자")) sch.setTotdata(dao.getprojectListCntAdmim(sch));
		else sch.setTotdata(dao.getprojectListCntNormal(sch));

		if(sch.getPageSize()==0)sch.setPageSize(10);
		
		sch.setPageCount((int)Math.ceil(sch.getTotdata()/(double)sch.getPageSize()));
		
		if(sch.getCurPage()>sch.getPageCount()) {
			sch.setCurPage(sch.getPageCount());
		}
		if(sch.getCurPage()==0)sch.setCurPage(1);
		
		sch.setEnd(sch.getCurPage()*sch.getPageSize());	
		if(sch.getEnd()>sch.getTotdata()) sch.setEnd(sch.getTotdata());
		
		sch.setStart((sch.getCurPage()-1)*sch.getPageSize()+1);
		
		sch.setBolckSize(5);
		
		int blockCount = (int)Math.ceil(sch.getCurPage()/(double)sch.getBolckSize());
		
		sch.setEndBlock(blockCount*sch.getBolckSize());
		if(sch.getEndBlock()>sch.getPageCount()) sch.setEndBlock(sch.getPageCount());
		sch.setStartBlock((blockCount-1)*sch.getBolckSize()+1);
		return auth.equals("관리자")?dao.getprojectListAdmim(sch):dao.getprojectListNormal(sch);
	}
	///--------------프로젝트----------------------
	public List<Tmem_f> getTeamMemeber(int pcode){
		List<Tmem_f> mem = new ArrayList<Tmem_f>();
		mem.add(new Tmem_f(0,"배정없음"));
		mem.addAll(dao.getTeamMemeber(pcode));
		return mem;
	}
	// 프로젝트 테스크 출력
	public List<Data> getTaskdatas(int pcode) {
		return dao.getTaskdatas(pcode);
	}
	public List<TaskRink_f> getRink(int pcode){
		return dao.getRink(pcode);
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
	
	public int deleteAllChildTask(Task_f cdel) {
		return dao.deleteAllChildTask(cdel);
	}
	
	public Project_f getProjectInfo(int pcode) {
		Project_f pinfo =dao.getProjectInfo(pcode);
		 pinfo.setTmem(dao.getTmemEmp(pcode)); 
		return pinfo;
	}
	
	public String insertRink(TaskRink_f ins) {
		return dao.insertRink(ins)>0?"링크 생성 성공":"링크 생성 실패";
	}
	
	public String deleteLink(TaskRink_f del) {
		return dao.deleteTaskLink(del)>0?"링크 삭제 성공":"링크 삭제 실패";
	}
}
