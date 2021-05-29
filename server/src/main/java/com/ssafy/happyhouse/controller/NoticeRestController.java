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


import com.ssafy.happyhouse.dto.NoticeDto;
import com.ssafy.happyhouse.serivce.NoticeService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/notice")
public class NoticeRestController {
	private static final Logger logger = LoggerFactory.getLogger(NoticeRestController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private NoticeService noticeService;
	
	/* 모든 공지글의 정보를 반환 start */
	@GetMapping
	public ResponseEntity<List<NoticeDto>> listNotice() throws SQLException{
		logger.debug("listNotice - 호출");
		return new ResponseEntity<>(noticeService.listNotice(), HttpStatus.OK);
	}
	/* 모든 공지글의 정보를 반환 end */
	
	
	/* 해당 noticeid에 해당하는 글을 반환 start */
	@GetMapping("{noticeid}")
	public ResponseEntity<NoticeDto> searchNotice(@PathVariable int noticeid) throws SQLException {
		logger.debug("searchNotice - 호출");
		return new ResponseEntity<>(noticeService.selectNotice(noticeid), HttpStatus.OK);
	}
	/* 해당 noticeid에 해당하는 글을 반환 end */
	
	/* 새로운 공지 글을 작성 start */
	@PostMapping
	public ResponseEntity<String> registerNotice(@RequestBody NoticeDto noticeDto) {
		logger.debug("registerNotice - 호출");
		if(noticeService.registerNotice(noticeDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	/* 새로운 공지 글을 작성 end */
	
	/* 공지 글 수정 start */
	@PutMapping("{noticeid}")
	public ResponseEntity<String> modifyNotice(@RequestBody NoticeDto noticeDto) {
		logger.debug("modifyNotice - 호출");
		logger.debug("" + noticeDto);
		if(noticeService.modifyNotice(noticeDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	/* 공지 글 수정 start */
	
	/* 공지 글 삭제 start */
	@DeleteMapping("{noticeid}")
	public ResponseEntity<String> deleteNotice(@PathVariable("noticeid") int noticeid) {
		logger.debug("deleteNotice - 호출");
		if(noticeService.deleteNotice(noticeid)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	/* 공지 글 삭제 end */
}
