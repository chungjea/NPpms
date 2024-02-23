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

	public int doneProj(int empno) {
		return dao.doneProj(empno);
	}

	public String register(Emp_master_f ins, MailSender email) {
		sendMail(email);

		String msg = dao.register(ins) > 0 ? "회원정보등록성공" : "회원정보등록실패";
		int empno = dao.LatestEmp();
		ins.setEmpno(empno);

		return msg += sendMail(email);

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

	// 메일발송 메서드
	@Autowired(required = false)
	// 메일발송 메서드
	public String sendMail(MailSender email) {
		String msg = "";
		// 1. 메일 발송 데이터 전송을 위한 객체 생성.
		MimeMessage mmsg = sender.createMimeMessage();
		// 2. 해당 객체로 화면단에 입력된 내용 할당
		try {
			// 1) 제목
			mmsg.setSubject(email.getTitle());
			// 2) 수신자
			mmsg.setRecipient(RecipientType.TO, new InternetAddress(email.getEmail()));
			// 3) 내용
			mmsg.setText("사번:" + email.getEmpno() + "비번:" + email.getPassword());

			// 4) 발송처리..
			sender.send(mmsg);
			msg = "메일발송 성공";
			/*
			
				 
			 * 
			 * */
		} catch (MessagingException e) {
			System.out.println("메시지 전송 에러 발송:" + e.getMessage());
			msg = "메일 발송 에러 발생:" + e.getMessage();
		} catch (Exception e) {
			System.out.println("기타 에러 :" + e.getMessage());
			msg = "기타 에러 발생:" + e.getMessage();
		}
		return msg;
	}

}
