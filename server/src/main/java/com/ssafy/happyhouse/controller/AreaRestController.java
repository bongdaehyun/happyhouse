package com.ssafy.happyhouse.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.DongcodeDto;
import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.dto.myArea;
import com.ssafy.happyhouse.serivce.myareaService;

@RestController
@CrossOrigin("*")
@RequestMapping("/myapi")
public class AreaRestController {
	
	@Autowired
	private myareaService aSv;
	
	@GetMapping("/code")
	public ResponseEntity<String> getDongcode(String city,String gugun, String dong) throws SQLException{
		return new ResponseEntity<>(aSv.getAreacode(city, gugun, dong), HttpStatus.OK);
	}
	
	@PutMapping("{userid}")
	public ResponseEntity<String> updateArea(String code,@PathVariable String userid) throws SQLException {
		
		if(aSv.updateArea(code, userid)) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}
		return new ResponseEntity<String>("fail", HttpStatus.NO_CONTENT);
	}
	
	@GetMapping
	public ResponseEntity<?> getCode(String code) throws SQLException{
		return new ResponseEntity<DongcodeDto>(aSv.getCode(code), HttpStatus.OK);
	}
}

