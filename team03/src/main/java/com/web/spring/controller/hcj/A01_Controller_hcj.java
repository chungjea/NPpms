package com.web.spring.controller.hcj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.web.spring.service.hcj.A02_Service_hcj;
import com.web.spring.vo.Emp_pinfo_f;
import com.web.spring.vo.ProjectSch;
import com.web.spring.vo.Project_f;
import com.web.spring.vo.Task_f;
import com.web.spring.vo.Tmem_f;

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
			// 프로젝트 할당
			d.addAttribute("projects", service.getprojects(emp));
			d.addAttribute("pjcnt",service.getProjectCntAdmin(emp));
			
			if (emp.getAuth().equals("관리자")) {
				
	
				
				d.addAttribute("projectCnt", service.getProceedProjectCntAdmin(emp.getEmpno()));
				d.addAttribute("allprojectCnt", service.getAllMyProjectCntAdmin(emp.getEmpno()));
				d.addAttribute("workList", service.getProjectWorkByEmpnoAdmin(emp.getEmpno()));
				d.addAttribute("workcnt", service.getmyWorkCntAdmin(emp.getEmpno()));
				d.addAttribute("errList", service.getMyErrsListAdmin(emp.getEmpno()));
				d.addAttribute("errcnt", service.getMyErrorCntAdmin(emp.getEmpno()));
			} else {
				
				
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
	
	@ResponseBody
	@PostMapping("insertProject")
	public ModelAndView insertProject(Project_f ins) {
		
		System.out.println("일단들어옴!!!!!!!");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new MappingJackson2JsonView());

		modelAndView.addObject("msg", service.insertProject(ins));
		return modelAndView;
	}
	@ResponseBody
	@PostMapping("updateProject")
	public ModelAndView updateProject(Project_f upt) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new MappingJackson2JsonView());
		System.out.println("---------------데이터 확인!!---------------");
		System.out.println("매니저번호:"+upt.getEmpno());
		System.out.println("프로젝트 이름:"+upt.getPname());
		System.out.println("시작일:"+upt.getStartdte());
		System.out.println("마감일:"+upt.getEnddte());
		System.out.println("상태:"+upt.getStatus());
		System.out.println("번호:"+upt.getStartdte());
		System.out.println("프로젝트 번호:"+upt.getPcode());
		System.out.println("프로젝트명:"+upt.getPname());
		
		System.out.println("---------------확인완료---------------");
		System.out.println("---------------업데이트 컨트롤러 접근!!---------------");
		modelAndView.addObject("msg", service.updateProject(upt));
		return modelAndView;
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
	public String project(@ModelAttribute("pcode") int pcode,Model d) {
		d.addAttribute("pinfo", service.getProjectInfo(pcode));
		return "hcj/z05_bootTmp/gantt";
	}
	@PostMapping("loadpinfo")
	public ResponseEntity<?> loadpinfo(@RequestParam("pcode")int pcode) {	
		return ResponseEntity.ok(service.getProjectInfo(pcode));
	}
	@PostMapping("Tmem")
	public ModelAndView  getTeamMember(int pcode) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new MappingJackson2JsonView());
		modelAndView.addObject("mem",service.getTeamMemeber(pcode));
		return modelAndView;
	}
	
	@RequestMapping("Taskdata")
	public ModelAndView taskdata( int pcode) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new MappingJackson2JsonView());
		modelAndView.addObject("data", service.getTaskdatas(pcode));
		return modelAndView;
	}
	
	
	@ResponseBody
    @RequestMapping(value = "insertTask", method = RequestMethod.POST)
	public ModelAndView insertTask(@RequestBody Task_f ins) {
		System.out.println("일단 들어옴3ddasdasdtryyrt");
		System.out.println("text:"+ins.getText());
		System.out.println("pcode:"+ins.getPcode());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new MappingJackson2JsonView());
		modelAndView.addObject("msg", service.insertTask(ins));
		return modelAndView;
	}
	
	@ResponseBody
    @RequestMapping(value = "updateTask", method = RequestMethod.POST)
	public ModelAndView updateTask(@RequestBody Task_f upt) {
		System.out.println("일단 들어옴 -update-");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new MappingJackson2JsonView());
		modelAndView.addObject("msg", service.updateTask(upt));
		System.out.println("-------");
		return modelAndView;
	}
	
	@ResponseBody
    @RequestMapping(value = "deleteTask", method = RequestMethod.POST)
	public ModelAndView deleteTask(@RequestBody Task_f del) {
		System.out.println("일단 들어옴 -update-");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new MappingJackson2JsonView());
		modelAndView.addObject("msg", service.deleteTask(del));
		return modelAndView;
	}

}
