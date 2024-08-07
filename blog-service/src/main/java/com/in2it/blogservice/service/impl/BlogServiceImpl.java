package com.in2it.blogservice.service.impl;

<<<<<<< HEAD
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
=======
>>>>>>> c4e4e9173a64ca1834c01a85800ccc820f548de7
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in2it.blogservice.customException.IdInvalidException;
<<<<<<< HEAD
=======
import com.in2it.blogservice.customException.InfoMissingException;
>>>>>>> c4e4e9173a64ca1834c01a85800ccc820f548de7
import com.in2it.blogservice.customException.UserNotFoundException;
import com.in2it.blogservice.dto.BlogDto;
import com.in2it.blogservice.mapper.Converter;
import com.in2it.blogservice.model.Blog;
import com.in2it.blogservice.repository.BlogRepository;
import com.in2it.blogservice.service.BlogService;

<<<<<<< HEAD
@Service
@Component
=======
import jakarta.transaction.Transactional;

@Service
@Component
@Transactional
>>>>>>> c4e4e9173a64ca1834c01a85800ccc820f548de7
public class BlogServiceImpl implements BlogService {

	@Autowired
	private Converter objectMapper;

	@Autowired
	private BlogRepository repo;
//	@Autowired
//	private AuthorRepository authorRepo;
	
<<<<<<< HEAD


	@Override
	public BlogDto saveBlog(BlogDto blogDto,MultipartFile img) {

		

//		blogDto.setLikeCount(0);
//		blogDto.setCommentCount(0);
//		Author author=authorRepo.getById(blogDto.getAuthorId());
		
//		Blog save = repo.save(objectMapper.dtoToBlogConverter(blogDto));
		
		File file=new File("image");
		String path1=null;
		if(!file.isDirectory())
		{
			try {
				FileInputStream fis=new FileInputStream(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    if(file.isDirectory())
	    {
	    	try 
	    	{
				String path=file.getAbsolutePath();
//				for(MultipartFile f1:blogDto.getMedia())
//				{
//					path1=path+"/"+f1.getOriginalFilename();
//					FileInputStream fis=new FileInputStream(path1);
//				}
				path1=path+"/"+img.getOriginalFilename();
				img.transferTo(new File(path1));
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

		Blog blog = repo.save(objectMapper.dtoToBlogConverter(blogDto,img,path1));
		
		return objectMapper.blogToDtoConverter(blog);
	}
=======
	
	public BlogDto saveBlogWithFile(BlogDto blogDto, MultipartFile multipartFile) {
		Blog blog=null;
		if(!multipartFile.isEmpty() && blogDto!=null) {
			
			String uploadFilePath = objectMapper.uploadFile(multipartFile);
			String originalFilename = multipartFile.getOriginalFilename();
			
			Blog dtoToBlogConverter = objectMapper.dtoToBlogConverter(blogDto, originalFilename, uploadFilePath);
			
			String uriString = ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(multipartFile.getOriginalFilename()).toUriString();
			dtoToBlogConverter.setMediaPath(uriString);
			
		    blog= repo.save(dtoToBlogConverter);
		}
	
		 return objectMapper.blogToDtoConverter(blog);
		
	}
	
>>>>>>> c4e4e9173a64ca1834c01a85800ccc820f548de7

	@Override
	public BlogDto updateBlog(BlogDto blogDto, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteBlog(Long id) {
<<<<<<< HEAD
		return null;

	}

	@Override
=======
		
		if(id>0) {
		 repo.deleteBlogById(id);

		return	true;
		}
		else {
		
			throw new IdInvalidException(HttpStatus.NO_CONTENT  + "id not found, Please ! enter correct id.");
		}
		

	}


	@Override
	public Boolean deleteBlogByTitle(String title) {
		
		if(title!=null) {
			repo.deleteBytitle(title);
			return	true;
		}
		else {
			
			throw new InfoMissingException(HttpStatus.NO_CONTENT  + " Data not found, Please ! try again .");
		}
	}
	
	@Override
>>>>>>> c4e4e9173a64ca1834c01a85800ccc820f548de7
	public List<BlogDto> getBlogTitle(String title) {

		List<Blog> blog = repo.findByTitle(title);

		List<BlogDto> blogDtoList = new ArrayList<>();

		for (Blog blog2 : blog) {

			if (blog2 != null) {
				BlogDto blogToDtoConverter = objectMapper.blogToDtoConverter(blog2);
<<<<<<< HEAD
				blogDtoList.add(blogToDtoConverter);
			} else {
				throw new UserNotFoundException(
						HttpStatus.NO_CONTENT + "Content not avelable, please ! Try again.");
=======
				
				blogDtoList.add(blogToDtoConverter);
			} else {
				throw new UserNotFoundException(
						HttpStatus.NO_CONTENT + " Data not available, please ! Try again.");
>>>>>>> c4e4e9173a64ca1834c01a85800ccc820f548de7
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
<<<<<<< HEAD
				blogDtoList.add(blogToDtoConverter);
			} else {
				throw new UserNotFoundException(
						HttpStatus.NO_CONTENT + "Content not avelable, please ! Try again.");
=======
				
				blogDtoList.add(blogToDtoConverter);
			} else {
				throw new UserNotFoundException(
						HttpStatus.NO_CONTENT + " Data not available, please ! Try again.");
>>>>>>> c4e4e9173a64ca1834c01a85800ccc820f548de7
			}
		}

		return blogDtoList;
	}



	public List<BlogDto> getByAutherID(long id) {
		
		List<Blog> byAuthorId = repo.findByAuthorId(id);
		
		List<BlogDto> blogDtoList = new ArrayList<>();

		for (Blog blog2 : byAuthorId) {

			if (blog2 != null) {
				BlogDto blogToDtoConverter = objectMapper.blogToDtoConverter(blog2);
				blogDtoList.add(blogToDtoConverter);
			} else {
				throw new UserNotFoundException(
<<<<<<< HEAD
						HttpStatus.NO_CONTENT + "Content not available, please ! Try again.");
=======
						HttpStatus.NO_CONTENT + "  Data not available, please ! Try again.");
>>>>>>> c4e4e9173a64ca1834c01a85800ccc820f548de7
			}
		}
		
		return blogDtoList;
	}

	@Override
	public BlogDto getBlogById(Long id) {

<<<<<<< HEAD
		Blog blog = repo.findById(id).orElseThrow(() -> new IdInvalidException("Please ! correct id ."));
=======
		
		Blog blog = repo.getByBlogId(id);
>>>>>>> c4e4e9173a64ca1834c01a85800ccc820f548de7
		if (blog != null) {
			BlogDto blogDto = objectMapper.blogToDtoConverter(blog);
			return blogDto;
		} else {
			throw new UserNotFoundException(
<<<<<<< HEAD
					HttpStatus.NO_CONTENT + "Content not avelable, please ! Try again.");
=======
					HttpStatus.NO_CONTENT + "   Data not available, please ! Try again.");
>>>>>>> c4e4e9173a64ca1834c01a85800ccc820f548de7
		}
	}

	
	
	
	



	
	
	

}
