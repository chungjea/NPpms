package com.web.spring.service.lsd;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.web.spring.dao.lsd.A03_Dao_lsd;
import com.web.spring.vo.NoticeFile_f;
import com.web.spring.vo.NoticeSch_f;
import com.web.spring.vo.Noticeboard_f;

@Service
public class A02_Service_lsd {
	@Autowired(required = false)
	private A03_Dao_lsd dao;

	public List<Noticeboard_f> noticeSch(Noticeboard_f sch) {
		if (sch.getTitle() == null)
			sch.setTitle("");
		return dao.noticeSch(sch);
	}//noticeSch 검색

	// 공지 전체조회 및 페이징처리
	public List<Noticeboard_f> noticePage(NoticeSch_f sch){
		if(sch.getTitle()==null) sch.setTitle("");
		if(sch.getWriter()==null) sch.setWriter("");
		sch.setCount(dao.totNotice(sch));
		if(sch.getPageSize()==0) sch.setPageSize(5);
		int totPage = (int)Math.ceil(sch.getCount()/(double)sch.getPageSize());
		sch.setPageCount(totPage);
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
		return dao.noticePage(sch);
	}//noticePage() 공지전체+페이징처리	
	
	//@RequestParam(value = "notice_num", defaultValue = "0") 안되면 껴넣을것 ▽
		public Noticeboard_f noticeboardDetail(int notice_num) {
			// 조회할 떄, 조회수 +1
			System.out.println("##############조회수 수정성공:"+dao.readCntUptNotice(notice_num));
			Noticeboard_f f =noticeDetail(notice_num);
			System.out.println("#####조회수결과 : "+f.getReadcnt());
			return noticeDetail(notice_num);
		}// noticeboardDetail() 공지 세부

		// 안되면 detail로 위아래 세부사항 전부
		public Noticeboard_f noticeDetail(int notice_num) {
			Noticeboard_f noticeboard = dao.noticeboardDetail(notice_num);
			noticeboard.setFname(dao.getNoticeFile(notice_num));
			return noticeboard;
		}// noticeDetail() 공지 세부

	/*public int insertNotice(Noticeboard_f ins) {
		return dao.insertNotice(ins);
	}// insertNotice() 공지 등록*/
	
	
	@Value("${file.upload}")
	private String path;
	public String insertNotice(Noticeboard_f ins) {
		
		// 기본데이터 등록 처리
		int ck01 = dao.insertNotice(ins);
		String msg=ck01>0?"기본정보 등록성공":"등록 실패"; msg+="\\n";
		int ck02 = 0;
		// 파일업로드 정보 등록 처리.
		MultipartFile [] mpfs = ins.getReports();
		
		if( mpfs!=null && mpfs.length>0) {
		
			try {
				for(MultipartFile mpf:mpfs) {
				//  1) 파일업로드 처리
					String fname = mpf.getOriginalFilename();
					
					// MultipartFile ==> File 변환해서 저장.
					mpf.transferTo(new File(path+fname));
				//  2) db파일업로드 정보 입력	
				//  등록되는 갯수만큼 numbering 처리..
					ck02+=dao.insertNoticeFile(
							new NoticeFile_f(fname,path,ins.getTitle()));
					
				}
			} catch (IllegalStateException e) {
				System.out.println("#파일업로드 예외1:"+e.getMessage());
				msg+="#파일업로드 예외1:"+e.getMessage()+"\\n";
			} catch (IOException e) {
				System.out.println("#파일업로드 예외2:"+e.getMessage());
				msg+="#파일업로드 예외2:"+e.getMessage()+"\\n";
			} catch(Exception e) {
				System.out.println("#기타 예외3:"+e.getMessage());
				msg+="#기타 예외3:"+e.getMessage()+"\\n";
			}
			msg+="파일 "+ck02+"건 등록 완료";
		}
		
		return msg;
	}

	public String updateNotice(Noticeboard_f upt) {
		return dao.updateNotice(upt) > 0 ? "수정성공" : "수정실패";
	}// updateNotice() 공지 수정

	public String deleteNotice(int notice_num) {
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
