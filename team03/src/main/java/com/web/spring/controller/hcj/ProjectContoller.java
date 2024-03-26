package com.web.spring.controller.hcj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.spring.service.hcj.ProjectService;
import com.web.spring.vo.Emp_pinfo_f;
import com.web.spring.vo.ProjectSch;
import com.web.spring.vo.Project_f;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ProjectContoller {
	
	@Autowired(required = false)
	private ProjectService projectservice;

	@RequestMapping("mainpage")
	public String mainpage(Model d, HttpServletRequest request) {
		HttpSession session = request.getSession();

		Emp_pinfo_f emp = (Emp_pinfo_f) session.getAttribute("emp");
		
		if (emp != null) {
			// 프로젝트 할당
			d.addAttribute("projects", projectservice.getprojects(emp));
			d.addAttribute("pjcnt",projectservice.getProjectCntAdmin(emp));
			d.addAttribute("ristcnt",projectservice.getRisk(emp.getEmpno(),emp.getAuth()));
			d.addAttribute("workcnt",projectservice.getmyWorkCnt(emp.getEmpno(), emp.getAuth()));
		}
	
		return "hcj/z05_bootTmp/a01_index";
	}
	
	@PostMapping("insertProject")
	public ResponseEntity<String> insertProject(Project_f ins) {
		return ResponseEntity.ok(projectservice.insertProject(ins) );
	}

	
	@PostMapping("updateProject")
	public ResponseEntity<String> updateProject(Project_f upt) {
		return ResponseEntity.ok(projectservice.updateProject(upt));
	}
	
	@PostMapping("deleteProject")
	public ResponseEntity<String> deleteProject(Project_f del) {
		return ResponseEntity.ok(projectservice.deleteProject(del));
	}
	
	@RequestMapping("projectList")
	public String projectList(@ModelAttribute("sch") ProjectSch sch, Model d, HttpServletRequest request) {
		HttpSession session = request.getSession();

		Emp_pinfo_f emp = (Emp_pinfo_f) session.getAttribute("emp");
		if (emp != null) {
			d.addAttribute("projectSchList", projectservice.getprojectList(sch, emp.getEmpno(), emp.getAuth()));
		
		}
		return "hcj/z05_bootTmp/projectList";
	}
	
	@PostMapping("project")
	public String project(@ModelAttribute("pcode") int pcode,Model d,HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		Emp_pinfo_f emp = (Emp_pinfo_f) session.getAttribute("emp");
		if (emp != null) {			
		d.addAttribute("pinfo", projectservice.getProjectInfo(pcode));
		}
		return "hcj/z05_bootTmp/gantt";
	}
	
	@PostMapping("loadpinfo")
	public ResponseEntity<?> loadpinfo(@RequestParam("pcode")int pcode) {

		return ResponseEntity.ok(projectservice.getProjectInfo(pcode));
	}
	
	@PostMapping("workcnt")
	public ResponseEntity<?> workcnt(@RequestParam("pcode")int pcode,@RequestParam("empno")int empno,
									@RequestParam("auth")String auth){
		return ResponseEntity.ok(projectservice.getWorkCnt(empno, pcode, auth));
	}
}
