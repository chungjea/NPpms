package com.web.spring.controller.cjw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.spring.service.cjw.A02_Service_cjw;
import com.web.spring.vo.ApproveSch;
import com.web.spring.vo.Approve_f;
import com.web.spring.vo.FileSch;
import com.web.spring.vo.File_f;
import com.web.spring.vo.MeetingSch_f;
import com.web.spring.vo.Meeting_f;
import com.web.spring.vo.RiskSch;
import com.web.spring.vo.Risk_f;

@Controller
public class A01_Controller_cjw {
	@Autowired
	private A02_Service_cjw service;
	// 결재
	// http://localhost:3333/myapv
	@PostMapping("myapv")
	public String myapv(@ModelAttribute("sch") ApproveSch sch, Model d) {
		//System.out.println(sch.getCurPage());
		//System.out.println(sch.getTitle());
		//System.out.println(sch.getSts());
		//System.out.println(sch.getWempno());
		//System.out.println(sch.getMempno());
		d.addAttribute("apvList", service.myapv(sch));
		d.addAttribute("myapvcnt", service.myapvcnt(sch));
		d.addAttribute("badapvcnt", service.badapvcnt(sch));
		d.addAttribute("goodapvcnt", service.goodapvcnt(sch));
		d.addAttribute("toapvcnt", service.toapvcnt(sch));
		return "cjw/z05_bootTmp/approval";
	}
	
	@PostMapping("ckapv")
	public String ckapv(@ModelAttribute("sch") ApproveSch sch, Model d) {
		d.addAttribute("apvList", service.ckapv(sch));
		d.addAttribute("myapvcnt", service.myapvcnt(sch));
		d.addAttribute("badapvcnt", service.badapvcnt(sch));
		d.addAttribute("goodapvcnt", service.goodapvcnt(sch));
		d.addAttribute("toapvcnt", service.toapvcnt(sch));
		return "cjw/z05_bootTmp/approval";
	}
	
	@GetMapping("insertapvFrm")
	public String insertapvFrm() {
		return "cjw/z05_bootTmp/apvinsert";
	}
	
	@PostMapping("insertapv")
	public String insertapv(Approve_f ins, Model d) {
		d.addAttribute("msg", service.insertapv(ins));
		return "cjw/z05_bootTmp/apvinsert";
	}
	
	@PostMapping("detailapv")
	public String detailapv(int apvno, Model d) {
		d.addAttribute("dapv", service.detailapv(apvno));
		d.addAttribute("dapvfile", service.getapvfile(apvno));
		return "cjw/z05_bootTmp/apvdetail";
	}
	
	@PostMapping("doapv")
	public String doapv(Approve_f apv, Model d) {
		d.addAttribute("msg", service.doapv(apv));
		return "pageJsonReport";
	}
	
	// 리스크 관리
	// http://localhost:3333/myrsk
	@PostMapping("myrsk")
	public String myrsk(@ModelAttribute("sch") RiskSch sch, Model d) {
		d.addAttribute("rskList", service.myrsk(sch));
		d.addAttribute("myrskcnt", service.myrskcnt(sch));
		d.addAttribute("ckrskcnt", service.ckrskcnt(sch));
		d.addAttribute("torskcnt", service.torskcnt(sch));
		d.addAttribute("finrskcnt", service.finrskcnt(sch));
		d.addAttribute("sts","1");
		return "cjw/z05_bootTmp/risk";
	}
	
	@PostMapping("ckrsk")
	public String ckrsk(@ModelAttribute("sch") RiskSch sch, Model d) {
		d.addAttribute("rskList", service.ckrsk(sch));
		d.addAttribute("myrskcnt", service.myrskcnt(sch));
		d.addAttribute("ckrskcnt", service.ckrskcnt(sch));
		d.addAttribute("torskcnt", service.torskcnt(sch));
		d.addAttribute("finrskcnt", service.finrskcnt(sch));
		d.addAttribute("sts","2");
		return "cjw/z05_bootTmp/risk";
	}
	
