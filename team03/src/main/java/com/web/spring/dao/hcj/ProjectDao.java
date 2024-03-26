package com.web.spring.dao.hcj;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.web.spring.vo.Emp_pinfo_f;
import com.web.spring.vo.ProjectCnt;
import com.web.spring.vo.ProjectSch;
import com.web.spring.vo.Project_f;
import com.web.spring.vo.Workcnt;

@Mapper
public interface ProjectDao {
	
	

	
		// project 생성
		int insertProject(Project_f ins);
		
		// project 업데이트
		int updateProject(Project_f upt);
		
		// project 삭제
		@Delete("DELETE FROM PROJECT_F WHERE pcode = #{pcode}")
		int deleteProject(Project_f upt);
	
		
		List<ProjectCnt> getProjectCntByStatusAdmin(int empno);
		List<ProjectCnt> getProjectCntByStatusNormal(int empno);
		
		// 내프로젝트 담장 프로젝트 받아오기 (관리자)
		List<Project_f> getprojectsAdmin(Emp_pinfo_f emp);
		// 내가 참여한 진행중인 프로젝트  받아오기 (일반 사원)
		List<Project_f> getprojectsNormal(Emp_pinfo_f emp);
		
		// 내 담당 프로젝트 검색해서 가져오기 count,list(관리자)
		int getprojectListCntAdmim(ProjectSch sch);
		List<Project_f> getprojectListAdmim(ProjectSch sch);
		
		// 내 참여 프로젝트 검색해서 가져오기 count,list(일반 사원)
		int getprojectListCntNormal(ProjectSch sch);
		List<Project_f> getprojectListNormal(ProjectSch sch);
		
		@Select("SELECT pf.*,if2.ino,IF2.PATH, IF2.EXT, epf.ENAME mgname \r\n"
				+ "FROM PROJECT_F pf ,ICONREP_F if2,EMP_PINFO_F epf \r\n"
				+ "WHERE pf.PCODE = IF2.PCODE(+) \r\n"
				+ "AND pf.EMPNO = epf.EMPNO \r\n"
				+ "and pf.pcode = #{pcode}")
		Project_f getProjectInfo(int pcode);
		
		// 담당 프로젝트에서 완료안된 작업 수(Admin)
		@Select("SELECT count(*)\r\n"
				+ "	from\r\n"
				+ "		(SELECT PCODE \r\n"
				+ "		FROM PROJECT_F pf \r\n"
				+ "		WHERE empno = #{empno}) pc,PROJECT_WORK_F pwf\r\n"
				+ "	WHERE pc.pcode = pwf.pcode\r\n"
				+ "	AND pwf.progress < 100 "
				+ "and pwf.empno != 0")
		int getmyWorkCntAdmin(int empno);
		
		// 완료안된 내 작업 수(Normal)
		@Select("select count(*)\r\n"
				+ "from PROJECT_WORK_F\r\n"
				+ "where PROGRESS  < 100  \r\n"
				+ "and empno = #{empno} \r\n")
		int getmyWorkCntNormal(int empno);
		
		@Select("SELECT count(*) Allcnt,\r\n"
				+ "		count(CASE WHEN PROGRESS<1 THEN 1 end) AS Proceeding, \r\n"
				+ "		count(CASE WHEN PROGRESS = 1 THEN 1 END) AS complete\r\n"
				+ "		FROM project_work_f\r\n"
				+ "		WHERE empno = #{empno}\r\n"
				+ "		and pcode = #{pcode}")
		Workcnt getWorkCntNormal(@Param("empno")int empno,@Param("pcode")int pcode);
		
		@Select("SELECT count(*) Allcnt,\r\n"
				+ "count(CASE WHEN PROGRESS<1 THEN 1 end) AS Proceeding, \r\n"
				+ "count(CASE WHEN PROGRESS = 1 THEN 1 END) AS complete\r\n"
				+ "FROM project_work_f\r\n"
				+ "where PCODE = #{pcode}"
				+ "and empno != 0 ")
		Workcnt getWorkCntAdmin(@Param("pcode")int pcode);
		
		
		int getRiskNormal(int empno);
		int getRiskAdmin(int empno);
}
