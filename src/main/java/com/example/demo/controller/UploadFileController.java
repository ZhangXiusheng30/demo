package com.example.demo.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@RestController
@RequestMapping("/fileUpload")
public class UploadFileController {
	@Value("${spring.servlet.multipart.location}")
	private String realPath;
	
	@PostMapping("/upload")
	public String fileUpload(@RequestParam("uploadFile") MultipartFile file,HttpServletRequest request) {
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
		String fileDate = sdf.format(new Date());
		File folder = new File(realPath+"/"+fileDate);
		if(!folder.isDirectory()) {
			folder.mkdirs();
		}
		String oldName = file.getOriginalFilename();
		String newName = UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."), oldName.length());
		try {
			file.transferTo(new File(folder,newName));
			return newName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "上传失败！";
	}
	@PostMapping("/uploads")
	public String fileUploads(@RequestParam("uploadFiles") MultipartFile[] file,HttpServletRequest request) {
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
		String fileDate = sdf.format(new Date());
		File folder = new File(realPath+"/"+fileDate);
		if(!folder.isDirectory()) {
			folder.mkdirs();
		}
		for(int i=0;i<=file.length;i++) {			
			String oldName = file[i].getOriginalFilename();
			String newName = UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."), oldName.length());
			try {
				file[i].transferTo(new File(folder,newName));
				return newName;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "上传失败！";
	}
}
