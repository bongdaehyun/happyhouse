package com.ssafy.happyhouse.serivce;

import java.util.List;

import com.ssafy.happyhouse.dto.CommentDto;

public interface CommentService {
	List<CommentDto> list(String qnaid);
	boolean create(CommentDto commentDto);
	boolean modify(CommentDto commentDto);
	boolean delete(int commentNo);	
}
