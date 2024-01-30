package com.web.spring.controller.kjw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.spring.service.kjw.A02_Service_kjw;
import com.web.spring.vo.Emp_master_f;
import com.web.spring.vo.Emp_pinfo_f;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
//http://localhost:7080/team03/login.do4
@Controller
public class A01_Controller_kwj {
	@Autowired(required = false)
	private A02_Service_kjw service;
@GetMapping("login")
public String loginFrm() {
	return "kjw/z05_bootTmp/a83_login";
}
@PostMapping("login")
public String login(Emp_pinfo_f emplogin, HttpSession session) {
System.out.println("test");
	Emp_pinfo_f emp = service.login(emplogin);
	System.out.println("데이터 check:");
	System.out.println(emp); // null or 주소값
	if(emp!=null) {
		System.out.println("DB 속성:"+emp.getEmpno());

		session.setAttribute("emp", emp);

	}
	return "kjw/z05_bootTmp/a83_login";
}
@GetMapping("logout")
public String logout(HttpSession session) {
   session.removeAttribute("emp");
   session.invalidate();
   return "kjw/z05_bootTmp/newlogout";
}



@RequestMapping("mypagefilter")
public String mypagefilter(Model d,HttpServletRequest request) {
	HttpSession session = request.getSession();

	Emp_pinfo_f emp =(Emp_pinfo_f)session.getAttribute("emp");

	if(emp.getAuth().equals("관리자")) {
		d.addAttribute("emplist",service.Emplist());

		return "kjw/z05_bootTmp/a70_tablesadmin";

	} else { /* if(emp.getAuth()=="직원") */
		d.addAttribute("emplist",service.Emplist());
	
	return "kjw/z05_bootTmp/a70_tables";
	}
}

@RequestMapping("test")
public String test() {
	return "kjw/z05_bootTmp/a01_index";
}
@RequestMapping("registerFrm.do4")
public String registerFrm() {
	return "kjw/z05_bootTmp/a84_register";
}
@RequestMapping("register")
public String register(Emp_master_f ins,Model d) {
	d.addAttribute("msg",service.register(ins)>0?"등록성공":"등록실패");

	return "kjw/z05_bootTmp/a84_register";
}
}


/*
 * 	@GetMapping("login.do")
	public String loginFrm() {
		return "a04_login";
	}

	@PostMapping("login.do")
	public String login(Member member, HttpSession session) {

		Member mem = service.login(member);
		System.out.println("데이터 check:");
		System.out.println(mem); // null or 주소값
		if(mem!=null) {
			System.out.println("DB 속성:"+mem.getName());

			session.setAttribute("mem", mem);

		}
		return "a04_login";
	}
 *
 */
