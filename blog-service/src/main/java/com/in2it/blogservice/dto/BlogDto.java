package com.in2it.blogservice.dto;


import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BlogDto {
	
	
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
	@Override
	public String toString() {
		return "BlogDto [bId=" + bId + ", title=" + title + ", content=" + content + ", visiblity=" + visiblity
				+ ", commentCount=" + commentCount + ", likeCount=" + likeCount + ", media=" + media + ", postedBy="
				+ postedBy + ", cDateTime=" + cDateTime + ", dDateTime=" + dDateTime + "]";
	} 
	
}
