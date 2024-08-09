package com.in2it.blogservice.mapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in2it.blogservice.dto.BlogDto;
import com.in2it.blogservice.model.Blog;



@Component
public class Converter {
	
	/*static way to create file path*/
//	public final String fileUploadDir="D:\\blog-project\\blog-service\\src\\main\\resources\\static\\image";
	
	/* dynamic way to create file path*/
    public final String fileUploadDir=new ClassPathResource("static/image/").getFile().getAbsolutePath();
	
	private static long randomId=0;
	
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

		blog.setTeamId(dto.getTeamId());
		blog.setDepartmentId(dto.getDepartmentId());

		blog.setLikeCount(dto.getLikeCount());
		blog.setCommentCount(dto.getCommentCount());
		blog.setDeletedBy(dto.getDeletedBy());
	    blog.setStatus("ACTIVE");
		
		
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
		dto.setTeamId(blog.getTeamId());
		dto.setDepartmentId(blog.getDepartmentId());

	
		dto.setLikeCount(blog.getLikeCount());
		dto.setCommentCount(blog.getCommentCount());
		
        
		dto.setDeletedBy(blog.getDeletedBy());
	    dto.setStatus(blog.getStatus());
        dto.setMediaFile(blog.getMediaFile()); 
        dto.setMediaPath(blog.getMediaPath());
        
        dto.setCretedDateTime(blog.getCretedDateTime());
	    dto.setUpdatedDateTime(blog.getUpdatedDateTime());
		return dto;
	}


	
	
	
	// uploading file in file System
	public List<String> uploadFile(List<MultipartFile> multipartFile) {

		String fullPath=null;
		
		List<String> paths=new ArrayList<>();
		String uniqueID = UUID.randomUUID().toString();
	
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
				
            	  randomId = generateUniqueId();
            	  
				fullPath=fileUploadDir+File.separator+randomId+multipartFile2.getOriginalFilename();
				
				paths.add(fullPath);
				
				// This code is inserted file in file system 
				Files.copy(multipartFile2.getInputStream(),Paths.get(fullPath), StandardCopyOption.REPLACE_EXISTING);
			}
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return paths;
		
	}
	
	
	// Generating URIlink in response
	public List<String> genrateUriLink(List<MultipartFile> multipartFile){
		
		List<String> fileLink = new ArrayList<>();
		
		for (MultipartFile multipart : multipartFile) {

			String uriString = ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/")
					.path(randomId+multipart.getOriginalFilename()).toUriString();
			       fileLink.add(uriString);
			       
		}
		return fileLink;
		
	}
	
	
	
	
	// Generating Random Id
	  public static int generateUniqueId() {      
	        UUID idOne = UUID.randomUUID();
	        String str=""+idOne;        
	        int uid=str.hashCode();
	        String filterStr=""+uid;
	        str=filterStr.replaceAll("-", "");
	        return Integer.parseInt(str);
	    }
	
	
	

	

}



