package com.in2it.blogservice.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Blog {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private long bId;
	private String title;
	private String content;
	private String visiblity;
	private int commentCount;
	private int likeCount;
	private String media;
	private String postedBy;
	private LocalDateTime cDateTime;
	private LocalDateTime dDateTime; 
	
	@Transient
	private List<Like> likes = new ArrayList<>();
	@Transient
	private List<Comment> comments = new ArrayList<>();
	@Override
	public String toString() {
		return "Blog [bId=" + bId + ", title=" + title + ", content=" + content + ", visiblity=" + visiblity
				+ ", commentCount=" + commentCount + ", likeCount=" + likeCount + ", media=" + media + ", postedBy="
				+ postedBy + ", cDateTime=" + cDateTime + ", dDateTime=" + dDateTime + "]";
	}


	



}
