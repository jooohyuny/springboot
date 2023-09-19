package com.yun.aug04f.file;


import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class FileDAO {
	@Value("${file.dir}")
	private String fileDir;
	
	public Resource getPhoto(String name) {
		
	}
	
	public void upload(
			MultipartFile mf, YunFile yf, HttpServletRequest req) {
		try {
			String fileName = mf.getOriginalFilename(); // ㅋ ㅋ.png
			String type = fileName.substring(fileName.lastIndexOf(".")); // png
			fileName = fileName.replace(type, "");
			System.out.println(fileName);
			System.out.println(type);
			
			// UUID : 네트워크같은데서 중복안되는 id값 필요할때 쓰는
			String uuid = UUID.randomUUID().toString(); // 
			
			fileName = fileName + uuid + type;
			System.out.println(fileName);
			// 파일명 중복되면 그냥 덮어쓰기
			// 안덮어쓰려면 파일명을 다르게 해야
			// 그 대책은 없음
			
			File f = new File(fileDir + "/" + fileName);
			mf.transferTo(f); // 실제 업로드
			System.out.println(fileName);
			
			req.setAttribute("yf", yf);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
