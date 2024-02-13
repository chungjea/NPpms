package com.web.spring.dao.lsd;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.web.spring.vo.Calendar_f;

@Mapper
public interface Calendar_fDao {
	// 전체조회
	List<Calendar_f> getCalList(String dName);

	
	int insertCalendar(Calendar_f ins);

	// 수정
	@Update(" UPDATE Calendar_f \r\n" + " SET title=#{title},\r\n" + "startdate = #{start},\r\n"
			+ "		 	enddate = #{end},\r\n" + "			content=#{content},\r\n"
			+ "			writer=#{writer},\r\n" + "			backgroundColor=#{backgroundColor},\r\n"
			+ "			textColor=#{textColor},\r\n" + "			allDay =#{allDay},\r\n"
			+ "			urllink = #{urlLink}\r\n" + "		WHERE id=#{id}")
	int updateCalendar(Calendar_f upt);

	// 삭제
	@Delete("delete from Calendar_f where id=#{id}")
	int deleteCalendar(@Param("id") int id);
}// Calendar_fDao{}
