package com.ssafy.happyhouse.serivce;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	@Autowired 
	private UserRepo repo;
	
	@Override
	public boolean register(UserDto user) {
		return repo.register(user)==1;
	}

	@Override
	public UserDto login(UserDto user) {
		return repo.login(user);
	}

	@Override
	public UserDto selectUser(String userid) {
		return repo.selectUser(userid);
	}

	@Override
	public boolean modifyUser(UserDto user) {
		return repo.modifyUser(user)==1;
	}

	@Override
	public boolean secessionUser(String userid){
		return repo.secessionUser(userid)==1;
	}

}
