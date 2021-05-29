package com.ssafy.happyhouse.serivce;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.DongcodeDto;
import com.ssafy.happyhouse.dto.myArea;
import com.ssafy.happyhouse.repo.AreaApartRepo;
@Service
public class myareaServiceImpl implements myareaService{
	@Autowired
	private AreaApartRepo arepo;
	@Override
	public String getAreacode(String city, String gugun, String dong) throws SQLException {
		return arepo.getAreacode(city, gugun, dong);
	}
	@Override
	public List<myArea> selectarea(String dongcode) throws SQLException {
		
		return arepo.selectarea(dongcode);
	}
	@Override
	public boolean updateArea(String code, String userid) throws SQLException {
		return arepo.updateArea(code, userid) ==1;
		
	}
	@Override
	public String getdong(String code) throws SQLException {
		
		return arepo.getdong(code);
	}
	@Override
	public DongcodeDto getCode(String code) throws SQLException {
		return arepo.getCode(code);
	}
}
