package com.web.spring.service.kjw;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.spring.dao.kjw.A03_Dao_kjw;
import com.web.spring.vo.Commute_f;
import com.web.spring.vo.Emp_master_f;
import com.web.spring.vo.Emp_master_his_f;
import com.web.spring.vo.Emp_pinfo_f;

import com.web.spring.vo.MailSender;
import com.web.spring.vo.Project_f;
import com.web.spring.vo.Tmem_f;
import com.web.spring.vo.sal_f;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMessage.RecipientType;

@Service
public class A02_Service_kjw {
	@Autowired(required = false)
	private JavaMailSender sender;
	@Autowired(required = false)
	private A03_Dao_kjw dao;

	public Emp_pinfo_f login(Emp_pinfo_f sch) {

		if (sch.getPasswd() == null)
			sch.setPasswd("");
		return dao.login(sch);

	}

	public int empcnt(Emp_master_f cnt) {
		return dao.empcnt(cnt);
	}

	public int sumProj(int empno) {
		return dao.sumProj(empno);
	}

	public int LatestEmp() {
		System.out.println("test");
		return dao.LatestEmp();
	}

	public List<Emp_master_f> Emplist() {
		return dao.Emplist();

	}

	public List<Project_f> doneProjA(Emp_pinfo_f emp) {
		return dao.doneProjA(emp);
	}
	public List<Project_f> doneProjA1(Emp_pinfo_f emp) {
		return dao.doneProjA1(emp);
	}

	public List<Project_f> doneProjN(Emp_pinfo_f emp) {
		return dao.doneProjN(emp);
	}
	public List<Project_f> doneProjN1(Emp_pinfo_f emp) {
		return dao.doneProjN1(emp);
	}

	public int getsal() {
		return dao.getsal();
	}

	public String register(Emp_master_f ins) {

		return dao.register(ins) > 0 ? "등록성공" : "등록실패";
	}

	public int commute_e(Commute_f ins) {
		if (ins.getEmpno() == 0)
			ins.setEmpno(0);
		if (ins.getEname() == null)
			ins.setEname("");

		return dao.commute_e(ins);
	}

	public int commute_s(Commute_f ins) {
		if (ins.getEmpno() == 0)
			ins.setEmpno(0);
		if (ins.getEname() == null)
			ins.setEname("");

		return dao.commute_s(ins);
	}

	public Commute_f commute_f(Commute_f sch) {
		if (sch.getEmpno() == 0)
			sch.setEmpno(0);
		return dao.commute_f(sch);
	}

	public int updateinfo(Emp_master_f upt) {
		return dao.updateinfo(upt);
	}

	public int findpwd(int empno) {
		sendMail1(empno);
		return dao.checkEmail(empno) > 0 ? empno : 0;

	}

	@Transactional
	public void deleteEmps(List<Integer> empno) {
		dao.deleteEmps(empno);
	}

	@Transactional
	public void deleteEmpsagain(List<Integer> empno) {
		dao.deleteEmpsagain(empno);
	}

	public List<Emp_master_f> getEmpList(Emp_master_f sch) {
		if (sch.getEmpno() == 0)
			sch.setEmpno(0);
		if (sch.getDname() == null)
			sch.setDname("");

		return dao.getEmpList(sch);
	}

	public List<Emp_master_his_f> EmpHistory(Emp_master_his_f psearch) {
		if (psearch.getEmpno() == 0)
			psearch.setEmpno(0);
		if (psearch.getDname() == null)
			psearch.setDname("");

		return dao.EmpHistory(psearch);
	}

	public List<sal_f> getSalList(sal_f ssah) {
		if (ssah.getEmpno() == 0)
			ssah.setEmpno(0);
		return dao.getSalList(ssah);
	}

	public List<Commute_f> starttime_c(Commute_f csch) {
		if (csch.getEmpno() == 0)
			csch.setEmpno(0);
		if (csch.getALLTIME() == null)
			csch.setALLTIME(null);
		return dao.starttime_c(csch);
	}

