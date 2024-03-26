package com.web.spring.service.hcj;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.spring.dao.hcj.GanttDao;
import com.web.spring.vo.Data;
import com.web.spring.vo.Project_f;
import com.web.spring.vo.TaskRink_f;
import com.web.spring.vo.Task_f;
@Service
public class GanttService {

	@Autowired(required = false)
	private GanttDao ganttdao;
		// 프로젝트 테스크 출력
		public List<Data> getTaskdatas(int pcode) {
			return ganttdao.getTaskdatas(pcode);
		}
		public List<TaskRink_f> getRink(int pcode){
			return ganttdao.getRink(pcode);
		}
		
		public String insertTask(Task_f ins) {
		
			
			return ganttdao.insertTask(ins)>0?"등록성공":"등록실패";
		}

		public String updateTask(Task_f upt) {
		
			
			return ganttdao.updateTask(upt)>0?"수정성공":"수정실패";
		}
		public String deleteTask(Task_f del) {

			return ganttdao.deleteTask(del)>0?"삭제성공":"삭제실패";
		}
		
		public int deleteAllChildTask(Task_f cdel) {
			return ganttdao.deleteAllChildTask(cdel);
		}
		
		
		public String insertRink(TaskRink_f ins) {
			return ganttdao.insertRink(ins)>0?"링크 생성 성공":"링크 생성 실패";
		}
		
		public String deleteLink(TaskRink_f del) {
			return ganttdao.deleteTaskLink(del)>0?"링크 삭제 성공":"링크 삭제 실패";
		}
}
