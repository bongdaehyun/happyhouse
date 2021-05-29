package com.ssafy.happyhouse.repo;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.dto.HousedealDto;

public interface ApartRepo {
	List<HousedealDto> selectDong(String dong) throws SQLException;
	List<HousedealDto> selectAptName(String AptName,String dong) throws SQLException;
	List<HousedealDto> selectBuildYear(String buildYear,String dong) throws SQLException;
}
