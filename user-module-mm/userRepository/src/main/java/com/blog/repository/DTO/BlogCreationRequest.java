package com.blog.repository.DTO;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class BlogCreationRequest {

    private String title;
    private String content;
    private long teamId;
    private long departmentId;
    
    private List<MultipartFile> media;// Base64 encoded files

    public String getTitle() {
        return title;
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
		return "BlogCreationRequest [title=" + title + ", content=" + content + ", teamId=" + teamId + ", departmentId="
				+ departmentId + ", media=" + media + "]";
	}

	
    
    
}
