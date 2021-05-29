package com.ssafy.happyhouse.serivce;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.dto.HousedealDto;
import com.ssafy.happyhouse.dto.QnaDto;
//아파트검색시 사용
public interface ApartService {
	List<HousedealDto> selectDong(String dong) throws SQLException;

//	List<HousedealDto> selectAptName(String AptName) throws SQLException;
//	List<HousedealDto> selectBuildYear(String buildYear) throws SQLException;

	List<HousedealDto> selectAptName(String AptName,String dong) throws SQLException;
	List<HousedealDto> selectBuildYear(String buildYear,String dong) throws SQLException;

}
