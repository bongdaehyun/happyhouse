package com.ssafy.happyhouse.serivce;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.DongcodeDto;
import com.ssafy.happyhouse.dto.HousedealDto;
import com.ssafy.happyhouse.repo.DongRepo;

@Service
public class DongServiceImpl implements DongService{
	@Autowired
	private DongRepo dDao;

	@Override
	public List<String> selectGugun(String city) throws SQLException {
		return dDao.selectGugun(city);
	}

	@Override
	public List<String> selectDong(String gugun) throws SQLException {
		return dDao.selectDong(gugun);
	}
	
}
