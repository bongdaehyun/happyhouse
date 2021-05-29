package com.ssafy.happyhouse.serivce;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.dto.NoticeDto;

public interface NoticeService {
	
	// 게시물 목록조회
	List<NoticeDto> listNotice();
	
	// 게시물 상세조회
	NoticeDto selectNotice(int number);
	
	// 게시물 등록
	boolean registerNotice(NoticeDto notice);
	
	// 게시물 삭제
	boolean deleteNotice(int number);
	
	// 게시물 수정
	boolean modifyNotice(NoticeDto notice);
	
	// 게시물 제목검색
	List<NoticeDto> selectTitle(String title);

	// 게시물 작성자검색
	List<NoticeDto> selectWriter(int author);

	
}
