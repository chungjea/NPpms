package com.web.spring.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 컨테이너에 자동등록
@Component("downloadViewer_cjw")
public class DownloadViewer_cjw extends AbstractView {
	// 다운로드할 경로 설정(공통)
	String path = "C:\\Users\\user\\git\\NPpms\\team03\\src\\main\\webapp\\WEB-INF\\z01_upload\\";
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		// 1. 파일명 가져오기(controller단에서 모델명으로 전달)
		String fileName = (String)model.get("downloadFile");
		String realfile = (String)model.get("realFile");
		// 2. File객체 만들기(경로와 파일명)
		File file = new File(path+fileName);
		// 3. client에 이 파일을 전달해줄 response객체 속성 전달
		// 		1) 파일전송용 contentType설정
		res.setContentType("application/download;charset=utf-8");
		// 		2) 파일 길이 설정
		res.setContentLengthLong(file.length());
		//		3) 파일명이 한글일 때를 대비해서 한글 encoding 처리
		//		   공백부분이 +로 나와서 이것을 " "으로 다시 변경 처리
		realfile = URLEncoder.encode(realfile, "utf-8").replaceAll("\\+", " ");
		//		4) 파일전송을 위한 response객체의 Header 속성 설정
		//		   파일명지정(Content-Disposition),
		res.setHeader("Content-Disposition", "attachment;filename=\""+realfile+"\"");
		//		   attachment;filename="aaa.txt" 로 처리하기 위해 설정
		//		   binary데이터 처리(Content-Transfer-Encoding)
		res.setHeader("Content-Transfer-Encoding", "binary");
		//		5) 파일을 Stream으로 보내기 위해 FileInputStream에 탑재
		//			File ==> FileInputStream ==> response의 OutputStream으로 전달
		//			최종적으로 브라우저에 전달
		FileInputStream fis = new FileInputStream(file);
		OutputStream out = res.getOutputStream();
		//		6) FileInputStream(파일지정)을 OutputStream(전송)으로 복사
		FileCopyUtils.copy(fis, out);
		//		7) response의 buffer를 flush해서 전송완료
		out.flush();
		//		8) outputstream 자원해제/fileinputstream 자원해제
		out.close();
		fis.close();
		
	}

}
