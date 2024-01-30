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
import com.web.spring.vo.NoticeSch_f;
import com.web.spring.vo.Noticeboard_f;
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

	// 공지 전체 + 페이지
	// http://localhost:5080/team03/noticePage.do
	@RequestMapping("noticePage")
	public String getNoticeboard(@ModelAttribute("sch") NoticeSch_f sch, Model d) {
		d.addAttribute("noticeboard", service.noticePage(sch));
		return "lsd/z05_bootTmp/noticeBoard";
	}// getNoticeboard()

	// 공지 세부
	// http://localhost:5080/team03/noticeboardDetail.do
	@RequestMapping("noticeboardDetail")
	public String noticeboardDetail(@RequestParam("notice_num") int notice_num, Model d) {
		d.addAttribute("notice", service.noticeboardDetail(notice_num));
		return "lsd/z05_bootTmp/noticeDetail";
	}// getNoticeboard()

	// 공지 등록 폼
	// http://localhost:7080/springweb/insertNoticeFrm.do
	@RequestMapping("insertNoticeFrm")
	public String insertNoticeFrm(Noticeboard_f noticeIns) {
		return "lsd/z05_bootTmp/InsertNotice";
	}// insertNoticeFrm()

	// 공지 등록
	@RequestMapping("insertNotice")
	public String insertNotice(Noticeboard_f ins, Model d) {
		System.out.println(ins.getContent());
		d.addAttribute("msg", service.insertNotice(ins));
		return "lsd/z05_bootTmp/InsertNotice";
	}// insertNotice()

	// 수정
	// 게시글을 더블클릭했을 떄 상세화면이 나오고, 그 화면에서 내가 수정하면 수정이 되는것
	@RequestMapping("updateNotice")
	public String updateBoard(Noticeboard_f upt, Model d) {
		System.out.println("title : " + upt.getTitle());
		System.out.println("title : " + upt.getContent());

		// 수정 처리 내용
		d.addAttribute("proc", "upt");
		d.addAttribute("msg", service.updateNotice(upt));
		// 수정이후, 데이터(상세정보가 보임)
		d.addAttribute("afterUpt", service.noticeboardDetail(upt.getNotice_num()));
		return "lsd/z05_bootTmp/noticeDetail";
	}// updateBoard()

	// http://localhost:7080/board/deleteNotice.do?no=10
	// 삭제 deleteBoard.do?no=10
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
		if (report != null && report.length > 0) {
			try {
				for (MultipartFile mf : report) {
					String fname = mf.getOriginalFilename();
					if (fname != null && !fname.equals("")) {
						mf.transferTo(new File(path + fname));
						d.addAttribute("msg", "파일등록 성공");
					}else {
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
	}//noticefileupload()
	
	// 클라이언트에서 요청 처리
	// location.href="${path}/downloadNotice.do?fname=1.pdf"
	@RequestMapping("downloadNotice.do")
	public String download(@RequestParam("fname") String fname,
					Model d) {
		// view에서 사용할 파일명
			d.addAttribute("downloadNotice", fname);
			// 파일명 전달하고 내가 어떤 view를 호출할 것인가
			return "lsd/z05_bootTmp/downloadViewer_lsd";
		}//download()
		/* view의 이름 : downloadViewer
		 	모델명 : downloadFile
		*/
}// A01_Controller_lsd{}
