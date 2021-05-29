package com.ssafy.happyhouse.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.aptreviewDto;
import com.ssafy.happyhouse.dto.reviewCountDto;
import com.ssafy.happyhouse.serivce.reviewService;

@RestController
@CrossOrigin("*")
@RequestMapping("/review")
public class AptreviewRestController {
	@Autowired 
	private reviewService rSv;
	
	@GetMapping("list")
	public ResponseEntity<?> selectAll(String aptName) throws SQLException{
		return new ResponseEntity<List<aptreviewDto>>(rSv.selectAll(aptName), HttpStatus.OK);
	}
	
	@GetMapping("word")
	public ResponseEntity<?> selectWord() throws SQLException{
		return new ResponseEntity<List<reviewCountDto>>(rSv.selectWord(), HttpStatus.OK);
	}
	@GetMapping("age")
	public ResponseEntity<?> selectAge(String age) throws SQLException{
		return new ResponseEntity<List<aptreviewDto>>(rSv.searchAge(age), HttpStatus.OK);
	}
}
