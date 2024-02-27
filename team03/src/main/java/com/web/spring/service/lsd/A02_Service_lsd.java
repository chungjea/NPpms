package com.web.spring.service.lsd;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.web.spring.dao.lsd.A03_Dao_lsd;
import com.web.spring.vo.NoticeFile_f;
import com.web.spring.vo.NoticeSch_f;
import com.web.spring.vo.Noticeboard_f;

@Service
public class A02_Service_lsd {
	@Autowired(required = false)
	private A03_Dao_lsd dao;
	
	@Value("${file.upload}")
	private String path;
	// 프로젝트별 조회
//	public List<Noticeboard_f> projectSearch(int pcode){
//		return dao.projectSearch(pcode);
//	}//projectSearch()
	
	// 부서별 조회
//	public List<Noticeboard_f> deptSearch(String dname){
//		return dao.deptSearch(dname);
//	}//deptSearch()
	
	// noticeSch 검색
	public List<Noticeboard_f> noticeSch(Noticeboard_f sch) {
		if (sch.getTitle() == null)
			sch.setTitle("");
		return dao.noticeSch(sch);
	}

	// 공지 전체조회 및 페이징처리
	public List<Noticeboard_f> noticePage(NoticeSch_f sch, int pcode){
		if(sch.getTitle()==null) sch.setTitle("");
		if(sch.getWriter()==null) sch.setWriter("");
		sch.setPcode(pcode);
		sch.setCount(dao.totNotice(sch));
		if(sch.getPageSize()==0) sch.setPageSize(5);
		int totPage = (int)Math.ceil(sch.getCount()/(double)sch.getPageSize());
		sch.setPageCount(totPage);
		
		if(sch.getCurPage()> sch.getPageCount()) sch.setCurPage(sch.getPageCount());
		if(sch.getCurPage()==0) sch.setCurPage(1);
		
		sch.setEnd(sch.getCurPage()*sch.getPageSize());
		if(sch.getEnd()>sch.getCount()) {
			sch.setEnd(sch.getCount() );
		}
		
		sch.setStart((sch.getCurPage()-1)*sch.getPageSize()+1);
		sch.setBlockSize(5);
		int blockNum = (int)Math.ceil(sch.getCurPage()/(double)sch.getBlockSize());
		sch.setEndBlock(blockNum*sch.getBlockSize());
		if(sch.getEndBlock()>sch.getPageCount()) {
			sch.setEndBlock(sch.getPageCount());
		}
		sch.setStartBlock((blockNum-1)*sch.getBlockSize()+1);
//		System.out.println("매개변수 -> "+ sch);
		List<Noticeboard_f> list = dao.noticePage(sch);
		list.stream().forEach(it -> System.out.println(it.getNotice_num()));
		return list;
	}//noticePage() 공지전체+페이징처리	
	
	// noticeDetail() 공지 세부
	//@RequestParam(value = "notice_num", defaultValue = "0") 안되면 껴넣을것 ▽
	// === pcode ===
		public Noticeboard_f noticeboardDetail(int notice_num, int pcode) {
			// 조회할 떄, 조회수 +1
			//System.out.println("##############조회수 수정성공:"+dao.readCntUptNotice(notice_num));
			Noticeboard_f f =noticeDetail(notice_num,pcode);
			//System.out.println("#####조회수결과 : "+f.getReadcnt());
			return noticeDetail(notice_num,pcode);
		}// noticeboardDetail() 공지 세부

		// 안되면 detail로 위아래 세부사항 전부
		public Noticeboard_f noticeDetail(int notice_num, int pcode) {
			Noticeboard_f noticeboard = dao.noticeboardDetail(notice_num,pcode);
			//noticeboard.setFname(dao.getNoticeFile(notice_num));
			return noticeboard;
		}


		public List<NoticeFile_f> getNoticeFile(int notice_num) {
			return dao.getNoticeFile(notice_num);
		}
		
