package com.ssafy.happyhouse.dto;

import java.util.Date;

public class QnaDto {
	private int qnaid;
	private String qnatitle;
	private String qnacontent;
	private String qnawriter;
	private Date date;
	
	
	
	
	/**
	 * @param qnaid
	 * @param qnatitle
	 * @param qnacontent
	 * @param date
	 */
	public QnaDto(int qnaid, String qnatitle, String qnacontent) {
		super();
		this.qnaid = qnaid;
		this.qnatitle = qnatitle;
		this.qnacontent = qnacontent;
	}
	
	public QnaDto(int qnaid, String qnatitle, String qnacontent, String qnawriter, Date date) {
		this.qnaid = qnaid;
		this.qnatitle = qnatitle;
		this.qnacontent = qnacontent;
		this.qnawriter = qnawriter;
	}

	public String getQnawriter() {
		return qnawriter;
	}

	public void setQnawriter(String qnawriter) {
		this.qnawriter = qnawriter;
	}

	public QnaDto() {
		
	}

	
	public int getQnaid() {
		return qnaid;
	}

	public void setQnaid(int qnaid) {
		this.qnaid = qnaid;
	}

	public String getQnatitle() {
		return qnatitle;
	}

	public void setQnatitle(String qnatitle) {
		this.qnatitle = qnatitle;
	}

	public String getQnacontent() {
		return qnacontent;
	}

	public void setQnacontent(String qnacontent) {
		this.qnacontent = qnacontent;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "QnaDto [qnaid=" + qnaid + ", qnatitle=" + qnatitle + ", qnacontent=" + qnacontent + ", date=" + date
				+ "]";
	}
	
	
}
