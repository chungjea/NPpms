package com.web.spring.controller.lsd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.spring.service.lsd.Calendar_fService;
import com.web.spring.vo.Calendar_f;
import com.web.spring.vo.Emp_pinfo_f;

import jakarta.servlet.http.HttpSession;

@Controller
public class Calendar_fController {
	@Autowired(required = false)
	private Calendar_fService service;

	//전체조회
	@GetMapping("calendar_f_all")
	public String calendar_f_all() {
		return "lsd/z05_bootTmp/calendar_f_all";
	}//calendar_f_all()
	
	// 전체조회(부서)
	@GetMapping("calendar_f")
	public String calendar() {
		return "lsd/z05_bootTmp/calendar_f";
	}// calendar()

	@GetMapping("cal_fList")
	public String cal_fList(Model d, HttpSession session) {
		Emp_pinfo_f emp = (Emp_pinfo_f) session.getAttribute("emp");
		String dName = emp.getDname();
		String auth = emp.getAuth();
		d.addAttribute("cal_fList", service.getCalList(dName));
		return "pageJsonReport";
	}// cal_fList()

	// 전체조회(개인별)
	@GetMapping("calendar_f_empno")
	public String calendar_empno() {
		return "lsd/z05_bootTmp/calendar_f_empno";
	}// calendar_empno()

	// 전체조회(개인)
	@GetMapping("cal_fList_empno")
	public String cal_fList_empno(Model d, HttpSession session) {
		Emp_pinfo_f emp = (Emp_pinfo_f) session.getAttribute("emp");
		int empno = emp.getEmpno();
		d.addAttribute("cal_fList_empno", service.getCalList_empno(empno));
		return "pageJsonReport";
	}// cal_fList_empno()

	// 등록(부서)
	@RequestMapping("insCal_f")
	public String insCal_f(Calendar_f ins, Model d, HttpSession session) {
		System.out.println("start:" + ins.getStart());
		// 게시물 구분 - 로그인한 사람 dname을 가져옴
		Emp_pinfo_f emp = (Emp_pinfo_f) session.getAttribute("emp");
		String dName = emp.getDname();
		ins.setdName(dName);
		String auth = emp.getAuth();
		ins.setAuth(auth);
		
		d.addAttribute("msg", service.insertCalendar(ins));
		d.addAttribute("crud", "insert");
		d.addAttribute("cal_fList", service.getCalList(dName));
		return "pageJsonReport";
	}// insCal_f()

	// 등록(개인)
	@RequestMapping("insCal_f_empno")
	public String insCal_f_empno(Calendar_f ins, Model d, HttpSession session) {
		// 게시물 구분 - 로그인한 사람 empno을 가져옴
		Emp_pinfo_f emp = (Emp_pinfo_f) session.getAttribute("emp");
		int empno = emp.getEmpno();
		ins.setEmpno(empno);
		String dName = emp.getDname();
		ins.setdName(dName);
		String auth = emp.getAuth();
		ins.setAuth(auth);
		d.addAttribute("msg", service.insertCalendar(ins));
		d.addAttribute("crud", "insert");
		d.addAttribute("cal_fList_empno", service.getCalList_empno(empno));
		return "pageJsonReport";
	}// insCal_f_empno()

	// 수정
	@PostMapping("uptCal_f")
	public String uptCal_f(Calendar_f upt, Model d, HttpSession session) {
		Emp_pinfo_f emp = (Emp_pinfo_f) session.getAttribute("emp");
		String dName = emp.getDname();
		d.addAttribute("msg", service.updateCalendar(upt));
		d.addAttribute("crud", "update");
		d.addAttribute("cal_fList", service.getCalList(dName));
		return "pageJsonReport";
	}// uptCal_f

	// 수정(개인)
	@PostMapping("uptCal_f_empno")
	public String uptCal_f_empno(Calendar_f upt, Model d, HttpSession session) {
		Emp_pinfo_f emp = (Emp_pinfo_f) session.getAttribute("emp");
		int empno = emp.getEmpno();
		String dName = emp.getDname();
		// Calendar_f dname에 사번을 저장
		upt.setdName(dName);
		d.addAttribute("msg", service.updateCalendar(upt));
		d.addAttribute("crud", "update");
		d.addAttribute("cal_fList", service.getCalList_empno(empno));
		return "pageJsonReport";
	}// uptCal_f_empno

	// 삭제
	@PostMapping("delCal_f")
	public String delCal_f(@RequestParam("id") int id, Model d, HttpSession session) {
		Emp_pinfo_f emp = (Emp_pinfo_f) session.getAttribute("emp");
		String dName = emp.getDname();
		d.addAttribute("msg", service.deleteCalendar(id));
		d.addAttribute("crud", "delete");
		d.addAttribute("cal_fList", service.getCalList(dName));
		return "pageJsonReport";
	}// delCal_f()

	// 삭제(개인)
	@PostMapping("delCal_f_empno")
	public String delCal_f_empno(@RequestParam("id") int id, Model d, HttpSession session) {
		Emp_pinfo_f emp = (Emp_pinfo_f) session.getAttribute("emp");
		int empno = emp.getEmpno();
		d.addAttribute("msg", service.deleteCalendar(id));
		d.addAttribute("crud", "delete");
		d.addAttribute("cal_fList", service.getCalList_empno(empno));
		return "pageJsonReport";
	}// delCal_f_empno()

	// 폼 형식
	@GetMapping("insCal_fForm")
	public String insCal_fForm() {
		return "lsd/z05_bootTmp/calendar_finsForm";
	}// insCal_fForm()

	// 폼 형식(개인별)
	@GetMapping("insCal_f_empnoForm")
	public String insCal_f_empnoForm() {
		return "lsd/z05_bootTmp/calendar_finsForm";
	}// insCal_f_empnoForm()
	
}// Calendar_fController{}