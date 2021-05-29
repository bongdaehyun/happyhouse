package com.ssafy.happyhouse.serivce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.aptreviewDto;
import com.ssafy.happyhouse.dto.reviewCountDto;
import com.ssafy.happyhouse.repo.reviewRepo;

@Service
public class reviewServiceImpl implements reviewService {
	
	@Autowired
	private reviewRepo repo;
	@Override
	public List<aptreviewDto> selectAll(String aptName) {
		return repo.selectAll(aptName);
	}
	@Override
	public List<reviewCountDto> selectWord() {
		return repo.selectWord();
	}
	@Override
	public List<aptreviewDto> searchAge(String age) {
		
		return repo.searchAge(age);
	}
}
