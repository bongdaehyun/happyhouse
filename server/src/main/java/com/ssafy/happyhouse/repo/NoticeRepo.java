package com.ssafy.happyhouse.repo;


import java.util.List;

import com.ssafy.happyhouse.dto.NoticeDto;

public interface NoticeRepo {
	
	// 게시물 목록조회
	List<NoticeDto> listNotice();
	
	// 게시물 상세조회
	NoticeDto selectNotice(int noticeid);
	
	// 게시물 등록
	int registerNotice(NoticeDto noticeDto);
	
	// 게시물 삭제
	int deleteNotice(int noticeId);
	
	// 게시물 수정
	int modifyNotice(NoticeDto noticeDto);
	
	// 게시물 제목검색
	List<NoticeDto> selectTitle(String noticetitle);

	// 게시물 작성자검색
	List<NoticeDto> selectWriter(int noticewriter);

	
}