	public List<Commute_f> endtime_c(Commute_f csch) {
		if (csch.getEmpno() == 0)
			csch.setEmpno(0);
		if (csch.getALLTIME() == null)
			csch.setALLTIME(null);
		return dao.endtime_c(csch);
	}

	// 메일발송 메서드
	@Autowired(required = false)
	// 메일발송 메서드
	public String sendMail(String email) {
		String Emsg = "";
		Emp_master_f Einform = dao.getnewinfo(email);
		// 1. 메일 발송 데이터 전송을 위한 객체 생성.
		MimeMessage mmsg = sender.createMimeMessage();
		// 2. 해당 객체로 화면단에 입력된 내용 할당
		try {

			// 1) 제목
			mmsg.setSubject("PMS시스템 사원번호와 임시비밀번호입니다");
			// 2) 수신자
			mmsg.setRecipient(RecipientType.TO, new InternetAddress(Einform.getEmail()));
			// 3) 내용
			mmsg.setText("사번:" + Einform.getEmpno() + "비번:" + Einform.getPasswd());

			// 4) 발송처리..
			sender.send(mmsg);
			Emsg = "메일발송 성공";
			/*
			
				 
			 * 
			 * */
		} catch (MessagingException e) {
			System.out.println("메시지 전송 에러 발송:" + e.getMessage());
			Emsg = "메일 발송 에러 발생:" + e.getMessage();
		} catch (Exception e) {
			System.out.println("기타 에러 :" + e.getMessage());
			Emsg = "기타 에러 발생:" + e.getMessage();
		}
		return Emsg;
	}

	/*
	 * @Autowired(required = false) // 메일발송 메서드 public String resetpwd(String email)
	 * { String message=""; Emp_master_f find = dao.getnewpwd(empno); // 1. 메일 발송
	 * 데이터 전송을 위한 객체 생성. MimeMessage mmsg = sender.createMimeMessage(); // 2. 해당 객체로
	 * 화면단에 입력된 내용 할당 try {
	 * 
	 * // 1) 제목 mmsg.setSubject("PMS시스템 임시비밀번호입니다"); // 2) 수신자
	 * mmsg.setRecipient(RecipientType.TO, new InternetAddress(find.getEmail())); //
	 * 3) 내용 mmsg.setText("비번:" + find.getPasswd());
	 * 
	 * // 4) 발송처리.. sender.send(mmsg); message = "메일발송 성공";
	 * 
	 * 
	 * 
	 * 
	 * 
	 * } catch (MessagingException e) { System.out.println("메시지 전송 에러 발송:" +
	 * e.getMessage()); message = "메일 발송 에러 발생:" + e.getMessage(); } catch
	 * (Exception e) { System.out.println("기타 에러 :" + e.getMessage()); message =
	 * "기타 에러 발생:" + e.getMessage(); } return message; }
	 */


	
	@Autowired(required=false) // 메일발송 메서드 
	public String sendMail1(int empno)

	{ String Emsg = "";
	MimeMessage mmsg = sender.createMimeMessage();
	Emp_master_f fsch = dao.findpwd(empno); // 1. 메일발송 데이터 전송을 위한 객체 생성.  // 2. 해당객체로 화면단에 입력된 내용 할당 
	try {
	  
	 // 1) 제목 
		mmsg.setSubject("PMS시스템 현재비밀번호입니다"); 
		// 2) 수신자
	  mmsg.setRecipient(RecipientType.TO, new InternetAddress(fsch.getEmail())); 
	  //3) 내용 
mmsg.setText( "비번:" + fsch.getPasswd());
	 
	  // 4) 발송처리.. 
sender.send(mmsg); 
Emsg = "메일발송 성공";
	  
	  
	  
	  
	 
	  } catch (MessagingException e) { System.out.println("메시지 전송 에러 발송:" +
	 e.getMessage()); Emsg = "메일 발송 에러 발생:" + e.getMessage(); } catch (Exception
	  e) { System.out.println("기타 에러 :" + e.getMessage()); Emsg = "기타 에러 발생:" +
	  e.getMessage(); 
	  } 
	return Emsg; 
	}

}
