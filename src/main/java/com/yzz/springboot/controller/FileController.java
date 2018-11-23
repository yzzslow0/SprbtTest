package com.yzz.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author:Yangzhengzheng
 * @Date: Created in 14:08 2018/11/20
 * @Description:
 * @Modified By:
 */

@Slf4j
@RestController
public class FileController {
	@Value("${upload.folder}")
	private String physicalPath;

	/**
	 * 实现文件上传
	 */
	@PostMapping("uploadFile")
	@ResponseBody
	public Resources fileUpload(@RequestParam("myFile") MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				return saveFile(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}


	/**
	 * 实现多文件上传
	 */
	@PostMapping(value = "multifileUpload")
	public @ResponseBody
	String multifileUpload(HttpServletRequest request) {

		List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("fileName");

		if (files.isEmpty()) {
			return "false";
		}

		for (MultipartFile file : files) {
			String fileName = file.getOriginalFilename();
			int size = (int) file.getSize();
			System.out.println(fileName + "-->" + size);

			if (file.isEmpty()) {
				return "false";
			} else {
				File dest = new File(physicalPath + "/" + fileName);
				if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
					dest.getParentFile().mkdir();
				}
				try {
					file.transferTo(dest);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "false";
				}
			}
		}
		return "true";
	}

	/**
	 * 多文件上传
	 */
	@PostMapping("/uploadFiles")
	@ResponseBody
	public List<Resources> uploadFiles(HttpServletRequest request, HttpServletResponse response) {
//        if (physicalPath == null) {
//            physicalPath = request.getSession().getServletContext().getRealPath(File.separator);
//        }
		List<Resources> resources = new ArrayList<>();
		// 转型为MultipartHttpRequest
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		// 获得上传的文件（根据前台的name名称得到上传的文件）
		// MultipartFile file2 = multipartRequest.getFile("clientFile");

		MultiValueMap<String, MultipartFile> multiValueMap = multipartRequest.getMultiFileMap();
		//List<MultipartFile> file = multiValueMap.get("clientFiles");
		for (Map.Entry<String, List<MultipartFile>> entry : multiValueMap.entrySet()) {
			//String name = entry.getKey();
			List<MultipartFile> multipartFiles = entry.getValue();

			// 在这里就可以对file进行处理了，可以根据自己的需求把它存到数据库或者服务器的某个文件夹
			for (MultipartFile multipartFile : multipartFiles) {
				try {
					Resources r = saveFile(multipartFile);
					resources.add(r);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return resources;
	}

	@GetMapping("/{id}")
	public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
		try (InputStream inputStream = new FileInputStream(new File(physicalPath, id + ".jpg"));
		     OutputStream outputStream = response.getOutputStream()) {

			response.setContentType("application/x-download");
			response.addHeader("Content-Disposition", "attachment;filename=" + id + ".jpg");

			IOUtils.copy(inputStream, outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Resources saveFile(MultipartFile multipartFile) throws IOException {
		String id = getId();
		String ContentType = multipartFile.getContentType();
		String fileName = multipartFile.getOriginalFilename();
		String fileType = fileName.substring(fileName.lastIndexOf('.') + 1);
		log.debug("file：" + fileName + " size:" + multipartFile.getSize());
		File file = new File(physicalPath + File.separator + fileType);
		if (!file.isDirectory()) {
			file.mkdirs();
		}
		file = new File(file.getPath(), id + "." + fileType);
		multipartFile.transferTo(file);

		Resources resources = new Resources();
		resources.setId(id);
		resources.setName(fileName);
		resources.setType(ContentType);
		resources.setPath(file.getPath());
		resources.setStatus(1);
		//resources.setMd5(fileMD5);

		log.debug("服务器地址：" + resources.getPath());
		return resources;

	}

	private static String getId() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	private class Resources {
		private String id;

		private String name;

		private String path;

		private String type;

		private String md5;

		private Integer status;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getMd5() {
			return md5;
		}

		public void setMd5(String md5) {
			this.md5 = md5;
		}

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}
	}
}
