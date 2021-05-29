package com.ssafy.happyhouse.serivce;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.dto.DongcodeDto;
import com.ssafy.happyhouse.dto.HousedealDto;

public interface DongService {
	List<String> selectGugun(String city) throws SQLException;
	List<String> selectDong(String gugun) throws SQLException;
}
