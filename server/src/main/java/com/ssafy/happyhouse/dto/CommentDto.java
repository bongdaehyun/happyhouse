package com.ssafy.happyhouse.dto;

import java.util.Date;

public class CommentDto {
	private int comment_no;
	private String name;
	private String comment;
	private Date comment_time;
	private String qnaid;
	
	
	public CommentDto(int comment_no, String name, String comment, String qnaid) {
		this.comment_no = comment_no;
		this.name = name;
		this.comment = comment;
		this.qnaid = qnaid;
	}
	public int getComment_no() {
		return comment_no;
	}
	public void setComment_no(int comment_no) {
		this.comment_no = comment_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public Date getComment_time() {
		return comment_time;
	}
	public void setComment_time(Date comment_time) {
		this.comment_time = comment_time;
	}
	public String getQnaid() {
		return qnaid;
	}
	public void setQnaid(String qnaid) {
		this.qnaid = qnaid;
	}
	
	
}
