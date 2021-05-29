package com.ssafy.happyhouse.repo;

import java.util.List;

import com.ssafy.happyhouse.dto.aptreviewDto;
import com.ssafy.happyhouse.dto.reviewCountDto;

public interface reviewRepo {
	List<aptreviewDto> selectAll(String aptName);
	List<reviewCountDto> selectWord();
	List<aptreviewDto> searchAge(String age);
}
