package com.web.spring.util;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DownloadController_lsd {
	
	@RequestMapping("downloadNotice")
	public String download(@RequestParam("fname") String fname, Model d) {
		d.addAttribute("downloadNotice", fname);
		return "downloadViewer_lsd";
	}
}