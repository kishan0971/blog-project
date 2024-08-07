package com.in2it.blogservice.mapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.in2it.blogservice.dto.BlogDto;
import com.in2it.blogservice.model.Blog;



@Component
public class Converter {
	
	/*static way to create file path*/
	public final String fileUploadDir="D:\\blog-project\\blog-service\\src\\main\\resources\\static\\image";
	
	/* dynamic way to create file path*/
    //public final String fileUploadDir=new ClassPathResource("static/image/").getFile().getAbsolutePath();
	
	
	public Converter() throws IOException {
		
	}
	
	// Here we changed DtoModel to Entity
	public Blog dtoToBlogConverter(BlogDto dto, List<String> fileName, List<String> uploadedPath)
	{
		Blog blog=new Blog();
		blog.setContent(dto.getContent());
		blog.setAuthorId(dto.getAuthorId());

		blog.setMediaFile(fileName);
		blog.setMediaPath(uploadedPath);
		
		blog.setTitle(dto.getTitle());
		blog.setVisiblity(dto.getVisiblity());

		
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
	
	
	// Here we changed Entity to DtoModel
	public BlogDto blogToDtoConverter(Blog blog)
	{
		BlogDto dto=new BlogDto();
		
		
		dto.setId(blog.getId()); 
		
		dto.setContent(blog.getContent());
		dto.setAuthorId(blog.getAuthorId());

		dto.setTitle(blog.getTitle());
		dto.setVisiblity(blog.getVisiblity());
		dto.setProjectId(blog.getProjectId());
		dto.setDepartmentId(blog.getDepartmentId());

	
		dto.setLikeCount(blog.getLikeCount());
		dto.setCommentCount(blog.getCommentCount());
		
        
		dto.setDeletedBy(blog.getDeletedBy());
	    dto.setStatus(blog.getStatus());
        dto.setMediaFile(blog.getMediaFile()); 
        dto.setMediaPath(blog.getMediaPath());
	    
		return dto;
	}


	
	// uploading file in file System
	public List<String> uploadFile(List<MultipartFile> multipartFile) {

		String fullPath=null;
		
		List<String> paths=new ArrayList<>();
		
		try {
			
			
			
			// read data from multipartFile
			/*
			fullPath=fileUploadDir+File.separator+multipartFile2.getOriginalFilename();
			InputStream stream=file.getInputStream();
			byte[] data=new byte[stream.available()];
			stream.read(data);
			
			// file write data 
			
			
			System.out.println("full path +++++"+ fullPath);
			FileOutputStream outputStream=new FileOutputStream(fullPath);
			outputStream.write(data);
			
			outputStream.flush();
			outputStream.close();
			
			*/
			
			// replaced code in one line 
			
              for (MultipartFile multipartFile2 : multipartFile) {
				
				fullPath=fileUploadDir+File.separator+multipartFile2.getOriginalFilename();
				
				paths.add(fullPath);
				
				// This code is inserted file in file system 
				Files.copy(multipartFile2.getInputStream(),Paths.get(fullPath), StandardCopyOption.REPLACE_EXISTING);
			}
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return paths;
		
	}
	
	
	

	

}



