package com.ssafy.happyhouse.repo;

import java.util.List;

import com.ssafy.happyhouse.dto.CommentDto;

public interface CommentRepo {
	List<CommentDto> list(String qnaid);
	int create(CommentDto commentDto);
	int modify(CommentDto commentDto);
	int delete(int commentNo);	
}
