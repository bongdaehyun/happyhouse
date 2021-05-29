package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ssafy.happyhouse.dto.QnaDto;
import com.ssafy.happyhouse.dto.SearchCondition;
import com.ssafy.happyhouse.serivce.QnaService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/qna")
public class QnaRestController {
	private static final Logger logger = LoggerFactory.getLogger(QnaRestController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private QnaService qnaService;
	
	/* 모든 공지글의 정보를 반환 start */
	@GetMapping("/list")
	public ResponseEntity<List<QnaDto>> listQna() throws SQLException{
		logger.debug("listQna - 호출");
		return new ResponseEntity<>(qnaService.listQna(), HttpStatus.OK);
	}
	/* 모든 공지글의 정보를 반환 end */
	
	/* 검색된 공지글의 정보를 반환 start */
	@GetMapping("/title")
	public ResponseEntity<List<QnaDto>> searchQna(SearchCondition condition) throws SQLException{
		logger.debug("searchQna - 호출");
		logger.debug(condition.getWord());
		return new ResponseEntity<>(qnaService.selectTitle(condition.getWord()), HttpStatus.OK);
		//return new ResponseEntity<List<QnaDto>>(qnaService.selectTitle(condition.getWord()), HttpStatus.OK);
	}
	/* 검색된 공지글의 정보를 반환 end */
	
	/* 해당 qnaid에 해당하는 글을 반환 start */
	@GetMapping("{qnaid}")
	public ResponseEntity<QnaDto> selectQna(@PathVariable int qnaid) throws SQLException {
		logger.debug("searchQna - 호출");
		return new ResponseEntity<QnaDto>(qnaService.selectQna(qnaid), HttpStatus.OK);
	}
	/* 해당 qnaid에 해당하는 글을 반환 end */
	
	/* 새로운 공지 글을 작성 start */
	@PostMapping
	public ResponseEntity<String> registerQna(@RequestBody QnaDto qnaDto) {
		logger.debug("registerQna - 호출");
		if(qnaService.registerQna(qnaDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	/* 새로운 공지 글을 작성 end */
	
	/* 공지 글 수정 start */
	@PutMapping("{qnaid}")
	public ResponseEntity<String> modifyQna(@RequestBody QnaDto qnaDto) {
		logger.debug("modifyQna - 호출");
		logger.debug("" + qnaDto);
		if(qnaService.modifyQna(qnaDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	/* 공지 글 수정 start */
	
	/* 공지 글 삭제 start */
	@DeleteMapping("{qnaid}")
	public ResponseEntity<String> deleteQna(@PathVariable("qnaid") int qnaid) {
		logger.debug("deleteQna - 호출");
		if(qnaService.deleteQna(qnaid)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	/* 공지 글 삭제 end */ 
}
