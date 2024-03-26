package com.web.spring.service.hcj;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.web.spring.dao.hcj.IconfileDao;
import com.web.spring.dao.hcj.ProjectDao;
import com.web.spring.dao.hcj.TmemberDao;
import com.web.spring.vo.Emp_pinfo_f;
import com.web.spring.vo.IconRep_f;
import com.web.spring.vo.ProjectCnt;
import com.web.spring.vo.ProjectSch;
import com.web.spring.vo.Project_f;
import com.web.spring.vo.Tmem_f;
import com.web.spring.vo.Workcnt;

@Service
public class ProjectService {
	@Autowired(required = false)
	private ProjectDao projectdao;
	
	@Autowired(required = false)
	private IconfileDao iconfiledao;
	
	@Autowired(required = false)
	private TmemberDao tmemberDao;
	
	@Value("${file.upload}")
	   private String path;
	
	
	public List<ProjectCnt> getProjectCntAdmin(Emp_pinfo_f emp){
		if(emp.getAuth().equals("관리자")) return projectdao.getProjectCntByStatusAdmin(emp.getEmpno());
		else return projectdao.getProjectCntByStatusNormal(emp.getEmpno());
	}
	
	// 내가 참여한 프로젝트 5개까지 불러오기(진행중인상태 우선)
	public List<Project_f> getprojects(Emp_pinfo_f emp){
		return emp.getAuth().equals("관리자")?
			projectdao.getprojectsAdmin(emp):projectdao.getprojectsNormal(emp);
	}
		
		// 미완료 상태인 내프로젝트의 작업들건수 불러오기(Normal)
	public int getmyWorkCnt(int empno,String auth) {
			return auth.equals("관리자")?projectdao.getmyWorkCntAdmin(empno):projectdao.getmyWorkCntNormal(empno);
	}
	
	// 프로젝트 생성
		public String insertProject(Project_f ins) {
	
			String msg = projectdao.insertProject(ins)>0?"프로젝트 생성성공!":"프로젝트 생성 실패";

			if(ins.getReports()!= null&&!ins.getReports().getOriginalFilename().equals("")) {	
	
				String dbpath = "/z01_upload/";
				try {
							
						// 1. 파일 업로드
						// 파일명을 가져오기..
						
						String frealname = ins.getReports().getOriginalFilename();
						String savename = iconfiledao.getIconNum();
						String fname = frealname.substring(0, frealname.lastIndexOf("."));
						String ext = frealname.substring(frealname.lastIndexOf("."));
						
						
						
						ins.getReports().transferTo(new File(path+savename+ext));
						
						// 2. 업로드된 파일정보를 DB저장..(추후에 활용할 목적)(
						iconfiledao.insertIconfile(new IconRep_f(fname,dbpath,ext));
						// FileRep(int no, String fname, String path, String etc) 
					
						
				} catch (IllegalStateException e) {
					System.out.println("파일업로드 예외1:"+e.getMessage());
				} catch (IOException e) {
					System.out.println("파일업로드 예외2:"+e.getMessage());
				}
			
			}
			int cnt = 0;
			if(ins.getTmem()!=null) {
				for(Tmem_f mem:ins.getTmem()) {
					cnt += tmemberDao.insertTMemInNewProject(mem.getKey());

				}
			}
			msg += cnt+"명의 팀 추가 완료";


			return msg;
		}
		
		public String updateProject(Project_f upt) {
			
			String msg = projectdao.updateProject(upt)>0?"수정성공":"수정실패";
			
			tmemberDao.deleteTmemALL(upt.getPcode());

			if(upt.getTmem()!=null) {	
				int pcode = upt.getPcode();
				List<Integer> uptmem = new ArrayList<Integer>();
				List<Integer> curmem = tmemberDao.getCurMem(pcode);
				
				for(Tmem_f mem: upt.getTmem()) {
					uptmem.add(mem.getKey());
				
				}
				// 현태팀원이 upt팀원에 없을경우 삭제
				for(int mem:curmem) {
					if(uptmem.indexOf(mem)==-1) {
						tmemberDao.deleteTMem(mem,pcode);
					}
				}
				
				for(int mem:uptmem) {
					if(curmem.indexOf(mem)==-1) {
						tmemberDao.insertTMemProject(mem, pcode);
					}
				}
			}			
				MultipartFile file = upt.getReports();
				
				if(file !=null&&(!file.getOriginalFilename().equals(""))) {
					String filename = "icon"+iconfiledao.getfilename(upt.getPcode());
					File deletefile = new File(path+filename);

					if(deletefile.exists()) {
			
						deletefile.delete();
			
						try {
				
							String uptfilename = upt.getReports().getOriginalFilename();
		
							String fname = uptfilename.substring(0, uptfilename.lastIndexOf("."));
							String ext = uptfilename.substring(uptfilename.lastIndexOf("."));
							int ino = iconfiledao.getIconNumupdate(upt.getPcode());
							upt.getReports().transferTo(new File(path+"icon"+ino+ext));
			
							iconfiledao.updatefile(fname, ext, ino);
				
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
			tmemberDao.deleteTmemALL(del.getPcode());
			MultipartFile file = del.getReports();
			String filename = "icon"+iconfiledao.getfilename(del.getPcode());
			File deletefile = new File(path+filename);

				if(deletefile.exists()) {

					deletefile.delete();
					iconfiledao.deletefile(del.getPcode());

				}
			
			return projectdao.deleteProject(del)>0?"프로젝트 삭제":"프로젝트 삭제 실패";
		}
		
		//검색된 프로젝트 리스트 가져오기
		public List<Project_f> getprojectList(ProjectSch sch,int empno,String auth){
			if(sch.getPname()==null)sch.setPname("");	
			if(sch.getStatus()!=null&&sch.getStatus().equals(""))sch.setStatus(null);
			sch.setEmpno(empno);
			if(auth.equals("관리자")) sch.setTotdata(projectdao.getprojectListCntAdmim(sch));
			else sch.setTotdata(projectdao.getprojectListCntNormal(sch));

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
			return auth.equals("관리자")?projectdao.getprojectListAdmim(sch):projectdao.getprojectListNormal(sch);
		}
		
		
		public Project_f getProjectInfo(int pcode) {
			Project_f pinfo =projectdao.getProjectInfo(pcode);
			 pinfo.setTmem(tmemberDao.getTmemEmp(pcode)); 
			return pinfo;
		}
		
		public int getRisk(int empno, String auth) {
			return auth.equals("관리자")?projectdao.getRiskAdmin(empno):projectdao.getRiskNormal(empno);
		}
		
		public Workcnt getWorkCnt(int empno, int pcode,String auth) {

			return auth.equals("관리자")?
					projectdao.getWorkCntAdmin(pcode):projectdao.getWorkCntNormal(empno, pcode);
	}
}
