package com.in2it.blogservice.service.impl;

import java.time.LocalDateTime;
import java.util.List;

<<<<<<< HEAD

import com.in2it.blogservice.dto.BlogDto;

=======
import org.springframework.beans.factory.annotation.Autowired;

import com.in2it.blogservice.dto.BlogDto;
import com.in2it.blogservice.mapper.Converter;
import com.in2it.blogservice.model.Blog;
import com.in2it.blogservice.repository.BlogRepository;
>>>>>>> c316e027c69735a7ed61103b6276c986464207f1
import com.in2it.blogservice.service.BlogService;

public class BlogServiceImpl implements BlogService {

	@Autowired
	private Converter objectMapper;
	
	@Autowired
	private BlogRepository repo;
	
	@Override
	public BlogDto saveBlog(BlogDto blogDto) {
		
		blogDto.setCretedDateTime(LocalDateTime.now());
		Blog blog=repo.save(objectMapper.dtoToBlogConverter(blogDto));
		
		
		return objectMapper.blogToDtoConverter(blog);
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
	public List<BlogDto> getByAutherName(String auther) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public BlogDto getBlog(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

<<<<<<< HEAD

	
=======
	@Override
	public BlogDto getBlogByid(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

>>>>>>> c316e027c69735a7ed61103b6276c986464207f1
}
