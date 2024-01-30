package com.web.spring.service.cjw;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.web.spring.dao.cjw.A03_Dao_cjw;
import com.web.spring.vo.Approve_f;
import com.web.spring.vo.Apvfile_f;
import com.web.spring.vo.MeetingSch_f;
import com.web.spring.vo.Meeting_f;
import com.web.spring.vo.Metfile_f;
import com.web.spring.vo.Risk_f;
import com.web.spring.vo.Rskfile_f;

@Service
public class A02_Service_cjw {
	@Autowired(required = false)
	private A03_Dao_cjw dao;
	
	// 결재 : 상신한 대기/반려/완료 문서 리스트
	public List<Approve_f> myapv(Approve_f sch){
		return dao.myapv(sch);
	}
	// 결재 : 결재처리를 해야하는 문서 리스트
	public List<Approve_f> ckapv(Approve_f sch){
		return dao.ckapv(sch);
	}
	// 결재 : 상신한 대기 문서의 수
	public int myapvcnt(Approve_f sch) {
		return dao.myapvcnt(sch);
	}
	// 결재 : 상신한 반려 문서의 수
	public int badapvcnt(Approve_f sch) {
		return dao.badapvcnt(sch);
	}
	// 결재 : 상신한 완료 문서의 수
	public int goodapvcnt(Approve_f sch) {
		return dao.goodapvcnt(sch);
	}
	// 결재 : 결재처리를 해야하는 문서의 수
	public int toapvcnt(Approve_f sch) {
		return dao.toapvcnt(sch);
	}

	// 결재 : 결재 상신
	public String insertapv(Approve_f ins) {
		String msg = "";
		String path = "C:\\b01_javaexp\\workspace\\team03\\src\\main\\webapp\\WEB-INF\\z01_upload\\";
		if(dao.insertapv(ins)>0 && dao.insertapv2(ins)>0) {
			msg = "결재 상신 완료\\n";
		}else {
			msg = "결재 상신 실패\\n";
		}
		int ckf = 0;
		MultipartFile[] mpfs = ins.getReports();
		if(mpfs!=null && mpfs.length>0) {
			try {
				for(MultipartFile mpf:mpfs) {
					if(mpf!=null) {
						String fname = mpf.getOriginalFilename();
						if(!fname.trim().equals("")) {
							mpf.transferTo(new File(path+fname));
							ckf+=dao.insertapvfile(new Apvfile_f(fname,path));
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
	
	// 결재 : 결재 상세
	public Approve_f detailapv(int apvno) {
		Approve_f apv = dao.detailapv(apvno);
		apv.setFnames(dao.getapvfile(apvno));
		return apv;
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
	public List<Risk_f> myrsk(Risk_f sch){
		return dao.myrsk(sch);
	}
	// 리스크 : 담당자를 지정해야 하는 리스크 리스트
	public List<Risk_f> ckrsk(Risk_f sch){
		return dao.ckrsk(sch);
	}
	// 리스크 : 처리할 리스크 리스트
	public List<Risk_f> torsk(Risk_f sch){
		return dao.torsk(sch);
	}
	// 리스크 : 완료된 (등록/처리했던)리스크 리스트
	public List<Risk_f> finrsk(Risk_f sch){
		return dao.finrsk(sch);
	}
	
	// 리스크 : 리스크 등록
	public String insertrsk(Risk_f ins) {
		String msg = "";
		String path = "C:\\b01_javaexp\\workspace\\team03\\src\\main\\webapp\\WEB-INF\\z01_upload\\";
		if(dao.insertrsk(ins)>0 && dao.insertrsk2(ins)>0) {
			msg = "리스크 등록 완료\\n";
		}else {
			msg = "리스크 등록 실패\\n";
		}
		int ckf = 0;
		MultipartFile[] mpfs = ins.getReports();
		if(mpfs!=null && mpfs.length>0) {
			try {
				for(MultipartFile mpf:mpfs) {
					if(mpf!=null) {
						String fname = mpf.getOriginalFilename();
						if(!fname.trim().equals("")) {
							mpf.transferTo(new File(path+fname));
							ckf+=dao.insertrskfile(new Rskfile_f(fname,path));
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
	
	// 리스크 : 리스크 상세
	public Risk_f detailrsk(int rskno) {
		Risk_f rsk = dao.detailrsk(rskno);
		if(rsk.getCharge().equals(" / ")) rsk.setCharge("");
		rsk.setFnames(dao.getrskfile(rskno));
		return rsk;
	}
	
	// 리스크 : 담당자 지정
	public String dorsk(Risk_f rsk) {
		String msg = "";
		if(dao.dorsk(rsk)>0 && dao.dorsk2(rsk)>0) {
			msg = "담당자 등록 완료\n";
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
		String path = "C:\\b01_javaexp\\workspace\\team03\\src\\main\\webapp\\WEB-INF\\z01_upload\\";
		if(dao.insertmet(ins)>0) {
			msg = "회의록 등록 완료\\n";
		}else {
			msg = "회의록 등록 실패\\n";
		}
		int ckf = 0;
		MultipartFile[] mpfs = ins.getReports();
		if(mpfs!=null && mpfs.length>0) {
			try {
				for(MultipartFile mpf:mpfs) {
					if(mpf!=null) {
						String fname = mpf.getOriginalFilename();
						if(!fname.trim().equals("")) {
							mpf.transferTo(new File(path+fname));
							ckf+=dao.insertmetfile(new Metfile_f(fname,path));
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
		Meeting_f met = dao.detailmet(metno);
		met.setFnames(dao.getmetfile(metno));
		return met;
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
		List<String> delFnames = dao.getmetfile(metno);
		String path = "C:\\b01_javaexp\\workspace\\team03\\src\\main\\webapp\\WEB-INF\\z01_upload\\";
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
			msg += "파일 삭제 완료";
		}
		return msg;
	}
}
