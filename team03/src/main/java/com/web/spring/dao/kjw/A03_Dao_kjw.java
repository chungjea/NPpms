package com.web.spring.dao.kjw;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.web.spring.vo.Emp_master_f;
import com.web.spring.vo.Emp_pinfo_f;


// springweb.a02_mvc.a03_dao.A04_MemberDao
@Mapper
public interface A03_Dao_kjw {
	

	Emp_pinfo_f login(Emp_pinfo_f sch);

	

	List<Emp_master_f> Emplist();
	
	
	 int register(Emp_master_f ins);
	 
	 int empcnt(Emp_master_f cnt);

}


