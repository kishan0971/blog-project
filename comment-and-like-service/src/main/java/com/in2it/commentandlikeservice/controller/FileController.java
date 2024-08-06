package com.in2it.commentandlikeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.in2it.commentandlikeservice.payload.FileResponse;
import com.in2it.commentandlikeservice.service.FileService;

@RestController
@RequestMapping("/file")
public class FileController {

	@Autowired
	private FileService fileService;

//	@Value("${project.media}")
//	private String path;

	@PostMapping("/upload")
	public ResponseEntity<FileResponse> fileUpload(@RequestPart("file") MultipartFile file) {

		String fileName = null;
		try {
//			System.out.println(path);
			fileName = fileService.uploadImage( file);
			System.out.println("++++++++++++++++");
			return new ResponseEntity<>(new FileResponse(fileName, "Image is Successfully Uploaded !!"), HttpStatus.OK);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(new FileResponse(null, "Image is not Uploaded due to error on server !!"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
