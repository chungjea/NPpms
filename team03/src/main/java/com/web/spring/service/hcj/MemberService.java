package com.web.spring.service.hcj;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.spring.dao.hcj.TmemberDao;
import com.web.spring.vo.Emp_pinfo_f;
import com.web.spring.vo.Tmem_f;

@Service
public class MemberService {
	@Autowired(required = false)
	private TmemberDao tmemberdao;
	
	public List<Tmem_f> getTeamMemeber(int pcode){
		List<Tmem_f> mem = new ArrayList<Tmem_f>();
		mem.add(new Tmem_f(0,"배정없음"));
		mem.addAll(tmemberdao.getTeamMemeber(pcode));
		return mem;
	}
	
	
	// 사원 검색
		public List<Emp_pinfo_f> getemplist(Emp_pinfo_f sch,String empnoSch){
			if(sch.getDname()==null)sch.setDname("");
			if(empnoSch == ""||empnoSch ==null)empnoSch="0";
			sch.setEmpno(Integer.parseInt(empnoSch));
			return tmemberdao.getemplistByLike(sch);
		}
}
