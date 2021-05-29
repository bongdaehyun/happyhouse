package com.ssafy.happyhouse.repo;

import java.sql.SQLException;

import com.ssafy.happyhouse.dto.UserDto;


public interface UserRepo {
//	회원가입
	int register(UserDto user);

//	로그인
	UserDto login(UserDto user);

//	회원정보 수정을 위한 회원의 모든 정보 얻기
	UserDto selectUser(String userid);

//	회원정보 수정
	int modifyUser(UserDto user);

//	회원탈퇴
	int secessionUser(String userid);
}