	/*public int insertNotice(Noticeboard_f ins) {
		return dao.insertNotice(ins);
	}// insertNotice() 공지 등록*/
	
	
	// 파일 업로드랑 같이
	public String insertNotice(Noticeboard_f ins) {
		System.out.println("서비스 시작");
		// 기본데이터 등록 처리
		int ck01 = dao.insertNotice(ins);

		//String path = "C:\\a01_springbt\\workspace\\maven.1708065300599\\team03\\src\\main\\webapp\\WEB-INF\\z01_upload\\";

		String msg=ck01>0?"기본정보 등록성공":"등록 실패"; msg+="\\n";
		int ck02 = 0;
		// 파일업로드 정보 등록 처리.
		MultipartFile [] mpfs = ins.getReports();
		
		if( mpfs!=null && mpfs.length>0) {
		
			try {
				for(MultipartFile mpf:mpfs) {
				//  1) 파일업로드 처리
					String fname = mpf.getOriginalFilename();
					String fno = ""+dao.getfnoNF();
					// MultipartFile ==> File 변환해서 저장.
					// fname(실제 파일명)대신 sequence number로 파일 저장
					mpf.transferTo(new File(path+fno));
				//  2) db파일업로드 정보 입력	
				//  등록되는 갯수만큼 numbering 처리..
					ck02+=dao.insertNoticeFile(
							new NoticeFile_f(fname,path,ins.getTitle(),fno));
					int pcode = ins.getPcode();
					dao.insertfileNF(fname, path, fno, pcode);
					
				}
			} catch (IllegalStateException e) {
				//System.out.println("#파일업로드 예외1:"+e.getMessage());
				msg+="#파일업로드 예외1:"+e.getMessage()+"\\n";
			} catch (IOException e) {
				//System.out.println("#파일업로드 예외2:"+e.getMessage());
				msg+="#파일업로드 예외2:"+e.getMessage()+"\\n";
			} catch(Exception e) {
				//System.out.println("#기타 예외3:"+e.getMessage());
				msg+="#기타 예외3:"+e.getMessage()+"\\n";
			}
			msg+="파일 "+ck02+"건 등록 완료";
		}
		System.out.println("서비스 종료:");
		return msg;
	}

	public String getfnamebyfnoNF(String fno) {
		return dao.getfnamebyfnoNF(fno);
	}
	
	// updateNotice() 공지 수정
	public String updateNotice(Noticeboard_f upt) {
		String content = upt.getContent();
		String title = upt.getTitle();
		return dao.updateNotice(upt) > 0 ? "수정성공" : "수정실패";
	}//updateNotice()

	public String deleteNotice(int notice_num) {
		List<String> delFnames = dao.getfnobynameNF(notice_num);
		//String path = "C:\\Users\\82108\\git\\NPpms\\team03\\src\\main\\webapp\\WEB-INF\\z01_upload\\";
		for(String fname:delFnames) {
			File fileToDelete = new File(path+fname);
			if(fileToDelete.exists()) fileToDelete.delete();
		}
		if(dao.deleteNoticeFile(notice_num)>0) {
			dao.deletefileNF(notice_num);
		}
		return dao.deleteNotice(notice_num) > 0 ? "삭제성공" : "삭제실패";
	}// deleteNotice() 공지 삭제

	/*@Value("${file.upload}")
	private String path;
	
	// 파일 등록
	public String insertNoticeFile(Noticeboard_f ins) {

		// 기본데이터 등록 처리
		int ck01 = dao.insertNotice(ins);
		String msg = ck01 > 0 ? "기본정보 등록성공" : "등록 실패";
		msg += "\\n";
		int ck02 = 0;
		// 파일업로드 정보 등록 처리.
		MultipartFile[] mpfs = ins.getReports();

		if (mpfs != null && mpfs.length > 0) {

			try {
				for (MultipartFile mpf : mpfs) {
					// 1) 파일업로드 처리
					String fname = mpf.getOriginalFilename();
					if (!fname.equals("")) {
						// MultipartFile ==> File 변환해서 저장.
						mpf.transferTo(new File(path + fname));
						// 2) db파일업로드 정보 입력
						// 등록되는 갯수만큼 numbering 처리..
						ck02 += dao.insertNoticeFile(new NoticeFile_f(fname, path, ins.getTitle()));
					}
				}
			} catch (IllegalStateException e) {
				System.out.println("#파일업로드 예외1:" + e.getMessage());
				msg += "#파일업로드 예외1:" + e.getMessage() + "\\n";
			} catch (IOException e) {
				System.out.println("#파일업로드 예외2:" + e.getMessage());
				msg += "#파일업로드 예외2:" + e.getMessage() + "\\n";
			} catch (Exception e) {
				System.out.println("#기타 예외3:" + e.getMessage());
				msg += "#기타 예외3:" + e.getMessage() + "\\n";
			}
			msg += "파일 " + ck02 + "건 등록 완료";
		}

		return msg;
	}//insertNoticeFile()*/
	
}// A02_Service_lsd{}
