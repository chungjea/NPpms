package com.web.spring.controller.kjw;


import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.web.spring.vo.Emp;
import com.web.spring.vo.Emp_master_f;
import com.web.spring.vo.Emp_master_his_f;
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



public String loginFrm() {
	return "kjw/z05_bootTmp/a83_login";
}



@Autowired(required=false)
private SessionLocaleResolver localeResolver;
@RequestMapping(value="login", method = {RequestMethod.GET, RequestMethod.POST})
public String login(Emp_pinfo_f emplogin, HttpSession session,@RequestParam(value="lang", defaultValue = "ko")
String lang,
HttpServletRequest request,
HttpServletResponse response) {
	Locale locale = new Locale(lang);
	localeResolver.setLocale(request, response, locale);
	Emp_pinfo_f emp = service.login(emplogin);
	System.out.println("선택한 언어:"+lang);

	
	

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
@PostMapping("deleteEmpsagain")
public ResponseEntity<?> deleteEmpsagain(@RequestBody List<Integer> empno){
	try {
		service.deleteEmpsagain(empno);
		return ResponseEntity.ok().body
				(Map.of("status","success","message","selected rows deleted successfully"));
	}catch(Exception e) {
		return ResponseEntity.status
				(HttpStatus.INTERNAL_SERVER_ERROR).body
				(Map.of("status","error","message",e.getMessage()));
	}
}

@RequestMapping("mypagefilter")
public String mypagefilter(@ModelAttribute("sch") Emp_master_f sch,Emp_master_his_f psearch,
		 sal_f sch1,Model d,HttpSession session) {
	Emp_pinfo_f emp =(Emp_pinfo_f)session.getAttribute("emp");

	if(emp.getAuth().equals("관리자")) {
		d.addAttribute("empList", service.getEmpList(sch));
		d.addAttribute("salList", service.getSalList(sch1));
		d.addAttribute("EmpHistory", service.EmpHistory(psearch));
			return "kjw/z05_bootTmp/a70_tablesadmin";

		} else { /* if(emp.getAuth()=="직원") */
			d.addAttribute("empList", service.getEmpList(sch));
			d.addAttribute("salList", service.getSalList(sch1));
			d.addAttribute("EmpHistory", service.EmpHistory(psearch));
		return "kjw/z05_bootTmp/a70_tables";
		}
}

@RequestMapping("HRFilter")
public String HRFilter(@ModelAttribute("sch") Emp_master_f sch,Emp_master_his_f psearch, Model d,HttpSession session) {
	Emp_pinfo_f emp=(Emp_pinfo_f)session.getAttribute("emp");
	if(emp.getDname().equals("인사팀")) {
		d.addAttribute("empList", service.getEmpList(sch));
		d.addAttribute("EmpHistory", service.EmpHistory(psearch));
		return "kjw/z05_bootTmp/a70_tablesadmin";

	}else {
		return "권한이 없는 사용자입니다.";
	}
}
@RequestMapping("FIFilter")
public String FIFilter(@ModelAttribute("sch") sal_f sal, Model d,HttpSession session) {
	Emp_pinfo_f emp=(Emp_pinfo_f)session.getAttribute("emp");
	if(emp.getDname().equals("재무팀")) {
		d.addAttribute("salList", service.getSalList(sal));
		return "kjw/z05_bootTmp/a70_tablesadmin";

	}else {
		System.out.println("등록되지않은 유저입니다");
		return "${path}/mainpage";
	}
}
@RequestMapping("commute_frm")
public String commuteFrm() {
	return "kjw/z05_bootTmp/a20_cards";
}
@RequestMapping(value ="commute_s", method = {RequestMethod.POST,RequestMethod.GET})
public String commute_s(Commute_f ins,Commute_f sch,Model d,Commute_f csch,@DateTimeFormat(pattern="HH:mm:ss") Date starttime,HttpSession session) {
	Emp_pinfo_f emp=(Emp_pinfo_f)session.getAttribute("emp");
	d.addAttribute("msg",service.commute_s(ins)>0?"출근등록성공":"출근등록실패");
	d.addAttribute("inputS", service.starttime_c(csch));
	d.addAttribute("inputE", service.endtime_c(csch));
	d.addAttribute("LatestEmp", service.LatestEmp());
	return "kjw/z05_bootTmp/a20_cards";
	
}
@RequestMapping("commute_start")
public String commute_start(Commute_f ins, Model d,HttpSession session,Commute_f csch) {
	Emp_pinfo_f emp=(Emp_pinfo_f)session.getAttribute("emp");
	if(ins.getEmpno()!=0) {/// form에 입력값이 있을 때..처리
		d.addAttribute("inputS", service.starttime_c(csch));
		d.addAttribute("inputE", service.endtime_c(csch));
		d.addAttribute("msg",service.commute_s(ins)>0?"출근등록성공":"출근등록실패");
	}
	return "kjw/z05_bootTmp/a20_cards";
}
@RequestMapping("commute_end")
public String commute_end(Commute_f ins, Model d,HttpSession session,Commute_f csch) {
	Emp_pinfo_f emp=(Emp_pinfo_f)session.getAttribute("emp");
	if(ins.getEmpno()!=0) {/// form에 입력값이 있을 때..처리
		d.addAttribute("inputS", service.starttime_c(csch));
		d.addAttribute("inputE", service.endtime_c(csch));
		d.addAttribute("msg",service.commute_e(ins)>0?"퇴근등록성공":"퇴근등록실패");
	}
	return "kjw/z05_bootTmp/a20_cards";
}
@Autowired(required = false)
@RequestMapping(value="confirming", method = {RequestMethod.POST,RequestMethod.GET})
public String mailSend(MailSender email,  Model d) {
	d.addAttribute("LatestEmp", service.LatestEmp());
	if(email.getEmail()!=null) {
	System.out.println("email:"+email.getEmail());
	System.out.println("password:"+email.getPassword());
	d.addAttribute("msg", service.sendMail(email));
	
	}else {
		return "mailVo.getReceiver()";
	}
	return "kjw/z05_bootTmp/a84_register";
}

@RequestMapping("registerFrm")
public String registerFrm() {
	return "kjw/z05_bootTmp/a84_register";
}
@RequestMapping(value="register", method = {RequestMethod.POST,RequestMethod.GET})
public String register(Emp_master_f ins,Model d,MailSender email,HttpSession session) {
	
	d.addAttribute("LatestEmp", service.LatestEmp());
	if(email.getEmail()!=null) {
	System.out.println("email:"+email.getEmail());
	System.out.println("password:"+email.getPassword());
	System.out.println("empno:"+email.getEmpno());
	Emp_pinfo_f emp =(Emp_pinfo_f)session.getAttribute("emp");
	}
	else {
			System.out.println("등록되지않은 메시지입니다");
		}
	return "kjw/z05_bootTmp/a84_register";
	}

@RequestMapping("updateFrm")
public String updateFrm() {
	return "kjw/z05_bootTmp/detailpage";
}
@RequestMapping("updateinfo")
public String updateinfo(Emp_master_f upt,HttpSession session,Model d) {
	Emp_pinfo_f emp =(Emp_pinfo_f)session.getAttribute("emp");
	Emp_master_f emplist =(Emp_master_f)session.getAttribute("emplist");
	d.addAttribute("msg",service.updateinfo(upt)>0?"수정성공":"수정실패");
	return "kjw/z05_bootTmp/detailpage";
}

//컨테이너에 선언한 지역 언어선택 객체 호출

	

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
