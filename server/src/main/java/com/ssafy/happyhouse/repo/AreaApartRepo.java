package com.ssafy.happyhouse.repo;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.dto.DongcodeDto;
import com.ssafy.happyhouse.dto.myArea;

public interface AreaApartRepo {
	List<myArea> selectarea(String dongcode)throws SQLException;
	String getAreacode(String city,String gugun, String dong) throws SQLException;
	int updateArea(String code,String userid)throws SQLException;
	String getdong(String code)throws SQLException;
	DongcodeDto getCode(String code)throws SQLException;
}
