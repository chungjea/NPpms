package com.web.spring.service.cjw;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.web.spring.dao.cjw.A03_Dao_cjw;
import com.web.spring.vo.ApproveSch;
import com.web.spring.vo.Approve_f;
import com.web.spring.vo.Apvfile_f;
import com.web.spring.vo.Chatroom_f;
import com.web.spring.vo.Emp_pinfo_f;
import com.web.spring.vo.FileSch;
import com.web.spring.vo.File_f;
import com.web.spring.vo.MeetingSch_f;
import com.web.spring.vo.Meeting_f;
import com.web.spring.vo.Metfile_f;
import com.web.spring.vo.RiskSch;
import com.web.spring.vo.Risk_f;
import com.web.spring.vo.Rskfile_f;
import com.web.spring.vo.Team;

@Service
public class A02_Service_cjw {
	@Autowired(required = false)
	private A03_Dao_cjw dao;
	@Value("${file.upload}")
	private String path;
	// 파일명 가져오기
	public String getfnamebyfno(String fno) {
		return dao.getfnamebyfno(fno);
	}
	
	// 결재 : 상신한 대기 문서 리스트
	public List<Approve_f> myapv(ApproveSch sch){
		if(sch.getSts()==null) sch.setSts("대기");
		if(sch.getTitle()==null) sch.setTitle("");
		sch.setCount(dao.mycnt(sch));
		if(sch.getPageSize()==0) sch.setPageSize(5);
		int totPage = (int)Math.ceil(sch.getCount()/(double)sch.getPageSize());
		sch.setPageCount(totPage);
		if(sch.getCurPage()>sch.getPageCount()) sch.setCurPage(sch.getPageCount());
		if(sch.getCurPage()==0) sch.setCurPage(1);
		sch.setEnd(sch.getCurPage()*sch.getPageSize());
		if(sch.getCurPage()*sch.getPageSize()>sch.getCount()) {
			sch.setEnd(sch.getCount());
		}
		sch.setStart((sch.getCurPage()-1)*sch.getPageSize()+1);
		sch.setBlockSize(5);
		int blockNum = (int)Math.ceil(sch.getCurPage()/(double)sch.getBlockSize());
		sch.setEndBlock(blockNum*sch.getBlockSize());
		if(sch.getEndBlock()>sch.getPageCount()) {
			sch.setEndBlock(sch.getPageCount());
		}
		sch.setStartBlock((blockNum-1)*sch.getBlockSize()+1);
		return dao.myapv(sch);
	}	
	// 결재 : 반려된 문서 리스트
	public List<Approve_f> badapv(ApproveSch sch){
		if(sch.getTitle()==null) sch.setTitle("");
		sch.setCount(dao.badcnt(sch));
		if(sch.getPageSize()==0) sch.setPageSize(5);
		int totPage = (int)Math.ceil(sch.getCount()/(double)sch.getPageSize());
		sch.setPageCount(totPage);
		if(sch.getCurPage()>sch.getPageCount()) sch.setCurPage(sch.getPageCount());
		if(sch.getCurPage()==0) sch.setCurPage(1);
		sch.setEnd(sch.getCurPage()*sch.getPageSize());
		if(sch.getCurPage()*sch.getPageSize()>sch.getCount()) {
			sch.setEnd(sch.getCount());
		}
		sch.setStart((sch.getCurPage()-1)*sch.getPageSize()+1);
		sch.setBlockSize(5);
		int blockNum = (int)Math.ceil(sch.getCurPage()/(double)sch.getBlockSize());
		sch.setEndBlock(blockNum*sch.getBlockSize());
		if(sch.getEndBlock()>sch.getPageCount()) {
			sch.setEndBlock(sch.getPageCount());
		}
		sch.setStartBlock((blockNum-1)*sch.getBlockSize()+1);
		return dao.badapv(sch);
	}
	// 결재 : 승인된 문서 리스트
	public List<Approve_f> goodapv(ApproveSch sch){
		if(sch.getTitle()==null) sch.setTitle("");
		sch.setCount(dao.goodcnt(sch));
		if(sch.getPageSize()==0) sch.setPageSize(5);
		int totPage = (int)Math.ceil(sch.getCount()/(double)sch.getPageSize());
		sch.setPageCount(totPage);
		if(sch.getCurPage()>sch.getPageCount()) sch.setCurPage(sch.getPageCount());
		if(sch.getCurPage()==0) sch.setCurPage(1);
		sch.setEnd(sch.getCurPage()*sch.getPageSize());
		if(sch.getCurPage()*sch.getPageSize()>sch.getCount()) {
			sch.setEnd(sch.getCount());
		}
		sch.setStart((sch.getCurPage()-1)*sch.getPageSize()+1);
		sch.setBlockSize(5);
		int blockNum = (int)Math.ceil(sch.getCurPage()/(double)sch.getBlockSize());
		sch.setEndBlock(blockNum*sch.getBlockSize());
		if(sch.getEndBlock()>sch.getPageCount()) {
			sch.setEndBlock(sch.getPageCount());
		}
		sch.setStartBlock((blockNum-1)*sch.getBlockSize()+1);
		return dao.goodapv(sch);
	}
	// 결재 : 결재처리를 해야하는 문서 리스트
	public List<Approve_f> ckapv(ApproveSch sch){
		if(sch.getTitle()==null) sch.setTitle("");
		sch.setCount(dao.tocnt(sch));
		if(sch.getPageSize()==0) sch.setPageSize(5);
		int totPage = (int)Math.ceil(sch.getCount()/(double)sch.getPageSize());
		sch.setPageCount(totPage);
		if(sch.getCurPage()>sch.getPageCount()) sch.setCurPage(sch.getPageCount());
		if(sch.getCurPage()==0) sch.setCurPage(1);
		sch.setEnd(sch.getCurPage()*sch.getPageSize());
		if(sch.getCurPage()*sch.getPageSize()>sch.getCount()) {
			sch.setEnd(sch.getCount());
		}
		sch.setStart((sch.getCurPage()-1)*sch.getPageSize()+1);
		sch.setBlockSize(5);
		int blockNum = (int)Math.ceil(sch.getCurPage()/(double)sch.getBlockSize());
		sch.setEndBlock(blockNum*sch.getBlockSize());
		if(sch.getEndBlock()>sch.getPageCount()) {
			sch.setEndBlock(sch.getPageCount());
		}
		sch.setStartBlock((blockNum-1)*sch.getBlockSize()+1);
		return dao.ckapv(sch);
	}
	// 결재 : 상신한 대기 문서의 수
	public int myapvcnt(ApproveSch sch) {
		return dao.myapvcnt(sch);
	}
	// 결재 : 상신한 반려 문서의 수
	public int badapvcnt(ApproveSch sch) {
		return dao.badapvcnt(sch);
	}
	// 결재 : 상신한 완료 문서의 수
	public int goodapvcnt(ApproveSch sch) {
		return dao.goodapvcnt(sch);
	}
	// 결재 : 결재처리를 해야하는 문서의 수
	public int toapvcnt(ApproveSch sch) {
		return dao.toapvcnt(sch);
	}

