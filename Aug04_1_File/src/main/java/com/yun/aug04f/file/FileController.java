package com.yun.aug04f.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class FileController {

	@Autowired
	private FileDAO fDAO;
	
	@RequestMapping("/file.upload")
	public String fileUpload(
			@RequestParam("photooo") MultipartFile mf,
			YunFile yf, 
			HttpServletRequest req) {
		fDAO.upload(mf, yf, req);
		return "output";
	}
}
