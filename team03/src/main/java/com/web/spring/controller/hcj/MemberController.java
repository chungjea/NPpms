package com.web.spring.controller.hcj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.web.spring.service.hcj.MemberService;
import com.web.spring.vo.Emp_pinfo_f;

@Controller
public class MemberController {

	@Autowired(required = false)
	private MemberService memberservice;
	
	@RequestMapping("empsearch")
	public String empsearch(Emp_pinfo_f sch,String empnoSch, Model d) {
	
		d.addAttribute("elist", memberservice.getemplist(sch,empnoSch));
		return "pageJsonReport";
	}
	
	@PostMapping("Tmem")
	public ModelAndView  getTeamMember(int pcode) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new MappingJackson2JsonView());
		modelAndView.addObject("mem",memberservice.getTeamMemeber(pcode));
		return modelAndView;
	}
}
