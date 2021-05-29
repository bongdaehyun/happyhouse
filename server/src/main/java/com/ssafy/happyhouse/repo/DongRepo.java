package com.ssafy.happyhouse.repo;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.dto.DongcodeDto;


public interface DongRepo {
	
	List<String> selectGugun(String city) throws SQLException;
	List<String> selectDong(String gugun) throws SQLException;
}