	// 결재 : 결재 상신
	public String insertapv(Approve_f ins) {
		String msg = "";
		//String path = "C:\\Users\\user\\git\\NPpms\\team03\\src\\main\\webapp\\WEB-INF\\z01_upload\\";
		if(dao.insertapv(ins)>0 && dao.insertapv2(ins)>0) {
			msg = "결재 상신 완료\\n";
		}else {
			msg = "결재 상신 실패\\n";
		}
		int ckf = 0;
		int wempno = ins.getWempno();
		int mempno = ins.getMempno();
		int pcode = ins.getPcode();
		MultipartFile[] mpfs = ins.getReports();
		if(mpfs!=null && mpfs.length>0) {
			try {
				for(MultipartFile mpf:mpfs) {
					if(mpf!=null) {
						String fname = mpf.getOriginalFilename();
						if(!fname.trim().equals("")) {
							String fno = ""+dao.getfno();
							mpf.transferTo(new File(path+fno));
							ckf+=dao.insertapvfile(new Apvfile_f(fname,path,fno));
							dao.insertfileapv(new Apvfile_f(fname,path,fno,wempno,pcode));
							dao.insertfileapv(new Apvfile_f(fname,path,fno,mempno, pcode));
						}
					}
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
			msg+="파일 "+ckf+"건 등록 완료\\n";
		}
		return msg;
	}
	
	// 결재 : 결재 올릴 같은 부서 사람들 명단
	public List<Team> getteammen(@Param("empno") int empno, @Param("pcode") int pcode) {
		return dao.getteammen(empno, pcode);
	}
	
	// 결재 : 결재 상세
	public Approve_f detailapv(int apvno) {
		return dao.detailapv(apvno);
	}
	public List<Apvfile_f> getapvfile(int apvno) {
		return dao.getapvfile(apvno);
	}
	
	// 결재 : 결재 처리
	public String doapv(Approve_f apv) {
		String msg = "";
		if(dao.doapv(apv)>0 && dao.doapv2(apv)>0) {
			msg = "결재 처리 완료\n";
		}
		return msg;
	}
	
	
	// 리스크 : 등록한 리스크 리스트
	public List<Risk_f> myrsk(RiskSch sch){
		if(sch.getWempno()==0) sch.setWempno(1000);
		if(sch.getCempno()==0) sch.setCempno(1000);
		if(sch.getManager()==0) sch.setManager(1000);
		if(sch.getTitle()==null) sch.setTitle("");
		sch.setCount(dao.myrskcntp(sch));
		if(sch.getPageSize()==0) sch.setPageSize(5);
		int totPage = (int)Math.ceil(sch.getCount()/(double)sch.getPageSize());
		sch.setPageCount(totPage);
		if(sch.getCurPage()>sch.getPageCount()) sch.setCurPage(sch.getPageCount());
		if(sch.getCurPage()==0) sch.setCurPage(1);
		sch.setEnd(sch.getCurPage()*sch.getPageSize());
		if(sch.getCurPage()*sch.getPageSize()>sch.getCount()) {
			sch.setEnd(sch.getCount());
		}
		sch.setStart((sch.getCurPage()-1)*sch.getPageSize()+1);
		sch.setBlockSize(5);
		int blockNum = (int)Math.ceil(sch.getCurPage()/(double)sch.getBlockSize());
		sch.setEndBlock(blockNum*sch.getBlockSize());
		if(sch.getEndBlock()>sch.getPageCount()) {
			sch.setEndBlock(sch.getPageCount());
		}
		sch.setStartBlock((blockNum-1)*sch.getBlockSize()+1);
		return dao.myrsk(sch);
	}
	// 리스크 : 담당자를 지정해야 하는 리스크 리스트
	public List<Risk_f> ckrsk(RiskSch sch){
		if(sch.getTitle()==null) sch.setTitle("");
		sch.setCount(dao.ckrskcntp(sch));
		if(sch.getPageSize()==0) sch.setPageSize(5);
		int totPage = (int)Math.ceil(sch.getCount()/(double)sch.getPageSize());
		sch.setPageCount(totPage);
		if(sch.getCurPage()>sch.getPageCount()) sch.setCurPage(sch.getPageCount());
		if(sch.getCurPage()==0) sch.setCurPage(1);
		sch.setEnd(sch.getCurPage()*sch.getPageSize());
		if(sch.getCurPage()*sch.getPageSize()>sch.getCount()) {
			sch.setEnd(sch.getCount());
		}
		sch.setStart((sch.getCurPage()-1)*sch.getPageSize()+1);
		sch.setBlockSize(5);
		int blockNum = (int)Math.ceil(sch.getCurPage()/(double)sch.getBlockSize());
		sch.setEndBlock(blockNum*sch.getBlockSize());
		if(sch.getEndBlock()>sch.getPageCount()) {
			sch.setEndBlock(sch.getPageCount());
		}
		sch.setStartBlock((blockNum-1)*sch.getBlockSize()+1);
		return dao.ckrsk(sch);
	}
	// 리스크 : 처리할 리스크 리스트
	public List<Risk_f> torsk(RiskSch sch){
		if(sch.getTitle()==null) sch.setTitle("");
		sch.setCount(dao.torskcntp(sch));
		if(sch.getPageSize()==0) sch.setPageSize(5);
		int totPage = (int)Math.ceil(sch.getCount()/(double)sch.getPageSize());
		sch.setPageCount(totPage);
		if(sch.getCurPage()>sch.getPageCount()) sch.setCurPage(sch.getPageCount());
		if(sch.getCurPage()==0) sch.setCurPage(1);
		sch.setEnd(sch.getCurPage()*sch.getPageSize());
		if(sch.getCurPage()*sch.getPageSize()>sch.getCount()) {
			sch.setEnd(sch.getCount());
		}
		sch.setStart((sch.getCurPage()-1)*sch.getPageSize()+1);
		sch.setBlockSize(5);
		int blockNum = (int)Math.ceil(sch.getCurPage()/(double)sch.getBlockSize());
		sch.setEndBlock(blockNum*sch.getBlockSize());
		if(sch.getEndBlock()>sch.getPageCount()) {
			sch.setEndBlock(sch.getPageCount());
		}
		sch.setStartBlock((blockNum-1)*sch.getBlockSize()+1);
		return dao.torsk(sch);
	}
	// 리스크 : 완료된 (등록/처리했던)리스크 리스트
	public List<Risk_f> finrsk(RiskSch sch){
		if(sch.getTitle()==null) sch.setTitle("");
		sch.setCount(dao.finrskcntp(sch));
		if(sch.getPageSize()==0) sch.setPageSize(5);
		int totPage = (int)Math.ceil(sch.getCount()/(double)sch.getPageSize());
		sch.setPageCount(totPage);
		if(sch.getCurPage()>sch.getPageCount()) sch.setCurPage(sch.getPageCount());
		if(sch.getCurPage()==0) sch.setCurPage(1);
		sch.setEnd(sch.getCurPage()*sch.getPageSize());
		if(sch.getCurPage()*sch.getPageSize()>sch.getCount()) {
			sch.setEnd(sch.getCount());
		}
		sch.setStart((sch.getCurPage()-1)*sch.getPageSize()+1);
		sch.setBlockSize(5);
		int blockNum = (int)Math.ceil(sch.getCurPage()/(double)sch.getBlockSize());
		sch.setEndBlock(blockNum*sch.getBlockSize());
		if(sch.getEndBlock()>sch.getPageCount()) {
			sch.setEndBlock(sch.getPageCount());
		}
		sch.setStartBlock((blockNum-1)*sch.getBlockSize()+1);
		return dao.finrsk(sch);
	}
	// 리스크 : 등록된 리스크의 수
	public int myrskcnt(RiskSch sch) {
		return dao.myrskcnt(sch);
	}
	// 리스크 : 담당자를 지정해야 할 리스크의 수
	public int ckrskcnt(RiskSch sch) {
		return dao.ckrskcnt(sch);
	}
	// 리스크 : 처리할 리스크의 수
	public int torskcnt(RiskSch sch) {
		return dao.torskcnt(sch);
	}
	// 리스크 : 완료된 리스크의 수
	public int finrskcnt(RiskSch sch) {
		return dao.finrskcnt(sch);
	}
	
	// 리스크 : 리스크 등록
	public String insertrsk(Risk_f ins) {
		String msg = "";
		//String path = "C:\\Users\\user\\git\\NPpms\\team03\\src\\main\\webapp\\WEB-INF\\z01_upload\\";
		if(dao.insertrsk(ins)>0 && dao.insertrsk2(ins)>0) {
			msg = "리스크 등록 완료\\n";
		}else {
			msg = "리스크 등록 실패\\n";
		}
		int ckf = 0;
		int wempno = ins.getWempno();
		int manager = ins.getManager();
		int pcode = ins.getPcode();
		MultipartFile[] mpfs = ins.getReports();
		if(mpfs!=null && mpfs.length>0) {
			try {
				for(MultipartFile mpf:mpfs) {
					if(mpf!=null) {
						String fname = mpf.getOriginalFilename();
						if(!fname.trim().equals("")) {
							String fno = ""+dao.getfno();
							mpf.transferTo(new File(path+fno));
							ckf+=dao.insertrskfile(new Rskfile_f(fname,path,fno));
							dao.insertfilersk(new Rskfile_f(fname,path,fno,wempno,pcode));
							dao.insertfilersk(new Rskfile_f(fname,path,fno,manager,pcode));
						}
					}
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
			msg+="파일 "+ckf+"건 등록 완료\\n";
		}
		return msg;
	}
	
	// 리스크 : 리스크 올릴 매니저 사번
	public int getmymanager(int pcode) {
		return dao.getmymanager(pcode);
	}
	
	// 리스크 : 리스크 상세
	public Risk_f detailrsk(int rskno) {
		Risk_f rsk = dao.detailrsk(rskno);
		if(rsk.getCharge().equals(" / ")) rsk.setCharge("");
		return rsk;
	}
	public List<Rskfile_f> getrskfile(int rskno) {
		return dao.getrskfile(rskno);
	}
	
	// 리스크 : 담당자 지정
	public String dorsk(Risk_f rsk) {
		String msg = "";
		if(dao.dorsk(rsk)>0 && dao.dorsk2(rsk)>0) {
			msg = "담당자 등록 완료\n";
			List<String> fno = dao.getrskfno(rsk);
			if(!fno.isEmpty()) {
				for(String no:fno) {
					int n = Integer.parseInt(no);
					Rskfile_f rf = dao.getrskfileinfo(n);
					rf.setEmpno(rsk.getCempno());
					rf.setPcode(rsk.getPcode());
					dao.insertfilersk2(rf);
				}
			}
		}
		return msg;
	}
	
	// 리스크 : 완료 처리
	public String donersk(int rskno) {
		String msg = "";
		if(dao.donersk(rskno)>0) {
			msg = "리스크 처리 완료\n";
		}
		return msg;
	}
	
	
	// 회의록 : 리스트 출력
	public List<Meeting_f> metlist(MeetingSch_f sch) {
		if(sch.getTitle()==null) sch.setTitle("");
		sch.setCount(dao.totmet(sch));
		if(sch.getPageSize()==0) sch.setPageSize(10);
		int totPage = (int)Math.ceil(sch.getCount()/(double)sch.getPageSize());
		sch.setPageCount(totPage);
		if(sch.getCurPage()>sch.getPageCount()) sch.setCurPage(sch.getPageCount());
		if(sch.getCurPage()==0) sch.setCurPage(1);
		sch.setEnd(sch.getCurPage()*sch.getPageSize());
		if(sch.getCurPage()*sch.getPageSize()>sch.getCount()) {
			sch.setEnd(sch.getCount());
		}
		sch.setStart((sch.getCurPage()-1)*sch.getPageSize()+1);
		sch.setBlockSize(5);
		int blockNum = (int)Math.ceil(sch.getCurPage()/(double)sch.getBlockSize());
		sch.setEndBlock(blockNum*sch.getBlockSize());
		if(sch.getEndBlock()>sch.getPageCount()) {
			sch.setEndBlock(sch.getPageCount());
		}
		sch.setStartBlock((blockNum-1)*sch.getBlockSize()+1);
		return dao.metlist(sch);
	}
	
	// 회의록 : 회의록 등록
	public String insertmet(Meeting_f ins) {
		String msg = "";
		//String path = "C:\\Users\\user\\git\\NPpms\\team03\\src\\main\\webapp\\WEB-INF\\z01_upload\\";
		if(dao.insertmet(ins)>0) {
			msg = "회의록 등록 완료\\n";
		}else {
			msg = "회의록 등록 실패\\n";
		}
		int ckf = 0;
		int pcode = ins.getPcode();
		MultipartFile[] mpfs = ins.getReports();
		if(mpfs!=null && mpfs.length>0) {
			try {
				for(MultipartFile mpf:mpfs) {
					if(mpf!=null) {
						String fname = mpf.getOriginalFilename();
						if(!fname.trim().equals("")) {
							String fno = ""+dao.getfno();
							mpf.transferTo(new File(path+fno));
							ckf+=dao.insertmetfile(new Metfile_f(fname,path,fno));
							dao.insertfilemet(new Metfile_f(fname,path,fno,pcode));
						}
					}
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
			msg+="파일 "+ckf+"건 등록 완료\\n";
		}
		return msg;
	}
	
	// 회의록 : 회의록 상세
	public Meeting_f detailmet(int metno) {
		return dao.detailmet(metno);
	}
	public List<Metfile_f> getmetfile(int metno) {
		return dao.getmetfile(metno);
	}
	
	// 회의록 : 회의록 수정
	public String updatemet(Meeting_f upt) {
		String msg = "";
		if(dao.updatemet(upt)>0) {
			msg = "회의록 수정 완료";
		}else {
			msg = "회의록 수정 실패";
		}
		return msg;
	}
	
	// 회의록 : 회의록 삭제
	public String deletemet(int metno) {
		List<String> delFnames = dao.getfnobynamem(metno);
		//String path = "C:\\Users\\user\\git\\NPpms\\team03\\src\\main\\webapp\\WEB-INF\\z01_upload\\";
		for(String fname:delFnames) {
			File fileToDelete = new File(path+fname);
			if(fileToDelete.exists()) fileToDelete.delete();
		}
		String msg = "";
		if(dao.deletemet(metno)>0) {
			msg = "회의록 삭제 완료\\n";
		}else {
			msg = "회의록 삭제 실패\\n";
		}
		if(dao.deletemetfile(metno)>0) {
			dao.deletefilemet(metno);
			msg += "파일 삭제 완료";
		}
		return msg;
	}
	
	
	// 문서관리 : 게시판 리스트 출력
	public List<File_f> boardfile(FileSch sch) {
		if(sch.getType()==null) sch.setType("fname");
		if(sch.getFname()==null) sch.setFname("");
		if(sch.getPage()==null) sch.setPage("");
		sch.setCount(dao.boardfilecnt(sch));
		if(sch.getPageSize()==0) sch.setPageSize(5);
		int totPage = (int)Math.ceil(sch.getCount()/(double)sch.getPageSize());
		sch.setPageCount(totPage);
		if(sch.getCurPage()>sch.getPageCount()) sch.setCurPage(sch.getPageCount());
		if(sch.getCurPage()==0) sch.setCurPage(1);
		sch.setEnd(sch.getCurPage()*sch.getPageSize());
		if(sch.getCurPage()*sch.getPageSize()>sch.getCount()) {
			sch.setEnd(sch.getCount());
		}
		sch.setStart((sch.getCurPage()-1)*sch.getPageSize()+1);
		sch.setBlockSize(3);
		int blockNum = (int)Math.ceil(sch.getCurPage()/(double)sch.getBlockSize());
		sch.setEndBlock(blockNum*sch.getBlockSize());
		if(sch.getEndBlock()>sch.getPageCount()) {
			sch.setEndBlock(sch.getPageCount());
		}
		sch.setStartBlock((blockNum-1)*sch.getBlockSize()+1);
		return dao.boardfile(sch);
	}
	
	// 문서관리 : 팀 파일 업로드
	public String insertfileteam(File_f ins) {
		//String path = "C:\\Users\\user\\git\\NPpms\\team03\\src\\main\\resources\\static\\z01_upload\\";
		String msg = "";
		int ckf = 0;
		MultipartFile[] mpfs = ins.getReports();
		int empno = ins.getEmpno();
		int pcode = ins.getPcode();
		if(mpfs!=null && mpfs.length>0) {
			try {
				for(MultipartFile mpf:mpfs) {
					if(mpf!=null) {
						String fname = mpf.getOriginalFilename();
						if(!fname.trim().equals("")) {
							String fno = ""+dao.getfno();
							mpf.transferTo(new File(path+fno));
							ckf+=dao.insertfileteam(fname, path, fno, empno, pcode);
						}
					}
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
			msg+="파일 "+ckf+"건 등록 완료\\n";
		}
		return msg;
	}

	// 문서관리 : 팀명 가져오기
	public String getpname(int pcode) {
		return dao.getpname(pcode);
	}
	
	// 문서관리 : 팀 리스트 출력
	public List<File_f> teamfile(FileSch sch) {
		if(sch.getType()==null) sch.setType("fname");
		if(sch.getFname()==null) sch.setFname("");
		if(sch.getPage()==null) sch.setPage("");
		sch.setCount2(dao.teamfilecnt(sch));
		if(sch.getPageSize2()==0) sch.setPageSize2(5);
		int totPage2 = (int)Math.ceil(sch.getCount2()/(double)sch.getPageSize2());
		sch.setPageCount2(totPage2);
		if(sch.getCurPage2()>sch.getPageCount2()) sch.setCurPage2(sch.getPageCount2());
		if(sch.getCurPage2()==0) sch.setCurPage2(1);
		sch.setEnd2(sch.getCurPage2()*sch.getPageSize2());
		if(sch.getCurPage2()*sch.getPageSize2()>sch.getCount2()) {
			sch.setEnd2(sch.getCount2());
		}
		sch.setStart2((sch.getCurPage2()-1)*sch.getPageSize2()+1);
		sch.setBlockSize2(3);
		int blockNum2 = (int)Math.ceil(sch.getCurPage2()/(double)sch.getBlockSize2());
		sch.setEndBlock2(blockNum2*sch.getBlockSize2());
		if(sch.getEndBlock2()>sch.getPageCount2()) {
			sch.setEndBlock2(sch.getPageCount2());
		}
		sch.setStartBlock2((blockNum2-1)*sch.getBlockSize2()+1);
		return dao.teamfile(sch);
	}
	
	// 문서관리 : 개인 파일 업로드
	public String insertfilemy(File_f ins) {
		//String path = "C:\\Users\\user\\git\\NPpms\\team03\\src\\main\\resources\\static\\z01_upload\\";
		String msg = "";
		int ckf = 0;
		MultipartFile[] mpfs = ins.getReports();
		int empno = ins.getEmpno();
		int pcode = ins.getPcode();
		if(mpfs!=null && mpfs.length>0) {
			try {
				for(MultipartFile mpf:mpfs) {
					if(mpf!=null) {
						String fname = mpf.getOriginalFilename();
						if(!fname.trim().equals("")) {
							String fno = ""+dao.getfno();
							mpf.transferTo(new File(path+fno));
							ckf+=dao.insertfilemy(fname, path, fno, empno);
						}
					}
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
			msg+="파일 "+ckf+"건 등록 완료\\n";
		}
		return msg;
	}
	
	// 문서관리 : 개인 리스트 출력
	public List<File_f> myfile(FileSch sch) {
		if(sch.getType()==null) sch.setType("fname");
		if(sch.getFname()==null) sch.setFname("");
		if(sch.getPage()==null) sch.setPage("");
		sch.setCount3(dao.myfilecnt(sch));
		if(sch.getPageSize3()==0) sch.setPageSize3(5);
		int totPage3 = (int)Math.ceil(sch.getCount3()/(double)sch.getPageSize3());
		sch.setPageCount3(totPage3);
		if(sch.getCurPage3()>sch.getPageCount3()) sch.setCurPage3(sch.getPageCount3());
		if(sch.getCurPage3()==0) sch.setCurPage3(1);
		sch.setEnd3(sch.getCurPage3()*sch.getPageSize3());
		if(sch.getCurPage3()*sch.getPageSize3()>sch.getCount3()) {
			sch.setEnd3(sch.getCount3());
		}
		sch.setStart3((sch.getCurPage3()-1)*sch.getPageSize3()+1);
		sch.setBlockSize3(3);
		int blockNum3 = (int)Math.ceil(sch.getCurPage3()/(double)sch.getBlockSize3());
		sch.setEndBlock3(blockNum3*sch.getBlockSize3());
		if(sch.getEndBlock3()>sch.getPageCount3()) {
			sch.setEndBlock3(sch.getPageCount3());
		}
		sch.setStartBlock3((blockNum3-1)*sch.getBlockSize3()+1);
		return dao.myfile(sch);
	}
	
	// 문서관리 : 파일 삭제
	public String deletefile(String fno) {
		String fname = dao.getfnamebyfno(fno);
		//String path = "C:\\Users\\user\\git\\NPpms\\team03\\src\\main\\resources\\static\\z01_upload\\";
		File fileToDelete = new File(path+fname);
		if(fileToDelete.exists()) fileToDelete.delete();
		String msg = "";
		if(dao.deletefile(fno)>0) {
			msg += fname+" 삭제 완료";
		}
		return msg;
	}
	
	
	// 채팅 : 사원명 리스트
	public List<Emp_pinfo_f> empList(){
		return dao.empList();
	}
	
	// 채팅 : 채팅방 생성
	public String makechatroom(Chatroom_f ins) {
		String msg = "";
		int cku = 0;
		String roomname = "";
		int chatters[] = ins.getChatter();
		for(int chatter:chatters) {
			roomname += dao.namebyempno(chatter)+", ";
		}
		roomname = roomname.substring(0, roomname.length() - 2);
		int crno = dao.crno();
		for(int chatter:chatters) {
			String username = dao.namebyempno(chatter);
			cku += dao.makechatroom(new Chatroom_f(crno, roomname, chatter, username));
		}
		msg = cku+"명 채팅방 생성 완료";
		return msg;
	}
	
	// 채팅 : 채팅방 리스트
	public List<Chatroom_f> chatroomlist(int empno) {
		return dao.chatroomlist(empno);
	}
	
	
	public String insChatRoom(Chatroom_f ins) {
		return dao.insChatRoom(ins)>0?"입장성공":"입장실패";
	}
	
	public String delChatRoom(Chatroom_f del) {
		return dao.delChatRoom(del)>0?"퇴장성공":"퇴장실패";
	}

	public List<String> getChRooms(){
		return dao.getChRooms();
	}
	public List<String> getChRoomIds(String username){
		return dao.getChRoomIds(username);
	}	
	public List<String> getIdsByRoom(String crname){
		return dao.getIdsByRoom(crname);
	}		
	
}
