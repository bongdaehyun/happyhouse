package com.ssafy.happyhouse.dto;

public class BaseaddressDto {
	int no;
	String city;
	String code;
	String dongcode;
	String gugun;
	String dong;
	String lat;
	String lng;
	
	public BaseaddressDto(int no, String city, String code, String dongcode, String gugun, String dong, String lat,
			String lng) {
		
		setCity(city);
		setCode(dongcode);
		setDong(dong);
		setDongcode(dongcode);
		setGugun(gugun);
		setLat(lat);
		setLng(lng);
		setNo(no);
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDongcode() {
		return dongcode;
	}
	public void setDongcode(String dongcode) {
		this.dongcode = dongcode;
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
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("baseaddress [no=").append(no).append(", city=").append(city).append(", code=").append(code)
				.append(", dongcode=").append(dongcode).append(", gugun=").append(gugun).append(", dong=").append(dong)
				.append(", lat=").append(lat).append(", lng=").append(lng).append("]");
		return builder.toString();
	}

	
	
	
}
