package com.web.spring.dao.kjw;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.web.spring.vo.Emp_master_f;
import com.web.spring.vo.Emp_master_his_f;
import com.web.spring.vo.Emp_pinfo_f;
import com.web.spring.vo.Project_f;
import com.web.spring.vo.Tmem_f;
import com.web.spring.vo.Commute_f;
import com.web.spring.vo.sal_f;

@Mapper
// springweb.a02_mvc.a03_dao.A04_MemberDao
public interface A03_Dao_kjw {
	

	Emp_pinfo_f login(Emp_pinfo_f sch);
	
	 int register(Emp_master_f ins);
	 
	 int deleteEmps(List<Integer> empno);
	 int deleteEmpsagain(List<Integer> empno);
	 
	List<Emp_master_f> getEmpList(Emp_master_f sch);
		
	List<Project_f> doneProjA(Emp_pinfo_f emp);
	List<Project_f> doneProjN(Emp_pinfo_f emp);
	
int updateinfo(Emp_master_f upt);
		List<sal_f> getSalList(sal_f ssah); //급여리스트

		List<Emp_master_f> Emplist(); //사원정보리스트
		
		int commute_s(Commute_f ins);
		int commute_e(Commute_f ins);
		

		Commute_f commute_f(Commute_f sch); //출근
		
		int empcnt(Emp_master_f cnt); //사원총합
		int LatestEmp(); //사원번호

		int sumProj(int empno);
		int getsal();

		List<Emp_master_his_f> EmpHistory(Emp_master_his_f psearch);

		boolean existByName(String ename);
		List<Commute_f> starttime_c(Commute_f csch);
		List<Commute_f> endtime_c(Commute_f csch);
		Emp_master_f getnewinfo(String email);
		Emp_master_f getnewpwd(int empno);//비밀번호 찾기
		int checkEmpno(String email);
		
}




