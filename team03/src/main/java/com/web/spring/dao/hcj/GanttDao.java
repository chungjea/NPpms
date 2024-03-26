package com.web.spring.dao.hcj;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.web.spring.vo.Data;
import com.web.spring.vo.TaskRink_f;
import com.web.spring.vo.Task_f;

@Mapper
public interface GanttDao {
	
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
	

	@Select("SELECT id, SOURCE, target, type FROM TASKRINK_F\r\n"
			+ "WHERE pcode = #{pcode}")
	List<TaskRink_f> getRink(int pcode);
	
	@Insert("INSERT INTO TASKRINK_F values(#{id},#{source},#{target},#{type},#{pcode})")
	int insertTaskLink(TaskRink_f ins);
	
	@Delete("delete from TASKRINK_F where id = #{id} ")
	int deleteTaskLink(TaskRink_f del);
	

}
