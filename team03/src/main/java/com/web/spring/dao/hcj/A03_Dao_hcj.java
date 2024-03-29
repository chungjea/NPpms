package com.web.spring.dao.hcj;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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


@Mapper
public interface A03_Dao_hcj {
//------------------------차트----------------------------------
	/*
	 * //전체 프로젝트 수 //관리자
	 * 
	 * @Select("Select count(*) from project_f " + "where empno = #{empno}") int
	 * getAllMyProjectCntAdmin(int empno); // 사원
	 * 
	 * @Select("SELECT count(*) FROM PROJECT_F pf ,TMEM_F tf \r\n" +
	 * "		WHERE tf.PCODE = pf.PCODE AND tf.EMPNO = #{empno}\r\n") int
	 * getAllMyProjectCntNormal(int empno); // 프로젝트 수 //관리자 int
	 * getProjectCntAdmin(Emp_pinfo_f emp); // 사원
	 * 
	 * @Select("SELECT count(*) FROM PROJECT_F pf ,TMEM_F tf \r\n" +
	 * "		WHERE tf.PCODE = pf.PCODE AND tf.EMPNO = #{empno}\r\n" +
	 * "		AND STATUS ='완료'") int getCompleteProjectCntNormal(int empno); //
	 * 예정된 프로젝트 수 //관리자
	 * 
	 * @Select("SELECT count(*) FROM project_f\r\n" +
	 * "where status='예정' and empno = #{empno} \r\n") int
	 * getExpectedProjectCntAdmin(int empno); // 사원
	 * 
	 * @Select("SELECT count(*) FROM PROJECT_F pf ,TMEM_F tf \r\n" +
	 * "		WHERE tf.PCODE = pf.PCODE AND tf.EMPNO = #{empno}\r\n" +
	 * "		AND STATUS ='예정'") int getExpectedProjectCntNormal(int empno); //
	 * 중단된 프로젝트 수 //관리자
	 * 
	 * @Select("SELECT count(*) FROM project_f\r\n" +
	 * "where status='중단' and empno = #{empno} \r\n") int
	 * getStopedProjectCntAdmin(int empno); // 사원
	 * 
	 * @Select("SELECT count(*) FROM PROJECT_F pf ,TMEM_F tf \r\n" +
	 * "		WHERE tf.PCODE = pf.PCODE AND tf.EMPNO = #{empno}\r\n" +
	 * "		AND STATUS ='중단'") int getStopedProjectCntNormal(int empno); // 진행중인
	 * 프로젝트 수 //관리자
	 * 
	 * @Select("SELECT count(*) FROM project_f\r\n" +
	 * "where status='진행중' and empno = #{empno} \r\n") int
	 * getProceedProjectCntAdmin(int empno); // 사원
	 * 
	 * @Select("SELECT count(*) FROM PROJECT_F pf ,TMEM_F tf \r\n" +
	 * "		WHERE tf.PCODE = pf.PCODE AND tf.EMPNO = #{empno}\r\n" +
	 * "		AND STATUS ='진행중'") int getProceedProjectCntNormal(int empno);
	 */
	
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
		
		List<ProjectCnt> getProjectCntByStatusAdmin(int empno);
		List<ProjectCnt> getProjectCntByStatusNormal(int empno);
		
		
//--------------------------대시보드 리스트----------------------------------------
		
	// 내프로젝트 담장 프로젝트5개까지 받아오기 (관리자)
	List<Project_f> getprojectsAdmin(Emp_pinfo_f emp);
	// 내가 참여한 진행중인 프로젝트 5개까지 받아오기 (일반 사원)
	List<Project_f> getprojectsNormal(Emp_pinfo_f emp);
	
	int getRiskNormal(int empno);
	int getRiskAdmin(int empno);
	
//---------------------------전체 프로젝트 검색----------------------------------
	// 내 담당 프로젝트 검색해서 가져오기 count,list(관리자)
	int getprojectListCntAdmim(ProjectSch sch);
	List<Project_f> getprojectListAdmim(ProjectSch sch);
	
