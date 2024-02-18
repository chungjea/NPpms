package com.web.spring.controller.kjw;


import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.web.spring.service.kjw.A02_Service_kjw;
import com.web.spring.vo.Commute_f;
import com.web.spring.vo.Emp_master_f;
import com.web.spring.vo.Emp_pinfo_f;
import com.web.spring.vo.MailSender;
import com.web.spring.vo.sal_f;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


//http://localhost:3333/team03/mypagefilter
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

@RequestMapping("findpassword")
public String mailSend(MailSender mailVo,  Model d) {
	if(mailVo.getTitle()!=null) {
	}else {
		System.out.println("등록되지않은 메시지입니다");
	}
	return "kjw/z05_bootTmp/a82_findpassword";
}

@GetMapping("logout")
public String logout(HttpSession session) {
   session.removeAttribute("emp");
   session.invalidate();
   return "kjw/z05_bootTmp/newlogout";
}

@PostMapping("deleteEmps")
	public ResponseEntity<?> deleteEmps(@RequestBody List<Integer> empno){
		try {
			service.deleteEmps(empno);
			return ResponseEntity.ok().body
					(Map.of("status","success","message","selected rows deleted successfully"));
		}catch(Exception e) {
			return ResponseEntity.status
					(HttpStatus.INTERNAL_SERVER_ERROR).body
					(Map.of("status","error","message",e.getMessage()));
		}
	}


@RequestMapping("mypagefilter")
public String mypagefilter(@ModelAttribute("sch") Emp_master_f sch,
		 sal_f sch1,Model d,HttpSession session) {
	Emp_pinfo_f emp =(Emp_pinfo_f)session.getAttribute("emp");

	if(emp.getAuth().equals("관리자")) {
		d.addAttribute("empList", service.getEmpList(sch));
		d.addAttribute("salList", service.getSalList(sch1));
		
			return "kjw/z05_bootTmp/a70_tablesadmin";

		} else { /* if(emp.getAuth()=="직원") */
			d.addAttribute("empList", service.getEmpList(sch));
			d.addAttribute("salList", service.getSalList(sch1));
		return "kjw/z05_bootTmp/a70_tables";
		}
}
@RequestMapping("commute_s")
public String commute_s(Commute_f ins,Model d) {
	d.addAttribute("msg",service.commute_s(ins)>0?"출근등록성공":"출근등록실패");
	return "kjw/z05_bootTmp/a20_cards";
	
}


@RequestMapping("registerFrm")
public String registerFrm() {
	return "kjw/z05_bootTmp/a84_register";
}
@RequestMapping("register")
public String register(Emp_master_f ins,Model d,HttpSession session) {
	Emp_pinfo_f emp =(Emp_pinfo_f)session.getAttribute("emp");
	d.addAttribute("msg",service.register(ins)>0?"등록성공":"등록실패");

	return "kjw/z05_bootTmp/a84_register";
}
@RequestMapping("test1")
public String test1() {
	return "kjw/z05_bootTmp/detailpage";
}

//컨테이너에 선언한 지역 언어선택 객체 호출
private SessionLocaleResolver localeResolver;
	

	@RequestMapping(value = "multiLang", method = {RequestMethod.POST,RequestMethod.GET})

	public String multiLang(@RequestParam(value="lang", defaultValue = "ko")
							String lang,
							HttpServletRequest request,
							HttpServletResponse response
							) {

		System.out.println("선택한 언어:"+lang);

		Locale locale = new Locale(lang);
		localeResolver.setLocale(request, response, locale);

		 

		return "kjw/z05_bootTmp/a83_login";

	}

}


/*
 * 	@GetMapping("login.do")1
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
