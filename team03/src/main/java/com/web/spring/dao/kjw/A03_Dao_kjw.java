package com.web.spring.dao.kjw;

import java.util.List;

import com.web.spring.vo.Emp_master_f;
import com.web.spring.vo.Emp_pinfo_f;
import com.web.spring.vo.sal_f;


// springweb.a02_mvc.a03_dao.A04_MemberDao
public interface A03_Dao_kjw {
	

	Emp_pinfo_f login(Emp_pinfo_f sch);

	List<Emp_master_f> Emplist();
	
	 int register(Emp_master_f ins);
	 
	List<Emp_master_f> getEmpList(Emp_master_f sch);
		int getCountEmp();

		List<sal_f> getSalList(sal_f sch);
}


