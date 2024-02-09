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

@Controller
public class Calendar_fController {
	@Autowired(required = false)
	private Calendar_fService service;

	// http://localhost:3333/calendar_f
	@GetMapping("calendar_f")
	public String calendar() {
		return "lsd/z05_bootTmp/calendar_f";
	}// calendar()

	@GetMapping("cal_fList")
	public String cal_fList(Model d) {
		d.addAttribute("cal_fList", service.getCalList());
		return "pageJsonReport";
	}// cal_fList()

	// http://localhost:3333/insCal_f
	@RequestMapping("insCal_f")
	public String insCal_f(Calendar_f ins, Model d) {
		System.out.println("start:" +ins.getStart());
		d.addAttribute("msg", service.insertCalendar(ins));
		d.addAttribute("cal_fList", service.getCalList());
		return "pageJsonReport";
	}// insCal_f()

	@PostMapping("uptCal_f")
	public String uptCal_f(Calendar_f upt, Model d) {
		d.addAttribute("msg", service.updateCalendar(upt));
		d.addAttribute("cal_fList", service.getCalList());
		return "pageJsonReport";
	}// uptCal_f

	@PostMapping("delCal_f")
	public String delCal_f(@RequestParam("id") int id, Model d) {
		d.addAttribute("msg", service.deleteCalendar(id));
		d.addAttribute("cal_fList", service.getCalList());
		return "pageJsonReport";
	}// delCal_f()

	@GetMapping("insCal_fForm")
	public String insCal_fForm() {
		return "lsd/z05_bootTmp/calendar_finsForm";
	}// insCal_fForm()

}// Calendar_fController{}
