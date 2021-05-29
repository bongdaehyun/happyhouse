package com.ssafy.happyhouse.dto;

public class DongcodeDto {
	String city;
	String gugun;
	String dong;
	
	public DongcodeDto(String city, String gugun, String dong) {
		setCity(city);
		setDong(dong);
		
		setGugun(gugun);
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	
	
	
}