	@PostMapping("torsk")
	public String torsk(@ModelAttribute("sch") RiskSch sch, Model d) {
		d.addAttribute("rskList", service.torsk(sch));
		d.addAttribute("myrskcnt", service.myrskcnt(sch));
		d.addAttribute("ckrskcnt", service.ckrskcnt(sch));
		d.addAttribute("torskcnt", service.torskcnt(sch));
		d.addAttribute("finrskcnt", service.finrskcnt(sch));
		d.addAttribute("sts","3");
		return "cjw/z05_bootTmp/risk";
	}
	
	@PostMapping("finrsk")
	public String finrsk(@ModelAttribute("sch") RiskSch sch, Model d) {
		d.addAttribute("rskList", service.finrsk(sch));
		d.addAttribute("myrskcnt", service.myrskcnt(sch));
		d.addAttribute("ckrskcnt", service.ckrskcnt(sch));
		d.addAttribute("torskcnt", service.torskcnt(sch));
		d.addAttribute("finrskcnt", service.finrskcnt(sch));
		d.addAttribute("sts","4");
		return "cjw/z05_bootTmp/risk";
	}
	
	@GetMapping("insertrskFrm")
	public String insertrskFrm() {
		return "cjw/z05_bootTmp/rskinsert";
	}
	
	@PostMapping("insertrsk")
	public String insertrsk(Risk_f ins, Model d) {
		d.addAttribute("msg", service.insertrsk(ins));
		return "cjw/z05_bootTmp/rskinsert";
	}
	
	@PostMapping("detailrsk")
	public String detailrsk(int rskno, Model d) {
		d.addAttribute("drsk", service.detailrsk(rskno));
		d.addAttribute("drskfile", service.getrskfile(rskno));
		return "cjw/z05_bootTmp/rskdetail";
	}
	
	@PostMapping("dorsk")
	public String dorsk(Risk_f rsk, Model d) {
		d.addAttribute("msg", service.dorsk(rsk));
		return "pageJsonReport";
	}
	
	@PostMapping("donersk")
	public String donersk(int rskno, Model d) {
		d.addAttribute("msg", service.donersk(rskno));
		return "pageJsonReport";
	}
	
	// 회의록
	// http://localhost:3333/meeting?deptno=10
	@GetMapping("meeting")
	public String meeting(@ModelAttribute("sch") MeetingSch_f sch, Model d) {
		d.addAttribute("metList", service.metlist(sch));
		return "cjw/z05_bootTmp/meeting";
	}
	
	@GetMapping("insertmetFrm")
	public String insertmetFrm(Model d) {
		d.addAttribute("type", "reg");
		return "cjw/z05_bootTmp/metinsert";
	}

	@PostMapping("insertmet")
	public String insertmet(Meeting_f ins, Model d) {
		d.addAttribute("msg", service.insertmet(ins));
		return "cjw/z05_bootTmp/metinsert";
	}
	
	@PostMapping("detailmet")
	public String detailmet(int metno, Model d) {
		d.addAttribute("dmet", service.detailmet(metno));
		d.addAttribute("dmetfile", service.getmetfile(metno));
		return "cjw/z05_bootTmp/metdetail";
	}
	
	@PostMapping("updatemetFrm")
	public String updatemetFrm(int metno, Model d) {
		d.addAttribute("type", "upt");
		d.addAttribute("umet", service.detailmet(metno));
		return "cjw/z05_bootTmp/metinsert";
	}
	
	@PostMapping("updatemet")
	public String updatemet(Meeting_f upt, int metno, Model d) {
		d.addAttribute("msg2", service.updatemet(upt));
		d.addAttribute("type", "upt");
		d.addAttribute("umet", service.detailmet(metno));
		d.addAttribute("umetfile", service.getmetfile(metno));
		return "cjw/z05_bootTmp/metinsert";
	}
	
	@PostMapping("deletemet")
	public String deletemet(int metno, Model d) {
		d.addAttribute("msg", service.deletemet(metno));
		return "cjw/z05_bootTmp/metdetail";
	}
	
	// 문서관리
	// http://localhost:3333/file?empno=1000&deptno=10
	@GetMapping("file")
	public String file(@ModelAttribute("sch") FileSch sch, Model d) {
		d.addAttribute("bfile", service.boardfile(sch));
		return "cjw/z05_bootTmp/file";
	}
	
	@GetMapping("upload")
	public String upload(File_f ins, Model d) {
		d.addAttribute("msg", service.insertfilemy(ins));
		return "cjw/z05_bootTmp/file";
	}
}
