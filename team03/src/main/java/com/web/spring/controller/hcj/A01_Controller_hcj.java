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
import org.springframework.web.servlet.function.EntityResponse;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.web.spring.service.hcj.A02_Service_hcj;
import com.web.spring.vo.Emp_pinfo_f;
import com.web.spring.vo.ProjectSch;
import com.web.spring.vo.Project_f;
import com.web.spring.vo.TaskRink_f;
import com.web.spring.vo.Task_f;

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
			d.addAttribute("ristcnt",service.getRisk(emp.getEmpno(),emp.getAuth()));
			d.addAttribute("workcnt",service.getmyWorkCnt(emp.getEmpno(), emp.getAuth()));
		}
	
		return "hcj/z05_bootTmp/a01_index";
	}
	@PostMapping("workcnt")
	public ResponseEntity<?> workcnt(@RequestParam("pcode")int pcode,@RequestParam("empno")int empno,
									@RequestParam("auth")String auth){
		return ResponseEntity.ok(service.getWorkCnt(empno, pcode, auth));
	}
	
	
	@PostMapping("insertProject")
	public ResponseEntity<String> insertProject(Project_f ins) {
		return ResponseEntity.ok(service.insertProject(ins) );
	}

	
	@PostMapping("updateProject")
	public ResponseEntity<String> updateProject(Project_f upt) {
		return ResponseEntity.ok(service.updateProject(upt));
	}
	
	@PostMapping("deleteProject")
	public ResponseEntity<String> deleteProject(Project_f del) {
		return ResponseEntity.ok(service.deleteProject(del));
	}

	@RequestMapping("empsearch")
	public String empsearch(Emp_pinfo_f sch,String empnoSch, Model d) {
	
		d.addAttribute("elist", service.getemplist(sch,empnoSch));
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

	@PostMapping("project")
	public String project(@ModelAttribute("pcode") int pcode,Model d,HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		Emp_pinfo_f emp = (Emp_pinfo_f) session.getAttribute("emp");
		if (emp != null) {			
		d.addAttribute("pinfo", service.getProjectInfo(pcode));
		}
		return "hcj/z05_bootTmp/gantt";
	}
	@PostMapping("loadpinfo")
	public ResponseEntity<?> loadpinfo(@RequestParam("pcode")int pcode) {
		System.out.println(pcode);
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
		modelAndView.addObject("links", service.getRink(pcode));
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
		System.out.println("일단 들어옴 -delete-");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new MappingJackson2JsonView());
		modelAndView.addObject("msg", service.deleteTask(del));
		return modelAndView;
	}
	
	@ResponseBody
    @RequestMapping(value = "deleteChildTask", method = RequestMethod.POST)
	public ModelAndView deleteChildTask(@RequestBody Task_f cdel) {
		System.out.println("일단 들어옴 -delete-");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new MappingJackson2JsonView());
		modelAndView.addObject("msg", service.deleteAllChildTask(cdel));
		return modelAndView;
	}
	
	
	@ResponseBody
	@PostMapping("insertLink")
	public ResponseEntity<?> insertTaskLink(@RequestBody TaskRink_f ins){
		return ResponseEntity.ok(service.insertRink(ins));
	}
	
	@ResponseBody
	@PostMapping("deleteLink")
	public ResponseEntity<?> deleteTaskLink(@RequestBody TaskRink_f del){
		return ResponseEntity.ok(service.deleteLink(del));
	}

}
