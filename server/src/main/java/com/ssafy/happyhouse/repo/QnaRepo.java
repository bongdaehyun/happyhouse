package com.ssafy.happyhouse.repo;


import java.util.List;

import com.ssafy.happyhouse.dto.QnaDto;

public interface QnaRepo {
	
	// 게시물 목록조회
	List<QnaDto> listQna();
	
	// 게시물 상세조회
	QnaDto selectQna(int qnaid);
	
	// 게시물 등록
	int registerQna(QnaDto qnaDto);
	
	// 게시물 삭제
	int deleteQna(int qnaId);
	
	// 게시물 수정
	int modifyQna(QnaDto qnaDto);
	
	// 게시물 제목 검색
	List<QnaDto> selectTitle(String qnatitle);	
}
