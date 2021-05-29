package com.ssafy.happyhouse.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.serivce.JwtService;
import com.ssafy.happyhouse.serivce.UserService;



@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/user")
public class UserRestController {
	@Autowired
	private UserService uService;
	
	@Autowired
	private JwtService jwtService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	
	/* 정보 수정창에서 수정 start */
	@PutMapping("{userid}")
	public ResponseEntity<String> modify(@RequestBody UserDto userDto) {
		logger.debug("modify - 호출");
		logger.debug("" + userDto);
		if(uService.modifyUser(userDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	/* 정보 수정창에서 수정 end */
	

	/* 유저 정보 가져오기 start */
	@GetMapping("{userid}")
	public ResponseEntity<UserDto> selectUser(@PathVariable String userid)  {
		logger.debug("selectUser - 호출");
		return new ResponseEntity<>(uService.selectUser(userid), HttpStatus.OK);
	}
	/* 유저 정보 가져오기 end */
	
	
	/* 유저 회원 등록 start */
	@PostMapping
	public ResponseEntity<String> register(@RequestBody UserDto userDto) {
		logger.debug("register - 호출");
		if(uService.register(userDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	/* 유저 회원 등록 end */
	
	/* login*/
	@PostMapping("/confirm/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody UserDto userDto, HttpServletResponse response, HttpSession session) {
		Map<String, Object> resultMap=new HashMap<>();
		HttpStatus status=null;
		try {
			UserDto loginUser=uService.login(userDto);
			if(loginUser!=null){
				//jwt.io에서 확인
				//로그인 성공했다면 토큰을 생성한다.
				String token=jwtService.create(loginUser);
				logger.trace("로그인 토큰정보 : {}", token);
				
				//토큰 정보는 response의 헤더로 보내고 나머지는 Map에 담는다.
				//response.setHeader("auth-token", token);
				resultMap.put("auth-token", token);
				resultMap.put("user-id", loginUser.getUserid());
				resultMap.put("user-name", loginUser.getUsername());
				resultMap.put("user-code", loginUser.getCode());
				//resultMap.put("status", true);
				//resultMap.put("data", loginUser);
				status=HttpStatus.ACCEPTED;
			}else{
				resultMap.put("message", "로그인 실패");
				status=HttpStatus.ACCEPTED;
			}
		}catch(Exception e){
			logger.error("로그인 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status=HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	/*정보 가져오기*/
	@GetMapping("/info")
	public ResponseEntity<Map<String, Object>> getInfo(HttpServletRequest req) {
		Map<String, Object> resultMap=new HashMap<>();
		HttpStatus status=HttpStatus.ACCEPTED;
		System.out.println(">>>>>> "+jwtService.get(req.getHeader("auth-token")));
		try {
			// 사용자에게 전달할 정보이다.
			//String info=memberService.getServerInfo();
			
			resultMap.putAll(jwtService.get(req.getHeader("auth-token")));

			//resultMap.put("status", true);
			//resultMap.put("info", info);
			status=HttpStatus.ACCEPTED;
		}catch(RuntimeException e){
			logger.error("정보조회 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status=HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	/* 회원 탈퇴 start */
	@DeleteMapping("{userid}")
	public ResponseEntity<String> secession(@PathVariable("userid") String userid) {
		logger.debug("secession - 호출");
		if(uService.secessionUser(userid)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	/* 회원 탈퇴 end */
	

}
