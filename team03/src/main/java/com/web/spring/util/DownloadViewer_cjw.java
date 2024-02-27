package com.web.spring.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 컨테이너에 자동등록
@Component("downloadViewer_cjw")
public class DownloadViewer_cjw extends AbstractView {
	// 다운로드할 경로 설정(공통)
	@Value("${file.upload}")
	private String path;
	//String path = "C:\\Users\\user\\git\\NPpms\\team03\\src\\main\\resources\\static\\z01_upload\\";
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		String fileName = (String)model.get("downloadFile");
		String realfile = (String)model.get("realFile");
		File file = new File(path+fileName);
		res.setContentType("application/download;charset=utf-8");
		res.setContentLengthLong(file.length());
		realfile = URLEncoder.encode(realfile, "utf-8").replaceAll("\\+", " ");
		res.setHeader("Content-Disposition", "attachment;filename=\""+realfile+"\"");
		res.setHeader("Content-Transfer-Encoding", "binary");
		FileInputStream fis = new FileInputStream(file);
		OutputStream out = res.getOutputStream();
		FileCopyUtils.copy(fis, out);
		out.flush();
		out.close();
		fis.close();
		
	}

}
