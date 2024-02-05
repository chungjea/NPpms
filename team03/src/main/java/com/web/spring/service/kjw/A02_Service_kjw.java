package com.web.spring.service.kjw;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.spring.dao.kjw.A03_Dao_kjw;
import com.web.spring.vo.Emp_master_f;
import com.web.spring.vo.Emp_pinfo_f;
import com.web.spring.vo.sal_f;



@Service
public class A02_Service_kjw {
	@Autowired(required = false)
	private A03_Dao_kjw dao;
	
	public Emp_pinfo_f login(Emp_pinfo_f sch) {
		return dao.login(sch);
	}
	public List<Emp_master_f> Emplist(){
		return dao.Emplist();

}
	public int register(Emp_master_f ins) {
		return dao.register(ins);
}

	@Transactional
	public void deleteEmps(List<Integer> empno) {
		dao.deleteEmps(empno);
	}
	
	public List<Emp_master_f> getEmpList(Emp_master_f sch){
		if(sch.getEmpno()==0) sch.setEmpno(0);
		
		
		return dao.getEmpList(sch);
	}
	public List<sal_f> getSalList(sal_f sch){
		if(sch.getEmpno()==0) sch.setEmpno(0);
		return dao.getSalList(sch);
	}

}

