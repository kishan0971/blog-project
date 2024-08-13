package com.blog.repository.DTO;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Component
public class BlogCreationFeignClient {

//    private Long userId;
    private String authorId;
    private String title;
    private String content;
    private long teamId;
    private long departmentId;
    private List<MultipartFile> media;

//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }



    public String getTitle() {
        return title;
    }

    public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


 

	public long getTeamId() {
		return teamId;
	}

	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public List<MultipartFile> getMedia() {
		return media;
	}

	public void setMedia(List<MultipartFile> media) {
		this.media = media;
	}

	@Override
	public String toString() {
		return "BlogCreationFeignClient [authorId=" + authorId + ", title=" + title + ", content=" + content
				+ ", teamId=" + teamId + ", departmentId=" + departmentId + ", media=" + media + "]";
	}




    
    
}
