package com.ssafy.happyhouse.serivce;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.HousedealDto;
import com.ssafy.happyhouse.repo.ApartRepo;

@Service
public class ApartServiceImpl implements ApartService {
	@Autowired
	private ApartRepo aDao;
	
	@Override
	public List<HousedealDto> selectDong(String dong) throws SQLException {
		return aDao.selectDong(dong);
	}

	@Override
	public List<HousedealDto> selectAptName(String AptName,String dong) throws SQLException {
		
		return aDao.selectAptName(AptName,dong);
	}

	@Override
	public List<HousedealDto> selectBuildYear(String buildYear,String dong) throws SQLException {
		return aDao.selectBuildYear(buildYear,dong);
	}

	

}
