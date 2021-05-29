package com.ssafy.happyhouse.dto;

public class GuguncodeDto {
	String gugun_code;
	String gugun_name;
	public GuguncodeDto(String gugun_code, String gugun_name) {
		setGugun_code(gugun_code);
		setGugun_name(gugun_name);
	}
	public String getGugun_code() {
		return gugun_code;
	}
	public void setGugun_code(String gugun_code) {
		this.gugun_code = gugun_code;
	}
	public String getGugun_name() {
		return gugun_name;
	}
	public void setGugun_name(String gugun_name) {
		this.gugun_name = gugun_name;
	}
	
	
}
