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

	// 전체조회(프로젝트별)
	@GetMapping("calendar_f_all")
	public String calendar_f_all(@RequestParam("pcode")int pcode, HttpSession session) {
		session.setAttribute("pcode", pcode);
		return "lsd/z05_bootTmp/calendar_f_all";
	}// calendar_f_all()

	@GetMapping("Cal_fList_all")
	public String Cal_fList_all(Model d, HttpSession session, @RequestParam int pcode) {
		Emp_pinfo_f emp = (Emp_pinfo_f) session.getAttribute("emp");
		if (emp != null) {
			int empno = emp.getEmpno();
			d.addAttribute("Cal_fList_all", service.getCalList_all(pcode,empno));
		}

		return "pageJsonReport";
	}// getCalList_all()

	// 전체조회(부서관리자)
//	@GetMapping("calendar_f")
//	public String calendar() {
//		return "lsd/z05_bootTmp/calendar_f";
//	}// calendar()
//
//	@GetMapping("cal_fList")
//	public String cal_fList(Model d, HttpSession session) {
//		Emp_pinfo_f emp = (Emp_pinfo_f) session.getAttribute("emp");
//		String dName = emp.getDname();
//		String auth = emp.getAuth();
//		d.addAttribute("cal_fList", service.getCalList(dName));
//		return "pageJsonReport";
//	}// cal_fList()

	// 등록(부서 관리자)
	@RequestMapping("insCal_f")
	public String insCal_f(Calendar_f ins, Model d, HttpSession session) {
		
		Emp_pinfo_f emp = (Emp_pinfo_f) session.getAttribute("emp");
		if (emp != null) {
			ins.setEmpno(emp.getEmpno());
			ins.setAuth(emp.getAuth());

			d.addAttribute("msg", service.insertCalendar(ins));
			d.addAttribute("crud", "insert");
			d.addAttribute("cal_fList", service.getCalList_all(ins.getPcode(), ins.getEmpno()));

		}

		return "pageJsonReport";

	}// insCal_f`()

	// 수정
	@PostMapping("uptCal_f")
	public String uptCal_f(Calendar_f upt, Model d, HttpSession session) {
		Emp_pinfo_f emp = (Emp_pinfo_f) session.getAttribute("emp");
		if (emp != null) {
			upt.setEmpno(emp.getEmpno());
			upt.setAuth(emp.getAuth());
//			String auth = emp.getAuth();
//			upt.setPcode(pcode);

			d.addAttribute("msg", service.updateCalendar(upt));
			d.addAttribute("crud", "update");
			d.addAttribute("cal_fList", service.getCalList_all(upt.getPcode(), upt.getEmpno()));

		}

		return "pageJsonReport";
	}// uptCal_f
//
//	// 삭제
	@PostMapping("delCal_f")
	public String delCal_f(@RequestParam("pcode") int pcode, @RequestParam("id") int id, Model d, HttpSession session) {
		Emp_pinfo_f emp = (Emp_pinfo_f) session.getAttribute("emp");
		if (emp != null) {
			String auth = emp.getAuth();
			d.addAttribute("msg", service.deleteCalendar(id));
			d.addAttribute("crud", "delete");
			d.addAttribute("cal_fList", service.getCalList_all(pcode, emp.getEmpno()));

		}

		return "pageJsonReport";
	}// delCal_f()

	// 폼 형식
	@GetMapping("insCal_fForm")
	public String insCal_fForm() {
		return "lsd/z05_bootTmp/calendar_finsForm";
	}// insCal_fForm()

}// Calendar_fController{}