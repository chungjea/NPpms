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

	// 전체조회
	public List<Calendar_f> getCalList(String dName) {
		return dao.getCalList(dName);
	}// getCalList()

	// 등록
	public String insertCalendar(Calendar_f ins) {
		return dao.insertCalendar(ins) > 0 ? "등록성공" : "등록실패";
	}// insertCalendar()

	// 수정
	public String updateCalendar(Calendar_f upt) {
		return dao.updateCalendar(upt) > 0 ? "등록성공" : "등록실패";
	}// updateCalendar()

	// 삭제
	public String deleteCalendar(int id) {
		return dao.deleteCalendar(id) > 0 ? "등록성공" : "등록실패";
	}// updateCalendar()
}// Calendar_fService{}
