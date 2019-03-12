package com.example.cloud.fileupload;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	/**
	 * 测试方法
	 * 访问 http://localhost:8050/index.html
	 * 使用命令 curl -F "file=@文件全名" localhost:8050/upload
	 * @Author Chester_Zheng
	 * @Description 使用Zuul进行文件上传
	 * @Date 2019年2月22日下午3:29:48
	 * @param file
	 * @return
	 * @throws IOException
	 * @ReturnType String
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public String handleFileUpload(@RequestParam(value = "file", required = true) MultipartFile file)
			throws IOException {
		byte[] bytes = file.getBytes();
		File fileToSave = new File(file.getOriginalFilename());
		FileCopyUtils.copy(bytes, fileToSave);
		return fileToSave.getAbsolutePath();
	}
}
