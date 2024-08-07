package com.in2it.blogservice.mapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;

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

//		List<String> mediaNames=new ArrayList<>();
//		for(MultipartFile file:dto.getMedia())
//		{
//			mediaNames.add(file.getName());
//		}
//		
//		blog.setMedia(mediaNames);
		blog.setMedia(img.getOriginalFilename());
		blog.setTitle(dto.getTitle());
		blog.setVisiblity(dto.getVisiblity());
//		blog.setMediaPath(dto.getMediaPath());
//		blogDto.setCretedDateTime(LocalDateTime.now());
//		blogDto.setMediaPath(path1);
		blog.setMediaPath(mediaPath);
		
		//set to current date&time
		blog.setCretedDateTime(LocalDateTime.now());
//		blog.setCretedDateTime(dto.getCretedDateTime());
		
//		blog.setProjectId(author.getProjectId());
//		blog.setDepartmentId(author.getDepartmentId());
		blog.setProjectId(dto.getProjectId());
		blog.setDepartmentId(dto.getDepartmentId());
		//set to initial value 
//		blog.setLikeCount(0);
//		blog.setCommentCount(0);
		
		blog.setLikeCount(0);
		blog.setCommentCount(0);


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

		dto.setImg(getImage(blog.getMediaPath()));
		//set to current date&time
//		dto.setCretedDateTime(blog.getCretedDateTime());
		

		//set to initial value 
		dto.setLikeCount(blog.getLikeCount());
		dto.setCommentCount(blog.getCommentCount());
		
        
		dto.setDeletedBy(blog.getDeletedBy());
	    dto.setStatus(blog.getStatus());
        dto.setMediaFile(blog.getMediaFile()); 
        dto.setMediaPath(blog.getMediaPath());
	    
		return dto;
	}

	public byte[] getImage(String path)
	{
		byte[] img=null;
		try {
			img = Files.readAllBytes(new File(path).toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}



	
	// uploading file in file System
	public String uploadFile(MultipartFile file) {

		String fullPath=null;
		try {
			fullPath=fileUploadDir+File.separator+file.getOriginalFilename();
			
			// read data from multipartFile
			/*
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
			Files.copy(file.getInputStream(),Paths.get(fullPath), StandardCopyOption.REPLACE_EXISTING);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return fullPath;
		
	}
	
	
	}
	}
