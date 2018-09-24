package com.yc.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	public static void uploadFile(byte[] file, String filePath, String fileName)
			throws Exception {
		File targetFile = new File(filePath);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		FileOutputStream out = new FileOutputStream(filePath + fileName);
		out.write(file);
		out.flush();
		out.close();
	}
	
	public static void upload( String filePath, String fileName,MultipartFile file) throws IllegalStateException, IOException{
		File dir=new File(filePath+fileName);
		File dest=new File(dir,file.getOriginalFilename());
		file.transferTo(dest);
	}
	

}
