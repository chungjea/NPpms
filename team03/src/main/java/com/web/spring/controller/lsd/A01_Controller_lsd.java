package com.web.spring.controller.lsd;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.web.spring.service.lsd.A02_Service_lsd;
import com.web.spring.vo.Emp_pinfo_f;
import com.web.spring.vo.NoticeSch_f;
import com.web.spring.vo.Noticeboard_f;
import com.web.spring.vo.Project_f;

import jakarta.servlet.http.HttpSession;

/*
Noticeboard_f 
private int notice_num;
private String writer;
private String content;
private Date regDate;
private Date updateDate;
private String title;

public class NoticeFile_f 
private int no;
private String fname;
private String path;
private Date regdte;
private Date uptdte;
private String etc;
*/
@Controller
public class A01_Controller_lsd {
	@Autowired
	private A02_Service_lsd service;

	// 프로젝트별 조회 === pcode ===
	// http://localhost:3333/noticePage
	@RequestMapping("noticePage")
	public String projectSearch(Model d, int pcode, HttpSession session) {
		Emp_pinfo_f emp = (Emp_pinfo_f)session.getAttribute("emp");
		if(emp!=null) {
			d.addAttribute("projectSearch", service.projectSearch(pcode));
		}
		return "lsd/z05_bootTmp/noticeBoard";
	}
	
	
	// 부서별 조회 deptSearch
//	@GetMapping("noticePage")
//	public String deptSearch(Model d, HttpSession session) {
//		Emp_pinfo_f emp = (Emp_pinfo_f)session.getAttribute("emp");
//		String dname = emp.getDname();
//		System.out.println("?dname?"+dname);
//		d.addAttribute("deptSearch", service.deptSearch(dname));
//		return "lsd/z05_bootTmp/noticeBoard";
//	}//deptSearch()

	// 검색
	@RequestMapping("noticeSch")
	public String noticeSch(Noticeboard_f sch, Model d) {
		d.addAttribute("noticeboard", service.noticeSch(sch));
		return "lsd/z05_bootTmp/noticeBoard";
	}

	// 공지 전체 + 페이지 == dname있는데 pcode
	// http://localhost:3333/noticePage
//	@RequestMapping("noticePage")
//	public String getNoticeboard(@ModelAttribute("sch") NoticeSch_f sch, Model d, HttpSession session) {
//		Emp_pinfo_f emp = (Emp_pinfo_f)session.getAttribute("emp");
//		if (emp != null) {
//			String dname = emp.getDname();
//			d.addAttribute("noticeboard", service.noticePage(sch, dname));
//		}
//		return "lsd/z05_bootTmp/noticeBoard";
//	}// getNoticeboard()

	// 공지 세부
	// http://localhost:3333/noticeboardDetail
	@RequestMapping("noticeboardDetail")
	public String noticeboardDetail(@RequestParam("notice_num") int notice_num, 
									@RequestParam("pcode") int pcode,
									Model d) {
		d.addAttribute("notice", service.noticeboardDetail(notice_num,pcode));
		d.addAttribute("noticeFile",service.getNoticeFile(notice_num));
		return "lsd/z05_bootTmp/noticeDetail";
	}// getNoticeboard()

	// 공지 등록 폼
	// http://localhost:3333/springweb/insertNoticeFrm
	@RequestMapping("insertNoticeFrm")
	public String insertNoticeFrm(Noticeboard_f noticeIns) {
		return "lsd/z05_bootTmp/InsertNotice";
	}// insertNoticeFrm()

	 //공지 등록 === pcode ===
	@RequestMapping("insertNotice")
	public String insertNotice(Noticeboard_f ins, Model d, HttpSession session,int pcode) {
		Emp_pinfo_f emp = (Emp_pinfo_f) session.getAttribute("emp");
		if(emp!=null) {
			d.addAttribute("msg", service.insertNotice(ins));
		}
		return "lsd/z05_bootTmp/InsertNotice";
	}// insertNotice()
	
	// 공지 등록 == dname있는데 pcode
//	@RequestMapping("insertNotice")
//	public String insertNotice(Noticeboard_f ins, Model d, HttpSession session) {
//		Emp_pinfo_f emp = (Emp_pinfo_f) session.getAttribute("emp");
//		String dname = emp.getDname();
//		d.addAttribute("msg", service.insertNotice(ins));
//		return "lsd/z05_bootTmp/InsertNotice";
//	}// insertNotice()

	// 수정
	// 게시글을 더블클릭했을 떄 상세화면이 나오고, 그 화면에서 내가 수정하면 수정이 되는것
	@RequestMapping("updateNotice")
	public String updateBoard(Noticeboard_f upt, Model d, int pcode) {
		// 수정 처리 내용
		d.addAttribute("proc", "upt");
		d.addAttribute("msg", service.updateNotice(upt,pcode));
		// 수정이후, 데이터(상세정보가 보임)
		d.addAttribute("afterUpt", service.noticeboardDetail(upt.getNotice_num(),upt.getPcode()));
		
		
		return "lsd/z05_bootTmp/noticeDetail";
	}// updateBoard()

	// http://localhost:3333/board/deleteNotice?no=10
	// 삭제 deleteBoard?no=10
	@RequestMapping("deleteNotice")
	public String deleteNotice(@RequestParam("no") int notice_num, Model d) {
		d.addAttribute("proc", "del");
		d.addAttribute("msg", service.deleteNotice(notice_num));
		return "lsd/z05_bootTmp/noticeDetail";
	}// deleteNotice{}

	// 파일업로드
	// 파일 업로드 폼
	@GetMapping("noticeFileupload")
	public String noticeFileuploadFrm() {
		return "lsd/z05_bootTmp/noticefileupload";
	}

	// 파일 업로드 경로
	@Value("${file.upload}")
	private String path;

	@PostMapping("noticefileupload")
	public String noticefileupload(@RequestParam("report") MultipartFile[] report, Model d) {
		System.out.println("경로???" + path);
		if (report != null && report.length > 0) {
			try {
				for (MultipartFile mf : report) {
					String fname = mf.getOriginalFilename();
					if (fname != null && !fname.equals("")) {
						mf.transferTo(new File(path + fname));
						d.addAttribute("msg", "파일등록 성공");
					} else {
						d.addAttribute("msg", "파일등록 실패");
					}
				}
			} catch (IllegalStateException e) {
				d.addAttribute("msg", "파일등록 실패");
			} catch (IOException e) {
				d.addAttribute("msg", "파일등록 실패");
			}
		} else {
			d.addAttribute("msg", "파일등록 실패");
		}
		return "lsd/z05_bootTmp/noticefileupload";
	}// noticefileupload()
}// A01_Controller_lsd{}
