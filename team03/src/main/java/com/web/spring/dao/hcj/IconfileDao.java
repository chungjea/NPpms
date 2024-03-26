package com.web.spring.dao.hcj;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.web.spring.vo.IconRep_f;

@Mapper
public interface IconfileDao {

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
	
}
