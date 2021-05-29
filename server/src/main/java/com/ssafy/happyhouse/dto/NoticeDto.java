package com.ssafy.happyhouse.dto;

import java.util.Date;

public class NoticeDto {
	private int noticeid;
	private String noticetitle;
	private String noticecontent;
	private String noticewriter;
	private Date date;
	
	
	public NoticeDto() {
		
	}

	public NoticeDto(int noticeid, String noticetitle, String noticecontent, String noticewriter) {
		this.noticeid = noticeid;
		this.noticetitle = noticetitle;
		this.noticecontent = noticecontent;
		this.noticewriter = noticewriter;
		
	}
	
	
	public String getNoticewriter() {
		return noticewriter;
	}

	public void setNoticewriter(String noticewriter) {
		this.noticewriter = noticewriter;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getNoticeid() {
		return noticeid;
	}

	public void setNoticeid(int noticeid) {
		this.noticeid = noticeid;
	}

	public String getNoticetitle() {
		return noticetitle;
	}

	public void setNoticetitle(String noticetitle) {
		this.noticetitle = noticetitle;
	}

	public String getNoticecontent() {
		return noticecontent;
	}

	public void setNoticecontent(String noticecontent) {
		this.noticecontent = noticecontent;
	}



}
