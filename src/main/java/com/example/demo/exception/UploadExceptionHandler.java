package com.example.demo.exception;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
public class UploadExceptionHandler {
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public void fileUploadException(MaxUploadSizeExceededException e,HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8"); 
		PrintWriter pw = response.getWriter();
		pw.write("文件大小超过最大限制！");
		pw.flush();
		pw.close();
	}
}
