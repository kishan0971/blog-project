package com.in2it.blogservice.mapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.in2it.blogservice.dto.BlogDto;
import com.in2it.blogservice.model.Blog;



@Component
public class Converter {
	
	/*static way to create file path*/
//	public final String fileUploadDir="D:\\blog-project\\blog-service\\src\\main\\resources\\static\\image";
	
	/* dynamic way to create file path*/
	public final String fileUploadDir=new ClassPathResource("static/image/").getFile().getAbsolutePath();
	
	
	public Converter() throws IOException {
		
	}
	
	public Blog dtoToBlogConverter(BlogDto dto,String fileName,String uploadedPath)
	{
		Blog blog=new Blog();
		blog.setContent(dto.getContent());
		blog.setAuthorId(dto.getAuthorId());

		blog.setMediaFile(fileName);
		
		blog.setTitle(dto.getTitle());
		blog.setVisiblity(dto.getVisiblity());

		blog.setMediaPath(uploadedPath);
		
		//set to current date&time
		blog.setCretedDateTime(LocalDateTime.now());

		blog.setProjectId(dto.getProjectId());
		blog.setDepartmentId(dto.getDepartmentId());

		blog.setLikeCount(dto.getLikeCount());
		blog.setCommentCount(dto.getCommentCount());
		blog.setDeletedBy(dto.getDeletedBy());
	    blog.setStatus("Active");
		
		
		return blog;
	}
	
	public BlogDto blogToDtoConverter(Blog blog)
	{
		BlogDto dto=new BlogDto();
		
		
		dto.setId(blog.getId()); 
		dto.setContent(blog.getContent());
		dto.setAuthorId(blog.getAuthorId());
//		dto.setMedia (blog.getMedia());
		dto.setTitle(blog.getTitle());
		dto.setVisiblity(blog.getVisiblity());
		dto.setProjectId(blog.getProjectId());
		dto.setDepartmentId(blog.getDepartmentId());

		//set to initial value 
		dto.setLikeCount(blog.getLikeCount());
		dto.setCommentCount(blog.getCommentCount());
		
        
		dto.setDeletedBy(blog.getDeletedBy());
	    dto.setStatus(blog.getStatus());
        dto.setMediaFile(blog.getMediaFile()); 
        dto.setMediaPath(blog.getMediaPath());
	    
		return dto;
	}


	
	// uploading file in file System
	public String uploadFile(MultipartFile file) {

		String fullPath=null;
		try {
			fullPath=fileUploadDir+File.separator+file.getOriginalFilename();
			
			// read data from multi part
//			InputStream stream=file.getInputStream();
//			byte[] data=new byte[stream.available()];
//			stream.read(data);
//			
//			// file write data 
//			
//			
//			System.out.println("full path +++++"+ fullPath);
//			FileOutputStream outputStream=new FileOutputStream(fullPath);
//			outputStream.write(data);
//			
//			outputStream.flush();
//			outputStream.close();
			
			
			
			// replaced code in one line 
			Files.copy(file.getInputStream(),Paths.get(fullPath), StandardCopyOption.REPLACE_EXISTING);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return fullPath;
		
	}
	
	
	

	

}



