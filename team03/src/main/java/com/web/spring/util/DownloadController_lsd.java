package com.web.spring.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.spring.service.lsd.A02_Service_lsd;

@Controller
public class DownloadController_lsd {
	@Autowired
	private A02_Service_lsd service;
	
	@RequestMapping("downloadNotice")
	public String download(@RequestParam("fno") String fno, Model d) {
		d.addAttribute("downloadFile", fno);
		d.addAttribute("realFile", service.getfnamebyfnoNF(fno));
		return "downloadViewer_lsd";
	}
}
