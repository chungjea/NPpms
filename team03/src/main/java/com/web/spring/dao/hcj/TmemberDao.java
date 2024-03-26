package com.web.spring.dao.hcj;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.web.spring.vo.Emp_pinfo_f;
import com.web.spring.vo.Tmem_f;

@Mapper
public interface TmemberDao {

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
		
		
		@Select("SELECT empno FROM TMEM_F tf  WHERE pcode = #{pcode}")
		List<Integer> getCurMem(int pcode);
		
		@Select("SELECT empno KEY, ename label FROM view_tmem_add_empinfo "
				+ "WHERE pcode = #{pcode}")
		List<Tmem_f> getTmemEmp(int  pcode);
		
		
		@Select("SELECT tf.empno key, epf.ENAME label  \r\n"
				+ "		FROM TMEM_F tf  , EMP_PINFO_F epf\r\n"
				+ "		WHERE tf.EMPNO = epf.EMPNO\r\n"
				+ "		and pcode = #{pcode}")
		List<Tmem_f> getTeamMemeber(int pcode);
	
		
		List<Emp_pinfo_f> getemplistByLike(Emp_pinfo_f sch);
		
		
}
