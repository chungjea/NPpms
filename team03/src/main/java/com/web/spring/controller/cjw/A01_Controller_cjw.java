package com.web.spring.controller.cjw;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.spring.service.cjw.A02_Service_cjw;
import com.web.spring.vo.ApproveSch;
import com.web.spring.vo.Approve_f;
import com.web.spring.vo.Chatroom_f;
import com.web.spring.vo.Emp_pinfo_f;
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
		d.addAttribute("apvList", service.myapv(sch));
		d.addAttribute("myapvcnt", service.myapvcnt(sch));
		d.addAttribute("badapvcnt", service.badapvcnt(sch));
		d.addAttribute("goodapvcnt", service.goodapvcnt(sch));
		d.addAttribute("toapvcnt", service.toapvcnt(sch));
		return "cjw/z05_bootTmp/approval";
	}
	
	@PostMapping("badapv")
	public String badapv(@ModelAttribute("sch") ApproveSch sch, Model d) {
		d.addAttribute("apvList", service.badapv(sch));
		d.addAttribute("myapvcnt", service.myapvcnt(sch));
		d.addAttribute("badapvcnt", service.badapvcnt(sch));
		d.addAttribute("goodapvcnt", service.goodapvcnt(sch));
		d.addAttribute("toapvcnt", service.toapvcnt(sch));
		return "cjw/z05_bootTmp/approval";
	}
	
	@PostMapping("goodapv")
	public String goodapv(@ModelAttribute("sch") ApproveSch sch, Model d) {
		d.addAttribute("apvList", service.goodapv(sch));
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
	
	@PostMapping("insertapvFrm")
	public String insertapvFrm(@Param("empno") int empno, @Param("pcode") int pcode, Model d) {
		d.addAttribute("dmlist", service.getteammen(empno, pcode));
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
	
	@PostMapping("insertrskFrm")
	public String insertrskFrm(int pcode, Model d) {
		System.out.println(pcode);
		d.addAttribute("mempno", service.getmymanager(pcode));
		return "cjw/z05_bootTmp/rskinsert";
	}
	
	@PostMapping("insertrsk")
	public String insertrsk(Risk_f ins, Model d) {
		d.addAttribute("msg", service.insertrsk(ins));
		return "cjw/z05_bootTmp/rskinsert";
	}
	
	@PostMapping("detailrsk")
	public String detailrsk(@Param("rskno")int rskno, @Param("empno") int empno, @Param("team")int pcode, Model d) {
		d.addAttribute("drsk", service.detailrsk(rskno));
		d.addAttribute("drskfile", service.getrskfile(rskno));
		d.addAttribute("dmlist", service.getteammen(empno, pcode));
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
	// http://localhost:3333/meeting
	@PostMapping("meeting")
	public String meeting(@ModelAttribute("sch") MeetingSch_f sch, Model d) {
		d.addAttribute("metList", service.metlist(sch));
		return "cjw/z05_bootTmp/meeting";
	}
	
	@PostMapping("insertmetFrm")
	public String insertmetFrm(int pcode, Model d) {
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
	public String updatemetFrm(@Param("metno") int metno, @Param("pcode") int pcode, Model d) {
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
	@PostMapping("file")
	public String file(@ModelAttribute("sch") FileSch sch, Model d) {
		d.addAttribute("bfile", service.boardfile(sch));
		d.addAttribute("tfile",service.teamfile(sch));
		d.addAttribute("mfile", service.myfile(sch));
		d.addAttribute("pname",service.getpname(sch.getPcode()));
		return "cjw/z05_bootTmp/file";
	}
	
	@PostMapping("uploadteam")
	public String uploadteam(File_f ins, Model d) {
		d.addAttribute("msg", service.insertfileteam(ins));
		return "cjw/z05_bootTmp/file";
	}
	
	@PostMapping("upload")
	public String upload(File_f ins, Model d) {
		d.addAttribute("msg", service.insertfilemy(ins));
		return "cjw/z05_bootTmp/file";
	}
	
	@GetMapping("deletefile")
	public String deletefile(String fno, Model d) {
		d.addAttribute("msg", service.deletefile(fno));
		return "cjw/z05_bootTmp/file";
	}
	
	// 채팅
	// http://localhost:3333/chatting?empno=202301018
	@Value("${socketServer}")
	private String socketServer;	
	@GetMapping("chatting")
	public String chatting(int empno, Model d) {
		d.addAttribute("crlist", service.chatroomlist(empno));
		d.addAttribute("socketServer", socketServer);
		return "cjw/z05_bootTmp/chatting";
	}
	
	@ModelAttribute("elist")
	public List<Emp_pinfo_f> empList(){
		return service.empList();
	}
	
	@PostMapping("makechatroom")
	public String makechatroom(Chatroom_f ins, Model d) {
		d.addAttribute("msg", service.makechatroom(ins));
		return "pageJsonReport";
	}
	

	// enterChRoom
	@PostMapping("enterChRoom")
	public String enterChRoom(Chatroom_f croom, Model d) {
		d.addAttribute("result", service.insChatRoom(croom));
		d.addAttribute("conIds", service.getChRoomIds(croom.getUsername()));
		d.addAttribute("conRooms", service.getChRooms());
		
		return "pageJsonReport";
	}
	@GetMapping("conRooms")
	public String conRooms(Model d) {
		d.addAttribute("conRooms", service.getChRooms());
		
		return "pageJsonReport";
	}	
	@GetMapping("conIds")
	public String conIds(@RequestParam("crno") String crname, Model d) {
		d.addAttribute("conIds", service.getIdsByRoom(crname));
		
		return "pageJsonReport";
	}		
	@PostMapping("exitChRoom")	
	public String delChatRoom(Chatroom_f croom, Model d) {
		d.addAttribute("result", service.delChatRoom(croom));
		return "pageJsonReport";
	}
	
}
