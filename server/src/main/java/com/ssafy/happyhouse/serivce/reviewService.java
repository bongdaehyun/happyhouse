package com.ssafy.happyhouse.serivce;

import java.util.List;

import com.ssafy.happyhouse.dto.aptreviewDto;
import com.ssafy.happyhouse.dto.reviewCountDto;

public interface reviewService {
	List<aptreviewDto> selectAll(String aptName);
	List<reviewCountDto> selectWord();
	List<aptreviewDto> searchAge(String age);
}
