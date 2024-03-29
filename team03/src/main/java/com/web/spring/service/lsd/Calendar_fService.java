package com.web.spring.service.lsd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.spring.dao.lsd.Calendar_fDao;
import com.web.spring.vo.Calendar_f;

@Service
public class Calendar_fService {
	@Autowired(required = false)
	private Calendar_fDao dao;

	// 전체조회(프로젝트별+개인)
	public List<Calendar_f> getCalList_all(int pcode,int empno) {
		return dao.getCalList_all(pcode,empno);
	}// getCalList_all()

	// 등록
	public String insertCalendar(Calendar_f ins) {
		return dao.insertCalendar(ins) > 0 ? "등록성공" : "등록실패";
	}// insertCalendar()

	// 수정
	public String updateCalendar(Calendar_f upt) {
		return dao.updateCalendar(upt) > 0 ? "수정성공" : "수정실패";
	}// updateCalendar()

	// 삭제
	public String deleteCalendar(int id) {
		return dao.deleteCalendar(id) > 0 ? "삭제성공" : "삭제실패";
	}// updateCalendar()
}// Calendar_fService{}