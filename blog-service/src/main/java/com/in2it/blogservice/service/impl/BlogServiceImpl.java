package com.in2it.blogservice.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.in2it.blogservice.dto.BlogDto;
import com.in2it.blogservice.mapper.Converter;
import com.in2it.blogservice.model.Blog;
import com.in2it.blogservice.repository.BlogRepository;
import com.in2it.blogservice.service.BlogService;

public class BlogServiceImpl implements BlogService {

	@Autowired
	private Converter objectMapper;
	
	@Autowired
	private BlogRepository repo;
//	@Autowired
//	private AuthorRepository authorRepo;
	
	@Override
	public BlogDto saveBlog(BlogDto blogDto) {
		
		
		blogDto.setCretedDateTime(LocalDateTime.now());
		blogDto.setLikeCount(0);
		blogDto.setCommentCount(0);
//		Author author=authorRepo.getById(blogDto.getAuthorId());
		
		Blog blog=repo.save(objectMapper.dtoToBlogConverter(blogDto));
		
		File file=new File("image");
		String path1=null;
	    if(file.isDirectory())
	    {
	    	try 
	    	{
				String path=file.getAbsolutePath();
				System.out.println("Current directory path = "+path);
				for(MultipartFile f1:blogDto.getMedia())
				{
					path1=path+"/"+f1.getOriginalFilename();
					FileInputStream fis=new FileInputStream(path1);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		
		return objectMapper.blogToDtoConverter(blog);
	}
	
	public  void storeImage()
	{
		
	}
	
////	write
//	String path = getServletContext().getRealPath("image");
//    MultipartRequest mpr = new MultipartRequest(req, path, 500 * 1024 * 1024);
//    String path1 = mpr.getOriginalFileName("img");
//    String path2 = path + "/" + path1;
//    FileInputStream fis = new FileInputStream(path2);
//
////    read
//    String path=request.getServletContext().getRealPath("/");
// 	InputStream f=rec.getBinaryStream("img");
//	FileOutputStream fout=new FileOutputStream(path+"\\"+"profile"+rec.getInt(1)+".png");
//	int i=0;
//    while((i=f.read())!=-1)
//    {
//        fout.write(i);
//    }
    
	
	@Override
	public BlogDto updateBlog(BlogDto blogDto, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteBlog(Long id) {
		return null;
		// TODO Auto-generated method stub
		
	}



	@Override
	public List<BlogDto> getBlog(String title) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<BlogDto> getBlog() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlogDto> getByAutherID(long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public BlogDto getBlog(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


}