	// 내 참여 프로젝트 검색해서 가져오기 count,list(일반 사원)
	int getprojectListCntNormal(ProjectSch sch);
	List<Project_f> getprojectListNormal(ProjectSch sch);
	
	//------------------------------------프로젝트 생성----------------------------
	
	// project 생성
	int insertProject(Project_f ins);
	
	// project 업데이트
	int updateProject(Project_f upt);
	
	// project 삭제
	@Delete("DELETE FROM PROJECT_F WHERE pcode = #{pcode}")
	int deleteProject(Project_f upt);
	
	
	// 
	
	//아이콘 파일 정보 저장
	@Insert("insert into iconrep_f values(seq_icon.currval,#{fname},#{path},project_seq.currval,#{ext})")
	int insertIconfile(IconRep_f ins);
	@Select("select 'icon'||seq_icon.nextval from dual")
	String getIconNum();
	
	@Select("select ino||ext from ICONREP_F where pcode = #{pcode}")
	String getfilename(int pcode);
	@Select("select ino from ICONREP_F where pcode = #{pcode}")
	int getIconNumupdate(int pcode);
	
	@Update("update ICONREP_F set fname = #{fname},ext = #{ext} where ino = #{ino}")
	int updatefile(String fname,String ext,int ino);
	
	@Delete("delete from ICONREP_F where pcode = #{pcode}")
	int deletefile(int pcode);
	
	// 팀 멤버 추가
	@Insert("insert into TMEM_F values(#{empno},project_seq.currval)")
	int insertTMemInNewProject(int empno);
	
	// 팀 멤버 추가
		@Insert("insert into TMEM_F values(#{empno},#{pcode})")
		int insertTMemProject(@Param("empno")int empno,@Param("pcode")int pcode);
	
	// 팀 멤버 삭제
	@Delete("delete from Tmem_f where empno = #{empno} and pcode = #{pcode}")
	int deleteTMem(@Param("empno")int empno,@Param("pcode")int pcode);
	
	
	
	// 팀멤버 전체 삭제
	@Delete("delete from Tmem_f where pcode=#{pcode}")
	int deleteTmemALL(int pcode);
	
	
	
//----------------------대시보드 작업 -----------------------
	// 내 담당 프로젝트 작업 5개
	@Select("SELECT rownum cnt, fin.*\r\n"
			+ "from\r\n"
			+ "	(SELECT pwf.*\r\n"
			+ "	from\r\n"
			+ "		(SELECT PCODE \r\n"
			+ "		FROM PROJECT_F pf \r\n"
			+ "		WHERE empno = #{empno}) pc,PROJECT_WORK_F pwf\r\n"
			+ "	WHERE pc.pcode = pwf.pcode\r\n"
			+ "	ORDER BY pwf.enddte,pwf.progress) fin\r\n"
			+ "WHERE rownum <= 5")
	List<Project_work_f> getProjectWorkByEmpnoAdmin(int empno);
	
	// 내 작업 5개(Normal)
	@Select("SELECT rownum,fin.* \r\n"
			+ "FROM (\r\n"
			+ "SELECT pwf.* ,pf.pname\r\n"
			+ "FROM PROJECT_WORK_F pwf, PROJECT_F pf\r\n"
			+ "WHERE pwf.empno = #{empno}\r\n"
			+ "AND pwf.pcode = pf.pcode\r\n"
			+ "ORDER BY pwf.enddte, pwf.PROGRESS\r\n"
			+ ") Fin\r\n"
			+ "WHERE rownum <= 5")
	List<Project_work_f> getProjectWorkByEmpnoNormal(int empno);
	
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
	
	
	
	
	//-------------이슈----------------
	// 내 담당 프로젝트 이슈 갯수(Admin)
	@Select("SELECT count(*)\r\n"
			+ "from\r\n"
			+ "	(SELECT PCODE \r\n"
			+ "	FROM PROJECT_F pf \r\n"
			+ "	WHERE empno = #{empno}) pc,\r\n"
			+ "	(SELECT pwf.pcode , ef.*\r\n"
			+ "	FROM ERROR_F ef,PROJECT_WORK_F pwf\r\n"
			+ "	WHERE pwf.wno = ef.wno ) werrs\r\n"
			+ "WHERE pc.pcode = werrs.pcode\r\n"
			+ "AND status='미처리'")
	int getMyErrorCntAdmin(int empno);
	// 내 참여 프로젝트 이슈 갯수(Normal)
	@Select("SELECT count(*) \r\n"
			+ "FROM ERROR_F ef, PROJECT_WORK_F pwf  \r\n"
			+ "WHERE status = '미처리'\r\n"
			+ "AND ef.WNO = PWF.WNO \r\n"
			+ "AND pwf.EMPNO = #{empno}")
	int getMyErrorCntNormal(int empno);
	
	
	
