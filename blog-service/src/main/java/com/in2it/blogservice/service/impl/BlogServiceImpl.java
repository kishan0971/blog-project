package com.in2it.blogservice.service.impl;

<<<<<<< HEAD
=======
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
>>>>>>> 6a656c08de5666159a6db4dbd599f361efc67e17
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.http.HttpStatus;
=======
import org.springframework.web.multipart.MultipartFile;
>>>>>>> 6a656c08de5666159a6db4dbd599f361efc67e17

import com.in2it.blogservice.customException.IdInvalidException;
import com.in2it.blogservice.customException.UserNotFoundException;
import com.in2it.blogservice.dto.BlogDto;
import com.in2it.blogservice.mapper.Converter;
import com.in2it.blogservice.model.Author;
import com.in2it.blogservice.model.Blog;
import com.in2it.blogservice.repository.AuthorRepository;
import com.in2it.blogservice.repository.BlogRepository;
import com.in2it.blogservice.service.BlogService;

public class BlogServiceImpl implements BlogService {

	@Autowired
	private Converter objectMapper;

	@Autowired
	private BlogRepository repo;
//	@Autowired
//	private AuthorRepository authorRepo;
	
	@Autowired
	private AuthorRepository authRepo;

	@Override
	public BlogDto saveBlog(BlogDto blogDto) {

		blogDto.setCretedDateTime(LocalDateTime.now());
<<<<<<< HEAD
		Blog blog = repo.save(objectMapper.dtoToBlogConverter(blogDto));

=======
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
		
>>>>>>> 6a656c08de5666159a6db4dbd599f361efc67e17
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

	}

	@Override
	public List<BlogDto> getBlog(String title) {

		List<Blog> blog = repo.findByTitle(title);

		List<BlogDto> blogDtoList = new ArrayList<>();

		for (Blog blog2 : blog) {

			if (blog2 != null) {
				BlogDto blogToDtoConverter = objectMapper.blogToDtoConverter(blog2);
				blogDtoList.add(blogToDtoConverter);
			} else {
				throw new UserNotFoundException(
						HttpStatus.NO_CONTENT + "Content not avelable, please ! Try again.");
			}
		}

		return blogDtoList;
	}

	@Override
	public List<BlogDto> getBlog() {
		
		List<Blog> blog = repo.findAll();

		List<BlogDto> blogDtoList = new ArrayList<>();

		for (Blog blog2 : blog) {

			if (blog2 != null) {
				BlogDto blogToDtoConverter = objectMapper.blogToDtoConverter(blog2);
				blogDtoList.add(blogToDtoConverter);
			} else {
				throw new UserNotFoundException(
						HttpStatus.NO_CONTENT + "Content not avelable, please ! Try again.");
			}
		}

		return blogDtoList;
	}

	@Override
<<<<<<< HEAD
	public List<BlogDto> getByAutherName(String auther) {
//		
//	    List<Author> byFirstName = authRepo.findByFirstName(auther);
//		
//		List<BlogDto> blogDtoList=new  ArrayList<>();
//		
//		
//		
//		for (Author auth : byFirstName) {
//			
//			auth.getId()
//		}
//		
////		for (Blog blog2 : blog) {
////			
////			if(blog2!=null) {
////				BlogDto blogToDtoConverter = objectMapper.blogToDtoConverter(blog2);
////				blogDtoList.add(blogToDtoConverter);
////			}
////			else {
////				throw new UserNotFoundException(HttpStatus.NO_CONTENT + "Content not avelable, please ! Try again.");
////			}
////		}
//	
=======
	public List<BlogDto> getByAutherID(long id) {
		// TODO Auto-generated method stub
>>>>>>> 6a656c08de5666159a6db4dbd599f361efc67e17
		return null;
	}

	@Override
	public BlogDto getBlog(Long id) {

		Blog blog = repo.findById(id).orElseThrow(() -> new IdInvalidException("Please ! correct id ."));
		if (blog != null) {
			BlogDto blogDto = objectMapper.blogToDtoConverter(blog);
			return blogDto;
		} else {
			throw new UserNotFoundException(
					HttpStatus.NO_CONTENT + "Content not avelable, please ! Try again.");
		}
	}
	
	
	

}
