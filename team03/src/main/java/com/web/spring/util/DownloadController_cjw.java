package com.web.spring.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.spring.service.cjw.A02_Service_cjw;

@Controller
public class DownloadController_cjw {
	@Autowired
	private A02_Service_cjw service;
	
	@RequestMapping("download")
	public String download(@RequestParam("fno") String fno, Model d) {
		d.addAttribute("downloadFile", fno);
		d.addAttribute("realFile", service.getfnamebyfno(fno));
		return "downloadViewer_cjw";
	}
}
