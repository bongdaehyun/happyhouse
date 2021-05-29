package com.ssafy.happyhouse.serivce;


import java.util.List;

import com.ssafy.happyhouse.dto.QnaDto;

public interface QnaService {
	
	// 게시물 목록조회
	List<QnaDto> listQna();
	
	// 게시물 상세조회
	QnaDto selectQna(int number);
	
	// 게시물 등록
	boolean registerQna(QnaDto notice);
	
	// 게시물 삭제
	boolean deleteQna(int number);
	
	// 게시물 수정
	boolean modifyQna(QnaDto notice);
	
	// 게시물 제목검색
	List<QnaDto> selectTitle(String title);	
	
}
