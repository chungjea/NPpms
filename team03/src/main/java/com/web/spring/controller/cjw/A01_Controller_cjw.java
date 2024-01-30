package com.web.spring.controller.cjw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.spring.service.cjw.A02_Service_cjw;
import com.web.spring.vo.Approve_f;
import com.web.spring.vo.MeetingSch_f;
import com.web.spring.vo.Meeting_f;
import com.web.spring.vo.Risk_f;

@Controller
public class A01_Controller_cjw {
	@Autowired
	private A02_Service_cjw service;
	// 결재
	// http://localhost:7080/team03/myapv.do3?wempno=1000&mempno=1000
	@GetMapping("myapv")
	public String myapv(Approve_f sch, Model d) {
		if(sch.getSts()==null) sch.setSts("대기");
		d.addAttribute("apvList", service.myapv(sch));
		d.addAttribute("myapvcnt", service.myapvcnt(sch));
		d.addAttribute("badapvcnt", service.badapvcnt(sch));
		d.addAttribute("goodapvcnt", service.goodapvcnt(sch));
		d.addAttribute("toapvcnt", service.toapvcnt(sch));
		return "cjw/z05_bootTmp/approval";
	}
	
	@GetMapping("ckapv")
	public String ckapv(Approve_f sch, Model d) {
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
		return "cjw/z05_bootTmp/apvdetail";
	}
	
	@RequestMapping("download")
	public String download(@RequestParam("fname") String fname, Model d) {
		d.addAttribute("downloadFile", fname);
		return "cjw/z05_bootTmp/downloadViewer_cjw";
	}
	
	@PostMapping("doapv")
	public String doapv(Approve_f apv, Model d) {
		d.addAttribute("msg", service.doapv(apv));
		return "pageJsonReport";
	}
	
	// 리스크 관리
	// http://localhost:7080/team03/myrsk.do3?wempno=1000&cempno=1000&manager=1000
	@GetMapping("myrsk")
	public String myrsk(Risk_f sch, Model d) {
		d.addAttribute("rskList", service.myrsk(sch));
		d.addAttribute("myrskcnt", service.myrsk(sch).size());
		d.addAttribute("ckrskcnt", service.ckrsk(sch).size());
		d.addAttribute("torskcnt", service.torsk(sch).size());
		d.addAttribute("finrskcnt", service.finrsk(sch).size());
		return "cjw/z05_bootTmp/risk";
	}
	
	@PostMapping("ckrsk")
	public String ckrsk(Risk_f sch, Model d) {
		d.addAttribute("rskList", service.ckrsk(sch));
		d.addAttribute("myrskcnt", service.myrsk(sch).size());
		d.addAttribute("ckrskcnt", service.ckrsk(sch).size());
		d.addAttribute("torskcnt", service.torsk(sch).size());
		d.addAttribute("finrskcnt", service.finrsk(sch).size());
		return "cjw/z05_bootTmp/risk";
	}
	
	@PostMapping("torsk")
	public String torsk(Risk_f sch, Model d) {
		d.addAttribute("rskList", service.torsk(sch));
		d.addAttribute("myrskcnt", service.myrsk(sch).size());
		d.addAttribute("ckrskcnt", service.ckrsk(sch).size());
		d.addAttribute("torskcnt", service.torsk(sch).size());
		d.addAttribute("finrskcnt", service.finrsk(sch).size());
		return "cjw/z05_bootTmp/risk";
	}
	
	@PostMapping("finrsk")
	public String finrsk(Risk_f sch, Model d) {
		d.addAttribute("rskList", service.finrsk(sch));
		d.addAttribute("myrskcnt", service.myrsk(sch).size());
		d.addAttribute("ckrskcnt", service.ckrsk(sch).size());
		d.addAttribute("torskcnt", service.torsk(sch).size());
		d.addAttribute("finrskcnt", service.finrsk(sch).size());
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
	// http://localhost:7080/team03/meeting.do3?deptno=10
	@GetMapping("meeting")
	public String meeting(@ModelAttribute("sch")MeetingSch_f sch, Model d) {
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
		return "cjw/z05_bootTmp/metinsert";
	}
	
	@PostMapping("deletemet")
	public String deletemet(int metno, Model d) {
		d.addAttribute("msg", service.deletemet(metno));
		return "cjw/z05_bootTmp/metdetail";
	}
}
