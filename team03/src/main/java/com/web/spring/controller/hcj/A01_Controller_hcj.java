package com.web.spring.controller.hcj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.web.spring.service.hcj.A02_Service_hcj;
import com.web.spring.vo.Emp_pinfo_f;
import com.web.spring.vo.ProjectSch;
import com.web.spring.vo.Project_f;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class A01_Controller_hcj {
	@Autowired
	private A02_Service_hcj service;

	// http://localhost:3333/mainpage
	@RequestMapping("mainpage")
	public String mainpage(Model d, HttpServletRequest request) {
		HttpSession session = request.getSession();

		Emp_pinfo_f emp = (Emp_pinfo_f) session.getAttribute("emp");
		if (emp != null) {
			if (emp.getAuth().equals("관리자")) {
				d.addAttribute("projects", service.getprojectsAdmin(emp.getEmpno()));
				d.addAttribute("CompleteprojectCnt", service.getCompleteProjectCntAdmin(emp.getEmpno()));
				d.addAttribute("ExpectedprojectCnt", service.getExpectedProjectCntAdmin(emp.getEmpno()));
				d.addAttribute("stopedprojectCnt", service.getStopedProjectCntAdmin(emp.getEmpno()));
				d.addAttribute("projectCnt", service.getProceedProjectCntAdmin(emp.getEmpno()));
				d.addAttribute("allprojectCnt", service.getAllMyProjectCntAdmin(emp.getEmpno()));
				d.addAttribute("workList", service.getProjectWorkByEmpnoAdmin(emp.getEmpno()));
				d.addAttribute("workcnt", service.getmyWorkCntAdmin(emp.getEmpno()));
				d.addAttribute("errList", service.getMyErrsListAdmin(emp.getEmpno()));
				d.addAttribute("errcnt", service.getMyErrorCntAdmin(emp.getEmpno()));
			} else {
				d.addAttribute("projects", service.getprojectsNormal(emp.getEmpno()));
				d.addAttribute("CompleteprojectCnt", service.getCompleteProjectCntNormal(emp.getEmpno()));
				d.addAttribute("ExpectedprojectCnt", service.getExpectedProjectCntNormal(emp.getEmpno()));
				d.addAttribute("stopedprojectCnt", service.getStopedProjectCntNormal(emp.getEmpno()));
				d.addAttribute("projectCnt", service.getProceedProjectCntNormal(emp.getEmpno()));
				d.addAttribute("allprojectCnt", service.getAllMyProjectCntNormal(emp.getEmpno()));
				d.addAttribute("workList", service.getProjectWorkByEmpnoNormal(emp.getEmpno()));
				d.addAttribute("workcnt", service.getmyWorkCntNormal(emp.getEmpno()));
				d.addAttribute("errList", service.getMyErrsListNormal(emp.getEmpno()));
				d.addAttribute("errcnt", service.getMyErrorCntNormal(emp.getEmpno()));
			}
		}
		return "hcj/z05_bootTmp/a01_index";
	}

	@PostMapping("insertProject")
	public String insertProject(Project_f ins, String teams, Model d) {
		d.addAttribute("msg", service.insertProject(ins, teams));
		return "pageJsonReport";
	}

	@RequestMapping("empsearch")
	public String empsearch(Emp_pinfo_f sch, String empnoStr, Model d) {
		if (empnoStr == null || empnoStr == "")
			empnoStr = "0";
		sch.setEmpno(Integer.parseInt(empnoStr));
		if (sch.getDname() == null)
			sch.setDname("");
		d.addAttribute("elist", service.getemplist(sch));
		return "pageJsonReport";
	}

	@RequestMapping("workcnt")
	public String workcnt(@RequestParam("empno") int empno, Model d) {
		return "pageJsonReport";
	}

	@RequestMapping("projectList")
	public String projectList(@ModelAttribute("sch") ProjectSch sch, Model d, HttpServletRequest request) {
		HttpSession session = request.getSession();

		Emp_pinfo_f emp = (Emp_pinfo_f) session.getAttribute("emp");
		if (emp != null) {
			d.addAttribute("projectSchList", service.getprojectList(sch, emp.getEmpno(), emp.getAuth()));
			System.out.println(emp.getAuth());
		}
		return "hcj/z05_bootTmp/projectList";
	}

	@RequestMapping("project")
	public String project(Model d) {
		return "hcj/z05_bootTmp/gantt";
	}

	@RequestMapping("Taskdata")
	public ModelAndView taskdata() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new MappingJackson2JsonView());
		modelAndView.addObject("data", service.getTaskdatas());
		return modelAndView;
	}

}