	// 내 담당 프로젝트 이슈 5개(Admin)
	List<Error_f> getMyErrsListAdmin(int empno);
	// 내 참여 프로젝트 이슈 5개(Normal)
	List<Error_f> getMyErrsListNormal(int empno);
	

	
	
//-------------사원조회 모달-----------------------	
	//사원 조회

	List<Emp_pinfo_f> getemplistByLike(Emp_pinfo_f sch);

	
	
	// 프로젝트 간트차트
	@Select("SELECT WNO id, WNAME text, to_char(STARTDTE,'YYYY-MM-DD') \r\n "
			+ "start_date, ENDDTE-STARTDTE +1  duration, PROGRESS,"
			+ "REFNO parent, empno assignor\r\n"
			+ "FROM PROJECT_WORK_F pwf \r\n"
			+ "where pcode = #{pcode}")
	List<Data> getTaskdatas(int pcode);
	
	@Insert("INSERT INTO PROJECT_WORK_F pwf values(#{id},#{parent},to_date(#{startdte},'YYYY-MM-DD'),to_date(#{enddte},'YYYY-MM-DD'),#{progress},#{pcode},#{assignor},1,#{text})")
	int insertTask(Task_f ins);
	@Update("update PROJECT_WORK_F set refno = #{parent}, startdte = to_date(#{startdte},'YYYY-MM-DD'), enddte = to_date(#{enddte},'YYYY-MM-DD'), progress = #{progress},empno = #{assignor},wname = #{text} where wno = #{id}")
	int updateTask(Task_f upt);
	@Delete("DELETE FROM PROJECT_WORK_F WHERE wno = #{id}")
	int deleteTask(Task_f del);
	@Delete("delete FROM PROJECT_WORK_F WHERE refno = #{id}")
	int deleteAllChildTask(Task_f cdel);
	
	@Insert("INSERT INTO taskRink_F values(#{id},#{source},#{target},#{type},#{pcode})")
	int insertRink(TaskRink_f ins);
	
	
	List<Tmem_f> getTeamMemeber(int pcode);
	
	
	@Select("SELECT empno FROM TMEM_F tf  WHERE pcode = #{pcode}")
	List<Integer> getCurMem(int pcode);
	
	@Select("SELECT pf.*,if2.ino,IF2.PATH, IF2.EXT, epf.ENAME mgname \r\n"
			+ "FROM PROJECT_F pf ,ICONREP_F if2,EMP_PINFO_F epf \r\n"
			+ "WHERE pf.PCODE = IF2.PCODE(+) \r\n"
			+ "AND pf.EMPNO = epf.EMPNO \r\n"
			+ "and pf.pcode = #{pcode}")
	Project_f getProjectInfo(int pcode);
	
	
	@Select("SELECT empno KEY, ename label FROM view_tmem_add_empinfo "
			+ "WHERE pcode = #{pcode}")
	List<Tmem_f> getTmemEmp(int  pcode); 
	
	@Select("SELECT id, SOURCE, target, type FROM TASKRINK_F\r\n"
			+ "WHERE pcode = #{pcode}")
	List<TaskRink_f> getRink(int pcode);
	
	@Insert("INSERT INTO TASKRINK_F values(#{id},#{source},#{target},#{type},#{pcode})")
	int insertTaskLink(TaskRink_f ins);
	
	@Delete("delete from TASKRINK_F where id = #{id} ")
	int deleteTaskLink(TaskRink_f del);
}
