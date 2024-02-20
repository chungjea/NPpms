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
import com.web.spring.vo.Emp_pinfo_f;
import com.web.spring.vo.MailSender;
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
		
		if(sch.getPasswd()==null) sch.setPasswd(""); 
		return dao.login(sch);
		
	}
	public List<Emp_master_f> Emplist(){
		return dao.Emplist();

}
	public int register(Emp_master_f ins) {
		return dao.register(ins);
}
	public int commute_s(Commute_f ins) {
		 if(ins.getEmpno()==0) ins.setEmpno(0);
		 if(ins.getEname()==null) ins.setEname("");

		return dao.commute_s(ins);
	}
	public Commute_f commute_f(Commute_f sch) {
		if(sch.getEmpno()==0) sch.setEmpno(0);
		return dao.commute_f(sch);
	}
	public int updateinfo(Emp_master_f upt) {
		return dao.updateinfo(upt);
	}

	@Transactional
	public void deleteEmps(List<Integer> empno) {
		dao.deleteEmps(empno);
	}
	
	public List<Emp_master_f> getEmpList(Emp_master_f sch){
		if(sch.getEmpno()==0) sch.setEmpno(0);
		if(sch.getDname()==null) sch.setDname("");
		
		
		return dao.getEmpList(sch);
	}
	public List<sal_f> getSalList(sal_f sch){
		if(sch.getEmpno()==0) sch.setEmpno(0);
		return dao.getSalList(sch);
	}


	// 메일발송 메서드
	public String sendMail(MailSender email) {
		
		
		String msg="";
		// 1. 메일 발송 데이터 전송을 위한 객체 생성.
		MimeMessage mmsg = sender.createMimeMessage();
		// 2. 해당 객체로 화면단에 입력된 내용 할당
		try {
		//	1) 제목	
			mmsg.setSubject(email.getTitle());
		//  2) 수신자
			mmsg.setRecipient(RecipientType.TO, 
					new InternetAddress(email.getEmail()));
		//  3) 내용
			mmsg.setText(email.getContent());
		// 3-1) 사번
			mmsg.setText(email.getEmpno());

		//  4) 발송처리..	
			sender.send(mmsg);
			msg = "메일발송 성공";
		/*
		# 회사 인사시스템에서 아이디생성/임시비번 생성/메일 발송/인사기본 데이터 저장.
		1. 인사담담자 : 메일:[    ] 이름:[   ] [클릭] 
		2. 요청값을 받아서.
			1) 회사사번생성(DB sequence + 부서코드 + 회사코드 + 입사일 조합)
			2) 임시비번생성(숫자 + 알파벳 char 랜덤으로 자리수로 생성)
			3) 입력한 메일주소와 함께 DB(회사인사테이블)에 등록
			4) 메일주소로 사번/비번을 타이틀과 내용을 발송 처리
		3. 메일을 받은 사원은 생성된 사번과 임시비번으로 로그인 하여,
			개인 정보를 추가 등록 처리한다.
		# 아이디와 비번을 잊었을 때.
		1. 등록한 메일 주소를 입력하세요.[    ]
		2. 해당 메일 주소로 아이디와 비번을 메일로 발송 처리.
			
			 
		 * 
		 * */	
		} catch (MessagingException e) {
			System.out.println("메시지 전송 에러 발송:"+e.getMessage());
			msg = "메일 발송 에러 발생:"+e.getMessage();
		} catch(Exception e) {
			System.out.println("기타 에러 :"+e.getMessage());
			msg = "기타 에러 발생:"+e.getMessage();			
		}
		return msg;
	}

}

