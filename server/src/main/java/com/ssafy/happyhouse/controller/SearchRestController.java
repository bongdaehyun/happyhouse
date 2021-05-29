package com.ssafy.happyhouse.controller;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.DongcodeDto;
import com.ssafy.happyhouse.dto.HousedealDto;
import com.ssafy.happyhouse.dto.HouseinfoDto;
import com.ssafy.happyhouse.dto.QnaDto;
import com.ssafy.happyhouse.dto.SearchCondition;
import com.ssafy.happyhouse.serivce.ApartService;
import com.ssafy.happyhouse.serivce.DongService;
import com.ssafy.happyhouse.serivce.QnaService;

//검색시 사용되는 컨트롤러
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/search")
public class SearchRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchRestController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private ApartService aSv;
	@Autowired
	private DongService dSv;

	/* 아파트 별 검색 start */
	@GetMapping()
	public ResponseEntity<List<HousedealDto>> apartlist(SearchCondition condition) throws SQLException {
		logger.debug("listNotice - 호출");
		if(condition.getKey().equals("DONG")) {
			return new ResponseEntity<>(aSv.selectDong(condition.getDong()), HttpStatus.OK);
		}else if(condition.getKey().equals("BUILDYEAR")) {
			return new ResponseEntity<>(aSv.selectBuildYear(condition.getWord(),condition.getDong()), HttpStatus.OK);
		}else{
			return new ResponseEntity<>(aSv.selectAptName(condition.getWord(),condition.getDong()), HttpStatus.OK);
		}
	}
	 
	/* 아파트 별 검색 end */
	
	@GetMapping("/gugun")
	public ResponseEntity<?> getGugun(String city)throws SQLException{
		List<String> guguns=dSv.selectGugun(city);
		if(guguns!=null)return new ResponseEntity<List<String>>(guguns,HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/donglist")
	public ResponseEntity<?> getDong(String gugun)throws SQLException{
		List<String> dongs=dSv.selectDong(gugun);
		if(dongs!=null)return new ResponseEntity<List<String>>(dongs,HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	


}
