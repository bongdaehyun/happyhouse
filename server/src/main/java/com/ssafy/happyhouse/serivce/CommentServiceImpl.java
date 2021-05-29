package com.ssafy.happyhouse.serivce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.CommentDto;
import com.ssafy.happyhouse.repo.CommentRepo;

@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentRepo cRepo;
	
	@Override
	public boolean create(CommentDto commentDto) {
		// TODO Auto-generated method stub
		return cRepo.create(commentDto)==1;
	}
	@Override
	public boolean delete(int commentNo) {
		// TODO Auto-generated method stub
		return cRepo.delete(commentNo)==1;
	}
	@Override
	public List<CommentDto> list(String qnaid) {
		// TODO Auto-generated method stub
		return cRepo.list(qnaid);
	}
	@Override
	public boolean modify(CommentDto commentDto) {
		// TODO Auto-generated method stub
		return cRepo.modify(commentDto)==1;
	}
}
